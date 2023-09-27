package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MyStepDefs{
    @Given("I go to {string}")
    public void url(String arg0) {
        getDriver().get("https://skryabin.com/webdriver/html/sample.html");
    }
    @Then("I should see page title")
    public void iShouldSeePageTitleAs() {
        assertThat(getDriver().getTitle()).isEqualTo("Sample Page");
    }
    @Then("I wait")
    public void iWaitFor() throws Exception {
        Thread.sleep(2000);
    }

    @When("I resize window as desktop")
    public void AsDesktop() {
        getDriver().manage().window().setSize(new Dimension(1680,1050));
    }
    @When("I resize window to as tablet")
    public void AsTablet() {
        getDriver().manage().window().setSize(new Dimension(1024,768));
    }
    @When("I resize window to as phone")
    public void AsPhone() {
        getDriver().manage().window().setSize(new Dimension(375,667));
    }

    @Then("date should be displayed")
    public void dateShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.id("currentDate")).isDisplayed()).isTrue();
    }

    @Then("date should not be displayed")
    public void dateShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.id("currentDate")).isDisplayed()).isFalse();
    }

    @When("I type {string} into username")
    public void iTypeIntoUsername(String text)  {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(text);
    }

    @And("I click on email")
    public void iClickOnEmail() {
        getDriver().findElement(By.name("email")).click();
    }

    @Then("Username error should be displayed")
    public void elementWithXpathUsernameErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='username-error']")).isDisplayed()).isTrue();
    }

    @Then("Username error should contain text {string}")
    public void usernameErrorShouldContainText(String text) {
        assertThat(getDriver().findElement(By.id("username-error")).getText().contains(text));
    }

    @When("I clear username element")
    public void iClearUsernameElement() {
        getDriver().findElement(By.xpath("//input[@name='username']")).clear();
    }

    @Then("Username error should not be displayed")
    public void usernameErrorShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.id("username-error")).isDisplayed()).isFalse();
    }

    @When("I type {string} into Email")
    public void iTypeIntoEmail(String text) {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(text);
    }

    @And("I click on Username")
    public void iClickOnUsername() {
        getDriver().findElement(By.xpath("//input[@name='username']")).click();
    }

    @Then("Email error should be displayed")
    public void emailErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isTrue();
    }

    @Then("Email error should contain text {string}")
    public void emailErrorShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getText().contains(text));
    }

    @When("I clear Email")
    public void iClearEmail() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
    }


    @Then("Email error should not be displayed")
    public void emailErrorShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isFalse();
    }

    @When("I type {string} into password")
    public void iTypeIntoPassword(String text) {
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(text);
    }

    @And("I click on confirm password")
    public void iClickOnConfirmPassword() {
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).click();
    }

    @When("I type {string} into confirm password")
    public void iTypeIntoConfirmPassword(String text) {
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(text);
    }

    @Then("Password error should be displayed")
    public void passwordErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='password-error']")).isDisplayed()).isTrue();
    }

    @Then("Password error should contain text {string}")
    public void passwordErrorShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//label[@id='password-error']")).getText().contains(text));
    }

    @Then("Confirm password error should be displayed")
    public void confirmPasswordErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='confirmPassword-error']")).isDisplayed()).isTrue();
    }

    @Then("Confirm password error should contain text {string}")
    public void confirmPasswordErrorShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//label[@id='confirmPassword-error']")).getText().contains(text));
    }

    @When("I clear confirm password field")
    public void iClearConfirmPasswordField() {
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).clear();
    }

    @When("I clear password field")
    public void iClearPasswordField() {
        getDriver().findElement(By.xpath("//input[@name='password']")).clear();
    }

    @Then("Password error should not be displayed")
    public void passwordErrorShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='password-error']")).isDisplayed()).isFalse();
    }

    @Then("Confirm password error should not be displayed")
    public void confirmPasswordErrorShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='confirmPassword-error']")).isDisplayed()).isFalse();
    }

    @And("I click on Name input field")
    public void iClickOnNameInputField() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
    }

    @Then("Name input fields should be displayed")
    public void nameInputFieldsShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'ui-dialog')]")).isDisplayed()).isTrue();
    }

    @When("I type {string} into first name")
    public void iTypeIntoFirstName(String text) {
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(text);
    }

    @When("I type {string} into middle name")
    public void iTypeIntoMiddleName(String text) {
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys(text);
    }

    @When("I type {string} into last name")
    public void iTypeIntoLastName(String text) {
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(text);
    }

    @Then("I click on confirmation")
    public void iClickOnCofirmation() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("Name should have attribute {string} as {string}")
    public void nameShouldHaveAttributeAs(String attribute, String value) {
        assertThat(getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute(attribute)).isEqualTo(value);
    }

    @Then("I click on form submit")
    public void iClickOnFormSubmit() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("Privacy policy error should be displayed")
    public void privacyPolicyErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//label[@id='agreedToPrivacyPolicy-error']")).isDisplayed()).isTrue();
    }

    @Then("Privacy policy error should contain text {string}")
    public void privacyPolicyErrorShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//label[@id='agreedToPrivacyPolicy-error']")).getText().contains(text));
    }

    @Then("I check on privacy policy")
    public void iCheckOnPrivacyPolicy() {
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @Then("element Privacy policy confirmation should be displayed on confirmation page")
    public void elementPrivacyPolicyConfirmationShouldBeDisplayedOnConfirmationPage() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).isDisplayed()).isTrue();
    }

    @Then("element Privacy policy confirmation should contain text {string}")
    public void elementPrivacyPolicyConfirmationShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText().contains(text));
    }

    @When("I type {string} into number input field")
    public void iTypeIntoNumberInputField(String text) {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(text);
    }

    @Then("element first name should contain text {string}")
    public void elementFirstNameShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText().contains(text));
    }

    @Then("element middle name should contain text {string}")
    public void elementMiddleNameShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='middleName']")).getText().contains(text));
    }

    @Then("element last name should contain text {string}")
    public void elementLastNameShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText().contains(text));
    }

    @Then("element full name should contain text {string}")
    public void elementFullNameShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText().contains(text));
    }

    @Then("element username should contain text {string}")
    public void elementUsernameShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText().contains(text));
    }

    @Then("element password should contain text {string}")
    public void elementPasswordShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText().contains(text));
    }

    @Then("element email should contain text {string}")
    public void elementEmailShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText().contains(text));
    }

    @Then("I click on country in selector")
    public void iClickOnCountryInSelector() {
        getDriver().findElement(By.xpath("//*[@value='Japan']")).click();
    }

    @Then("I click on male radio button")
    public void iClickOnMaleRadioButton() {
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
    }

    @Then("I click on contact permission")
    public void iClickOnContactPermission() {
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
    }

    @When("I type {string} into address input field")
    public void iTypeIntoAdressInputField(String text) {
        getDriver().findElement(By.xpath("//textarea[@name='address']")).sendKeys(text);
    }

    @Then("I click on car make in selector")
    public void iClickOnCarMakeInSelector() {
        getDriver().findElement(By.xpath("//*[@value='Toyota']")).click();
    }

    @Then("I click on third party confirmation")
    public void iClickOnThirdPartyConfirmation() {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
    }

    @When("I accept pop-up")
    public void iAcceptPopUp() {
        getDriver().switchTo().alert().accept();
    }

    @When("I type {string} into DoB field")
    public void iTypeIntoDoBField(String text) {
        getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys(text);
    }

    @Then("element phone number should contain text {string}")
    public void elementPhoneNumberShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText().contains(text));
    }

    @Then("element country should contain text {string}")
    public void elementCountryShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText().contains(text));
    }

    @Then("element address should contain text {string}")
    public void elementAddressShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='address']")).getText().contains(text));
    }

    @Then("element DoB should contain text {string}")
    public void elementDoBShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText().contains(text));
    }

    @Then("element car make should contain text {string}")
    public void elementCarMakeShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText().contains(text));
    }

    @Then("element allowed to contact should contain text {string}")
    public void elementAllowedToContactShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText().contains(text));
    }

    @Then("element gender should contain text {string}")
    public void elementGenderShouldContainText(String text) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='gender']")).getText().contains(text));
    }
}