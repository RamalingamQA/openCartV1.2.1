package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccount;
import pageObjects.loginPage;

public class dummy {
	WebDriver driver;
	@Test()
	public void reg() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.accountBtn();
		hp.loginBtn();
		//Login with Bad creds
		loginPage lp=new loginPage(driver);
		lp.userNametxt("tret");
		lp.passwordtxt("dhss");
		lp.loginBtn();
		//Validate account page
		MyAccount ma=new MyAccount(driver);
		ma.myAccountTitle();
		System.out.println(ma.myAccountTitle());
		if(ma.myAccountTitle()==true) {
			Assert.assertTrue(true);
			}
		else {
			Assert.assertFalse(false);
		}
		
	}

}
