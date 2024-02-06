/**
 * Implementation of the Fraction interface.
 */
public class FractionImpl implements Fraction {
    private int nominator;
    private int denominator;

    /**
     * Constructs a FractionImpl object with the given nominator and denominator.
     * 
     * @param nominator   the nominator of the fraction
     * @param denominator the denominator of the fraction
     * @throws IllegalArgumentException if the denominator is negative
     */
    public FractionImpl(int nominator, int denominator) throws IllegalArgumentException {
        this.nominator = nominator;
        this.denominator = denominator;
        if (this.denominator < 0) {
            throw new IllegalArgumentException("denominator should always be positive");
        }
    }

    /**
     * Returns the nominator of the fraction.
     * 
     * @return the nominator of the fraction
     */
    @Override
    public int getNominator() {
        return this.nominator;
    }

    /**
     * Returns the denominator of the fraction.
     * 
     * @return the denominator of the fraction
     */
    @Override
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Returns the fraction as a double value.
     * 
     * @return the fraction as a double value
     */
    @Override
    public double getFraction() {
        return (double) nominator / denominator;
    }

    /**
     * Sets the nominator of the fraction.
     * 
     * @param nominator the new nominator value
     */
    @Override
    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    /**
     * Sets the denominator of the fraction.
     * 
     * @param denominator the new denominator value
     */
    @Override
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Returns the reciprocal of the fraction.
     * 
     * @return the reciprocal of the fraction
     */
    @Override
    public double reciprocal() {
        if (this.toDouble() == 0)
            return 0.00;
        else {
            return (double) 1 / this.toDouble();
        }
    }

    /**
     * Compares this fraction with another fraction.
     * 
     * @param other the fraction to compare with
     * @return 1 if this fraction is greater than the other fraction,
     *         -1 if this fraction is less than the other fraction,
     *         0 if this fraction is equal to the other fraction
     */
    @Override
    public int compareTo(Fraction other) {
        double fractionThis = this.toDouble();
        double fractionOther = other.toDouble();

        if (fractionOther < fractionThis) {
            return 1;
        } else if (fractionOther > fractionThis) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Adds another fraction to this fraction and returns the result as a double
     * value.
     * 
     * @param other the fraction to add
     * @return the result of adding the other fraction to this fraction as a double
     *         value
     */
    @Override
    public double add(Fraction other) {
        return other.toDouble() + this.toDouble();
    }

    /**
     * Converts the fraction to a double value.
     * 
     * @return the fraction as a double value
     */
    @Override
    public double toDouble() {
        return (double) this.nominator / this.denominator;
    }

    public String toString(){
        int gcd = gcd(this.nominator,this.denominator);
        return String.format("%d/%d",this.getNominator() / gcd,this.getDenominator() / gcd);
    }

    static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }
}
