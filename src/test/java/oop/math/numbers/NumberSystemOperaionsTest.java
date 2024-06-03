package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberSystemOperaionsTest {
    @Test
    public void testAdd() {
        NumberSystem ns1 = new NumberSystem("10", 9);
        NumberSystem ns2 = new NumberSystem("5", 8);
        assertThrows(IllegalArgumentException.class, () -> ns1.add(ns2));
    }

    @Test
    public void testAdd1() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testAdd2() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.add(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testAdd3() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.add(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testAdd4() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.add(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubt() {
        NumberSystem ns1 = new NumberSystem("10", 3);
        NumberSystem ns2 = new NumberSystem("5", 6);
        assertThrows(IllegalArgumentException.class, () -> ns1.subt(ns2));
    }

    @Test
    public void testSubt1() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("5", ns1.toString());
    }

    @Test
    public void testSubt2() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.subt(ns2);
        assertEquals("15", ns1.toString());
    }

    @Test
    public void testSubt3() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.subt(ns2);
        assertEquals("-5", ns1.toString());
    }

    @Test
    public void testSubt4() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.subt(ns2);
        assertEquals("-15", ns1.toString());
    }

    @Test
    public void testMult() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 11);
        assertThrows(IllegalArgumentException.class, () -> ns1.mult(ns2));
    }

    @Test
    public void testMult1() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testMult2() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMult3() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.mult(ns2);
        assertEquals("-50", ns1.toString());
    }

    @Test
    public void testMult4() {
        NumberSystem ns1 = new NumberSystem("-10", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.mult(ns2);
        assertEquals("50", ns1.toString());
    }

    @Test
    public void testDivi() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("5", 9);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDiviZero() {
        NumberSystem ns1 = new NumberSystem("10", 10);
        NumberSystem ns2 = new NumberSystem("0", 10);
        assertThrows(IllegalArgumentException.class, () -> ns1.divi(ns2));
    }

    @Test
    public void testDivi1() {
        NumberSystem ns1 = new NumberSystem("100", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDivi2() {
        NumberSystem ns1 = new NumberSystem("11", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDivi3() {
        NumberSystem ns1 = new NumberSystem("11", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDivi4() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("5", 10);
        ns1.divi(ns2);
        assertEquals("-2", ns1.toString());
    }

    @Test
    public void testDivi5() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("-5", 10);
        ns1.divi(ns2);
        assertEquals("2", ns1.toString());
    }

    @Test
    public void testDivi6() {
        NumberSystem ns1 = new NumberSystem("-11", 10);
        NumberSystem ns2 = new NumberSystem("50", 10);
        ns1.divi(ns2);
        assertEquals("0", ns1.toString());
    }
}
