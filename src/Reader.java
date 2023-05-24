import java.io.*;
import java.util.ArrayList;

public class Reader {
    PokemonFactory pokemonFactory = PokemonFactory.instanta();

    public Reader(){

    }

    public Trainer readTrainer(int testNumber, int trainerNumber){
        if(trainerNumber != 1 && trainerNumber != 2){
            System.out.println("Trainer number not valid!");
            return null;
        }
        String fName = new String();
        if(trainerNumber == 1)
            fName = "tests/input/test" + testNumber + "_antrenor1.txt";

        if(trainerNumber == 2)
            fName = "tests/input/test" + testNumber + "_antrenor2.txt";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fName));
        } catch (FileNotFoundException e) {
            System.err.println("ABORT!");
        }

        String name = null;
        int age = -1;
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String st;
        String[] split;
        try {
            while ((st = br.readLine()) != null) {
                String[] buff = st.split("\n");
                split = buff[0].split(", ");
                if (age == -1) {
                    name = split[0];
                    age = Integer.parseInt(split[1]);
                    continue;
                }
                pokemons.add(readPokemon(split[0], split[1], split[2], split[3]));
            }
        } catch (IOException e) {
            System.err.println("ABORT!");
        }
        if(name == null)
            return null;
        Trainer trainer = new Trainer(name, age, pokemons);
        trainer.updatePokemons();
        return trainer;
    }

    public Pokemon readPokemon(String name, String item1, String item2, String item3){
        return pokemonFactory.createPokemon(name, item1, item2, item3);
    }
}
