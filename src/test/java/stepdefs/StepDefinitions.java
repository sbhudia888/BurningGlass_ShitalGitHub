package stepdefs;

import config.Base;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AboutPage;
import pages.HomePage;
import pages.SolutionsPage;

import java.util.List;

public class StepDefinitions extends Base {

    private HomePage homePage = new HomePage();
    private SolutionsPage solutionsPage = new SolutionsPage();
    private AboutPage aboutPage = new AboutPage();


    @Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String arg1, String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        homePage.navigateToHomePage(url);
        homePage.verifyTitle("United Kingdom | Burning Glass Technologies");

    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void i_should_see_message(String expectedHeading) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        try {
            String actualHeading = driver.findElement(By.xpath("//h1[@class='et_pb_module_header']")).getText();
            Assert.assertEquals(expectedHeading.trim(), actualHeading.replace("\n", " "));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^I navigate to \"([^\"]*)\" page from top menu bar$")
    public void i_navigate_to_page_from_top_menu_bar(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (arg1.equalsIgnoreCase("Solutions")) {
            WebElement elmAbout = driver.findElement(By.xpath("//a[@class='ubermenu-target ubermenu-item-layout-default ubermenu-item-layout-text_only']"));
            elmAbout.click();
        } else if (arg1.equalsIgnoreCase("About")) {
            WebElement elmAbout = driver.findElement(By.xpath("//a[@class='ubermenu-target ubermenu-item-layout-default ubermenu-item-layout-text_only']"));
            elmAbout.click();

        } else if (arg1.equalsIgnoreCase("Research")) {
            WebElement elmResarch = driver.findElement(By.xpath("//*[@id=\"menu-item-12576\"]/a"));
            waitAndClick(elmResarch, 1000);
        }


    }

    @Then("^I should have landed in \"([^\"]*)\" page$")
    public void i_should_have_landed_in_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        solutionsPage.verifyTitleText("Solutions");

    }

    @Then("^below sections would be listed in \"([^\"]*)\" page$")
    public void below_sections_would_be_listed_in_page(String pageName, DataTable listOfSections) throws Throwable {

        String page = pageName;
        List<String> data = listOfSections.asList(String.class);

        if (page.equalsIgnoreCase("Solutions")) {
            solutionsPage.verifySectionsAvailable(data);
        } else if (page.equalsIgnoreCase("About")) {
            aboutPage.verifySectionsAvailable(data);

        }

    }

}
