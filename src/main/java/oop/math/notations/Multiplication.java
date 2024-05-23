package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

import src.main.java.oop.math.interfaces.Mult_Layer;
import src.main.java.oop.math.interfaces.Notation;
import src.main.java.oop.math.interfaces.Sum_Layer;

public class Multiplication implements Notation, Sum_Layer, Mult_Layer {
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
    
    public Multiplication(String expression) {
        expression = expression.replaceAll("[ ()]", "");
        String[] parts = expression.split("x");
        for(String part : parts){
            elements.add(new Exponential(part));
        }
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
    
    public Multiplication mult(Mult_Layer multiParam){
        elements.addAll(multiParam.toMultiplication().getElements());
        return this;
    }
    public Multiplication mult(Integer integer) {
        return this.mult(new Exponential(integer));
    }

    public Multiplication divi(Mult_Layer multiParam) {
        return this.mult(multiParam.toMultiplication().reverse());
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
