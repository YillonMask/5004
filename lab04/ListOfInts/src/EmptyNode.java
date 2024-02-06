/**
 * Represents an empty node in a list of integers.
 * Implements the IListOfInts interface.
 */
public class EmptyNode implements IListOfInts {

    /**
     * Prepends an element to the list.
     * 
     * @param data The data of the element to be prepended.
     * @return The updated list with the new element at the beginning.
     */
    @Override
    public IListOfInts prepend(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Appends an element to the list.
     * 
     * @param data The data of the element to be appended.
     * @return The updated list with the new element at the end.
     */
    @Override
    public IListOfInts append(int data) {
        return append(data);
    }

    /**
     * Inserts an element at the specified index in the list.
     * 
     * @param data  The data of the element to be inserted.
     * @param index The index at which the element should be inserted.
     * @return The updated list with the new element inserted at the specified
     *         index.
     * @throws IllegalArgumentException if the index is invalid.
     */
    @Override
    public IListOfInts insertAtIndex(int data, int index) throws IllegalArgumentException {
        if (index == 0)
            return prepend(data);
        throw new IllegalArgumentException("Invalid index to insert an element");
    }

    /**
     * Retrieves the data at the specified index in the list.
     * 
     * @param index The index of the element to retrieve.
     * @return The data at the specified index.
     * @throws IllegalArgumentException if the index is invalid.
     */
    @Override
    public int getDataAtIndex(int index) throws IllegalArgumentException {
        throw new IllegalArgumentException("Wrong index");
    }

    /**
     * Retrieves the rest of the list after the current node.
     * 
     * @return The rest of the list.
     * @throws IllegalArgumentException if the list is empty.
     */
    @Override
    public IListOfInts getRest() throws IllegalArgumentException {
        throw new IllegalArgumentException("Null");
    }

    /**
     * Retrieves the count of elements in the list.
     * 
     * @return The count of elements.
     */
    @Override
    public int getCount() {
        return 0;
    }

    /**
     * Retrieves the sum of all elements in the list.
     * 
     * @return The sum of elements.
     */
    @Override
    public int getSum() {
        return 0;
    }

    /**
     * Returns a string representation of the list.
     * 
     * @return The string representation of the list.
     */
    @Override
    public String toString() {
        return "";
    }
}
