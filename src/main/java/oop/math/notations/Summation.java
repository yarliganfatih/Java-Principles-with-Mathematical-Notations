package src.main.java.oop.math.notations;

import java.util.ArrayList;
import java.util.List;

public class Summation {
    List<Multiplication> elements = new ArrayList<>();

    public Summation() {

    }

    public Summation(Multiplication element) {
        elements.add(element);
    }

    public void add(Multiplication element) {
        elements.add(element);
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