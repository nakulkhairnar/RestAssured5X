package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestTestNG_010Delete
{
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "27ed8db3bfd2b0a";

    @Test
    public void testDeleteRequest()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2832");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        Response response = requestSpecification.when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);





    }

}
