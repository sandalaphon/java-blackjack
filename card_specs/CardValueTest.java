import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;

public class CardValueTest{
Card card;

@Before
public void before(){
card = new Card(CardValue.ACE, CardSuit.SPADES);
}

@Test
public void whatCardTest(){
assertEquals(CardValue.ACE, card.getCardValue());
}

@Test
public void getSuitTest(){
  assertEquals(CardSuit.SPADES, card.getCardSuit());
}

@Test
public void getCardbJValue(){
  assertEquals( 11, card.getCardValue().bJValue());
}

@Test 
public void getCardbJOrder(){
  assertEquals(14, card.getCardValue().bJOrder());
}


  }

  
  