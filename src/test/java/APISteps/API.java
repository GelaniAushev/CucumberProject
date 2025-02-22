package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class API {

    //String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    static String token;
    RequestSpecification request;
    Response response;
    static String empID;

    @Given("a JWT bearer token is generated")
    public void a_jwt_bearer_token_is_generated() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body("{\n" +
                        "  \"email\": \"admin228@gmail.com\",\n" +
                        "  \"password\": \"Test@123\"\n" +
                        "}");

        Response response = request.when().post(APIConstants.GENERATE_TOKEN_URI);
        token = response.jsonPath().getString("token");
        token = "Bearer " + token;
    }

    @Given("a request is prepared for creation of an employee")
    public void a_request_is_prepared_for_creation_of_an_employee() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a Post call is made to create an Employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("status code is {int} for the call")
    public void status_code_is_for_the_call(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the value of the key {string} is {string}")
    public void the_value_of_the_key_is(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
    }

    @Then("the employee id {string} is stored in a global variable")
    public void the_employee_id_is_stored_in_a_global_variable(String key) {
        empID = response.jsonPath().getString(key);
    }

    //---------------------------get call----------------------------

    @Given("a request is prepared to retrieve an employee")
    public void a_request_is_prepared_to_retrieve_an_employee() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .queryParam("employee_id", empID);
    }

    @When("a get call is made to retrieve the employee")
    public void a_get_call_is_made_to_retrieve_the_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the received data from the object {string} matches the expected data")
    public void the_received_data_from_the_object_matches_the_expected_data(String empObj, io.cucumber.datatable.DataTable dataTable) {
        //data coming from feature file to validate with get call
        List<Map<String, String>> expectedData = dataTable.asMaps();
        //it will return the body in the form of the map, basically the value of the key employee
        Map<String, String> actualData = response.body().jsonPath().get(empObj);

        for (Map<String, String> map : expectedData) {
            //get all the keys in the map
            Set<String> keys = map.keySet();
            for (String key : keys) {
                String expectedValue = map.get(key);
                String actualValue = actualData.get(key);
                Assert.assertEquals(expectedValue,actualValue);
            }
        }
    }

}
