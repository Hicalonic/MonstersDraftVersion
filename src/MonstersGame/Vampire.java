package MonstersGame;

public class Vampire extends Monster {

    private static final MonsterList VAMPIRE = MonsterList.VAMPIRE;
    private int healthRecover = 10;
    public Vampire() {
        super(VAMPIRE, 15, 80);
    }


    @Override
    public void attack(Monster defender) {
        if (biteProbability()) {
            defender.loseHealth(this.getDamage());
            System.out.println("Vampire successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.getHealth());
            recoverHealth(healthRecover);
            System.out.println("Vampire has bitten " + defender.typeOfMonster + " and recovered " + healthRecover + " HP! Leaving himself with " + this.getHealth());
            System.out.println("--".repeat(30));
        }
        defender.loseHealth(this.getDamage());
        System.out.println("Vampire successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.getHealth());
        System.out.println("--".repeat(30));
    }

    private boolean biteProbability(){
        if (RandomNumber.randomNumber(1, 3) == 3) {
            return true;
        }
        return false;
    }
}
