package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestTestNG_007Put
{

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;


    String token = "bddf81907c19e61";
    @Test
    public void testputrequest()
    {
        //URL, Auth token, ID(2222), Payload,  we required
        String payload = "{\n" +
                "    \"firstname\" : \"Nakul\",\n" +
                "    \"lastname\" : \"QA\",\n" +
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
        requestSpecification.basePath("booking/2833");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);


        requestSpecification.body(payload).log().all();


        //Calling Put method on URI. After hitting we get response
        Response response = requestSpecification.when().put();//we can remove when() that will be fine

        //Get validatable response to perform validation
         validatableResponse = response.then().log().all();
         validatableResponse.statusCode(200);
         validatableResponse.body("firstname", Matchers.equalTo("Nakul"));
         validatableResponse.body("lastname", Matchers.equalTo("QA"));

    }

}
