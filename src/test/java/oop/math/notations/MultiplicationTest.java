package oop.math.notations;
import org.junit.jupiter.api.Test;

import oop.math.interfaces.Notation;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {

    @Test
    public void testDefaultConstructor() {
        Multiplication m = new Multiplication();
        assertTrue(m.getElements().isEmpty());
        assertEquals(1.0, m.result());
        assertEquals("", m.toString());
    }

    @Test
    public void testSingleParameterConstructor() {
        Exponential e = new Exponential(2, 3);
        Multiplication m = new Multiplication(e);
        assertEquals(8.0, m.result());
        assertEquals("(2^3)", m.toString());
    }

    @Test
    public void testCopyConstructor() {
        Exponential e1 = new Exponential(2, 3);
        Multiplication m1 = new Multiplication(e1);
        Multiplication m2 = new Multiplication(m1);
        assertEquals(8.0, m2.result());
        assertEquals("(2^3)", m2.toString());
    }

    @Test
    public void testStringConstructor() {
        Multiplication m = new Multiplication("2^3 x 3^2");
        assertEquals(72.0, m.result());
        assertEquals("(2^3) x (3^2)", m.toString());
    }

    @Test
    public void testInterpret() {
        Notation n1 = Notation.interpret("√9 x 3^-2 x 3√27");
        assertTrue(n1 instanceof Multiplication);
        assertEquals(1.0, n1.result());
        assertEquals("(√9) x (3^-2) x (3√27)", n1.toString());
    }

    @Test
    public void testReverse() {
        Multiplication m = new Multiplication("2^3 x 3^2");
        m.reverse();
        assertEquals(0.013888888888888888, m.result(), 1e-10);
        assertEquals("(2^-3) x (3^-2)", m.toString());
    }
    
    @Test
    public void test_Reverse() {
        Multiplication m = new Multiplication(new Exponential(2, 3));
        Multiplication reversed = m._reverse();
        assertEquals("(2^3) x (-1)", reversed.toString());
    }

    @Test
    public void testToSummation() {
        Multiplication m = new Multiplication(new Exponential(2, 3));
        Summation s = m.toSummation();
        assertNotNull(s);
        assertEquals("[(2^3)]", s.toString());
    }
}