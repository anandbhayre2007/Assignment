package driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commonFunctionLibrary.FunctionLibrary;

public class Driver {

	public static WebDriver dr;
	public FunctionLibrary lib=new FunctionLibrary();
	
	@BeforeTest
	@Parameters({"browserName","url"})
	public void setUp(String browserName, String url)
	{
		//Launch the application
		dr=lib.launchBrowser(browserName, url);
	}
	
	@AfterTest
	public void tearDown()
	{
		dr.quit();
	}
}
