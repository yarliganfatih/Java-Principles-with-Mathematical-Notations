package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;

import java.util.ArrayList;
import java.util.List;

public class OctalNumberTest {
    @Test
    public void testSetSign() {
        OctalNumber ns = new OctalNumber(1);
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

        ns = new OctalNumber(-0);
        assertEquals(+1, ns.getSign());

        ns = new OctalNumber(1);
        ns.reverse();
        assertEquals(-1, ns.getSign());
        ns.reverse();
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testSetRadix() {
        OctalNumber ns = new OctalNumber();
        ns.setRadix(8);
        assertEquals(8, ns.getRadix());
        ns.setRadix(1);
        assertEquals(8, ns.getRadix());
    }

    @Test
    public void testSetDigits() {
        OctalNumber ns = new OctalNumber("-12");
        ns.setDigits(new ArrayList<>(List.of(1, 2, 3)));
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());

        assertThrows(IllegalArgumentException.class, () -> ns.setDigits(new ArrayList<>()));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(-1, 2, 3))));

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(1, 9, 3))));

        ns.setDigits(new ArrayList<>(List.of(0)));
        assertEquals(true, ns.isZero());
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        OctalNumber ns = new OctalNumber();
        assertEquals(8, ns.getRadix());
        assertEquals(new ArrayList<>(List.of(0)), ns.getDigits());
        assertEquals("0_8", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        OctalNumber ns = new OctalNumber(123);
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());
        assertEquals(8, ns.getRadix());
        assertEquals("123_8", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        OctalNumber ns = new OctalNumber("101");
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(8, ns.getRadix());
        assertEquals("101_8", ns.toString());

        ns = new OctalNumber("-25");
        assertEquals(new ArrayList<>(List.of(2, 5)), ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(8, ns.getRadix());
        assertEquals("-25_8", ns.toString());

        ns = new OctalNumber("-0");
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testConstructorWithDigitsAndRadix() {
        List<Integer> digits = new ArrayList<>(List.of(1, 0, 1));
        OctalNumber ns = new OctalNumber(1, digits);
        assertEquals(digits, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(8, ns.getRadix());
    }

    @Test
    public void testToSummation() {
        OctalNumber ns = new OctalNumber(123);
        Summation sum = ns.toSummation();
        assertEquals("[(1) x (8^2)] + [(2) x (8)] + [(3) x (8^0)]", sum.toString());
        assertEquals(83.0, sum.result());
    }
}
