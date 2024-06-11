package oop.math.numbers.numberSystems;

import java.util.List;

import oop.math.numbers.NumberSystem;

public class OctalNumber extends NumberSystem {

    @Override
    public void setRadix(int radix){
        this.radix = 8;
    }

    public OctalNumber(){
        super();
        this.setRadix(8);
    }
    public OctalNumber(int number){
        super(number);
        this.setRadix(8);
    }
    public OctalNumber(String numberStr){
        super(numberStr, 8);
    }
    public OctalNumber(int sign, List<Integer> digits){
        super(sign, digits, 8);
    }
}
