/**
 * Graph
 */
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

  }
}