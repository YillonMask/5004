import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A few quick JUnit4 tests for Month enum
 * <p>
 * Not usually necessary for enums but never hurts to test
 */
public class MonthTest {

  /**
   * Verifies that the values() method works as advertised for Months
   */
  @Test
  public void values() {
    assertEquals(Month.DECEMBER, Month.values()[11]);
  }

  /**
   * Verifies that the valueOf() method works as advertised for Months
   */
  @Test
  public void valueOf() {
    assertEquals(Month.JANUARY, Month.valueOf ("JANUARY"));
  }
}