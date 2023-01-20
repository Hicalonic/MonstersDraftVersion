package MonstersGame;



public class Player {
    private String name;
    public Monster[] playerCards;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void showHand(){
        for (int i = 0; i < playerCards.length; i++) {
        System.out.println(this.playerCards[i].toString());
        }
    }

    public void getCards() {
        for (int i = 0; i < this.playerCards.length; i++) {
            this.playerCards[i] = monsterAttribution();
        }
    }

    public void initializePlayersHand(int numberOfMonsters){
        this.playerCards = new Monster[numberOfMonsters];
        getCards();
    }

    public  int chooseHandSize(){
        return 3; //(int) Math.ceil(Math.random() * 10 + 3);
    }


//    public void add() {
//        if (this.numberOfMonsters < this.playerCards.length) {
//
//    }
//            this.playerCards[this.numberOfMonsters] = monsterAttribution();
//        }

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
        switch (randomNumberToPickCard()) {
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
}


