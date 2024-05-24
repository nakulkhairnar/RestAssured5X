package RestClass_Feb25;

import org.testng.annotations.Test;

public class RestAssured_027
{
    //will see data drivan test
    //Parallel executions
    //framework
    //1 Modular
    //2 keyword/robot driven framework
    //3 Data Driven and
    //4 Test Driven framework
    //5 hybrid framework
    //6 Behaviour data driven framework
//test cases login where will inject the username and password
    //excel - there is not support directly in java to read the excel file
    //Apache POI library-  
    //Excel format- xls, xlsx, csv, etc
@Test(dataProvider = "getData", dataProviderClass = RestAssured_028.class)
    public void testLogin(String username, String password)
{
    System.out.println(username);
    System.out.println(password);
}







}
