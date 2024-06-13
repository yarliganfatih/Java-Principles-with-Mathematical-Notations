package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;

import java.util.ArrayList;
import java.util.List;

public class DecimalNumberTest {
    @Test
    public void testSetSign() {
        DecimalNumber ns = new DecimalNumber(1);
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

        ns = new DecimalNumber(-0);
        assertEquals(+1, ns.getSign());

        ns = new DecimalNumber(1);
        ns.reverse();
        assertEquals(-1, ns.getSign());
        ns.reverse();
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testSetDigits() {
        DecimalNumber ns = new DecimalNumber("-12");
        ns.setDigits(new ArrayList<>(List.of(1, 2, 3)));
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());

        assertThrows(IllegalArgumentException.class, () -> ns.setDigits(new ArrayList<>()));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(-1, 2, 3))));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(1, 11, 3))));

        ns.setDigits(new ArrayList<>(List.of(0)));
        assertEquals(true, ns.isZero());
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        DecimalNumber ns = new DecimalNumber();
        assertEquals(10, ns.getRadix());
        assertEquals(new ArrayList<>(List.of(0)), ns.getDigits());
        assertEquals("0", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        DecimalNumber ns = new DecimalNumber(123);
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());
        assertEquals(10, ns.getRadix());
        assertEquals("123", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        DecimalNumber ns = new DecimalNumber("101");
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(10, ns.getRadix());
        assertEquals("101", ns.toString());

        ns = new DecimalNumber("-25");
        assertEquals(new ArrayList<>(List.of(2, 5)), ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(10, ns.getRadix());
        assertEquals("-25", ns.toString());

        ns = new DecimalNumber("-0");
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testConstructorWithDigitsAndRadix() {
        List<Integer> digits = new ArrayList<>(List.of(1, 0, 1));
        DecimalNumber ns = new DecimalNumber(1, digits);
        assertEquals(digits, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(10, ns.getRadix());
    }

    @Test
    public void testToSummation() {
        DecimalNumber ns = new DecimalNumber(123);
        Summation sum = ns.toSummation();
        assertEquals("[(1) x (10^2)] + [(2) x (10)] + [(3) x (10^0)]", sum.toString());
        assertEquals(123.0, sum.result());
    }
}
