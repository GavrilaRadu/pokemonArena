public class ItemFactory {
    private static ItemFactory instantaUnica;

    private ItemFactory(){

    }

    public static ItemFactory instanta(){
        if(instantaUnica == null)
            instantaUnica = new ItemFactory();
        return instantaUnica;
    }

    public Item createItem(String name){
        Item item;

        switch(name){
            case "Scut":
                item = new ItemBuilder()
                        .withName("Scut")
                        .withHp(0)
                        .withAttack(0)
                        .withSpecialAttack(0)
                        .withDef(2)
                        .withSpecialDef(2)
                        .build();
                break;
            case "Vesta":
                item = new ItemBuilder()
                        .withName("Vesta")
                        .withHp(10)
                        .withAttack(0)
                        .withSpecialAttack(0)
                        .withDef(0)
                        .withSpecialDef(0)
                        .build();
                break;
            case "Sabiuta":
                item = new ItemBuilder()
                        .withName("Sabiuta")
                        .withHp(0)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(0)
                        .withSpecialDef(0)
                        .build();
                break;
            case "Bagheta Magica":
                item = new ItemBuilder()
                        .withName("Bagheta Magica")
                        .withHp(0)
                        .withAttack(0)
                        .withSpecialAttack(3)
                        .withDef(0)
                        .withSpecialDef(0)
                        .build();
                break;
            case "Vitamine":
                item = new ItemBuilder()
                        .withName("Vitamine")
                        .withHp(2)
                        .withAttack(2)
                        .withSpecialAttack(2)
                        .withDef(0)
                        .withSpecialDef(0)
                        .build();
                break;
            case "Brad de Craciun":
                item = new ItemBuilder()
                        .withName("Brad de Craciun")
                        .withHp(0)
                        .withAttack(3)
                        .withSpecialAttack(0)
                        .withDef(1)
                        .withSpecialDef(0)
                        .build();
                break;
            case "Pelerina":
                item = new ItemBuilder()
                        .withName("Pelerina")
                        .withHp(0)
                        .withAttack(0)
                        .withSpecialAttack(0)
                        .withDef(0)
                        .withSpecialDef(3)
                        .build();
                break;
            default:
                item = null;
        }
        return item;
    }
}
