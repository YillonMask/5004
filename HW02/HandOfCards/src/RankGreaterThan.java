import java.util.function.Predicate;

public class RankGreaterThan implements Predicate<Card> {
    private final int rank;

    public RankGreaterThan(int rank){
        this.rank = rank;
    }

    public boolean test(Card c){
        return c.getRank() > rank;
    }
}
