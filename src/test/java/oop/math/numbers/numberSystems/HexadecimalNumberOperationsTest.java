package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.numbers.NumberSystem;

public class HexadecimalNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddEffectOther() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.add(ns2);
        assertEquals("5_16", ns2.toString());
        assertEquals("15_16", ns1.toString());
    }

    @Test
    public void testAdd() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.add(ns2);
        assertEquals("15_16", ns1.toString());
    }

    @Test
    public void testAddNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.add(ns2);
        assertEquals("b_16", ns1.toString());
    }

    @Test
    public void testAddBothNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.add(ns2);
        assertEquals("-15_16", ns1.toString());
    }

    @Test
    public void testAddMixed() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.add(ns2);
        assertEquals("-b_16", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtEffectOther() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("5_16", ns2.toString());
        assertEquals("b_16", ns1.toString());
    }

    @Test
    public void testSubt() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("b_16", ns1.toString());
    }

    @Test
    public void testSubtNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.subt(ns2);
        assertEquals("15_16", ns1.toString());
    }

    @Test
    public void testSubtBothNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.subt(ns2);
        assertEquals("-b_16", ns1.toString());
    }

    @Test
    public void testSubtMixed() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("-15_16", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultEffectOther() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("5_16", ns2.toString());
        assertEquals("50_16", ns1.toString());
    }

    @Test
    public void testMult() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("50_16", ns1.toString());
    }

    @Test
    public void testMultNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.mult(ns2);
        assertEquals("-50_16", ns1.toString());
    }

    @Test
    public void testMultMixed() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("-50_16", ns1.toString());
    }

    @Test
    public void testMultBothNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-10");
        HexadecimalNumber ns2 = new HexadecimalNumber("-5");
        ns1.mult(ns2);
        assertEquals("50_16", ns1.toString());
    }

    @Test
    public void testDiviDifferentRadix() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviByZero() {
        HexadecimalNumber ns1 = new HexadecimalNumber("10");
        HexadecimalNumber ns2 = new HexadecimalNumber("0");
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviEffectOther() {
        HexadecimalNumber ns1 = new HexadecimalNumber("100");
        HexadecimalNumber ns2 = new HexadecimalNumber("10");
        ns1.divi(ns2);
        assertEquals("10_16", ns2.toString());
        assertEquals("10_16", ns1.toString());
    }

    @Test
    public void testDivi() {
        HexadecimalNumber ns1 = new HexadecimalNumber("100");
        HexadecimalNumber ns2 = new HexadecimalNumber("10");
        ns1.divi(ns2);
        assertEquals("10_16", ns1.toString());
    }

    @Test
    public void testDiviRemainder() {
        HexadecimalNumber ns1 = new HexadecimalNumber("11");
        HexadecimalNumber ns2 = new HexadecimalNumber("2");
        ns1.divi(ns2);
        assertEquals("8_16", ns1.toString());
    }

    @Test
    public void testDiviNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("11");
        HexadecimalNumber ns2 = new HexadecimalNumber("-2");
        ns1.divi(ns2);
        assertEquals("-8_16", ns1.toString());
    }

    @Test
    public void testDiviMixed() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-11");
        HexadecimalNumber ns2 = new HexadecimalNumber("2");
        ns1.divi(ns2);
        assertEquals("-8_16", ns1.toString());
    }

    @Test
    public void testDiviBothNegative() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-11");
        HexadecimalNumber ns2 = new HexadecimalNumber("-2");
        ns1.divi(ns2);
        assertEquals("8_16", ns1.toString());
    }

    @Test
    public void testDiviSmallDivisor() {
        HexadecimalNumber ns1 = new HexadecimalNumber("-11");
        HexadecimalNumber ns2 = new HexadecimalNumber("20");
        ns1.divi(ns2);
        assertEquals("0_16", ns1.toString());
    }
}
