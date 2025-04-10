package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static WebDriver driver;

	public static void startBrowser(String URL) {
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    if (System.getenv("CI") != null) {
	        options.addArguments("--headless");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
	    }

	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--window-size=1920,1080");

	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get(URL);
	}



    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
