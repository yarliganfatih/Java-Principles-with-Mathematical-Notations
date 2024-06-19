package oop.math.notations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SummationOperationsTest {
    @Test
    public void testAddSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        s1.add(s2);
        assertEquals("[(3)]", s2.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", s1.toString());
        assertEquals(5.0, s1.result());
    }

    @Test
    public void testAddMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Multiplication m = new Multiplication(new Exponential(3));
        s.add(m);
        assertEquals("(3)", m.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", s.toString());
        assertEquals(5.0, s.result());
    }

    @Test
    public void testAddExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Exponential e = new Exponential(3);
        s.add(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", s.toString());
        assertEquals(5.0, s.result());
    }

    @Test
    public void testAddInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        s.add(3);
        assertEquals("[(2)] + [(3)]", s.toString());
        assertEquals(5.0, s.result());
    }

    @Test
    public void testAddLayerAddSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1._add(s2);
        assertEquals("[(3)]", s2.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Multiplication m = new Multiplication(new Exponential(3));
        Summation result = s._add(m);
        assertEquals("(3)", m.toString()); // should not be affected
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void testAddLayerAddExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Exponential e = new Exponential(3);
        Summation result = s._add(e);
        assertEquals("3", e.toString()); // should not be affected
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
        s1.subt(s2);
        assertEquals("[(3)]", s2.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", s1.toString());
        assertEquals(-1.0, s1.result());
    }

    @Test
    public void testSubtMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Multiplication m = new Multiplication(new Exponential(3));
        s.subt(m);
        assertEquals("(3)", m.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", s.toString());
        assertEquals(-1.0, s.result());
    }

    @Test
    public void testSubtExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Exponential e = new Exponential(3);
        s.subt(e);
        assertEquals("3", e.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", s.toString());
        assertEquals(-1.0, s.result());
    }

    @Test
    public void testSubtInteger() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        s.subt(3);
        assertEquals("[(2)] + [(3) x (-1)]", s.toString());
        assertEquals(-1.0, s.result());
    }

    @Test
    public void testSubtLayerSubtSummation() {
        Summation s1 = new Summation(new Multiplication(new Exponential(2)));
        Summation s2 = new Summation(new Multiplication(new Exponential(3)));
        Summation result = s1._subt(s2);
        assertEquals("[(3)]", s2.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtMultiplication() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Multiplication m = new Multiplication(new Exponential(3));
        Summation result = s._subt(m);
        assertEquals("(3)", m.toString()); // should not be affected
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void testSubtLayerSubtExponential() {
        Summation s = new Summation(new Multiplication(new Exponential(2)));
        Exponential e = new Exponential(3);
        Summation result = s._subt(e);
        assertEquals("3", e.toString()); // should not be affected
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