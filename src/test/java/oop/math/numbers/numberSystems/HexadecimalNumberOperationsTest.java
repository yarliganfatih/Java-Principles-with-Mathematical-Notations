package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertNotEquals("10_16", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15_16",
            "10, -5, b_16",
            "-10, -5, -15_16",
            "-10, 5, -b_16"
    })
    public void testAdd(String val1, String val2, String expected) {
        HexadecimalNumber ns1 = new HexadecimalNumber(val1);
        HexadecimalNumber ns2 = new HexadecimalNumber(val2);
        ns1.add(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("10_16", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, b_16",
            "10, -5, 15_16",
            "-10, -5, -b_16",
            "-10, 5, -15_16"
    })
    public void testSubt(String val1, String val2, String expected) {
        HexadecimalNumber ns1 = new HexadecimalNumber(val1);
        HexadecimalNumber ns2 = new HexadecimalNumber(val2);
        ns1.subt(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("10_16", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50_16",
            "10, -5, -50_16",
            "-10, 5, -50_16",
            "-10, -5, 50_16"
    })
    public void testMult(String val1, String val2, String expected) {
        HexadecimalNumber ns1 = new HexadecimalNumber(val1);
        HexadecimalNumber ns2 = new HexadecimalNumber(val2);
        ns1.mult(ns2);
        assertEquals(expected, ns1.toString());
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
        assertNotEquals("100_16", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10, 10_16",
            "11, 2, 8_16",
            "11, -2, -8_16",
            "-11, 2, -8_16",
            "-11, -2, 8_16",
            "-11, 20, 0_16"
    })
    public void testDivi(String val1, String val2, String expected) {
        HexadecimalNumber ns1 = new HexadecimalNumber(val1);
        HexadecimalNumber ns2 = new HexadecimalNumber(val2);
        ns1.divi(ns2);
        assertEquals(expected, ns1.toString());
    }
}
