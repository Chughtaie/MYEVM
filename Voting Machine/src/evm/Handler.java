package evm;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Handler {
	
	Oracle db = new Oracle();
	
	@FXML
	private AnchorPane Vote;	
	@FXML
	private TextField name;	
	@FXML
	private TextField cnic;
	@FXML
	private TextField age;
	@FXML
	private TextField cid;
	@FXML
	private TextField code;
	@FXML
	private Button opencand;
	
	
	@FXML
	private ChoiceBox<String> cb_region;
	@FXML
	private ChoiceBox<String> cb_party;
	@FXML
	private ChoiceBox<String> cb_candidate;
	
	@FXML
	private TableView<String> tb_results;
	@FXML
	private ListView<String> partyResults;
	
	private static boolean pop = false;
	private static boolean pop1 = false;
	private static boolean pop2 = false;
	
	
	
	@FXML
	public void showResults() {

		/*
		tb_results = new TableView<String>();
		tb_results.setEditable(true);
		
		TableColumn firstNameCol = new TableColumn("Parties");
		TableColumn lastNameCol = new TableColumn("Votes");
		tb_results.getColumns().addAll(firstNameCol, lastNameCol);
		*/
	
//		String query = "select name from party";
//		Vector<String> party =  db.read(query, "name");
//		
//		String que = "select votes from party";
//		Vector<String> votes =  db.read(que, "votes");
		if(!partyResults.getItems().isEmpty()) return;
		String que = "select name,votes from party";
		Vector<String> results =  db.read(que,"name","votes","\t\t");

		
		partyResults.getItems().add("Name\t\tVotes");
		partyResults.getItems().addAll(results);


		
		
		
			//tb_results.setItems(null);I
		
			/* TableView<String> tb_results = new TableView<>();
		        TableColumn<String, String> tableColumn = new TableColumn<>("Name");

		        tableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

		        tb_results.getColumns().add(tableColumn);
		        ObservableList<String> items = FXCollections.observableArrayList("Itachi");
		        tb_results.setItems(items);
		        *.
			/*
		TableColumn<String, String> partyColumn = new TableColumn<>("Party");
		partyColumn.setCellValueFactory(new PropertyValueFactory<>("party"));

		TableColumn<String, String> votesColumn = new TableColumn<>("Votes");
		votesColumn.setCellValueFactory(new PropertyValueFactory<>("votes"));
		
		tableView.getItems().add("John");
		tableView.getItems().add("Jane");
	*/
	}
	
	@FXML
	public void openResults(ActionEvent event) throws IOException {
	
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Results.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.
	    
	}
	
	
	
	@FXML
	public void populateParty(ActionEvent event) throws SQLException{
		if(pop) return;		
		Vector<String> party = db.read("select pcode from party","pcode");		
	 	cb_party.getItems().addAll(party);
		pop=true;
	}
	

	
	@FXML
	public void populateCandidate(ActionEvent event) throws SQLException{
		//if(pop1) return;

		if((String)cnic.getText().toString() == null || !(cb_candidate.getItems().isEmpty()))
			return;

		
		String ab = "select regioncode from voter where cnic = '" + cnic.getText().toString() + "'";
		Vector<String> region = db.read(ab,"regioncode");
		String bc = "select status from voter where cnic = '" + cnic.getText().toString() + "'";
		Vector<String> status = db.read(bc,"status");
		

		if(region.isEmpty()) {System.out.println("Voter not register!!"); return;}
		//System.out.println(status.get(0).toString());
		if(status.get(0).toString().compareTo("1")==0) { System.out.println("Already voted!"); return; }

		String abc = "select name from candidate where regioncode = '" + region.firstElement() + "'";		
		Vector<String> candidate = db.read(abc,"name");

		cb_candidate.getItems().addAll(candidate);

			
		pop1=true;
	}
	
	@FXML
	public void populateRegion(ActionEvent event) throws SQLException{
		if(pop1) return;
		if((String)cb_party.getValue() == null)
			return;

		String ab = "select code from region minus select regioncode from candidate where pcode = '" + (String)cb_party.getValue() + "'";
		System.out.println(ab);
		
		Vector<String> region = db.read(ab,"code");
		cb_region.getItems().addAll(region);

			
		pop1=true;
	}
	
	@FXML
	public void populateRegionVoter(ActionEvent event) throws SQLException{
		if(pop2) return;		
		Vector<String> region = db.read("select code from region","code");
		System.out.println("populateRegionVoter");
	 	cb_region.getItems().addAll(region);
		pop2=true;
	}
	
	
	
	@FXML
	public void openVOTE(ActionEvent event) throws IOException {
	
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("VOTE.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.

	}
	
	@FXML
	public void openCandidate(ActionEvent event) throws IOException {
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Candidate.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openParty(ActionEvent event) throws IOException {
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Party.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openVoter(ActionEvent event) throws IOException {
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Voter.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openRegion(ActionEvent event) throws IOException {
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Region.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.

	}

	

	public void openMain() throws IOException {
		
		pop =false;
		pop1=false;
		pop2=false;
		
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.
	
	    
	}
	
	@FXML
	public void reg_Voter(ActionEvent event) throws IOException, SQLException{
		
		String region ="";
		region = (String) cb_region.getValue();
		Voter nvoter = new Voter(name.getText().toString(),cnic.getText().toString(),region);
		
		try {
			db.addVoter(nvoter);
			System.out.println(nvoter.getName() + " with cnic "+ nvoter.getCnic() + " have registered successfully in " + nvoter.getRegion_code());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Voter not registered");
			e.printStackTrace();

		}
		pop2=false;
		openMain();
	}
	
	
	@FXML
	public void reg_Candidate(ActionEvent event) throws IOException  {
		
	//	System.out.println();

		String cod = "";
		cod = (String) cb_party.getValue();
		String region ="";
		region = (String) cb_region.getValue();

		
		Candidate cand = new Candidate(name.getText().toString(), Integer.parseInt(age.getText().toString()),
					cnic.getText().toString(), cod, cid.getText().toString(),region);
		cand.displayCandidate();
				
		try {
			db.addCandidate(cand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pop=false;
		pop1=false;
		openMain();
	}
	
	@FXML
	public void returnMain(ActionEvent event) throws IOException {
		openMain();
	}
	
	@FXML
	public void reg_Party(ActionEvent event) throws IOException{
		
		Party party = new Party(name.getText().toString(),code.getText().toString());
		
		try {
			db.addParty(party);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openMain();
	}
	
	@FXML
	public void reg_Region(ActionEvent event) throws IOException {
		
		Region region = new Region(name.getText().toString(),code.getText().toString());
		 try {
			db.addRegion(region);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 openMain();
	}
	
	@FXML
	public void castVote() throws IOException, SQLException {
		
		//if((String)cnic.getText().toString() == null)
			//return;
		if(cb_candidate.getItems().isEmpty()) return;
		
		String status = "update voter set status = 1 where cnic = '" + cnic.getText().toString() +"'";		
		db.add(status);
		String vote = "update candidate set votes = votes + 1 where name = '" + (String) cb_candidate.getValue() +"'";
		db.add(vote);
		System.out.println("Reached");
		Vector<String> pcode = db.read("select pcode from candidate where name = '" + (String) cb_candidate.getValue() +"'","pcode");
		
		vote = "update party set votes = votes + 1 where pcode = '" + (String) pcode.firstElement() +"'";
		db.add(vote);
		
		openMain();
	
	}
	
	
}
