// author :satyam naolekar
// Finding majority element, a element appearing atleast 50% of time is majority element
import java.util.*;
public class Majority {
  public static void main (String[] args) {
		Scanner sc= new Scanner(System.in); // Make a note of this
	    int T= sc.nextInt();
	    for(int t=0;t<T;t++){
	        int size= sc.nextInt();
	        //key,count
	        Map<Integer,Integer> _map= new HashMap<>();
	        boolean found = false ;
	        int key=0;
	        for(int i=0 ; i< size ; i++){
	            key = sc.nextInt();
	            if(_map.containsKey(key)){
	                int ct = _map.get(key);
	                ct++ ;
	                if(ct > size/2){
                      sc.close();
	                    found=true;
	                    break ;
	                }
	                _map.put(key,ct);
	            }
	            else
                    _map.put(key,1);
	        }
	        if(found)
	            System.out.println(key);
	        else
	            System.out.println("NO Majority Element");
	    }
	    sc.close();
	}
}