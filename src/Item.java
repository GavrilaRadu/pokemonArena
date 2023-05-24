public class Item {
    private String name;
    private int hp;
    private int attack;
    private int sAttack;
    private int def;
    private int sDef;

    public Item(){
    }
    public Item(String name, int hp, int attack, int sAttack, int def, int sDef) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.sAttack = sAttack;
        this.def = def;
        this.sDef = sDef;
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

    public void setName(String name) {
        this.name = name;
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
}
