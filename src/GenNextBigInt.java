import java.util.*;
public class GenNextBigInt{
  public static void swap(int[] arr, int i, int j){
    int temp= arr[i];
    arr[i]= arr[j];
    arr[j]=temp;
    return ;
  }

  public static boolean printNextPositive(int[] arr){
    int ptr= arr.length -1 ;
    int n = ptr;
    while(ptr>0 && arr[ptr]<=arr[--ptr]);
    if(ptr==0)
      return false ;
    int t=n;
    while(arr[ptr]> arr[t]){
      t--;
    }
    swap(arr,ptr,t);
    ptr++;
    while(ptr<n){
      swap(arr,ptr,n);
      n--;
      ptr++;
    }
    return true ;
  }

  public static boolean printNextNegative(int[] arr){
    int ptr= arr.length -1 ;
    int n = ptr;
    while(ptr>0 && arr[ptr]>=arr[--ptr]);
    if(ptr==0)
      return false ;
    int t=n;
    while(arr[ptr]< arr[t]){
      t--;
    }
    swap(arr,ptr,t);
    ptr++;
    while(ptr<n){
      swap(arr,ptr,n);
      n--;
      ptr++;
    }
    return true ;
  }

  public static void main (String args[]){
    Scanner sc= new Scanner(System.in);
    int num= sc.nextInt();
    String number= (Math.abs(num))+"";
    int arr[]= new int[number.length()];
    for(int i=0; i< arr.length; i++){
      arr[i]= number.charAt(i) - '0' ;
    }
    if(num>0){
      if(!printNextPositive(arr)){
        System.out.println("Not possible");
        return ;
      }
    System.out.println();
    }
    else{
      if(!printNextNegative(arr)){
        System.out.println("not possible");
        return ; 
      }
      System.out.println();
      System.out.print("-");
    }
    for(int i=0;i<arr.length ; i++)
      System.out.print(arr[i]);
     
    return ;
  }
}