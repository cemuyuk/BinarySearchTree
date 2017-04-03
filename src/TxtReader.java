import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {
	String DatabaseTxtDocument;
	String QueryTxtDocument;
	ArrayList <String> commandsOfQuery;
	ArrayList <Node> databaseContent;
	ArrayList<Node> nodesInTheQuery;

	public TxtReader(String DatabaseTxtDocument, String QueryTxtDocument) {
		this.DatabaseTxtDocument=DatabaseTxtDocument;
		this.QueryTxtDocument=QueryTxtDocument;
		getDatabaseData();
		getQueryData();
	}
	
	private Node parseNode(String[] values){
		Node result = new Node(values);
		return result;
	}

	//Reads the Database.txt file and fills the databaseContent arraylist
	private void getDatabaseData(){
		databaseContent=new ArrayList<Node>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.DatabaseTxtDocument));
			String str;
			str = in.readLine();
			String[] values =str.split(" ");
			Node node=new Node(values);
			this.databaseContent.add(node);
			while ((str = in.readLine()) != null) {
				values =str.split(" ");
				this.databaseContent.add(parseNode(values));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}
	
	private void getQueryData(){
		nodesInTheQuery=new ArrayList<Node>();
		commandsOfQuery=new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.QueryTxtDocument));
			String str;
			str = in.readLine();
			String[] values =str.split(" ");
			this.nodesInTheQuery.add(parseSqForQuery(values));
			commandsOfQuery.add(values[0]);
			while ((str = in.readLine()) != null) {
				values =str.split(" ");
				this.nodesInTheQuery.add(parseSqForQuery(values));
				commandsOfQuery.add(values[0]);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}
	public Node parseSqForQuery(String[] values){
		String[] nodeInput = new String[3];
		nodeInput[0]=values[1];
		nodeInput[1]=values[2];
		nodeInput[2]=values[3];
		Node result = new Node(nodeInput);
		return result;
	}
	
	public ArrayList<Node> getNodesInTheQuery(){
		return this.nodesInTheQuery;
	}
	
	public ArrayList<Node> getDatabaseContent(){
		return this.databaseContent;
	}

	public ArrayList<String> getCommandsOfQuery() {
		return this.commandsOfQuery;
	}

	public void setCommandsOfQuery(ArrayList<String> commandsOfQuery) {
		this.commandsOfQuery = commandsOfQuery;
	}

	public void setNodesInTheQuery(ArrayList<Node> nodesInTheQuery) {
		this.nodesInTheQuery = nodesInTheQuery;
	}
	
}
