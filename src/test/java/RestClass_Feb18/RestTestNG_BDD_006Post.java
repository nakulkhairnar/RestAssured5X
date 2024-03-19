package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RestTestNG_BDD_006Post
{
    @Test
    public void testBDDPost()
    {
        //Post: Request
        //URL
        //Body: Payload - JSON
        //Headers - content types
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        //hashmap, CLass - Automation ? - class - 60-70%

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).log().all()
                .body(payload).when().post()
                .then().log().all()
                .statusCode(200);
    }

}
