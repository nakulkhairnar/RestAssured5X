package RestClass_Feb24;

import org.testng.annotations.Test;

public class RestAssured_022
{
    @Test(groups = {"init"}, priority = 2)
    public void serverstarts()
    {
        System.out.println("Server started OK");
    }
    @Test(groups = {"init"}, priority = 1)
    public void intienvironment()
    {
        System.out.println("initial environment will run");
    }
    @Test(dependsOnMethods = {"init.*"})
    public void method1()
    {
        System.out.println("Method 1 will run");
    }

}
