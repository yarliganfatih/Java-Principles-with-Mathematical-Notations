package oop.math.numbers;

public class NumberSystem {
    int sign = +1;
    int digits = 0;
    int radix = 10;

    public NumberSystem() {
    }
    public NumberSystem(int number) {
        this.sign = number < 0 ? -1 : +1;
        this.digits = Math.abs(number);
    }
    public NumberSystem(String numberStr, int radix) {
        int number = Integer.parseInt(numberStr); // TODO should be able to catch letters
        this.sign = number < 0 ? -1 : +1;
        this.digits = Math.abs(number); // TODO each digit must be compatible with radix
        this.radix = radix; // TODO cannot be less than 2
    }

    // TODO operation methods should be developed for different radixed numbers other than decimal

    public NumberSystem add(NumberSystem other) {
        if (this.radix != other.radix)
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = this.sign * this.digits;
        int decimal2 = other.sign * other.digits;
        int result = decimal1 + decimal2;
        this.sign = result < 0 ? -1 : +1;
        this.digits = Math.abs(result);
        return this;
    }

    public NumberSystem subt(NumberSystem other) {
        other.sign *= -1;
        return this.add(other);
    }

    public NumberSystem mult(NumberSystem other) {
        if (this.radix != other.radix)
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = this.sign * this.digits;
        int decimal2 = other.sign * other.digits;
        int result = decimal1 * decimal2;
        this.sign = result < 0 ? -1 : +1;
        this.digits = Math.abs(result);
        return this;
    }

    public NumberSystem divi(NumberSystem other) {
        if (this.radix != other.radix)
            throw new IllegalArgumentException("Incompatible radix value.");
        if (other.digits == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        int decimal1 = this.sign * this.digits;
        int decimal2 = other.sign * other.digits;
        int result = decimal1 / decimal2;
        this.sign = result < 0 ? -1 : +1;
        this.digits = Math.abs(result);
        return this;
    }

    public String toString() {
        String out = this.sign == -1 ? "-" : "";
        out += Integer.toString(this.digits);
        if (this.radix != 10)
            out += "_" + this.radix;
        return out;
    }
}
