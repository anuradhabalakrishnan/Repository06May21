package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends BrowserDriver {

    @Given("^I'm on home page \"([^\"]*)\"$")
    public void i_m_on_home_page(String url) throws Throwable {
        driver.get(url);

    }

    @When("^I click on My Account link$")
    public void i_click_on_My_Account_link() throws Throwable {
        driver.findElement(By.linkText("My Account")).click();
            }

    @When("^I enter the username \"([^\"]*)\"$")
    public void i_enter_the_username(String username) throws Throwable {
        driver.findElement(By.id("EmailOrAccountNumber")).sendKeys(username);

    }

    @When("^I enter the password \"([^\"]*)\"$")
    public void i_enter_the_password(String password) throws Throwable {
        driver.findElement(By.id("Password")).sendKeys(password);

    }

    @When("^I click the login Button$")
    public void i_click_the_login_Button() throws Throwable {
        driver.findElement(By.id("SignInNow")).click();
    }

    @Then("^I should successfully and redirected to Account Page$")
    public void i_should_successfully_and_redirected_to_Account_Page() throws Throwable {
        WebElement accountUniqueElement = driver.findElement(By.xpath("//div/h1[@class='boxclassic']"));
        Assert.assertTrue(accountUniqueElement.isDisplayed());
    }

    @Then("^I should not be able to login$")
    public void i_should_not_be_able_to_login() throws Throwable {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        String actualFailedLoginTex=driver.findElement(By.xpath("//*[@id=\"pri\"]/div/div/div/div/div/span")).getText();
        String expectedFailedLoginText="Sorry, we have been unable to sign you in.";
        Assert.assertEquals(expectedFailedLoginText,actualFailedLoginTex);

    }


}
