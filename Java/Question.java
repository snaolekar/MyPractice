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
    //-------------------------------------------------------------------
    static void printExtremeNodes(Node node) {
        if(node == null)
            return ;
        Node st= null;
        Queue<Node> q= new LinkedList<Node>();
        int level=1;
        q.add(node);
        q.add(null);
        Node prvPrint=null;
        Node prv= null;
        while(!q.isEmpty()){
            node= q.remove();
            if(node==null && prv !=null){
               if(level%2 ==1){
                System.out.print(prv.data+" ");
                prvPrint= prv;
                if(st != prvPrint)
                System.out.print(st.data+" ");
               }
               else{
                   if(prv != prvPrint)
                    System.out.print(prv.data);
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
                if(prv==null){
                if(level%2==0){
                    System.out.print(node.data+" ");
                    prvPrint= node ;
                }
                else
                    st= node;
                }
            }
            prv=node;
        }
        
    
    }

    //-------------------------------------------------------------------
    static Map <Integer, LinkedList<Integer>> _orderMap = new TreeMap<Integer, LinkedList<Integer>>();
    static void verticalUtil(Node root, int hd){
        if(_orderMap.containsKey(hd)){
            LinkedList<Integer> ll= _orderMap.get(hd);
            ll.add(root.data);
            _orderMap.put(hd,ll);
        }
        else{
            LinkedList<Integer> ll= new LinkedList<Integer>();
            ll.add(root.data);
            _orderMap.put(hd,ll);
        }
        if(root.left !=null)
            verticalUtil(root.left, hd-1);
        if(root.right !=null)
            verticalUtil(root.right, hd+1);

    }
    static void verticalOrder(Node root){
        if(root == null)
        return ;
        verticalUtil(root, 0);
        for(Map.Entry<Integer, LinkedList<Integer>>entry : _orderMap.entrySet()){
            for (int i : entry.getValue()){
                System.out.print(i+" ");
            }
            System.out.print("$");
        }
    }

    //-------------------------------------------------------------------
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

    //-------------------------------------------------------------------
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

    //-------------------------------------------------------------------
    static void mirror(Node node){
        if(node==null)
        return;
        Node temp=null;
        temp= node.left ;
        node.left= node.right;
        node.right= temp;
        if(node.left !=null)
            mirror(node.left);
        if(node.right !=null)
            mirror(node.right);
        return ;
    }

    //-------------------------------------------------------------------
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

    //-------------------------------------------------------------------
    static void lot(Node node) 
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

    //------------------------------------------------------------------- Good Qn
    static int max_dia=0;
    static int diameter(Node node){
        diameterUtil(node);
        return max_dia ;
    }
    static int diameterUtil(Node node)
    {
        if (node==null)
            return 0;
        if(node.left ==null && node.right ==null)
            return 1;
        int lsd = diameterUtil(node.left);
        int rsd = diameterUtil(node.right);
        if(node.left !=null && node.right !=null){
            int max = Math.max(lsd+1,rsd+1);
            int maxd = lsd+rsd+1;
            if(maxd > max_dia)
                max_dia= maxd;
            return max ;
        }
        return node.left ==null ? rsd+1 : lsd+1 ;
    }

    //------------------------------------------------------------------- Good Qn
    static int maxSum= Integer.MIN_VALUE ;
    static int maxSum(Node root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null )
            return root.data;
    
        int ls= maxSum(root.left);
        int rs= maxSum(root.right);
            
        if(root.left !=null && root.right != null){
            int max= Math.max(ls+root.data, rs+root.data);
            int sum= ls+rs+root.data ;
            if(sum > maxSum)
                maxSum=sum;
            return max ;
        }
        return root.left == null ? rs+root.data : ls+root.data ;
    }
    //-------------------------------------------------------------------
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
        System.out.println("------ Vertical Order -----");
        verticalOrder(tree);
        System.out.println("------ Tree Order -----");
        Question.lot(tree);
        Question.mirror(tree);
        System.out.println("------ Mirror Tree Order -----");
        Question.lot(tree);
        System.out.println("------ MaxSum-----");
        Question.maxSum(tree);
        System.out.println(maxSum);
        System.out.println("------ MaxSum-----");
        System.out.println(Question.diameter(tree));
    }
}
