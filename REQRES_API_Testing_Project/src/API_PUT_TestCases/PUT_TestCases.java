package API_PUT_TestCases;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Parent_Classes.API_Methods_Parent_class;
import io.restassured.http.Method;

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
		
		try {

			JSONObject Jobj  = new JSONObject();
			Jobj.put("id", "98030");
			Jobj.put("name", "Shivaji");
			Jobj.put("email", "shivaji@mgail.com");
			Jobj.put("last_name", "wankhede");
			Jobj.put("avatar", "www.google.com");
			System.out.println("Created Json object data: "+Jobj);
			httpRequest.header("content-type","application/json");
			httpRequest.body(Jobj.toJSONString());
			response = httpRequest.request(Method.PUT, "/users/2");
			System.out.println("\nPUT Response: "+response.asPrettyString().toString());
			String body = response.asPrettyString().toString();
			boolean check_body = body.isBlank();
			Assert.assertEquals(check_body, false);
			ExtentTest TC_01 = report.createTest("TC_01_PUT_Connection_check");
			if(check_body == false) {
				TC_01.log(Status.PASS, "Connection check ok");
				TC_01.log(Status.INFO, body);
				report.flush();
			}
			else {
				TC_01.log(Status.FAIL, "Connection fail");
				TC_01.log(Status.INFO, body);
				report.flush();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
