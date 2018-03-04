/*
* Author: satyam naolekar
* optimized algo to check if given sum exist in an array
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class CheckSumExist {
	public static void main(String[] args) {
        int size, loop ;
        Scanner sc = new Scanner(System.in);
        loop = sc.nextInt();
        for(int i=0; i<loop ; i++){
            size = sc.nextInt();
            int sum = sc.nextInt();
            int arr[]= new int[size];
            for(int j=0; j<size; j++){
                arr[j]= sc.nextInt();
            }
            // logic
            int start=0,end=0,rsum=0,k=0;
            for(;k<size;k++){
                rsum+=arr[k];
                end=k;
                if(rsum > sum){
                    while (rsum > sum){
                        rsum= rsum - arr[start];
                        start++;
                    }
                }
                if(rsum==sum){
                    System.out.println((start+1)+" "+(end+1));
                    break;
                }
            }
            if(k==size)
                System.out.println("-1");
        }
        sc.close();
    }
}