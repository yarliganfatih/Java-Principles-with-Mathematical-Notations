package oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import oop.math.interfaces.Notation;
import oop.math.interfaces.Sum_Layer;

public class Summation implements Notation, Sum_Layer {
    public static final String symbol = "+";
    private List<Multiplication> elements = new ArrayList<>();

    public List<Multiplication> getElements(){
        return this.elements;
    }
    public void setElements(List<Multiplication> elements){
        this.elements = elements;
    }

    public Summation() {

    }

    public Summation(Summation other) {
        this.elements = new ArrayList<>();
        for (Multiplication m : other.getElements()) {
            this.elements.add(new Multiplication(m));
        }
    }

    public Summation(Multiplication element) {
        elements.add(element);
    }

    public Summation(String expression) {
        expression = expression.replaceAll("[ \\[\\]]", "");
        String[] parts = expression.split("\\" + Summation.symbol);
        for(String part : parts){
            elements.add(new Multiplication(part));
        }
    }

    public Summation reverse(){
        for (Multiplication element : elements) {
            element._reverse();
        }
        return this;
    }

    public Summation add(Sum_Layer multiParam){
        elements.addAll(multiParam.toSummation().getElements());
        return this;
    }
    public Summation add(Integer integer) {
        return this.add(new Exponential(integer));
    }

    public Summation subt(Sum_Layer multiParam){
        Summation other = new Summation(multiParam.toSummation());
        return this.add(other.reverse());
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
        return String.join(" " + Summation.symbol + " ", out);
    }
}