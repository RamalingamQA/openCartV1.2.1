package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']") WebElement userName;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement login;
	
	
	public void userNametxt(String Name) {
		userName.sendKeys(Name);
		
	}

	public void passwordtxt(String pass) {
		password.sendKeys(pass);
		
	}
	public void loginBtn() {
		login.click();
	}
	

}
