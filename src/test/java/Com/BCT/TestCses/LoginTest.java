package Com.BCT.TestCses;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Com.BCT.Commons.BaseClass;
import Com.BCT.pages.HomePage;
import Com.BCT.pages.LoginClass;


public class LoginTest extends BaseClass {

	LoginClass loginClass;
	HomePage homepage;
	
//	// Constructor of class
//		public LoginTest() {
//			super();
//		}
		
		
    @Parameters("BrowserName")
	@BeforeMethod
	public void setup(String BrowserName) throws Exception {
    	launchParallal(BrowserName);
	    //launch();
		loginClass = new LoginClass();
		homepage = new HomePage();
		
	}
	
	@Test
	public void login() throws Exception {
		
		homepage =loginClass.LoginData(p.getProperty("un"), p.getProperty("pass"));
	}
	
	

	 // @AfterMethod 
	  public void teardown()
	  { 
		  driver.close();
	  }
}
