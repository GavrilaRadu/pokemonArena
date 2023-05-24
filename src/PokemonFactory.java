public class PokemonFactory {
    private static PokemonFactory instantaUnica;

    private PokemonFactory(){

    }

    public static PokemonFactory instanta(){
        if(instantaUnica == null)
            instantaUnica = new PokemonFactory();
        return instantaUnica;
    }

    public Pokemon createPokemon(String name, String item1, String item2, String item3){
        Pokemon pokemon;
        switch(name){
            case "Neutrel1":
                pokemon = new PokemonBuilder()
                        .withName("Neutrel1")
                        .withHp(10)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(1)
                        .withSpecialDef(1)
                        .withAbility1(null)
                        .withAbility2(null)
                        .build();
                break;
            case "Neutrel2":
                pokemon = new PokemonBuilder()
                        .withName("Neutrel2")
                        .withHp(20)
                        .withAttack(4)
                        .withSpecialAttack(0)
                        .withDef(1)
                        .withSpecialDef(1)
                        .withAbility1(null)
                        .withAbility2(null)
                        .build();
                break;
            case "Pikachu":
                pokemon = new PokemonBuilder()
                        .withName("Pikachu")
                        .withHp(35)
                        .withAttack(0)
                        .withSpecialAttack(4)
                        .withDef(2)
                        .withSpecialDef(3)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(6)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(4)
                                .withStun(true)
                                .withDodge(true)
                                .withCooldown(5)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Bulbasaur":
                pokemon = new PokemonBuilder()
                        .withName("Bulbasaur")
                        .withHp(42)
                        .withAttack(0)
                        .withSpecialAttack(5)
                        .withDef(3)
                        .withSpecialDef(1)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(6)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(5)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(3)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Charmander":
                pokemon = new PokemonBuilder()
                        .withName("Charmander")
                        .withHp(50)
                        .withAttack(4)
                        .withSpecialAttack(0)
                        .withDef(3)
                        .withSpecialDef(2)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(4)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(7)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(6)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Squirtle":
                pokemon = new PokemonBuilder()
                        .withName("Squirtle")
                        .withHp(60)
                        .withAttack(0)
                        .withSpecialAttack(3)
                        .withDef(5)
                        .withSpecialDef(5)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(4)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(3)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(2)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(2)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Snorlax":
                pokemon = new PokemonBuilder()
                        .withName("Snorlax")
                        .withHp(62)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(6)
                        .withSpecialDef(4)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(4)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(5)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(0)
                                .withStun(false)
                                .withDodge(true)
                                .withCooldown(5)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Vulpix":
                pokemon = new PokemonBuilder()
                        .withName("Vulpix")
                        .withHp(36)
                        .withAttack(5)
                        .withSpecialAttack(0)
                        .withDef(2)
                        .withSpecialDef(4)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(8)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(6)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(2)
                                .withStun(false)
                                .withDodge(true)
                                .withCooldown(7)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Eevee":
                pokemon = new PokemonBuilder()
                        .withName("Eevee")
                        .withHp(39)
                        .withAttack(0)
                        .withSpecialAttack(4)
                        .withDef(3)
                        .withSpecialDef(3)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(5)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(3)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(3)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(3)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Jigglypuff":
                pokemon = new PokemonBuilder()
                        .withName("Jigglypuff")
                        .withHp(34)
                        .withAttack(4)
                        .withSpecialAttack(0)
                        .withDef(2)
                        .withSpecialDef(3)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(4)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(3)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Meowth":
                pokemon = new PokemonBuilder()
                        .withName("Meowth")
                        .withHp(41)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(4)
                        .withSpecialDef(2)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(5)
                                .withStun(false)
                                .withDodge(true)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(1)
                                .withStun(false)
                                .withDodge(true)
                                .withCooldown(3)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            case "Psyduck":
                pokemon = new PokemonBuilder()
                        .withName("Psyduck")
                        .withHp(43)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(3)
                        .withSpecialDef(3)
                        .withAbility1(new AbilityBuilder()
                                .withDamage(2)
                                .withStun(false)
                                .withDodge(false)
                                .withCooldown(4)
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDamage(2)
                                .withStun(true)
                                .withDodge(false)
                                .withCooldown(5)
                                .build())
                        .addItems(item1, item2, item3)
                        .build();
                break;
            default:
                pokemon = null;
        }
        return pokemon;
    }
}
