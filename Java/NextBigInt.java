import java.util.*;

public class NextBigInt{
  public static void swap(int[] arr, int i,int j){
  int t= arr[i];
  arr[i]=arr[j];
  arr[j]= t ;
  return;
  }

  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    int num= sc.nextInt();
    List <Integer> arr1= new ArrayList<>();
    while(num >0){
      arr1.add(num%10);
      num=num/10;
    }
    Collections.reverse(arr1);
    int [] arr= arr1.stream().mapToInt(i -> i).toArray();
    int n= arr.length-1;
    int ptr = n ;
    while(ptr>0 && arr[ptr] < arr[--ptr]);
    System.out.println(ptr);
    if(ptr == 0){
      System.out.println("not possible");
      return ;
    }
    int t=n ;
    while(arr[ptr]>arr[t]){
      t-- ;
    }
    swap(arr,ptr,t); //swap with last and incrise ptr
    ptr++;
    //reversing remaining array
    while(ptr < n){
      swap(arr,ptr,n);
      ptr++;
      n--;
    }
    System.out.println("");
    for(int i=0; i< arr.length ; i++)
    System.out.print(arr[i]);
  }
}
