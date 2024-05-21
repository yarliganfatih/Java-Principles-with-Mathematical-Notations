package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import src.main.java.oop.math.depended_operations.Division;
import src.main.java.oop.math.interfaces.Notation;

public class Multiplication extends Division implements Notation {
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
