package src.main.java.oop.math.depended_operations;

import src.main.java.oop.math.notations.Exponential;
import src.main.java.oop.math.notations.Multiplication;

public abstract class Division {
    public abstract Multiplication _mult(Multiplication multiplication);
    public abstract Multiplication _mult(Exponential element);
    
    public Multiplication _divi(Multiplication multiplication) {
        return this._mult(multiplication.reverse());
    }
    public Multiplication _divi(Exponential element) {
        return this._mult(element._reverse());
    }
    public Multiplication _divi(Integer integer) {
        return this._divi(new Exponential(integer));
    }
}
