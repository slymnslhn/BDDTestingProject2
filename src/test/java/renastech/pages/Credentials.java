package renastech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import renastech.utils.CommonUtils;


public class Credentials extends PageFact {

    @FindBy (id = "card_nmuber")
    private WebElement cardNumber;

    @FindBy (id = "month")
    private WebElement expMonth;

    @FindBy(id = "year")
    private WebElement expYear;

    @FindBy (id = "cvv_code")
    private WebElement CvvCode;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement payButton;

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public WebElement getExpMonth() {
        return expMonth;
    }

    public WebElement getExpYear() {
        return expYear;
    }

    public WebElement getCvvCode() {
        return CvvCode;
    }

    public void getPayButton() {
        CommonUtils.clickWithWait(payButton);
    }
}
