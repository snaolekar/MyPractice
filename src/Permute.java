import java.util.*;
/**
 * author: satyam naolekar
 * Prints all the permutation of given string.
 */
public class Permute {

    public void permutation(char[] str, int l , int r){
     if(l==r)
        printArr(str,r);   
     else{
         for(int i=l;i<=r;i++){
            str=swap(str,l,i);
            permutation(str,l+1,r);
            str=swap(str,l,i);
         }
        }
    } 

    public void printPerMute(char[] str, int l , int r ){
     if(l==r)
        printArr(str, r);
     else{
         for(int i=l;i<=r;i++){
             str=swap(str,l,i);
             printPerMute(str,l+1,r);
             str=swap(str,l,i);
         }

        }
    }
    char[] swap(char[] str,int i, int j){
        char ch= str[i];
        str[i]=str[j];
        str[j]=ch ;
        return str ;
    }
    void printArr(char[] str, int r){
        for(int i=0;i<=r;i++){
            System.out.print(str[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input= sc.nextLine();        
        Permute pm= new Permute();
        pm.permutation(input.toCharArray(),0,input.length() -1 );
        sc.close();
    }
}