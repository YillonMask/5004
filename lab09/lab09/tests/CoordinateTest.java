import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {
    @Test
    public void testEquals() {
        Coordinate coord1 = new Coordinate(5, 10);
        Coordinate coord2 = new Coordinate(5, 10);
        assertTrue(coord1.equals(coord2));
        Coordinate coord3 = new Coordinate(5, 10);
        Coordinate coord4 = new Coordinate(10, 5);
        assertFalse(coord3.equals(coord4));
        Coordinate coord5 = new Coordinate(5, 10);
        Coordinate coord6 = null;
        assertFalse(coord5.equals(coord6));
    }
}
