package cardgame;
import java.util.ArrayList;

public class HandEvaluator{
  private ArrayList<Card>hand;

  public HandEvaluator(ArrayList<Card> hand){
    this.hand = hand;
  }

  public int whatMove(){
    //0 for hit, 1 for stick, 2 for double, 3 for split, 4 for bust, 5 identify blackjack
    if (isPlayerBust()){return 4;}
    if(hasBlackJack()){return 5;}
    //not soft totals yet
    if(hasSeventeenormore()){return 1;}
    else {return 0;}
  }

  

  // ugly ternary that checks for blackjack
  public boolean hasBlackJack(){
    return ((this.hand.size()==2) && (hasAce() && hasTen())) ? true : false;
  }

  public boolean hasSeventeenormore(){
    if (!hasAce()){
      int handValue= getHandValue();
      if (handValue>=17){return true;}
      return false;
    }
      else if (hasAce()){
      if (getSoftHandValue()>=17){return true;}
      return false;}
      System.out.println("Error Hand Evaluator line 35, ought not get here");
      return false;
      }
    
 // What if 2 Aces? Next problem! checking duplicates next step. Incidentally this will work once aces are split for punters and house cant split aces.
    public int getSoftHandValue(){
      int sum = 0;
      for (Card card : this.hand ) {
        if(card.getCardValue()==CardValue.ACE){sum += 1;}
         else {sum += card.getCardValue().bJValue();}
       }
     return sum;
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

  // public boolean hasBlackJack(){

  // }

   public boolean hasTen(){
    for(Card card: this.hand){
      if(card.getCardValue().bJValue()==10){return true;}
    }
    return false;
  }

  public boolean hasAce(){
    for(Card card: this.hand){
      if (card.getCardValue()==CardValue.ACE){return true;}
    }
    return false;
  }


  // public boolean hasTen(){
  //   for()
  // }

  // 1. check if bust. 
  // 2. chick if blackjack...stands.
  // 3. check dealer's card.
  // 4. check if hand can be split
  // 5. check if hand ought to be split
  // 6  split or dont. if split receive new card and re=evaluate
  // 7. Does the hand have an Ace? if yes Soft-total
  // if two carder, doubling is an option.
  // 8. Soft-total(ST) Ace count Ace as high and if ST = 20 stand.
  // if ST = 19 && dealer==6 double if 2 carder else stand, else stand
  // if ST = 18 && dealer==2..6 double if two carder else stand, dealer==7 or 8 stand, dealer 9,10, A hit
  // if ST = 17 && dealer==3,4,5,6 double else hit
  // if ST = 15 or 16 && dealer==4,5,6 double else hit
  // if ST = 13 or 14 && dealer==5,6 double else hit
  // Hard total = total without ace (or designated low ace)
  // HT 17 and over Stand
  // dealer = 2,3,4,5,6  && HT ==13,14,15,16 stand else hit
  // dealer ==4,5,6 && HT ==12 Stand else hit
  // HT==11 Double if 2Carder else hit
  // HT==10 && dealer==2,3,4,5,6,7,8,9 double or hit. Dealer ==T,A hit.
  // HT==9 && dealer==3,4,5,6 double or hit. Else hit
  // ELSE hit.
  //




}