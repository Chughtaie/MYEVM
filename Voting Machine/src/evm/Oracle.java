package evm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Oracle {
	
	public Vector<String> read(String query,String name) {
		try 
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(query);
			
    		Vector<String> data = new Vector<String>() ;
			while(rs.next()) {
				String reg = rs.getString(name);
				data.add(reg);
				System.out.println(reg);
			}
			//System.out.println("Connection Established");
    		con.close();
    		
    		return data;
		}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Diver not loaded..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established...");
    	}
		
		return null;
		
	}
	public Vector<String> read(String query,String name,String party,String sep) {
		try 
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(query);
			
    		Vector<String> data = new Vector<String>() ;
			while(rs.next()) {
				String reg = rs.getString(name)+ sep + rs.getString(party) ;				
				data.add(reg);
				System.out.println(reg);
			}
			//System.out.println("Connection Established");
    		con.close();
    		
    		return data;
		}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Diver not loaded..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established...");
    	}
		
		return null;
		
	}
	

	public void addVoter(Voter vot)throws IOException, SQLException{		
		String query = "insert into Voter values('" + vot.getName() + "','" + vot.getCnic() + "'," +
				vot.getVote() + ",'" + vot.getSdate() + "','" + vot.getRegion_code() + "')";
		add(query);
	}
	
	public void addCandidate(Candidate candidate)throws IOException, SQLException{
		//insert into Candidate(name,age,votes,cnic,pcode,regioncode) values('Ibrahim Satti',34,0,'xnedkj','eagle','NA-52');
		String query = "insert into Candidate(name,age,votes,cnic,pcode,regioncode) values('" + candidate.getName() + "'," + candidate.getAge() +"," +
				candidate.getVotes() +",'" + candidate.getCnic() + "','" + candidate.getpartyCode() + "','" + candidate.getRegionCode() +"')";
		add(query);
	}
	
	public void addParty(Party party)throws IOException, SQLException{
		//insert into party(name,pcode,prescid,votes) values('Noon League','lion','');
		String query = "insert into party(name,pcode,prescid,votes) values('" + party.getName() + "','" + party.getPartyCode() +"','" + party.getPresCid() +"'," + 0 + ")";
		add(query);
	}
	
	public void addRegion(Region region)throws IOException, SQLException{
		//insert into region(name,code) values('i-8/4','NA-54');
		String query = "insert into region(name,code) values('" + region.getName() + "','" + region.getCode() +"')";
		add(query);
	}

	/*
	public void addVote(Region region)throws IOException, SQLException{
		
		String query = "insert into region values(" + 01 + ",'" + region.getName() + "','" + region.getCode() +"')";
		add(query);
	}*/

	public void add(String query)throws IOException, SQLException {
		
		System.out.println(query);
		try 
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			stmt.executeQuery(query);	
    		con.close();
		}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Diver not loaded..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established...");
    	}
	} 

	
	
	
	
	//abstract void Update(Vote acc)throws IOException, SQLException;
}
