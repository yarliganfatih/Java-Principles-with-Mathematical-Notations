package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import src.main.java.oop.math.depended_operations.Subtraction;
import src.main.java.oop.math.interfaces.Notation;

public class Multiplication extends Subtraction implements Notation {
    private List<Exponential> elements = new ArrayList<>();

    public List<Exponential> getElements(){
        return this.elements;
    }
    public void setElements(List<Exponential> elements){
        this.elements = elements;
    }

    public Multiplication() {

    }

    public Multiplication(Multiplication other) {
        this.mult(other);
    }

    public Multiplication(Exponential element) {
        elements.add(element);
    }
    
    public Multiplication reverse(){
        for (Exponential element : elements) {
            element._reverse();
        }
        return this;
    }
    public Multiplication _reverse(){
        return this.mult(-1);
    }
    
    @Override
        public Summation _add(Summation summation) {
            return new Summation(this).add(summation);
        }
    @Override
        public Summation _add(Multiplication multiplication) {
            return new Summation(this).add(multiplication);
        }
    public Summation _add(Exponential exponential) {
        return this._add(new Multiplication(exponential));
    }
    public Summation _add(Integer integerNumber) {
        return this._add(new Exponential(integerNumber));
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

    public Multiplication mult(Multiplication multiplication){
        elements.addAll(multiplication.getElements());
        return this;
    }
    public Multiplication mult(Exponential element) {
        elements.add(element);
        return this;
    }
    public Multiplication mult(Integer integer) {
        return this.mult(new Exponential(integer));
    }

    public Multiplication divi(Multiplication multiplication) {
        return this.mult(multiplication.reverse());
    }
    public Multiplication divi(Exponential element) {
        return this.mult(element._reverse());
    }
    public Multiplication divi(Integer integer) {
        return this.divi(new Exponential(integer));
    }

    public Multiplication _mult(Multiplication multiplication){
        return new Multiplication(this).mult(multiplication);
    }
    public Multiplication _mult(Exponential element) {
        return new Multiplication(this).mult(element);
    }
    public Multiplication _mult(Integer integer) {
        return this._mult(new Exponential(integer));
    }

    public Multiplication _divi(Multiplication multiplication) {
        return this._mult(multiplication.reverse());
    }
    public Multiplication _divi(Exponential element) {
        return this._mult(element._reverse());
    }
    public Multiplication _divi(Integer integer) {
        return this._divi(new Exponential(integer));
    }

    public double result() {
        double mult = 1;
        for (Exponential element : this.elements) {
            mult *= (double) element.result();
        }
        return mult;
    }

    public String toString() {
        List<String> out = new ArrayList<>();
        for (Exponential element : elements) {
            out.add("(" + element.toString() + ")");
        }
        return String.join(" x ", out);
    }
}
