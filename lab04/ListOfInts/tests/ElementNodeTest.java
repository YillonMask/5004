import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementNodeTest {

  private IListOfInts list;

  @Before
  public void setUp() throws Exception {
    // Create a sample linked list for testing
    list = new ElementNode(1, new ElementNode(2, new ElementNode(3, null)));
  }

  @Test
  public void prepend() {
    list = list.prepend(0);
    assertEquals("0 -> 1 -> 2 -> 3", list.toString());
  }

  @Test
  public void append() {
    list = list.append(4);
    assertEquals("1 -> 2 -> 3 -> 4", list.toString());
  }

  @Test
  public void insertAtIndex() {
    list = list.insertAtIndex(0, 0);
    assertEquals("0 -> 1 -> 2 -> 3", list.toString());

    list = list.insertAtIndex(5, 4);
    assertEquals("0 -> 1 -> 2 -> 3 -> 5", list.toString());

    list = list.insertAtIndex(4, 4);
    assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5", list.toString());
  }

  @Test
  public void getDataAtIndex() {
    assertEquals(1, list.getDataAtIndex(0));
    assertEquals(2, list.getDataAtIndex(1));
    assertEquals(3, list.getDataAtIndex(2));
  }

  @Test
  public void getRest() {
    IListOfInts rest = list.getRest();
    assertEquals("2 -> 3", rest.toString());
  }

  @Test
  public void getCount() {
    assertEquals(3, list.getCount());
  }

  @Test
  public void getSum() {
    assertEquals(6, list.getSum());
  }

  @Test
  public void testToString() {
    assertEquals("1 -> 2 -> 3", list.toString());
  }
}
