package oop.math.notations;

import org.junit.jupiter.api.Test;

import oop.math.interfaces.Notation;

import static org.junit.jupiter.api.Assertions.*;

public class SummationTest {

    @Test
    public void testDefaultConstructor() {
        Summation s = new Summation();
        assertTrue(s.getElements().isEmpty());
        assertEquals(0.0, s.result());
        assertEquals("", s.toString());
    }

    @Test
    public void testSingleParameterConstructor() {
        Multiplication m = new Multiplication(new Exponential(2, 3));
        Summation s = new Summation(m);
        assertEquals(8.0, s.result());
        assertEquals("[(2^3)]", s.toString());
    }

    @Test
    public void testCopyConstructor() {
        Multiplication m = new Multiplication(new Exponential(2, 3));
        Summation s1 = new Summation(m);
        Summation s2 = new Summation(s1);
        assertEquals(8.0, s2.result());
        assertEquals("[(2^3)]", s2.toString());
    }

    @Test
    public void testStringConstructor() {
        Summation s = new Summation("[2^3] + [3^2]");
        assertEquals(17.0, s.result());
        assertEquals("[(2^3)] + [(3^2)]", s.toString());
    }

    @Test
    public void testInterpret() {
        Notation n1 = Notation.interpret("[(7) x (2) x (2^2)] + [(√9) x (4√16) x (7) x (2) x (3^-2) x (3√27)]");
        assertTrue(n1 instanceof Summation);
        assertEquals(84.0, n1.result());
        assertEquals("[(7) x (2) x (2^2)] + [(√9) x (4√16) x (7) x (2) x (3^-2) x (3√27)]", n1.toString());
    }

    @Test
    public void testReverse() {
        Summation s = new Summation("[2^3] + [3^2]");
        s.reverse();
        assertEquals(-17.0, s.result());
        assertEquals("[(2^3) x (-1)] + [(3^2) x (-1)]", s.toString());
    }
}
