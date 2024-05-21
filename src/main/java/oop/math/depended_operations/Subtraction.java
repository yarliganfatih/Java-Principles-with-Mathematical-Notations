package src.main.java.oop.math.depended_operations;

import src.main.java.oop.math.notations.Exponential;
import src.main.java.oop.math.notations.Multiplication;
import src.main.java.oop.math.notations.Summation;

public abstract class Subtraction {
    public Summation toSummation(){
        if(this instanceof Summation) return (Summation)this;
        if(this instanceof Multiplication) return new Summation((Multiplication)this);
        if(this instanceof Exponential) return new Summation(new Multiplication((Exponential)this));
        // if(this instanceof Integer) return new Summation(new Multiplication(new Exponential(this)));
        return null;
    }

    public Summation _add(Summation summation){
        return new Summation().add(this.toSummation()).add(summation);
    }
    public Summation _add(Multiplication multiplication){
        return new Summation().add(this.toSummation()).add(multiplication);
    }
    public Summation _add(Exponential exponential){
        return this._add(new Multiplication(exponential));
    }
    public Summation _add(Integer integer){
        return this._add(new Exponential(integer));
    }


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
