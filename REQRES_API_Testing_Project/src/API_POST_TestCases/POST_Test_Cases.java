package API_POST_TestCases;
import API_GET_TestCases.GET_TEST_CASES;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POST_Test_Cases extends API_GET_TestCases.GET_TEST_CASES{

	@BeforeClass
	public void Before_Test_Initialization() {
		API_GET_TestCases.GET_TEST_CASES GetClassObj = new API_GET_TestCases.GET_TEST_CASES();
		
		response = GetClassObj.response;
		httpRequest = GetClassObj.httpRequest;
		report = GetClassObj.report;
		spark = GetClassObj.spark;
	}
	
	
	@Test
	public void TC_01_POST_Connection_Check() {
		
	}
	
	
	@Test
	public void TC_02_POST_Check_Response_Text() {
		
	}
	
	@Test
	public void TC_03_POST_Check_Response_Code() {
		
		
	}
	
	@Test
	public void TC_04_POST_Check_Response_Time() {
		
	}
	
	
	@Test
	public void TC_05_POST_Check_Session_ID() {
		
	}
	
	
	@Test
	public void TC_06_POST_Check_getResponse_string() {
		
	}
}
