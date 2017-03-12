package cardgame;
import java.util.ArrayList;
public class Deck{
 
 private ArrayList<Card>newDeck;
// constructor
 public Deck(){
  this.newDeck = new ArrayList<Card>();
  // nested for loops to populate deck
  int index = 0;
  for (int i=0; i<4 ; i++) {

    for (int j=0;j<13 ;j++ ) {
      newDeck.add(index, new Card(CardValue.values()[j], CardSuit.values()[i]));
      index++;
      // print out to confirm
      // System.out.println("Card is the " + CardValue.values()[j] +" of " + CardSuit.values()[i]);
    }
  }
}

public ArrayList<Card> getDeck(){
  return newDeck;
}



}