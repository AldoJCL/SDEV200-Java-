package Module2.Exercise13_15;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    // no-arg constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // constructor for regular long values
    public Rational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    // constructor for BigInteger values
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        // keep the negative sign on the numerator only
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }

        BigInteger gcd = numerator.gcd(denominator);

        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    // return numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // add a rational number
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator()));

        BigInteger d = denominator.multiply(secondRational.getDenominator());

        return new Rational(n, d);
    }

    // subtract a rational number
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));

        BigInteger d = denominator.multiply(secondRational.getDenominator());

        return new Rational(n, d);
    }

    // multiply a rational number
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());

        return new Rational(n, d);
    }

    // divide a rational number
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());

        return new Rational(n, d);
    }

    // return rational as string
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        }
        else {
            return numerator + "/" + denominator;
        }
    }

    // checks if two rational numbers are equal
    @Override
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            return this.subtract((Rational) other).getNumerator().equals(BigInteger.ZERO);
        }

        return false;
    }

    // required by Number
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    // required by Number
    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    // required by Number
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    // required by Number
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // compare two rational numbers
    @Override
    public int compareTo(Rational o) {
        return this.subtract(o).getNumerator().compareTo(BigInteger.ZERO);
    }
}