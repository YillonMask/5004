import java.util.Objects;

/**
 * This class represents a Book. A Book has a kind, title, author, year, and price.
 * <p>
 * The "kind" ("Book") is calculated by a method inherited from AbstractBookStoreItem.
 * The other fields must be provided to super when a new Book is constructed.
 * NB: A book can be equal to another book even if their prices are different.
 * Book is a subclass of AbstractBookStoreItem, which implements BookStoreItem.
 */
public class Book extends AbstractBookStoreItem {
  // Note: Book inherits protected fields title, author, year, and price from parent
  // It also inherits some concrete methods, but implements others directly

  /**
   * Construct a new Book object that has the provided title, author, year, and price
   * <p>
   * @param title, String representing the title of this book
   * @param author, Person who is the author of this book
   * @param year, int representing the year of publication
   * @param price, double representing the current price of this book
   */
  public Book(String title, Person author, int year, double price) {
    super(title, author, year, price);
  }

  /**
   * Checks if two Books have the same author
   * <p>
   * @param other, the other BookStoreItem
   * @return boolean, true iff the authors are equal
   */
  @Override
  public boolean sameAuthor(BookStoreItem other) {
    // Get the two authors and hand to equals
    Person author1 = this.getAuthor();
    Person author2 = other.getAuthor();
    return author1.equals(author2);
  }

  /**
   * Return a formatted string that contains key information about this book.
   * <p>
   * The string should be in the following format:
   * Kind: [Book]
   * Title: [title of the book]
   * Author: [first-name last-name]
   * Year: [year of publication]
   * Price: [Price as a decimal number with two numbers after decimal]
   * 
   * @return String, the formatted string as above
   */
  public String toString() {
    String str;
    str = "Kind: " + this.kind()+"\nTitle: "+this.title+"\nAuthor: "+this.author+
          "\nYear: "+this.year+String.format("\nPrice: %.2f",this.price);
    return str;
  }

  /**
   * Books to be considered equal if Title, Author, and Year are equal.
   * <p>
   * @param object, the other object to be compared with this book
   * @return true iff the books are equal
   * Different prices do not invalidate equality
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Book)) {
      return false;
    }
    Book otherbook = (Book) object;
    return this.title.equals(otherbook.title)
            && this.author.equals(otherbook.author)
            && this.year == otherbook.year;
  }
  //FlawFound: equals() method should check if the object is an instance of Book and then compare the fields
  //FlawToDO: change the equals() method to check if the object is an instance of Book and then compare the fields
  //FlawFixed: changed the equals() method to check if the object is an instance of Book and then compare the fields

  /**
   * Override hashCode since overriding equals
   * <p>
   * @return an int, the hashCode for equal Books
   * Based on title, author, and year
   */
  @Override
  public int hashCode() {
     return Objects.hash(title, author, year);
  }
}