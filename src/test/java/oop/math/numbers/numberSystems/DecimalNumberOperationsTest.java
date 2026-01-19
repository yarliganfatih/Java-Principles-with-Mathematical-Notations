package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import oop.math.numbers.NumberSystem;

public class DecimalNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddEffectOther() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.add(ns2);
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "10, -5, 5",
            "-10, -5, -15",
            "-10, 5, -5"
    })
    public void testAdd(String val1, String val2, String expected) {
        DecimalNumber ns1 = new DecimalNumber(val1);
        DecimalNumber ns2 = new DecimalNumber(val2);
        ns1.add(ns2);
        assertEquals(expected, ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtEffectOther() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.subt(ns2);
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "10, -5, 15",
            "-10, -5, -5",
            "-10, 5, -15"
    })
    public void testSubt(String val1, String val2, String expected) {
        DecimalNumber ns1 = new DecimalNumber(val1);
        DecimalNumber ns2 = new DecimalNumber(val2);
        ns1.subt(ns2);
        assertEquals(expected, ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        DecimalNumber ns1 = new DecimalNumber("10");
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultEffectOther() {
        DecimalNumber ns1 = new DecimalNumber("10");
        DecimalNumber ns2 = new DecimalNumber("5");
        ns1.mult(ns2);
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50",
            "10, -5, -50",
            "-10, 5, -50",
            "-10, -5, 50"
    })
    public void testMult(String val1, String val2, String expected) {
        DecimalNumber ns1 = new DecimalNumber(val1);
        DecimalNumber ns2 = new DecimalNumber(val2);
        ns1.mult(ns2);
        assertEquals(expected, ns1.toString());
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
    public void testDiviEffectOther() {
        DecimalNumber ns1 = new DecimalNumber("100");
        DecimalNumber ns2 = new DecimalNumber("50");
        ns1.divi(ns2);
        assertEquals("50", ns2.toString());
        assertNotEquals("100", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 50, 2",
            "11, 5, 2",
            "11, -5, -2",
            "-11, 5, -2",
            "-11, -5, 2",
            "-11, 50, 0"
    })
    public void testDivi(String val1, String val2, String expected) {
        DecimalNumber ns1 = new DecimalNumber(val1);
        DecimalNumber ns2 = new DecimalNumber(val2);
        ns1.divi(ns2);
        assertEquals(expected, ns1.toString());
    }
}
