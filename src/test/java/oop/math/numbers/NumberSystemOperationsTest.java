package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberSystemOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 9);
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddEffectOther() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("5", ns2.toString()); // should not be affected
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testAddRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtEffectOther() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("5", ns2.toString()); // should not be affected
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testSubtRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultEffectOther() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.mult(ns2);
        assertEquals("5", ns2.toString()); // should not be affected
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testMultRadix10() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
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
    public void testDiviEffectOther() {
        NumberSystem ns1 = new NumberSystem("100", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("50", ns2.toString()); // should not be affected
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDiviRadix10() {
        NumberSystem ns1 = new NumberSystem("100", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testAddRadix3() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("2", 3);
        ns1.add(ns2);
        assertEquals("12_3", ns1.toString());
    }

    @Test
    public void testAddRadix15() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("5", 15);
        ns1.add(ns2);
        assertEquals("10_15", ns1.toString());
    }

    @Test
    public void testAddRadix36() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("5", 36);
        ns1.add(ns2);
        assertEquals("1f_36", ns1.toString());
    }

    @Test
    public void testSubtRadix3() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("2", 3);
        ns1.subt(ns2);
        assertEquals("1_3", ns1.toString());
    }

    @Test
    public void testSubtRadix15() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("5", 15);
        ns1.subt(ns2);
        assertEquals("5_15", ns1.toString());
    }

    @Test
    public void testSubtRadix36() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("5", 36);
        ns1.subt(ns2);
        assertEquals("15_36", ns1.toString());
    }

    @Test
    public void testMultRadix3() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("2", 3);
        ns1.mult(ns2);
        assertEquals("20_3", ns1.toString());
    }

    @Test
    public void testMultRadix15() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("5", 15);
        ns1.mult(ns2);
        assertEquals("35_15", ns1.toString());
    }

    @Test
    public void testMultRadix36() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("5", 36);
        ns1.mult(ns2);
        assertEquals("6e_36", ns1.toString());
    }

    @Test
    public void testDiviRadix3() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("2", 3);
        ns1.divi(ns2);
        assertEquals("1_3", ns1.toString());
    }

    @Test
    public void testDiviRadix15() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("5", 15);
        ns1.divi(ns2);
        assertEquals("2_15", ns1.toString());
    }

    @Test
    public void testDiviRadix36() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("5", 36);
        ns1.divi(ns2);
        assertEquals("9_36", ns1.toString());
    }

    @Test
    public void testAddRadix3Negative() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("-2", 3);
        ns1.add(ns2);
        assertEquals("1_3", ns1.toString());
    }

    @Test
    public void testAddRadix15Negative() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("-5", 15);
        ns1.add(ns2);
        assertEquals("5_15", ns1.toString());
    }

    @Test
    public void testAddRadix36Negative() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("-5", 36);
        ns1.add(ns2);
        assertEquals("15_36", ns1.toString());
    }

    @Test
    public void testMultRadix3Negative() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("-2", 3);
        ns1.mult(ns2);
        assertEquals("-20_3", ns1.toString());
    }

    @Test
    public void testMultRadix15Negative() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("-5", 15);
        ns1.mult(ns2);
        assertEquals("-35_15", ns1.toString());
    }

    @Test
    public void testMultRadix36Negative() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("-5", 36);
        ns1.mult(ns2);
        assertEquals("-6e_36", ns1.toString());
    }

    @Test
    public void testDiviRadix3Negative() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("-2", 3);
        ns1.divi(ns2);
        assertEquals("-1_3", ns1.toString());
    }

    @Test
    public void testDiviRadix15Negative() {
        NumberSystem ns1 = new NumberSystem("A", 15);
        NumberSystem ns2 = new NumberSystem("-5", 15);
        ns1.divi(ns2);
        assertEquals("-2_15", ns1.toString());
    }

    @Test
    public void testDiviRadix36Negative() {
        NumberSystem ns1 = new NumberSystem("1a", 36);
        NumberSystem ns2 = new NumberSystem("-5", 36);
        ns1.divi(ns2);
        assertEquals("-9_36", ns1.toString());
    }
}
