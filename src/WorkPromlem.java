import java.util.*;
/**
 * author : satyam naolekar
 * WorkProblem
 */

class Item{
  int min;
  int work;
  int man;
  int sum;
  Item(){
    min=Integer.MAX_VALUE;
    work=-1;
    sum=0;
  }
} 
public class WorkPromlem {
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
      ArrayList <Item>manHour= new ArrayList <>();
      for (int i=0;i<N;i++)
        manHour.add(new Item()) ;
      boolean []man= new boolean[N];
      boolean []work= new boolean[N];
      int sum=0;
      for(int k=0;k<N;k++){
        for(int i=0;i<N;i++){
          if(man[i])
            continue ;
          if(manHour.get(i).work!=-1 && !work[manHour.get(i).work] && manHour.get(i).min !=-1)
            continue;
          int min = Integer.MAX_VALUE ;
          int index=-1;
          int tempSum=0;
          for(int j=0;j<N;j++){
            if(!work[j]){
              if(min > man_work[i][j]){
                min = man_work[i][j];
                index = j;
              }
              tempSum+=man_work[i][j];
            }
          }
          manHour.get(i).min= min ;
          manHour.get(i).work=index ;
          manHour.get(i).sum= tempSum ;
        }
        int max= -1 ;
        int index =-1;
        int manTemp=-1;
        int prvSum=0;
        for(int i=0;i<N;i++){
          if(max < manHour.get(i).min || (max==manHour.get(i).min && manHour.get(i).sum > prvSum)){
            max= manHour.get(i).min;
            index=manHour.get(i).work;
            manTemp = i;
            prvSum= manHour.get(i).sum ;
          }
        }
        sum+=max;
        manHour.get(manTemp).min=-1;
        man[manTemp]=true ;
        work[manHour.get(manTemp).work]=true ;
      }
      System.out.println(sum);
    }
  }
}