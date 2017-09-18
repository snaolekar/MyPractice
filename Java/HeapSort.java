/**
 * Hert
 */
//assumaxg index from 1 for heap
//create maxHeap and sort
public class HeapSort {
 static int arr[]={3,8,9,6,2,7};
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
    printArr(); 
    printSorted(size-1);
 }
 void printArr(){
    for(int ls:arr)
    System.out.print(ls+" ");
    System.out.println();
}
public static void main(String[] args) {
    HeapSort hs= new HeapSort();
    hs.buildHeap();    
    hs.printArr(); 
    hs.printSorted(size);  
    hs.printArr(); 
}
}