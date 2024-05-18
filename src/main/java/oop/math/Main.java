package src.main.java.oop.math;

import src.main.java.oop.math.interfaces.Notation;
import src.main.java.oop.math.notations.*;

public class Main {
    public static void main(String[] args) {
        monitorize();
    }

    public static void printNotation(Notation n){
        System.out.println(n.toString() + " = " + n.result());
    }

    public static void monitorize() {
        // creating a object with constructors
        Exponential e1 = new Exponential();
        printNotation(e1);

        Exponential e2 = new Exponential(2);
        printNotation(e2);

        Exponential e3 = new Exponential(3, 2);
        printNotation(e3);

        Exponential e4 = new Exponential(4, 1, 2);
        printNotation(e4);
        
        // creating inner static class
        Exponential.Rational r1 = new Exponential.Rational(1, 2);
        printNotation(r1);

        Exponential e5 = new Exponential(9, r1);
        printNotation(e5);
        
        Multiplication m1 = new Multiplication();
        // calling object method
        m1.mult(e1);
        m1.mult(e2);
        printNotation(m1);

        Multiplication m2 = new Multiplication(e1);
        m2.mult(e3);
        m2.mult(e4);
        m2.mult(e5);
        printNotation(m2);

        Summation s1 = new Summation(m1);
        s1.add(m2);
        printNotation(s1);
    }
}
