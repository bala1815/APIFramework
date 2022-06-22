package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.Utils;

public class StepDefinition extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
		
@Given("the payload is ready to add the Post")
public void the_payload_is_ready_to_add_the_Post()throws IOException
{
    req = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
    res = given().spec(req).body("\"title\" : \"bala World\"");
}

@When("user calls add posts api with Post http request")
public void user_calls_add_posts_api_with_Post_http_request() {
    response = res.when().post("posts").then().spec(resspec).extract().response();
}


@Then("Response code is {int} Ok")
public void Response_code_is_Ok(Integer int1) {
    String responseString =response.asString();
    System.out.println(responseString);
    assertEquals(response.getStatusCode(), 201);
}


@Given("the payload is ready to update the Posts using post id")
public void the_payload_is_ready_to_update_the_Posts_using_post_id() {
	req = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    res = given().spec(req).body("\"id\": 10,\r\n"
    		+ "    \"title\": \"Bala aut facere repellat provident occaecati excepturi optio reprehenderit\"");
   
}

@When("user calls  posts update api with Put http request")
public void user_calls_posts_update_api_with_Put_http_request() {
	 response = res.when().put("posts/10").then().spec(resspec).extract().response();

}

@Then("Update status in Response body is Ok")
public void update_status_in_Response_body_is_Ok() {
	  String responseString =response.asString();
	    System.out.println(responseString);
	    assertEquals(response.getStatusCode(), 200);
}


@Given("the payload is ready to get the comments of the respective post id")
public void the_payload_is_ready_to_get_the_comments_of_the_respective_post_id() {
	req = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    res = given().spec(req);
}

@When("user calls  posts id and comments by http get request")
public void user_calls_posts_id_and_comments_by_http_get_request() {
	response = res.when().get("posts/1/comments").then().spec(resspec).extract().response();
}


@Then("Update status Response code  is {int} Ok")
public void update_status_Response_code_is_Ok(Integer int1) {
	String responseString =response.asString();
    System.out.println(responseString);
	 assertEquals(response.getStatusCode(), 200);
}

@Then("response code is {int} Ok")
public void response_code_is_Ok(Integer int1) {
	String responseString =response.asString();
    System.out.println(responseString);
    assertEquals(response.getStatusCode(), 200);  
   }
}
