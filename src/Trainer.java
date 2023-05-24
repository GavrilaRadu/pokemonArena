import java.util.ArrayList;

public class Trainer {
    private String name;
    private int age;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name, int age, ArrayList<Pokemon> pokemons) {
        this.name = name;
        this.age = age;
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void updatePokemons(){
        for(Pokemon pokemon : pokemons){
            ArrayList<Item> items = pokemon.getItems();
            for(Item item : items){
                if(pokemon.getAttack() != 0)
                    pokemon.setAttack(pokemon.getAttack() + item.getAttack());
                if(pokemon.getsAttack() != 0)
                    pokemon.setsAttack(pokemon.getsAttack() + item.getsAttack());
                if(pokemon.getDef() != 0)
                    pokemon.setDef(pokemon.getDef() + item.getDef());
                if(pokemon.getsDef() != 0)
                    pokemon.setsDef(pokemon.getsDef() + item.getsDef());
                if(pokemon.getHp() != 0)
                    pokemon.setHp(pokemon.getHp() + item.getHp());
            }
        }
    }
}
