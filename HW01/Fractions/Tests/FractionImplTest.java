import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionImplTest {
    private FractionImpl fraction;
    private FractionImpl negative_denominator;
    private  FractionImpl fractionGCD;

    @Before
    public void setUp() throws Exception {
        fraction = new FractionImpl(3, 4);
        fractionGCD = new FractionImpl(15,6);
    }

    @Test
    public void testNegativeDenominator(){
        assertThrows(IllegalArgumentException.class,() ->{
            negative_denominator = new FractionImpl(3,-4);
        });
    }
    @Test
    public void testGetNominator() {
        assertEquals(3, fraction.getNominator());
    }

    @Test
    public void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testSetNominator() {
        fraction.setNominator(5);
        assertEquals(5, fraction.getNominator());
    }

    @Test
    public void testSetDenominator() {
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    public void testReciprocal() {
        double reciprocal = fraction.reciprocal();
        assertEquals(4.00 / 3.00, reciprocal, 0.001);
    }

    @Test
    public void testCompareTo() {
        FractionImpl other = new FractionImpl(1, 2);
        assertTrue(fraction.compareTo(other) > 0);
    }

    @Test
    public void testAdd() {
        FractionImpl other = new FractionImpl(1, 4);
        double result = fraction.add(other);
        assertEquals(1, result,0.001);
    }

    @Test
    public void testToDouble() {
        assertEquals(0.75, fraction.toDouble(), 0.0001);
    }

    @Test
    public void testToString(){
        String expected;
        expected = "5/2";
        assertEquals(expected,fractionGCD.toString());
    }
}
