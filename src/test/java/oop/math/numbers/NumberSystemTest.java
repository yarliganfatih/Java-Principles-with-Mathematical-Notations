package oop.math.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberSystemTest {

    @Test
    public void testDefaultConstructor() {
        NumberSystem ns = new NumberSystem();
        assertEquals(10, ns.radix);
        assertEquals(0, ns.digits);
        assertEquals("0", ns.toString());
    }

    @Test
    public void testConstructorWithNumber() {
        NumberSystem ns = new NumberSystem(123);
        assertEquals(123, ns.digits);
        assertEquals(10, ns.radix);
        assertEquals("123", ns.toString());
    }

    @Test
    public void testConstructorWithString() {
        NumberSystem ns = new NumberSystem("101", 2);
        assertEquals(101, ns.digits);
        assertEquals(+1, ns.sign);
        assertEquals(2, ns.radix);
        assertEquals("101_2", ns.toString());

        ns = new NumberSystem("-25", 10);
        assertEquals(25, ns.digits);
        assertEquals(-1, ns.sign);
        assertEquals(10, ns.radix);
        assertEquals("-25", ns.toString());
    }
}
