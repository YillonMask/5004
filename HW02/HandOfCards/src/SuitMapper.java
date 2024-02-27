import java.util.function.Function;

public class SuitMapper implements Function<Card, Suit> {
    @Override
    public Suit apply(Card card) {
        return card.getSuit();
    }
}