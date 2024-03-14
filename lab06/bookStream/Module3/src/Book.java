import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class represents a book. A book has a title, an author and a price
 */
public class Book {
  private String title;
  private float price;
  private int year;


  /**
   * Construct a Book object that has the provided title, author and  price
   *
   * @param title     the title to be given to this book
   * @param price     the price to be assigned to this book
   */

  public Book(String title, float price, int year) {
    this.title = title;
    this.price = price;
    this.year = year;
  }

  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book
   *
   * @return the price of this book
   */
  public float getPrice() {
    return this.price;
  }

  public int getYear(){return this.year;}


  /**
   * Return a formatted string that contains the information
   * of this object. The string should be in the following format:
   * <p>
   * Title: [title of the book]
   * Author: [first-name last-name]
   * Price: [Price as a decimal number with two numbers after decimal]
   *
   * @return the formatted string as above
   */

  public String toString() {
    String str;

    str = "Title: " + this.title + "\n" +
            "year: " + this.year;
    str = str + "\n";
    str = str + String.format("Price: %.2f", price);

    return str;
  }



  public static List<Float> getMap(List<Book> books, Predicate<Book> filterCriteria){
        return books.stream()
                .filter((filterCriteria))
                .map(Book::getPrice)
                .collect(Collectors.toList());
  }
}
