package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static int count=0;
	public static void CaptureShot(WebDriver driver) throws Exception {
		File Srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+"\\src\\test\\java\\Screenshot\\errorimage"+count+++".jpeg";
		FileUtils.copyFile(Srcfile, new File(ScreenshotPath));
	}
}
