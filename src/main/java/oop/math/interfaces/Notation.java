package oop.math.interfaces;

import oop.math.notations.Exponential;
import oop.math.notations.Multiplication;
import oop.math.notations.Summation;

public interface Notation {
    public double result();
    public String toString();

    public static Notation interpret(String expression){
        if(expression.contains(Summation.symbol)) return new Summation(expression);
        if(expression.contains(Multiplication.symbol)) return new Multiplication(expression);
        return new Exponential(expression);
    }
}
