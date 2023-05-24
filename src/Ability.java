public class Ability {
    private int damage;
    private boolean stun;
    private boolean dodge;
    private int cooldown;

    public Ability(){
    }

    public Ability(int damage, boolean stun, boolean dodge, int cooldown) {
        this.damage = damage;
        this.stun = stun;
        this.dodge = dodge;
        this.cooldown = cooldown;
    }

    public int getDamage() {
        return damage;
    }
    public boolean getStun() {
        return stun;
    }
    public boolean getDodge() {
        return dodge;
    }
    public int getCooldown() {
        return cooldown;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setStun(boolean stun) {
        this.stun = stun;
    }
    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
