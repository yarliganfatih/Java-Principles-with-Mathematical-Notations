package oop.math.notations;

import oop.math.interfaces.Mult_Layer;
import oop.math.interfaces.Notation;
import oop.math.interfaces.Sum_Layer;

public class Exponential implements Notation, Sum_Layer, Mult_Layer {
    private Integer base = 1;
    public static final String symbol = "^";
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
    
    public Exponential(String expression) {
        expression = expression.replaceAll("[ ()]", "");
        
        Integer _root = this.exponent.getDenominator();
        Integer _base = this.base;
        Integer _power = this.exponent.getNumerator();

        String[] parts = expression.split("√");
        if (parts.length == 2) {
            _root = !parts[0].isEmpty() ? Integer.parseInt(parts[0]) : 2;
            parts[0] = parts[1]; // to use below for base
        }
        String[] subParts = parts[0].split("\\" + Exponential.symbol);
        _base = Integer.parseInt(subParts[0]);
        if (subParts.length == 2) {
            _power = Integer.parseInt(subParts[1]);
        }

        this.setBase(_base);
        this.setExponent(new Rational(_power, _root));
    }
    
    public Exponential reverse(){
        this.setExponent(this.getExponent()._reverse());
        return this;
    }
    public Exponential _reverse(){
        return this.pow(-1);
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
            out += Exponential.symbol + this.getExponent().getNumerator().toString();
        return out;
    }

    public static class Rational implements Notation {
        private Integer numerator = 0;
        public static final String symbol = "/";
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
            return this.getNumerator().toString() + Rational.symbol + this.getDenominator().toString();
        }
    }
}
