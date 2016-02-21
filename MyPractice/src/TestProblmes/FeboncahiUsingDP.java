/**
 * 
 */
package TestProblmes;

import java.util.Arrays;

/**
 * @author snaolekar
 *
 */
public class FeboncahiUsingDP {
	 
	static int feb[] = new int[20];

	static int febonachi(int n)
	{
		if(n>2)
		{
			for(int i=2;i<n;i++)
			{
				if(((int)feb[i])==0)
				{
					feb[i]=feb[i-1]+feb[i-2];
				}
			}
		}
		return feb[n-1];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		feb[0]=0;
		feb[1]=1 ;
		System.out.println("10th fabonachi term"+febonachi(20));
		System.out.println("fabonachi term"+Arrays.toString(feb));

	}

}
