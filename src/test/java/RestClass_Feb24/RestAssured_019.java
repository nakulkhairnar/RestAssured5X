package RestClass_Feb24;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RestAssured_019
{
    @Test
    void testCase01()
    {
        //Assertions
        //two types of assertions 1 hard and 2 soft
        // Expected result is - Pramod
        //Actual result is - response is - pramod
        SoftAssert s = new SoftAssert();
        s.assertEquals(true, false, "True should not be equals to false");
        System.out.println("Please execute me");
        s.assertAll();

        //token - not fail no, basic auth ()
        //Hard assertions
        Assert.assertEquals(true, false, "failed");
        System.out.println("This will not print");


    }
}
