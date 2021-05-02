package pages.wallethub;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallethubReviewPage {

	WebDriver dr;

    @FindBy(xpath="//div[text()='Submit']")
    WebElement submitBtn;
    
    @FindBy(xpath="//span[contains(.,'Select')]")
    WebElement policyDropdown;
    
    @FindBy(xpath="//span[contains(.,'Select')]/../ul[@class='dropdown-list ng-enter-element']/li")
    List<WebElement> policies;
    
    @FindBy(xpath="//textarea[contains(@placeholder,'Write your review')]")
    WebElement writeReview;

    public WallethubReviewPage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr, this);
    }
    
    public  boolean isReviewPageDisplayed()
    {
    	return writeReview.isDisplayed();
    }

    public void clickPolicyDropdown()
    {
    	policyDropdown.click();
    }
 
    public void selectPolicy(String policyName) 
    {
    	clickPolicyDropdown();
    	
    	for(WebElement ele:policies)
    	{
    		if(ele.getText().equals(policyName))
    		{
    			ele.click();
    			break;
    		}
    	}
    }
    
    public void writeYourReview(int length)
    {
    	 String review = RandomStringUtils.random(length, true, false);
    	writeReview.sendKeys(review);
    }
    
    public void clickSubmit()
    {
    	submitBtn.click();
    }
    
}
