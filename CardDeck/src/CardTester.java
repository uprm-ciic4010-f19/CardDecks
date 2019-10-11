// CARD TESTER
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CardTester {

	Card jokerDiamondCard; 
	Card jokerClubsCard;  
	Card AceHeartsCard;   
	Card twoDiamondCard;   
	Card twoDiamondCard2;   
	Card fiveSpadesCard;   
	Card nineHeartsCard;   
	Card tenClubsCard; 
	Card jHeartsCard;   
	Card qHeartsCard;   
	Card kSpadesCard; 

	@Before    
	public void setUp() {   
		jokerDiamondCard = new Card(Card.Suit.DIAMONDS, Card.Rank.JOKER); 
		jokerClubsCard = new Card(Card.Suit.CLUBS, Card.Rank.JOKER);   
		AceHeartsCard = new Card(Card.Suit.HEARTS, Card.Rank.A);   
		twoDiamondCard = new Card(Card.Suit.DIAMONDS, Card.Rank.TWO);   
		twoDiamondCard2 = new Card(Card.Suit.DIAMONDS, Card.Rank.TWO);  
		fiveSpadesCard = new Card(Card.Suit.SPADES, Card.Rank.FIVE);    
		nineHeartsCard = new Card(Card.Suit.HEARTS, Card.Rank.NINE);    
		tenClubsCard = new Card(Card.Suit.CLUBS, Card.Rank.TEN); 		
		jHeartsCard = new Card(Card.Suit.HEARTS, Card.Rank.J);  
		qHeartsCard = new Card(Card.Suit.HEARTS, Card.Rank.Q); 
		kSpadesCard = new Card(Card.Suit.SPADES, Card.Rank.K); 
	}


	@Test    
	public void existsTest() { 
		Card[] emptyDeck = new Card[0];
		Card[] oneCardDeck = { qHeartsCard };
		Card[] NineHKSJokerC5S = {nineHeartsCard, jokerClubsCard, kSpadesCard, fiveSpadesCard };
		Card[] JokerDCD2D9H = { jokerDiamondCard, twoDiamondCard, tenClubsCard, twoDiamondCard2, nineHeartsCard };
		assertFalse("The deck has no cards", qHeartsCard.exists(emptyDeck));
		assertTrue("The deck has no cards", qHeartsCard.exists(oneCardDeck));
		assertFalse("The deck has no Ten of Clubs", tenClubsCard.exists( NineHKSJokerC5S ));
		assertTrue("The deck has the Five of Spades", fiveSpadesCard.exists( NineHKSJokerC5S ));
		assertTrue("The deck has the Two of Diamonds", twoDiamondCard.exists( JokerDCD2D9H ));
	} 
	

	@Test    
	public void add1Test() { 
		Card[] oneCardDeck = { qHeartsCard, null };
		Card[] twoCardDeck = { qHeartsCard, fiveSpadesCard };
		assertTrue("", jokerDiamondCard.exists(jokerDiamondCard.add1(oneCardDeck)));
		//assertFalse("", jokerDiamondCard.exists(jokerDiamondCard.add1(twoCardDeck)));
		// The above line is NOT how you test for exceptions!
	} 
	

	// This is how your can test that an exception occurs
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void add1TestB() { 
		Card[] twoCardDeck = { qHeartsCard, fiveSpadesCard };
		jokerDiamondCard.exists(jokerDiamondCard.add1(twoCardDeck));
	} 

	
	@Test    
	public void add2Test() { 
		Card[] oneCardDeck = { qHeartsCard, null };
		Card[] twoCardDeck = { qHeartsCard, fiveSpadesCard };
		assertTrue("", jokerDiamondCard.exists(jokerDiamondCard.add2(oneCardDeck)));
		assertTrue("", jokerDiamondCard.exists(jokerDiamondCard.add2(twoCardDeck)));
	}
	
	
	@Test
	public void removeJokerTest() {
		Card[] emptyDeck = new Card[0];
		Card[] KSJokerC5S = { kSpadesCard, jokerClubsCard, fiveSpadesCard };
		Card[] TenCJokerC9HJokerD = { tenClubsCard, jokerClubsCard, nineHeartsCard, jokerDiamondCard };
		Card[] JokerDeck = {jokerClubsCard, jokerDiamondCard };
		Card[] JokerD2DJokerCJokerD = { jokerDiamondCard, twoDiamondCard, jokerClubsCard , jokerDiamondCard };
		// Empty Deck
		Card[] emptyDeckResult = Card.removeJokers(emptyDeck, 0);
		assertEquals("Result should be empty", 0, emptyDeckResult.length);
		// One Joker
		Card[] KSJokerC5SResult = Card.removeJokers(KSJokerC5S, 1);
		assertEquals("Result should have two items", 2, KSJokerC5SResult.length);
		assertEquals("Item 1 should be King of Spades", kSpadesCard, KSJokerC5SResult[0 ]);
		assertEquals("Item 2 should be Five of Spades", fiveSpadesCard, KSJokerC5SResult[1]);
		// Two Jokers
		Card[] TenJokerC9HJokerDResult = Card.removeJokers(TenCJokerC9HJokerD, 2);
		assertEquals("Result should have two items", 2, TenJokerC9HJokerDResult.length);
		assertEquals("Item 1 should be Ten of Clubs", tenClubsCard, TenJokerC9HJokerDResult[0]);
		assertEquals("Item 2 should be Nine of Hearts", nineHeartsCard, TenJokerC9HJokerDResult[1]);
		// Only Jokers
		Card[] JokerDeckResult = Card.removeJokers(JokerDeck, 2);
		assertEquals("Result should be empty", 0, JokerDeckResult.length);
		// Three Jokers
		Card[] JokerD2DJokerCJokerDResult = Card.removeJokers(JokerD2DJokerCJokerD, 3);
		assertEquals("Result should have one items", 1, JokerD2DJokerCJokerDResult. length);
		assertEquals("Item 1 should be Two of Diamonds", twoDiamondCard, JokerD2DJokerCJokerDResult[0]);
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
