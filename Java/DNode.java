//author: satyam naolekar
// printing bottom view of a tree
// solution to : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

import java.util.* ;
import java.util.Map.Entry ;
public class DNode{
  int data;
  DNode left, right;
  int hd;

  public DNode(int data){
      this.data=data;
      this.hd = Integer.MAX_VALUE;
      this.left = this.right=null;
  }

static void printBottomView(DNode root){
  if (root == null)
  return;
  root.hd=0;
  Map<Integer,Integer> _map= new TreeMap<Integer,Integer>() ;
  Queue <DNode> _tq = new LinkedList<DNode>();
  _tq.add(root);
  while(! _tq.isEmpty()){
    DNode temp= _tq.remove();
    _map.put(temp.hd,temp.data);
    if(temp.left !=null){
      temp.left.hd= temp.hd -1 ;
      _tq.add(temp.left);
    }
    if(temp.right !=null){
      temp.right.hd= temp.hd +1 ;
      _tq.add(temp.right);
    }
  }
  for(Map.Entry<Integer, Integer> entry : _map.entrySet()){
    System.out.print(entry.getValue()+" ");
  }
}

public static void main(String[] args) {
  DNode root = new DNode(20);
  root.left = new DNode(8);
  root.right = new DNode(22);
  root.left.left = new DNode(5);
  root.left.right = new DNode(3);
  root.right.left = new DNode(4);
  root.right.right = new DNode(25);
  root.left.right.left = new DNode(10);
  root.left.right.right = new DNode(14);
  DNode.printBottomView(root);
}
}

