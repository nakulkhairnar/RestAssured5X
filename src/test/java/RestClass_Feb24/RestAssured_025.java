package RestClass_Feb24;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssured_025
{
    //Data drivenTesting
    //Test with multiple inputs
    //login test --> 100 of users
    //Registration -- DDT
    //Data provider - Test Data?
    @DataProvider
    public Object[][] getdata()
    {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password123"},
        };
    }
    @Test(dataProvider = "getdata")
    public void loginTest(String username, String password)
    {
        System.out.println(username);
        System.out.println(password);
    }
}
