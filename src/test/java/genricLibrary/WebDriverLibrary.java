package genricLibrary;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLibrary {

	WebDriver driver;

	public WebDriver launchBrowser(String browser, PropertyFileLibrary pLib, long time) {

		switch (browser) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\waris ansari\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
			
			ChromeOptions options = new ChromeOptions();
	        options.setBinary("C:\\Users\\waris ansari\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	        driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("please enter valid browser");

		}
		driver.get(pLib.fetchDataFromPropertyFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}

}
