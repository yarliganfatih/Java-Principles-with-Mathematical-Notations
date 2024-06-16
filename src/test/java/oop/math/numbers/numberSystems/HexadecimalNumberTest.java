package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;
import oop.math.numbers.NumberSystem;

import java.util.ArrayList;
import java.util.List;

public class HexadecimalNumberTest {
    @Test
    public void testSetSign() {
        HexadecimalNumber ns = new HexadecimalNumber(1);
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

        ns = new HexadecimalNumber(-0);
        assertEquals(+1, ns.getSign());

        ns = new HexadecimalNumber(1);
        ns.reverse();
        assertEquals(-1, ns.getSign());
        ns.reverse();
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testSetDigits() {
        HexadecimalNumber ns = new HexadecimalNumber("-12");
        ns.setDigits(new ArrayList<>(List.of(1, 2, 3)));
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());

        assertThrows(IllegalArgumentException.class, () -> ns.setDigits(new ArrayList<>()));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(-1, 2, 3))));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(1, 17, 3))));

        ns.setDigits(new ArrayList<>(List.of(0)));
        assertEquals(true, ns.isZero());
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        HexadecimalNumber ns = new HexadecimalNumber();
        assertEquals(16, ns.getRadix());
        assertEquals(new ArrayList<>(List.of(0)), ns.getDigits());
        assertEquals("0_16", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        HexadecimalNumber ns = new HexadecimalNumber(123);
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());
        assertEquals(16, ns.getRadix());
        assertEquals("123_16", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        HexadecimalNumber ns = new HexadecimalNumber("101");
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(16, ns.getRadix());
        assertEquals("101_16", ns.toString());

        ns = new HexadecimalNumber("-25");
        assertEquals(new ArrayList<>(List.of(2, 5)), ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(16, ns.getRadix());
        assertEquals("-25_16", ns.toString());

        ns = new HexadecimalNumber("-0");
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testConstructorWithDigitsAndRadix() {
        List<Integer> digits = new ArrayList<>(List.of(1, 0, 1));
        HexadecimalNumber ns = new HexadecimalNumber(1, digits);
        assertEquals(digits, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(16, ns.getRadix());
    }

    @Test
    public void testToSummation() {
        HexadecimalNumber ns = new HexadecimalNumber(123);
        Summation sum = ns.toSummation();
        assertEquals("[(1) x (16^2)] + [(2) x (16)] + [(3) x (16^0)]", sum.toString());
        assertEquals(291.0, sum.result());
    }
    
    @Test
    public void testConvertToRadix() {
        HexadecimalNumber ns = new HexadecimalNumber("a");
        
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
        HexadecimalNumber ns = new HexadecimalNumber("a");
        BinaryNumber binary = ns.toBinaryNumber();
        assertEquals("1010_2", binary.toString());
    }

    @Test
    public void testToOctalNumber() {
        HexadecimalNumber ns = new HexadecimalNumber("a");
        OctalNumber octal = ns.toOctalNumber();
        assertEquals("12_8", octal.toString());
    }

    @Test
    public void testToDecimalNumber() {
        HexadecimalNumber ns = new HexadecimalNumber("a");
        DecimalNumber decimal = ns.toDecimalNumber();
        assertEquals("10", decimal.toString());
    }

    @Test
    public void testToHexadecimalNumber() {
        HexadecimalNumber ns = new HexadecimalNumber("a");
        HexadecimalNumber hex = ns.toHexadecimalNumber();
        assertEquals("a_16", hex.toString());
    }

    @Test
    public void testConvertNegativeToRadix() {
        HexadecimalNumber ns = new HexadecimalNumber("-a");
        
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
        HexadecimalNumber ns = new HexadecimalNumber("-a");
        BinaryNumber binary = ns.toBinaryNumber();
        assertEquals("-1010_2", binary.toString());
    }

    @Test
    public void testToOctalNumberNegative() {
        HexadecimalNumber ns = new HexadecimalNumber("-a");
        OctalNumber octal = ns.toOctalNumber();
        assertEquals("-12_8", octal.toString());
    }

    @Test
    public void testToDecimalNumberNegative() {
        HexadecimalNumber ns = new HexadecimalNumber("-a");
        DecimalNumber decimal = ns.toDecimalNumber();
        assertEquals("-10", decimal.toString());
    }

    @Test
    public void testToHexadecimalNumberNegative() {
        HexadecimalNumber ns = new HexadecimalNumber("-a");
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
}
