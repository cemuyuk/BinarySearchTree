
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TxtReader myReader = new TxtReader("Database.txt","Query.txt");
		
//		ARGUMENT "name" to the constructor will cause tree to operate with regards to phone number
//		BinarySearchTree myTree1 = new BinarySearchTree("name");
//		myTree1.createTheTree(myReader.databaseContent);
//		myTree1.delete(myReader.databaseContent.get(0));

		
		
//		ARGUMENT "surname" to the constructor will cause tree to operate with regards to phone number
//		BinarySearchTree myTree2 = new BinarySearchTree("surname");
//		myTree2.createTheTree(myReader.databaseContent);
//		myTree2.delete(myReader.databaseContent.get(0));
		
		
		
		
//		ARGUMENT "number" to the constructor will cause tree to operate with regards to phone number
		BinarySearchTree myTree3 = new BinarySearchTree("number");	
		
		//READS THE DATABASE AND CREATES THE TREE ACCORDING TO TYPE THAT IS EITHER NAME NUMBER OR SURNAME
		myTree3.createTheTree(myReader.getDatabaseContent());

		//EXECUTES THE INSTRUCTIONS IN THE QUERY AND 
		//CREATES THE TREE ACCORDING TO TYPE THAT IS EITHER NAME NUMBER OR SURNAME
		myTree3.executeTheQueryTxt(myReader.getNodesInTheQuery(), myReader.getCommandsOfQuery());
		
	}
}
