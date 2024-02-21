import org.junit.Before;
import org.junit.Test;


import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {
    private Card<Card> card;

    @Before
    public void setUp() {
        card = new Card<>(Suit.HEARTS, 5);
    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void testGetRank() {
        assertEquals(5, card.getRank());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.RED, card.getColor());
    }

    @Test
    public void testToString() {
        assertEquals("Card{suit=HEARTS, rank=5}", card.toString());
    }

    @Test
    public void testEquals() {
        Card<Card> otherCard = new Card<>(Suit.HEARTS, 5);
        assertEquals(card, otherCard);
    }

    @Test
    public void testHashCode() {
        Card<Card> otherCard = new Card<>(Suit.HEARTS, 5);
        assertEquals(card.hashCode(), otherCard.hashCode());
    }

    @Test
    public void testCompareTo() {
        Card<Card> higherCard = new Card<>(Suit.HEARTS, 8);
        Card<Card> lowerCard = new Card<>(Suit.HEARTS, 2);

        assertTrue(card.compareTo(higherCard) < 0);
        assertTrue(card.compareTo(lowerCard) > 0);
        assertEquals(0, card.compareTo(card));
    }
}