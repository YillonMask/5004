import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class HandofCardsTest {
    private HandofCards<Card> hand,emptyHand;
    private ArrayList<Card> handList;
    private Card<Card> card1, card2, card3,card4,card5;

    @Before
    public void setUp() {
        hand = new HandofCards<>();
        emptyHand = new HandofCards<>();
        card1 = new Card<>(Suit.HEARTS, 5);
        card2 = new Card<>(Suit.HEARTS, 8);
        card3 = new Card<>(Suit.CLUBS, 9);
        card4 = new Card<>(Suit.DIAMONDS, 10);
        card5 = new Card<>(Suit.SPADES, 12);
    }

    @Test
    public void addCardToHandIncreasesSize() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        assertEquals(3, hand.getSize());
        assertEquals(0, emptyHand.getSize());
    }

    @Test
    public void testDiscardCardDecreasesSize() {
        hand.add(card1);
        hand.discard(0);
        assertEquals(0, hand.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> hand.discard(1));
    }

    @Test
    public void testGetCard() {
        hand.add(card1);
        hand.add(card2);
        assertEquals(card2, hand.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> hand.get(2));
    }

    @Test
    public void testFind() {
        hand.add(card1);
        hand.add(card2);
        assertEquals(1, hand.find(card2));
        assertEquals(-1, hand.find(card3));
    }

    @Test
    public void testIsEmpty() {
        hand.add(card1);
        assertTrue(emptyHand.isEmpty());
        assertFalse(hand.isEmpty());
    }

    /**
     * Test the sorting method using compareTo method
     */
    @Test
    public void testSortBasedOnRankUsingCompareTo() {
        handList= new ArrayList<>();
        handList.add(card5);
        handList.add(card4);
        handList.add(card3);
        handList.add(card2);
        handList.add(card1);
        //before sorting
        assertEquals(card5, handList.get(0));
        assertEquals(card4, handList.get(1));
        //this will use the compareTo method in the Card class
        Collections.sort(handList);
        //after sorting
        assertEquals(card2, handList.get(1));
        assertEquals(card1, handList.get(0));
    }

    /**
     * Test the sorting method using a Comparator
     */

    @Test
    public void testSortBasedOnSuitComparator() {
        handList= new ArrayList<>();
        handList.add(card5);
        handList.add(card4);
        handList.add(card3);
        handList.add(card2);
        handList.add(card1);
        //before sorting
        assertEquals(card5, handList.get(0));
        assertEquals(card4, handList.get(1));
        assertEquals(card3, handList.get(2));
        //this will use the compare method in the SuitComparator class
        Collections.sort(handList, new SuitComparator());
        //after sorting
        assertEquals(card3, handList.get(0));
        assertEquals(card2, handList.get(1));
        assertEquals(card1, handList.get(2));
    }

    @Test
    public void testToString() {
        hand.add(card1);
        hand.add(card2);
        String expected = card1.toString() + "\n" + card2.toString() + "\n";
        assertEquals(expected, hand.toString());
    }

    /**
     * Test the getHand method using a single method
     */
    @Test
    public void testGetHandUsingSingleMethod(){
        int rank = 5;
        hand.add(card1);
        hand.add(card2);
    Hand<Card> filteredHand = hand.getHand(new RankGreaterThan(rank));
        String expected = card2.toString() + "\n";
        assertEquals(expected, filteredHand.toString());
    }

    /**
     * Test the getHand method using a lambda expression
     */
    @Test
    public void testGetHandUsingLambdaExpression() {
        int rank = 5;
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        Hand<Card> filteredHand = hand.getHand(card -> card.getRank() > rank && card.getSuit() == Suit.CLUBS);
        String expected = card3.toString() + "\n";
        assertEquals(expected, filteredHand.toString());
    }

    /**
     * Test the getHand method using an anonymous class
     */
    @Test
    public void testGetHandUsingAnonymousClass() {
        int rank = 5;
        hand.add(card1);
        hand.add(card2);
        Hand<Card> filteredHand = hand.getHand(
                new Predicate<Card>(){
                    @Override
                    public boolean test(Card card) {
                        return card.getRank() > rank;
                    }
                });
        String expected = card2.toString() + "\n";
        assertEquals(expected, filteredHand.toString());
    }

    /**
     * Test the rankSum method
     */

    @Test
    public void rankSumReturnsCorrectSum() {
        hand.add(card1);
        hand.add(card2);
        assertEquals(13, hand.rankSum());
        hand.add(card3);
        assertEquals(22, hand.rankSum());
        assertEquals(0, emptyHand.rankSum());
    }

    /**
     * Test the getMap method based on Suit using a lambda expression
     */

    @Test
    public void testGetMapBasedOnSuit() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Suit> mappedHand = hand.getMap(Card->Card.getSuit());
        for(int i = 0; i < hand.getSize();i++){
            assertEquals(hand.get(i).getSuit(),mappedHand.get(i));
        }
    }

    /**
     * Test the getMap method based on Suit using an anonymous class
     */
    @Test
    public void testGetMapBasedOnSuitUsingAnonymousClass() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Suit> mappedHand = hand.getMap(new Function<Card, Suit>() {
            @Override
            public Suit apply(Card card) {
                return card.getSuit();
            }
        });
        for (int i = 0; i < hand.getSize(); i++) {
            assertEquals(hand.get(i).getSuit(), mappedHand.get(i));
        }
    }

    /**
     * Test the getMap method based on Suit using a single method
     */
    @Test
    public void testGetMapBasedOnSuitUsingSingleMethod() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Suit> mappedHand = hand.getMap(new SuitMapper());
        for (int i = 0; i < hand.getSize(); i++) {
            assertEquals(hand.get(i).getSuit(), mappedHand.get(i));
        }
    }

    /**
     * Test the getMap method based on Rank using a Lambda expression
     */
    @Test
      public void testGetMapBasedOnRank() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Integer> mappedHand = hand.getMap(Card -> Card.getRank());
        for (int i = 0; i < hand.getSize(); i++) {
          assertEquals(hand.get(i).getRank(), (int) mappedHand.get(i));
        }
    }

    /**
     * Test the getMap method based on Rank using an anonymous class
     */
    @Test
    public void testGetMapBasedOnRankUsingAnonymousClass(){
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Integer> mappedHand = hand.getMap(new Function<Card,Integer>(){
            @Override
            public Integer apply(Card card){
                return card.getRank();
            }
        });
    }

    /**
     * Test the getMap method based on Rank using a single method
     */
    @Test
    public void testGetMapBasedOnRankUsingSingleMethod(){
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        Hand<Integer> mappedHand = hand.getMap(new RankMapper());
        for (int i = 0; i < hand.getSize(); i++) {
            assertEquals(hand.get(i).getRank(), (int) mappedHand.get(i));
        }
    }

}
