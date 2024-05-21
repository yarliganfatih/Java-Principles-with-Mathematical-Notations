package src.main.java.oop.math.depended_operations;

import src.main.java.oop.math.notations.Exponential;
import src.main.java.oop.math.notations.Multiplication;

public abstract class Division extends Subtraction {
    public Multiplication toMultiplication(){
        if(this instanceof Multiplication) return (Multiplication)this;
        if(this instanceof Exponential) return new Multiplication((Exponential)this);
        // if(this instanceof Integer) return new Multiplication(new Exponential(this));
        return null;
    }
    public Multiplication _mult(Multiplication multiplication){
        return new Multiplication().mult(this.toMultiplication()).mult(multiplication);
    }
    public Multiplication _mult(Exponential exponential){
        return new Multiplication().mult(this.toMultiplication()).mult(exponential);
    }
    public Multiplication _mult(Integer integer){
        return this._mult((new Exponential(integer)));
    }
    
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
