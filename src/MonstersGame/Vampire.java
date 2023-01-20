package MonstersGame;

public class Vampire extends Monster {

    private static final MonsterList VAMPIRE = MonsterList.VAMPIRE;
    private int healthRecover = 10;
    public Vampire() {
        super(VAMPIRE, 15, 80);
    }

    @Override
    public int attack() {
        if (biteProbability()) {
            recoverHealth(healthRecover);
        }
        return super.attack();
    }


    private boolean biteProbability(){
        if ((int) (Math.random() * 3 + 1) == 3) {
            return true;
        }
        return false;
    }
}
