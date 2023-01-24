package MonstersGame;

public class Witch extends Supernatural implements Strikeable{
    private int health;
    private boolean isAlive;
    private String name;
    public Witch() {
        super();
        this.damage = 20;
        this.health = 100;
        this.name = "Witch";
        this.isAlive = true;
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public void loseHealth(int hitPoints) {
        health -= (hitPoints / 2);
        if(health <= 0)
            health = 0;
            this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
