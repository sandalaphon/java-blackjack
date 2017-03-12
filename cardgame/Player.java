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
 return (this.hand.size()<2 && this.name!="dealer"  ? true : false);
 }



}