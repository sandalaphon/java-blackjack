import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import java.util.ArrayList;

public class DeckTest{
  Deck deck;
  Dealer dealer;
  Player player;
  ArrayList<Player>players;

  @Before
  public void before(){
    ArrayList<Player>players=new ArrayList<Player>();
    players.add(player);
    deck = new Deck();
    dealer = new Dealer(players);
  }

  @Test
  public void deck52Test(){
    int val =  52;
    assertEquals( val, deck.getDeck().size());
  }

  @Test
  public void printShuffledDeck(){
    
    assertEquals(52, dealer.shuffle().size());
  }


}