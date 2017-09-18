/**
 * @author snaoleka
 *
 */

class TreeNode
{
	int data;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
	this.data = data;
	this.leftChild = leftChild;
	this.rightChild = rightChild;
	}
	
	public TreeNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public int getData() {
		return data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}

public class BSTExample {
	TreeNode root ;
	
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public BSTExample(TreeNode root) {
		this.root = root;
	}
	
	public BSTExample() {
		super();
		this.root = null;
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
    System.out.println("Preorder Traversal...");
    bst.preOrderTreversal(bst.getRoot());
    System.out.println("-----------------------");
    System.out.println("Postorder Traversal...");
    bst.postOrderTreversal(bst.getRoot());
    System.out.println("-----------------------");

	}

}
