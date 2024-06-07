package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.notations.Summation;

import java.util.ArrayList;
import java.util.List;

public class NumberSystemTest {
    @Test
    public void testSetSign() {
        NumberSystem ns = new NumberSystem(1);
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

        ns = new NumberSystem(-0);
        assertEquals(+1, ns.getSign());

        ns = new NumberSystem(1);
        ns.reverse();
        assertEquals(-1, ns.getSign());
        ns.reverse();
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testSetRadix() {
        NumberSystem ns = new NumberSystem();
        ns.setRadix(8);
        assertEquals(8, ns.getRadix());

        assertThrows(IllegalArgumentException.class, () -> ns.setRadix(1));

        assertThrows(IllegalArgumentException.class, () -> new NumberSystem("0", 1));
    }

    @Test
    public void testSetDigits() {
        NumberSystem ns = new NumberSystem("-12", 10);
        ns.setDigits(new ArrayList<>(List.of(1, 2, 3)));
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());

        assertThrows(NumberFormatException.class, () -> ns.setDigits(new ArrayList<>(List.of(-1, 2, 3))));

        assertThrows(NumberFormatException.class, () -> new NumberSystem("981", 8));

        ns.setDigits(new ArrayList<>(List.of(0)));
        assertEquals(true, ns.isZero());
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        NumberSystem ns = new NumberSystem();
        assertEquals(10, ns.getRadix());
        assertEquals(new ArrayList<>(List.of(0)), ns.getDigits());
        assertEquals("0", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        NumberSystem ns = new NumberSystem(123);
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), ns.getDigits());
        assertEquals(10, ns.getRadix());
        assertEquals("123", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        NumberSystem ns = new NumberSystem("101", 2);
        assertEquals(new ArrayList<>(List.of(1, 0, 1)), ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(2, ns.getRadix());
        assertEquals("101_2", ns.toString());

        ns = new NumberSystem("-25", 10);
        assertEquals(new ArrayList<>(List.of(2, 5)), ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(10, ns.getRadix());
        assertEquals("-25", ns.toString());

        ns = new NumberSystem("-0", 10);
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testConstructorWithDigitsAndRadix() {
        List<Integer> digits = new ArrayList<>(List.of(1, 0, 1));
        NumberSystem ns = new NumberSystem(1, digits, 2);
        assertEquals(digits, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(2, ns.getRadix());
    }

    @Test
    public void testToSummation() {
        NumberSystem ns = new NumberSystem(123);
        Summation sum = ns.toSummation();
        assertEquals("[(1) x (10^2)] + [(2) x (10)] + [(3) x (10^0)]", sum.toString());
        assertEquals(123.0, sum.result());

        ns = new NumberSystem("-A1F", 16);
        sum = ns.toSummation();
        assertEquals("[(10) x (16^2) x (-1)] + [(1) x (16) x (-1)] + [(15) x (16^0) x (-1)]", sum.toString());
        assertEquals(-2591.0, sum.result());
    }

    @Test
    public void testCharToDigit() {
        NumberSystem ns = new NumberSystem();
        assertEquals(1, ns.charToDigit('1'));
        assertEquals(10, ns.charToDigit('A'));
        assertEquals(10, ns.charToDigit('a'));

        assertThrows(NumberFormatException.class, () -> ns.charToDigit('!'));
    }

    @Test
    public void testStringToDigits() {
        NumberSystem ns = new NumberSystem();
        assertEquals(new ArrayList<>(List.of(1, 2)), ns.stringToDigits("12"));
        assertEquals(new ArrayList<>(List.of(1, 2, 10)), ns.stringToDigits("12A"));
        assertEquals(new ArrayList<>(List.of(11, 2, 10)), ns.stringToDigits("b2A"));
    }
}
