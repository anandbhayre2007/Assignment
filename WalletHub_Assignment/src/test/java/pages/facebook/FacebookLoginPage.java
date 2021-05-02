package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	WebDriver dr;

    @FindBy(id="email")
    WebElement userName;

    @FindBy(id="pass")
    WebElement password;    


    @FindBy(name="login")
    WebElement login;

    public FacebookLoginPage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        userName.sendKeys(strUserName);     
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
    password.sendKeys(strPassword);
    }

    //Click on login button

    public void clickLogin(){
            login.click();
    }  

    //Get the title of Login Page
    public String getLoginTitle(){
     return    dr.getTitle();
    }

    public void loginToFacebook(String strUserName,String strPasword){

        //Fill user name
        this.setUserName(strUserName);

        //Fill password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();           

    }
}
