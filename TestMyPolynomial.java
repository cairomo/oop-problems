package sevennine;

public class TestMyPolynomial {
	public static void main(String[] args) {
		double[] acoeffs = new double[] {1, 1, 0};
		MyPolynomial a = new MyPolynomial(acoeffs);
		System.out.println("the degree of  " + a.toString() + " is " + a.getDegree());
		System.out.println("when x = 3, " + a.toString() + " = " + String.valueOf(a.evaluate(3.0)));
		double[] bcoeffs = new double[] {2,1,2,4};
		MyPolynomial b = new MyPolynomial(bcoeffs);
		System.out.println(a.toString() + " plus " + b.toString() + " = " + a.add(b));
	}
}
