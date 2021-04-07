package pages;

import config.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SolutionsPage extends Base {

    JavascriptExecutor js = ((JavascriptExecutor) driver);

//    @FindBy(css = ".utility-nav__cart-icon")
//    public WebElement cartIcon;

    @FindBy(xpath = "//h2[text()='Corporations']")
    public WebElement Solutions_Corporations;

    @FindBy(xpath = "//h2[text()='Education']")
    public WebElement Solutions_Education;


    public SolutionsPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyTitleText(String expectedTitleText) {

        WebElement elm = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(elm.getText(), expectedTitleText);
    }

    public void verifySectionsAvailable(List<String> data) {

        for (int x = 0; x <= data.size(); x++) {

            String sectionName = data.get(x);
            String sectionXPath = "//h2[text()='" + sectionName + "']";

            System.out.println("Verifying for exist " + sectionName);

//            WebElement elm = driver.findElement((By.xpath(sectionXPath));

            // explicit wait condition
            WebDriverWait w = new WebDriverWait(driver, 3);
            // presenceOfElementLocated condition
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sectionXPath)));


        }


    }

}
