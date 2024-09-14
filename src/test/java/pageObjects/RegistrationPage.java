package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='firstname']") WebElement firstName;
	@FindBy(xpath="//input[@name='lastname']") WebElement lastName;
	@FindBy(xpath="//input[@name='email']") WebElement eMail;
	@FindBy(xpath="//input[@name='telephone']") WebElement telePhone;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='confirm']") WebElement confirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	@FindBy(xpath="//input[@type='submit']") WebElement submit;
	@FindBy(xpath="//div[@id='content']//h1[1]") WebElement successMsg;

	
	
	
	public void firstNametxt(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	public void lastNametxt(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	public void emailtxt(String email) {
		eMail.sendKeys(email);
		
	}
	public void telePhonetxt(String phoneNumber) {
		telePhone.sendKeys(phoneNumber);
	}
	public void passWordtxt(String password) {
		this.password.sendKeys(password);
	}
	public void confirmPasswordtxt(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}
	public void agreeBtn() {
		agree.click();
	}
	public void submitBtn() {
		submit.click();
	}
	public String successMsg() {
		try {
			String txt=successMsg.getText();
			return txt;
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
		
		
	}
}