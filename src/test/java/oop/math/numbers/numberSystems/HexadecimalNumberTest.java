package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;

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
    public void testSetRadix() {
        HexadecimalNumber ns = new HexadecimalNumber();
        ns.setRadix(8);
        assertEquals(16, ns.getRadix());
        ns.setRadix(1);
        assertEquals(16, ns.getRadix());
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
}
