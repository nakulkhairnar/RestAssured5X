package RestClass_Feb18;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Rest_003Get
{
    //Non BDD style Get request
    //HTTP Method   ID    Auth   Payload   Few Keys
    //GET           y      x       x
    //POST          x      x       y
    //PATCH         y      y       y        Only few
    //PUT           y      y       y        All keys
    //DELETE        y      y       x
    //GET ALL       x      x       x
    //HEAD          y      x       x      only header info
    public static void main(String[] args)
    {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4007").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

        //testing framework --> Allow us to execute the test cases
        //1 main --> it will execute all the testcase that we have mentioned


    }



}
