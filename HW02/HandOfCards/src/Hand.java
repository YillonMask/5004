import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * This interface represents all the operations to be supported by a Hand of items of type C.
 *
 * @param <C>
 */
public interface Hand<C> {

    /**
     * Method to add an item <C>to the "front" of a Hand.
     *
     * @param c
     */
    void add(C c);

    /**
     * Method to remove index'th <C> from the Hand
     * if the index is invalid, it throws an IndexOutOfBoundsException.
     *
     * @param index
     */
    void discard(int index);

    /**
     * Method to get the index'th <C> from the Hand
     * if the index is invalid, it throws an IndexOutOfBoundsException.
     *
     * @param index
     * @return C
     */
    C get(int index);

    /**
     * Method to get the number of <C>s currently in the Hand.
     *
     * @return size
     */
    int getSize();

    /**
     * Method to check if the Hand is empty.
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Method to find the index of a <C> in the Hand.
     *
     * @param c
     * @return index
     */
    int find(C c);

    /**
     * Method to sort the Hand based on a Comparator.
     *
     * @param comparator
     */
    void sortHand(Comparator<C> comparator);

    /**
     * Method to return a subset of a Hand based on a Predicate.
     * @param predicate
     * @return a Hand of items <C> that satisfy the predicate.
     */
    Hand<C> getHand(Predicate<C> predicate);
    /**
     *Method to fold/reduce the hand to the sum of the ranks.
     */
    int rankSum();

    /** Method to map the Hand to another type based on a Function.
     *
     * @param function
     * @return
     * @param <T>
     */
    <T> Hand<T> getMap(Function<C, T> function);

}