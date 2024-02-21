import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Card<C> implements Hand<C> {
    private final List<C> cards = new ArrayList<>();

    @Override
    public void initializeHand() {
        cards.clear();
    }

    @Override
    public void add(C c) {
        cards.add(0, c); // Adds to the "front" of the Hand.
    }

    @Override
    public void discard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public C get(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public int find(C c) {
        return cards.indexOf(c);
    }

    @Override
    public void sortHand(Comparator<? super C> comparator) {
        Collections.sort(cards, comparator);
    }
    @Override
    public Hand<C> getHand(Predicate<? super C> filter) {
        Hand<C> filteredHand = new Card<>();
        this.cards.stream()
                .filter(filter)
                .forEach(filteredHand::add);
        return filteredHand;
    }

    @Override
    public int rankSum() {
        // This assumes that C type has a method getRank() that returns an int.
        return this.cards.stream()
                .mapToInt(Card::getRank)
                .sum();
    }

    @Override
    public <R> Hand<R> getMap(Function<? super C, ? extends R> mapper) {
        Hand<R> mappedHand = new Card<>();
        this.cards.stream()
                .map(mapper)
                .forEach(mappedHand::add);
        return mappedHand;
    }

    private final Suit suit;
    private final Integer rank;

    public Card(Suit suit, Integer rank) {
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("Rank must be between 1 and 13");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Integer getRank() {
        return rank;
    }

    public color getColor() {
        return (suit == Suit.DIAMONDS || suit == Suit.HEARTS) ? color.RED : color.BLACK;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return suit == card.suit && rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
        return 31 * suit.hashCode() + rank.hashCode();
    }

    @Override
    public int compareTo(Card other) {
        return this.rank.compareTo(other.rank);
    }
}

