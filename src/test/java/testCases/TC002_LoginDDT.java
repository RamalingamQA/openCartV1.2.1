package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccount;
import pageObjects.loginPage;
import testBase.BaseClass2;
import testBase.dataProviders;

public class TC002_LoginDDT extends BaseClass2{
	@Test(dataProvider="LoginData",dataProviderClass=dataProviders.class)
	public void login(String userName, String pwd, String exp) throws InterruptedException {
		try
		{
		//logger.info("Execution started");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.accountBtn();
		hp.loginBtn();
		
		//Login Page
		loginPage lp=new loginPage(driver);
		lp.userNametxt(userName);
		lp.passwordtxt(pwd);
		lp.loginBtn();
		Thread.sleep(2000);
		
		//My AccountPage
		MyAccount ma=new MyAccount(driver);
		Thread.sleep(2000);
		boolean status=ma.myAccountTitle();
		System.out.println(status);
		System.out.println(driver.getTitle());
		
		//Data is valid - login success then logout->test pass
		//				  login failed then no action->test fail
		
		//Data is invalid-login success then logout->test fail
		//				login failed no actions->test pass
		
		if(exp.equalsIgnoreCase("valid")) {
			if(status==true) {
				ma.logoutBtn();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(status==true) {
				ma.logoutBtn();
				Assert.fail();
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.error("err");
			logger.debug("debug");
			Assert.fail();
			}
		
		
		
	}
	

}
