package oop.math.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import oop.math.notations.Exponential;
import oop.math.notations.Multiplication;
import oop.math.notations.Summation;
import oop.math.numbers.numberSystems.BinaryNumber;
import oop.math.numbers.numberSystems.DecimalNumber;
import oop.math.numbers.numberSystems.HexadecimalNumber;
import oop.math.numbers.numberSystems.OctalNumber;

public class NumberSystem {
    private int sign = +1;
    private List<Integer> digits = new ArrayList<>(List.of(0));
    protected final int radix;

    public int getSign() {
        return this.sign;
    }
    public void setSign(int number) {
        if (number >= 0)
            this.sign = +1;
        else if (number < 0)
            this.sign = -1;
    }
    public NumberSystem reverse() {
        this.setSign(this.sign * -1);
        return this;
    }

    public List<Integer> getDigits() {
        return this.digits;
    }
    public void setDigits(List<Integer> digits) {
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
    
    public NumberSystem(int radix) {
        if (radix < 2)
            throw new IllegalArgumentException("Radix cannot be less than 2.");
        this.radix = radix;
    }
    public NumberSystem() {
        this(10);
    }
    public NumberSystem(int number, int radix) { // up to _10
        this(radix);
        this.setSign(number);
        this.setDigits(this.stringToDigits(Integer.toString(number)));
    }
    public NumberSystem(String numberStr, int radix) { // up to _36
        this(radix);
        this.setDigits(this.stringToDigits(numberStr.replaceAll("[ ]", "")));
    }
    public NumberSystem(int sign, List<Integer> digits, int radix) { // up to _∞
        this(radix);
        this.setSign(sign);
        this.setDigits(digits);
    }
    public NumberSystem(NumberSystem other) {
        this(other.getRadix());
        this.setSign(other.getSign());
        this.setDigits(other.getDigits());
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
    
    public NumberSystem convertToRadix(int radix) {
        int decimal = (int) this.toSummation().result();
        if (radix == 10)
            return new DecimalNumber(decimal); // upcasting
        List<Integer> digitList = decimalToDigits(decimal, radix);
        if (radix == 2)
            return new BinaryNumber(this.getSign(), digitList); // upcasting
        if (radix == 8)
            return new OctalNumber(this.getSign(), digitList); // upcasting
        if (radix == 16)
            return new HexadecimalNumber(this.getSign(), digitList); // upcasting
        return new NumberSystem(this.getSign(), digitList, radix);
    }
    public BinaryNumber toBinaryNumber() {
        return (BinaryNumber) this.convertToRadix(2); // downcasting
    }
    public OctalNumber toOctalNumber() {
        return (OctalNumber) this.convertToRadix(8); // downcasting
    }
    public DecimalNumber toDecimalNumber() {
        return (DecimalNumber) this.convertToRadix(10); // downcasting
    }
    public HexadecimalNumber toHexadecimalNumber() {
        return (HexadecimalNumber) this.convertToRadix(16); // downcasting
    }

    public List<Integer> extendList(List<Integer> digits, int extend) {
        digits = new ArrayList<>(digits);
        Collections.reverse(digits);
        while (digits.size() < extend) digits.add(0);
        return digits;
    }
    
    public NumberSystem add(NumberSystem other) {
        other = new NumberSystem(other);
        if(this.getRadix() != other.getRadix()) throw new IllegalArgumentException("Incompatible radix value.");
        int max = Math.max(this.getDigits().size(), other.getDigits().size()) + 1;

        List<Integer> digitList1 = extendList(this.getDigits(), max);
        List<Integer> digitList2 = extendList(other.getDigits(), max);
        List<Integer> digitList = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < max; i++) {
            //if(i == max - 1 && carry == -1) break;
            int sum = carry;
            sum += this.getSign() * digitList1.get(i);
            sum += other.getSign() * digitList2.get(i);
            if (sum < 0) {
                sum += this.getRadix();
                carry = -1; // borrow
            } else {
                carry = sum / this.getRadix(); // 1 or 0
            }
            digitList.add(Math.abs(sum % this.getRadix()));
        }
        this.setSign(carry); // if carry==0 then sign is positive
        Collections.reverse(digitList);
        this.setDigits(digitList);
        return this;
    }

    public NumberSystem subt(NumberSystem other) {
        other = new NumberSystem(other);
        other.reverse();
        return this.add(other);
    }

    public NumberSystem mult(NumberSystem other) {
        other = new NumberSystem(other);
        if(this.getRadix() != other.getRadix()) throw new IllegalArgumentException("Incompatible radix value.");
        NumberSystem summation = new NumberSystem("0", this.getRadix());
        NumberSystem counter = new NumberSystem(other);
        counter.setSign(+1);
        while(!(counter.isZero())){
            summation.add(this);
            counter.subt(new NumberSystem("1", counter.getRadix()));
        }
        this.setDigits(summation.getDigits());
        if(other.getSign() == -1) this.reverse();
        return this;
    }
    
    public NumberSystem divi(NumberSystem other) {
        other = new NumberSystem(other);
        if (this.getRadix() != other.getRadix()) throw new IllegalArgumentException("Incompatible radix value.");
        if (other.isZero()) throw new IllegalArgumentException("Denominator cannot be zero.");
        NumberSystem counter = new NumberSystem("0", other.getRadix());
        NumberSystem absThis = new NumberSystem(this);
        absThis.setSign(+1);
        NumberSystem absNumber = new NumberSystem(other);
        absNumber.setSign(+1);
        while(absThis.isBiggerOrEqualDigits(absNumber)){
            absThis.subt(absNumber);
            counter.add(new NumberSystem("1", counter.getRadix()));
        }
        this.setDigits(counter.getDigits());
        if(other.getSign() == -1) this.reverse();
        return this;
    }

    public Boolean isBiggerOrEqualDigits(NumberSystem other){
        other = new NumberSystem(other);
        if (this.getDigits().size() > other.getDigits().size()) return true;
        if (this.getDigits().size() < other.getDigits().size()) return false;
        // if sizes are equal
        int i = -1;
        for(int digit : this.getDigits()){
            if(digit != other.getDigits().get(++i)) break;
        }
        return (this.getDigits().get(i) >= other.getDigits().get(i));
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
