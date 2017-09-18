import java.util.*;
/**
 * name
 */
public class DutchFlag {
    public static void main(String[] args) {
        int size, loop ;
        Scanner sc = new Scanner(System.in);
        loop = sc.nextInt();
        for(int l=0; l<loop ; l++){
            size = sc.nextInt();
            int arr[]= new int[size];
            for(int j=0; j<size; j++){
                arr[j]= sc.nextInt();
            }
            // logic
            int i=0,j=0,k=size-1;
            while (j<=k) {
                int temp;
                switch (arr[j]) {
                    case 0:
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                        i++;
                        j++;
                        break;
                    case 1:
                        j++; 
                        break;
                    case 2:
                        temp=arr[j];
                        arr[j]=arr[k];
                        arr[k]=temp;
                        k--; 
                        break;
                    default:
                        System.out.println("-1");;
                }
            }
            for(j=0;j<size;j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.print("\n");
        }
        sc.close();
    } 
    }