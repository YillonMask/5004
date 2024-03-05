import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit 4 test Class for Book
 * <p>
 * Methods shared by Publications are tested in AbstractBookStoreItemTest
 * Methods with unique Book implementations are tested here
 */
public class BookTest {
  private Person pat;
  private Person john;
  private Book book1;
  private Book book2;
  private Book book3;
  private Book book4;
  private Magazine mag1;

  /**
   * Set up some examples of Person and Book for testing
   */
  @Before
  public void setUp() {
    // Examples of Person
    pat = new Person("Pat", "Conroy", 1948);
    john = new Person("John", "Steinbeck", 1902);
    // Examples of Book
    book1 = new Book ("Beaches", pat, 2020, 5.0);
    book2 = new Book("Sunsets", pat, 2021, 25.00);
    book3 = new Book("The Grapes of Wrath", john, 1939,  50.00 );
    mag1 = new Magazine("Beaches", pat, 2020, Month.MARCH, 5.0);
  }
  
  @Test
  public void testBookString() {
    String expected;
    expected = """
        Kind: Book
        Title: Beaches
        Author: Pat Conroy
        Year: 2020
        Price: 5.00""";
    //FlowFound:Expected price is 500
    //FlowToDo:Change the expected price to 5.00
    //FlowFixed:Changed the expected price to 5.00
    assertEquals(expected,book1.toString());
    String expected2;
    expected2 = """
        Kind: Book
        Title: Sunsets
        Author: Pat Conroy
        Year: 2021
        Price: 25.00""";
    assertEquals(expected2,book2.toString());
    //FlowFound:each test should have more than one assertion
    //FlowToDo:added another assertion
    //FlowFixed:added another assertion
  }
    @Test
    public void testSameAuthor() {
      assertTrue(book1.sameAuthor(book2));
      assertFalse(book1.sameAuthor(book3));
    }

  // FlowFound:BookTest did not cover SameAuthor() method
  // FlowToDo:Cover the SameAuthor() method
  // FlowFixed:Covered the SameAuthor() method

  @Test
  public void testEquals() {
    book4 = new Book ("Beaches", pat, 2020, 6);
    assertTrue(book1.equals(book4));
    assertFalse(book1.equals(book2));
    assertFalse(mag1.equals(book1));
    }
    // FlowFound:BookTest did not cover the equals() method
    // FlowToDo:Cover the equals() method
    // FlowFixed:Covered the equals() method

    @Test
  public void testhashcode() {
    book4 = new Book ("Beaches", pat, 2020, 6);
    assertEquals(book1.hashCode(), book4.hashCode());
    assertNotEquals(book1.hashCode(), book2.hashCode());
  }
    // FlowFound:BookTest did not cover the hashCode() method
    // FlowToDo:Cover the hashCode() method
    // FlowFixed:Covered the hashCode() method
}
