package oop.math.interfaces;

import oop.math.notations.Exponential;
import oop.math.notations.Multiplication;

public interface Mult_Layer {
    public default Multiplication toMultiplication(){
        if(this instanceof Multiplication) return (Multiplication)this;
        if(this instanceof Exponential) return new Multiplication((Exponential)this);
        // if(this instanceof Integer) return new Multiplication(new Exponential((Integer)this)); // TODO #3
        return null;
    }

    public default Multiplication _mult(Mult_Layer multiParam){
        return new Multiplication().mult(this.toMultiplication()).mult(multiParam.toMultiplication());
    }
    public default Multiplication _mult(Integer integer){
        return this._mult((new Exponential(integer)));
    }
    
    public default Multiplication _divi(Mult_Layer multiParam) {
        return this._mult(multiParam.toMultiplication().reverse());
    }
    public default Multiplication _divi(Integer integer) {
        return this._divi(new Exponential(integer));
    }
}
