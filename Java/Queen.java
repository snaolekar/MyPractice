import java.util.*;
import java.lang.*;
import java.io.*;

class Queen {
    static boolean isSafe(int[] solution, int index,int N){
        for(int i=0;i<N;i++){
            if(solution[i]==index)
                return false;
            if(Math.abs(solution[i]-index)==Math.abs(N-i))
                return false; //diagnonal case
        }
        return true;
    }
    static  boolean assignQueen(int[] solution, int i){
        int len= solution.length ;
        boolean status=false;
        if(i==len-1){
            for(int j=0;j<len; j++){
                if(isSafe(solution,j,i)){
                    status=true;
                    solution[i]=j;
                    System.out.print("[");
                   for(int k=0;k<len;k++){
                       System.out.print((solution[k]+1)+" ");
                   } 
                   System.out.print("] ");
                }
            }
            return status ;
        }
        boolean statusO = false ;
        for(int j=0;j<len; j++){
            if(isSafe(solution,j,i)){
                int[] solutionI = new int[len];
                for(int k=0;k<len;k++)
                    solutionI[k]=solution[k];
                solutionI[i]=j;
                status= assignQueen(solutionI,i+1);
                if(!statusO)
                    statusO=status ;
            }
        }
        return statusO;
    }
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=0;t<T;t++){
        int size=sc.nextInt();
        if(size==1){
            System.out.println("[1 ]");
            continue;
        }
        boolean statusO=false;
		    for(int i=0;i<size;i++){
		        //index will be row number and value column
		        int solution[]= new int [size];
            solution[0]=i;
            boolean status= assignQueen(solution,1);
            if(!statusO)
              statusO= status ;
		    }
		    if(statusO)
		        System.out.println("");
		    else
		        System.out.println("-1");
		
    }
    sc.close();
}
}