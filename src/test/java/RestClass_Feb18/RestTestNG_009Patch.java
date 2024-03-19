package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestTestNG_009Patch
{
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "3a5ac58db52a4e2";


    @Test
    public void patchrequest()
    {
        String payload = "{\n" +
                "    \"firstname\" : \"Nakul\",\n" +
                "    \"lastname\" : \"Khairnar\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Nakul\",\n" +
                "    \"lastname\" : \"Khairnar123\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/740");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        //For patch request
        requestSpecification.body(payloadPatch).log().all();
        //Calling Patch method on URI. After hitting we get response
        Response response = requestSpecification.when().patch();//we can remove when() that will be fine

        //Get validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Nakul"));
        validatableResponse.body("lastname", Matchers.equalTo("Khairnar123"));

    }
}
