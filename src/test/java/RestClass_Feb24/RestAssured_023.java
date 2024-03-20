package RestClass_Feb24;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RestAssured_023
{
    @Parameters("browser")
    @Test(priority = 1)
    void demo1(String value)
    {
        System.out.println("Browser is " +value);
        //open the browser and select the database

    }
}
