package oop.math.notations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import oop.math.notations.Exponential.Rational;

public class ExponentialOperationsTest {

    @Test
    public void testSqrtRational() {
        Exponential e = new Exponential(4);
        Rational r = new Rational(2);
        e.sqrt(r);
        assertEquals("2", r.toString());
        assertEquals("√4", e.toString());
        assertEquals(2.0, e.result());
    }

    @Test
    public void testSqrtInteger() {
        Exponential e = new Exponential(4);
        e.sqrt(2);
        assertEquals("√4", e.toString());
        assertEquals(2.0, e.result());
    }

    @Test
    public void test_SqrtRational() {
        Exponential e = new Exponential(4);
        Rational r = new Rational(2);
        Exponential result = e._sqrt(r);
        assertEquals("2", r.toString());
        assertEquals("√4", result.toString());
        assertEquals(2.0, result.result());
    }

    @Test
    public void test_SqrtInteger() {
        Exponential e = new Exponential(4);
        Exponential result = e._sqrt(2);
        assertEquals("√4", result.toString());
        assertEquals(2.0, result.result());
    }

    @Test
    public void testPowRational() {
        Exponential e = new Exponential(2);
        Rational r = new Rational(3);
        e.pow(r);
        assertEquals("3", r.toString());
        assertEquals("2^3", e.toString());
        assertEquals(8.0, e.result());
    }

    @Test
    public void testPowInteger() {
        Exponential e = new Exponential(2);
        e.pow(3);
        assertEquals("2^3", e.toString());
        assertEquals(8.0, e.result());
    }

    @Test
    public void test_PowRational() {
        Exponential e = new Exponential(2);
        Rational r = new Rational(3);
        Exponential result = e._pow(r);
        assertEquals("3", r.toString());
        assertEquals("2^3", result.toString());
        assertEquals(8.0, result.result());
    }

    @Test
    public void test_PowInteger() {
        Exponential e = new Exponential(2);
        Exponential result = e._pow(3);
        assertEquals("2^3", result.toString());
        assertEquals(8.0, result.result());
    }

    @Test
    public void test_MultMultiplication() {
        Exponential e = new Exponential(2);
        Multiplication m = new Multiplication(new Exponential(3));
        Multiplication result = e._mult(m);
        assertEquals("(3)", m.toString());
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void test_MultExponential() {
        Exponential e1 = new Exponential(2);
        Exponential e2 = new Exponential(3);
        Multiplication result = e1._mult(e2);
        assertEquals("3", e2.toString());
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void test_MultInteger() {
        Exponential e = new Exponential(2);
        Multiplication result = e._mult(3);
        assertEquals("(2) x (3)", result.toString());
        assertEquals(6.0, result.result());
    }

    @Test
    public void test_DiviMultiplication() {
        Exponential e = new Exponential(2);
        Multiplication m = new Multiplication(new Exponential(3));
        Multiplication result = e._divi(m);
        assertEquals("(3)", m.toString());
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void test_DiviExponential() {
        Exponential e1 = new Exponential(2);
        Exponential e2 = new Exponential(3);
        Multiplication result = e1._divi(e2);
        assertEquals("3", e2.toString());
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void test_DiviInteger() {
        Exponential e = new Exponential(2);
        Multiplication result = e._divi(3);
        assertEquals("(2) x (3^-1)", result.toString());
        assertEquals(2.0 / 3.0, result.result());
    }

    @Test
    public void test_AddSummation() {
        Exponential e = new Exponential(2);
        Summation s = new Summation(new Multiplication(new Exponential(3)));
        Summation result = e._add(s);
        assertEquals("[(3)]", s.toString());
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void test_AddMultiplication() {
        Exponential e = new Exponential(2);
        Multiplication m = new Multiplication(new Exponential(3));
        Summation result = e._add(m);
        assertEquals("(3)", m.toString());
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void test_AddExponential() {
        Exponential e1 = new Exponential(2);
        Exponential e2 = new Exponential(3);
        Summation result = e1._add(e2);
        assertEquals("3", e2.toString());
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void test_AddInteger() {
        Exponential e = new Exponential(2);
        Summation result = e._add(3);
        assertEquals("[(2)] + [(3)]", result.toString());
        assertEquals(5.0, result.result());
    }

    @Test
    public void test_SubtSummation() {
        Exponential e = new Exponential(2);
        Summation s = new Summation(new Multiplication(new Exponential(3)));
        Summation result = e._subt(s);
        assertEquals("[(3)]", s.toString());
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void test_SubtMultiplication() {
        Exponential e = new Exponential(2);
        Multiplication m = new Multiplication(new Exponential(3));
        Summation result = e._subt(m);
        assertEquals("(3)", m.toString());
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void test_SubtExponential() {
        Exponential e1 = new Exponential(2);
        Exponential e2 = new Exponential(3);
        Summation result = e1._subt(e2);
        assertEquals("3", e2.toString());
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

    @Test
    public void test_SubtInteger() {
        Exponential e = new Exponential(2);
        Summation result = e._subt(3);
        assertEquals("[(2)] + [(3) x (-1)]", result.toString());
        assertEquals(-1.0, result.result());
    }

}
