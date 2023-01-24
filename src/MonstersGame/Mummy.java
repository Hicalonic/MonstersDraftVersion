package MonstersGame;

public class Mummy extends Monster {

    private int attackCounter;
    private  int thirdAttackPenalty = 10;
    private static final MonsterList MUMMY = MonsterList.MUMMY;


    public Mummy() {
        super(MUMMY, MUMMY.getHealth());
        this.attackCounter = attackCounter;
        this.damage = MUMMY.getDamage();
    }


    @Override
    public void attack(Monster defender) {
        switch (attackCounter) {
            case 2:
                loseHealth(thirdAttackPenalty);
                if (health <= 0) {
                    setAlive(false);
                }
                attackCounter = 0;
                System.out.println("Mummy missed attack, lost 10 HP leaving her with " + this.health);
                System.out.println("--".repeat(30));
                break;
            default:
                defender.loseHealth(this.getDamage());
                attackCounter++;
                System.out.println("Mummy successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.health);
                System.out.println("--".repeat(30));
                break;
        }
    }
}
