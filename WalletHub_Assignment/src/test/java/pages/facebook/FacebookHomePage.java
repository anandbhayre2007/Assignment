package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage {

	WebDriver dr;

    @FindBy(xpath="//span[contains(text(),'on your mind')]/../..")
    WebElement postTextBox;

    @FindBy(xpath="//div[contains(@aria-label,'on your mind')]")
    WebElement postMessage;
    
    @FindBy(xpath="//*[text()='Post']")
    WebElement postBtn;
    
    @FindBy(xpath="//span[text()='J']//following::div[@class='f530mmz5 b1v8xokw o0t2es00 oo9gr5id']/div[@class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql']")
    WebElement postedMessage;

    public FacebookHomePage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

 
    public boolean isPostTextboxDisplayed()
    {
    	return postTextBox.isDisplayed();
    }
    
    public void openPostMessagePopup()
    {
    	postTextBox.click();
    }
    
    public void postMessage(String message)
    {
    	postMessage.sendKeys(message);
    }
    
    public void clickPost()
    {
    	postBtn.click();
    }
    
    public String isMessageDisplayed()
    {
    	return postedMessage.getText();
    }
}