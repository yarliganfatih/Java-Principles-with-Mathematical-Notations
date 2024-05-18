package src.main.java.oop.math.notations;

import src.main.java.oop.math.interfaces.Notation;

public class Exponential implements Notation {
    Integer base = 1;
    Rational exponent = new Rational(1);

    public Exponential() {

    }

    public Exponential(Integer base) {
        this.base = base;
    }

    public Exponential(Integer base, Rational exponent) {
        if (base == 0 && exponent.result() < 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        this.base = base;
        this.exponent = exponent;
    }

    public Exponential(Integer base, Integer power) {
        Rational exponent = new Rational(power);
        if (base == 0 && exponent.result() < 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        this.base = base;
        this.exponent = exponent;
    }

    public Exponential(Integer base, Integer power, Integer root) {
        Rational exponent = new Rational(power, root);
        if (base == 0 && exponent.result() < 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        this.base = base;
        this.exponent = exponent;
    }
    
    public Summation _add(Multiplication multiplication){
        Summation _summation = new Summation(new Multiplication(this));
        _summation.add(multiplication);
        return _summation;
    }

    public Multiplication _mult(Exponential exponential){
        Multiplication _multiplication = new Multiplication(this);
        _multiplication.mult(exponential);
        return _multiplication;
    }

    public void pow(Rational rational){
        this.exponent.mult(rational);
    }

    public double result() {
        return Math.pow((double) this.base, (double) this.exponent.result());
    }

    public String toString() {
        String out = "";
        if (this.exponent.denominator > 2)
            out += this.exponent.denominator.toString();
        if (this.exponent.denominator > 1)
            out += "√";
        out += this.base.toString();
        if (this.exponent.numerator != 1)
            out += "^" + this.exponent.numerator.toString();
        return out;
    }

    public static class Rational implements Notation {
        Integer numerator = 0;
        Integer denominator = 1;
    
        public Rational() {
        }
    
        public Rational(Integer numerator) {
            this.numerator = numerator;
        }
    
        public Rational(Integer numerator, Integer denominator) {
            this.numerator = numerator;
            if (denominator == 0)
                throw new IllegalArgumentException("Denominator cannot be zero.");
            this.denominator = denominator;
        }
        
        public void mult(Rational rational){
            this.numerator *= rational.numerator;
            this.denominator *= rational.denominator;
        }
    
        public double result() {
            return (double) this.numerator / (double) this.denominator;
        }
        
        public String toString() {
            if (this.denominator == 1)
                return this.numerator.toString();
            return this.numerator.toString() + "/" + this.denominator.toString();
        }
    }
}
