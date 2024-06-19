package oop.math.notations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MultiplicationOperationsTest {
    @Test
    public void testMultMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        m1.mult(m2);
        assertEquals("(3)", m2.toString()); // should not be affected
        assertEquals("(2) x (3)", m1.toString());
        assertEquals(6.0, m1.result());
    }

    @Test
    public void testMultExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        m.mult(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("(2) x (3)", m.toString());
        assertEquals(6.0, m.result());
    }

    @Test
    public void testMultInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        m.mult(3);
        assertEquals("(2) x (3)", m.toString());
        assertEquals(6.0, m.result());
    }

    @Test
    public void test_diviMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        m1.divi(m2);
        assertEquals("(3)", m2.toString()); // should not be affected
        assertEquals("(2) x (3^-1)", m1.toString());
        assertEquals(2.0 / 3.0, m1.result());
    }

    @Test
    public void test_diviExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        m.divi(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("(2) x (3^-1)", m.toString());
        assertEquals(2.0 / 3.0, m.result());
    }

    @Test
    public void test_diviInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        m.divi(3);
        assertEquals("(2) x (3^-1)", m.toString());
        assertEquals(2.0 / 3.0, m.result());
    }

    @Test
    public void testMultLayerMultMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        assertEquals("(3)", m2.toString()); // should not be affected
        Multiplication result = m1._mult(m2);
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void testMultLayerMultExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        Multiplication result = m._mult(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void testMultLayerMultInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        Multiplication result = m._mult(3);
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void testDiviLayerDiviMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        Multiplication result = m1._divi(m2);
        assertEquals("(3)", m2.toString()); // should not be affected
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void testDiviLayerDiviExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        Multiplication result = m._divi(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void testDiviLayerDiviInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        Multiplication result = m._divi(3);
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void testAddSummation() {
        Multiplication m = new Multiplication(new Exponential(2));
        Summation s = new Summation(new Multiplication(new Exponential(3)));
        Summation result = m._add(s);
        assertEquals("[(3)]", s.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        Summation result = m1._add(m2);
        assertEquals("(3)", m2.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        Summation result = m._add(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        Summation result = m._add(3);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testSubtSummation() {
        Multiplication m = new Multiplication(new Exponential(2));
        Summation s = new Summation(new Multiplication(new Exponential(3)));
        Summation result = m._subt(s);
        assertEquals("[(3)]", s.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtMultiplication() {
        Multiplication m1 = new Multiplication(new Exponential(2));
        Multiplication m2 = new Multiplication(new Exponential(3));
        Summation result = m1._subt(m2);
        assertEquals("(3)", m2.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtExponential() {
        Multiplication m = new Multiplication(new Exponential(2));
        Exponential e = new Exponential(3);
        Summation result = m._subt(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtInteger() {
        Multiplication m = new Multiplication(new Exponential(2));
        Summation result = m._subt(3);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }
}