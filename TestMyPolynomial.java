package oneseven;

/*
 * EXERCISE 1.7: The MyPolynomial Class

A class called MyPolynomial models polynomials of degree n

The class contains:
An instance variable named coeffs, which stores the coefficients of the n-degree polynomial in a double array of size n+1,
where c0 is kept at index 0.
A constructor MyPolynomial(coeffs:double...) that takes a variable number of doubles to initialize the coeffs array,
where the first argument corresponds to c0.

Another constructor that takes coefficients from a file (of the given filename)
A method getDegree() that returns the degree of this polynomial.
A method toString() that returns "cnx^n+cn-1x^(n-1)+...+c1x+c0".
A method evaluate(double x) that evaluate the polynomial for the given x, by substituting the given x into the polynomial expression.
Methods add() and multiply() that adds and multiplies this polynomial with the given MyPolynomial instance another,
and returns a new MyPolynomial instance that contains the result.

Question: Do you need to keep the degree of the polynomial as an instance variable in the MyPolynomial class in Java?
How about C/C++? Why?
In Java, the degree of the polynomial does not need to be kept as an instance variable because you can just call getDegree() whenever
you need it.
 */

public class TestMyPolynomial {
	public static void main(String[] args) {
		double[] acoeffs = new double[] {1, 1, 0};
		MyPolynomial a = new MyPolynomial(acoeffs);
		System.out.println("the degree of  " + a.toString() + " is " + a.getDegree());
		System.out.println("when x = 3, " + a.toString() + " = " + String.valueOf(a.evaluate(3.0)));
		double[] bcoeffs = new double[] {2,1,2,4};
		MyPolynomial b = new MyPolynomial(bcoeffs);
		System.out.println(a.toString() + " plus " + b.toString() + " equals " + a.add(b));
		System.out.println(a.toString() + " times " + b.toString() + " equals " + a.multiply(b));
	}
}
