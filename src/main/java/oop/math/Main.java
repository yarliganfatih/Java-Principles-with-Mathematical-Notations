package src.main.java.oop.math;

import src.main.java.oop.math.interfaces.Notation;
import src.main.java.oop.math.notations.*;

public class Main {
    public static void main(String[] args) {
        monitorize();
        errorCatching();
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

    public static void errorCatching(){
        try {
            Exponential.Rational r1 = new Exponential.Rational(1, 0); // NOT ALLOWED
            printNotation(r1);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Exponential e1 = new Exponential(0, -1); // NOT ALLOWED
            printNotation(e1);
        } catch (Exception e) {
            System.err.println(e);
        }
        
        try {
            Exponential e2 = new Exponential(0, 2);
            printNotation(e2);
            e2.pow(new Exponential.Rational(-1)); // SHOULD BE NOT ALLOWED
            printNotation(e2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Exponential e2 = new Exponential(3, 1);
            printNotation(e2);
            // If attribute's access modifier is public then we can assign
            e2.exponent.denominator = 0; // SHOULD BE NOT ALLOWED
            printNotation(e2);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
