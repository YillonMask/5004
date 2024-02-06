/**
 * This interface represents a list of integers.
 */
public interface IListOfInts {
    /**
     * Adds an integer to the front of the list.
     *
     * @param data the integer to be added
     * @return a new list with the integer added to the front
     */
    IListOfInts prepend(int data);

    /**
     * Adds an integer to the back of the list.
     *
     * @param data the integer to be added
     * @return a new list with the integer added to the back
     */
    IListOfInts append(int data);

    /**
     * Inserts an integer at the specified index in the list.
     * If the index is greater than the length of the list, the integer is added to
     * the end of the list.
     *
     * @param data  the integer to be inserted
     * @param index the index at which the integer should be inserted
     * @return a new list with the integer inserted at the specified index
     */
    IListOfInts insertAtIndex(int data, int index);

    /**
     * Retrieves the integer at the specified index in the list.
     * If the index is greater than or equal to the length of the list, an exception
     * is thrown.
     *
     * @param index the index of the integer to be retrieved
     * @return the integer at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    int getDataAtIndex(int index);

    /**
     * Returns a new list containing all elements of the original list except the
     * first element.
     *
     * @return a new list with all but the first element
     */
    IListOfInts getRest();

    /**
     * Returns the length of the list.
     *
     * @return the length of the list
     */
    int getCount();

    /**
     * Returns the sum of all elements in the list.
     *
     * @return the sum of all elements in the list
     */
    int getSum();

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    String toString();
}
