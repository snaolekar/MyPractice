import java.util.*;
/**
 * author: satyam naolekar
 * full implementation of heap sort without any advance data strecture
 */
//assumaxg index from 1 for heap
//create maxHeap and sort
public class HeapSort {
 static int arr[]=new int [5];
 static int size= arr.length-1;
 void buildHeap(){
     for(int i=(size-1)/2;i>=0;i--){
        heapify(i,size);
     }
 }
 int getParent(int index){
     return (index-1)/2;
 }

 int getLeftChild(int index){
     return index*2+1;
 }
 int getRightChild(int index){
     return (index+1)*2;
 }

 void heapify(int index, int size){
    if(index>(size-1)/2 || size==0)
        return ;
    int left= getLeftChild(index);
    int right= getRightChild(index);
    int max = left;
    if(right<=size)
        max= arr[left] > arr[right] ? left : right ;
    if(arr[max] < arr[index])
        return ;
    else {
        swap(max,index);
        heapify(max,size);
    }    
 }
 void swap(int i, int j){
     int temp= arr[i];
     arr[i]=arr[j];
     arr[j]=temp;
     return ;
 }

 void printSorted(int size){
    //System.out.println(arr[0]);
    if(size ==0)
        return ;
    swap(0,size);
    heapify(0,size-1);
    //printArr(); 
    printSorted(size-1);
 }
 void printArr(){
    for(int ls:arr)
    System.out.print(ls+" ");
    System.out.println();
}
void insert(int el){
    if(arr[0] < el)
        return ;
    else
     arr[0]=el;
     heapify(0, size);
    
}
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    for(int i=0;i<5;i++)
        arr[i]=sc.nextInt();
    HeapSort hs= new HeapSort();
    hs.buildHeap();    
    hs.printArr(); 
    int element=sc.nextInt();
    while(element!=-1){
        hs.insert(element);
        element=sc.nextInt();
    }
    System.out.println("5th smallest element"+arr[0]);
    sc.close();
    hs.printSorted(size);  
    hs.printArr(); 
}
}