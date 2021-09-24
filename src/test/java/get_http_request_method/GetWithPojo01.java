package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import pojos.Bookingdates;

/*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "firstname": "Mary",
                                    "lastname": "Smith",
                                    "totalprice": 647,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2016-02-05",
                                        "checkout": "2021-01-16"
                                     }
                                     "additionalneeds": "Breakfast"
                                  }
     */
public class GetWithPojo01 extends JsonPlaceHolderBaseUrl {

    @Test

    public void getWithPojo01(){

        spec.pathParams("first", "booking", "second", 2);
        

    }
}
