import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

class HandofCards<C> implements Hand<C>{
    private ArrayList<C> hand;

    public HandofCards() {
        hand = new ArrayList<>();
    }

    /**
     * Method to add one <c> to the "front" of a Hand
     *
     * @param c
     */
    @Override
    public void add(C c) {
        hand.add(c);
    }

    /**
     * Method to remove index'th <C> from the Hand
     * if the index is invalid, it throws an IndexOutOfBoundsException
     *
     * @param index
     */
    @Override
    public void discard(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        hand.remove(index);
    }

    /**
     * Method to get the index'th <C> from the Hand
     * if the index is invalid, it throws an IndexOutOfBoundsException
     *
     * @param index
     * @return C
     */
    @Override
    public C get(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return hand.get(index);
    }

    /**
     * Method to get the number of <C>s currently in the Hand
     *
     * @return size
     */
    @Override
    public int getSize() {
        return hand.size();
    }

    /**
     * Method to check if the Hand is empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return hand.isEmpty();
    }

    /**
     * Method to find the index of a first item in the Hand
     * if the item is not in the Hand, it returns -1
     *
     * @param c
     * @return index
     */
    @Override
    public int find(C c) {
        return hand.indexOf(c);
    }

    /**
     * Method to sort the Hand accepts a higher-order comparison
     * Function as a argument and calls Collections.sort
     *
     * @param comparator
     */
    @Override
    public void sortHand(Comparator<C> comparator) {
        Collections.sort(hand, comparator);
    }

    /**
     * Method to return a subset of a Hand based on a Predicate
     * accepts a higher-order Predicate as an argument and returns a new Hand
     * containing only the items that satisfy the Predicate
     *
     * @param predicate
     * @return Hand
     */

    @Override
    public Hand<C> getHand(Predicate<C> predicate) {
        Hand<C> filteredHand = new HandofCards<>();
        for (C card : hand) {
            if (predicate.test(card)) {
                filteredHand.add(card);
            }
        }
        return filteredHand;
    }

    /**
     * Method to fold/reduce the hand to the sum of the ranks
     * @return int
     */

    @Override
    public int rankSum() {
        int sum = 0;
        for (C card : hand) {
            if (card instanceof Card) {
                sum += ((Card) card).getRank();
            }
        }
        return sum;
    }

    /**
     * Method to map the Hand to another type based on a Function
     * accepts a higher-order Function as a argument and returns a new Hand
     * containing the items that have been transformed by the Function
     *
     * @param function
     * @return Hand
     */

    @Override
    public <T> Hand<T> getMap(Function<C, T> function) {
        Hand<T> mappedHand = new HandofCards<>();
        for (C card : hand) {
            mappedHand.add(function.apply(card));
        }
        return mappedHand;
    }

    /**
     * Method to return a string representation of the hand of cards
     * @return String
     */

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(C card: hand){
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
}
