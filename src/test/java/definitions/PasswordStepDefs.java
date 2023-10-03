package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class PasswordStepDefs {
    @Given("I open {string} page vs")
    public void iOpenPageVs(String url) {
        if(url.contains("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.contains("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url: " +url+ " is not supported.");
        }
    }

    @Then("I click button {string} vs")
    public void iClickButtonVs(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName +"')]")).click();
    }

    @Then("I type {string} into password field vs")
    public void iTypeIntoPasswordFieldVs(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click on {string} field vs")
    public void iClickOnFieldVs(String arg0) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).click();
    }

    @Then("the password error message {string} is displayed vs")
    public void thePasswordErrorMessageIsDisplayedVs(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//*[text()='Should be at least 5 characters']")).getText();

    }

    @When("I clear password field vs")
    public void iClearPasswordFieldVs() {
//        getDriver().findElement(By.cssSelector("#mat-error-2"));
        getDriver().findElement(By.id("mat-input-4")).clear();

    }

    @Then("the password error message is not displayed vs")
    public void thePasswordErrorMessageIsNotDisplayedVs() {

    }

    @Then("I type {string} into confirm password field vs")
    public void iTypeIntoConfirmPasswordFieldVs(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

    }

    @Then("the error message {string} is displayed vs")
    public void theErrorMessageIsDisplayedVs(String errorDisplayed) {
       String error = getDriver().findElement(By.xpath("//*[text()='Entered passwords should match']")).getText();




    }

    @Then("I clear confirm password field vs")
    public void iClearConfirmPasswordFieldVs() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).clear();
    }

    @Then("I type {string} into first name field vs")
    public void iTypeIntoFirstNameFieldVs(String first_name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(first_name);
    }

    @Then("I type {string} into last name field vs")
    public void iTypeIntoLastNameFieldVs(String last_name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(last_name);
    }

    @Then("I type {string} into email field vs")
    public void iTypeIntoEmailFieldVs(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into group code field vs")
    public void iTypeIntoGroupCodeFieldVs(String group_code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group_code);
    }


    @Then("I verify that the password is masked vs")
    public void iVerifyThatThePasswordIsMaskedVs() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).getAttribute("type").equals("password")).isTrue();
    }


}

