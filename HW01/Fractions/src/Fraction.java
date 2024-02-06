/**
 * The Fraction interface represents a fraction and provides methods for
 * performing operations on fractions.
 */
public interface Fraction extends Comparable<Fraction> {
    /**
     * Converts the fraction to a double value.
     *
     * @return the fraction as a double value
     */
    double toDouble();

    /**
     * Returns a string representation of the fraction.
     *
     * @return a string representation of the fraction
     */
    String toString();

    /**
     * Returns the reciprocal of the fraction.
     *
     * @return the reciprocal of the fraction
     */
    double reciprocal();

    /**
     * Adds another fraction to the current fraction.
     *
     * @param other the fraction to be added
     * @return the sum of the two fractions
     */
    double add(Fraction other);

    /**
     * Compares the current fraction with another fraction.
     *
     * @param other the fraction to be compared
     * @return a negative integer, zero, or a positive integer if the current
     *         fraction is less than, equal to, or greater than the other fraction
     */
    int compareTo(Fraction other);

    /**
     * Returns the numerator of the fraction.
     *
     * @return the numerator of the fraction
     */
    int getNominator();

    /**
     * Sets the numerator of the fraction.
     *
     * @param nominator the new numerator value
     */
    void setNominator(int nominator);

    /**
     * Returns the denominator of the fraction.
     *
     * @return the denominator of the fraction
     */
    int getDenominator();

    /**
     * Sets the denominator of the fraction.
     *
     * @param denominator the new denominator value
     */
    void setDenominator(int denominator);

    /**
     * Returns the fraction as a double value.
     *
     * @return the fraction as a double value
     */
    double getFraction();
}
