
public class Node {

	private String[] data; // i=0 is name, i=1 is surname, i=2 is phone number.
	private Node parent;
	private Node rightChild;
	private Node leftChild;
	private boolean root;
	
	public Node(String[] data) {
		this.data=data;
		parent=null;
		rightChild=null;
		leftChild=null;
		root = false;
	}
	public String getSurname(){
		return this.data[1];
	}
	public String getName(){
		return this.data[0];	
	}
	public String getNumber(){
		return this.data[2];
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isRoot() {
		return root;
	}
	
	public void setRoot(boolean root) {
		this.root = root;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}	

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public boolean hasLeft(){
		if(this.getLeftChild()!=null) return true;
		return false;
	}
	
	public boolean hasRight(){
		if(this.getRightChild()!=null) return true;
		return false;
	}
	
	public boolean hasChild(){
		if(this.getRightChild()==null && this.getLeftChild()==null)
			return false;
		return true;
	}
}
