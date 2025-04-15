// author : sastyam naolekar
// optimized solution to check if sorted array is rotaated, or finding the max in sorted roated array
// asked in many interviews , simple and logical question 

import java.util.*;
public class RotatedMin {
  static void findAndPrintMid(int[] arr, int l, int r){
    int prv=arr[l];
    int N= r-l;
    if(N==1){
        System.out.println(arr[l]);
        return ;
    }
    if(N==2){
        int min=(arr[l] > arr[r-1] ? arr[r-1] : arr[l]);
        System.out.println(min);
        return ;
    }
        int mid= l+(N%2 ==0 ? N/2 : (N-1)/2);
            if((mid==0 || arr[mid] < arr[mid-1]) && (mid==arr.length-1 || arr[mid] < arr[mid+1])){
                System.out.println(arr[mid]);
                return ;
            }
            else{
                if(prv < arr[mid]){
                    //go right side
                     findAndPrintMid(arr,mid,r);
                }
                else{
                    //go left side
                     findAndPrintMid(arr,l,mid);
                }
            }
       
}
public static void main (String[] args) {
    //code
    Scanner sc= new Scanner(System.in);
    int N = sc.nextInt();
    int arr[]= new int[N];
    for(int i=0;i<N;i++){
        arr[i]= sc.nextInt();
    }
    if(arr[0]< arr[N-1]){
      //not rotated
      System.out.println(arr[0]);
    }
    else
      findAndPrintMid(arr,0,N);
    sc.close();
}

}