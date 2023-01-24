package MonstersGame;

public class Witch extends Supernatural implements Strikeable{
    private int health;
    public Witch() {
        super();
        this.damage = 20;
        this.health = 100;
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



    }
}
