package API_PUT_TestCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Parent_Classes.API_Methods_Parent_class;

public class PUT_TestCases extends API_Methods_Parent_class{

	@BeforeClass
	public void before_class_initialize() {

		API_GET_TestCases.GET_TEST_CASES GetClassObj = new API_GET_TestCases.GET_TEST_CASES();

		response = GetClassObj.response;
		httpRequest = GetClassObj.httpRequest;
		report = GetClassObj.report;
		spark = GetClassObj.spark;

	}


	@Test
	public void TC_01_PUT_Connection_check() {

	}


	@Test
	public void TC_02_PUT_Connection_Response_check() {

	}


	@Test
	public void TC_03_PUT_StatusCode_Check() {


	}

	@Test
	public void TC_04_PUT_Response_text_check() {

	}

	@Test
	public void TC_05_PUT_Response_Time_Check() {

	}

}
