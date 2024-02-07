
/**
 * This class contains unit tests for the FractionImpl class.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionImplTest {
    private FractionImpl fraction;
    private FractionImpl negative_denominator;
    private FractionImpl fractionGCD;

    @Before
    public void setUp() throws Exception {
        fraction = new FractionImpl(3, 4);
        fractionGCD = new FractionImpl(15, 6);
    }

    /**
     * Test case to verify that an IllegalArgumentException is thrown when the
     * denominator is negative.
     */
    @Test
    public void testNegativeDenominator() {
        assertThrows(IllegalArgumentException.class, () -> {
            negative_denominator = new FractionImpl(3, -4);
        });
    }

    /**
     * Test case to verify the getNominator() method.
     */
    @Test
    public void testGetNominator() {
        assertEquals(3, fraction.getNominator());
    }

    /**
     * Test case to verify the getDenominator() method.
     */
    @Test
    public void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    /**
     * Test case to verify the setNominator() method.
     */
    @Test
    public void testSetNominator() {
        fraction.setNominator(5);
        assertEquals(5, fraction.getNominator());
    }

    /**
     * Test case to verify the setDenominator() method.
     */
    @Test
    public void testSetDenominator() {
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    /**
     * Test case to verify the reciprocal() method.
     */
    @Test
    public void testReciprocal() {
        Fraction reciprocal = fraction.reciprocal();
        assertEquals(4, reciprocal.getNominator());
        assertEquals(3, reciprocal.getDenominator());
    }

    @Test
    public void testZeroReciprocal(){
        Fraction zeroReciprocal = new FractionImpl(0,8);
        assertThrows(ArithmeticException.class, zeroReciprocal::reciprocal);
    }

    @Test
    public void testNegativeReciprocal(){
        Fraction negative = new FractionImpl(-1,8);
        Fraction negativeReciprocal = negative.reciprocal();
        assertEquals(-8,negativeReciprocal.getNominator());
        assertEquals(1,negativeReciprocal.getDenominator());
    }

    /**
     * Test case to verify the compareTo() method.
     */
    @Test
    public void testCompareTo() {
        FractionImpl other = new FractionImpl(1, 2);
        assertTrue(fraction.compareTo(other) > 0);
    }

    /**
     * Test case to verify the add() method.
     */
    @Test
    public void testAdd() {
        FractionImpl other = new FractionImpl(1, 3);
        Fraction result = fraction.add(other);
        assertEquals(13, result.getNominator());
        assertEquals(12, result.getDenominator());
    }

    /**
     * Test case to verify the toDouble() method.
     */
    @Test
    public void testToDouble() {
        assertEquals(0.75, fraction.toDouble(), 0.0001);
    }

    /**
     * Test case to verify the toString() method.
     */
    @Test
    public void testToString() {
        String expected;
        expected = "5/2";
        assertEquals(expected, fractionGCD.toString());
    }
}
