package driverManager;

public class DriverManagerFactory {

	public static DriverManager getDriverManager(DriverType type) {
		return switch (type) {
			case CHROME -> new ChromeDriverManager();
			case FIREFOX -> new FireFoxManager();
			// more browsers here
			//noinspection UnnecessaryDefault
			default -> new ChromeDriverManager();
		};
	}
}
