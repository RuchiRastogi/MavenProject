package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declare the variables
	@FindBy(id="username")
	private WebElement unTb;
	
	@FindBy(name="pwd")
	private WebElement pwd;
	
	@FindBy(xpath=".//div[.='Login ']")
	private WebElement loginBtn;
	
	//initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void setUserName(String un){
		unTb.sendKeys(un);
	}
	public void setPassword(String passwd){
		pwd.sendKeys(passwd);	
		
	}
	
	public void clickLogin(){
		loginBtn.click();
	}

}
