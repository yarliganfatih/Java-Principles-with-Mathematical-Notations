package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;

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
    public void testSetRadix() {
        BinaryNumber ns = new BinaryNumber();
        ns.setRadix(8);
        assertEquals(2, ns.getRadix());
        ns.setRadix(1);
        assertEquals(2, ns.getRadix());
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