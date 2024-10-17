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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass2{
	
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
	@Parameters({"browser","Os"})
	@BeforeClass
	public void setup(String br, String os) throws IOException {
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		//creating logger
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver= new FirefoxDriver();break;
		default: System.out.println("ENter valid browser");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url=p.getProperty("appURL1");
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void TearDown() {
		driver.quit();
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
}