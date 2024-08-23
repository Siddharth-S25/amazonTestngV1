package Amazon_TestNG.Pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMZ_Login_TestNG_BaseClass_UtilityClass {
//Step1:Data member should be declared globaly with access level private using @findBy Annotation

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement mobile;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submit;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement Login_Button;

//Step2:. Initialize within a constructor with access level public using pagefactory class

    public AMZ_Login_TestNG_BaseClass_UtilityClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//Step3:Utilize within a method with access level public

    public void Enter_Mobile(String mob) {
        mobile.sendKeys(mob);
    }

    public void Click_Submit() {
        submit.click();
    }

    public void Enter_Pass(String pass) {
        password.sendKeys(pass);
    }

    public void Clik_Lgn() {
        Login_Button.click();
    }


}
