import java.util.*;

class ANode {
    int data;
    ANode left;
    ANode right;

    public ANode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public ANode getLeftChild() {
        return this.left;
    }

    public ANode getRightChild() {
        return this.right;
    }

    public void addLeft(ANode r) {
        this.left = r;
    }

    public void addRight(ANode r) {
        this.right = r;
    }
};

public class Question {
    //-------------------------------------------------------------------
    static void printExtremeANodes(ANode node) {
        if(node == null)
            return ;
        ANode st= null;
        Queue<ANode> q= new LinkedList<>();
        int level=1;
        q.add(node);
        q.add(null);
        ANode prvPrint=null;
        ANode prv= null;
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
    static Map <Integer, LinkedList<Integer>> _orderMap = new TreeMap<>();
    static void verticalUtil(ANode root, int hd){
        if(_orderMap.containsKey(hd)){
            LinkedList<Integer> ll= _orderMap.get(hd);
            ll.add(root.data);
            _orderMap.put(hd,ll);
        }
        else{
            LinkedList<Integer> ll= new LinkedList<>();
            ll.add(root.data);
            _orderMap.put(hd,ll);
        }
        if(root.left !=null)
            verticalUtil(root.left, hd-1);
        if(root.right !=null)
            verticalUtil(root.right, hd+1);

    }
    static void verticalOrder(ANode root){
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
    static void leftView(ANode root)
    {
        //levle order traversal 
      Queue<ANode> q= new LinkedList<ANode>();
      ANode prev=null;
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
    static void rightViewOptimize(ANode root,int level){
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
    static void mirror(ANode node){
        if(node==null)
        return;
        ANode temp=null;
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
    static void printSpiral(ANode node) 
    {
        if(node==null)
        return;
        Stack<Integer> s= new Stack<Integer>();
        Queue<ANode> q= new LinkedList<ANode>();
        int level=1;
        q.add(node);
        q.add(null);
        ANode prv= null;
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
    static void lot(ANode node) 
    {
        if(node==null)
        return;
        Queue<ANode> q= new LinkedList<ANode>();
        q.add(node);
        q.add(null);
        ANode prv= null;
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
    static int diameter(ANode node){
        diameterUtil(node);
        return max_dia ;
    }
    static int diameterUtil(ANode node)
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
    static int maxSum(ANode root){
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
        ANode tree = new ANode(1);
        ANode two = new ANode(2);
        tree.addRight(two);
        ANode three = new ANode(3);
        tree.addLeft(three);
        ANode four = new ANode(4);
        two.addLeft(four);
        ANode five = new ANode(5);
        two.addRight(five);
        ANode six = new ANode(6);
        three.addRight(six);
        ANode seven = new ANode(7);
        ANode ei = new ANode(8);
        ANode ni= new ANode(9);
        ANode tn= new ANode(10);
        five.addRight(ni);
        six.addRight(tn);
        four.addLeft(seven);
        four.addRight(ei);
        ANode el= new ANode(11);
        ni.addLeft(el); 
        Question.printExtremeANodes(tree);
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
