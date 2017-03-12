import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import java.util.ArrayList;


public class DealerTest{
  Player player;
  Player player2;
  Dealer dealer;
  // Deck deck;
  // Card card;
  // Card card2;
  // Card card3;
  ArrayList<Player>players;

  @Before
  public void before(){
    players = new ArrayList<Player>();
    player = new Player("Richard", 1);
    player2 = new Player("Charlie", 2);
    players.add(player);
    players.add(player2);
    dealer = new Dealer(players);
    // deck =  new Deck();
    // card = new Card(CardValue.SEVEN, CardSuit.HEARTS);
    // card2 = new Card(CardValue.JACK, CardSuit.SPADES);
    // card3 = new Card(CardValue.KING, CardSuit.SPADES);
  }

@Test
  public void dealerIsAPlayer(){
    assertEquals(3, dealer.numberOfPlayers());
  }






}