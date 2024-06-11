package oop.math.numbers.numberSystems;

import java.util.ArrayList;
import java.util.List;

import oop.math.numbers.NumberSystem;

public class BinaryNumber extends NumberSystem {

    @Override
    public void setRadix(int radix){
        this.radix = 2;
    }

    public BinaryNumber() {
        super();
        this.setRadix(2);
    }
    public BinaryNumber(int number) {
        super(number);
        this.setRadix(2);
    }
    public BinaryNumber(String numberStr) {
        super(numberStr, 2);
    }
    public BinaryNumber(int sign, List<Integer> digits) {
        super(sign, digits, 2);
    }

    public BinaryNumber onesComplement() {
        List<Integer> digits = this.getDigits();
        List<Integer> _digits = new ArrayList<>();
        for (Integer digit : digits) {
            _digits.add(digit == 1 ? 0 : 1);
        }
        this.setDigits(_digits);
        return this;
    }

    public BinaryNumber twosComplement() {
        return (BinaryNumber) this.onesComplement().add(new BinaryNumber(1));
    }
}
