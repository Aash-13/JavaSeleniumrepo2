package ScreenShot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Browser.browser;

public class Capture extends browser{
	public static String screenShot(String name) throws Exception { 
		Thread.sleep(2000);
		String path=null;
		try {

		//	TakesScreenshot driver = null;
			TakesScreenshot shot = ((TakesScreenshot) driver);

			File source = shot.getScreenshotAs(OutputType.FILE);

			path = System.getProperty("user.dir") + "\\target\\ScreenShot\\" + name + ".png";

			File destination = new File(path);

			FileUtils.copyFile(source,destination);

		} catch (Exception e) {

			System.out.println("Screenshot");

		}
		return path;
	}

}
