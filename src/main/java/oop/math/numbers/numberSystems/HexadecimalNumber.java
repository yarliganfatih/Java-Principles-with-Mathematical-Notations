package oop.math.numbers.numberSystems;

import java.util.List;

import oop.math.numbers.NumberSystem;

public class HexadecimalNumber extends NumberSystem {

    @Override
    public void setRadix(int radix){
        this.radix = 16;
    }

    public HexadecimalNumber() {
        super();
        this.setRadix(16);
    }
    public HexadecimalNumber(int number) { // insufficient coverage
        super(number);
        this.setRadix(16);
    }
    public HexadecimalNumber(String numberStr) {
        super(numberStr, 16);
    }
    public HexadecimalNumber(int sign, List<Integer> digits) {
        super(sign, digits, 16);
    }
}
