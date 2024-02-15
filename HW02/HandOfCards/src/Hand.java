import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Hand<C> {

    // Constructor to create an empty Hand - this is not possible to define in an interface in Java.
    // Instead, you can define a method to initialize or reset the hand.
    void initializeHand();

    // Method to add an item to the "front" of the Hand.
    void add(C c);

    // Method to discard an item at a specific index from the Hand.
    void discard(int index);

    // Method to get an item at a specific index from the Hand.
    C get(int index);

    // Method to get the size of the Hand.
    int getSize();

    // Method to check if the Hand is empty.
    boolean isEmpty();

    // Method to find the index of an item in the Hand.
    int find(C c);

    // Method to sort the Hand using a comparison function.
    void sortHand(Comparator<? super C> comparator);

    // Method to return a subset of a Hand based on a Predicate.
    Hand<C> getHand(Predicate<? super C> filter);

    // Method to fold/reduce the hand to the sum of the ranks.
    int rankSum();

    // Method to map the Hand to another type based on a Function.
    <R> Hand<R> getMap(Function<? super C, ? extends R> mapper);

    public color getColor();
}