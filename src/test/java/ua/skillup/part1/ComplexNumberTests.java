package ua.skillup.part1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ComplexNumberTests {
    @Test
    public void testAdd() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.add(b);
        assertEquals(c.getReal(), 4);
        assertEquals(c.getImaginary(), 6);
    }

    @Test
    public void testSubtract() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.subtract(b);
        assertEquals(c.getReal(), -2);
        assertEquals(c.getImaginary(), -2);
    }

    @Test
    public void testMultiply() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.multiply(b);
        assertEquals(c.getReal(), -5);
        assertEquals(c.getImaginary(), 10);
    }

    @Test
    public void testDivide() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.divide(b);
        assertEquals(c.getReal(), 0.44);
        assertEquals(c.getImaginary(), 0.08);
    }

    @Test
    public void testConjugate() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.conjugate();
        assertEquals(b.getReal(), 1);
        assertEquals(b.getImaginary(), -2);
    }

    @Test
    public void testAbs() {
        ComplexNumber a = new ComplexNumber(3, 4);
        assertEquals(a.abs(), 5);
    }

    @Test
    public void testMultiplyByFactor() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.multiply(2);
        assertEquals(b.getReal(), 2);
        assertEquals(b.getImaginary(), 4);
    }

    @Test
    public void testDivideByFactor() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.divide(2);
        assertEquals(b.getReal(), 0.5);
        assertEquals(b.getImaginary(), 1);
    }
}
