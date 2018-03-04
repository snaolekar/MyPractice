// author : Satyam Naolekar
// solution for Alian Dictionary from geeks for geeks 
// <https://practice.geeksforgeeks.org/problems/alien-dictionary/1>

import java.util.* ;
/**
 * AlienD
 */
class AGraph{
  HashMap<Character,Set<Character>> adj; 

  AGraph(){
    adj = new HashMap<>();
  }

  public void addEdge(char a, char b){
    if(adj.containsKey(a)){
      adj.get(a).add(b);
    }
    else{
      Set<Character> entry = new HashSet<>();
      entry.add(b);
      adj.put(a,entry);
    }
  }
  public void getOrder(HashSet <Character>visited, Stack <Character>st, char a_ch){
    visited.add(a_ch);
    Set l = adj.get(a_ch);
    if(l != null){
      Iterator <Character> lt= l.iterator();
      while(lt.hasNext()){
        char ch= lt.next();
        if(!visited.contains(ch)){
          getOrder(visited,st,ch);
        }
      }
    }
    st.push(a_ch);
   }
  }
 
public class AlienD {

  public static void main(String[] args) {
    //String[] input={ "baa", "abcd", "abca", "cab", "cad" };
    String[] input={ "caa", "aaa", "aab" };
    AGraph G= new AGraph();
    for (int j=1;j<input.length;j++) {
      char []item1 = input[j-1].toCharArray();
      char[]item2 = input[j].toCharArray();
      int len= item1.length > item2.length ? item2.length : item1.length ;
      for(int i=0;i< len;i++){
        if(item1[i]!=item2[i]){
          G.addEdge(item1[i],item2[i]);   
          break;
        }
      }
    }
    HashSet <Character>visited= new HashSet<>();
    Stack <Character>st= new Stack<>();
    char ch=input[0].charAt(0);
    G.getOrder(visited,st,ch);
    while (!st.isEmpty()) {
      System.out.println(st.pop()+" ");
    }
  }
}