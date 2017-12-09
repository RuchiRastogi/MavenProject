package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import pom.LoginPage;


public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin(){
		LoginPage lp=new LoginPage(driver);
		int rowCount = Library.getRowCount(EXCELPATH, "InvalidLogin");
		for (int i = 1; i <=rowCount; i++) {
			String un=Library.getCellValue(EXCELPATH, "InvalidLogin", i, 0);	
			String pw=Library.getCellValue(EXCELPATH, "InvalidLogin", i, 1);
				
			lp.setUserName(un);
			lp.setPassword(pw);
			lp.clickLogin();
		}
		
		System.out.println(rowCount);
		
	}
}
