import java.util.*;

public class NextBigPal{

public static boolean isPal(int[] arr){
  int l,r ;
  int n=arr.length ;
  if(n%2==0){
    l= n/2 -1 ;
    r= n/2 ;
  }
  else
  {
    l=r=n/2 ;
  }
  while(r<n){
    if(arr[l] == arr[r]){
      l --;
      r++ ;
    }
    else
      return false;
  }
  return true ;
}

public static void printPalMethod1(int num, int[] arr){
  for(int i=num+1; ;i++){
    String number= i+"";
    for(int j=0; j< arr.length; j++){
      arr[j]= number.charAt(j) - '0' ;
    }
    if(isPal(arr)){
      System.out.println();
      for(int k=0;k<arr.length;k++){
        System.out.print(arr[k]);
      }
      return ;
    }
  }
}

public static void printPalMethod2(int[] arr){
  int l,r,l_st, r_st;
  int n=arr.length ;
  if(n%2==0){
    l_st=l= n/2 -1 ;
    r_st=r= n/2 ;
  }
  else
  {
    l_st=l=r_st=r=n/2 ;
  }
  while(r<n){
    if(arr[l] == arr[r]){
    l--;
    r++;
  }
  else
    break;
  }
  if(r==n){
    //alreaday a palendrom
    l=l_st;
    r=r_st;
    while(l>=0){
      if(arr[l]==9){
      arr[l]=0;
      l--;
      }
      else{
        arr[l]+=1;
        break ;
      }
    }
    while(r_st<n){
      arr[r_st]=arr[l_st];
      r_st++;
      l_st--;
    }
    System.out.println();
    for(int k=0; k<arr.length;k++)
    System.out.print(arr[k]);
  }
  else{
  //not a palendrom
  if(arr[l]>arr[r]){
    while(r<n){
      arr[r]=arr[l];
      r++;
      l--;
    }
    System.out.println();
    for(int k=0; k<arr.length;k++)
      System.out.print(arr[k]);
  }
  else{
    l=l+1 ;
    r=r-1 ;
    l_st=l;
    while(l_st>=0){
      if(arr[l_st]==9){
        arr[l_st]=0;
         l_st--;
      }
      else{
        arr[l_st]+=1;
        break ;
      }
    }
    while(r<n){
      arr[r]=arr[l];
      r++;
      l--;
    }
    System.out.println();
    for(int k=0; k<arr.length;k++)
      System.out.print(arr[k]);
    }
  }
}

public static void main (String args[]){
  Scanner sc= new Scanner(System.in);
  int num= sc.nextInt();
  sc.close();
  String number= (Math.abs(num)) +"";
  int arr[]= new int[number.length()];

  for(int i=0; i< arr.length; i++){
    arr[i]= number.charAt(i) - '0' ;
  }
  System.out.println("first_method");
  printPalMethod1(num,arr);
  for(int i=0; i< arr.length; i++){
    arr[i]= number.charAt(i) - '0' ;
  }
  System.out.println();
  System.out.println("second_method");
  printPalMethod2(arr);
  }
}
