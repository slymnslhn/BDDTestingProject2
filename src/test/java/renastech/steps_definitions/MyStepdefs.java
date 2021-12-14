package renastech.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import renastech.pages.Credentials;
import renastech.pages.PaymentGA;
import renastech.pages.PaymentSuccess;
import renastech.utils.ConfigurationsReader;
import renastech.utils.Driver;

import java.io.IOException;
import java.util.Map;

public class MyStepdefs {
    PaymentGA paymentGA=new PaymentGA();
    Credentials credentials=new Credentials();
    PaymentSuccess paymentSuccess=new PaymentSuccess();
    private static final Logger logger= Logger.getLogger(MyStepdefs.class);


    @Given(": The user wants to go to Gateway")
    public void theUserWantsToGoToGateway() {
        Driver.getDriver().get(ConfigurationsReader.getProperty("demoguruURL"));
        logger.info("The user is on DemoGuru Payment Gateway page");
    }


    @When("The user wants to verify that the header is present as {string}")
    public void theUserWantsToVerifyThatTheHeaderIsPresentAs(String expect) {
    Assert.assertEquals(paymentGA.getHeader().getText(),expect);
    logger.info("Header successfully verified");
    }

    @When("The user wants to verify that the toy price is {string}")
    public void theUserWantsToVerifyThatTheToyPriceIs(String expected) {
    Assert.assertTrue(paymentGA.getToyPrice().getText().contains(expected));
    logger.info("Price verification performed");
    }

    @When("The user wants to verify that the URL contains {string}")
    public void theUserWantsToVerifyThatTheURLContains(String expectedURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
        logger.info("URL expect validation performed");
    }

    @When("The user wants to have quantity as {string}")
    public void theUserWantsToHaveQuantityAs(String totalQuantity) {
        paymentGA.addQuantity(totalQuantity);
        logger.info("The expected product selection has been made");
    }

    @And("The user wants to click Buy button")
    public void theUserWantsToClickBuyButton() {
        paymentGA.clickBuyNowButton();
        logger.info("Payment button clicked successfully");
    }

    @And("The user wants to enter information about payment as")
    public void theUserWantsToEnterInformationAboutPaymentAs(Map<String,String> dataTable) {

        credentials.getCardNumber().sendKeys(dataTable.get("cardnumber"));
        credentials.getExpMonth().sendKeys(dataTable.get("expiryMonth"));
        credentials.getExpYear().sendKeys(dataTable.get("ExpiryYear"));
        credentials.getCvvCode().sendKeys(dataTable.get("CVVCode"));
        logger.info("Customer's card information has been successfully entered");
    }

    @And("The user wants to click pay button")
    public void theUserWantsToClickPayButton() {
        credentials.getPayButton();
        logger.info("Successfully clicked the payment button");
    }

    @Then("The user wants to verify that {string}")
    public void theUserWantsToVerifyThat(String expected) {
        Assert.assertEquals(paymentSuccess.getPaymentSuccess().getText(),expected);
        logger.info("Confirmation of payment has been successfully completed");
    }

    @When("The user wants to choose different {string}")
    public void theUserWantsToChooseDifferent(String quantity) throws IOException {
    paymentGA.addQuantity(quantity);
    logger.info("Expected quantities has been successfully entered ");

    }


}
