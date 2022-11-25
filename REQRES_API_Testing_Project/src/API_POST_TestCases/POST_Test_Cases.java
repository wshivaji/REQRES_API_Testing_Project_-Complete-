package API_POST_TestCases;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Parent_Classes.API_Methods_Parent_class;
import io.restassured.http.Method;

public class POST_Test_Cases extends API_Methods_Parent_class{




	@Test
	public void TC_01_POST_Connection_Check() {




		JSONObject CreateJson = new JSONObject();

		CreateJson.put("Name", "Shivaji");
		CreateJson.put("Job", "QA");

		httpRequest.header("Content-type", "application/json");
		httpRequest.body(CreateJson.toJSONString());

		response = httpRequest.request(Method.POST,"/users");

		String responseBody = response.getBody().toString();
		String x = response.asPrettyString().toString();
		System.out.println("response body post case: "+responseBody+"  \n preety string:  "+x);

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
