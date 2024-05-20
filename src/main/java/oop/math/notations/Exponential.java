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

    public Exponential(Exponential other) {
        this.setBase(other.getBase());
        this.setExponent(new Rational(other.getExponent()));
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
    
    public Exponential reverse(){
        this.setExponent(this.getExponent()._reverse());
        return this;
    }
    public Exponential _reverse(){
        return this.pow(-1);
    }
    
    public Summation _add(Summation summation){
        return new Summation(new Multiplication(this)).add(summation);
    }
    public Summation _add(Multiplication multiplication){
        return new Summation(new Multiplication(this)).add(multiplication);
    }
    public Summation _add(Exponential exponential){
        return this._add(new Multiplication(exponential));
    }
    public Summation _add(Integer integer){
        return this._add(new Exponential(integer));
    }

    public Summation _subt(Summation summation) {
        return this._add(summation.reverse());
    }
    public Summation _subt(Multiplication element) {
        return this._add(element._reverse());
    }
    public Summation _subt(Exponential exponential) {
        return this._subt(new Multiplication(exponential));
    }
    public Summation _subt(Integer integer) {
        return this._subt(new Exponential(integer));
    }

    public Multiplication _mult(Multiplication multiplication){
        return new Multiplication(this).mult(multiplication);
    }
    public Multiplication _mult(Exponential exponential){
        return new Multiplication(this).mult(exponential);
    }
    public Multiplication _mult(Integer integer){
        return this._mult((new Exponential(integer)));
    }

    public Multiplication _divi(Multiplication multiplication) {
        return this._mult(multiplication.reverse());
    }
    public Multiplication _divi(Exponential exponential){
        return this._mult(exponential._reverse());
    }
    public Multiplication _divi(Integer integer){
        return this._divi((new Exponential(integer)));
    }

    public Exponential pow(Rational rational){
        this.setExponent(this.getExponent().mult(rational));
        return this;
    }
    public Exponential pow(Integer integer){
        this.exponent.mult(integer);
        return this;
    }

    public Exponential sqrt(Rational rational){
        return this.pow(rational._reverse());
    }
    public Exponential sqrt(Integer integer){
        return this.sqrt(new Rational(integer));
    }

    public Exponential _pow(Rational rational){
        Exponential clone = new Exponential(this);
        clone.setExponent(clone.getExponent().mult(rational));
        return clone;
    }
    public Exponential _pow(Integer integer){
        Exponential clone = new Exponential(this);
        clone.exponent.mult(integer);
        return clone;
    }

    public Exponential _sqrt(Rational rational){
        return this._pow(rational._reverse());
    }
    public Exponential _sqrt(Integer integer){
        return this._sqrt(new Rational(integer));
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

        public Rational(Rational other){
            this.setNumerator(other.getNumerator());
            this.setDenominator(other.getDenominator());
        }
    
        public Rational(Integer numerator) {
            this.setNumerator(numerator);
        }
    
        public Rational(Integer numerator, Integer denominator) {
            this.setNumerator(numerator);
            this.setDenominator(denominator);
        }

        public Rational _reverse(){
            Integer inMemory = this.getNumerator();
            this.setNumerator(this.getDenominator());
            this.setDenominator(inMemory);
            return this;
        }
        
        public Rational mult(Rational rational){
            this.setNumerator(this.getNumerator() * rational.getNumerator());
            this.setDenominator(this.getDenominator() * rational.getDenominator());
            return this;
        }
        public Rational mult(Integer integer){
            this.setNumerator(this.getNumerator() * integer);
            return this;
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
