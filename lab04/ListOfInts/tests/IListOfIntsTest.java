import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IListOfIntsTest {

    private IListOfInts list;

    @Before
    public void setUp() throws Exception {
        list = new ListOfInts();
    }

    @Test
    public void prepend() {
        list = list.prepend(1);
        assertEquals(1, list.getDataAtIndex(0));
        assertEquals(1, list.getCount());
    }

    @Test
    public void append() {
        list = list.append(2);
        assertEquals(2, list.getDataAtIndex(0));
        assertEquals(1, list.getCount());
    }

    @Test
    public void insertAtIndex() {
        list = list.insertAtIndex(3, 0);
        assertEquals(3, list.getDataAtIndex(0));
        assertEquals(1, list.getCount());
    }

    @Test
    public void getDataAtIndex() {
        list = list.prepend(4);
        assertEquals(4, list.getDataAtIndex(0));
    }

    @Test
    public void getRest() {
        list = list.prepend(5).prepend(6);
        IListOfInts rest = list.getRest();
        assertEquals(5, rest.getDataAtIndex(0));
        assertEquals(1, rest.getCount());
    }

    @Test
    public void getCount() {
        list = list.prepend(7).prepend(8).prepend(9);
        assertEquals(3, list.getCount());
    }

    @Test
    public void getSum() {
        list = list.prepend(10).prepend(11).prepend(12);
        assertEquals(33, list.getSum());
    }

    @Test
    public void testToString() {
        list = list.prepend(13).prepend(14).prepend(15);
        assertEquals("[15, 14, 13]", list.toString());
    }
}