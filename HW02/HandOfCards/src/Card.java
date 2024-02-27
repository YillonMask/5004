import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class to represent a Card. A card has a suit and a rank
 * @param <C>
 */
public class Card<C> implements Comparable<Card> {
    private final List<C> cards = new ArrayList<>();
    private final Suit suit;
    private final int rank;

    /**
     * Constructor for a Card
     *
     * @param suit
     * @param rank
     */
    public Card(Suit suit, int rank) {
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("Rank must be between 1 and 13");
        }
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Method to get the suit of the card
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Method to get the rank of the card
     *
     * @return rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Method to get the color of the card
     * if the card is a diamond or heart, it is red otherwise it is black
     *
     * @return color as an Enum
     */
    public Enum getColor() {
        return (suit == Suit.DIAMONDS || suit == Suit.HEARTS) ? color.RED : color.BLACK;
    }


    /**
     * Method to return a string representation of the Card
     * @return String
     */

    @Override
    public String toString() {
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        return ranks[rank - 1] + " of " + suit.toString();
    }

    /**
     * Method to check if two Cards are equal
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    /**
     * Method to return the hashcode of the Card
     * @return int
     */

    @Override
    public int hashCode() {
        return 31 * suit.hashCode() + rank;
    }

    /**
     * Method to compare two Cards based on their rank
     * @param other
     * @return int
     */
    @Override
    public int compareTo(Card other) {
        return Integer.compare(rank, other.rank);
    }
}

