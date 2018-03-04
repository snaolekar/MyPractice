/*
 * Author : Satyam Naolekar
 * Implement splitwise algo optimized, to settle debt in group.
 * debet simplification feature of splitwise
 * asked in amazon interview.
*/
import java.util.* ;
class Person implements Comparable {
  char id ;
  int balance ;

  Person(char c){
    id = c ;
    balance= 0;
  }
  @Override
  public int compareTo(Object per2){
    return this.balance - ((Person)per2).balance ;
  }
}

public class SplitWise {
static void addTxn(Person lender, Person borrower, int value){
  lender.balance = lender.balance + value ;
  borrower.balance = borrower.balance - value;
}

static void printMinTrans(List<Person>participents){
  PriorityQueue <Person>borrower = new PriorityQueue<>(5); // min Heap
  PriorityQueue <Person>lender = new PriorityQueue<>(5,Collections.reverseOrder()); //maxHeap
  for (Person p : participents){
    if(p.balance < 0)
    borrower.add(p);
    else if (p.balance > 0)
    lender.add(p);
  }
  while(borrower.size()>0 && lender.size()>0){
    Person br = borrower.remove();
    Person ln = lender.remove();
    if(Math.abs(br.balance)> Math.abs(ln.balance)){
      br.balance = br.balance + ln.balance ;
      System.out.println(br.id +"Will give "+ln.balance+" To "+ln.id);
      ln.balance = 0;
      borrower.add(br);
    } 
    else{
      ln.balance = br.balance + ln.balance ;
      System.out.println(br.id +" Will give "+Math.abs(br.balance)+" To "+ln.id);
      br.balance= 0;
      if(ln.balance >0)
        lender.add(ln);
    }   
  }
  System.out.println("!...Finished ...!");
}
  // if A give B =>  x amount, A will have balance -x and b will have balance +x 
public static void main(String[] args) {
 List <Person>participents = new LinkedList<>();
 Person A = new Person('A');
 Person B = new Person('B');
 Person C = new Person('C');
 Person D = new Person('D');
 participents.add(A);
 participents.add(B);
 participents.add(C);
 participents.add(D);
 addTxn(A,B,100);
 addTxn(B,C,200);
 addTxn(C,D,100);
 addTxn(D,A,200);
 addTxn(D,B,100);
 printMinTrans(participents);
}
}