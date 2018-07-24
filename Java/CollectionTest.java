// author: satyam naolekar
// testing different collections in java

import java.util.*;
import java.util.Map.Entry;

public class CollectionTest {
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>();
    Map<Integer,String> m = new TreeMap<>();
    Set<String> s = new TreeSet<>();
     
    l.add(1);
    l.add(4);
    l.add(3);
    l.add(2);
    l.add(3);
     
    m.put(1, "A");
    m.put(4, "B");
    m.put(3, "C");
    m.put(2, "D");
    m.put(3, "E");
     
    System.out.println("Adding to Set");
    System.out.println("Adding 1: " + s.add("bill"));
    System.out.println("Adding 4: " + s.add("chill"));
    System.out.println("Adding 3: " + s.add("hill"));
    System.out.println("Adding 2: " + s.add("will"));
    System.out.println("Adding 3: " + s.add("bill"));
    
    System.out.println("List");
    Iterator<Integer> i = l.iterator();
    while (i.hasNext()) System.out.println(i.next());
     
    System.out.println("Map using keys");
    i = m.keySet().iterator();
    while (i.hasNext()) System.out.println(m.get(i.next()));
     
    System.out.println("Map using entries");
    Iterator<Entry<Integer, String>> j = m.entrySet().iterator();
    while (j.hasNext()) System.out.println(j.next());
     
    System.out.println("Set");
    Iterator<String>k = s.iterator();
    while (k.hasNext()) System.out.println(k.next());
  }
}