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
   		System.out.println(mod(7,25));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
		for(int i=0;i<x2;i++)
		{
			x1++;

		}
		
		return x1;
	}

	
	public static int minus(int x1, int x2) 
	{
		for(int i=0;i<x2;i++)
		{
			x1--;

		}
		
		return x1;
	}

	
	public static int times(int x1, int x2) 
	{
	int t=0;
		for(int r=0;r<x2;r++)
	{
		t=plus(t, x1);
	}
		
		return t;
	}

	
	public static int pow(int x, int n) 
	{
		int p=x;
		for(int q=0;q<n;q++)
		{
		p=times(p, x);
        }
		
		return p;
	}

	
	public static int div(int x1, int x2) 
	{
		int d=x1;int i=0;
		while(d<x2)
		{
			d=minus(d, x2);
			i++;

		}


		
		return i;
	}

	
	public static int mod(int x1, int x2) 
	{
		int m=x2;
		m=minus(x1, times(div(x1, x2),x2));

		
		return m;
	}	

	
	public static int sqrt(int x) 
	{
		int s=0;
		for(int i =0;i<x;i++)
		{
			if(times(i, i)==x)
			{
				return i;
			}
			else
			{
				if(times(i, i)>x)
				{
					return i--;
				}

			}
			


		}
		return 0;
	}	  	  
}