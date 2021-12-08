package evm;

import java.util.Date;
import java.util.Vector;

/**
 * @author Mr.Chughtai
 *
 */
public class Party {
	
	private String name;
	private Date regDate;
	private int presCid;
	private String partyCode;
	//Vector<Candidate> candidate;
	//private Vector<Region> region;
	public Party(String name, String partyCode) {
		this.name = name;
		this.partyCode = partyCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getPresCid() {
		return presCid;
	}
	public void setPresCid(int presCid) {
		this.presCid = presCid;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	
	
	
	
	
	
	
	
	
	/*
	Party(String a,String c){
		name=a;
		pres=null;
		code=c;
		//can=new Vector<Candidate>();
		reg_date=new Date();
	}
	
	void addCandidate(Candidate a) {
		candidate.add(a);
	}
	
	Candidate delCandidate(String cnicc) {
		for(int i=0;i<candidate.size();i++)
			if(candidate.get(i).getCnic()==cnicc)
				 return candidate.remove(i);				
				
		System.out.println("Not a member of Party!!");
		return null;
	}

	boolean setPres(String cnicc) {
		for(int i=0;i<candidate.size();i++)
			if(candidate.get(i).getCnic()==cnicc)
				{pres=candidate.get(i); return true;}

		System.out.println("Not a member of Party!!");
		return false;
	}

	public Vector<Region> getRegion() {
		return region;
	}

	public void setRegion(Vector<Region> region) {
		this.region = region;
	}
*/

}
