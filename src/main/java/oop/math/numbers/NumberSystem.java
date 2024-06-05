package oop.math.numbers;

public class NumberSystem {
    private int sign = +1;
    private int digits = 0;
    private int radix = 10;

    public int getSign() {
        return this.sign;
    }
    public void setSign(int number) {
        if (number >= 0) this.sign = +1;
        else if (number < 0) this.sign = -1;
    }
    public void reverse() {
        this.setSign(this.sign * -1);
    }

    public int getDigits() {
        return this.digits;
    }
    public void setDigits(int digits) {
        if (digits < 0)
            throw new NumberFormatException("Digits cannot be negative.");
        int _digits = digits;
        while (_digits >= 1) {
            if (_digits % 10 >= this.radix)
                throw new NumberFormatException("Invalid digit (" + _digits % 10 + ") for this radix (" + this.radix + ").");
            _digits /= 10;
        }
        this.digits = digits;
        if (this.digits == 0)
            this.setSign(0); // to avoid -0
    }

    public int getRadix() {
        return this.radix;
    }
    public void setRadix(int radix) {
        if (radix < 2)
            throw new IllegalArgumentException("Radix cannot be less than 2.");
        this.radix = radix;
    }

    public NumberSystem() {
    }
    public NumberSystem(int number) {
        this.setSign(number);
        this.setDigits(Math.abs(number));
    }
    public NumberSystem(String numberStr, int radix) {
        this.setRadix(radix); // priority for comparison
        int number = Integer.parseInt(numberStr); // TODO should be able to catch letters
        this.setSign(number);
        this.setDigits(Math.abs(number));
    }

    // TODO operation methods should be developed for different radixed numbers other than decimal

    public NumberSystem add(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = this.getSign() * this.getDigits();
        int decimal2 = other.getSign() * other.getDigits();
        int result = decimal1 + decimal2;
        this.setSign(result);
        this.setDigits(Math.abs(result));
        return this;
    }

    public NumberSystem subt(NumberSystem other) {
        other.reverse();
        return this.add(other);
    }

    public NumberSystem mult(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = this.getSign() * this.getDigits();
        int decimal2 = other.getSign() * other.getDigits();
        int result = decimal1 * decimal2;
        this.setSign(result);
        this.setDigits(Math.abs(result));
        return this;
    }

    public NumberSystem divi(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        if (other.getDigits() == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        int decimal1 = this.getSign() * this.getDigits();
        int decimal2 = other.getSign() * other.getDigits();
        int result = decimal1 / decimal2;
        this.setSign(result);
        this.setDigits(Math.abs(result));
        return this;
    }

    public String toString() {
        String out = this.getSign() == -1 ? "-" : "";
        out += Integer.toString(this.getDigits());
        if (this.getRadix() != 10)
            out += "_" + this.getRadix();
        return out;
    }
}
