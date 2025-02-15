package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
///import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"Master","Regression","Sanity"})
	private void setUp() throws IOException {
		
		//properties file
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//creating logs
		logger=LogManager.getLogger(this.getClass());
		driver=new ChromeDriver();
		
		//logger.info(br);
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
		}
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String txt=RandomStringUtils.randomAlphabetic(5);
		return txt;
	}
	public String randomNumber() {
		String txt=RandomStringUtils.randomNumeric(10);
		return txt;	
	}
	public String randomAlphaNumber() {
		String txt1=RandomStringUtils.randomAlphabetic(5);
		String txt2=RandomStringUtils.randomNumeric(4);
		return txt1+txt2;		
	}
	public String timeStamp;
	public String capturescreenshot(String tname) {
		timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String storedPath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png"; //tname is failed test method
		File result=new File(storedPath);
		source.renameTo(result);
		return storedPath;
	}

	

}
