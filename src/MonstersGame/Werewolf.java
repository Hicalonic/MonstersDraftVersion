package MonstersGame;

public class Werewolf extends Monster {

    private static final MonsterList WEREWOLF = MonsterList.WEREWOLF;

    public Werewolf() {
        super(WEREWOLF, WEREWOLF.getHealth());
        this.damage = WEREWOLF.getDamage();
    }

    @Override
    public void attack(Monster defender) {
        defender.loseHealth(this.getDamage());
        System.out.println("Werewolf successfully attacked " + defender.typeOfMonster + " dealing " + this.getDamage() + " leaving him with " + defender.health);
        System.out.println("--".repeat(30));
    }
}
