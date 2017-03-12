package cardgame;

public class Card{

  private CardValue cardv;
  private CardSuit suit;
  public Card(CardValue cardv, CardSuit suit){
  this.cardv = cardv;
  this.suit = suit;
 }

 public CardValue getCardValue(){
  return this.cardv;
 }



public CardSuit getCardSuit(){
  return this.suit;
}

}

