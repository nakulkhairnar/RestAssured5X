package RestClass_Feb24;

import org.testng.annotations.*;

public class RestAssured_012
{
    @BeforeSuite
    void demo()
    {
        System.out.println("Before suite");
    }
    @BeforeTest
    void test()
    {
        System.out.println("Before test");
    }

    @BeforeClass
    void demoo()
    {
        System.out.println("Before demoo");
    }
//why we run before method --> to read the excel file text, JSON, CSV Database
    @BeforeMethod
    void demo01()
    {
        System.out.println("BeforeMethod");
    }
    @Test
    void demo02()
    {
        System.out.println("Test");
    }
//now 2 times before and after method will run
    @Test
    void demo022()
    {
        System.out.println("Test 22");
    }
    //close the files: here write the code
    @AfterMethod
    void demo03()
    {
        System.out.println("AfterMethod");
    }
    @AfterClass
    void test01()
    {
        System.out.println("After class");
    }
    @AfterTest
    void test02()
    {
        System.out.println("After test");
    }
    @AfterSuite
    void test03()
    {
        System.out.println("After suite");
    }

}
