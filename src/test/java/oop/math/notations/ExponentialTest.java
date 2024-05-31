package oop.math.notations;

import org.junit.jupiter.api.Test;

import oop.math.interfaces.Notation;

import static org.junit.jupiter.api.Assertions.*;

public class ExponentialTest {

    // Exponential class tests
    @Test
    public void testDefaultConstructor() {
        Exponential e = new Exponential();
        assertEquals(1.0, e.result());
        assertEquals("1", e.toString());
    }

    @Test
    public void testSingleParameterConstructor() {
        Exponential e = new Exponential(2);
        assertEquals(2.0, e.result());
        assertEquals("2", e.toString());
    }

    @Test
    public void testDoubleParameterConstructor() {
        Exponential e = new Exponential(3, 2);
        assertEquals(9.0, e.result());
        assertEquals("3^2", e.toString());
    }

    @Test
    public void testTripleParameterConstructor() {
        Exponential e = new Exponential(4, 1, 2);
        assertEquals(2.0, e.result());
        assertEquals("√4", e.toString());
    }

    @Test
    public void testStringConstructor() {
        Exponential e = new Exponential("2^3");
        assertEquals(8.0, e.result());
        assertEquals("2^3", e.toString());
    }

    @Test
    public void testStringConstructor2() {
        Exponential e = new Exponential("√2^4");
        assertEquals(4.0, e.result());
        assertEquals("√2^4", e.toString());
    }

    @Test
    public void testStringConstructor3() {
        Exponential e = new Exponential("4√2^4");
        assertEquals(2.0, e.result());
        assertEquals("4√2^4", e.toString());
    }

    @Test
    public void testInterpret() {
        Notation n1 = Notation.interpret("3^-2");
        assertTrue(n1 instanceof Exponential);
        assertEquals(0.1111111111111111, n1.result(), 1e-10);
        assertEquals("3^-2", n1.toString());
    }

    @Test
    public void testReverse() {
        Exponential e = new Exponential(3, 2);
        e.reverse();
        assertEquals(1.7320508075688772, e.result(), 1e-10);
        assertEquals("√3", e.toString());
    }

    @Test
    public void test_Reverse() {
        Exponential e = new Exponential(2, 3);
        Exponential reversed = e._reverse();
        assertEquals(0.125, e.result());
        assertEquals("2^-3", reversed.toString());
    }

    @Test
    public void testToMultiplication() {
        Exponential e = new Exponential(2, 3);
        Multiplication m = e.toMultiplication();
        assertNotNull(m);
        assertEquals("(2^3)", m.toString());
    }

    @Test
    public void testToSummation() {
        Exponential e = new Exponential(2, 3);
        Summation s = e.toSummation();
        assertNotNull(s);
        assertEquals("[(2^3)]", s.toString());
    }

    @Test
    public void testInvalidExponentConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Exponential(0, -1);
        });
        assertEquals("Denominator cannot be zero.", exception.getMessage());
    }

    // Rational class tests
    @Test
    public void testRationalInvalidDenominator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Exponential.Rational(1, 0);
        });
        assertEquals("Denominator cannot be zero.", exception.getMessage());
    }
    
    @Test
    public void testDefaultRationalConstructor() {
        Exponential.Rational r = new Exponential.Rational();
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
        assertEquals("0", r.toString());
    }

    @Test
    public void testSingleParameterRationalConstructor() {
        Exponential.Rational r = new Exponential.Rational(3);
        assertEquals(3, r.getNumerator());
        assertEquals(1, r.getDenominator());
        assertEquals("3", r.toString());
    }

    @Test
    public void testDoubleParameterRationalConstructor() {
        Exponential.Rational r = new Exponential.Rational(3, 4);
        assertEquals(3, r.getNumerator());
        assertEquals(4, r.getDenominator());
        assertEquals("3/4", r.toString());
    }

    @Test
    public void testRationalReverse() {
        Exponential.Rational r = new Exponential.Rational(3, 4);
        r._reverse();
        assertEquals(4, r.getNumerator());
        assertEquals(3, r.getDenominator());
        assertEquals("4/3", r.toString());
    }

    @Test
    public void testRationalMultRational() {
        Exponential.Rational r1 = new Exponential.Rational(2, 3);
        Exponential.Rational r2 = new Exponential.Rational(3, 4);
        r1.mult(r2);
        assertEquals(6, r1.getNumerator());
        assertEquals(12, r1.getDenominator());
        assertEquals("6/12", r1.toString());
    }

    @Test
    public void testRationalMultInteger() {
        Exponential.Rational r = new Exponential.Rational(2, 3);
        r.mult(4);
        assertEquals(8, r.getNumerator());
        assertEquals(3, r.getDenominator());
        assertEquals("8/3", r.toString());
    }

    @Test
    public void testRationalResult() {
        Exponential.Rational r = new Exponential.Rational(3, 4);
        assertEquals(0.75, r.result(), 1e-10);
    }

}
