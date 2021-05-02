package commonFunctionLibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionLibrary {

	/*
	 * Author:
	 * Date:
	 * Description:
	 * Param: 
	 * 
	 */
	public WebDriver launchBrowser(String browserName, String url)
	{
		WebDriver dr=null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().browserVersion("90.0.4430.24").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); 
			options.addArguments("--disable-notifications");
			dr = new ChromeDriver(options);
		}else if(browserName.equals("firefox")){
			//TODO: Add code to launch firefox browser
		}
		dr.get(url);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return dr;
	}
	
	
	public void captureScreenShot(WebDriver dr, String fileName) throws IOException
	{
		  TakesScreenshot screenshot=(TakesScreenshot)dr; File
		  src=screenshot.getScreenshotAs(OutputType.FILE);
		  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  FileHandler.copy(src, new File(Configuration.screenshotPath+fileName+"_"+timeStamp+".png"));
	}
}
