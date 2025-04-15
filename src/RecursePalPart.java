import java.util.*;
/**
 * author : satyam naolekar
 * recursive soltion for palendrom partationing, easy and correct the iterative one is not correct for all cases
 */
public class RecursePalPart {

  static int arr[][];
  static Boolean isPelandrom(char[] str, int i, int j){
    while(i<j){
      if(str[i++] != str[j--])
        return false;
    }
    return true;
  }
  static int findPalendromCuts(char[] str, int i , int j){
    if( isPelandrom(str,i,j) ) 
      return 0;
    if(arr[i][j]!=0) 
      return arr[i][j];
    int ans= Integer.MAX_VALUE ;
    for(int k=i;k<j;k++)
      ans =Math.min(ans,findPalendromCuts(str,i,k)+1+findPalendromCuts(str,k+1,j));
    arr[i][j]=ans ;
    return ans ;
  }
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String str= sc.next();
    char[] input = str.toCharArray();
    int len= input.length ;
    arr= new int[len][len] ; 
    for(int i=0;i<len;i++)
      arr[i][i]=1;
    System.out.println(findPalendromCuts(input,0,len-1));
    sc.close();
  }
}