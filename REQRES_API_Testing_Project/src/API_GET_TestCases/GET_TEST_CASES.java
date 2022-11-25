package API_GET_TestCases;






import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Parent_Classes.API_Methods_Parent_class;

public class GET_TEST_CASES extends API_Methods_Parent_class {



	@BeforeClass
	public void before_class_initialize_api() {

		report  = new ExtentReports();
		spark = new ExtentSparkReporter("Extent_Report/ExtentTestReport.html");
		spark.config().setDocumentTitle("REST API Test Report");
		spark.config().setReportName("This is API GET Method Test Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setEncoding("utf-8");
		report.attachReporter(spark);
	}



	@Test
	public void TC01_api_connect_check() {
		
		try {
			
			//get response body in string
			String responseBody = response.getStatusLine();
			System.out.println("Status Code is: "+responseBody);
			Assert.assertEquals(responseBody, "HTTP/1.1 200 OK");
			ExtentTest TC_01 = report.createTest("TC_01 Check API Connection using GET Method");
			if(responseBody == "HTTP/1.1 200 OK") {
				TC_01.log(Status.PASS, "API GET connection Success");
				report.flush();
			}
			else {
				TC_01.log(Status.FAIL, "API GET connection Fail");
				report.flush();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void TC02_Check_Response_code() {
		//get status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code of API Response: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		ExtentTest TC_02 = report.createTest("TC_02 Check API Connection response 200");
		if(statusCode == 200) {
			TC_02.log(Status.PASS, "API GET Method Status Code Received"+statusCode);
			report.flush();
		}
		else {
			TC_02.log(Status.FAIL,"API GET Method Status Code not Received "+statusCode);
			report.flush();
		}
	}

	@Test
	public void TC03_get_Complete_Response() {

		System.out.print("Pretty String: "+response.asPrettyString());
		boolean empty_body = response.asPrettyString().isEmpty();
		Assert.assertEquals(false, empty_body);
		ExtentTest TC03= report.createTest("TC_03 Response body received contain data");
		if (!empty_body){
			TC03.log(Status.PASS, "API GET response contains data");
			TC03.log(Status.INFO, response.asPrettyString());
			report.flush();

		}
		else {
			TC03.log(Status.FAIL, "API Get response does not contain data");
			TC03.log(Status.INFO, response.asPrettyString());
			report.flush();

		}
	}

	@Test
	public void TC04_Check_Time_Received() {

		int time = (int) response.time();
		System.out.println("Response Time: "+response.time());
		ExtentTest TC04 = report.createTest("TC_04 is time received");
		if(time > 0) {
			TC04.log(Status.PASS, "Time Received");
			TC04.log(Status.INFO, "Time :"+time);
			report.flush();
		}
		else {
			TC04.log(Status.FAIL, "Time Not Received");
			TC04.log(Status.INFO, "Time : "+time);
			report.flush();
		}
	}


	@Test
	public void TC05_Receive_body_as_string() {
		String s = response.asString();
		boolean has_data = s.isBlank();
		Assert.assertEquals(has_data, true);
		ExtentTest TC05 = report.createTest("TC_05 is data converted to string");
		if(!has_data) {
			TC05.log(Status.PASS, "Data Converted into String successfully");
			TC05.log(Status.INFO, "Data : "+s);
			report.flush();
		}
		else {
			TC05.log(Status.FAIL, "Data Not converted into String ");
			TC05.log(Status.INFO, "Data : "+s);
			report.flush();
		}
	}


	@Test
	public void TC06_Check_session_ID() {

		System.out.println("Session Id: "+response.getSessionId());
		String sessionID = response.getSessionId();
		boolean has_id = sessionID.isEmpty();
		Assert.assertEquals(has_id, true);
		ExtentTest TC06 = report.createTest("TC_06 is Session ID Received");
		if(has_id) {
			TC06.log(Status.FAIL, "Session ID not Received");
			TC06.log(Status.INFO, "Data : "+sessionID);
			report.flush();
		}
		else {
			TC06.log(Status.PASS, "Session ID received successfully");
			TC06.log(Status.INFO, "Data : "+sessionID);
			report.flush();
		}
	}
}
