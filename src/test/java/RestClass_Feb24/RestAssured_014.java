package RestClass_Feb24;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssured_014
{
    //PUT
    String token;
    Integer bookingID;

    public String gettoken()
    {
        token = "123";
        return token;
    }
    @BeforeTest
    public void getTokenandID()
{
    token = gettoken();
    //POST request
    bookingID = 123;

}
@Test
    public void testputreq()
{
    System.out.println(token);
    System.out.println(bookingID);
}


}
