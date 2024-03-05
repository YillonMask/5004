/**
 * Interface Specification for various BookStoreItems such as Books and Magazines
 */
public interface BookStoreItem {

  /**
   * Getter for the title of the BookStoreItem
   * <p>
   * @return String, the title of the BookStoreItem
   */
  String getTitle();

  /** Getter for the year of the BookStoreItem
   * <p>
   * @return int, the year of BookStoreItem
   */
  int getYear();

  /**
   * Getter for the author of the BookStoreItem, a Person
   * <p>
   * @return Person, the author of the BookStoreItem
   */
  Person getAuthor();

  /**
   * Getter for the retail price of the BookStoreItem
   * <p>
   * @return double, the retail price of the BookStoreItem
   */
  double getPrice();

  /**
   * Method to determine if two BookStoreItems have the same author
   * <p>
   * @param other, the other Publication whose author might be same as this
   * @return boolean, true if the authors are the same Person, else false
   */
  boolean sameAuthor(BookStoreItem other);
  //FlowFound:missing semicolon at the end of line 39
  //FlowToDo: add semicolon at the end of line 39
  //FlowFixed: semicolon added at the end of line 39

  /**
   * Method to return the kind of BookStoreItem as a String
   * <p>
   * @return String, the kind of BookStoreItem (eg "Book" or "Magazine")
   */
  String kind();
}
