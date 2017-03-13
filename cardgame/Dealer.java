package cardgame;
import java.util.ArrayList;
import java.util.Random;


public class Dealer{

  private Deck deck;
  private ArrayList<Card> cards;
  private ArrayList<Card> shuffledCards;
  private ArrayList<Player> players;
  private Player dealerAsPlayer;

  public Dealer(ArrayList<Player> plays){
    this.deck = new Deck();
    this.cards = deck.getDeck();
    this.players = new ArrayList<Player>(plays);
    this.dealerAsPlayer = new Player("dealer", this.players.size());
    this.players.add(this.players.size(), dealerAsPlayer);
  // shuffledCards are not shuffled until they are shuffled.
    this.shuffledCards =  new ArrayList<Card>(cards);
    shuffle();
  }

  public ArrayList<Player> getPlayers(){
    return this.players;
  }

  public ArrayList<Card> shuffle(){

    Random randomnumber = new Random();
    Card holder;
    int randomIndex;

    for (int i=0; i < 52; i++) {
      randomIndex = randomnumber.nextInt(52);
      holder = this.shuffledCards.get(i);
      this.shuffledCards.set(i, this.shuffledCards.get(randomIndex));
      this.shuffledCards.set(randomIndex,holder);
    }
  // print out to confirm
    // for (Card card : shuffledCards ) {
      // System.out.println(card.getCardValue() + " of " + card.getCardSuit());
    // }
    return shuffledCards;
  }

  public void deal(){

    for (Player player : this.players ) {
      // System.out.println(player.getName());
      Card card = shuffledCards.get(shuffledCards.size()-1);
       if (player.shouldDeal()) 
        {player.receiveCard(card);
        shuffledCards.remove(shuffledCards.size()-1);
        // System.out.println(card);
       }
    }
  }

  public Player dealerAsPlayer(){
    return this.dealerAsPlayer;
  }

  public void twist(Player player){
    Card card = shuffledCards.get(shuffledCards.size()-1);
    player.receiveCard(card);
    shuffledCards.remove(shuffledCards.size()-1);
  }

  public int numberOfPlayers(){
    return this.players.size();
  }

  public int cardsInDeck(){
    return shuffledCards.size();
  }


public void dealerLoop(){
  //two deals sets up hand 2 cards for players, 1 for dealer
  deal();
  deal();
  for(Player player : players){
  if (player.getName() != "dealer")
    {dealTillStandOrBust(player);}
    }
    dealerTwistsUntil17OrBust();
    if (dealerAsPlayer.isPlayerBust()){System.out.println("dealer has gone bust!!!!!!!!!!!!!");}
    winnersAndLosers();
  }

// public void dealTillStandOrBust(Player player){
  
//   int movecode;
//   movecode = player.checkHand();
//  while(movecode<0){
//   movecode = player.checkHand();
//   switch(movecode){
//     case 0: twist(player);
//     case 1: System.out.println(player.getName() + " sticks on " + player.getHandValue() + player.getHandAsString());
//     return; 
//     case 2: return; //double when betting
//     case 3: return; //split when coded
//     case 4: System.out.println(player.getName() + " has gone bust");player.deleteHand();return; //player is bust. remove money and clear hand.
//     case 5: System.out.println(player.getName() + " has BlackJack!");
//     return; //blackjack identified
//     }
//    movecode = player.checkHand();
 // }
   // if (movecode==4){System.out.println(player.getName() + " is bust");}
    // }

  public void dealTillStandOrBust(Player player){

    while(!player.isPlayerBust()){
     int movecode=player.checkHand();
        if (movecode>0){System.out.println("returning");System.out.println(player.getName() + " finished with: " + player.getHandAsString()); return;}
       twist(player);
      }
    }
  


  public void dealerTwistsUntil17OrBust(){
   dealTillStandOrBust(this.dealerAsPlayer);
  }

  public void winnersAndLosers(){
    System.out.println("dealer had" + dealerAsPlayer.getHandValue());
    int dealerHandValue = this.dealerAsPlayer.getHandValue();
    if (dealerAsPlayer.isPlayerBust()){dealerHandValue=-1;}
    for (Player player: this.players){
      if (player.isPlayerBust())
        {System.out.println(player.getName() + " has gone bust");;player.lose();}
   else if (player.getHandValue()>dealerHandValue&&(player.getName()!="dealer")) 
      {player.win();}
    else if (player.getHandValue()==dealerHandValue&&(player.getName()!="dealer"))
      {player.stands();}
      else {player.lose();}
      player.deleteHand();
    }
  }


}
