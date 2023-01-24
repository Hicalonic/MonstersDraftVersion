package MonstersGame;

public class Vampire extends Monster {

    private static final MonsterList VAMPIRE = MonsterList.VAMPIRE;
    private int healthRecover = 10;
    public Vampire() {
        super(VAMPIRE, VAMPIRE.getHealth());
        this.damage = VAMPIRE.getDamage();
    }

    @Override
    public void attack(Monster defender) {
        if (biteProbability()) {
            defender.loseHealth(this.getDamage());
            System.out.println("Vampire successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.health);
            recoverHealth(healthRecover);
            System.out.println("Vampire has bitten " + defender.typeOfMonster + " and recovered " + healthRecover + " HP! Leaving himself with " + this.health);
            System.out.println("--".repeat(30));
        }
        defender.loseHealth(this.getDamage());
        System.out.println("Vampire successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.health);
        System.out.println("--".repeat(30));
    }

    private boolean biteProbability(){
        if (RandomNumber.randomNumber(1, 3) == 3) {
            return true;
        }
        return false;
    }
}
