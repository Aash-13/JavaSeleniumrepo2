package TestCaseDemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.browser;
import Excel.logindata;
import Pages.Page1;
import Pages.Page2;

public class TestdataFromExcel {
	@BeforeMethod
	public void Open() throws Exception {
		browser.init("TestdataFromExcelReport");
		browser.openBrowser();
		browser.navigateToUrl();
	}
	@DataProvider(name="dp1")
	public Object[][] data() throws Exception
	{
		Object[][] obj=logindata.readExcel(0);
		return obj;
		
	}
	
	@Test(dataProvider = "dp1")
	public void Testloginbutton(String name,String password,String expected) throws Exception
	{
		Thread.sleep(2000);
		Page1.userNameEnter(name);
		Page1.userPasswordEnter(password);
		Page1.clickLogin();
		Page2.clickOnMenu();
//		Assert.assertEquals(Page2.LeaveName(),expected);
		
	}

	@AfterMethod
	public void Close() throws Exception {
		browser.closeBrowser();
	}
}
