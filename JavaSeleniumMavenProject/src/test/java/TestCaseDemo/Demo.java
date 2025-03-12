package TestCaseDemo;

import Browser.browser;
import Pages.Page1;
import Pages.Page2;
import ScreenShot.Capture;

public class Demo {
public static void main(String[] args) throws Exception {
		
		browser.openBrowser();
		browser.navigateToUrl();
//		Capture.screenShot("Title");
		
		if(Page1.title().equalsIgnoreCase("Orangehrm")) 
			System.out.println("Title is matched with Expected");
		else
			System.out.println("Title not matched with Expected");
		Page1.userNameEnter("Admin");
		Page1.userPasswordEnter("admin123");
		Page1.clickLogin();
		
		if(Page2.UserCheck().equalsIgnoreCase("admin")) 
			System.out.println("Username matched with Expected");
		else
			System.out.println("Username not matched with Expected");
		Page2.clickOnMenu();
		Thread.sleep(2000);
		browser.closeBrowser();
	}

}
