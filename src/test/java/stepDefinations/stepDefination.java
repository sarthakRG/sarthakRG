package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import resources.TestDataBuild;
import resources.Utils;
import resources.apiresources;

public class stepDefination extends Utils{
	
	RequestSpecification response;
	Response response12;
	static int Count1;
	static String Fname;

	@Given("^Get Character request$")
    public void get_character_request() throws Throwable {
		response = given().spec(requestspecifica());
        
	}

	    @When("^User calls \"([^\"]*)\" with get http request$")
	    public void user_calls_something_with_get_http_request(String res) throws Throwable {
	    	
	    	apiresources value = apiresources.valueOf(res);
	    	
	    	response12 = response.when().get(value.getresource()).then().extract()
					.response();
	        
	    }

	    @Then("^the api call is success with status code \"([^\"]*)\"$")
	    public void the_api_call_is_success_with_status_code_something(int strArg1) throws Throwable {
	        
	    	
	    	assertEquals(response12.getStatusCode(),strArg1);
	    }

	    @And("^\"([^\"]*)\" in response is \"([^\"]*)\"$")
	    public void something_in_response_is_something(String strArg1, int Counttocheck) throws Throwable {
	        
	    	 Count1 = getJsonPath(response12,strArg1);
	    	 
	    	 assertEquals(Count1,Counttocheck);
	    	
	    }
	    
	    @Given("^Get special Character request with \"([^\"]*)\"$")
	    public void get_special_character_request_with_something(String name) throws Throwable {
	    	response = given().spec(requestspecifica()).queryParam("search", ""+name+"");
	    }

	    @When("^User calls for request with \"([^\"]*)\"$")
	    public void user_calls_for_request_with_something(String res) throws Throwable {
	        
	    	apiresources value = apiresources.valueOf(res);
	    	
	    	response12 = response.when().get(value.getresource()).then().extract()
					.response();
	    }
	    
	    
	    @Then("^the api call for get special character is success with status code \"([^\"]*)\"$")
	    public void the_api_call_for_get_special_character_is_success_with_status_code_something(int stacode) throws Throwable {
	    	assertEquals(response12.getStatusCode(),stacode);
	    }
	    
	    
	    @And("^name in response should be \"([^\"]*)\"$")
	    public void name_in_response_should_be_something(String strArg2) throws Throwable {
	        
	    	String j = response12.asString();
	    	JsonPath qwe = new JsonPath(j);
	    	Fname = qwe.get("results[0].name");
	    	assertEquals(Fname,strArg2);
	    }

	    
	    @Given("^Get Planet request$")
	    public void get_planet_request() throws Throwable {
	    	response = given().spec(requestspecifica());
	    }

	    @When("^User calls \"([^\"]*)\" api with get http request method$")
	    public void user_calls_something_api_with_get_http_request_method(String strArg1) throws Throwable {
	    	apiresources value = apiresources.valueOf(strArg1);
	    	
	    	response12 = response.when().get(value.getresource()).then().extract()
					.response();
	    }

	    @Then("^the api call should be a success with status code \"([^\"]*)\"$")
	    public void the_api_call_should_be_a_success_with_status_code_something(int strArg1) throws Throwable {
	    	assertEquals(response12.getStatusCode(),strArg1);
	    }

	    @And("^\"([^\"]*)\" of planets in response is \"([^\"]*)\"$")
	    public void something_of_planets_in_response_is_something(String strArg1, int Counttocheck) throws Throwable {

	    	Count1 = getJsonPath(response12,strArg1);
	    	 
	    	 assertEquals(Count1,Counttocheck);
	    	
	    }
	    
	    
	    @Given("^Get special planet request with \"([^\"]*)\"$")
	    public void get_special_planet_request_with_something(String name) throws Throwable {
	    	response = given().spec(requestspecifica()).queryParam("search", ""+name+"");
	    }

	    @When("^User calls api \"([^\"]*)\" to get the desired planet$")
	    public void user_calls_api_something_to_get_the_desired_planet(String strArg1) throws Throwable {
	    	apiresources value = apiresources.valueOf(strArg1);
	    	
	    	response12 = response.when().get(value.getresource()).then().extract()
					.response();
	    }

	    @Then("^the api call for get special planet is success with status code \"([^\"]*)\"$")
	    public void the_api_call_for_get_special_planet_is_success_with_status_code_something(int strArg1) throws Throwable {
	    	assertEquals(response12.getStatusCode(),strArg1);
	    }

	    @And("^Planet name in response should be \"([^\"]*)\"$")
	    public void planet_name_in_response_should_be_something(String strArg1) throws Throwable {

	    	String j = response12.asString();
	    	JsonPath qwe = new JsonPath(j);
	    	Fname = qwe.get("results[0].name");
	    	assertEquals(Fname,strArg1);
	    }

	    

}
