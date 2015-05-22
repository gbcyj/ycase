package test.com;

public class Calculators {
	public int add(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) throws Exception {
		if (0 == b) {
			System.out.println("please input nonzero figure");
		}
		return a / b;
	}
}
