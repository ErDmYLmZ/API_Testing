package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertTrue;

public class Get05Rep extends HerOkuAppBaseUrl {

    /*
         Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Mary" and last name is "Ericsson"
     */


    @Test

    public void get05Rep() {

        spec.pathParam("first", "booking").
                queryParams("firstname","Mary","lastname","Jones");

        Response response = given().
                            spec(spec).
                            when().
                            get("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        assertTrue("The data looked for does not exist", response.asString().contains("bookingid"));

    }
}