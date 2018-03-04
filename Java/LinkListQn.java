import java.util.*;
/**
 * author: satyam naolekar
 * Basic linked list use case
 * LinkListQn
 */
public class LinkListQn {

  static LinkedList <Integer> l1=new LinkedList<Integer>();
  static LinkedList <Integer> l2=new LinkedList<Integer>();

  public static void main(String[] args) {
  l1.add(3);
  l1.add(2);
  l1.add(1);

  l2.add(8);
  l2.add(4);
   
  Iterator<Integer> itl1= l1.listIterator();
  Iterator<Integer> itl2= l2.listIterator();
  int num1=0;
  int num2=0;
  Boolean isFirst=true;
  while (itl1.hasNext()) {
    if(isFirst)
      num1= num1+itl1.next();
    else
      num1=num1*10+itl1.next();
    isFirst=false;
  }
  isFirst=true;
  while (itl2.hasNext()) {
    if(isFirst)
      num2= num2+itl2.next();
    else
      num2=num2*10+itl2.next();
    isFirst=false;
  }
  System.out.println(num1*num2);
  }

}