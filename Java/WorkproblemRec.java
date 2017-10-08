import java.util.*;
/**
 * WorkProbemRec
 */
public class WorkproblemRec {

static int calculateManHour(int[][] man_hour, int man,boolean[]status,int N){
  if(man==N-1){
    for(int i=0;i<N;i++){
      if(!status[i])
      return man_hour[man][i];
    }
  }
  int minSum=Integer.MAX_VALUE ;
  int tmpReturn=0;
    for(int j=0;j<N;j++){
      if(!status[j]){
        boolean statusN[]= new boolean[N];
        for(int k=0;k<N;k++)
          statusN[k]=status[k];
        statusN[j]=true;
        tmpReturn =man_hour[man][j]+calculateManHour(man_hour,man+1,statusN,N);
        if(minSum> tmpReturn)
          minSum= tmpReturn;
      }
    }
  return minSum;
}
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int T= sc.nextInt();
    for(int t=0;t<T;t++){
      int N= sc.nextInt();
      int [][]man_work= new int[N][N];
      for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
          man_work[i][j]=sc.nextInt();
        }
      }
      boolean[] status= new boolean[N];
      int sum= calculateManHour(man_work,0,status,N);
      System.out.println(sum);
    }
}
}