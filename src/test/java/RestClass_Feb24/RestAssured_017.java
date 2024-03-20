package RestClass_Feb24;

import org.testng.annotations.Test;

public class RestAssured_017
{
    //learn priority anotation
    @Test(priority = 1)
    public void t1()
    {
        System.out.println("Result 1");
    }
    @Test(priority = 3)
    public void t2()
    {
        System.out.println("Result 2");
    }
    @Test(priority = -2)
    public void t3()
    {
        System.out.println("Result 3");
    }
}
