import java.util.*;
/**
 * @author snaoleka
 * calculate factorial using linked list
 *
 */
public class FactorialLinkList {
 static LinkedList<Long> fact = new LinkedList<Long>();
 
 static Long factorial(int n)
 {
	 if(fact.size()<n)
	 {
		 for(int i=1;i<=n;i++)
		 {
			 if(fact.size()<=i)
			 {
				 fact.add(i*fact.get(i-1));
			 }
		 }
	 }
	 return fact.get(n);
 }
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     fact.add((long)1); //factorial of 0
     Scanner input=new Scanner(System.in);
     System.out.println("Enter number : ");
     int n=input.nextInt(); 
     System.out.println(factorial(n));
     System.out.println(fact.toString());
     int random = (int)Math.ceil(12*Math.random());
     System.out.println(random);
     input.close();
	}

}
