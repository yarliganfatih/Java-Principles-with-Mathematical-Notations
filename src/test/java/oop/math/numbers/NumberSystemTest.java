package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

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
        ns.setDigits(123);
        assertEquals("-123", ns.toString());

        assertThrows(NumberFormatException.class, () -> ns.setDigits(-10));

        assertThrows(NumberFormatException.class, () -> new NumberSystem("981", 8));

        ns.setDigits(0);
        assertEquals(+1, ns.getSign());
    }

    @Test
    public void testDefaultConstructor() {
        NumberSystem ns = new NumberSystem();
        assertEquals(10, ns.getRadix());
        assertEquals(0, ns.getDigits());
        assertEquals("0", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        NumberSystem ns = new NumberSystem(123);
        assertEquals(123, ns.getDigits());
        assertEquals(10, ns.getRadix());
        assertEquals("123", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        NumberSystem ns = new NumberSystem("101", 2);
        assertEquals(101, ns.getDigits());
        assertEquals(+1, ns.getSign());
        assertEquals(2, ns.getRadix());
        assertEquals("101_2", ns.toString());

        ns = new NumberSystem("-25", 10);
        assertEquals(25, ns.getDigits());
        assertEquals(-1, ns.getSign());
        assertEquals(10, ns.getRadix());
        assertEquals("-25", ns.toString());

        ns = new NumberSystem("-0", 10);
        assertEquals(+1, ns.getSign());
    }
}
