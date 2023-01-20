package MonstersGame;

public abstract class Monster {
    public enum MonsterList {
        VAMPIRE("VAMPIRE"), MUMMY("MUMMY"), WEREWOLF("WEREWOLF");

        public String name;
        private MonsterList(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    MonsterList typeOfMonster;
    private int damage;
    private int health;
    private boolean isAlive = true;

    public Monster(MonsterList typeOfMonster, int damage, int health) {
        this.typeOfMonster = typeOfMonster;
        this.damage = damage;
        this.health = health;
    }

    public int attack() {
        return this.damage;
    }

    public void  defend() {
        this.health -= attack();
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void loseHealth(int hitPoints) {
        this.health -= hitPoints;
    }
    public void recoverHealth(int hitPoints) {
        this.health += hitPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "typeOfMonster=" + typeOfMonster +
                ", damage=" + damage +
                ", health=" + health +
                '}';
    }
}
