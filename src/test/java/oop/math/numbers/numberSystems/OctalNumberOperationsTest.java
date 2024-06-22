package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import oop.math.numbers.NumberSystem;

public class OctalNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        OctalNumber ns1 = new OctalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddEffectOther() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.add(ns2);
        assertEquals("5_8", ns2.toString());
        assertEquals("15_8", ns1.toString());
    }

    @Test
    public void testAdd() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.add(ns2);
        assertEquals("15_8", ns1.toString());
    }

    @Test
    public void testAddNegative() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.add(ns2);
        assertEquals("3_8", ns1.toString());
    }

    @Test
    public void testAddBothNegative() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.add(ns2);
        assertEquals("-15_8", ns1.toString());
    }

    @Test
    public void testAddMixed() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.add(ns2);
        assertEquals("-3_8", ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        OctalNumber ns1 = new OctalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtEffectOther() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.subt(ns2);
        assertEquals("5_8", ns2.toString());
        assertEquals("3_8", ns1.toString());
    }

    @Test
    public void testSubt() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.subt(ns2);
        assertEquals("3_8", ns1.toString());
    }

    @Test
    public void testSubtNegative() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.subt(ns2);
        assertEquals("15_8", ns1.toString());
    }

    @Test
    public void testSubtBothNegative() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.subt(ns2);
        assertEquals("-3_8", ns1.toString());
    }

    @Test
    public void testSubtMixed() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.subt(ns2);
        assertEquals("-15_8", ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        OctalNumber ns1 = new OctalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultEffectOther() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.mult(ns2);
        assertEquals("5_8", ns2.toString());
        assertEquals("50_8", ns1.toString());
    }

    @Test
    public void testMult() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.mult(ns2);
        assertEquals("50_8", ns1.toString());
    }

    @Test
    public void testMultNegative() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.mult(ns2);
        assertEquals("-50_8", ns1.toString());
    }

    @Test
    public void testMultMixed() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("5");
        ns1.mult(ns2);
        assertEquals("-50_8", ns1.toString());
    }

    @Test
    public void testMultBothNegative() {
        OctalNumber ns1 = new OctalNumber("-10");
        OctalNumber ns2 = new OctalNumber("-5");
        ns1.mult(ns2);
        assertEquals("50_8", ns1.toString());
    }

    @Test
    public void testDiviDifferentRadix() {
        OctalNumber ns1 = new OctalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviByZero() {
        OctalNumber ns1 = new OctalNumber("10");
        OctalNumber ns2 = new OctalNumber("0");
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviEffectOther() {
        OctalNumber ns1 = new OctalNumber("100");
        OctalNumber ns2 = new OctalNumber("20");
        ns1.divi(ns2);
        assertEquals("20_8", ns2.toString());
        assertEquals("4_8", ns1.toString());
    }

    @Test
    public void testDivi() {
        OctalNumber ns1 = new OctalNumber("100");
        OctalNumber ns2 = new OctalNumber("20");
        ns1.divi(ns2);
        assertEquals("4_8", ns1.toString());
    }

    @Test
    public void testDiviRemainder() {
        OctalNumber ns1 = new OctalNumber("11");
        OctalNumber ns2 = new OctalNumber("2");
        ns1.divi(ns2);
        assertEquals("4_8", ns1.toString());
    }

    @Test
    public void testDiviNegative() {
        OctalNumber ns1 = new OctalNumber("11");
        OctalNumber ns2 = new OctalNumber("-2");
        ns1.divi(ns2);
        assertEquals("-4_8", ns1.toString());
    }

    @Test
    public void testDiviMixed() {
        OctalNumber ns1 = new OctalNumber("-11");
        OctalNumber ns2 = new OctalNumber("2");
        ns1.divi(ns2);
        assertEquals("-4_8", ns1.toString());
    }

    @Test
    public void testDiviBothNegative() {
        OctalNumber ns1 = new OctalNumber("-11");
        OctalNumber ns2 = new OctalNumber("-2");
        ns1.divi(ns2);
        assertEquals("4_8", ns1.toString());
    }

    @Test
    public void testDiviSmallDivisor() {
        OctalNumber ns1 = new OctalNumber("-11");
        OctalNumber ns2 = new OctalNumber("20");
        ns1.divi(ns2);
        assertEquals("0_8", ns1.toString());
    }
}
