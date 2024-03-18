package ua.skillup.part1;

import org.testng.annotations.Test;

public class ComplexNumberTests {
    @Test
    public void testAdd() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.add(b);
        assert c.getReal() == 4;
        assert c.getImaginary() == 6;
    }

    @Test
    public void testSubtract() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.subtract(b);
        assert c.getReal() == -2;
        assert c.getImaginary() == -2;
    }

    @Test
    public void testMultiply() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.multiply(b);
        assert c.getReal() == -5;
        assert c.getImaginary() == 10;
    }

    @Test
    public void testDivide() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.divide(b);
        assert c.getReal() == 0.44;
        assert c.getImaginary() == 0.08;
    }

    @Test
    public void testConjugate() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.conjugate();
        assert b.getReal() == 1;
        assert b.getImaginary() == -2;
    }

    @Test
    public void testAbs() {
        ComplexNumber a = new ComplexNumber(3, 4);
        assert a.abs() == 5;
    }

    @Test
    public void testMultiplyByFactor() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.multiply(2);
        assert b.getReal() == 2;
        assert b.getImaginary() == 4;
    }

    @Test
    public void testDivideByFactor() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = a.divide(2);
        assert b.getReal() == 0.5;
        assert b.getImaginary() == 1;
    }
}
