package oop.math.numbers.numberSystems;

import java.util.List;

import oop.math.numbers.NumberSystem;

public class HexadecimalNumber extends NumberSystem {

    public HexadecimalNumber() {
        super(16);
    }
    public HexadecimalNumber(int number) { // insufficient coverage
        super(number, 16);
    }
    public HexadecimalNumber(String numberStr) {
        super(numberStr, 16);
    }
    public HexadecimalNumber(int sign, List<Integer> digits) {
        super(sign, digits, 16);
    }
    
    @Override
    public HexadecimalNumber toHexadecimalNumber() {
        return this;
    }
}
