import java.util.*;
/** Sorting
 */
public class  Sorting {
  int mrr[];
  int res[];
  void setMrr(int []arr){
    mrr=arr ;
  }
  void setRes(int []arr){
    res=arr ;
  }
//////////////////////////Insertion Sort //////////////////
  void insertionSort(int[]arr,int size){
    for(int i=1;i<size;i++){
      int j=i;
      while(j>0 && arr[j-1] > arr[j]){
         swap(arr,j-1,j);
         j-- ;
      }
    }
  }

  //////////////////////////Merge Sort //////////////////
  void MergeSort(int low, int high){
    if(low==high)
      return;
    int mid=(low+high)/2;
    MergeSort(low,mid);
    MergeSort(mid+1,high);
    Merge(low,mid,high);
  }

  void Merge(int low,int mid,int high){
    int start=low;
    int i=low;
    int temp=mid;
    while(i<=high && mid<high && low<=temp){
      if(mrr[low]<mrr[mid+1])
        res[i++]=mrr[low++];
      else
        res[i++]=mrr[++mid];
    }
    while(low<=temp)
    res[i++]=mrr[low++];
    while(mid+1<=high)
    res[i++]=mrr[++mid];
    for(i=start;i<=high;i++){
      mrr[i]=res[i];
    }
  }
//////////////////////////Quick Sort //////////////////
  void DoQuickSort(int[] arr){
    int l=0;
    int r=arr.length -1;    
    quickSort(arr,l,r);
  }
  void quickSort(int []arr, int l,int r){
    if(l==r)
      return;
    int pv= arr[l]; // first element as pivot
    int start= l;
    int end=r;
    if(l+1==r){ //special handeling for 2 elelent list
      if(arr[l]> arr[r]){
        swap(arr,l,r);
      }
        l++;
        r--;
    }else{
      ++l;
      while (l < r) {
        while (l < r && arr[l] < pv)
          l++;
        while (l < r && arr[r] > pv) //since I am swapping with r need to execute this once 
          r--;
        if (l < r) {
          swap(arr, l, r);
          l++;
          r--;
        }
      }
      swap(arr, start, r);
    }
  if(start<r)
    quickSort(arr,start,r-1);
  if(end>r)
    quickSort(arr,r+1,end);
}
  
void swap(int arr[],int i, int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp ;
  }

  //Minmum swaps
 int findMinIndex(int[] A,int i,int N){
    int min=A[i];
    int minInd=i;
    for(int j=i+1;j<N;j++){
        if(A[j]<min){
            min=A[j];
            minInd=j;
        }
    }
    A[minInd]=A[i];
    A[i]=min;
    return minInd;
}
int minSwaps(int[] A, int N)
{
  int count=0;
  for(int i=0;i<N;i++){
     if(i!=findMinIndex(A,i,N))
      count++;
  }
  return count;
}
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in) ;
    int size=0;
    int arr[]=null ;
    try{
      size =sc.nextInt() ;
      if(size<1){
        System.out.println("Please enter number greater then 0 for size");
        sc.close();
        throw new RuntimeException("Number is negative for size ");
      }
      arr=new int[size];
      for(int i=0;i<size;i++){
       arr[i]=sc.nextInt();
      }
    }
    catch(Exception e){
        e.getMessage();
        e.printStackTrace();
        return ;
    }
    //while(!sc.hasNextInt())
    //  System.out.println("Integer Number Please ");
    //size = sc.nextInt();
    int qrr[]= new int[size];
    for(int i=0;i<size;i++){
      qrr[i]=arr[i];
    }
    Sorting qn= new Sorting();
    qn.DoQuickSort(qrr);
    System.out.println("Result of Quick Sort");
    for(int i=0;i<size;i++){
      System.out.print(qrr[i]+" ");
    }
    System.out.println();
    
    int mrr[]= new int[size];
    for(int i=0;i<size;i++){
      mrr[i]=arr[i];
    }
    qn.setMrr(mrr);
    int res[]= new int[size];
    qn.setRes(res);
    qn.MergeSort(0,size-1);
    System.out.println("Result of Merge Sort");
    for(int i=0;i<size;i++){
      System.out.print(mrr[i]+" ");
    }
    System.out.println();
    System.out.println("Result of Insertion Sort");
    int srr[]= new int[size];
    for(int i=0;i<size;i++){
      srr[i]=arr[i];
    }
    System.out.println("Minimus swaps required"+qn.minSwaps(srr, size));
    qn.insertionSort(arr,size);
    for(int i=0;i<size;i++){
      System.out.print(arr[i]+" ");
    }
    sc.close();
  }
}