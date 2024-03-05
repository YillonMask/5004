import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit4 test Class for Magazine
 */
public class MagazineTest {
  private Person pat;
  private Person john;
  private Magazine mag1;
  private Magazine mag2;
  private Magazine mag3;
  private Magazine mag4 ;

  /**
   * Set up examples of  Persons and Magazines to use in testing
   */
  @Before
  public void setUp() {
    pat = new Person("Pat", "Conroy", 1948);
    john = new Person("John", "Steinbeck", 1902);
    mag1 = new Magazine("Beaches Issue", pat, 2020,
        Month.MARCH, 5.0);
    mag2 = new Magazine("Sunsets Issue", pat, 2021,
        Month.SEPTEMBER, 2.50);
    mag3 = new Magazine("The Grapes of July", john, 1939,
        Month.JULY, 2.00);
    mag4 = new Magazine("Beaches Issue", pat, 2020,
            Month.MARCH, 25.0);
  }

  @Test
  public void testToString() {
    String expected;
    expected = """
        Kind: Magazine
        Title: Beaches Issue
        Author: Pat Conroy
        Year: 2020
        Month: MARCH
        Price: 5.00""";
    assertEquals(expected, mag1.toString());
    assertNotEquals(expected, mag2.toString());
  }

    @Test
    public void testSameAuthor() {
      assertEquals(true, mag1.sameAuthor(mag2));
      assertEquals(false, mag1.sameAuthor(mag3));
    }
    //FlowFound: Test did not cover sameAuthor method
    //FlowToDo: Cover the sameAuthor method
    //FlowFixed: Covered the sameAuthor method

    @Test
    public void testequals() {
      assertEquals(true, mag1.equals(mag4));
      assertEquals(false, mag1.equals(mag2));
    }
    //FlowFound: Test did not cover equals method
    //FlowToDo: Cover the equals method
    //FlowFixed: Covered the equals method

  @Test
  public void testhashcode(){
    assertEquals(mag1.hashCode(), mag4.hashCode());
    assertNotEquals(mag1.hashCode(), mag2.hashCode());
  }
    //FlowFound: Test did not cover hashcode method
    //FlowToDo: Cover the hashcode method
    //FlowFixed: Covered the hashcode method

  @Test
    public void testGetMonth() {
        assertEquals(Month.MARCH, mag1.getMonth());
        assertEquals(Month.SEPTEMBER, mag2.getMonth());
    }
    //FlowFound: Test did not cover getMonth method
    //FlowToDo: Cover the getMonth method
    //FlowFixed: Covered the getMonth method
}