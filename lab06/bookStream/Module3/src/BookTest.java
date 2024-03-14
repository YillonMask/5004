import static java.util.Collection.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JUnit test class for books
 */
public class BookTest {

  private Book b1;
  private Book b2;
  private Book b3;
  private Book b4;
  private Book b5;
  private List<Book> listOfBook = new ArrayList<>();

  @Before
  public void setUp() {
    // example of books
    b1 = new Book("book1", 20,1980);
    b2 = new Book("book2", 18,1990);
    b3 = new Book("book3", 16,1988);
    b4 = new Book("book4", 32,2004);
    b5 = new Book("book5", 42,2022);
    listOfBook.add(b1);
    listOfBook.add(b2);
    listOfBook.add(b3);
    listOfBook.add(b4);
    listOfBook.add(b5);
  }


  @Test
 public void testGetMap(){
      List<Float> listOfPrice = new ArrayList<>();
      int beforeYear = 1990;
      listOfPrice = Book.getMap(listOfBook,book -> book.getYear() < beforeYear);
      List<Float> expected = new ArrayList<>();
      expected.add(b1.getPrice());
      expected.add(b3.getPrice());
      assertEquals(expected.toString(),listOfPrice.toString());
  }

}