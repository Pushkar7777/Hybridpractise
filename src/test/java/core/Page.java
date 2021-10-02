package core;

import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import Utility.Screenshot;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Page {
	public WebDriver driver=null;
	public Logger logs, logs2 =null;
	//public ExtentTest test=null;
	//public ExtentReports report =null;
	
  @Parameters({ "browser","url" })
  @BeforeTest
  public void beforeTest(String browser,String url) {
	  	logs=Logger.getLogger("devpinoyLogger1");
	  	logs.debug("working1");
	  	logs2=Logger.getLogger("devpinoyLogger2");
	  	logs2.debug("working2");
	  //	report=new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReportResults.html");
	  //	test= report.startTest("Test Started");
	  	if (browser.equals("firefox")) {
	  		System.setProperty("webdriver.gecko.driver", "e:\\browser-drivers\\geckodriver.exe");
	  		driver=new FirefoxDriver();
	  		logs.debug("Firefox browser Started");
	  	//	test.log(LogStatus.PASS,"FireFox browser started");
	  		
	  	}else if(browser.equals("chrome")) {
	  		System.setProperty("webdriver.chrome.driver", "e:\\browser-drivers\\chromedriver.exe");
	  		driver=new ChromeDriver();
	  		logs.debug("Chrome Driver Started");
	  		//test.log(LogStatus.PASS, "Chroe Driver Started");
	  	}
	  	
	  	driver.navigate().to(url);
	  	logs.debug("url open..");
		//test.log(LogStatus.PASS, "Navigated to the specified URL");
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void afterTest() throws Exception {
	  Screenshot s=new Screenshot();
	  s.CaptureShot(driver);
	  logs.debug("Screenshot Captured");
	  //test.log(LogStatus.PASS, "Screenshot Captured");
	  driver.quit();
	  logs.debug("browser closed");
	  //test.log(LogStatus.PASS, "browser closed");
	  //report.endTest(test);
	  //report.flush();
  }

}
