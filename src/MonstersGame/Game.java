package MonstersGame;

public class Game {
    public Player attacker, defender;
    private Witch witch;
    private Fairy fairy;
    private int numberOfMonsters;

    public Game(Player p1, Player p2) {
        this.attacker = p1;
        this.defender = p2;
        this.numberOfMonsters = 0;
        this.witch = new Witch();
        this.fairy = new Fairy();
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public void setNumberOfMonsters(int numberOfMonsters) {
        this.numberOfMonsters = numberOfMonsters;
    }

    public void verifyHandSize() {
        int p1HandSize = attacker.chooseHandSize();
        int p2HandSize = defender.chooseHandSize();
        System.out.println("Player 1 chose to play with " + p1HandSize + " monsters!");
        System.out.println("Player 2 chose to play with " + p2HandSize + " monsters!");
        if (p1HandSize != p2HandSize) {
            verifyHandSize();
        } else {
            setNumberOfMonsters(p1HandSize);
            attacker.initializePlayersHand(getNumberOfMonsters());
            defender.initializePlayersHand(getNumberOfMonsters());
        }
    }

    public void updateMonsterState(Player player) {
        for (int i = 0; i < player.getPlayerCards().length; i++) {
            if (player.getPlayerCards()[i].health <= 0) {
                player.getPlayerCards()[i].setAlive(false);
            }
        }
    }

    public boolean allMonsterDead(Player player){
        for (Monster playerCard : player.getPlayerCards()) {
            if(playerCard.isAlive()== true)
                return false;
        }
        return true;
    }

    public void play() {

        randomizeFirstPlayer();
        while (allMonsterDead(this.attacker) == false && allMonsterDead(this.defender) == false) {
            pickCardToFight(this.attacker).attack(pickCardToFight(this.defender));
            updateMonsterState(this.defender);
            attacker.showHand();
            defender.showHand();
            generateObstacle(defender);
            updateMonsterState(this.defender);
            swapPlayers();
        }
        if (allMonsterDead(this.attacker) == true)
            System.out.println(this.defender.getName() + " won this game!");
        else System.out.println(this.attacker.getName() + " won this game!");
    }

    private void randomizeFirstPlayer() {
        if(RandomNumber.randomNumber(1, 2) == 1){
            swapPlayers();
        }
    }

    private void swapPlayers() {
        Player swap=this.defender;
        this.defender= this.attacker;
        this.attacker= swap;
    }

    private Monster pickCardToFight(Player p) {
        int monsterIndex = (int) (Math.random() * (p.getPlayerCards().length));
        while(!p.getPlayerCards()[monsterIndex].isAlive()){
            monsterIndex = (int) (Math.random() * (p.getPlayerCards().length));
        }
        return p.getPlayerCards()[monsterIndex];
    }
    private void generateObstacle(Player player) {
        if (allMonsterDead(player) == false) {
            Monster luckyMonster = pickCardToFight(player);
            switch (RandomNumber.randomNumber(1, 6)) {
                case 1:
                    if (witch.isAlive()) {
                        pickCardToFight(player).loseHealth(witch.damage);
                        System.out.println(witch.getName() + " attacked " + luckyMonster.typeOfMonster + " leaving him with " + luckyMonster.health + " HP.");
                    }
                        break;
                case 2:
                    pickCardToFight(player).loseHealth(fairy.damage);
                    System.out.println(fairy.getName() + " attacked " + luckyMonster.typeOfMonster + " leaving him with " + luckyMonster.health + " HP.");
                    break;
                case 3:
                    if (witch.isAlive()) {
                        witch.loseHealth(pickCardToFight(player).damage);
                        System.out.println(luckyMonster.typeOfMonster + " attacked " + witch.getName() + " leaving her with" + witch.getHealth() + " HP");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}