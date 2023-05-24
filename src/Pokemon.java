import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int sAttack;
    private int def;
    private int sDef;
    private Ability ability1;
    private Ability ability2;
    private ArrayList<Item> items;

    public Pokemon(){
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getsAttack() {
        return sAttack;
    }
    public int getDef() {
        return def;
    }
    public int getsDef() {
        return sDef;
    }
    public Ability getAbility1() {
        return ability1;
    }
    public Ability getAbility2() {
        return ability2;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }
    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setsAttack(int sAttack) {
        this.sAttack = sAttack;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setsDef(int sDef) {
        this.sDef = sDef;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }

    public void incStats(){
        hp++;
        if(attack != 0)
            attack++;
        else
            sAttack++;
        def++;
        sDef++;
    }
}
