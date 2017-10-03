import java.util.*;


/**
 * @author snaoleka
 *
 */
public class KnapsackSloution {
	/**
	 * @param args
	 */
	//static final int capacity= 280;
	static final int capacity= 4;
	static int[] value= {1,2,3};
	static int[] weight= {4,5,1};
	static int includeItem[]={0,0,0};
	//static int[] weight= {70,60,50,40,30,20,10,10,1,12,43,45,76,43,12,43,54,75,24,42,543};
	//static int[] value= {260,245,200,100,80,65,60,60,10,43,45,57,43,12,65,324,345,23,12,543,123};
	//static int includeItem[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int maxSum=0;
    static Hashtable<String, Integer> solutionMap = new Hashtable<String, Integer>();
	
   static void Knapsack(int[] include, int remW, int Val)
	{
		for(int i=0;i<include.length ;i++)
		{
			if(include[i]==0 && weight[i]<remW)
			{
				int temparr[]= include.clone();
				temparr[i]=1;
				int remWTemp= remW-weight[i];
				int Valtemp= Val+value[i];
				if(Valtemp>maxSum)
				{
					maxSum=Valtemp;
					includeItem =temparr.clone();
				}
				if(!solutionMap.containsKey(Arrays.toString(temparr)))
				{
					solutionMap.put(Arrays.toString(temparr), maxSum);
					Knapsack(temparr,remWTemp,Valtemp);
				}
			}
		}
	}
	public static void main(String[] args) {
		int weighttotal= 0;
		Knapsack(includeItem,capacity,0);
		System.out.println(maxSum);
		System.out.println(Arrays.toString(includeItem));
		for(int i=0;i<includeItem.length;i++)
		{
			if(includeItem[i]==1)
			{
				weighttotal=weighttotal+weight[i];
			}
		}
	    System.out.println("total Weight"+weighttotal);
	}
	
}
