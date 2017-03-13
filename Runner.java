import cardgame.*;
import java.util.ArrayList;

public class Runner{
  // Player player1;
  // Player player2;
  // Player player3;
  // Player player4;
  // ArrayList<Card>players;
  // Dealer dealer;
  

public static void main(String[] args) {
  ArrayList<Player>players = new ArrayList<Player>();
  Player player1 = new Player("Richard", 1);
  Player player2 = new Player("Henry II", 1);
  Player player3 = new Player("Edward I", 1);
  Player player4 = new Player("Jamie", 1);
  players.add(player1);
  players.add(player2);
  players.add(player3);
  players.add(player4);
  Dealer dealer = new Dealer(players);
  dealer.dealerLoop();
  

}
}