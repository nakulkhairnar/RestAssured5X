package RestClass_Feb24;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_011
{
    @Test
    public void testCase01()
    {
        Assert.assertEquals(true , true);

    }
    @Test
    public void testCase02()
    {
        Assert.assertEquals(false, true);

    }

}
