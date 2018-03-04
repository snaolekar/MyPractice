//author : satyam naolekar
// optimized solution for assending sort of even number and decending sort of odd numbers.

import java.util.*;
import java.lang.*;
import java.io.*;

class LeftRight {
    static void swap(int arr[], int i , int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
        return ;
    }
    
    static void sort(int arr[], int i, int j , boolean order){
        //order true acseding false decending
        int size= j-i+1;
        int tmpArr[]= new int[size];
        for(int i1=i,j1=0;i1<=j;i1++,j1++)
            tmpArr[j1]=arr[i1];
            
        if(order)
            Arrays.sort(tmpArr);
        else{
            for(int k=0;k<size;k++)
                tmpArr[k]= tmpArr[k]*-1 ;
            Arrays.sort(tmpArr);
            for(int k=0;k<size;k++)
                tmpArr[k]= tmpArr[k]*-1 ;
        }
        for(int i1=i,j1=0;i1<=j;i1++,j1++)
            arr[i1]=tmpArr[j1];
    }
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in); // Make a note of this
	    int T= sc.nextInt();
	    for(int t=0;t<T;t++){
	        int size= sc.nextInt();
	        int arr[]= new int[size];
	        for(int i=0;i<size;i++){
	            arr[i]=sc.nextInt();
	        }
	        int left=0;
	        int right=size-1;
	        while(left<right){
	            while(left < size && arr[left] % 2 ==1)
	                left++;
	            while(right >=0 && arr[right] % 2 == 0)
	                right--;
	            if(left < right){
	                swap(arr, left, right);
	                left ++;
	                right -- ;
	            }
          }
          if(arr[left] %2 ==1 )
            left++;
          System.out.println(Arrays.toString(arr));
	        
	       // left will be first even number if there is any
	       if(left == 0) // only even number 
	            Arrays.sort(arr);
	       else if(left ==size){
          for(int k=0;k<size;k++)
            arr[k]= arr[k]*-1 ;
          Arrays.sort(arr);
          for(int k=0;k<size;k++)
            arr[k]= arr[k]*-1 ;
         }
	       else{
	           sort(arr,0,left-1,false);
	           sort(arr,left,size-1,true);
         }
         System.out.println(Arrays.toString(arr));
        }
	    sc.close();
	}
}