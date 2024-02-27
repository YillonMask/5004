import java.util.function.Function;

public class RankMapper implements Function<Card,Integer> {
    @Override
    public Integer apply(Card card){
        return card.getRank();
    }
}
