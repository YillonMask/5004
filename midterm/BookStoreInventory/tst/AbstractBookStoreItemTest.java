import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for concrete methods implemented in AbstractBookStoreItem
 * <p>
 * Includes shared tests for required methods, even if implemented separately;
 * Separate tests are provided for methods unique to the subClasses.
 */
public class AbstractBookStoreItemTest {
  private Book book1; // Test example for a book
  private Book book2; // Test example for another book
  private Magazine mag1;  // Test example for a magazine
  private Magazine mag2;  // Test example for another magazine
  private Person john;       // Test example for an author
  private Person mark;       // Test example for another author

  @Before
  public void SetUp() {
    // Initialize some People, Books, and Magazines
    john = new Person("John", "Steinbeck", 2023);
    mark = new Person("Mark", "Miller", 1950);
    book1 = new Book("The Grapes of Wrath", john, 1939, 100.00);
    book2 = new Book("The Winter of our Discontent", john, 1961, 75.00);
    mag1 = new Magazine("Life", john,  1940, Month.FEBRUARY, 2.50);
    mag2 = new Magazine("Life", mark, 1960, Month.APRIL, 4.00);
  }

  /**
   * Verify that getTitle returns the BookStoreItem's title as constructed
   */
  @Test
  public void testGetTitle() {
    // Test with a Book
    assertEquals("The Grapes of Wrath", book1.getTitle());
    // Test with a Magazine
    assertEquals("Life", mag1.getTitle());
  }

  /**
   * Verify that getYear returns BookStoreItem's publication year as constructed
   */
  @Test
  public void testGetYear() {
    // Test with a Book
    assertEquals(1939, book1.getYear());
    // Test with a Magazine
    assertEquals(1940, mag1.getYear());
  }

  /**
   * Verify that getAuthor returns the BookStoreItem's author as constructed
   */
  @Test
  public void testGetAuthor() {
    // Test with a Book
    assertEquals(book1.getAuthor(), john);
    // Test with a Magazine
    assertEquals(mag1.getAuthor(), john);
  }

  /**
   * Verify that getPrice returns the BookStoreItem's current price
   * <p>
   * Price is approximate to within 0.001.
   */
  @Test
  public void testGetPrice() {
    assertEquals(100.0, book1.getPrice(), 0.001);
    assertEquals(2.50, mag1.getPrice(), 0.001);
  }

  /**
   * Verify that sameAuthor correctly compares authors of two BookStoreItems
   */
  @Test
  public void testSameAuthor() {
    // Test with 2 Books with same author
    assertTrue(book1.sameAuthor(book2));
    // Test with 2 Magazines with different authors
    assertFalse(mag1.sameAuthor(mag2));
    // Test with 1 Book and 1 Magazine
    assertTrue(book1.sameAuthor(mag1));
    // Test with 1 Magazine and 1 Book
    assertFalse(book2.sameAuthor(mag2));
  }

  /**
   * Verify that getKind returns the BookStoreItem's kind as constructed
   * <p>
   * Not a getter for a field! String is computed from the name of its subClass
   */
  @Test
  public void testKind() {
    assertEquals("Book", book1.kind());
    assertEquals("Magazine", mag1.kind());
  }
}
