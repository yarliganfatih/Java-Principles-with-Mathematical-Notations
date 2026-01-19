package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertNotEquals("10_8", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15_8",
            "10, -5, 3_8",
            "-10, -5, -15_8",
            "-10, 5, -3_8"
    })
    public void testAdd(String val1, String val2, String expected) {
        OctalNumber ns1 = new OctalNumber(val1);
        OctalNumber ns2 = new OctalNumber(val2);
        ns1.add(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("10_8", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 3_8",
            "10, -5, 15_8",
            "-10, -5, -3_8",
            "-10, 5, -15_8"
    })
    public void testSubt(String val1, String val2, String expected) {
        OctalNumber ns1 = new OctalNumber(val1);
        OctalNumber ns2 = new OctalNumber(val2);
        ns1.subt(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("10_8", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50_8",
            "10, -5, -50_8",
            "-10, 5, -50_8",
            "-10, -5, 50_8"
    })
    public void testMult(String val1, String val2, String expected) {
        OctalNumber ns1 = new OctalNumber(val1);
        OctalNumber ns2 = new OctalNumber(val2);
        ns1.mult(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("100_8", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 20, 4_8",
            "11, 2, 4_8",
            "11, -2, -4_8",
            "-11, 2, -4_8",
            "-11, -2, 4_8",
            "-11, 20, 0_8"
    })
    public void testDivi(String val1, String val2, String expected) {
        OctalNumber ns1 = new OctalNumber(val1);
        OctalNumber ns2 = new OctalNumber(val2);
        ns1.divi(ns2);
        assertEquals(expected, ns1.toString());
    }
}
