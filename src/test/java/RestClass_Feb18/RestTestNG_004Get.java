package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestTestNG_004Get
{
    // add dependency of TestNG in pom.xml -- added
    @Test
    public void getAllBooking001()
    { //positive test case
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1872").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
    @Test
    public void getAllBooking002()
    { //negative test case
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }
    @Test(enabled = false)
    public void getAllBooking003()
    {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }


}
