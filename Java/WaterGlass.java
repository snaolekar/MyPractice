// author : satyam naolekar
// if glasses are arranged in form of triangle (will try to draw) how much water will be there at each level if we pour from top 
// Diagram
/*   _
    _ _
   _ _ _
  _ _ _ _
 _ _ _ _ _
_ _ _ _ _ _

*/
import java.util.*;
class WaterGlass {
	public static void main (String[] args) {
    Scanner sc= new Scanner(System.in);
    int T = sc.nextInt();
    for(int t=0;t< T; t++){
        int Cap = sc.nextInt();
        int I = sc.nextInt();
        int J= sc.nextInt();
        if(I<J)
            return ;
        int index=0 ;
        float arrG[] = new float[((I+2)*(I+1))/2];
        arrG[0]=Cap ;
        for(int i=1;i<=I ;i++){
            for(int j=1 ;j<=i ; j++){
                float x = arrG[index] ; //input to this glass
                if(x>1){
                    arrG[index]=1;
                    x=x-1;
                    arrG[index+i] = arrG[index+i] + x/2;
                    arrG[index+i+1] = arrG[index+i+1] + x/2;
                }
                index++;
            }
        }
        System.out.println(arrG[((I*(I-1)/2 + J) -1 )]);
    }
    sc.close();
}
}