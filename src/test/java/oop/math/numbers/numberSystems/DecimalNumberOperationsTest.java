package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.numbers.NumberSystem;

public class DecimalNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAdd() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.add(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testAddNegative() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.add(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testAddBothNegative() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.add(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testAddMixed() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.add(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubt() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testSubtNegative() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.subt(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testSubtBothNegative() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.subt(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubtMixed() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMult() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testMultNegative() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMultMixed() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMultBothNegative() {
        DecimalNumber ns1 = new DecimalNumber("-10");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testDiviDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 9);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviByZero() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("0");
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDivi() {
        DecimalNumber ns1 = new DecimalNumber("100");
        DecimalNumber ns2 = new DecimalNumber("50");
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviRemainder() {
        DecimalNumber ns1 = new DecimalNumber("11");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviNegative() {
        DecimalNumber ns1 = new DecimalNumber("11");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDiviMixed() {
        DecimalNumber ns1 = new DecimalNumber("-11");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDiviBothNegative() {
        DecimalNumber ns1 = new DecimalNumber("-11");
        DecimalNumber ns2 = new DecimalNumber("-5");
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviSmallDivisor() {
        DecimalNumber ns1 = new DecimalNumber("-11");
        DecimalNumber ns2 = new DecimalNumber("50");
        ns1.divi(ns2);
        assertEquals("0", ns1.toString());
    }
}
