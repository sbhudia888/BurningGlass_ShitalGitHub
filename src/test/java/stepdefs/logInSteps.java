package stepdefs;//package stepdefs;
//
//import config.Base;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.testng.Assert;
//import pages.ElLoginPage;
//
//
//public class logInSteps extends Base {
//
//    ElLoginPage elLoginPage = new ElLoginPage();
//
//    @Given("I am on home page")
//    public void iAmOnHomePage() {
//        navigatTo();
//    }
//
//    @And("I log in with test user")
//    public void iLogInWithTestUser() throws InterruptedException {
//        elLoginPage.signInBtn.click();
//        isElementDisplayed(elLoginPage.sigsInButton,5);
//        elLoginPage.input_text(prop.getProperty("user"),prop.getProperty("pass"));
//        elLoginPage.sigsInButton.click();
//        Thread.sleep(5000);
//    }
//
//    @Then("I should be landed on my account page")
//    public void iShouldBeLandedOnMyAccountPage() throws InterruptedException {
//        Thread.sleep(5000);
//        System.out.println("From steps "+driver);
//        Assert.assertEquals(driver.getTitle(), "My Account | Estée Lauder", "User not on my account page");
//    }
//
//    @When("I try to login with invalid user")
//    public void iTryToLoginWithInvalidUser() throws InterruptedException {
//        elLoginPage.signInBtn.click();
//        isElementDisplayed(elLoginPage.sigsInButton,5);
//        elLoginPage.input_text(prop.getProperty("user2"),prop.getProperty("pass2"));
//        elLoginPage.sigsInButton.click();
//        Thread.sleep(5000);
//    }
//
//    @Then("I should not be logged in")
//    public void iShouldNotBeLoggedIn() {
//        Assert.assertFalse(driver.getTitle().equals("My Account | Estée Lauder"), "User was successful to log in");
//    }
//
//    @And("I should see an error as {string}")
//    public void iShouldSeeAnErrorAs(String error) {
//        Assert.assertTrue(elLoginPage.error.getText().equals(error), "Expected error was not thrown");
//    }
//}