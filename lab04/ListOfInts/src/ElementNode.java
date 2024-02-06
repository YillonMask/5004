/**
 * Represents a node in a linked list implementation of IListOfInts.
 */
public class ElementNode implements IListOfInts {
    public IListOfInts rest;
    public int data;

    /**
     * Constructs an ElementNode with the specified data and rest.
     * 
     * @param data the data of the node
     * @param rest the rest of the linked list
     */
    public ElementNode(int data, IListOfInts rest) {
        this.data = data;
        this.rest = rest;
    }

    /**
     * Prepends a new node with the specified data to the linked list.
     * 
     * @param data the data to prepend
     * @return the updated linked list with the new node prepended
     */
    @Override
    public IListOfInts prepend(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Appends a new node with the specified data to the linked list.
     * 
     * @param data the data to append
     * @return the updated linked list with the new node appended
     */
    @Override
    public IListOfInts append(int data) {
        this.rest = this.rest.append(data);
        return this;
    }

    /**
     * Inserts a new node with the specified data at the specified index in the
     * linked list.
     * 
     * @param data  the data to insert
     * @param index the index at which to insert the new node
     * @return the updated linked list with the new node inserted
     */
    @Override
    public IListOfInts insertAtIndex(int data, int index) {
        if (index == 0)
            return prepend(data);
        else {
            this.rest = this.rest.insertAtIndex(data, index - 1);
            return this;
        }
    }

    /**
     * Retrieves the data at the specified index in the linked list.
     * 
     * @param index the index of the data to retrieve
     * @return the data at the specified index
     * @throws IllegalArgumentException if the index is out of bounds
     */
    @Override
    public int getDataAtIndex(int index) throws IllegalArgumentException {
        if (index == 0)
            return this.data;
        else {
            return this.rest.getDataAtIndex(index - 1);
        }
    }

    /**
     * Retrieves the rest of the linked list.
     * 
     * @return the rest of the linked list
     */
    @Override
    public IListOfInts getRest() {
        return this.rest;
    }

    /**
     * Retrieves the number of nodes in the linked list.
     * 
     * @return the number of nodes in the linked list
     */
    @Override
    public int getCount() {
        return 1 + rest.getCount();
    }

    /**
     * Retrieves the sum of all the data in the linked list.
     * 
     * @return the sum of all the data in the linked list
     */
    @Override
    public int getSum() {
        return this.data + rest.getSum();
    }

    /**
     * Returns a string representation of the linked list.
     * 
     * @return a string representation of the linked list
     */
    @Override
    public String toString() {
        return "(" + this.data + ")";
    }
}
