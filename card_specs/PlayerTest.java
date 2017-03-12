import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import java.util.ArrayList;


public class PlayerTest{
  Player player;
  Dealer dealer;
  Deck deck;
  Card card;
  Card card2;
  Card card3;
  ArrayList<Player>players = new ArrayList<Player>();

  @Before
  public void before(){
  
    player = new Player("Richard", 1);
    players.add(player);
    dealer = new Dealer(players);
    deck =  new Deck();
    card = new Card(CardValue.SEVEN, CardSuit.HEARTS);
    card2 = new Card(CardValue.JACK, CardSuit.SPADES);
    card3 = new Card(CardValue.KING, CardSuit.SPADES);
  }

  @Test
  public void playerCanReceiveCard(){
    player.receiveCard(card);
    assertEquals(CardValue.SEVEN, player.showHand().get(0).getCardValue());
  }

  @Test
  public void playerCanAddUp(){
    player.receiveCard(card);
    player.receiveCard(card2);
    assertEquals(17, player.getHandValue());
  }

  @Test
  public void playerCanGoBustTest(){
    player.receiveCard(card);
    player.receiveCard(card2);
    player.receiveCard(card3);
    assertEquals(true, player.isPlayerBust());
  }
//test if player remains if not bust
  @Test
  public void playerIsntBustTest(){
    player.receiveCard(card);
    player.receiveCard(card2);
    assertEquals(false, player.isPlayerBust());
  }

  @Test
  public void playerGetsACardFromDealer(){
    dealer.deal();
    assertEquals(1, player.showHand().size());
  }
}