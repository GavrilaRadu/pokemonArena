public class ItemBuilder {
    Item item;

    ItemBuilder(){
        item = new Item();
    }

    public Item build(){
        return item;
    }

    public ItemBuilder withName(String name){
        item.setName(name);
        return this;
    }
    public ItemBuilder withHp(int hp){
        item.setHp(hp);
        return this;
    }
    public ItemBuilder withAttack(int attack){
        item.setAttack(attack);
        return this;
    }
    public ItemBuilder withSpecialAttack(int specialAttack){
        item.setsAttack(specialAttack);
        return this;
    }
    public ItemBuilder withDef(int def){
        item.setDef(def);
        return this;
    }
    public ItemBuilder withSpecialDef(int specialDef){
        item.setsDef(specialDef);
        return this;
    }
}
