
	/**
	 * Creates random blackjack hands, with 2 to 6 cards,
	 * and prints out the blackjack value of each hand.
	 * The user decides when to stop.
	 */

public class BlackjackGame {
	public static void main(String[] args) {
   
	      Deck deck;            // A deck of cards.
	      Card card;            // A card dealt from the deck.
	      BlackjackHand hand;   // A hand of from two to six cards.
	      int nbCards;      // Number or cards in the hand.
	      boolean again;        // Set to true if user wants to continue.	      
	      deck = new Deck();    // Create the deck.

	      do {
	         deck.shuffle();
	         hand = new BlackjackHand(); 
	         nbCards = 2 + (int)(Math.random()*5);
	         System.out.println();
	         System.out.println();
	         System.out.println("Your cards :");
	         for ( int i = 0 ; i < nbCards ; i++ ) {
	            card = deck.dealCard();
	            hand.addCard(card);
	            System.out.println(card);
	         }
	         System.out.println("The value of your hand is " + hand.getBlackjackValue()+'.');
	         System.out.println();
	         System.out.print("Do you want to play again ? ");
	         again = TextIO.getlnBoolean();
	      } while (again == true);
	}
}

