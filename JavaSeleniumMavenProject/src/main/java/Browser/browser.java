package Browser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
	public static WebDriver driver;                   //declared object globally
	public static WebDriverWait wait;
	public static Actions act;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	
	public static void init(String reportName) {
		extent=new ExtentReports();
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//target//ExtentReports//"+reportName+".html");
	}
	/*
	 * Open the browser based on the choice
	 */

	public static void openBrowser() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Open Browser");
		logger1.log(Status.INFO, "Opening the Browser");
		try {
			String choice = utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				logger1.log(Status.PASS, "Opening the ChromeBrowser");
			}	
			else if (choice.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
				logger1.log(Status.PASS, "Opening the EdgeBrowser");
			}
			else if (choice.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				logger1.log(Status.PASS, "Opening the FirefoxBrowser");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
			logger1.log(Status.FAIL, "Failed Opening Browser");
		}
		extent.flush();
	}
	/*
	 * Pauses the URL of the application
	 */
	public static void navigateToUrl() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Navigate to URL");
		logger1.log(Status.INFO, "Navigate to OrangeHRM");
		try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs("OrangeHRM"));
			logger1.log(Status.PASS, "Navigated to OrangeHRM Webpage");
		} catch (Exception e) {
			System.out.println("Browser - geturl");
			logger1.log(Status.FAIL, "Failed Navigating to OrangeHRM");
		}
		extent.flush();
	}
	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Close Browser");
		logger1.log(Status.INFO, "Closing the Browser");
		//Thread.sleep(2000);
		try {
			driver.quit();
			logger1.log(Status.PASS, "Closing the ChromeBrowser");
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
			logger1.log(Status.FAIL, "Failed Closing the ChromeBrowser");

		}
		extent.flush();

	}
}
