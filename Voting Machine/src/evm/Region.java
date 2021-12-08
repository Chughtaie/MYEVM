package evm;

public class Region{

	private String region_name;
	private String region_code;

	

	
	public Region(String region_name, String region_code) {
		this.region_name = region_name;
		this.region_code = region_code;
	}
	public String getName() {
		return region_name;
	}
	public void setName(String name) {
		this.region_name = name;
	}
	public String getCode() {
		return region_code;
	}
	public void setCode(String code) {
		this.region_code = code;
	}
}
