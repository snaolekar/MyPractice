import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node getLeftChild() {
        return this.left;
    }

    public Node getRightChild() {
        return this.right;
    }

    public void addLeft(Node r) {
        this.left = r;
    }

    public void addRight(Node r) {
        this.right = r;
    }
};

public class Question {
    static void printExtremeNodes(Node root) {
        int level = 1;
        Node lastNode;
        Queue<Node> qn = new LinkedList<Node>();
        Stack<Integer> st = new Stack<Integer>();
        System.out.println(root.data);
        qn.add(null);
        Node temp;
        temp = root.getLeftChild();
        if (temp != null)
            qn.add(temp);
        temp = root.getRightChild();
        if (temp != null)
            qn.add(temp);
        qn.add(null);
        lastNode = qn.remove(); // null is the value right now
        while (!qn.isEmpty()) {
            root = qn.remove();
            if (lastNode == null) {
                if(root ==null)
                    return;
                if (level % 2 == 1)
                    st.push(root.data); //extream left node
                else
                    System.out.print(root.data + " ");
            }
            if (root == null) {
                if (level % 2 == 1)
                    st.push(lastNode.data); //extream right node
                else
                    System.out.print(lastNode.data + " ");
                if (level % 2 == 1) {
                    while (!st.empty()) {
                        System.out.print(st.pop() + " ");
                    }
                }
                level++;
            }
            lastNode = root;
            if (root == null) {
                qn.add(null);
                System.out.println();
            } else {
                temp = root.getLeftChild();
                if (temp != null)
                    qn.add(temp);
                temp = root.getRightChild();
                if (temp != null)
                    qn.add(temp);
            }
        }
    }
    static void leftView(Node root)
    {
        //levle order traversal 
      Queue<Node> q= new LinkedList<Node>();
      Node prev=null;
      q.add(root);
      q.add(null);
      while(!q.isEmpty()){
        root=q.remove();
        if(root!=null){
            if(root.getLeftChild() !=null)
                q.add(root.getLeftChild());
            if(root.getRightChild() != null)
                q.add(root.getRightChild());
            if(prev == null)
                System.out.print(root.data+" ");
        }
        else if(prev != null){
            q.add(null);
        }
        prev=root;
      }
      return ;
    }
    static int maxLevel=0 ;
    
    static void rightViewOptimize(Node root,int level){
        if(root == null)
        return;
        if(level > maxLevel){
            System.out.print(root.data+" ");
            maxLevel= level;
        }
        if(root.right !=null)
            rightViewOptimize(root.right, level+1);
        if(root.left !=null)
            rightViewOptimize(root.left, level+1);
        return ;
    }

    static void printSpiral(Node node) 
    {
        if(node==null)
        return;
        Stack<Integer> s= new Stack<Integer>();
        Queue<Node> q= new LinkedList<Node>();
        int level=1;
        q.add(node);
        q.add(null);
        Node prv= null;
        while(!q.isEmpty()){
            node= q.remove();
            if(node==null && prv !=null){
               if(level%2 ==1){
                  while(!s.isEmpty())
                      System.out.print(s.pop()+" ");
               }
              System.out.println();
              level++;
              q.add(node);
            }
            else if(node !=null){
                if(node.left !=null)
                  q.add(node.left);
              if(node.right !=null)
                  q.add(node.right);
              if(level%2==0)
                  System.out.print(node.data+" ");
              else
                  s.push(node.data);
            }
            prv=node;
        }
        
    }
    public static void main(String[] args) {
        Node tree = new Node(1);
        Node two = new Node(2);
        tree.addRight(two);
        Node three = new Node(3);
        tree.addLeft(three);
        Node four = new Node(4);
        two.addLeft(four);
        Node five = new Node(5);
        two.addRight(five);
        Node six = new Node(6);
        three.addRight(six);
        Node seven = new Node(7);
        Node ei = new Node(8);
        Node ni= new Node(9);
        Node tn= new Node(10);
        five.addRight(ni);
        six.addRight(tn);
        four.addLeft(seven);
        four.addRight(ei);
        Node el= new Node(11);
        ni.addLeft(el); 
        Question.printExtremeNodes(tree);
        Question.leftView(tree);
        Question.rightViewOptimize(tree,1);
        System.out.println("------ Spiral -----");
        Question.printSpiral(tree);
        System.out.println("TEST");
    }
}
