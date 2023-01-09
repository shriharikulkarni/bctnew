package Com.BCT.Commons;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {


	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;




	//To read properties file
	public   BaseClass(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream("C://Users//shrihari.kulkarni//eclipse-workspace//Browser_Compatibility_Testing//src//main//java//Com//BCT//property//Config.properties");
			p.load(f);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	//To launch Browser
	public void launch() {

		if((p.getProperty("BrowserName")).equalsIgnoreCase("chrome")) {
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}else if((p.getProperty("BrowserName")).equalsIgnoreCase("firefox")){
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else if((p.getProperty("BrowserName")).equalsIgnoreCase("edge")){
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "E://edge driver//msedgedriver.exe");
			driver = new EdgeDriver();

		}

	}

	public void launchParallal(String BrowserName) {

		System.out.println("Browser name is :"+BrowserName);

		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "E://edge driver//msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}





}
