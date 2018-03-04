/**
 * author : Satyam Naolekar
 * BuildTree from text stream
 */
import java.util.*;
class Node {
  int data;
  Node left;
  Node right;
  Node(int data){
    this.data = data;
    this.left = null;
    this.right = null ;
  }
  Node(){
    this.data = 0;
    this.left = null;
    this.right = null ;
  }
};
public class BuildTree {

static int [] tree={10,30,20,5,15};
static char [] location={'N','N','L','L','L'};
static int n=5;

static void levelOrderTraversal(Node node) 
{
    if(node==null)
    return;
    Queue<Node> q= new LinkedList<Node>();
    q.add(node);
    q.add(null);
    Node prv= null;
    while(!q.isEmpty()){
        node= q.remove();
        if(node==null && prv !=null){
          System.out.println();
          q.add(node);
        }
        else if(node !=null){
            if(node.left !=null)
              q.add(node.left);
          if(node.right !=null)
              q.add(node.right);
          System.out.print(node.data+" ");
        }
        prv=node;
    }
}
static int index=0;
static Node buildTree(){
  if(index == n)
    return null ;
  
  Node root= new Node(tree[index]);
  index++;
  if(n==1)
    return root; 
 
    if(index<n && location[index]=='N'){
      root.left= buildTree();
  }
  else if (index < n)
    root.left= new Node(tree[index++]);
  
  if(index<n && location[index]=='N'){
    root.right = buildTree();
  }
  else if (index < n)
    root.right = new Node(tree[index++]);
  return root ;
}
public static void main(String[] args) {
Node root = buildTree() ;
levelOrderTraversal(root); 
}
}