package oop.math.interfaces;

import oop.math.notations.Exponential;
import oop.math.notations.Multiplication;
import oop.math.notations.Summation;

public interface Sum_Layer {
    public default Summation toSummation(){
        if(this instanceof Summation) return (Summation)this;
        if(this instanceof Multiplication) return new Summation((Multiplication)this);
        if(this instanceof Exponential) return new Summation(new Multiplication((Exponential)this));
        // if(this instanceof Integer) return new Summation(new Multiplication(new Exponential((Integer)this))); // TODO #3
        return null;
    }

    public default Summation _add(Sum_Layer multiParam){
        return new Summation().add(this.toSummation()).add(multiParam.toSummation());
    }
    public default Summation _add(Integer integer){
        return this._add(new Exponential(integer));
    }


    public default Summation _subt(Sum_Layer multiParam) {
        return this._add(multiParam.toSummation().reverse());
    }
    public default Summation _subt(Integer integer) {
        return this._subt(new Exponential(integer));
    }
}
