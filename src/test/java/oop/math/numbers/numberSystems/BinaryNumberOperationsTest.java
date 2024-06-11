package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.numbers.NumberSystem;

public class BinaryNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAdd() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.add(ns2);
        assertEquals("1111_2", ns1.toString());
    }

    @Test
    public void testAddNegative() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.add(ns2);
        assertEquals("101_2", ns1.toString());
    }

    @Test
    public void testAddBothNegative() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.add(ns2);
        assertEquals("-1111_2", ns1.toString());
    }

    @Test
    public void testAddMixed() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.add(ns2);
        assertEquals("-101_2", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubt() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.subt(ns2);
        assertEquals("101_2", ns1.toString());
    }

    @Test
    public void testSubtNegative() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.subt(ns2);
        assertEquals("1111_2", ns1.toString());
    }

    @Test
    public void testSubtBothNegative() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.subt(ns2);
        assertEquals("-101_2", ns1.toString());
    }

    @Test
    public void testSubtMixed() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.subt(ns2);
        assertEquals("-1111_2", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMult() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.mult(ns2);
        assertEquals("110010_2", ns1.toString());
    }

    @Test
    public void testMultNegative() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.mult(ns2);
        assertEquals("-110010_2", ns1.toString());
    }

    @Test
    public void testMultMixed() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.mult(ns2);
        assertEquals("-110010_2", ns1.toString());
    }

    @Test
    public void testMultBothNegative() {
        BinaryNumber ns1 = new BinaryNumber("-1010");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.mult(ns2);
        assertEquals("110010_2", ns1.toString());
    }

    @Test
    public void testDiviDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 9);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviByZero() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0");
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDivi() {
        BinaryNumber ns1 = new BinaryNumber("1100100");
        BinaryNumber ns2 = new BinaryNumber("110010");
        ns1.divi(ns2);
        assertEquals("10_2", ns1.toString());
    }

    @Test
    public void testDiviRemainder() {
        BinaryNumber ns1 = new BinaryNumber("1011");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.divi(ns2);
        assertEquals("10_2", ns1.toString());
    }

    @Test
    public void testDiviNegative() {
        BinaryNumber ns1 = new BinaryNumber("1011");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.divi(ns2);
        assertEquals("-10_2", ns1.toString());
    }

    @Test
    public void testDiviMixed() {
        BinaryNumber ns1 = new BinaryNumber("-1011");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.divi(ns2);
        assertEquals("-10_2", ns1.toString());
    }

    @Test
    public void testDiviBothNegative() {
        BinaryNumber ns1 = new BinaryNumber("-1011");
        BinaryNumber ns2 = new BinaryNumber("-0101");
        ns1.divi(ns2);
        assertEquals("10_2", ns1.toString());
    }

    @Test
    public void testDiviSmallDivisor() {
        BinaryNumber ns1 = new BinaryNumber("-1011");
        BinaryNumber ns2 = new BinaryNumber("110010");
        ns1.divi(ns2);
        assertEquals("0_2", ns1.toString());
    }
}
