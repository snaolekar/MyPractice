import java.util.*;
 /*
 * author: satyam naolekar
 * give all prime factors for given number
 */
public class Prime {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int num= sc.nextInt();
    while(num%2 ==0 ){
      System.out.print(2+" ");
      num=num/2;
    }
    for(int i=3;i<Math.sqrt(num);i=i+2){
      if(num%i ==0){
        System.out.print(i+" ");
        num=num/i;
      }
    }
   if(num >2)
    System.out.print(num); 
  System.out.println();
  sc.close();
  }
}