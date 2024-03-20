package RestClass_Feb24;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssured_015
{
    @BeforeTest
    public void t1()
    {
        System.out.println("1");
    }
    @BeforeTest
    public void t2()
    {
        System.out.println("2");
    }
    @Test
    public void t3()
    {
        //token and booking id
        System.out.println("This is not advisable approach");
    }


}
