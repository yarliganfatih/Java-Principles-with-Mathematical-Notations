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
        
        Exponential e5Clone = new Exponential(e5);
        printNotation(e5Clone);

        e5Clone.pow(3);
        printNotation(e5Clone);
        printNotation(e5);
        
        Multiplication m1 = new Multiplication().mult(e1).mult(7).mult(e2);
        printNotation(m1);

        Multiplication m2 = new Multiplication(e1).mult(e3).mult(e4).mult(m1).mult(e5);
        printNotation(m2);

        Multiplication m2Clone = m2._mult(2);
        printNotation(m2Clone);
        printNotation(m2);

        Summation s1 = new Summation(m1).add(m2);
        printNotation(s1);

        Summation s2 = m2._add(e3).add(s1);
        printNotation(s2);

        Summation s2CloneAdded = new Summation(s2).add(7);
        printNotation(s2CloneAdded);
        printNotation(s2);

        printNotation(e4._add(e3).add(e5));
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
            e2.pow(new Exponential.Rational(-1)); // NOT ALLOWED
            printNotation(e2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Exponential e2 = new Exponential(3, 1);
            printNotation(e2);
            // If attribute's access modifier is public then we can assign
            e2.getExponent().setDenominator(0); // NOT ALLOWED
            printNotation(e2);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
