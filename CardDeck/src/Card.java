/**   
 * Card Class   
 */   public class Card {     

	 /**   
	  * Enum types for the card variables   
	  * - Suit   
	  * - Rank   
	  */  
	 enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }  
	 enum Rank { JOKER, A, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHTH, NINE, TEN, J, Q, K } 

	 Suit suit;
	 Rank rank;

	 /**   
	  *  A constructor that accepts a suit and rank input to initialize a card   
	  * @param s   
	  * @param r   
	  */
	 public Card(Suit s, Rank r) {
		 suit = s;
		 rank = r;
	 }   

	 /**
	  * A constructor that uses a different Card to initialize the new card.
	  * @param otherC
	  */
	 public Card(Card otherC) {
		 this.suit = otherC.suit;
		 this.rank = otherC.rank;  	 
	 }

	 // Getters & Setters
	 public Suit getSuit() { return suit;}
	 public Rank getRank() {	return rank; }
	 public void setSuit(Suit suit) {this.suit = suit;}
	 public void setRank(Rank rank) {this.rank = rank;}

	 /**   
	  * Checks if two cards are the same.   
	  * @param c2   
	  */   
	 @Override   
	 public boolean equals(Object c2) { 
		 if(!(c2 instanceof Card))
			 return false; 
		 //throw new RuntimeException("Illegal argument to Card.equals()");
		 Card c = (Card) c2;
		 return suit == c.suit && rank == c.rank;
	 }     

	 /**
	  * TO-STRING
	  * Override of the method toSting prints a card object.
	  * @return The string "[R,S]" where R is rank and S is suit
	  */
	 @Override  
	 public String toString() {
		 return "[" + rank  + "," + suit + "]";  
	 } 	

	 /**
	  * Exercise 1
	  * Returns true only if the target Card exists
	  * inside the given Card array
	  * @param deck
	  * @return
	  */
	 public boolean exists(Card[] deck) {
		 // TODO Your Code Here
		 for (int i = 0; i < deck.length; i++) {
			 if (deck[i] != null && deck[i].equals(this)) {
				 return true;
			 }else if (deck[i] == null) {
				 return false;
			 }
		 }
		 return false;
	 }

	 /**
	  * Exercise 1B
	  * Returns true only if the target Card exists
	  * inside the given Card array
	  * @param deck
	  * @return
	  */
	 public boolean exists2(Card[] deck) {
		 // TODO Your Code Here
		 for (int i = 0; i < deck.length; i++) {
			 if (deck[i] != null) {
				 if(deck[i].equals(this)) {
					 return true;
				 }
			 } else
				 return false;
		 }
		 return false;
	 }


	 /**
	  * Exercise 1C
	  * Returns true only if the target Card exists
	  * inside the given Card array
	  * @param deck
	  * @return
	  */
	 public boolean exists3(Card[] deck) {
		 // TODO Your Code Here
		 for(Card c: deck) { 
			 if(this.equals(c))
				 return true;
		 }
		 return false;
	 } 


	 /**
	  * Add target Card to end of deck.
	  * Throw array-out-of-bounds exception if deck is full.
	  * @param deck
	  * @return deck
	  */
	 public Card[] add1(Card[] deck) {
		 // TODO Your Code Here
		 int i = 0;
		 while (deck[i] != null) {
			 i++;
		 }
		 deck[i] = this; 
		 return deck;
	 }


	 /**
	  * Add target Card to end of deck.
	  * If deck is full, expand deck (double in size).
	  * @param newCard
	  * @param deck
	  */
	 public Card[] add2(Card[] deck) {
		 // TODO Your Code Here
		 int lastIndex = deck.length - 1;
		 if (deck[lastIndex] != null) {
			 Card[] moreCards = new Card[deck.length * 2];
			 for (int j = 0; j < deck.length; j++ ) {
				 moreCards[j] = deck[j];
			 }
			 deck = moreCards;
		 }

		 int i = 0;
		 while (deck[i] != null) {
			 i++;
		 }
		 deck[i] = this; 
		 return deck;
	 }


	 /**   
	  * Exercise X
	  * Returns a new deck with all the Joker cards removed   
	  * from the original deck given how many joker cards are   
	  * in the given array.   
	  * @param deck   
	  * @param jokerCount   
	  * @return   
	  */
	 public static Card[] removeJokers(Card[] deck, int jokerCount) {
		 return null;
	 }  	 

 } // END OF CARD CLASS
