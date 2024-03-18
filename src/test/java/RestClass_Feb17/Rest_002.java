package RestClass_Feb17;

import io.restassured.RestAssured;

public class Rest_002
{
    //BDD style get request
    public static void main(String[] args)
    {
        //GET request https://api.zippopotam.us/IN/560037
        //URL
        //Header=no
        //Get method
        //base Url= https://api.zippopotam.us
        //base path= IN/560037
        //payload: no
        //Auth: no
        //validate status code:
        //Response body:
        //Time, Header, Cookies
        //Gherkin --> Given, when, then -->
        //non BDD and still use gherkin syntax

        //RestAssured.given().when().then()- domain specific language (Java);
        //given()--> URL, Header, Base URL, Base Path, Auth, params. message body
        //When()--> Payload, after mentiond Http Method,
        //Then()--> Response validation, status code, response body, time, cookies etc
        RestAssured.given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/560037").when().get().then()
                .log().all()
                .statusCode(200);
    }
}
