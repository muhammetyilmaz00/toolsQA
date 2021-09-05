package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxManager extends DriverManager{

	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().browserVersion("75").setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		this.driver = new FirefoxDriver(options);
	}
}
