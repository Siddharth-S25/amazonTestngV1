package Amazon_TestNG.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AMZ_HOME_TestNG_BaseClass_UtilityClass {

    //Step1:Data member should be declared globaly with access level private using @findBy Annotation
    @FindBy(xpath = "//a[@id=\"nav-link-accountList\"]")
    private WebElement LoginLink;

    @FindBy(xpath = "//span[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement Username;

    @FindBy(xpath = "//a[@id=\"nav-item-signout\"]")
    private WebElement Logout;
//------------------------------------------------------------------------------------------------
    //Step2:. Initialize within a constructor with access level public using pagefactory class

    public AMZ_HOME_TestNG_BaseClass_UtilityClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //--------------------------------------------------------------------------------------------

//Step3:Utilize within a method with access level public

    public void Click_on_Login() {
        LoginLink.click();
    }

    public void User_Verify(String expected)
    {
        String actualuser=Username.getText();
        Assert.assertEquals(actualuser,expected);


    }

    public void Click_on_Logout(WebDriver driver) {
        Actions act = new Actions(driver);
        act.moveToElement(Username).perform();
        act.click(Logout).build().perform();


    }


}
