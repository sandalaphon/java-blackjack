package cardgame;
import java.util.ArrayList;

public class Player{
 private ArrayList<Card>hand;
 private String name;
 private Integer position;

 // constructor

 public Player(String name, Integer position){
    this.name = name;
   this.position = position;
   this.hand = new ArrayList<Card>();
 }

 public String getName(){
    return this.name;
 }

// player receives cards
 public void receiveCard(Card card){
  this.hand.add(card);
 }

 public ArrayList<Card> showHand(){
  return this.hand;
 }

// after each round hand is removed by dealer
 public void deleteHand(){
  this.hand.clear();
 }

 public int getHandValue(){
  int sum = 0;
  for (Card card : this.hand ) {
    sum += card.getCardValue().bJValue();
  }
  return sum;
 }

 public boolean isPlayerBust(){
  int handValue= getHandValue();
  return (handValue > 21 ? true : false) ;
 }

 public boolean shouldDeal(){
  if (this.name=="dealer" && this.hand.size()<1) {return true;}
 return (this.hand.size()<2 && this.name!="dealer"  ? true : false);
 }

 public int checkHand(){
  HandEvaluator evaluator = new HandEvaluator(this.hand);
  return evaluator.whatMove();

 }

public void win(){
  System.out.println(this.name + " has won!");
}

public void lose(){
  System.out.println(this.name + " has lost :)");
}

public void stands(){
  System.out.println(this.name + " hands are equal stands");
}

}