package oop.math.numbers.numberSystems;

import java.util.List;

import oop.math.numbers.NumberSystem;

public class DecimalNumber extends NumberSystem {

    @Override
    public void setRadix(int radix){
        this.radix = 10;
    }

    public DecimalNumber() {
        super();
        this.setRadix(10);
    }
    public DecimalNumber(int number) {
        super(number);
        this.setRadix(10);
    }
    public DecimalNumber(String numberStr) {
        super(numberStr, 10);
    }
    public DecimalNumber(int sign, List<Integer> digits) {
        super(sign, digits, 10);
    }

    public Integer toInt() {
        return (int) this.toSummation().result();
    }
}
