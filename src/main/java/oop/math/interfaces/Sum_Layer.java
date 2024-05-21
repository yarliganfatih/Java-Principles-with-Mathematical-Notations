package src.main.java.oop.math.interfaces;

import src.main.java.oop.math.notations.Exponential;
import src.main.java.oop.math.notations.Multiplication;
import src.main.java.oop.math.notations.Summation;

public interface Sum_Layer {
    public default Summation toSummation(){
        if(this instanceof Summation) return (Summation)this;
        if(this instanceof Multiplication) return new Summation((Multiplication)this);
        if(this instanceof Exponential) return new Summation(new Multiplication((Exponential)this));
        // if(this instanceof Integer) return new Summation(new Multiplication(new Exponential(this)));
        return null;
    }

    public default Summation _add(Summation summation){
        return new Summation().add(this.toSummation()).add(summation);
    }
    public default Summation _add(Multiplication multiplication){
        return new Summation().add(this.toSummation()).add(multiplication);
    }
    public default Summation _add(Exponential exponential){
        return this._add(new Multiplication(exponential));
    }
    public default Summation _add(Integer integer){
        return this._add(new Exponential(integer));
    }


    public default Summation _subt(Summation summation) {
        return this._add(summation.reverse());
    }
    public default Summation _subt(Multiplication element) {
        return this._add(element._reverse());
    }
    public default Summation _subt(Exponential exponential) {
        return this._subt(new Multiplication(exponential));
    }
    public default Summation _subt(Integer integer) {
        return this._subt(new Exponential(integer));
    }
}
