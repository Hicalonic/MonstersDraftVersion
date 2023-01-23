package MonstersGame;


import java.util.Arrays;

public class Player {
    private String name;
    public Monster[] playerCards;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPlayerCards(Monster[] newDeck) {
        this.playerCards = newDeck;
    }

    public void showHand(){
        for (int i = 0; i < playerCards.length; i++) {
        System.out.println(this.playerCards[i].toString());
        }
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
    public int randomNumberToPickCard () {

        return (int) Math.floor(Math.random() * (3) + 1);
    }

    public  int chooseHandSize(){
        return (int) Math.floor(Math.random() * 3 + 2);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerCards=" + Arrays.toString(playerCards) +
                '}';
    }
}


