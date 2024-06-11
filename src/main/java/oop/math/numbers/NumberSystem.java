package oop.math.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import oop.math.notations.Exponential;
import oop.math.notations.Multiplication;
import oop.math.notations.Summation;

public class NumberSystem {
    private int sign = +1;
    private List<Integer> digits = new ArrayList<>(List.of(0));
    protected int radix = 0;

    public int getSign() {
        return this.sign;
    }
    public void setSign(int number) {
        if (number >= 0)
            this.sign = +1;
        else if (number < 0)
            this.sign = -1;
    }
    public void reverse() {
        this.setSign(this.sign * -1);
    }

    public List<Integer> getDigits() {
        return this.digits;
    }
    public void setDigits(List<Integer> digits) {
        if (this.radix == 0) // To ensure setRadix is ​​before setDigits
            throw new IllegalArgumentException("Firstly radix must be assigned.");
        if (digits.size() == 0)
            throw new IllegalArgumentException("Digits cannot be empty.");
        for (int digit : digits) {
            if (digit < 0)
                throw new NumberFormatException("Digit (" + digit + ") cannot be negative.");
            if (digit >= this.radix)
                throw new NumberFormatException("Invalid digit (" + digit + ") for radix (" + this.radix + ").");
        }
        while (digits.get(0) == 0 && digits.size() > 1)
            digits.remove(0);
        this.digits = digits;
        if (this.isZero())
            this.setSign(0); // to avoid -0
    }
    public Boolean isZero() {
        return (this.digits.size() == 1 && this.digits.get(0) == 0);
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
        this.setRadix(10);
    }
    public NumberSystem(int number) { // up to _10
        this();
        this.setSign(number);
        this.setDigits(this.stringToDigits(Integer.toString(number)));
    }
    public NumberSystem(String numberStr, int radix) { // up to _36
        this.setRadix(radix);
        this.setDigits(this.stringToDigits(numberStr.replaceAll("[ ]", "")));
    }
    public NumberSystem(int sign, List<Integer> digits, int radix) { // up to _∞
        this.setRadix(radix);
        this.setSign(sign);
        this.setDigits(digits);
    }

    public List<Integer> stringToDigits(String numberStr) {
        List<Character> charList = numberStr.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        if (charList.get(0) == '-')
            this.setSign(-1);
        if (charList.get(0) == '-' || charList.get(0) == '+')
            charList.remove(0);
        return charList.stream()
                .map(c -> charToDigit(c))
                .collect(Collectors.toList());
    }

    public Integer charToDigit(Character chr) {
        int ascii = (int) chr;
        if (ascii < 58 && ascii > 47)
            return chr - '0';
        if (ascii < 91 && ascii > 64)
            return 10 + (chr - 'A');
        if (ascii < 123 && ascii > 96)
            return 10 + (chr - 'a');
        throw new NumberFormatException("Invalid digit value.");
    }

    public static List<Integer> decimalToDigits(int decimal, int radix) {
        decimal = Math.abs(decimal);
        List<Integer> digitList = new ArrayList<>();
        digitList.add(decimal % radix);
        while (decimal >= radix) {
            decimal /= radix;
            digitList.add(decimal % radix);
        }
        Collections.reverse(digitList);
        return digitList;
    }

    public Summation toSummation() {
        Summation sum = new Summation();
        for (int i = 0; i < this.getDigits().size(); i++) {
            sum.add(new Multiplication(new Exponential(this.getDigits().get(i)))
                    .mult(new Exponential(this.getRadix(), this.getDigits().size() - 1 - i)));
        }
        if (this.getSign() == -1)
            sum.reverse();
        return sum;
    }

    public NumberSystem add(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = (int) this.toSummation().result();
        int decimal2 = (int) other.toSummation().result();
        int result = decimal1 + decimal2;
        this.setSign(result);
        List<Integer> digitList = decimalToDigits(result, this.getRadix());
        this.setDigits(digitList);
        return this;
    }

    public NumberSystem subt(NumberSystem other) {
        other.reverse();
        return this.add(other);
    }

    public NumberSystem mult(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        int decimal1 = (int) this.toSummation().result();
        int decimal2 = (int) other.toSummation().result();
        int result = decimal1 * decimal2;
        this.setSign(result);
        List<Integer> digitList = decimalToDigits(result, this.getRadix());
        this.setDigits(digitList);
        return this;
    }

    public NumberSystem divi(NumberSystem other) {
        if (this.getRadix() != other.getRadix())
            throw new IllegalArgumentException("Incompatible radix value.");
        if (other.isZero())
            throw new IllegalArgumentException("Denominator cannot be zero.");
        int decimal1 = (int) this.toSummation().result();
        int decimal2 = (int) other.toSummation().result();
        int result = decimal1 / decimal2;
        this.setSign(result);
        List<Integer> digitList = decimalToDigits(result, this.getRadix());
        this.setDigits(digitList);
        return this;
    }

    public String toString() {
        String out = this.getSign() == -1 ? "-" : "";
        for (int digit : this.getDigits()) {
            if (digit < 36)
                out += Integer.toString(digit, this.getRadix());
            else
                out += "{" + digit + "}";
        }
        if (this.getRadix() != 10)
            out += "_" + this.getRadix();
        return out;
    }
}
