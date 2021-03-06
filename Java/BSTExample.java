/**
 * @author snaoleka
 * author: Satyam Naolekar
 * Solution for many Binary Search Tree (BST) data strecture problems 
 ** Inorder, preorder, postorder traversal
 ** Node insertion in BST
 ** Check if given tree is BST
 ** Maintaining the median while insertion 2 solution (2nd is better)
 ** Some more problem solution mentioned in comments
 */
 import java.util.Stack ;
 
class TreeNode
{
	int data;
	TreeNode leftChild;
	TreeNode rightChild;
	TreeNode parent ;

	public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
	this.data = data;
	this.leftChild = leftChild;
	this.rightChild = rightChild;
	}
	
	public TreeNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.parent= null;
	}
	
	public int getData() {
		return this.data;
	}

	public TreeNode getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
// sample BST class
public class BSTExample {
	TreeNode root ;
	TreeNode medianNode ;
	int diff ;
	int size ;
	int count;
	
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public BSTExample(TreeNode root) {
		this.root = root;
		this.medianNode= root;
		this.size=1;
		count=0;
	}
	public void printMedian(){
		System.out.println(this.medianNode.data);
	}
	public BSTExample() {
		this.root = null;
		this.medianNode = null ;
		this.diff = 0;
		this.count=0;
		this.size=0;
	}
	
	public void InOrderUsingStack(){
		TreeNode tNode = this.root ;
		int Count=0;
		if(tNode==null)
			return ;
		Stack<TreeNode> st= new Stack<>();
		st.push(tNode);
		//push all left subtree of root
		while(tNode.leftChild != null){
			tNode= tNode.leftChild ;
			st.push(tNode);
		}
		//pop the left most node
		while(!st.isEmpty())
		{
			tNode= st.pop();
			Count++;
			System.out.println(tNode.getData());
			if(tNode.rightChild !=null){
				tNode = tNode.rightChild;
				st.push(tNode);
				while(tNode.leftChild != null){
					tNode= tNode.leftChild ;
					st.push(tNode);
				}
			}
		}
		System.out.println("Count = "+Count);
	}

	void inOrderMorris(){
		TreeNode current, pre ;
		current = this.root ;
		if(current == null)
			return ;
		while(current != null){
			if(current.leftChild == null){
				System.out.println(" "+current.getData());
				current= current.rightChild ;
			}
			else{
				pre = current.leftChild ;
				while(pre.rightChild !=null && pre.rightChild !=current)
					pre = pre.rightChild;

				if(pre.rightChild == null){ // 
					pre.rightChild = current ;
					current = current.leftChild ;
				}
				else{// correcting the tree
					System.out.println(" "+current.getData());
					current= current.rightChild ;
					pre.rightChild = null ;
				}
			}
		}
	}

	void inOrderTreversal(TreeNode node)
	{
		if(node!=null)
		{
		inOrderTreversal(node.leftChild);
		System.out.println(node.getData());
		inOrderTreversal(node.rightChild);
		}
	}
	void preOrderTreversal(TreeNode node)
	{
		if(node!=null)
		{
			System.out.println(node.getData());
			preOrderTreversal(node.leftChild);
			preOrderTreversal(node.rightChild);
		}
	}

	void postOrderTreversal(TreeNode node)
	{
		if(node!=null)
		{
			postOrderTreversal(node.leftChild);
			postOrderTreversal(node.rightChild);
			System.out.println(node.getData());
		}
	}
	void insertNode(int val)
	{
		TreeNode node= new TreeNode(val);
		if(root==null)
		{
			root=node ;
		}
		else
		{
			TreeNode tempNode= root;
			while(true)
			{
				if(val >tempNode.getData())
				{
					if(tempNode.rightChild==null)
					{
						tempNode.rightChild= node;
						break;
					}
					else
						tempNode= tempNode.rightChild ;
				}
				else
				{
					if(tempNode.leftChild==null)
					{
						tempNode.leftChild= node;
						break;
					}
					else
						tempNode= tempNode.leftChild ;
				}
			}
		}
}

// Maintain median while insertion solution 1
void addAndUpdateMedian1(int value){
	if(this.root == null){
		this.root = new TreeNode(value);
		this.medianNode = this.root ;
		this.size = 1;
		return ;
	}
	TreeNode temp = new TreeNode(value);
	TreeNode traval = this.root;
	while(true){
		if(traval.data > temp.data){
			if(traval.leftChild == null){
				traval.leftChild = temp ;
				break ;
			}
			else
				traval = traval.leftChild ;
		}else{
			if(traval.rightChild == null){
				traval.rightChild= temp ;
				break ;
			}
			else
				traval = traval.rightChild ;
		}
	}
	this.size = this.size + 1;
	this.count=0;
	printMedinaInorder(this.root);
}

void printMedinaInorder(TreeNode curr){
if(this.size == 1){
	System.out.println(root.data);
	return ;
}
//check with mine solution
if(this.size == 2){
	System.out.println(root.data);
	return ;
}
else{
	if(curr != null && (this.count)*2 < this.size){
		printMedinaInorder(curr.leftChild);
		this.count++;
		if(this.size%2==0){
			if(this.count == this.size/2){
				// for now
				System.out.println(curr.data);
				return ;
			}
		}else{
			if(this.count == this.size/2){
				System.out.println(curr.data);
				return ;
			}
		}	
		printMedinaInorder(curr.rightChild);
	}
}
}

// Maintain median while insertion solution 2
void addAndUpdateMedian(int value){
	if(this.root == null){
		this.root = new TreeNode(value);
		this.medianNode = this.root ;
		return ;
	}
	TreeNode temp = this.root ;
	while(true){
		if(temp.data  > value){
			if(temp.leftChild == null){
				temp.leftChild= new TreeNode(value);
				temp.leftChild.parent= temp ;
				break ;
			}
			else
				temp= temp.leftChild ;
		}else{
			if(temp.rightChild== null){
				temp.rightChild = new TreeNode(value);
				temp.rightChild.parent= temp ;
				break;
			}
			else
				temp= temp.rightChild ;
		}
	}
	if(this.medianNode.data < value)
		this.diff = this.diff +1 ;
	else
		this.diff = this.diff -1 ;
	//updating median node
	if(Math.abs(this.diff)<2)
		return ;
	//move towords inorderPredisessor
	if(this.diff == -2 ){
		diff = 0;
		this.medianNode = getPredecessor(this.medianNode) ;
	}
	else{
		diff = 0;
		this.medianNode = getSuccessor(this.medianNode) ;
	}
}

TreeNode getPredecessor(TreeNode node){
	if(node.leftChild != null)
		return rightMost1(node.leftChild);
	int val = node.data ;
	while(node.parent.data > val)
		node= node.parent ;
	return node.parent;	
}

TreeNode getSuccessor(TreeNode node){
	if(node.rightChild != null)
		return leftMost1(node.rightChild);
	int val = node.data ;
	while(node.parent.data < val)
		node= node.parent ;
	return node.parent;	
}

TreeNode rightMost(TreeNode node){
	if(node.rightChild == null)
		return node ;
	return rightMost(node.rightChild);
}

TreeNode rightMost1(TreeNode node){
	while(node.rightChild != null)
		node= node.rightChild;
	return node;
}

TreeNode leftMost(TreeNode node){
	if(node.leftChild == null)
		return node ;
	return leftMost(node.leftChild);
}

TreeNode leftMost1(TreeNode node){
	while(node.leftChild != null)
		node= node.leftChild ;
	return node;
}

Boolean BSTHelper(TreeNode root, int min, int max){
	if(root == null)
		return true;
	//System.out.println("MIN:"+min+":MAX:"+max);
	if(root.data < min || root.data > max)
		return false;
	return (BSTHelper(root.leftChild, min, root.data) && BSTHelper(root.rightChild, root.data, max));
}

int isBST(TreeNode root)  
{
	if(BSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
		return 1;
	return 0;
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BSTExample bst = new BSTExample();
    bst.insertNode(2);
    bst.insertNode(5);
    bst.insertNode(15);
    bst.insertNode(223);
    bst.insertNode(22);
    bst.insertNode(24);
    bst.insertNode(34);
    bst.insertNode(18);
    System.out.println("Inorder Traversal...");
    bst.inOrderTreversal(bst.getRoot());
    System.out.println("-----------------------");
    System.out.println("Inorder Traversal Using Stack...");
    bst.InOrderUsingStack();
		System.out.println("-----------------------");
    System.out.println("Inorder Traversal with no memory..");
    bst.inOrderMorris();
		System.out.println("-----------------------");
    System.out.println("Preorder Traversal...");
    bst.preOrderTreversal(bst.getRoot());
    System.out.println("-----------------------");
    System.out.println("Postorder Traversal...");
    bst.postOrderTreversal(bst.getRoot());
		System.out.println("-----------------------");
		System.out.println(bst.isBST(bst.getRoot())); 
		System.out.println("-----------------------");
    BSTExample bst1 = new BSTExample();
		System.out.println("Median Example");
		System.out.println("-----------------------");
		bst1.addAndUpdateMedian(5);
		bst1.printMedian();
    bst1.addAndUpdateMedian(15);
		bst1.printMedian();
    bst1.addAndUpdateMedian(223);
		bst1.printMedian();
    bst1.addAndUpdateMedian(22);
		bst1.printMedian();
    bst1.addAndUpdateMedian(24);
		bst1.printMedian();
    bst1.addAndUpdateMedian(34);
		bst1.printMedian();
    bst1.addAndUpdateMedian(28);
		bst1.printMedian();
    bst1.addAndUpdateMedian(18);
		bst1.printMedian();
    bst1.addAndUpdateMedian(17);
		bst1.printMedian();
    bst1.addAndUpdateMedian(127);
		bst1.printMedian();
    bst1.addAndUpdateMedian(125);
		bst1.printMedian();
    bst1.addAndUpdateMedian(12);
		bst1.printMedian();
    bst1.addAndUpdateMedian(6);
		bst1.printMedian();
    bst1.addAndUpdateMedian(170);
		bst1.printMedian();
    bst1.addAndUpdateMedian(19);
		bst1.printMedian();
	}
}