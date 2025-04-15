import java.util.*;
import java.lang.*;
import java.io.*;
// author : satyam naolekar
// diagonal traversal of a matrix

class Sprial {
public static void main(String[] args) {
     Scanner sc= new Scanner(System.in); // Make a note of this
     int n = sc.nextInt();
     int i=0,j=0;
     int mat[][]= new int[n][n] ;
     for(i=0;i<n;i++){
       for (j=0;j<n;j++){
         mat[i][j]= sc.nextInt();
       }
     }
     if(n==1){
        System.out.print(mat[i][j]);
        sc.close();
        return;
     }
     i=0;
     j=0;
     int dir=1 ;// 0 down 1 up
         System.out.print(mat[i][j]+" ");
         j++;
         System.out.print(mat[i][j]+" ");
         dir=0 ;
        while(!(i==n-1 && j==n-1)){
         while(dir==0 && !(i==n-1 && j==n-1)){
             //go ginonally down
             i++;
             j--;
             System.out.print(mat[i][j]+" ");
            if(i==n-1){
                j++;
                System.out.print(mat[i][j]+" ");
                dir=1;
            }
            else if(j==0){
                if(i==n-1)
                    j++;
                else
                    i++;
                System.out.print(mat[i][j]+" ");
                dir=1;
            }
         }
         while(dir==1 &&  !(i==n-1 && j==n-1)){
             //go diagonally up
             i--;
             j++;
             System.out.print(mat[i][j]+" ");
            if(i==0){
                if(j==n-1)
                    i++;
                else
                    j++;
                System.out.print(mat[i][j]+" ");
                dir=0;
            }
            else if(j==n-1){
                i++;
                System.out.print(mat[i][j]+" ");
                dir=0;
            }
         }
     }
     sc.close();
     return;
}
}