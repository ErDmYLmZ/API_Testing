package get_http_request_method;

import base_urls.Restapiexample;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;


public class DummyTest06 extends Restapiexample {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            This user exists in the system
           {
            "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""
        },
        {
            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""
        }
     */

    @Test
    public void DummyTest06(){
        spec.pathParams("first", "api", "second", "v1", "third", "employee", "final", 7);
        //spec.pathParams("first", "api", "second", "v1", "third", "employee");
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();

//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("data.id",equalTo(7), "employee_name", equalTo(null),
//                        "employee_salary", equalTo( null), "employee_age", equalTo( null));

        spec.pathParams("first", "api", "second", "v1", "third", "employee", "final", 8);
        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response2.prettyPrint();

        JsonPath json = response2.jsonPath();
//        assertEquals("Id does not match",8,json.getInt("data.id"));
//        assertEquals("Name does not match", "Rhona Davidson",json.getString("employee_name"));
//        assertEquals("Salary does not match",327900,json.getInt("employee_salary"));
//        assertEquals("Age does not match",55,json.getInt("employee_age"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getInt("id"), 8, "id does not match");
        softAssert.assertEquals(json.getString("employee_name"), "Rhona Davidson", "Name does not match");
        softAssert.assertEquals(json.getInt("employee_salary"), 327900, "Salary does not match");
        softAssert.assertEquals(json.getInt("employee_age"), 59, "Age does not match");

        softAssert.assertAll();



//        spec.pathParams("first", "api", "second", "v1", "third", "employee", "final", 8);
//        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
//        response2.prettyPrint();











    }
}
