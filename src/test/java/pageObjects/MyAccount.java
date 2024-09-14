package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccountPage;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement logOut;
	
	public boolean myAccountTitle() {
		try {
			return myAccountPage.isDisplayed();
		}
		catch(Exception e){
			return false;
		}
			
		}
	
	public void logoutBtn() {
		logOut.click();
	}

}
