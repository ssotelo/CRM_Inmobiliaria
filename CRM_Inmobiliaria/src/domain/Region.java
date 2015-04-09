package domain;

public class Region {
	private String regionId;
	private String REgionName;
	
	public Region(String regionId, String rEgionName) {
		super();
		this.regionId = regionId;
		REgionName = rEgionName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getREgionName() {
		return REgionName;
	}

	public void setREgionName(String rEgionName) {
		REgionName = rEgionName;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", REgionName=" + REgionName
				+ "]";
	}
}
