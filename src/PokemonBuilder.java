public class PokemonBuilder {
    Pokemon pokemon;

    PokemonBuilder(){
        pokemon = new Pokemon();
    }

    public Pokemon build(){
        return pokemon;
    }

    public PokemonBuilder withName(String name){
        pokemon.setName(name);
        return this;
    }
    public PokemonBuilder withHp(int hp){
        pokemon.setHp(hp);
        return this;
    }
    public PokemonBuilder withAttack(int attack){
        pokemon.setAttack(attack);
        return this;
    }
    public PokemonBuilder withSpecialAttack(int specialAttack){
        pokemon.setsAttack(specialAttack);
        return this;
    }
    public PokemonBuilder withDef(int def){
        pokemon.setDef(def);
        return this;
    }
    public PokemonBuilder withSpecialDef(int specialDef){
        pokemon.setsDef(specialDef);
        return this;
    }
    public PokemonBuilder withAbility1(Ability ability){
        pokemon.setAbility1(ability);
        return this;
    }
    public PokemonBuilder withAbility2(Ability ability){
        pokemon.setAbility2(ability);
        return this;
    }

    public PokemonBuilder addItems(String item1, String item2, String item3){
        ItemFactory itemFactory = ItemFactory.instanta();
        pokemon.addItem(itemFactory.createItem(item1));
        pokemon.addItem(itemFactory.createItem(item2));
        pokemon.addItem(itemFactory.createItem(item3));
        return this;
    }
}
