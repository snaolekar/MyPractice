import java.util.*;
/**
 * RecursePal
 */
public class RecursePal {

  static int arr[][];
  static boolean prr[][];
  static Boolean isPelandrom(char[] str, int i, int j){
    if(i==j)  
      return true;
    if(prr[i+1][j-1]==true){
      if(str[i]==str[j]){
        prr[i][j]=true;
        return true;
      }
      else{
       prr[i][j]=false;
       return false; 
      }
    }
    else
    return false;
  }
  static int findPalendromCuts(char[] str, int i , int j){
    int ans= Integer.MAX_VALUE ;
    if(i<j){
    for(int k=i;k<j;k++)
      ans =Math.min(ans,findPalendromCuts(str,i,k)+1+findPalendromCuts(str,k+1,j));
    arr[i][j]=ans ;
    }
    if( isPelandrom(str,i,j) ) 
      return 0;
    if(arr[i][j]!=0) 
      return arr[i][j];
    return ans ;
  }
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String str= sc.next();
    char[] input = str.toCharArray();
    int len= input.length ;
    arr= new int[len][len] ; 
    prr= new boolean[len][len] ; 
    for(int i=0;i<len;i++)
      prr[i][i]=true;
    System.out.println(findPalendromCuts(input,0,len-1));
  }
}