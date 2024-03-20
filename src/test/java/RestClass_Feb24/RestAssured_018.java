package RestClass_Feb24;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_018
{
    //Learn grouping
    @Test(groups = {"sanity","QA"})
    public void sanityRun()
    {
        System.out.println("Sanity");
        System.out.println("QA");
    }
    @Test(groups = {"reg", "sanity", "Prod"})
    public void regRun()
    {
        System.out.println("Regression");

    }
    @Test(groups = {"Smoke", "sanity", "Dev"})
    public void smokeRun()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);

    }

}
