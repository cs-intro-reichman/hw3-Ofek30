// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int counter = x1;
		if (x2>0) {
			for (int i=0;i<x2;i++){
				counter++;
			}
		}
		else {
			for (int i=0;i>x2;i--){
				counter--;
			}
		}
		return counter;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int counter = x1;
		if (x2>0) {
			for (int i=0;i<x2;i++){
				counter--;
			}
		}	
		else {
			for (int i=0;i>x2;i--){
				counter++;
			}
		}
		return counter;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int counter = 0;
		int x1abs = x1; int x2abs =x2;
		if (x1<0) x1abs=minus(0,x1);
		if (x2<0) x2abs=minus(0,x2);
		for (int i=0;i<x2abs;i++){
			counter=plus(counter,x1abs);
		}
		if (x1<0 ^ x2<0) {
			counter = minus(0,counter);
		}
		return counter;
		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int counter = x;
		for (int i=0;i<n-1;i++){
			counter = times(counter,x);
		}
		if (n>0){
			return counter;
		}
		else return 1;
		}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int x1abs = x1; int x2abs =x2;
		if (x1<0) x1abs=minus(0,x1);
		if (x2<0) x2abs=minus(0,x2);
		int checkIfUnderX2 = x1abs;
		int counter = 0;
		while (checkIfUnderX2>=x2abs) {
			checkIfUnderX2=minus(checkIfUnderX2, x2abs);
			counter++;
		}
		if (x1<0 ^ x2<0){
			counter = minus(0,counter);
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int checkIfUnderX2 = x1;
		while (checkIfUnderX2>=x2) {
			checkIfUnderX2=minus(checkIfUnderX2, x2);
		}
		return checkIfUnderX2;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i=0;
		int pow2calc;
		while (i<x) {
			pow2calc = pow(i,2);
			if (pow2calc<x) {
				i++;
			}
			if (pow2calc ==x) {
				return i;
			}
			if (pow2calc>x) {
				return i-1;
			}
		}
		return i;
	}	  	  
}