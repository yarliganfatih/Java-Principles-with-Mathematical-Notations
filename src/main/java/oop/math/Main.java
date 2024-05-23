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

        e3.reverse();
        printNotation(e3);

        Exponential e4 = new Exponential(4, 1, 2);
        printNotation(e4);

        Exponential e4Clone = e4._sqrt(3);
        printNotation(e4Clone);
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

        m1.divi(new Exponential(3, 2));
        printNotation(m1);

        Multiplication m1Clone = m1._divi(5);
        printNotation(m1Clone);
        printNotation(m1);

        Multiplication m2 = new Multiplication(e1).mult(e3).mult(e4).mult(m1).mult(e5);
        printNotation(m2);

        Multiplication m2Clone = m2._mult(2);
        printNotation(m2Clone);
        printNotation(m2);

        Multiplication m3 = e5._divi(4);
        printNotation(m3);

        Summation s1 = new Summation(m1).add(m2).subt(11);
        printNotation(s1);

        Summation s2 = m2._add(e3).add(s1);
        printNotation(s2);

        Summation s2CloneAdded = new Summation(s2).add(7);
        printNotation(s2CloneAdded);
        printNotation(s2);

        printNotation(e4._add(e3).add(e5));
        printNotation(e4._subt(e3).subt(e5));
        printNotation(e4._subt(s1).subt(e1));

        Exponential e6 = new Exponential("√9");
        printNotation(e6);
        
        Exponential e7 = new Exponential("3^-2");
        printNotation(e7);

        Multiplication m4 = new Multiplication("√9 x 3^-2 x 3√27");
        printNotation(m4);
        
        Multiplication m5 = new Multiplication(e6.toString() + "x" + e7.toString() + " x 3√27");
        printNotation(m5);

        Summation s3 = new Summation("7 x 2 x 2^2 + 7 x 2 x " + m5.toString());
        printNotation(s3);
        
        Summation s4 = new Summation("7x2x2^2 + √9x4√16x7x2x3^(-2)x3√27");
        printNotation(s4);

        Summation s5 = new Summation("[(7) x (2) x (2^2)] + [(√9) x (4√16) x (7) x (2) x (3^-2) x (3√27)]");
        printNotation(s5);
        
        Summation s6 = new Summation(s5.add(m4).toString());
        printNotation(s6);
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
            Exponential e1 = new Exponential("0^-2"); // NOT ALLOWED
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
