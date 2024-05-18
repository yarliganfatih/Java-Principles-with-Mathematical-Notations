package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

public class Multiplication {
    List<Exponential> elements = new ArrayList<>();

    public Multiplication() {

    }

    public Multiplication(Exponential element) {
        elements.add(element);
    }
    
    public Summation _add(Multiplication multiplication) {
        Summation _summation = new Summation(this);
        _summation.add(multiplication);
        return _summation;
    }

    public void mult(Exponential element) {
        elements.add(element);
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
            out.add(element.toString());
        }
        return String.join(" x ", out);
    }
}
