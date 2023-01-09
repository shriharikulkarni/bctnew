package Com.BCT.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import Com.BCT.Commons.BaseClass;

public class LoginClass extends BaseClass {
	
	BaseClass t = new BaseClass();
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;

	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement Loginbtn;
	


	public LoginClass()
	{
		PageFactory.initElements(t.driver, this);
	}
	

	public HomePage LoginData(String un, String pass) throws InterruptedException

	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		
		uname.sendKeys(un);
		password.sendKeys(pass);
		Loginbtn.click();
		
		
		
		return new HomePage();
	}

}
