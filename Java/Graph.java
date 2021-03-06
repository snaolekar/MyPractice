import java.util.*;
/**
 * author: satyam naolekar
 * Graph related problems 
 * BFS
 * DFS
 * TOPO (Topological Sort)
 * MST (Minimum spanning tree)
 */
  class LGraph {
  // Array  of lists for Adjacency List Representation
  private LinkedList<Integer> adj[];

  // Constructor
  LGraph(int v) {
    adj = new LinkedList [v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<Integer>();
  }

  //Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w); // Add w to v's list.
  }
  public void BFS(int v, Boolean visited[]){
    Queue<Integer> q= new LinkedList<Integer>();
    q.add(v);
    System.out.print(v + " ");
    visited[v]=true;
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
    if (adj[v].size() == 0) {
      return;
    }
    int next=v ;
    s.add(v);//fist entry of root node
    boolean needpop= true ;
    while(!s.isEmpty()) {
      if(needpop)
        next = s.pop();
      if(!visited[next]) {
        System.out.print(next + " ");
        visited[next] = true;
      }
      if (adj[next].size() > 0) {
        s.add(next);
        next = adj[next].remove();
        needpop= false ;
      }else{
        needpop=true;
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
    LGraph g = new LGraph(5);
            g.addEdge(0, 1);
            g.addEdge(0, 3);
            g.addEdge(0, 4);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 3);
    Boolean visited[]=new Boolean[4];
    Boolean visited1[]=new Boolean[5];
    for(int lp=0;lp<5;lp++)
      visited1[lp]=false;
    System.out.println("DFS ....");
    g.DFS(0,visited1);                   
    System.out.println();
    
    LGraph g1 = new LGraph(5);
    g1.addEdge(0, 1);
    g1.addEdge(0, 3);
    g1.addEdge(0, 4);
    g1.addEdge(1, 2);
    g1.addEdge(2, 3);
    g1.addEdge(3, 3);
    for(int lp=0;lp<5;lp++)
      visited1[lp]=false;
    System.out.println(".. BFS Sorting...");
    g1.BFS(0,visited1);                   
    System.out.println("....");

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