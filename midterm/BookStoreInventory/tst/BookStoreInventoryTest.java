import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit4 Class to test our Inventory of BookStoreItems
 */
public class BookStoreInventoryTest {
  BookStoreInventory myInventory;
  BookStoreItem book0, mag1, book2, book3;
  Person ben, john, seymour;

  /**
   * Create new Inventory with various BookStoreItems/authors, for testing
   */
  @Before
  public void setUp(){
    myInventory = new BookStoreInventory();
    john = new Person("John", "Steinbeck",1902);
    ben = new Person("Ben","Lerner",1982);
    seymour  = new Person("Seymour", "Papert", 1928);

    book0 = new Book ("Beaches", ben, 2020, 5.0);
    mag1 = new Magazine("Sunsets", ben, 2021, Month.NOVEMBER, 25.00);
    book2 = new Book("The Grapes of Wrath", john, 1939,  50.00 );
    book3 = new Book("Mindstorms", seymour, 1980, 10.00);

    myInventory = new BookStoreInventory();
    myInventory.addToInventory(book0);
    myInventory.addToInventory(mag1);
    myInventory.addToInventory(book2);
    myInventory.addToInventory(book3);
  }

  /**
   * Test addToInventory, getFromInventory, inventoryContains -- 3 related methods
   * <p>
   * Verifies adding BookStoreItems to the Inventory
   * More than one copy of a given publication may be added
   * Testing that these 3 methods work together consistently
   * Next few tests are closely related and use shared sample data
   */
  @Test
  public void testAddToInventory() {
    // book0 was the first one added
    assertEquals(book0, myInventory.getFromInventory(0));
    assertNotEquals(book0, mag1);
    myInventory.addToInventory(book0); // now also at index 4
    assertEquals(book0, myInventory.getFromInventory(4));
    assertTrue(myInventory.inventoryContains(mag1));
    assertEquals(myInventory.size(), 5);
    // System.out.println(myInventory); // for visual confirmation of sort by author last name
  }

  /**
   * Test getFromInventory with Index out of bounds exception
   * <p>
   * Verifying that these 3 methods work together consistently
   * Tests are closely related and share above sample data
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetFromInventoryException() {
    // Data above involved fewer than 6 BookStoreItems in the Inventory
    myInventory.getFromInventory(10);
  }

  /**
   * Test getFromInventory with valid index
   * <p>
   * Also verifying that the 3 methods work together consistently
   */
  @Test
  public void testGetFromInventory() {
    // Additional tests in related methods
    assertEquals(book2, myInventory.getFromInventory(2));
  }

  /**
   * Test method inventoryContains
   * <p>
   * Also ensuring behavior is consistent with above 2 methods
   */
  @Test
  public void testInventoryContains() {
    assertTrue(myInventory.inventoryContains(book2));
    Person nick = new Person("Nicholas", "Negroponte", 1943);
    BookStoreItem mag2 = new Magazine("Wired", nick, 2023, Month.JANUARY, 2.00);
    assertFalse(myInventory.inventoryContains(mag2));
  }

  /**
   * Test toString method for libraries using sample data defined above
   *
   * <p>
   * First print that it is an Inventory. Then,
   * print all BookStoreItems, separated by 5 dashes on separate line
   */
  @Test
  public void testToString() {
    String expected = "Inventory:"
        + "\n-----\n" + book0.toString() +
          "\n-----\n" + mag1.toString() +
          "\n-----\n" + book2.toString() +
          "\n-----\n" + book3.toString();
    assertEquals(expected, myInventory.toString());
  }

  /**
   * Test sortInventory method for Inventories using sample data defined above
   * <p>
   * Note that the sorted Inventory order is different from original ordering
   */
  @Test
  public void testSortInventory() {
    myInventory.sortInventory(new SortByAuthor());
    String expected = "Inventory:"
         + "\n-----\n" + book0.toString() +
           "\n-----\n" + mag1.toString() +
           "\n-----\n" + book3.toString() +
           "\n-----\n" + book2.toString() ;
    assertEquals(expected, myInventory.toString());
    System.out.println("Sorted by Author: \n" + expected);
   }
}
