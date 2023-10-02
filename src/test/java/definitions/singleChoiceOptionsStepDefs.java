package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class singleChoiceOptionsStepDefs {
    @Then("I verify that name {string} and role {string} are displayed in the home page TC")
    public void iVerifyThatNameAndRoleAreDisplayedInTheHomePageTC(String name, String role) {
        String actualName = getDriver().findElement(By.xpath("//div[@class='info']/h3")).getText();
        assertThat(actualName.equals(name)).isTrue();
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        assertThat(actualRole.equals(role)).isTrue();
    }


    @Then("{string} field error message {string} is displayed TC")
    public void fieldErrorMessageIsDisplayedTC(String option, String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../..//*[contains(text(), '" + expectedError + "')]")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @Then("error message {string} is displayed TC")
    public void errorMessageIsDisplayedTC(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//div[contains(text(),'*Choose correct answer')]")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @And("I type 1000 characters into {string} field of {string} TC")
    public void iType1000CharactersIntoFieldOfTC(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    }

    @And("I type 1 character into {string} field of {string} TC")
    public void iType1CharacterIntoFieldOfTC(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys("T");
    }

    @And("I type 1001 characters into {string} field of {string} TC")
    public void iType1001CharactersIntoFieldOfTC(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys("123%$#TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTt");
    }

    @And("{string} field error message is displayed TC")
    public void fieldErrorMessageIsDisplayedTC(String option) {
        assertThat(getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../..//mat-error[@role='alert']")).isDisplayed()).isTrue();
    }


    @When("I add 13 options to {string} TC")
    public void iAdd13OptionsToTC(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();

    }

    @When("I add 14 options to {string} TC")
    public void iAdd14OptionsToTC(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
    }

    @When("I add option to {string} TC")
    public void iAddOptionToTC(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Add Option')]")).click();
    }

    @And("I click gear icon next to {string} field of {string} TC")
    public void iClickGearIconNextToFieldOfTC(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//textarea[contains(@placeholder, '" + optionNum + "')]/../../../../..//mat-icon[contains(text(), 'settings')]")).click();
    }

    @And("I select {string} menu item TC")
    public void iSelectMenuItemTC(String menuItem) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + menuItem + "')]")).click();
    }

    @Then("text {string} is displayed in {string} field TC")
    public void textIsDisplayedInFieldTC(String  expectedText, String optionNum) {
        String actualText = getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + optionNum + "')]")).getText();
        assertThat(actualText.equals(expectedText)).isTrue();
    }

    @Then("{string} field is not displayed TC")
    public void fieldIsNotDisplayedTC(String optionNum) {
        assertThat(getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + optionNum + "')]")).isDisplayed()).isFalse();
    }
}
