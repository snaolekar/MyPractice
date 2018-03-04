// author : satyam naolekar
// another elegent solution to maintain median element while making insertion in BST, algo given by friend.
class VTree {
  int data ;
  VTree left ;
  VTree right;
  int l;
  int r;
  
  public VTree(int data){
    this.data= data ;
    this.left = null;
    this.right= null;
    l = 0 ;
    r=0;
  }
}

public class VBST {
VTree  root ;
VTree median ;

public VBST(){
  this.root= null ;
  this.median = null ;
}

void insertAndUpdateMedian(int val){
  if(root == null){
    root = new VTree(val);
    median = root ;
  }
  else{
    VTree temp = root; // traversal pointer
    //insert function
    while(true){
      if(temp.data > val){
        temp.l= temp.l + 1 ;
        //left Subtree insertion
        if(temp.left == null){
          temp.left= new VTree(val);
          break ;
        }
        else
          temp= temp.left ;
      }else{
        //right subtree insertion
        temp.r= temp.r + 1 ;
        if(temp.right == null){
          temp.right = new VTree(val);
          break ;
        }
        else
          temp= temp.right;
      }
    }
  }
  updateMedian(root, 0,0);
}
void updateMedian(VTree node, int a, int b){
  if(Math.abs((node.l+a)-(node.r+b))<2){
    median = node ;
    System.out.println(median.data);
    return ;
  }
  else{
    if(node.l+a > node.r+b)
      updateMedian(node.left, a, b+node.r+1); //move left
    else
      updateMedian(node.right, a+node.l+1, b); // move right
  }
}
public static void main(String[] args) {
  VBST qn = new VBST();
  qn.insertAndUpdateMedian(5);
  qn.insertAndUpdateMedian(15);
  qn.insertAndUpdateMedian(223);
  qn.insertAndUpdateMedian(22);
  qn.insertAndUpdateMedian(24);
  qn.insertAndUpdateMedian(34);
  qn.insertAndUpdateMedian(28);
  qn.insertAndUpdateMedian(18);
  qn.insertAndUpdateMedian(17);
  qn.insertAndUpdateMedian(127);
  qn.insertAndUpdateMedian(125);
  qn.insertAndUpdateMedian(12);
  qn.insertAndUpdateMedian(6);
  qn.insertAndUpdateMedian(170);
  qn.insertAndUpdateMedian(19);
}
}