package API_POST_TestCases;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.devtools.v105.runtime.model.ExceptionThrown;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Parent_Classes.API_Methods_Parent_class;
import io.restassured.http.Method;

public class POST_Test_Cases extends API_Methods_Parent_class{


	String x;
	JSONParser parser;

	@Test
	public void TC_01_POST_Connection_Check() throws ParseException {
		try {
			JSONObject CreateJson = new JSONObject();

			CreateJson.put("Name", "Shivaji");
			CreateJson.put("Job", "QA");

			httpRequest.header("Content-type", "application/json");
			httpRequest.body(CreateJson.toJSONString());

			response = httpRequest.request(Method.POST,"/users");

			String responseBody = response.getBody().toString();
			x = response.asPrettyString().toString();
			System.out.println("response body post case: "+responseBody+"  \n preety string:  "+x);
			ExtentTest TC_01 = report.createTest("TC_01_POST_Connection_Check");
			TC_01.log(Status.PASS, "Test Case executed and response received.");
			TC_01.log(Status.INFO, responseBody);
			report.flush();

		}
		catch (Exception e){
			e.printStackTrace();
			
		}

				
	}


	@Test
	public void TC_02_POST_Check_Response_Text() throws ParseException {
		System.out.println("Convert body in json: ");
		parser = new JSONParser();
		JSONObject jobj = (JSONObject) parser.parse(x);
		System.out.print("\n\nJSON Name: "+jobj.get("Name")); 
		int id = (int) jobj.get("id");
		System.out.println("\n\n ID: "+id);
		Assert.assertEquals(id, 200);
		ExtentTest TC_02 = report.createTest("TC_02_POST_Check_Response_Text");
		if(id==200) {
			System.out.println("Post Success ");
			TC_02.log(Status.PASS, "Resonse code reveived: "+id);
			report.flush();
		}
		else {
			System.out.println("POST Fail ");
			TC_02.log(Status.FAIL, "Response code received: "+id);
			report.flush();
		}
	}

	@Test
	public void TC_03_POST_Check_Response_Code() {


	}

	@Test
	public void TC_04_POST_Check_Response_Time() throws ParseException {
		JSONObject jobj = (JSONObject) parser.parse(x);
		String createAt = (String) jobj.get("createdAt");
		System.out.print("\n\nJSON Time: "+createAt);
		boolean checkdata = createAt.isBlank();
		Assert.assertEquals(checkdata, true);
		
	}


	@Test
	public void TC_05_POST_Check_Session_ID() {
		String sessionID = response.getSessionId();
		System.out.println("\n\nSession ID: "+sessionID);
		
	}


	@Test
	public void TC_06_POST_Check_getResponse_string() {

	}
}
