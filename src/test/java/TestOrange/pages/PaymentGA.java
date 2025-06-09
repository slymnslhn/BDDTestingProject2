package renastech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import renastech.utils.CommonUtils;

public class PaymentGA extends PageFact {

    @FindBy(xpath = "//h2[.='Mother Elephant With Babies Soft Toy']")
    private WebElement header;

    @FindBy(xpath = "//h3[.='Price: $20']")
    private WebElement toyPrice;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNowButton;

    public WebElement getHeader() {
        return header;
    }

    public WebElement getToyPrice() {
        return toyPrice;
    }

    public void addQuantity(String totalQuantity) {
        CommonUtils.selectFromDropDown(quantityButton, totalQuantity);
    }

    public void clickBuyNowButton() {
        CommonUtils.clickWithWait(buyNowButton);
    }
}
