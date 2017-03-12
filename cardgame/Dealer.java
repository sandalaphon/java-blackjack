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
    Card card = shuffledCards.get(shuffledCards.size()-1);
    for (Player player : this.players ) {
       if (player.shouldDeal()) 
        {player.receiveCard(card);
        shuffledCards.remove(shuffledCards.size()-1);
       }
    }
  }

  public int numberOfPlayers(){
    return this.players.size();
  }







}