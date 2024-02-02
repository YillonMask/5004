public interface IListOfInts {
    IListOfInts prepend(int data); // adds to front

    IListOfInts append(int data); // adds to back

    IListOfInts insertAtIndex(int data, int index); // inserts data so as to become the index'th element, before rest
    // Question: what if there are not enough elements for this?

    int getDataAtIndex(int index); // Question: what if the list isn't that long?

    IListOfInts getRest(); // Returns list of all but the first

    int getCount(); // Returns the length of the list

    int getSum(); // Returns the sum of the elements in the list

    String toString();
}
