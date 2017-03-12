import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import java.util.ArrayList;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class HandEvaluatorTest {
  HandEvaluator evaluator;
  HandEvaluator evaluator2;
  HandEvaluator evaluator3;
  ArrayList<Card>hand;
  ArrayList<Card>hand2;
  ArrayList<Card>hand3;
  Card card1;
  Card card2;
  Card card3;
  Card card4;
  

  @Before
  public void before(){
    card1 = new Card(CardValue.ACE, CardSuit.SPADES);
    card2 = new Card(CardValue.JACK, CardSuit.SPADES);
    card3 = new Card(CardValue.EIGHT, CardSuit.SPADES);
    card4 = new Card(CardValue.SIX, CardSuit.SPADES);
    hand = new ArrayList<Card>();
    hand2 = new ArrayList<Card>();
    hand3 = new ArrayList<Card>();
    hand.add(card1);
    hand.add(card2);
    hand2.add(card2);
    hand2.add(card3);
    hand3.add(card4);
    hand3.add(card2);
    evaluator = new HandEvaluator(hand);
    evaluator2 = new HandEvaluator(hand2);
    evaluator3= new HandEvaluator(hand3);
  }

  @Test
  public void blackjackReturns5(){
    assertEquals(5, evaluator.whatMove());
  }

  @Test
  public void seventeenSticks1(){
    assertEquals(1, evaluator2.whatMove());
  }

  @Test
  public void sixteenTwists0(){
    assertEquals(0, evaluator3.whatMove());
  }

}