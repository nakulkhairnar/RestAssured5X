package RestClass_Feb24;

import org.testng.annotations.Test;

public class RestAssured_024
{
    @Test(groups = {"reg"}, priority = 2)
    public void demo1()
    {
        System.out.println("Server started OK");
    }
    @Test(priority = 3)
    public void demo2()
    {
        System.out.println("initial environment will run");
    }
    @Test()//no priority test case will execute first
    public void demo3()
    {
        System.out.println("Method 1 will run");
    }

}
