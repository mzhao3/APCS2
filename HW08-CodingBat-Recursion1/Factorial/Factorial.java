public class Factorial {
    // Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

    public static int factorial (int n) {
	if (n == 1)
	    return 1;
	return factorial (n - 1) * n;

    }


    public static void main (String[] args) {
	System.out.println(factorial(1));
	System.out.println(factorial(2));
	System.out.println(factorial(3));

    }

}
