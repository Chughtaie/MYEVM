package evm;

import java.util.Date;

import oracle.sql.DATE;

/**
 * @author Mr.Chughtai
 *
 */
public class Voter {

	private String name;
	private String cnic;
	private int vote;
	private String region_code;
	private Date vdate;
	private String sdate;
	
	public Voter(String name, String cnic, String region_code) {
		this.name = name;
		this.cnic = cnic;
		this.vote = 0;
		this.setRegion_code(region_code);
		this.vdate = null;
		this.sdate = "";
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public Date getVdate() {
		return vdate;
	}
	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	
	
	void Vote() {
		vote = 1;
		vdate = new Date();
		sdate = vdate.toString();
	}	
	void clear() {
		vote = 0;		
		vdate = null;
		sdate = "";
	}


}
