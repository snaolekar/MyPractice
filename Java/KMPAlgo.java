/**
 * @author snaoleka
 *
 */
public class KMPAlgo {
	/**
	 * @param args
	 */
	static char[] pattern ="ababa".toCharArray();
	static char[] input ="rwrwrqrwr32r23rwefwerfr3rwef32r32r".toCharArray() ;
	static int matchArr[]= {0,0,0,0,0};
	static void createMatch()
	{
		int i=1,j=0,m=pattern.length; 
		for( i=1;i<m;)
		{
			if(pattern[i]==pattern[j])
			{
				matchArr[i]=j+1;
				i++;
				j++;
			}
			else if(j>0)
			{
				j=matchArr[j-1];
			}
			else
			{
				matchArr[i]=0;
				i++;
			}
		}
	}
	public static void main(String[] args) {
		int i=0,j=0;
		int n=input.length, m=pattern.length;
		createMatch();
		for(;i<n-m;)
		{ 
			if(input[i]==pattern[j])
			{
				if(j==m-1)
					break;
				else
				{
					i++;
					j++;
				}
			}
			else if(j>0)
				j=matchArr[j-1];
			else i++;
		}
		if(i<n-m)
			System.out.println("match found at "+(i-j+1));
		else
			System.out.println("Match Not Found");
	}
}
