/**
 * Created by satyam on 26/08/17.
 */

import java.util.*;

class Node {
    double val ;
    double left;
    double right ;
}

public class CardCode {
    public static void main(String args[] ) throws Exception {

        double base = Math.pow(10,9);
        double base_sum = base + 7 ;
        //Scanner
        Scanner s = new Scanner(System.in);
        int TESTCASES = s.nextInt();
        for (int t=0;t<TESTCASES ; t++){
            int N = s.nextInt();
            int []arr= new int [N+1];
            double []outSum= new double [N];
            //System.out.println("");
            for (int i = 0; i <= N; i++) {
                arr[i]= s.nextInt();
                //System.out.println(arr[i]);
            }
            s.close();
            ArrayList<Node> listPrev= new ArrayList<>();
            ArrayList<Node> list= new ArrayList<>();
            Node nt= new Node();
            nt.left= (double) arr[0] ;
            nt.right= (double) arr[1] ;
            nt.val = nt.left * nt.right;
            listPrev.add(nt);
            outSum[0]=nt.val ;
            for (int j=2; j<=N;j++){
                for(int i=0; i< listPrev.size();i++){
                    Node n=  listPrev.get(i);
                    Node n1= new Node();
                    Node n2= new Node();
                    n1.left = (double)arr[j];
                    n1.right = n.right ;
                    n1.val = n1.left * n1.right ;
                    list.add(n1);
                    n2.right = (double)arr[j];
                    n2.left = n.left ;
                    n2.val = n2.left * n2.right ;
                    list.add(n2);
                }
                listPrev.clear();
                listPrev.addAll(list);
                list.clear();
                double sum=0;
                for (int i=0;i<listPrev.size();i++){
                    sum=sum+listPrev.get(i).val ;
                }
                outSum[j-1]=sum;
            }
            double sum_final=0;
            for (int i=0;i<N;i++){
                sum_final= sum_final + outSum[i]* Math.pow(2,N-i);
            }
            //System.out.println("-----------------");
            double result= sum_final % base_sum;
            System.out.println((long)result);
        }
    }
}


