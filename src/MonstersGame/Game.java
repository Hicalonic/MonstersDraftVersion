package MonstersGame;

public class Game {
    public Player attacker, defender;
    public Monster pickedCard;
    private int numberOfMonsters;
    private boolean gotWinner;

    public Game(Player p1, Player p2) {
        this.attacker = p1;
        this.defender = p2;
        this.gotWinner = false;
        this.numberOfMonsters = 0;
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
        System.out.println("Player 1 choose to play with " + p1HandSize + " monsters!");
        System.out.println("Player 2 choose to play with " + p2HandSize + " monsters!");
        if (p1HandSize != p2HandSize) {
            verifyHandSize();
        } else {
            setNumberOfMonsters(p1HandSize);
            attacker.initializePlayersHand(getNumberOfMonsters());
            defender.initializePlayersHand(getNumberOfMonsters());
        }
    }

    public void updateMonsterState(Player player) {
        for (int i = 0; i < player.playerCards.length; i++) {
            if (player.playerCards[i].getHealth() <= 0) {
                player.playerCards[i].setAlive(false);
            }
        }
    }

    public boolean allMonsterDead(Player player){
        for (Monster playerCard : player.playerCards) {
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

            swapPlayers();
        }
        checkWinner(this.attacker);
        checkWinner(this.defender);
    }

    private void randomizeFirstPlayer() {
        if(chooseFirstPlayer() == 1){
            swapPlayers();
        }
    }

    private void swapPlayers() {
        Player swap=this.defender;
        this.defender= this.attacker;
        this.attacker= swap;
    }

    private boolean checkWinner(Player player) {
        for (int i = 0; i < player.playerCards.length; i++) {
            if (player.playerCards[i].isAlive() == true) {
                return gotWinner;
            }
        }
        return gotWinner = true;
    }
    public int chooseFirstPlayer() {
        return (int) Math.floor(Math.random() * (2) + 1);
    }

    private Monster pickCardToFight(Player p) {
        int monsterIndex = (int) (Math.random() * (p.playerCards.length));
//        for (Monster playerCard : p.playerCards) {
//            if (playerCard.isAlive() == true) {
//                if (p.playerCards[monsterIndex - 1].isAlive() == true) {
//                }
//            }
//        }
//        System.out.println(p.playerCards[monsterIndex-1].typeOfMonster + " Is still Alive");
//        return p.playerCards[monsterIndex - 1];

        while(!p.playerCards[monsterIndex].isAlive()){
            monsterIndex = (int) (Math.random() * (p.playerCards.length));
        }


        return p.playerCards[monsterIndex];
    }
}





















