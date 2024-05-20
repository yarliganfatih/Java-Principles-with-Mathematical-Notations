package src.main.java.oop.math.depended_operations;

import src.main.java.oop.math.notations.Multiplication;
import src.main.java.oop.math.notations.Summation;

public abstract class Subtraction {
    public abstract Summation _add(Summation summation);
    public abstract Summation _add(Multiplication elemen);
}
