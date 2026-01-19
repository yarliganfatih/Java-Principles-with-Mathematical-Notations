package oop.math.numbers.numberSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import oop.math.numbers.NumberSystem;

public class BinaryNumberOperationsTest {
    @Test
    public void testAddDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAddEffectOther() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.add(ns2);
        assertEquals("101_2", ns2.toString());
        assertNotEquals("1010_2", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1010, 0101, 1111_2",
            "1010, -0101, 101_2",
            "-1010, -0101, -1111_2",
            "-1010, 0101, -101_2"
    })
    public void testAdd(String val1, String val2, String expected) {
        BinaryNumber ns1 = new BinaryNumber(val1);
        BinaryNumber ns2 = new BinaryNumber(val2);
        ns1.add(ns2);
        assertEquals(expected, ns1.toString());
    }

    @Test
    public void testSubtDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubtEffectOther() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.subt(ns2);
        assertEquals("101_2", ns2.toString());
        assertNotEquals("1010_2", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1010, 0101, 101_2",
            "1010, -0101, 1111_2",
            "-1010, -0101, -101_2",
            "-1010, 0101, -1111_2"
    })
    public void testSubt(String val1, String val2, String expected) {
        BinaryNumber ns1 = new BinaryNumber(val1);
        BinaryNumber ns2 = new BinaryNumber(val2);
        ns1.subt(ns2);
        assertEquals(expected, ns1.toString());
    }

    @Test
    public void testMultDifferentRadix() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMultEffectOther() {
        BinaryNumber ns1 = new BinaryNumber("1010");
        BinaryNumber ns2 = new BinaryNumber("0101");
        ns1.mult(ns2);
        assertEquals("101_2", ns2.toString());
        assertNotEquals("1010_2", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1010, 0101, 110010_2",
            "1010, -0101, -110010_2",
            "-1010, 0101, -110010_2",
            "-1010, -0101, 110010_2"
    })
    public void testMult(String val1, String val2, String expected) {
        BinaryNumber ns1 = new BinaryNumber(val1);
        BinaryNumber ns2 = new BinaryNumber(val2);
        ns1.mult(ns2);
        assertEquals(expected, ns1.toString());
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
    public void testDiviEffectOther() {
        BinaryNumber ns1 = new BinaryNumber("1100100");
        BinaryNumber ns2 = new BinaryNumber("110010");
        ns1.divi(ns2);
        assertEquals("110010_2", ns2.toString());
        assertNotEquals("1100100_2", ns1.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1100100, 110010, 10_2",
            "1011, 0101, 10_2",
            "1011, -0101, -10_2",
            "-1011, 0101, -10_2",
            "-1011, -0101, 10_2",
            "-1011, 110010, 0_2"
    })
    public void testDivi(String val1, String val2, String expected) {
        BinaryNumber ns1 = new BinaryNumber(val1);
        BinaryNumber ns2 = new BinaryNumber(val2);
        ns1.divi(ns2);
        assertEquals(expected, ns1.toString());
    }
}
