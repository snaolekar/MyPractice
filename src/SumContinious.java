import java.util.* ;
import java.lang.* ;

 /**
  * author : satyam naolekar
  * print maximum continious sum in an array
 */
public class SumContinious {

    public static void main(String[] args) {
        int size, loop ;
        Scanner sc = new Scanner(System.in);
        loop = sc.nextInt();
        for(int i=0; i<loop ; i++){
            size = sc.nextInt();
            int arr[]= new int[size];
            for(int j=0; j<size; j++){
                arr[j]= sc.nextInt();
            }
            int sum= arr[0];
            int sumTemp=0;
            for (int k=0; k<size; k++) {
                sumTemp+= arr[k];
               if(sum < sumTemp)
                    sum= sumTemp ;
                if(sumTemp < 0){
                    sumTemp = 0 ;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
        
}
