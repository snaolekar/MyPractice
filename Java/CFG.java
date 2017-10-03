import java.util.*;

class GFG {
    
   static Hashtable<String, Integer> solutionMap = new Hashtable<String, Integer>();
   static int maxSum=0;
   static int[]includeItem;
   static void Knapsack(int[] include, int remW, int Val,int[] weight, int[] value,int[] includeItem)
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
					Knapsack(temparr,remWTemp,Valtemp,weight,value,includeItem);
				}
			}
		}
	}
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
		    int N=sc.nextInt();
		    int cap= sc.nextInt();
		    int weight[]= new int[N];
		    int value[]= new int[N];
		    int include[]=new int[N];
		    includeItem=include.clone();
		    for(int j=0;j<N;j++)
		     value[j]= sc.nextInt();
		    for(int j=0;j<N;j++)
		     weight[j]= sc.nextInt();
		   Knapsack(include,cap,0,weight,value,includeItem);
		   int weighttotal=0;
		   for(int k=0;k<includeItem.length;k++){
			if(includeItem[k]==1)
				weighttotal=weighttotal+weight[k];
		   }
	    System.out.println(weighttotal);
    }
    sc.close();
	}
}