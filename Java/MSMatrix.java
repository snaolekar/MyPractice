// author : satyam naolekar
// print matrix in spiral form
// often asked in microsoft interview questions.
import java.util.*;
public class MSMatrix {
 // 1,2,3,4,5,6,7,8 directions
 static boolean findString(char[][] inp, String str, int i, int j){
  if(inp[i][j]!=str.charAt(0))
      return false ;
  int XDir[]={-1,0,1,-1,1,-1,0,1};
  int YDir[]={-1,-1,-1,0,0,1,1,1};
  for(int dir=0; dir<8;dir++){
      int xd = j+XDir[dir];
      int yd = i+YDir[dir];
      int k=1;
      for(;k < str.length(); k++){
          if(xd < 0 || xd >= inp[0].length || yd <0 || yd >= inp.length)
              break;
          if(inp[yd][xd] != str.charAt(k))
              break;
          xd= xd+XDir[dir];
          yd= yd+YDir[dir];
      }
      if(k== str.length())
          return true;
  }
  return false;
}
public static void main (String[] args) {
Scanner sc= new Scanner(System.in);
int T= sc.nextInt();
for(int t=0;t<T;t++){
  int I= sc.nextInt();
  int J= sc.nextInt();
  char[][] inp= new char[I][J];
  for(int i=0;i<I;i++){
      for(int j=0;j<J;j++){
          inp[i][j]= sc.next().charAt(0);
      }
  }
  String str= sc.next();
  boolean found=false ;
  for(int i=0;i<I;i++){
      for(int j=0;j<J;j++){
        if(findString(inp,str,i,j)){
          System.out.print(i+" "+j+",");
          found=true ;
        }
      }
  }
  if(found)
      System.out.println();
}
sc.close();
}
}