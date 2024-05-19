package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import src.main.java.oop.math.interfaces.Notation;

public class Summation implements Notation {
    private List<Multiplication> elements = new ArrayList<>();

    public List<Multiplication> getElements(){
        return this.elements;
    }
    public void setElements(List<Multiplication> elements){
        this.elements = elements;
    }

    public Summation() {

    }

    public Summation(Summation other){
        this.setElements(other.getElements());
    }

    public Summation(Multiplication element) {
        elements.add(element);
    }

    public Summation add(Summation summation){
        elements.addAll(summation.getElements());
        return this;
    }
    public Summation add(Multiplication element) {
        elements.add(element);
        return this;
    }
    public Summation add(Exponential exponential) {
        return this.add(new Multiplication(exponential));
    }
    public Summation add(Integer integer) {
        return this.add(new Exponential(integer));
    }

    public Summation _add(Summation summation){
        return new Summation(this).add(summation);
    }
    public Summation _add(Multiplication element) {
        return new Summation(this).add(element);
    }
    public Summation _add(Exponential exponential) {
        return this._add(new Multiplication(exponential));
    }
    public Summation _add(Integer integer) {
        return this._add(new Exponential(integer));
    }

    public double result() {
        double sum = 0;
        for (Multiplication element : this.elements) {
            sum += (double) element.result();
        }
        return sum;
    }

    public String toString() {
        List<String> out = new ArrayList<>();
        for (Multiplication element : elements) {
            out.add(element.toString());
        }
        return String.join(" + ", out);
    }
}