package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec ;

   @Before
    public void setUp(){
        spec = (RequestSpecification) new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }
}
