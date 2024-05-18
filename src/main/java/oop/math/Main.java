package src.main.java.oop.math;

import src.main.java.oop.math.notations.*;

public class Main {
    public static void main(String[] args) {
        monitorize();
    }

    public static void monitorize() {
        // creating a object with constructors
        Exponential e1 = new Exponential();
        System.out.println(e1.toString() + " = " + e1.result());

        Exponential e2 = new Exponential(2);
        System.out.println(e2.toString() + " = " + e2.result());

        Exponential e3 = new Exponential(3, 2);
        System.out.println(e3.toString() + " = " + e3.result());

        Exponential e4 = new Exponential(4, 1, 2);
        System.out.println(e4.toString() + " = " + e4.result());
        
        // creating inner static class
        Exponential.Rational r1 = new Exponential.Rational(1, 2);
        System.out.println(r1.toString() + " = " + r1.result());

        Exponential e5 = new Exponential(9, r1);
        System.out.println(e5.toString() + " = " + e5.result());
        
        Multiplication m1 = new Multiplication();
        // calling object method
        m1.mult(e1);
        m1.mult(e2);
        System.out.println(m1.toString() + " = " + m1.result());

        Multiplication m2 = new Multiplication(e1);
        m2.mult(e3);
        m2.mult(e4);
        m2.mult(e5);
        System.out.println(m2.toString() + " = " + m2.result());

        Summation s1 = new Summation(m1);
        s1.add(m2);
        System.out.println(s1.toString() + " = " + s1.result());
    }
}
