package evm;

import java.util.Date;

public class Candidate {

	private String name;
	private int age;
	private int votes;
	private String cnic;
	private String partyCode;
	private Date join_date;
	private String cid;
	private String regionCode;

	

	
	public Candidate(String name, int age, String cnic, String pcode, String cid, String regionCode) {
		this.name = name;
		this.age = age;
		this.votes = 0;
		this.cnic = cnic;
		this.partyCode = pcode;
		this.setCid(cid);
		this.regionCode = regionCode;
	}

	void addVote() {
		votes++;		
	}
	void displayCandidate() {
		System.out.println(name +"\t"+ String.valueOf(age) +"\t"+ cnic +"\t"+ partyCode);
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getpartyCode() {
		return partyCode;
	}
	public void setpartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}


}
