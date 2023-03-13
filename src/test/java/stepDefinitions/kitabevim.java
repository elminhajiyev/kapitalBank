package stepDefinitions;

import Elements.homePage;
import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;


public class kitabevim {
    static final Logger logger = LogManager.getLogger(kitabevim.class.getName());
    protected WebDriver wd = Driver.getDriver();
    homePage hp = new homePage(wd);
    @Given("Go to {string}")
    public void gotToSite(String url){
        wd.get(url);
        DOMConfigurator.configure("log4j.xml");
        logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
        logger.info("TEST Has Started");

    }

    @When("Check homepage is open")
    public void checkHomepageIsOpen() {
        if(wd.getTitle() != null && wd.getTitle().contains("Kitabevim.az")){
            logger.info("Web page is opened");
        }
        else{
            System.exit(0);
        }

    }

    @Then("Read data from csv file")
    public void readDataFromCsvFile() throws FileNotFoundException {
        String data =  hp.readCsv();
        logger.info("CSV Readed!");
    }

    @Then("Fill search field with csv data")
    public void fillSearchFieldWithCsvData() throws FileNotFoundException {
        String data =  hp.readCsv();
        logger.info("CSV Readed!");
    }
    @Then("Insert Roman to search field")
    public void the_user_clicks_on_the_Colombia_option() throws FileNotFoundException {
        hp.searchInField(wd, hp.readCsv());
        logger.info("Roman searched!");
    }


    @And("Get value from basket count")
    public void getValueFromBasketCount() throws FileNotFoundException {
        hp.count();
        logger.info("Basket Count readed");
    }

    @And("Select random result")
    public void selectRandomResult() throws InterruptedException {
        hp.selectRandom(wd);
        logger.info("Random book is selected");
    }

    @And("Add to basket")
    public void addToBasket() {
        hp.addToBasket();
        logger.info("The book added to basket");
    }

    @And("Check basket value again")
    public void checkBasketValueAgain() {
        hp.checkAgain();
        logger.info("Basket Count checked again");
    }

    @And("The basket icon is hovered on")
    public void theBasketIconIsHoveredOn() {
        hp.setGotoBasket(wd);
        logger.info("Hovering to basket icon");
    }

    @And("Goto Basket")
    public void gotoBasket() {
        hp.goto_basket_icon();
        logger.info("Going to basket");
    }

    @And("The amount of the product is increased by {string}")
    public void theAmountOfTheProductIsIncreasedBy(String arg0) {
        hp.increase_1();
        logger.info("Increasing book amount");
    }

    @And("Click the refresh basket button")
    public void clickTheRefreshBasketButton() {
        hp.refresh_basket();
        logger.info("Refreshing the basket");
    }

    @And("It is checked whether the message is displayed")
    public void itIsCheckedWhetherTheMessageIsDisplayed() {
        hp.basket_refreshed();
        logger.info("Checking basket refresh");
    }

    @And("Clear Basket")
    public void clearBasket() {
        hp.clear_basket();
        logger.info("Removing elements from basket");
    }

    @Then("Verify basket is empty")
    public void verifyBasketIsEmpty() {
        hp.checkBasket();
        logger.info("Checking basket is empty!");
    }
    @After
    public void afterScenario() {
        wd.close();
    }
}
