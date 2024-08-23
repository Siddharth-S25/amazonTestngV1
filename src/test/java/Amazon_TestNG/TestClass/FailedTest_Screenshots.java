package Amazon_TestNG.TestClass;

import Amazon.MandatoryClasses.BaseClass;
import Amazon.MandatoryClasses.UtilityClass;
import Amazon_TestNG.Pom.AMZ_HOME_TestNG_BaseClass_UtilityClass;
import Amazon_TestNG.Pom.AMZ_Login_TestNG_BaseClass_UtilityClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;

public class FailedTest_Screenshots extends BaseClass

{
    XSSFSheet sheet;
    AMZ_HOME_TestNG_BaseClass_UtilityClass AMZHTBU;
    AMZ_Login_TestNG_BaseClass_UtilityClass AMZLTBU;

    @BeforeClass
    public void Browser_Application_Configuration() throws InterruptedException, IOException {
        Browser_Confiuration();

        AMZHTBU= new AMZ_HOME_TestNG_BaseClass_UtilityClass(driver);

        AMZLTBU =new AMZ_Login_TestNG_BaseClass_UtilityClass(driver);

    }

    @BeforeMethod
    public void Login() throws InterruptedException, IOException {

// Home Page
        AMZHTBU = new AMZ_HOME_TestNG_BaseClass_UtilityClass(driver);
        AMZHTBU.Click_on_Login();
        Thread.sleep(2000);


//Login page
        AMZLTBU.Enter_Mobile(UtilityClass.fetchdata(2,0));
        Thread.sleep(1000);
        AMZLTBU.Click_Submit();

        Thread.sleep(1000);
        AMZLTBU.Enter_Pass(UtilityClass.fetchdata(2,1));


        AMZLTBU.Clik_Lgn();
        Thread.sleep(1000);


    }

    @Test
    public void UserValidation() throws InterruptedException, IOException {
        Thread.sleep(1000);
        AMZHTBU.User_Verify(UtilityClass.fetchdata(2,0));

        Thread.sleep(2000);

    }

    @AfterMethod
    public void Log_out(ITestResult result) throws InterruptedException, IOException {

        //pass:SUCCESS fail: FAILURE  status

        if(result.getStatus()==ITestResult.FAILURE)
        {
            UtilityClass.screenShot(driver,result.getName());
        }

        Thread.sleep(1000);
        AMZHTBU.Click_on_Logout(driver);
        Thread.sleep(1000);
    }

    @AfterClass
    public void CloseApplication() throws InterruptedException {

        Thread.sleep(1000);

        driver.close();
    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Closing Browser", true);

    }


}
