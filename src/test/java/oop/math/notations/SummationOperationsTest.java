package oop.math.notations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SummationOperationsTest {
    @Test
    public void testAddSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1.add(s2);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.add(new Multiplication(new Exponential(3)));
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.add(new Exponential(3));
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.add(3);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1._add(s2);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._add(new Multiplication(new Exponential(3)));
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._add(new Exponential(3));
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._add(3);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testSubtSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1.subt(s2);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.subt(new Multiplication(new Exponential(3)));
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.subt(new Exponential(3));
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s.subt(3);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1._subt(s2);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._subt(new Multiplication(new Exponential(3)));
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._subt(new Exponential(3));
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Summation result = s._subt(3);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }
}