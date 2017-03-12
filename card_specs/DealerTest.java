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

// test 2 cards dealt to players...not dealer still not dealt in
  @Test
  public void dealerDeals1CardtoPlayers(){
    dealer.deal();
    assertEquals(1, player2.showHand().size());
  }

   @Test
  public void dealerGetsCard(){
    dealer.deal();
    ArrayList<Player>plrs;
   plrs = new ArrayList<Player>();
   plrs= dealer.getPlayers();
    assertEquals(1, plrs.get(plrs.size()-1).showHand().size());
  }

  @Test 
  public void dealRemovesCardFromDeck(){
    dealer.deal();
    assertEquals(49, dealer.cardsInDeck());

  }

  @Test
  public void dealtCardsAreDifferent(){
    dealer.deal();
    assertNotSame(player.showHand().get(0), player2.showHand().get(0));
  }
   //test players get 2 cards after dealer loop
  // test adjusted as player may now get more than one card if twists
  @Test
  public void player2Cards(){
    dealer.dealerLoop();
    assertEquals(true,player.showHand().size()>=2);
  }

  //test dealer has one card after dealerloop
  @Test
  public void dealerGetsOne(){
    dealer.dealerLoop();
     ArrayList<Player>plrs;
    plrs = new ArrayList<Player>();
    plrs= dealer.getPlayers();
 
    assertEquals(1, plrs.get(plrs.size()-1).showHand().size());
  }

  @Test
  public void testARound(){
    dealer.dealerLoop();
    dealer.dealerTwistsUntil17OrBust();
    dealer.winnersAndLosers();
    assertEquals(1,1);
  }


}