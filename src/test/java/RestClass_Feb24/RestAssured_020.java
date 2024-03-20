package RestClass_Feb24;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_020
{
    @Test
    void testcase01()
    {
        Assert.assertEquals(true, true, "passes");
        System.out.println("This will  print");
    }
    @Test
    void testcase02()
    {
        Assert.assertEquals(true, false, "failed");
        System.out.println("This will not print");
    }
}
