package TestCaseDemo;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.browser;
import Pages.Page1;
import Pages.Page2;
import ScreenShot.Capture;

public class Test1 {
	@BeforeMethod
	public void Open() throws Exception {
		browser.init("Test1Report");
		browser.openBrowser();
		browser.navigateToUrl();
	}
	@DataProvider(name="param")
	public Object[] dpMethod() {
		Object[] testdata=new Object[1];
		testdata[0]="OrangeHRM";
	//	testdata[1]="Google";
		return testdata;
	}
	@Test(priority=1,dataProvider="param")
	public void Title(String titlename) throws Exception {
		Assert.assertEquals(Page1.title(), titlename);
	//	Reporter.log("TestCase1 Title Assertion Pass");
	/*	if(Page1.title().equalsIgnoreCase(titlename)) {
			System.out.println("Title is matched with Expected");
			Reporter.log("TestCase1 Title Assertion Pass");
		}
		else {
			System.out.println("Title is not matched with Expected");
			Reporter.log("TestCase1 Title Assertion Fail");
		}*/
		Page1.userNameEnter("Admin");
		Page1.userPasswordEnter("admin123");
		Page1.clickLogin();
	}
	@AfterMethod
	public void Close() throws Exception {
		browser.closeBrowser();
	}
}
