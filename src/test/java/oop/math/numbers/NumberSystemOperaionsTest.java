package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberSystemOperaionsTest {
    @Test
    public void testAddDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 9);
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testAddRadix10Negative() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.add(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testAddRadix10BothNegative() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.add(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testAddRadix10Mixed() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testSubtRadix10Negative() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.subt(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testSubtRadix10BothNegative() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.subt(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubtRadix10Mixed() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testMultRadix10Negative() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMultRadix10Mixed() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMultRadix10BothNegative() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testDiviDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 9);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviByZero() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("0", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviRadix10() {
        NumberSystem ns1 = new NumberSystem("100", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviRadix10Remainder() {
        NumberSystem ns1 = new NumberSystem("11", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviRadix10Negative() {
        NumberSystem ns1 = new NumberSystem("11", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDiviRadix10Mixed() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDiviRadix10BothNegative() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviRadix10SmallDivisor() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("0", ns1.toString());
    }

    // Farklı radix değerleri için ek testler
    @Test
    public void testAddRadix8() {
        NumberSystem ns1 = new NumberSystem("10", 8);
        NumberSystem ns2 = new NumberSystem("7", 8);
        ns1.add(ns2);
        assertEquals("17_8", ns1.toString());
    }

    @Test
    public void testSubtRadix8() {
        NumberSystem ns1 = new NumberSystem("20", 8);
        NumberSystem ns2 = new NumberSystem("7", 8);
        ns1.subt(ns2);
        assertEquals("11_8", ns1.toString());
    }

    @Test
    public void testMultRadix8() {
        NumberSystem ns1 = new NumberSystem("7", 8);
        NumberSystem ns2 = new NumberSystem("3", 8);
        ns1.mult(ns2);
        assertEquals("25_8", ns1.toString()); // 7 * 3 = 21 in decimal, which is 25 in octal
    }

    @Test
    public void testDiviRadix8() {
        NumberSystem ns1 = new NumberSystem("20", 8);
        NumberSystem ns2 = new NumberSystem("4", 8);
        ns1.divi(ns2);
        assertEquals("4_8", ns1.toString());
    }

    @Test
    public void testAddRadix16() {
        NumberSystem ns1 = new NumberSystem("A", 16);
        NumberSystem ns2 = new NumberSystem("5", 16);
        ns1.add(ns2);
        assertEquals("f_16", ns1.toString());
    }

    @Test
    public void testSubtRadix16() {
        NumberSystem ns1 = new NumberSystem("B", 16);
        NumberSystem ns2 = new NumberSystem("5", 16);
        ns1.subt(ns2);
        assertEquals("6_16", ns1.toString());
    }

    @Test
    public void testMultRadix16() {
        NumberSystem ns1 = new NumberSystem("7", 16);
        NumberSystem ns2 = new NumberSystem("3", 16);
        ns1.mult(ns2);
        assertEquals("15_16", ns1.toString()); // 7 * 3 = 21 in decimal, which is 15 in hex
    }

    @Test
    public void testDiviRadix16() {
        NumberSystem ns1 = new NumberSystem("20", 16);
        NumberSystem ns2 = new NumberSystem("4", 16);
        ns1.divi(ns2);
        assertEquals("8_16", ns1.toString());
    }
}
