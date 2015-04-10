package domain;

public class Region {
	private String regionId;
	private String RegionName;
	
	public Region(String regionId, String regionName) {
		super();
		this.regionId = regionId;
		RegionName = regionName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return RegionName;
	}

	public void setRegionName(String regionName) {
		RegionName = regionName;
	}

	@Override
	public String toString() {
		return regionId + "^" + RegionName;
	}
}
