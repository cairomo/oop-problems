package sevennine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
public class MyPolynomial {
	private double[] coeffs;
	public MyPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}
	
	public MyPolynomial(String filename) {
		//gets coeffs from file
		Scanner in = null;
		   try {
		      in = new Scanner(new File(filename));  // open file
		   } catch (FileNotFoundException e) {
		      e.printStackTrace();
		   }
		   int degree = in.nextInt();      // read the degree
		   coeffs = new double[degree+1];  // allocate the array
		   for (int i=0; i<coeffs.length; ++i) {
		      coeffs[i] = in.nextDouble();
		   }
	}
	
	public int getDegree() {
		int endIndex = this.coeffs.length;
		for(int i = this.coeffs.length - 1;i>0;--i) {
			if(this.coeffs[i] == 0) {
				continue;
			} else {
				endIndex = i;
				return endIndex + 1;
			}
		}
		return endIndex;
	}
	
	public String toString() {
		String ret = "";
		for(int i = this.getDegree() - 1;i >= 0;--i) {
			if(this.coeffs[i] != 0) {
				if(this.coeffs[i] == 1) {
					if(i == 1) {
						ret += ("x" + " + " );
					} else if(i == 0) {
						ret += "1";
					} else {
						ret += ("x^" + Integer.toString(i) + " + " );
					}
				} else {
					if(i == 1) {
						ret += (Double.toString(this.coeffs[i]) + "x" + " + " );
					} else if(i == 0) {
						ret += (Double.toString(this.coeffs[i]) + " + " );
					} else {
						ret += (Double.toString(this.coeffs[i]) + "x^" + Integer.toString(i) + " + " );
					}
				}
			}
		}
		return ret;
	}
	
	public double evaluate(double x) {
		double val = 0;
		for(int i = 0;i < this.getDegree();++i) {
			val += (this.coeffs[i] * (Math.pow(x, i)));
		}
		return val;
	}
	
	public MyPolynomial add(MyPolynomial a) {
		double[] c = new double[Math.max((this.coeffs).length, (a.coeffs).length)];
		for(int i = Math.max((this.coeffs).length, (a.coeffs).length);i >= Math.abs((this.coeffs).length - (a.coeffs).length);++i) {
			//starts at end of array
			if((this.coeffs).length >= i && (a.coeffs).length >= i) {
				c[i] = this.coeffs[i] + a.coeffs[i];
			} else if((this.coeffs).length >= i) {
				c[i] = this.coeffs[i];
			} else c[i] = a.coeffs[i];
		}
		MyPolynomial x = new MyPolynomial(c);
		return x;
	}
	
	public MyPolynomial multiply(MyPolynomial a) {
		double[] xcoeffs = new double[this.getDegree() + a.getDegree()];
		MyPolynomial x = new MyPolynomial(xcoeffs);
		for(int i = 0;i<this.getDegree();++i) {
			for(int j = 0;j<a.getDegree();++j) {
				x.coeffs[i+j] += this.coeffs[i] + a.coeffs[j];
			}
		}
		return x;
	}
}
