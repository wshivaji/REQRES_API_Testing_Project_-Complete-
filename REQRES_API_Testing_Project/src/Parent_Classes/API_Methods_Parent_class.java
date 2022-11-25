package Parent_Classes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Methods_Parent_class {

	public Response response;
	public RequestSpecification httpRequest;

	public ExtentReports report;
	public ExtentSparkReporter spark;

	public API_Methods_Parent_class() {
		response = response;
		httpRequest = httpRequest;
		report = report;
		spark = spark;

		//Specify Base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Create Request Object
		httpRequest = RestAssured.given();

		//get response in console window
		response = httpRequest.request(Method.GET, "/users?page=2");

	}


}
