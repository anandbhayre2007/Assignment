package pages.wallethub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallethubHomePage {

	WebDriver dr;

    @FindBy(xpath="//review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']/*[local-name()='svg']")
    List<WebElement> stars;

    public WallethubHomePage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

 
    public void hoverMouseCursorOverAllTheStars() 
    {
    	Actions act= new Actions(dr);
    	
    	for(WebElement ele:stars)
    	{
    		act.moveToElement(ele).build().perform();
    		 
    		WebDriverWait wait= new WebDriverWait(dr,2);
    		
    		wait.until(ExpectedConditions.visibilityOf(ele.findElement(By.xpath("//*[local-name()='path' and @fill='none']"))));
    	}
    }
    
    public void clickStar(int starNumber)
    {
    	stars.get(starNumber-1).click();
    }
    
}
