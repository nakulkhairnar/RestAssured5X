package RestClass_Feb24;

import org.testng.annotations.Test;

public class RestAssured_021
{
    @Test
    public void serverStarts()
    {
        System.out.println("I will run first");
    }
    @Test(dependsOnMethods ="serverStarts")
    public void method1() {
        System.out.println("Method 1");
    }


}


