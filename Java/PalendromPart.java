import java.util.* ;
import java.util.*;
/**
 * author: satyam naolekar
 * gives maximum number of palendrom partationing , qn from geeks for geeks
 * PalendromPart
 */
public class PalendromPart {
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
    String str=sc.next();
    char[] input= str.toCharArray();
    int len= input.length ;
    System.out.println(len);
    int part=0;
    for(int i=0;i<len;){
      for(int j=len-1;j>=i;){
        int index=i;
        while (j>index && input[j]!=input[index]) {
          j--;
        }
        if(i==j){
          part++;
          System.out.println(input[i]);
          i++;
          continue;
        }
        while (j>index && input[--j]==input[++index]);
        if(j<=index){
          part++;
          if(j==index){
          System.out.println(str.substring(i,index+(index-i)+1));
          i= index+(index-i)+1;
          }
          else{
            System.out.println(str.substring(i,index +(index-i)));
            i= index +(index-i);
          }
        }
      }
    }
    System.out.println(--part);
		sc.close();
	}
}