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
    public void attack(Monster defender) {
        if(attackCounter > 2) {
            loseHealth(thirdAttackPenalty);
            attackCounter = 0;
            System.out.println("Mummy missed attack, lost 10 HP leaving her with " + this.getHealth());
            System.out.println("--".repeat(30));
        }
        defender.loseHealth(this.getDamage());
        attackCounter++;
        System.out.println("Mummy successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.getHealth());
        System.out.println("--".repeat(30));
    }
}
