package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//span[text()='My Account']") WebElement account;
	@FindBy(xpath="//li//a[@href='https://tutorialsninja.com/demo/index.php?route=account/register']") WebElement register;
	@FindBy(xpath="//ul//li[2]//a[text()='Login']") WebElement login;

	
	public void accountBtn() {
		account.click();
	}
	public void registerBtn() {
		register.click();
	}
	public void loginBtn() {
		login.click();
	}
	
}
