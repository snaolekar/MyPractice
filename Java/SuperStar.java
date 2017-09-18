import java.util.*;
public class SuperStar{
    public static void main (String args[]){
	    Scanner sc= new Scanner(System.in); // Make a note of this
	    int T= sc.nextInt();
	    for(int t=0;t<T;t++){
	        int size= sc.nextInt();
	        Stack<Integer> st= new Stack<Integer>();
	        int arr[]=new int[size];
	        for (int i=0;i<size;i++){
	            arr[i]=sc.nextInt();
	        }
	        int j=size-1;
	        st.push(arr[j]);
	        for(;j>0;j--){
	            if(arr[j-1] > arr[j])
	                st.push(arr[j-1]);
	            else
	                break;
            }
            System.out.println("\n");
	        while(!st.empty()){
	            System.out.print(st.pop()+" ");
	        }
	        System.out.println("\n");
	        int k=j;
	        while(j>0){
	            if(arr[j]>arr[j-1])
                    j--;
                else
                    break ;
	        }
	        if(j==0)
	            System.out.println(arr[j]);
	        else
	            System.out.println(-1);
        }
        sc.close();
	}
}