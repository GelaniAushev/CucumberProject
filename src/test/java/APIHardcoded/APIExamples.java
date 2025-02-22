package APIHardcoded;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APIExamples {

    // Setting the base URL
    String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

    // Token
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3Mzk5MzkzODMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTczOTk4MjU4MywidXNlcklkIjoiNzE3NCJ9.AZhC0WOwtTrt_V8fajpWqiYMgOpJQDaswy2hrur05Uo";

    static String empID;

    @Test
    public void aCreateEmployee(){
        // prepare the request
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token)
                .body("{\n" +
                        "  \"emp_firstname\": \"Gelani\",\n" +
                        "  \"emp_lastname\": \"Aushev\",\n" +
                        "  \"emp_middle_name\": \"ASUS\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-02-12\",\n" +
                        "  \"emp_status\": \"employeed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        Response response=prepareRequest.when().post("/createEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(201);

        response.then().assertThat().header("Connection","Keep-Alive");

        response.then().assertThat().body("Message",equalTo("Employee Created"));

        response.then().assertThat().body("Employee.emp_firstname",equalTo("Gelani"));

        // extract the employee id to be used in the next getCall
        empID=response.jsonPath().getString("Employee.employee_id");
        System.out.println("The employee id is: "+empID);
    }

    @Test
    public void bGetTheCreatedEmployee(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token)
                .queryParam("employee_id",empID);
        Response response=prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().body("employee.employee_id",equalTo(empID));

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void cUpdateTheEmployee(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token)
                .body("{\n" +
                        "  \"employee_id\": \""+empID+"\",\n" +
                        "  \"emp_firstname\": \"John\",\n" +
                        "  \"emp_lastname\": \"Doe\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-02-01\",\n" +
                        "  \"emp_status\": \"employeed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        Response response=prepareRequest.when().put("/updateEmployee.php");

        response.prettyPrint();
    }

}
