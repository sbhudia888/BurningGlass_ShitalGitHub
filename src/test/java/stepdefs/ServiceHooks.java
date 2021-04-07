package stepdefs;

import config.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ServiceHooks extends Base {
    @Before
    public static WebDriver initialization() {
        // Code to setup initial configurations

//        String browserName = prop.getProperty("browser"); //as of now only Chrome, in future implement for other browsers
//        String url = prop.getProperty("url");


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("From setup " + driver);


        return driver;
    }

    @After
    public static void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshotBytes, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        System.out.println("From quit " + driver);
        driver.quit();
    }


}
