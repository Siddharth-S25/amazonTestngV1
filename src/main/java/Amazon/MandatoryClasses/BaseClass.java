package Amazon.MandatoryClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass
        {
        public WebDriver driver;
        public Logger logger;
        public void Browser_Confiuration() throws InterruptedException
        {

          logger = LogManager.getLogger(this.getClass());

        System.setProperty("webdriver.chrome.driver", "G:\\Automation\\Driver\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(1000);


        }
}
