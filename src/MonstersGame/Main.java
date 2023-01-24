package MonstersGame;


public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("player1");
        Player p2 = new Player("player2");

        Game g1 = new Game(p1,p2);
        g1.verifyHandSize();
        g1.play();



//        Player [] players = {new Player("test"), null, new Player("test2")};
//        Player [] newPlayers = new Player[players.length-1];
//
//        int freePosition=0;
//        for (Player p : players) {
//            if(p!=null){
//                newPlayers[freePosition]=p;
//                freePosition++;
//            }
//        }
//        for (Player newPlayer : newPlayers) {
//            System.out.println(newPlayer);
//        }
    }

}