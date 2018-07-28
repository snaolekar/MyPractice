import java.util.*;
/**
 * Author: satyam naolekar
 * Implementation for Longest common subsequence 
 * LCS
 */
public class LCS {
  static void getLCS(String str1, String str2){
    int m=str1.length();
    int n=str2.length();
    int maxlen=0;
    int index=0;
    int[][] score= new int [m+1][n+1];
    //Score[i][j] represent matching till str1[i-1] and str2[j-1] 
    //hence score[i+1][j+1] will hold matching for str[i] str[j]
    //java by default array initilized with 0 hecne no need on initilization
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(str1.charAt(i)==str2.charAt(j)){
          score[i+1][j+1]= score[i][j]+1;
          if(maxlen < score[i+1][j+1]){
            maxlen =score[i+1][j+1];
            index=i+1;
          }
        }else
        score[i+1][j+1]=0;
      }
    }
    System.out.println("Max Match:"+maxlen);
    //java end not included hence i+1
    System.out.println("Max Match STR:"+str1.substring(index-maxlen,index));
  }
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String str1= sc.next();
    String str2= sc.next();
    LCS.getLCS(str1,str2);
    sc.close();
  }
}