package MonstersGame;

public abstract class Monster extends Supernatural implements Strikeable{


    MonsterList typeOfMonster;
    protected int health;

    private boolean isAlive = true;


    public Monster(MonsterList typeOfMonster, int health) {
        super();
        this.typeOfMonster = typeOfMonster;
        this.health = health;

    }

    public abstract void attack(Monster monster);

    public boolean isAlive() {
        return isAlive;
    }

    public void loseHealth(int hitPoints) {
        health -= hitPoints;
        if(health <= 0)
            health = 0;
    }
    public void recoverHealth(int hitPoints) {
        health += hitPoints;
    }


    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Monster -->" +
                typeOfMonster +
                " *health* [" + health +
                "] **isAlive** [" + isAlive +
                "]";
    }
}
