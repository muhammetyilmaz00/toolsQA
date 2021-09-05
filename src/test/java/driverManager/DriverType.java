package driverManager;

public enum DriverType {
	
	CHROME,
	
	FIREFOX;
	
	public static DriverType toDriverType(String driverType) {
		if(driverType == null) {
			return DriverType.CHROME;
		}
		
		driverType = driverType.toUpperCase();

		DriverType[] asList = DriverType.values();
		
		for(DriverType item : asList) {
			if(item.name().equals(driverType)) {
				return item;
			}
		}
		
		return CHROME;
	}
}
