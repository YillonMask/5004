import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit4 test Class for the Person class
 */
public class PersonTest {
  private Person john;
  private Person benlerner;
  private Person identicaltwin;

  /**
   *  Set up a few Persons to reuse in multiple tests
   */
  @Before
  public void setUp() {
    john = new Person("John", "Doe",1945);
    benlerner = new Person("Ben","Lerner",1982);
    identicaltwin = new Person("Ben","Lerner",1982);
  }

  /**
   * Verify that getFirstName returns value assigned by constructor
   */
  @Test
  public void testGetFirstName() {
    assertEquals("John", john.getFirstName());
    assertEquals("Ben", benlerner.getFirstName());
    assertNotEquals("Ben", john.getFirstName());
  }

  /**
   * Verify that getLastName returns value assigned by constructor
   */
  @Test
  public void getLastName() {
    assertEquals("Doe", john.getLastName());
    assertEquals("Lerner", benlerner.getLastName());
    assertNotEquals("Lerner", john.getLastName());
  }

  /**
   * Verify that getYearOfBirth returns value assigned by constructor
   */
  @Test
  public void testGetYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
    assertEquals(1982, benlerner .getYearOfBirth());
    assertNotEquals(1945, identicaltwin.getYearOfBirth());
  }

  /**
   * Verify that toString returns expected value of "firstName lastName"
   */
  @Test
  public void testToString() {
    assertEquals("John Doe", john.toString());
    assertEquals("Ben Lerner", benlerner.toString());
    assertNotEquals("John Doh!", john.toString());
  }

  /**
   * Verify that overridden equals method works as expected, depending on key fields
   * Creates several additional local Persons to supplement those defined above
   */
  @Test
  public void testEquals() {
    Person benaffleck = new Person("Ben","Affleck",1982);
    Person timlerner = new Person("Tim","Lerner",1982);
    Person anotherbenlerner = new Person("Ben","Lerner",1983);
    assertNotEquals(benlerner, benaffleck);
    assertNotEquals(benlerner, timlerner);
    assertNotEquals(benlerner, anotherbenlerner);
    assertEquals(benlerner, identicaltwin);
  }

  /**
   * Verify that overridden hashCode returns same int for equal Persons
   * Important to honor contract between equals and hashCode!
   */
  @Test
  public void testHashCode() {
    // NB: Two different Persons might hash to the same integer.
    // Hence, no negative tests, despite this be
    assertEquals(benlerner, identicaltwin);
    assertEquals(benlerner, benlerner);
  }
}
