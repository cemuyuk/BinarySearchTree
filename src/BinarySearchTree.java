import java.util.ArrayList;

public class BinarySearchTree {

	private Node root;
	private String insertionMode; //if this string is equal to "name" then we insert by name, 
	//if it's equal to "surname" we insert by surname, if it's equal to "number" we insert by phone no.


	//takes the input inserting mode, if the entered mode is not one of the above, then sets it to name by default
	//in other words, if the insertion mode is not name,surname or number, constructor sets it to insertion by name.
	public BinarySearchTree(String insertionMode) {
		if(!insertionMode.equals("name") && !insertionMode.equals("surname" ) && !insertionMode.equals("number"))
			this.insertionMode="name";
		else
			this.insertionMode=insertionMode;
		
		System.out.println("The type of the tree is "+this.insertionMode+" comparison.\nHence it will execute instructions with regards to that.\n");
	}
	public void deleteForLeft(Node replacingNode, Node nodeToDelete){
		this.removeOneNodeForDeletion(replacingNode);
		if(nodeToDelete.isRoot()){
			nodeToDelete.setRoot(false);
			replacingNode.setRoot(true);
			this.setRoot(replacingNode);
		}
		if(replacingNode.getRightChild()!=null && replacingNode.getParent()!=null)
			replacingNode.getRightChild().setParent(replacingNode.getParent());
		replacingNode.setLeftChild(nodeToDelete.getLeftChild());
		replacingNode.setRightChild(nodeToDelete.getRightChild());
		replacingNode.setParent(nodeToDelete.getParent());
		if(replacingNode.getParent()!=null){
			if(replacingNode.getParent().getRightChild()==nodeToDelete)
				replacingNode.getParent().setRightChild(replacingNode);
			else
				replacingNode.getParent().setLeftChild(replacingNode);
		}
		if(replacingNode.getLeftChild()!=null)
			replacingNode.getLeftChild().setParent(replacingNode);
		if(replacingNode.getRightChild()!=null)
			replacingNode.getRightChild().setParent(replacingNode);
		nodeToDelete.setParent(null);
		nodeToDelete.setRightChild(null);
		nodeToDelete.setLeftChild(null);
	}

	public void deleteForRight(Node replacingNode, Node nodeToDelete){
		this.removeOneNodeForDeletion(replacingNode);
		if(nodeToDelete.isRoot()){
			nodeToDelete.setRoot(false);
			replacingNode.setRoot(true);
			this.setRoot(replacingNode);
		}
		replacingNode.setLeftChild(nodeToDelete.getLeftChild());
		replacingNode.setRightChild(nodeToDelete.getRightChild());
		replacingNode.setParent(nodeToDelete.getParent());
		if(replacingNode.getParent()!=null){
			if(replacingNode.getParent().getRightChild()==nodeToDelete)
				replacingNode.getParent().setRightChild(replacingNode);
			else
				replacingNode.getParent().setLeftChild(replacingNode);
		}
		if(replacingNode.getLeftChild()!=null)
			replacingNode.getLeftChild().setParent(replacingNode);
		if(replacingNode.getRightChild()!=null)
			replacingNode.getRightChild().setParent(replacingNode);
		nodeToDelete.setParent(null);
		nodeToDelete.setRightChild(null);
		nodeToDelete.setLeftChild(null);
	}
	public void delete(Node nodeToDelete){
		if(nodeToDelete==null){ 
			System.out.println("This input node does not exist in the tree.");
		}else{
			//Node nodeToDelete=findNode(node);
			Node replacingNode=findTheCeilingOrFloorIfThereIsNoCeiling(nodeToDelete);

			String nameReplacing=replacingNode.getName().toLowerCase();
			String nameDeleting=nodeToDelete.getName().toLowerCase();

			String surnameReplacing=replacingNode.getSurname();
			String surnameDeleting=nodeToDelete.getSurname();

			String numberReplacing=replacingNode.getNumber();
			String numberDeleting=nodeToDelete.getNumber();

			if(this.insertionMode.equals("name")){
				if(nameReplacing.compareTo(nameDeleting)==0 && replacingNode==nodeToDelete){
					System.out.print("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+""
							+ " has no children. It will just be deleted from the tree, not replaced.");
					this.removeOneNodeForDeletion(nodeToDelete);			
				}else if(nameReplacing.compareTo(nameDeleting)<0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+" "
							+ "now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to name comparison.");
					deleteForLeft(replacingNode,nodeToDelete);
				}else if(nameReplacing.compareTo(nameDeleting)>0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+" "
							+ "now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to name comparison.");
					deleteForRight(replacingNode, nodeToDelete);
				}
			}

			else if(this.insertionMode.equals("surname")){
				if(surnameReplacing.compareTo(surnameDeleting)==0 && replacingNode==nodeToDelete){
					System.out.print("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+""
							+ " has no children. It will just be deleted from the tree, not replaced.");
					this.removeOneNodeForDeletion(nodeToDelete);
				}else if(surnameReplacing.compareTo(surnameDeleting)<0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+" "
							+ "now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to surname comparison.");
					deleteForLeft(replacingNode,nodeToDelete);
				}else if(surnameReplacing.compareTo(surnameDeleting)>0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+" "
							+ "now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to surname comparison.");
					deleteForRight(replacingNode, nodeToDelete);
				}
			}

			else if(this.insertionMode.equals("number")){
				if(numberDeleting.compareTo(numberDeleting)==0 && replacingNode==nodeToDelete){
					System.out.print("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+""
							+ " has no children. It will just be deleted from the tree, not replaced.");
					this.removeOneNodeForDeletion(nodeToDelete);
				}else if(numberReplacing.compareTo(numberDeleting)<0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+""
							+ " now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to number comparison.");
					deleteForLeft(replacingNode,nodeToDelete);
				}else if(numberReplacing.compareTo(numberDeleting)>0){
					System.out.println("\nDELETION: "+nodeToDelete.getName()+" "+nodeToDelete.getSurname()+""
							+ " now will be deleted and replaced by "+replacingNode.getName()+" "+replacingNode.getSurname()
							+" with regards to number comparison.");
					deleteForRight(replacingNode, nodeToDelete);
				}
			}
		}
	}
	public void removeOneNodeForDeletion(Node node){
		boolean isLeft=false;
		if(node.isRoot() && !node.hasChild()){
			this.setRoot(null);
		}else{
			if(node.getParent().getLeftChild()!=null && node.getParent().getLeftChild()==node)
				isLeft=true;

			if(node.hasRight() && isLeft){
				node.getParent().setLeftChild(node.getRightChild());
				node.getRightChild().setParent(node.getParent());
			}
			else if (node.hasRight() && !isLeft){
				node.getParent().setRightChild(node.getRightChild());
				node.getRightChild().setParent(node.getParent());
			}

			if(node.hasLeft() && isLeft){
				node.getParent().setLeftChild(node.getLeftChild());
				node.getLeftChild().setParent(node.getParent());
			}else if(node.hasLeft() && !isLeft){
				node.getParent().setRightChild(node.getLeftChild());
				node.getLeftChild().setParent(node.getParent());
			}
			
			if(!node.hasChild() && isLeft){
				node.getParent().setLeftChild(null);
			}else if(!node.hasChild() && !isLeft){
				node.getParent().setRightChild(null);
			}
				
				
			

			node.setParent(null);
			node.setLeftChild(null);
			node.setRightChild(null);
		}
	}

	// This method first returns the ceiling that will be used in deletion.
	//If there is no ceiling, it returns the floor. If there is no children of a node the method
	//simply returns the node itself.
	public Node findTheCeilingOrFloorIfThereIsNoCeiling(Node nodeInput){
		if(nodeInput.hasRight()){
			nodeInput=nodeInput.getRightChild();
			while(nodeInput.hasLeft())
				nodeInput=nodeInput.getLeftChild();
			return nodeInput;
		}else if(nodeInput.hasLeft()){
			nodeInput=nodeInput.getLeftChild();
			while(nodeInput.hasRight())
				nodeInput=nodeInput.getRightChild();
			return nodeInput;
		}else{
			return nodeInput;
		}

	}

	public Node findNode(Node node){
		return findNodeHelper(node, this.root);
	}

	private Node findNodeHelper(Node nodeToSearch, Node rootNode){

		if(this.insertionMode.equals("name")){
			if(rootNode!=null){
				if(rootNode.getName().compareTo(nodeToSearch.getName())==0){
					return rootNode;
				}
				else if(rootNode.getName().compareTo(nodeToSearch.getName())>0){
					return findNodeHelper(nodeToSearch, rootNode.getLeftChild());
				}
				else{
					return findNodeHelper(nodeToSearch, rootNode.getRightChild());
				}
			}else{
				return null;
			}
		}
		else if(this.insertionMode.equals("surname")){
			if(rootNode!=null){
				if(rootNode.getSurname().compareTo(nodeToSearch.getSurname())==0){
					return rootNode;
				}
				else if(rootNode.getSurname().compareTo(nodeToSearch.getSurname())>0){
					if(rootNode.getLeftChild()==null) return rootNode;
					return findNodeHelper(nodeToSearch, rootNode.getLeftChild());
				}
				else{
					if(rootNode.getRightChild()==null) return rootNode;
					return findNodeHelper(nodeToSearch, rootNode.getRightChild());
				}
			}else{
				return null;
			}
		}else{
			if(rootNode!=null){
				if(rootNode.getNumber().compareTo(nodeToSearch.getNumber())==0){
					return rootNode;
				}
				else if(rootNode.getNumber().compareTo(nodeToSearch.getNumber())>0){
					if(rootNode.getLeftChild()==null) return rootNode;
					return findNodeHelper(nodeToSearch, rootNode.getLeftChild());
				}
				else{
					if(rootNode.getRightChild()==null) return rootNode;
					return findNodeHelper(nodeToSearch, rootNode.getRightChild());
				}
			}else{
				return null;
			}
		}

	}

	public void insert(Node node){
		if(this.insertionMode.equals("name")){
			this.insertNodeByName(node);
			System.out.println("\nINSERTION: "+node.getName()+" "+node.getSurname()+" is added to the binary tree with regards to name comparison.");
		}
		else if(this.insertionMode.equals("surname")){
			this.insertNodeBySurnameame(node);
			System.out.println("\nINSERTION: "+node.getName()+" "+node.getSurname()+" is added to the binary tree with regards to surname comparison.");
		}

		else if(this.insertionMode.equals("number")){
			this.insertNodeByNumber(node);
			System.out.println("\nINSERTION: "+node.getName()+" "+node.getSurname()+" is added to the binary tree with regards to number comparison.");
		}
	}

	private void insertNodeByNameHelper(Node node, Node RootNode){
		String nameOfOldNode=RootNode.getData()[0].toLowerCase();
		String nameOfNewNode=node.getData()[0].toLowerCase();
		if(nameOfNewNode.compareTo(nameOfOldNode)>0){
			if(RootNode.getRightChild()!=null){
				insertNodeByNameHelper(node, RootNode.getRightChild());
			}
			else{
				RootNode.setRightChild(node);
				node.setParent(RootNode);
			}
		}else{
			if(RootNode.getLeftChild()!=null){
				insertNodeByNameHelper(node, RootNode.getLeftChild());
			}
			else{
				RootNode.setLeftChild(node);
				node.setParent(RootNode);
			}
		}
	}

	private void insertNodeByName(Node node){
		insertNodeByNameHelper(node,this.root);
	}

	private void insertNodeBySurnameHelper(Node node, Node RootNode){
		String surnameOfOldNode=RootNode.getData()[1].toLowerCase();
		String surnameOfNewNode=node.getData()[1].toLowerCase();
		if(surnameOfNewNode.compareTo(surnameOfOldNode) > 0){
			if(RootNode.getRightChild()!=null){
				insertNodeBySurnameHelper(node, RootNode.getRightChild());
			}
			else{
				RootNode.setRightChild(node);
				node.setParent(RootNode);
			}
		}else{
			if(RootNode.getLeftChild()!=null){
				insertNodeBySurnameHelper(node, RootNode.getLeftChild());
			}
			else{
				RootNode.setLeftChild(node);
				node.setParent(RootNode);
			}
		}
	}

	private void insertNodeBySurnameame(Node node){
		insertNodeBySurnameHelper(node,this.root);
	}

	private void insertNodeByNumberHelper(Node node, Node RootNode){
		String numberOfNewNode = node.getData()[2];
		String numberOfOldNode = RootNode.getData()[2];
		if(numberOfNewNode.compareTo(numberOfOldNode)>0){
			if(RootNode.getRightChild()!=null){
				insertNodeByNumberHelper(node, RootNode.getRightChild());
			}
			else{
				RootNode.setRightChild(node);
				node.setParent(RootNode);
			}
		}else{
			if(RootNode.getLeftChild()!=null){
				insertNodeByNumberHelper(node, RootNode.getLeftChild());
			}
			else{
				RootNode.setLeftChild(node);
				node.setParent(RootNode);
			}
		}
	}
	private void insertNodeByNumber(Node node){
		insertNodeByNumberHelper(node, this.root);
	}

	//create the bin.tree from that Data ArrayList
	public void createTheTree(ArrayList<Node> txtData){
		System.out.println("\nINITIALIZING the BINARY TREE from 'Database.txt'. With regards to "+this.insertionMode+" comparison.\n");
		if(txtData.size()>0){
			this.root=txtData.get(0);
			txtData.get(0).setRoot(true);
			System.out.println("\nThe root is: " +txtData.get(0).getName()+".");
			for(int i=1; i<txtData.size(); i++){
				this.insert(txtData.get(i));
			}
		}
		System.out.println("---------------------");
		System.out.println("The TREE CREATION IS DONE!!!! It is Created from 'Database.txt'\n");
		this.inOrder();
	}

	public void executeTheQueryTxt(ArrayList<Node> queryNodeData, ArrayList<String> queryCommandData){
		int size1=0;
		int size2=0;
		size1=queryNodeData.size();
		size2=queryCommandData.size();
		String tempCommand="";
		System.out.println("\nQuery.txt's COMMANDS WILL NOW BE EXECUTED! With regards to "+this.insertionMode+" comparison.\n");
		if(size1==size2){
			for(int i=0; i<size1; i++){
				tempCommand=queryCommandData.get(i).toLowerCase();
				if(tempCommand.equals("delete")){
					this.delete(this.findNode(queryNodeData.get(i)));
					System.out.println("The command that's read from the Query.txt is deletion."
							+ " Node " +queryNodeData.get(i).getName()+" is deleted.");

				}
				else if(tempCommand.equals("insert")){
					this.insert(queryNodeData.get(i));
					System.out.println("The command that's read from the Query.txt is insertion."
							+ " Node " +queryNodeData.get(i).getName()+" is inserted.");

				}
			}
		}
		System.out.println("\nQuery.txt's COMMANDS ARE EXECUTED!\n");
		this.inOrder();
	}

	//In-order Traversal to test
	public void inOrderTraversalHelper(Node node){
		if(node.getLeftChild()!=null)
			inOrderTraversalHelper(node.getLeftChild());
		if(node.isRoot()){
			System.out.println("ROOT: " + node.getData()[0]+" "+node.getData()[1]+" "+node.getData()[2]);
			if(node.getParent()!=null)
				System.out.println("P-"+node.getParent().getName());
			if(node.getLeftChild()!=null)
				System.out.println("L-"+node.getLeftChild().getName());
			if(node.getRightChild()!=null)
				System.out.println("R-"+node.getRightChild().getName());
			System.out.println("--------");
		}else{
			System.out.println("NODE: "+node.getData()[0]+" "+node.getData()[1]+" "+node.getData()[2]);
			if(node.getParent()!=null)
				System.out.println("P-"+node.getParent().getName());
			if(node.getLeftChild()!=null)
				System.out.println("L-"+node.getLeftChild().getName());
			if(node.getRightChild()!=null)
				System.out.println("R-"+node.getRightChild().getName());
			System.out.println("--------");
		}
		if(node.getRightChild()!=null)
			inOrderTraversalHelper(node.getRightChild());
	}
	public void inOrder(){
		System.out.println("----N ORDER TRAVERSAL"
				+ "\nTHE tree looks like this with inOrder Traversal. P is parent, R is right, L is left."
				+"\nThe tree operates with regards to "+ this.insertionMode+" comparison.\n");
		inOrderTraversalHelper(this.root);
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
}
