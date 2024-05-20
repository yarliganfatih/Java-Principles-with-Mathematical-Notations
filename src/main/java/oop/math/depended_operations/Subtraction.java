package src.main.java.oop.math.depended_operations;

import src.main.java.oop.math.notations.Exponential;
import src.main.java.oop.math.notations.Multiplication;
import src.main.java.oop.math.notations.Summation;

public abstract class Subtraction {
    public abstract Summation _add(Summation summation);
    public abstract Summation _add(Multiplication elemen);

    public Summation _subt(Summation summation) {
        return this._add(summation.reverse());
    }
    public Summation _subt(Multiplication element) {
        return this._add(element._reverse());
    }
    public Summation _subt(Exponential exponential) {
        return this._subt(new Multiplication(exponential));
    }
    public Summation _subt(Integer integer) {
        return this._subt(new Exponential(integer));
    }
}
