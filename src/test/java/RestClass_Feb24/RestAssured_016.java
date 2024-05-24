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

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssured_016
{
    String token;
    Integer bookingID;
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void getToken()
    {
        System.out.println("- Get Token ID");
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
        validatableResponse.body("token", Matchers.notNullValue());
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
    }
    @BeforeTest
    public void getBookingID()
    {
        System.out.println("-- Get Booking ID");
        requestSpecification = RestAssured.given();
        String payload2 = "{\n" +
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
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload2);
        Response response = requestSpecification.when().post();
        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(200);
        bookingID = response.then().log().all().extract().path("bookingID");
        System.out.println(bookingID);
    }
    @Test
    public void testPut()
    {
        //token and booking ID
        System.out.println("- Test case PUT request");
        String payload3 = "{\n" +
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
        requestSpecification.basePath("booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload3).log().all();
        Response response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Nakul"));
        validatableResponse.body("lastname", Matchers.equalTo("QA"));
    }
    @Test
    public void test2PUT()
    {
        System.out.println("Test case 2 for put request");
        String payload4 = "{\n" +
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
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.baseUri("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload4).log().all();
        Response response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String firstname = response.then().log().all().extract().path("firstname");
        assertThat(firstname).isNotNull().isNotBlank().isNotEmpty();
    }
}
