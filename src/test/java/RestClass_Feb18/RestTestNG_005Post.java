package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestTestNG_005Post
{
    @Test
   public void testngPost()
    {
        //Preparation of request
        RequestSpecification r = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        //Making request
        Response response = r.when().post();

        //Validation part
        ValidatableResponse vr = response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        vr.statusCode(200);

        //r.when().post();
        //r.then().statusCode(200);

    }
}
