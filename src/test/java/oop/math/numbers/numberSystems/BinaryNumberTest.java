package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;
import oop.math.numbers.NumberSystem;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumberTest {
    @Test
    public void testSetSign() {
        BinaryNumber ns = new BinaryNumber(1);
        ns.setSign(+1);
        assertEquals(+1, ns.getSign());
        ns.setSign(+2);
        assertEquals(+1, ns.getSign());
        ns.setSign(-1);
        assertEquals(-1, ns.getSign());
        ns.setSign(-2);
        assertEquals(-1, ns.getSign());
        ns.setSign(0);
        assertEquals(+1, ns.getSign());

        ns = new BinaryNumber(-0);
        assertEquals(+1, ns.getSign());

        ns = new BinaryNumber(1);
        ns.reverse();
        assertEquals(-1, ns.getSign());
        ns.reverse();
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testSetDigits() {
        BinaryNumber ns = new BinaryNumber("-10");
        ns.setDigits(new ArrayList<>(List.of(1, 0, 1)));
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());

        assertThrows(IllegalArgumentException.class, () -> ns.setDigits(new ArrayList<>()));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(-1, 1, 0))));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(1, 3, 0))));

        ns.setDigits(new ArrayList<>(List.of(0)));
        assertEquals(true, ns.isZero());
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        BinaryNumber ns = new BinaryNumber();
        assertEquals(2, ns.getRadix());
        assertEquals(new ArrayList<>(List.of(0)), ns.getDigits());
        assertEquals("0_2", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        BinaryNumber ns = new BinaryNumber(101);
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(2, ns.getRadix());
        assertEquals("101_2", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        BinaryNumber ns = new BinaryNumber("101");
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(2, ns.getRadix());
        assertEquals("101_2", ns.toString());

        ns = new BinaryNumber("-10");
        assertEquals(new ArrayList<>(List.of(1, 0)), ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(2, ns.getRadix());
        assertEquals("-10_2", ns.toString());

        ns = new BinaryNumber("-0");
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testConstructorWithDigitsAndRadix() {
        List<Integer> digits = new ArrayList<>(List.of(1, 0, 1));
        BinaryNumber ns = new BinaryNumber(1, digits);
        assertEquals(digits, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(2, ns.getRadix());
    }

    @Test
    public void testToSummation() {
        BinaryNumber ns = new BinaryNumber(101);
        Summation sum = ns.toSummation();
        assertEquals("[(1) x (2^2)] + [(0) x (2)] + [(1) x (2^0)]", sum.toString());
        assertEquals(5.0, sum.result());
    }
    
    @Test
    public void testConvertToRadix() {
        BinaryNumber ns = new BinaryNumber("1010");
        
        NumberSystem binary = ns.convertToRadix(2);
        assertEquals("1010_2", binary.toString());

        NumberSystem octal = ns.convertToRadix(8);
        assertEquals("12_8", octal.toString());

        NumberSystem decimal = ns.convertToRadix(10);
        assertEquals("10", decimal.toString());

        NumberSystem hex = ns.convertToRadix(16);
        assertEquals("a_16", hex.toString());
    }

    @Test
    public void testToBinaryNumber() {
        BinaryNumber ns = new BinaryNumber("1010");
        BinaryNumber binary = ns.toBinaryNumber();
        assertEquals("1010_2", binary.toString());
    }

    @Test
    public void testToOctalNumber() {
        BinaryNumber ns = new BinaryNumber("1010");
        OctalNumber octal = ns.toOctalNumber();
        assertEquals("12_8", octal.toString());
    }

    @Test
    public void testToDecimalNumber() {
        BinaryNumber ns = new BinaryNumber("1010");
        DecimalNumber decimal = ns.toDecimalNumber();
        assertEquals("10", decimal.toString());
    }

    @Test
    public void testToHexadecimalNumber() {
        BinaryNumber ns = new BinaryNumber("1010");
        HexadecimalNumber hex = ns.toHexadecimalNumber();
        assertEquals("a_16", hex.toString());
    }

    @Test
    public void testConvertNegativeToRadix() {
        BinaryNumber ns = new BinaryNumber("-1010");
        
        NumberSystem binary = ns.convertToRadix(2);
        assertEquals("-1010_2", binary.toString());

        NumberSystem octal = ns.convertToRadix(8);
        assertEquals("-12_8", octal.toString());

        NumberSystem decimal = ns.convertToRadix(10);
        assertEquals("-10", decimal.toString());

        NumberSystem hex = ns.convertToRadix(16);
        assertEquals("-a_16", hex.toString());
    }

    @Test
    public void testToBinaryNumberNegative() {
        BinaryNumber ns = new BinaryNumber("-1010");
        BinaryNumber binary = ns.toBinaryNumber();
        assertEquals("-1010_2", binary.toString());
    }

    @Test
    public void testToOctalNumberNegative() {
        BinaryNumber ns = new BinaryNumber("-1010");
        OctalNumber octal = ns.toOctalNumber();
        assertEquals("-12_8", octal.toString());
    }

    @Test
    public void testToDecimalNumberNegative() {
        BinaryNumber ns = new BinaryNumber("-1010");
        DecimalNumber decimal = ns.toDecimalNumber();
        assertEquals("-10", decimal.toString());
    }

    @Test
    public void testToHexadecimalNumberNegative() {
        BinaryNumber ns = new BinaryNumber("-1010");
        HexadecimalNumber hex = ns.toHexadecimalNumber();
        assertEquals("-a_16", hex.toString());
    }

    @Test
    public void testConvertToRadixWithLargeNumber() {
        NumberSystem ns = new NumberSystem("1000000", 10);
        
        NumberSystem binary = ns.convertToRadix(2);
        assertEquals("11110100001001000000_2", binary.toString());

        NumberSystem octal = ns.convertToRadix(8);
        assertEquals("3641100_8", octal.toString());

        NumberSystem decimal = ns.convertToRadix(10);
        assertEquals("1000000", decimal.toString());

        NumberSystem hex = ns.convertToRadix(16);
        assertEquals("f4240_16", hex.toString());
    }

    @Test
    public void testOnesComplement() {
        BinaryNumber ns = new BinaryNumber(101);
        ns.onesComplement();
        assertEquals("10_2", ns.toString());
    } 

    @Test
    public void testTwosComplement() {
        BinaryNumber ns = new BinaryNumber(101);
        ns.twosComplement();
        assertEquals("11_2", ns.toString());
    }
}