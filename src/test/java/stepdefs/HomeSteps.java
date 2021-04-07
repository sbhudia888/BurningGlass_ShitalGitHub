package stepdefs;//package stepdefs;
//
//
//import config.Base;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import org.testng.Assert;
//import pages.ElLoginPage;
//import pages.HomePage;
//
//
//public class HomeSteps extends Base {
//
//    HomePage homePage = new HomePage();
//    ElLoginPage elLoginPage =new ElLoginPage();
//
//    @And("I view my cart")
//    public void iViewMyCart() {
//        homePage.cartIcon.click();
//        isElementDisplayed(homePage.cartHeader,5);
//        Assert.assertTrue(homePage.cartHeader.getText().contains("My Bag"),"cart did not displayed");
//    }
//
//    @And("I should see an empty cart")
//    public void iShouldSeeAnEmptyCart() {
//     Assert.assertEquals(homePage.itemCount.getText(),"0","Item did not mached");
//    }
//
//    @Then("I sign out")
//    public void iSignOut() {
//        homePage.sigsOut.click();
//        isElementDisplayed(elLoginPage.signInBtn,5);
//    }
//
//    @And("I search for {string}")
//    public void iSearchFor(String item) {
//        homePage.search.click();
//        isElementDisplayed(homePage.searchBar,5);
//        homePage.searchBar.sendKeys(item);
//        homePage.searchLink.click();
//        Assert.assertTrue(homePage.products.size()>0,"No product found");
//    }
//
//
//    @And("I add the product to my cart")
//    public void iAddTheProductToMyCart() throws InterruptedException {
//        homePage.products.get(0).click();
//        isElementDisplayed(homePage.addToBag,5);
//        waitAndClick(homePage.addToBag,10);
//        Thread.sleep(10000);
//        Assert.assertEquals(homePage.itemCount.getText(),"1","Item was not added");
//    }
//
//
//    @Then("I verify {string} was added to my cart")
//    public void iVerifyWasAddedToMyCart(String product) {
//        waitAndClick(homePage.cartIcon,10);
//        isElementDisplayed(homePage.cartHeader,5);
//        Assert.assertTrue(homePage.itemInBag.getText().contains("Tuberose Le Jour"), "Item was not in the cart");
//    }
//
//    @And("I remove the item from my cart")
//    public void iRemoveTheItemFromMyCart() throws InterruptedException {
//        waitAndClick(homePage.removeItem,10);
//        Thread.sleep(10000);
//        Assert.assertTrue(homePage.itemCount.getText().equals( "0"), "Item was not removed");
//    }
//}