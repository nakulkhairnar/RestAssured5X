package RestClass_Feb24;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RestAssured_013
{
    //put request
    //Before - token, ID
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

@BeforeTest
    public void getToken()
    {
        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.post();
        validatableResponse = response.then();
        //Rest Assured --> Matchers(Hamcrest) - 1-2 % times you will be using it
        validatableResponse.body("token", Matchers.notNullValue());
        //TestNG Assertions
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
        //AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
        System.out.println(token);

    }
    @Test
    public void testNGputreq()
    {
        //Now we need to pass the above created token in this put request
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/3645");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();
        //Calling Put method on URI. After hitting we get response
        Response response = requestSpecification.when().put();
        //we can remove when() that will be fine
        //Get validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));

    }

}
