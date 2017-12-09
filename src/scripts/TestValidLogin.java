package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;

import generic.Library;
import pom.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin(){
		LoginPage lp=new LoginPage(driver);
		String un = Library.getCellValue(EXCELPATH, "ValidLogin", 1, 0);
		String pw = Library.getCellValue(EXCELPATH, "ValidLogin", 1, 1);
		String expectedTitle = Library.getCellValue(EXCELPATH, "ValidLogin", 1, 2);
		lp.setUserName(un);
		lp.setPassword(pw);
		lp.clickLogin();
		//in order to fail
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		//to compare
		SoftAssert s= new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		s.assertAll();
	}
		
	}

