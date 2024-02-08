import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyNodeTest {

    private IListOfInts emptyNode;

    @Before
    public void setUp() throws Exception {
        emptyNode = new EmptyNode();
    }

    @Test
    public void testPrepend() {
        IListOfInts updatedList = emptyNode.prepend(5);
        assertEquals("5", updatedList.toString());
    }

    @Test
    public void testAppend() {
        IListOfInts updatedList = emptyNode.append(10);
        assertEquals("10", updatedList.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertAtIndexInvalidIndex() {
        emptyNode.insertAtIndex(7, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDataAtIndexInvalidIndex() {
        emptyNode.getDataAtIndex(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRestEmptyList() {
        emptyNode.getRest();
    }

    @Test
    public void testGetCount() {
        int count = emptyNode.getCount();
        assertEquals(0, count);
    }

    @Test
    public void testGetSum() {
        int sum = emptyNode.getSum();
        assertEquals(0, sum);
    }

    @Test
    public void testToString() {
        String str = emptyNode.toString();
        assertEquals("", str);
    }
}