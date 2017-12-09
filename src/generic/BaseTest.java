package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IautoConstant{
	public static WebDriver driver;
	static{
		System.setProperty(GECKO_VALUE,GECKO_PATH);
		System.setProperty(CHROME_VALUE,CHROME_PATH);
	}
	//private static final String Key = null;
	
	@BeforeMethod
	public void openApplications(){
		driver=new FirefoxDriver();
		String url = Library.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		String ITO = Library.getProperty(CONFIG_PATH, "ImplicitlytimeOut");
		int time = Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
	
	//creating method for getting screenshot for failed testcases-
	public void getScreenshot(String testName){
		Date d=new Date();
		String currentDate = d.toString().replaceAll(":", "_");
 TakesScreenshot ts=(TakesScreenshot) driver;
 File scrFile = ts.getScreenshotAs(OutputType.FILE);
 File destFile=new File(".\\Screenshot\\"+currentDate+"\\"+testName+"screenshot.png");
 try {
	 FileUtils.copyFile(scrFile, destFile);
	
} catch (Exception e) {
	e.printStackTrace();
	
}

	

}}
