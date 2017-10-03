/**
 * MERGE2
 */
public class MERGE2 {
static int arr[]={1,4,6,8,34,67};
static int brr[]={1,4,23};
static int n=6;
static int m=3;
static int getElement(int i){
  if(i<n)
    return arr[i];
   else
    return brr[i-n];
}
static void swap(int i, int j){
  int temp,temp1;
  if(i<n)
    temp=arr[i];
  else
    temp=brr[i-n];

  if(j<n)
    temp1=arr[j];
  else
    temp1=brr[j-n];
  
  if(i<n)
    arr[i]=temp1;
   else
    brr[i-n]=temp1;

  if(j<n)
    arr[j]=temp;
   else
    brr[j-n]=temp;

}
public static void main(String[] args) {
  for (int i=n;i<n+m;i++){
    for(int j=i;j>0;j--){
      if(getElement(j-1) > getElement(j))
        swap(j-1,j);
      else
        break;
    }
  }
  for(int a1: arr){
    System.out.print(a1+" ");
  }
  for(int a1: brr){
    System.out.print(a1+" ");
  }
}
}