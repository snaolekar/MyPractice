import java.util.*;
/**
 * Graph
 */
  class LGraph {
  private int V; // No. of vertices

  // Array  of lists for Adjacency List Representation
  private LinkedList<Integer> adj[];

  // Constructor
  LGraph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<Integer>();
  }

  //Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w); // Add w to v's list.
  }

  public void BFS(int v, Boolean visited[]){
    Queue<Integer> q= new LinkedList<Integer>();
    System.out.print(v + " ");
    visited[v] = true;
    if (adj[v].size() == 0) {
      return;
    }
    while(adj[v].size() >0){
      int t= adj[v].remove();
      if(!visited[t]){
        q.add(t);
        System.out.print(t + " ");
        visited[t]=true;
      }
    }
    while(!q.isEmpty()){
    int next = q.remove();
    while(adj[next].size() >0){
      int t= adj[next].remove();
      if(!visited[t]){
        q.add(t);
        System.out.print(t + " ");
        visited[t]=true;
      }
    }
    }
  }
  public void TOPO(int v , Boolean visited[],Stack<Integer>st){
    visited[v]=true;
    while(adj[v].size()>0){
      int t=adj[v].remove();
      if(!visited[t])
        TOPO(t, visited, st);
    }
    st.push(v);
  }
  public void DFS(int v, Boolean visited[]) {
    Stack<Integer> s = new Stack<Integer>();
    System.out.print(v + " ");
    s.add(v);
    visited[v] = true;
    if (adj[v].size() == 0) {
      return;
    }
    int next = adj[v].remove();
    Boolean fromStack = false;
    while (!s.isEmpty()) {
      if (!fromStack)
        s.add(next);
      if (!visited[next]) {
        System.out.print(next + " ");
        visited[next] = true;
      }
      if (adj[next].size() > 0) {
        next = adj[next].remove();
        fromStack = false;
      } else {
        next = s.pop();
        fromStack = true;
      }
    }

  }
}

public class Graph {
  static int V=5;
  static int minIndex(int key[], Boolean[] visited){
    int min= Integer.MAX_VALUE ;
    int index=-1;
    for(int i=0;i<V;i++){
      if(key[i] < min && !visited[i]){
        index=i;
        min=key[i];
      }
    }
    return index;
  }
  static void printMST(int graph[][]){
    int key[]= new int[V];
    int linkSet[]= new int[V];
    Boolean visited[]= new Boolean[V];
    for(int i=0;i<V;i++){
      key[i]=Integer.MAX_VALUE ;
      visited[i]=false;
    }
      //choosing 0 as stating node on tree
      linkSet[0]=-1;
      key[0]=0;
      for(int i=1;i<V;i++){
        int u= minIndex(key,visited);
        visited[u]=true ;
        for(int v=0;v<V;v++){
          if(graph[u][v] >0 && graph[u][v]<key[v] && !visited[v]){
            linkSet[v]=u;
            key[v]=graph[u][v];
          }
        }
      }
      printTree(linkSet);
  }
  static void printTree(int [] linkSet){
    for(int i=1;i<V;i++)
      System.out.println(linkSet[i]+"--"+i);
  }

  public static void main(String[] args) {
    int graph[][] = {{0, 2, 0, 6, 0},
                    {2, 0, 3, 8, 5},
                    {0, 3, 0, 0, 7},
                    {6, 8, 0, 0, 9},
                    {0, 5, 7, 9, 0}};
    printMST(graph);
    LGraph g = new LGraph(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);
    Boolean visited[]=new Boolean[4];
    for(int lp=0;lp<4;lp++)
      visited[lp]=false;
    g.DFS(0,visited);                   
    System.out.println();
    LGraph g1 = new LGraph(4);
    g1.addEdge(0, 1);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(2, 0);
    g1.addEdge(2, 3);
    g1.addEdge(3, 3);
    for(int lp=0;lp<4;lp++)
    visited[lp]=false;
    g1.BFS(0,visited);                   
    LGraph g2 = new LGraph(4);
    g2.addEdge(0, 1);
    g2.addEdge(0, 2);
    g2.addEdge(1, 2);
    g2.addEdge(2, 0);
    g2.addEdge(2, 3);
    g2.addEdge(3, 3);
    for(int lp=0;lp<4;lp++)
    visited[lp]=false;
    Stack<Integer>tp= new Stack<Integer>();
    g2.TOPO(0,visited,tp);
      System.out.println("..TOPOLogical Sorting...");
    while(!tp.isEmpty()){
      System.out.print(tp.pop()+" ");
    }
  }
}