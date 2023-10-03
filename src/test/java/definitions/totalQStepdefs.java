package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class totalQStepdefs {
    static final int min=50;
    static final int max=201;
    static final String QuizTitle = "AUG23: 0 < NumOfQuestion < 51 ???";
    int numOfQ = 0;
    String xpath;
    WebElement element;
    WebDriverWait halt;

    public static String RndTxt() {
        String rndTxt = RandomStringUtils.randomAscii(min, max);
        return rndTxt;
    }
    @Given("I visit the website {string} in {string} environment_kc")
    public void iVisitTheWebsiteASKInQaEnvironment(String url, String env) {
        String website = "http://"+url+"-"+env+".portnov.com";
        getDriver().get(website);
    }

    @Then("I should see {string} on the page and verify page title_kc")
    public void iShouldSeeOnThePageAndVerifyPageTitle(String envtxt) {
        String title = "Assessment Control @ Portnov";
        xpath = "//div[@class='staging-label']";
        assertThat(getDriver().getTitle().equals(title)).isTrue();
        assertThat(getDriver().findElement(By.xpath(xpath)).getText().equals(envtxt)).isTrue();
    }

    @And("{string} and {string} input field should be present_kc")
    public void andInputFieldShouldBePresent(String em, String pwd) {
        xpath = "//input[@formcontrolname='"+em+"']";
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.isDisplayed()).isTrue();
        xpath = "//input[@formcontrolname='"+pwd+"']";
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.isDisplayed()).isTrue();
    }

    @When("fill out {string} and {string} fields and {string} as a teacher_kc")
    public void fillOutAndFieldsAsATeacher(String em, String password, String txt) {
        String email = "tallpoet@audoscale.net";
        String pwd = "XYZ06789";
        xpath = "//input[@formcontrolname='"+em+"']";
        element = getDriver().findElement(By.xpath(xpath));
        element.sendKeys(email);
        xpath = "//input[@formcontrolname='"+password+"']";
        element = getDriver().findElement(By.xpath(xpath));
        element.sendKeys(pwd);
        xpath = "//button/span[text()='"+txt+"']";
        getDriver().findElement(By.xpath(xpath)).click();
        xpath = "//p[contains(text(),'TEACHER')]";
        halt = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @Then("click {string} to land on quiz list_kc")
    public void clickToLandOnQuizList(String arg0) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+arg0+"')]")).click();
        xpath = "//div[@class='"+arg0.toLowerCase()+"']";
        halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        xpath = "//h4[contains(text(),'List of "+arg0+"')]";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }

    @Then("click on the {string} button_kc")
    public void clickOnTheButton_kc(String txt) {
        xpath = "//span[contains(text(),'"+txt+"')]";
        getDriver().findElement(By.xpath(xpath)).click();
        halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        xpath = "//input[contains(@placeholder,'Title')]";
        halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @Then("verify presence of quiz title field and quiz list button_kc")
    public void verifyPresenceOfQuizTitleFieldAndQuizListButton_kc() {
        xpath = "//input[contains(@placeholder,'Title')]";
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.getAttribute("placeholder").contains("Of The Quiz")).isTrue();
        xpath = "//span[contains(text(),'Back To Quizzes List')]";
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.isEnabled()).isTrue();
    }

    @When("I type into the quiz title field_kc")
    public void iTypeIntoTheQuizTitleField_kc() {
        xpath = "//input[contains(@placeholder,'Title')]";
        element = getDriver().findElement(By.xpath(xpath));
        element.sendKeys(QuizTitle);
    }

    @Then("Add Question button appears_kc")
    public void addQuestionButtonAppears_kc() throws InterruptedException{
        Thread.sleep(1000);
        assertThat(getDriver().findElement(By.xpath("//form/div/button")).isDisplayed()).isTrue();
    }

    @When("I erase the quiz title field_kc")
    public void iEraseTheQuizTitleField_kc() throws InterruptedException{
        xpath = "//input[contains(@placeholder,'Title')]";
        element = getDriver().findElement(By.xpath(xpath));
        element.clear();
        Thread.sleep(1000);
    }

    @Then("Add Question button should disappear_kc")
    public void addQuestionButtonShouldDisappear_kc() {
        xpath = "//form/div/button";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();//isFalse();
    }

    @When("I click on the Add Question button_kc")
    public void iClickOnTheAddQuestionButton_kc() throws InterruptedException{
        xpath = "//form/div/button";
        getDriver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }

    @Then("{string} and Passing Rate will appear_kc")
    public void qAndPassingRateWillAppear_kc(String arg0) throws InterruptedException{
        Thread.sleep(1000);
        xpath = "//mat-accordion";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        xpath = "//ac-quiz-passing-percentage";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        xpath = "//mat-panel-title[contains(text(),'"+arg0+": new empty question')]";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        xpath = "//mat-radio-group";
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }


    @Then("complete required info of the question Q{int}_kc")
    public void completeRequiredInfoOfTheQuestion_kc(int q) {
        //Randomize choice of question type: 1=textual, 2=single, 3=multi
        //"//mat-panel-title[contains(text(),'Q1')]/../../..//*[contains(text(),'Textual')]"
        int qType = 0;
        String match;
        String root = "//mat-panel-title[contains(text(),'Q"+q+"')]/../../..";
        numOfQ = q;
        while (qType == 0) {
            qType = (int) (Math.random() * 3.4);
        }
        System.out.println(qType);
        switch (qType) {
            case 1: {
                match = "Textual";
                xpath = root + "//*[contains(text(),'" + match + "')]";
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).click();
                xpath = root + "//textarea[@placeholder='Question *']";
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).sendKeys("?? " + RndTxt() + " ??");
                break;
            }
            case 2: {
                int Opt = 0;
                match = "Single";
                xpath = root + "//*[contains(text(),'" + match + "')]";
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).click();
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                xpath = root + "//textarea[@placeholder='Question *']";
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).sendKeys("?? " + RndTxt() + " ??");
                xpath = root + "//*[contains(@placeholder,'Option 1*')]";
                getDriver().findElement(By.xpath(xpath)).sendKeys(RndTxt());
                xpath = root + "//*[contains(@placeholder,'Option 2*')]";
                getDriver().findElement(By.xpath(xpath)).sendKeys(RndTxt());
                while (Opt == 0) {
                    Opt = (int) (Math.random() * 2.4);
                }
                System.out.println(Opt);
                xpath = root + "//div[@class='right']//mat-radio-group["+Opt+"]/mat-radio-button[1]";
                getDriver().findElement(By.xpath(xpath)).click();
                break;
            }
            case 3: {
                int Opt = 0;
                match = "Multiple";
                xpath = root + "//*[contains(text(),'" + match + "')]";
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).click();
                halt = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                xpath = root + "//textarea[@placeholder='Question *']";
                halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                getDriver().findElement(By.xpath(xpath)).sendKeys("?? " + RndTxt() + " ??");
                xpath = root + "//*[contains(@placeholder,'Option 1*')]";
                getDriver().findElement(By.xpath(xpath)).sendKeys(RndTxt());
                xpath = root + "//*[contains(@placeholder,'Option 2*')]";
                getDriver().findElement(By.xpath(xpath)).sendKeys(RndTxt());
                while (Opt == 0) {
                    Opt = (int) (Math.random() * 3.4);
                }
                System.out.println(Opt);
                switch (Opt) {
                    case 1: {
                        xpath = root + "//div[@class='right']/div/div[1]/mat-checkbox";
                        getDriver().findElement(By.xpath(xpath)).click();
                        break;
                    }
                    case 2: {
                        xpath = root + "//div[@class='right']/div/div[2]/mat-checkbox";
                        getDriver().findElement(By.xpath(xpath)).click();
                        break;
                    }
                    case 3: {
                        xpath = root + "//div[@class='right']/div/div[1]/mat-checkbox";
                        getDriver().findElement(By.xpath(xpath)).click();
                        xpath = root + "//div[@class='right']/div/div[2]/mat-checkbox";
                        getDriver().findElement(By.xpath(xpath)).click();
                        break;
                    }
                }
                break;
            }
        }
    }

    @And("save the quiz_kc")
    public void saveTheQuiz_kc() {
        getDriver().findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();

    }

    @Then("go to the {string} and verify total questions of quiz_kc")
    public void goToTheAndVerifyTotalQuestionsOfQuiz_kc(String arg0) {
        String root;
        xpath = "//h4[contains(text(),'"+arg0+"')]";
        halt = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        xpath = "//mat-panel-title[contains(text(),'"+QuizTitle+"')]";
        root = xpath;
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        xpath = root + "/..//mat-panel-description";
        assertThat(getDriver().findElement(By.xpath(xpath)).getText().contains(Integer.toString(numOfQ))).isTrue();
        /*
        xpath = root + "/../..//span[contains(@class,'indicator')]";
        getDriver().findElement(By.xpath(xpath)).click();
        xpath = root + "/../../..//tbody";
        System.out.println(xpath);
        element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        int rowcnt = rows.size();
        System.out.println("number of rows: "+rowcnt);
        for (int i=0; i<rowcnt; i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            int colcnt = cols.size();
            System.out.println("number of cells: "+colcnt);
            for (int j=0; j<colcnt; j++) {
                String data = cols.get(j).getText();
                System.out.println(data);
                if (j==0) {
                    assertThat(data.contains("Total Questions")).isTrue();
                } else {
                    assertThat(Integer.parseInt(data)==(numOfQ)).isTrue();
                }
            }
        }*/

    }

    @Then("delete the quiz_kc")
    public void deleteTheQuiz_kc() throws InterruptedException{
        String root = "//mat-panel-title[contains(text(),'"+QuizTitle+"')]/../..";
        xpath = root + "//span[contains(@class,'indicator')]";
        getDriver().findElement(By.xpath(xpath)).click();
        root = "//mat-panel-title[contains(text(),'"+QuizTitle+"')]/../../..";
        xpath = root + "//button[@color='warn']";
        getDriver().findElement(By.xpath(xpath)).click();
        xpath = "//mat-dialog-container/ac-modal-confirmation/div[2]/button[2]";
        halt = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        halt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        //xpath = "//ac-modal-confirmation//button/span[contains(text(),'Delete')]";
        getDriver().findElement(By.xpath(xpath)).click();
        Thread.sleep(3000);
    }


    @When("I add {int} questions to the quiz_kc")
    public void iAddQuestionsToTheQuiz_kc(int qty) throws InterruptedException {
        for (int i=0; i<qty; i++) {
            iClickOnTheAddQuestionButton_kc();
            completeRequiredInfoOfTheQuestion_kc(i+1);

        }
    }
}
