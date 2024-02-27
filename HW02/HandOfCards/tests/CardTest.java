import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CardTest {
    private Card<Card> card1, card2, card3;

    @Before
    public void setUp() {
        card1 = new Card<>(Suit.HEARTS, 5);
        card2 = new Card<>(Suit.HEARTS, 8);
        card3 = new Card<>(Suit.CLUBS, 13);
    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.HEARTS, card1.getSuit());
        assertEquals(Suit.CLUBS, card3.getSuit());
    }

    @Test
    public void testGetRank() {
        assertEquals(5, card1.getRank());
        assertEquals(13, card3.getRank());
    }

    @Test
    public void testGetColor() {
        assertEquals(color.BLACK, card3.getColor());
        assertEquals(color.RED, card1.getColor());
    }

    @Test
    public void testToString() {
        String expected = "5 of HEARTS";
        assertEquals(expected, card1.toString());
        String expected2 = "King of CLUBS";
        assertEquals(expected2, card3.toString());
    }

    @Test
    public void testEquals() {
        Card<Card> otherCard1, otherCard2;
        otherCard1 = new Card<>(Suit.HEARTS, 5);
        assertEquals(card1, otherCard1);
        otherCard2 = new Card<>(Suit.CLUBS, 8);
        assertNotEquals(card2, otherCard2);
    }

    @Test
    public void testHashCode() {
        Card<Card> otherCard1, otherCard2;
        otherCard1 = new Card<>(Suit.HEARTS, 5);
        assertEquals(card1.hashCode(), otherCard1.hashCode());
        otherCard2 = new Card<>(Suit.HEARTS, 8);
        assertEquals(card2.hashCode(),otherCard2.hashCode());
    }

    @Test
    public void testCompareTo() {
        Card<Card> higherCard = new Card<>(Suit.HEARTS, 8);
        Card<Card> lowerCard = new Card<>(Suit.HEARTS, 2);

        assertTrue(card1.compareTo(higherCard) < 0);
        assertTrue(card1.compareTo(lowerCard) > 0);
        assertEquals(0, card1.compareTo(card1));
    }

}