import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class Arena {
    private Trainer trainer1;
    private Trainer trainer2;
    private Pokemon neutrel1;
    private Pokemon neutrel2;

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    private int cd1a1, cd1a2, cd2a1, cd2a2;
    boolean stuned1, stuned2, giveStun1, giveStun2;
    boolean dodge1, dodge2;

    BufferedWriter bw;

    Arena(int testNumber) {
        Reader r = new Reader();
        neutrel1 = r.readPokemon("Neutrel1", null, null, null);
        neutrel2 = r.readPokemon("Neutrel2", null, null, null);
        trainer1 = r.readTrainer(testNumber, 1);
        trainer2 = r.readTrainer(testNumber, 2);

        try {
            bw = new BufferedWriter(new FileWriter("tests/output/test" + testNumber + ".txt", true));
        } catch (IOException e) {
            System.out.println("ABORT!");
        }
    }

    public void start(){
        Random rand = new Random();
        while(true) {
            switch (rand.nextInt(3)) {
                case 0:
                    fightNeutrel(1);
                    break;
                case 1:
                    fightNeutrel(2);
                    break;
                case 2:
                    fightTrainer();
                    try {
                        bw.close();
                    } catch (IOException e) {
                        System.err.println("ABORT!");
                    }
                    executor.shutdown();
                    return;
            }
        }
    }

    private void fightNeutrel(int neutrelNumber) {
        Pokemon neutrel;
        if(neutrelNumber == 1)
            neutrel = neutrel1;
        else
            neutrel = neutrel2;

        for (Pokemon pokemon : trainer1.getPokemons())
            fightAndPrint(pokemon, neutrel, 1);
        for (Pokemon pokemon : trainer2.getPokemons())
            fightAndPrint(pokemon, neutrel, 2);
    }

    private void fightTrainer() {
        int max1 = -1, max2 = -1, imax1 = -1, imax2 = -1, aux;
        String nameMax1 = null, nameMax2 = null;
        for(int i = 0; i < trainer1.getPokemons().size(); i++) {
            Pokemon pokemon = trainer1.getPokemons().get(i);
            aux = pokemon.getAttack() + pokemon.getsAttack() + pokemon.getDef() + pokemon.getsDef() + pokemon.getHp();
            if(max1 < aux){
                max1 = aux;
                nameMax1 = pokemon.getName();
                imax1 = i;
            }
            else {
                if(max1 == aux)
                    if(nameMax1.compareTo(pokemon.getName()) > 0){
                        nameMax1 = pokemon.getName();
                        imax1 = i;
                    }
            }

            Pokemon enemyPokemon = trainer2.getPokemons().get(i);
            aux = enemyPokemon.getAttack() + enemyPokemon.getsAttack() + enemyPokemon.getDef() + enemyPokemon.getsDef() + enemyPokemon.getHp();
            if(max2 < aux){
                max2 = aux;
                nameMax2 = pokemon.getName();
                imax2 = i;
            }
            else {
                if(max2 == aux)
                    if(nameMax2.compareTo(enemyPokemon.getName()) > 0){
                        nameMax2 = enemyPokemon.getName();
                        imax2 = i;
                    }
            }
            fightAndPrint(pokemon, enemyPokemon, 3);
        }
        Pokemon pokemon = trainer1.getPokemons().get(imax1);
        Pokemon enemyPokemon = trainer2.getPokemons().get(imax2);
        fightAndPrint(pokemon, enemyPokemon, 3);
    }

    private int fightPokemons(Pokemon pokemon, Pokemon enemyPokemon) {
        cd1a1 = 0;
        cd1a2 = 0;
        cd2a1 = 0;
        cd2a2 = 0;
        stuned1 = false;
        stuned2 = false;
        giveStun1 = false;
        giveStun2 = false;
        dodge1 = false;
        dodge2 = false;
        int hp1 = pokemon.getHp();
        int hp2 = enemyPokemon.getHp();
        int cpHp1 = 0;
        int cpHp2 = 0;

        if (enemyPokemon.getAbility1() == null)
            cd2a1 = -1;

        while (hp1 > 0 && hp2 > 0) {
            int finalHp1 = hp1;
            Callable<Integer> battle1 = () -> battle(enemyPokemon, pokemon, finalHp1, 2);

            int finalHp2 = hp2;
            Callable<Integer> battle2 = () -> battle(pokemon, enemyPokemon, finalHp2, 1);

            Future<Integer> cpcpHp1 = executor.submit(battle1);
            Future<Integer> cpcpHp2 = executor.submit(battle2);

            try {
                cpHp1 = cpcpHp1.get();
                cpHp2 = cpcpHp2.get();
            } catch (ExecutionException e) {
                System.err.println("ABORT!");
            } catch (InterruptedException e) {
                System.err.println("ABORT!");
            }

            //cpHp1 = battle(enemyPokemon, pokemon, hp1, 2);
            //cpHp2 = battle(pokemon, enemyPokemon, hp2, 1);

            if(!dodge1){
                hp1 = cpHp1;

                print("-> Rezultat:\n\t" + pokemon.getName() + ": HP " + hp1);

                if(giveStun2){
                    print(" si este stuned");
                    stuned1 = true;
                    giveStun2 = false;
                }
            }
            else {
                print("-> Rezultat:\n\t" + pokemon.getName() + ": HP " + hp1 + " (dodge)");
            }
            if(cd1a1 > 0)
                print(", abilitate 1 cooldown " + cd1a1);
            if(cd1a2 > 0)
                print(", abilitate 2 cooldown " + cd1a2);
            print("\n");

            if(!dodge2){
                hp2 = cpHp2;

                print("\t" + enemyPokemon.getName() + ": HP " + hp2);

                if(giveStun1){
                    print(" si este stuned");
                    stuned2 = true;
                    giveStun1 = false;
                }
            }
            else {
                print("\t" + enemyPokemon.getName() + ": HP " + hp2 + " (dodge)");
            }
            if(cd2a1 > 0)
                print(", abilitate 1 cooldown " + cd2a1);
            if(cd2a2 > 0)
                print(", abilitate 2 cooldown " + cd2a2);
            print("\n");
        }
        if(hp1 > 0)
            return 0;
        if(hp2 > 0)
            return 1;
        return 2;
    }

    private int battle(Pokemon pokemon, Pokemon enemyPokemon, int hp, int whichPokemon) {
        Random rand = new Random();
        int cpHp;
        int cd1, cd2;
        boolean giveStun = false, dodge = false, stuned;
        int ok = 0;
        if(whichPokemon == 1) {
            cd1 = cd1a1;
            cd2 = cd1a2;
            stuned = stuned1;
        }
        else{
            cd1 = cd2a1;
            cd2 = cd2a2;
            stuned = stuned2;
        }

        if(stuned){
            print(pokemon.getName() + " nimic ");
            if(cd1 > 0)
                cd1--;
            if(cd2 > 0)
                cd2--;
            if(whichPokemon == 1) {
                stuned1 = false;
                cd1a1 = cd1;
                cd1a2 = cd2;
            }
            else {
                stuned2 = false;
                cd2a1 = cd1;
                cd2a2 = cd2;
            }
            return hp;
        }

        switch (rand.nextInt(findGenerator(whichPokemon))) {
            case 0:
                cpHp = normalAttack(pokemon, enemyPokemon, hp);
                break;
            case 1:
                if (cd1 == 0) {
                    Ability ability = pokemon.getAbility1();
                    cpHp = hp - ability.getDamage();
                    cd1 = ability.getCooldown();
                    ok = 1;
                    print(pokemon.getName() + " abilitate 1 ");
                    giveStun = ability.getStun();
                    dodge = ability.getDodge();
                    break;
                }
            case 2:
                if (cd2 == 0) {
                    Ability ability = pokemon.getAbility2();
                    cpHp = hp - ability.getDamage();
                    cd2 = ability.getCooldown();
                    ok = 2;
                    print(pokemon.getName() + " abilitate 2 ");
                    giveStun = ability.getStun();
                    dodge = ability.getDodge();
                    break;
                }
            default:
                cpHp = -1;
                print("FAIL!");
        }

        if(ok == 0){
            if(cd1 > 0)
                cd1--;
            if(cd2 > 0)
                cd2--;
        }
        if(ok == 1){
            if(cd2 > 0)
                cd2--;
        }
        if(ok == 2){
            if(cd1 > 0)
                cd1--;
        }
        if(whichPokemon == 1){
            cd1a1 = cd1;
            cd1a2 = cd2;
            giveStun1 = giveStun;
            dodge1 = dodge;
        }
        else{
            cd2a1 = cd1;
            cd2a2 = cd2;
            giveStun2 = giveStun;
            dodge2 = dodge;
        }
        return cpHp;
    }

    private int normalAttack (Pokemon attacker, Pokemon attacked, int currHp){
        if(attacker.getAttack() != 0)
            print(attacker.getName() + " atac normal ");
        else
            print(attacker.getName() + " atac special ");

        if (attacker.getAttack() > attacked.getDef())
            return currHp - attacker.getAttack() + attacked.getDef();
        else if (attacker.getsAttack() > attacked.getsDef())
            return currHp - attacker.getsAttack() + attacked.getsDef();
        return currHp;
    }

    private int findGenerator(int whichPokemon){
        if(whichPokemon == 1) {
            if(cd1a1 == -1)
                return 1;
            if (cd1a1 != 0 && cd1a2 != 0)
                return 1;
            else {
                if (cd1a1 != 0 || cd1a2 != 0)
                    return 2;
                else
                    return 3;
            }
        }
        else {
            if(cd2a1 == -1)
                return 1;
            if (cd2a1 != 0 && cd2a2 != 0)
                return 1;
            else {
                if (cd2a1 != 0 || cd2a2 != 0)
                    return 2;
                else
                    return 3;
            }
        }
    }

    private void fightAndPrint(Pokemon pokemon, Pokemon enemyPokemon, int trainerNumber){
        int secondTrainer = 0;
        if(trainerNumber == 3) {
            trainerNumber = 1;
            secondTrainer = 1;
        }
        int rez = fightPokemons(pokemon, enemyPokemon);

        switch(rez){
            case 0:
                print("Antrenorul " + trainerNumber + " (" + pokemon.getName() + ") castiga ");
                if(secondTrainer == 0)
                    print("Lupta.\n");
                else
                    print("Arena, invingand pe celalalt jucator.\n");
                print(pokemon.getName() + " are acum +1 la toate caracteristicile.\n");
                pokemon.incStats();
                printAtributes(pokemon);
                break;
            case 1:
                if(secondTrainer == 0) {
                    print("Antrenorul " + trainerNumber + " (" + pokemon.getName() + ") a pierdut lupta.\n");
                    printAtributes(pokemon);
                }
                else {
                    trainerNumber++;
                    print("Antrenorul " + trainerNumber + " (" + enemyPokemon.getName() + ") castiga Arena, invingand pe celalalt jucator.\n");
                    print(enemyPokemon.getName() + " are acum +1 la toate caracteristicile.\n");
                    enemyPokemon.incStats();
                    printAtributes(enemyPokemon);
                }
                break;
            case 2:
                print("Cei doi antrenori au facut egalitate.\n");
                printAtributes(pokemon);
                printAtributes(enemyPokemon);
        }
    }

    private void printAtributes(Pokemon pokemon) {
        print("Atribute " + pokemon.getName() + ": HP " + pokemon.getHp() + ", ");
        if(pokemon.getAttack() != 0)
            print("Attack " + pokemon.getAttack() + ", Defense " + pokemon.getDef() + ", Special Defence " + pokemon.getsDef() + "\n\n");
        else
            print("Special Attack " + pokemon.getsAttack() + ", Defense " + pokemon.getDef() + ", Special Defence " + pokemon.getsDef() + "\n\n");
    }

    private void print(String str){
        System.out.print(str);
        try {
            bw.write(str);
        } catch (IOException e) {
            System.err.println("ABORT!");
        }
    }
}
