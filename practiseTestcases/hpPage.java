package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class hpPage extends BasePage2{
	public hpPage(WebDriver driver) {
		super(driver);
	}
	
	By account= By.xpath("//span[text()='My Account']");
	By register= By.xpath("//li//a[@href='https://tutorialsninja.com/demo/index.php?route=account/register']");
	
	public void accountBtn() {
		driver.findElement(account).click();
	}
	public void registerBtn() {
		driver.findElement(register).click();
	}
	
	

}
