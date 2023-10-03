package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationEmailStepDefs {
    @Given("I go to {string} page IB")
    public void iGoToPageIB(String url) {
        switch (url) {
            case "Login":
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            case "Registration":
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            default:
                System.out.println("This url: " + url + " is not supported.");
        }
    }

    @When("I type {string} in first name field")
    public void iTypeInFirstNameField(String fName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(fName);
    }

    @And("I type {string} in last name field")
    public void iTypeInLastNameField(String lName) {
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(lName);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
    }

    @And("enter group code {string}")
    public void enterGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(groupCode);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String pswd) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pswd);
    }

    @And("I retype password in Confirm password {string}")
    public void iRetypePasswordInConfirmPassword(String confirmPswd) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmPswd);
    }

    @When("I press {string} button")
    public void iPressButton(String btn) {
        getDriver().findElement(By.xpath("//span[text()='" + btn + "']")).click();
    }

    @Then("I get pop-up message {string}")
    public void iGetPopUpMessage(String popUp) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'" + popUp + "')]")).isDisplayed()).isTrue();
    }

    @Then("I get error message {string}")
    public void iGetErrorMessage(String errorMsg) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[text()='" + errorMsg + "']")).isDisplayed()).isTrue();
    }

    @Then("I get alert {string}")
    public void iGetAlert(String alert) {
        String error = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();
        assertThat(error.contains(alert)).isTrue();
    }
}




