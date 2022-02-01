package application.step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
//import net.jodah.failsafe.internal.util.Assert;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class MyStepdefs {

    ChromeDriver driver = new ChromeDriver();


    @Given("user navigates to the login page by opening Chrome")
    public void user_is_on_login_page() {
//        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.manage().window().maximize();
        driver.get("https://www.demo.bnz.co.nz/client/");
    }

//Entering correct username and password values

    @When("user clicks on menu")
    public void user_clicks_on_menu() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".Icons--hamburguerMenu")).click();
    }

    @When("user is able to click on payees page")
    public void user_clicks_on_payees_page() {
//        driver.findElement(By.xpath(("//span[@class='js-overview total']"))).isDisplayed();
        driver.findElement(By.linkText("Payees")).click();
    }

    //driver.findElement(By.linkText("Payees")).click();
    @Then("user is able to see payees page")
    public void user_is_able_to_see_payees_page() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//*[@class='Payees js-payees']"))).isDisplayed();
    }
//Open homepage upon login

//    @Then("user gets directed to homepage")
//    public void direct_to_homepage() throws Throwable
//    {
//
//
//    }


    @Given("User clicks Add button")
    public void userClicksAddButton() {

        driver.findElement(By.xpath(("//*[@class='Button Button--sub Button--translucid js-add-payee']"))).isDisplayed();
        driver.findElement(By.xpath(("//*[@class='Button Button--sub Button--translucid js-add-payee']"))).click();

//        driver.findElement(By.linkText("Add")).click();
//        driver.findElement(By.cssSelector(".js-main-menu-payees .Language__container")).click();

    }

    @When("Add payees popup is displayed")
    public void addPayeesPopupIsDisplayed() {
        driver.findElement(By.xpath(("//*[@class='payee u-textSize-sub js-payee-change-image-section image-picker-trigger']"))).isDisplayed();

    }

    @Then("user enters the payee details")
    public void userEntersThePayeeDetails() {
        driver.findElement(By.id("ComboboxInput-apm-name")).click();
        driver.findElement(By.id("ComboboxInput-apm-name")).sendKeys("testName");
        driver.findElement(By.id("ComboboxInput-apm-name")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("apm-bank")).click();
        driver.findElement(By.id("apm-bank")).sendKeys("00");
        driver.findElement(By.id("apm-branch")).sendKeys("0000");
        driver.findElement(By.id("apm-account")).sendKeys("0000000");
        driver.findElement(By.id("apm-suffix")).sendKeys("000");
        driver.findElement(By.id("apm-this-particulars")).click();
        driver.findElement(By.id("apm-this-particulars")).sendKeys("test");
        driver.findElement(By.id("apm-this-code")).sendKeys("test");
        driver.findElement(By.id("apm-this-reference")).sendKeys("test");
        driver.findElement(By.id("apm-that-particulars")).click();
        driver.findElement(By.id("apm-that-particulars")).sendKeys("test");
        driver.findElement(By.id("apm-that-reference")).click();
        driver.findElement(By.id("apm-that-reference")).sendKeys("test");
        driver.findElement(By.id("apm-that-code")).click();
        driver.findElement(By.id("apm-that-code")).sendKeys("test");


    }

    @And("user clicks on add button")
    public void userClicksOnAddButton() {
        driver.findElement(By.xpath(("//*[@class='js-submit Button Button--primary']"))).click();

    }

    @Then("payee added message is displayed")
    public void payeeAddedMessageIsDisplayed() {
        WebDriverWait waitUntilPresent = new WebDriverWait(driver, 3);
        waitUntilPresent.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message']"))));
        driver.findElement(By.xpath("//*[contains(text(),'Payee added')]")).click();


    }

    @And("payee is added in the list of payees")
    public void payeeIsAddedInTheListOfPayees() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//*[contains(text(),'testName')]"))).isDisplayed();

    }

    @Then("user does not enter the payee details")
    public void userDoesNotEnterThePayeeDetails() {
        // Null step to make it understandable
    }

    @And("user clicks on disabled add button")
    public void userClicksOnDisabledAddButton() {

        driver.findElement(By.xpath(("//*[@class='js-submit Button Button--primary Button--disabled']"))).click();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //js-submit Button Button--primary Button--disabled
        driver.findElement(By.xpath(("//*[@class='js-submit Button Button--primary Button--disabled']"))).isDisplayed();
        driver.findElement(By.xpath(("//*[contains(text(),'A problem was found. Please correct the field highlighted below.')]"))).isDisplayed();
    }

    @Then("an error message is not displayed")
    public void anErrorMessageIsNotDisplayed() {
        Boolean isPresent = driver.findElements(By.xpath(("//*[contains(text(),'A problem was found. Please correct the field highlighted below.')]"))).size() > 0;
    }

    @Then("user is able to click on payments page")
    public void userIsAbleToClickOnPaymentsPage() {

//        driver.findElement(By.linkText("Pay or transfer")).click();
        driver.findElement(By.cssSelector(".js-main-menu-paytransfer .Language__container")).click();
    }


    @And("user is able to see payments popup")
    public void userIsAbleToSeePaymentsPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//*[@data-testid='PaymentModal']"))).isDisplayed();
    }


    @Then("user click on from account")
    public void userClickOnFromAccount() {
        driver.findElement(By.xpath(("//*[@data-testid='from-account-chooser']"))).click();
    }

    @And("user selects everyday account")
    public void userSelectsEverydayAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Everyday')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//        driver.findElement(By.cssSelector(("body > div.ReactModalPortal > div > div > div.chooserContainer-1-1-22 > div > div > ul > li:nth-child(2) > button > div > div > div.content-1-1-64 > p.name-1-1-65"))).click();
    }

    @Then("user clicks on account")
    public void userClicksOnAccount() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//*[@data-testid='to-account-chooser']"))).click();

    }

    @Then("user click on to account")
    public void userClickOnToAccount() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//          driver.findElement(By.xpath(("//div//div//div//ul//li[@data-testid='to-account-accounts-tab']"))).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//ul//li[@data-testid='to-account-accounts-tab']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    @And("user clicks on bills account")
    public void userClicksOnBillsAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Bills')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//        driver.findElement(By.xpath(("//p[contains(text(),'Bills')]"))).click();
        //("//p[contains(text(),'Bills')]")
    }

    @Then("user inputs five hundred into the input box")
    public void userInputsFiveHundredIntoTheInputBox() {
        driver.findElement(By.xpath("//*[@data-monitoring-label='Transfer Form Amount']")).sendKeys("500");
        // ("//*[@data-monitoring-label='Transfer Form Amount']")
    }

    @And("user clicks on transfer")
    public void userClicksOnTransfer() {

        driver.findElement(By.xpath(("//*[@data-monitoring-label='Transfer Form Submit']"))).click();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//*[@class='js-overview total']"))).isDisplayed();
        //("//*[@class='js-overview total']")
    }

    @And("the amount in every day is two thousand")
    public void theAmountInEveryDayIsTwoThousand() {

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'2,000.00')]"));
        Assert.assertTrue("2,000.00", list.size() > 0);

    }

    @And("the amount in bills is nine twenty")
    public void theAmountInBillsIsNineTwenty() {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'920.00')]"));
        Assert.assertTrue("920.00", list.size() > 0);
    }

    @Then("transfer successful message is displayed")
    public void transferSuccessfulMessageIsDisplayed() {
        WebDriverWait waitUntilPresent = new WebDriverWait(driver, 3);
        waitUntilPresent.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message']"))));
        driver.findElement(By.xpath("//*[contains(text(),'Transfer successful')]")).click();
    }


    @Then("payees are sorted in ascending order by default")
    public void payeesAreSortedInAscendingOrderByDefault() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.xpath("//*[contains(@class,'List List--border')]"));
        for(WebElement elList:elementList){
            obtainedList.add(elList.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
        }




    @And("user clicks on Name header")
    public void userClicksOnNameHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[contains(@aria-label, 'Sort by payee name A to Z selected. Select again to reverse order.')]"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    @Then("payees are sorted in descending order")
    public void payeesAreSortedInDescendingOrder() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.xpath("//*[contains(@class,'List List--border')]"));
        for(WebElement elList:elementList){
            obtainedList.add(elList.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
    }

    @After()
    public void closeBrowser()
    {
        driver.quit();
    }



}
