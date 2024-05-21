package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import src.main.java.oop.math.interfaces.Notation;
import src.main.java.oop.math.interfaces.Sum_Layer;

public class Summation implements Notation, Sum_Layer {
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
        this.add(other);
    }

    public Summation(Multiplication element) {
        elements.add(element);
    }

    public Summation reverse(){
        for (Multiplication element : elements) {
            element._reverse();
        }
        return this;
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

    public Summation subt(Summation summation){
        return this.add(summation.reverse());
    }
    public Summation subt(Multiplication element) {
        return this.add(element._reverse());
    }
    public Summation subt(Exponential exponential) {
        return this.subt(new Multiplication(exponential));
    }
    public Summation subt(Integer integer) {
        return this.subt(new Exponential(integer));
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
            out.add("[" + element.toString() + "]");
        }
        return String.join(" + ", out);
    }
}