package MonstersGame;


import java.util.Arrays;

public class Player {
    private String name;
    private Monster[] playerCards;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void showHand(){
        System.out.println(this.getName() +  "'s hand");
        for (int i = 0; i < playerCards.length; i++) {
        System.out.println(this.playerCards[i].toString());
        }
        System.out.println("-".repeat(50));
    }

    public void initializePlayersHand(int numberOfMonsters){
        this.playerCards = new Monster[numberOfMonsters];
        getCards();
    }

    public void getCards() {
        for (int i = 0; i < this.playerCards.length; i++) {
            this.playerCards[i] = monsterAttribution();
        }
    }

    private Monster monsterAttribution () {
        return switch (pickCard()) {
            case VAMPIRE:
                yield new Vampire();
            case MUMMY:
                yield new Mummy();
            case WEREWOLF:
                yield new Werewolf();
        };
    }
    private Monster.MonsterList pickCard () {
        switch (RandomNumber.randomNumber(1, 3)) {
            case 1:
                return Monster.MonsterList.VAMPIRE;
            case 2:
                return Monster.MonsterList.MUMMY;
            case 3:
                return Monster.MonsterList.WEREWOLF;
            default:
                return null;
        }
    }

    public  int chooseHandSize(){
        return RandomNumber.randomNumber(2, 5);
    }

    public Monster[] getPlayerCards() {
        return playerCards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerCards=" + Arrays.toString(playerCards) +
                '}';
    }
}


