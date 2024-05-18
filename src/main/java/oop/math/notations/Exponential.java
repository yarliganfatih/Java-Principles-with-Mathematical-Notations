package src.main.java.oop.math.notations;

import src.main.java.oop.math.interfaces.Notation;

public class Exponential implements Notation {
    private Integer base = 1;
    private Rational exponent = new Rational(1);

    public Integer getBase(){
        return this.base;
    }
    public void setBase(Integer base){
        if (base == 0 && this.getExponent().result() < 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        this.base = base;
    }

    public Rational getExponent(){
        return this.exponent;
    }
    public void setExponent(Rational exponent){
        if (this.getBase() == 0 && exponent.result() < 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        this.exponent = exponent;
    }

    public Exponential() {

    }

    public Exponential(Integer base) {
        this.setBase(base);
    }

    public Exponential(Integer base, Rational exponent) {
        this.setBase(base);
        this.setExponent(exponent);
    }

    public Exponential(Integer base, Integer power) {
        this.setBase(base);
        this.setExponent(new Rational(power));
    }

    public Exponential(Integer base, Integer power, Integer root) {
        this.setBase(base);
        this.setExponent(new Rational(power, root));
    }
    
    public Summation _add(Summation summation){
        Summation _summation = new Summation(new Multiplication(this));
        _summation.add(summation);
        return _summation;
    }
    public Summation _add(Multiplication multiplication){
        Summation _summation = new Summation(new Multiplication(this));
        _summation.add(multiplication);
        return _summation;
    }
    public Summation _add(Exponential exponential){
        return this._add(new Multiplication(exponential));
    }
    public Summation _add(Integer integer){
        return this._add(new Exponential(integer));
    }

    public Multiplication _mult(Multiplication multiplication){
        Multiplication _multiplication = new Multiplication(this);
        _multiplication.mult(multiplication);
        return _multiplication;
    }
    public Multiplication _mult(Exponential exponential){
        Multiplication _multiplication = new Multiplication(this);
        _multiplication.mult(exponential);
        return _multiplication;
    }
    public Multiplication _mult(Integer integer){
        return this._mult((new Exponential(integer)));
    }

    public void pow(Rational rational){
        rational.mult(this.getExponent());
        this.setExponent(rational);
    }
    public void pow(Integer integer){
        this.exponent.mult(integer);
    }

    public double result() {
        return Math.pow((double) this.getBase(), (double) this.exponent.result());
    }

    public String toString() {
        String out = "";
        if (this.getExponent().getDenominator() > 2)
            out += this.getExponent().getDenominator().toString();
        if (this.getExponent().getDenominator() > 1)
            out += "√";
        out += this.getBase().toString();
        if (this.getExponent().getNumerator() != 1)
            out += "^" + this.getExponent().getNumerator().toString();
        return out;
    }

    public static class Rational implements Notation {
        private Integer numerator = 0;
        private Integer denominator = 1;
    
        public Integer getNumerator(){
            return this.numerator;
        }
        public void setNumerator(Integer numerator){
            this.numerator = numerator;
        }

        public Integer getDenominator(){
            return this.denominator;
        }
        public void setDenominator(Integer denominator){
            if (denominator == 0)
                throw new IllegalArgumentException("Denominator cannot be zero.");
            this.denominator = denominator;
        }

        public Rational() {
        }
    
        public Rational(Integer numerator) {
            this.setNumerator(numerator);
        }
    
        public Rational(Integer numerator, Integer denominator) {
            this.setNumerator(numerator);
            this.setDenominator(denominator);
        }
        
        public void mult(Rational rational){
            this.setNumerator(this.getNumerator() * rational.getNumerator());
            this.setDenominator(this.getDenominator() * rational.getDenominator());
        }
        public void mult(Integer integer){
            this.setNumerator(this.getNumerator() * integer);
        }
    
        public double result() {
            return (double) this.getNumerator() / (double) this.getDenominator();
        }
        
        public String toString() {
            if (this.getDenominator() == 1)
                return this.getNumerator().toString();
            return this.getNumerator().toString() + "/" + this.getDenominator().toString();
        }
    }
}
