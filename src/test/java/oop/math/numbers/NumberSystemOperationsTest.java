package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 5, 10, 15",
            "10, 3, 2, 3, 12_3",
            "A, 15, 5, 15, 10_15",
            "1a, 36, 5, 36, 1f_36",
            "10, 3, -2, 3, 1_3",
            "A, 15, -5, 15, 5_15",
            "1a, 36, -5, 36, 15_36"
    })
    public void testAdd(String val1, int radix1, String val2, int radix2, String expected) {
        NumberSystem ns1 = new NumberSystem(val1, radix1);
        NumberSystem ns2 = new NumberSystem(val2, radix2);
        ns1.add(ns2);
        assertEquals(expected, ns1.toString());
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
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 5, 10, 5",
            "10, 3, 2, 3, 1_3",
            "A, 15, 5, 15, 5_15",
            "1a, 36, 5, 36, 15_36"
    })
    public void testSubt(String val1, int radix1, String val2, int radix2, String expected) {
        NumberSystem ns1 = new NumberSystem(val1, radix1);
        NumberSystem ns2 = new NumberSystem(val2, radix2);
        ns1.subt(ns2);
        assertEquals(expected, ns1.toString());
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
        assertEquals("5", ns2.toString());
        assertNotEquals("10", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 5, 10, 50",
            "10, 3, 2, 3, 20_3",
            "A, 15, 5, 15, 35_15",
            "1a, 36, 5, 36, 6e_36",
            "10, 3, -2, 3, -20_3",
            "A, 15, -5, 15, -35_15",
            "1a, 36, -5, 36, -6e_36"
    })
    public void testMult(String val1, int radix1, String val2, int radix2, String expected) {
        NumberSystem ns1 = new NumberSystem(val1, radix1);
        NumberSystem ns2 = new NumberSystem(val2, radix2);
        ns1.mult(ns2);
        assertEquals(expected, ns1.toString());
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
        assertEquals("50", ns2.toString());
        assertNotEquals("100", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10, 50, 10, 2",
            "10, 3, 2, 3, 1_3",
            "A, 15, 5, 15, 2_15",
            "1a, 36, 5, 36, 9_36",
            "10, 3, -2, 3, -1_3",
            "A, 15, -5, 15, -2_15",
            "1a, 36, -5, 36, -9_36"
    })
    public void testDivi(String val1, int radix1, String val2, int radix2, String expected) {
        NumberSystem ns1 = new NumberSystem(val1, radix1);
        NumberSystem ns2 = new NumberSystem(val2, radix2);
        ns1.divi(ns2);
        assertEquals(expected, ns1.toString());
    }

}
