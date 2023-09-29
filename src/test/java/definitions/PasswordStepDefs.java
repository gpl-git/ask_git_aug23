package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;



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
    public void iClickButtonVs(String arg0) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
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
        String actualError = getDriver().findElement(By.id("mat-error-0")).getText();

    }

    @When("I clear password field vs")
    public void iClearPasswordFieldVs() {
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
    public void theErrorMessageIsDisplayedVs(String args0) {



    }

    @Then("I clear confirm password field vs")
    public void iClearConfirmPasswordFieldVs() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).clear();
    }
}
