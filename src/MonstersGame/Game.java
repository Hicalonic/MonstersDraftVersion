package MonstersGame;

public class Game {
    public Player p1, p2;
    public Monster monster;
    private int numberOfMonsters;
    private int numOfMonstersAlive;
    private boolean gotWinner = false;

    public Game() {
        this.p1 = new Player("player1");
        this.p2 = new Player("player2");
    }


    public void verifyHandSize(){
        int p1HandSize = p1.chooseHandSize();
        int p2HandSize = p2.chooseHandSize();
        if (p1HandSize != p2HandSize) {
            verifyHandSize();
        } else {
           this.numberOfMonsters = p1HandSize;
           p1.initializePlayersHand(this.numberOfMonsters);
           p2.initializePlayersHand(this.numberOfMonsters);
        }
    }

    public void die(Player p) {
        numOfMonstersAlive = 2;

        for (int i = 0; i < numOfMonstersAlive; i++) {
            if (p.playerCards[i].getHealth() < 1) {
                p.playerCards[numOfMonstersAlive] = p.playerCards[i];
                p.playerCards[numOfMonstersAlive] = null;
//                numOfMonstersAlive--;
            }
        }
    }

//    public void runGame() {
//            p1Choice = p1.playerChoice();
//            p2Choice = p2.playerChoice();
//            play();

    public void play() {
        while (gotWinner == false) {
            if (checkWinner())
            break;
            if (chooseFirstPlayer() == 1) {
                pickCardToFight(p1).attack();
                System.out.println(pickCardToFight(p1).typeOfMonster + " " + pickCardToFight(p1).getHealth());
                pickCardToFight(p2).defend();
                System.out.println(pickCardToFight(p2).typeOfMonster + " " + pickCardToFight(p2).getHealth());
            } else {
                pickCardToFight(p2).attack();
                System.out.println(pickCardToFight(p2).typeOfMonster + " " + pickCardToFight(p2).getHealth());
                pickCardToFight(p1).defend();
                System.out.println(pickCardToFight(p1).typeOfMonster + " " + pickCardToFight(p1).getHealth());
            }
        }
    }

    private boolean checkWinner(){
        if (p1.playerCards[0] == null) {
            System.out.println(p2.getName() + " wins");
            gotWinner = true;
        }
        if (p2.playerCards[0] == null) {
            System.out.println(p1.getName() + " wins");
            gotWinner = true;
        }
        return gotWinner;
    }
    public int chooseFirstPlayer() {
        return (int) Math.floor(Math.random() * (2) + 1);
    }

    private Monster pickCardToFight(Player p){
        die(p);
        int monsterIndex = (int) Math.ceil(Math.random() * (this.numOfMonstersAlive));
        return p.playerCards[monsterIndex - 1];
    }

}
