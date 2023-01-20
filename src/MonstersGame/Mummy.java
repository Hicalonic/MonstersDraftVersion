package MonstersGame;

public class Mummy extends Monster {

    private int attackCounter;
    private  int thirdAttackPenalty = 10;
    private static final MonsterList MUMMY = MonsterList.MUMMY;


    public Mummy() {
        super(MUMMY, 10, 100);
        this.attackCounter = attackCounter;
    }

    @Override
    public int attack() {
        if (this.attackCounter > 2) {
            thirdAttack();
        }
        setDamage(10);
        attackCounter++;
        return super.attack();
    }

    private void thirdAttack(){
        loseHealth(thirdAttackPenalty);
        setDamage(0);
        this.attackCounter = 0;
    }

}
