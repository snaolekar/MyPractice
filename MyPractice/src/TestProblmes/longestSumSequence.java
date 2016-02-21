package TestProblmes;

public class longestSumSequence {
	
	public static void main(String[] args) {
		int[] number={-11,-3,4,-2,3,-6};
		int maxSum=0 ;
		int temp_sum=0;
		int start=0;
		int end=0;
		int max= number[0];
		boolean isPositive = false;
		for(int i=0;i<number.length ;i++)
		{
			if(number[i]>=0)
				isPositive=true;
			if(number[i]>max)
				max=number[i];
			temp_sum= temp_sum+number[i];
			if(temp_sum>0)
			{
				if(temp_sum >maxSum)
				{
					maxSum= temp_sum;
					end=i;
				}
			}
			else
			{
				temp_sum=0;
				start=i+1;
			}
		}
		if(isPositive)
		{
		System.out.println("Sum: "+maxSum);
		System.out.println("start"+start);
		if(end>start)
			System.out.println("end: "+end);
		else
			System.out.println("end: "+start);	
		}
		else
			System.out.println("Sum: "+max);
			
	}

}
