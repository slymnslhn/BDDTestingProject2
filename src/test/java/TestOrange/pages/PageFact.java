package renastech.pages;

import org.openqa.selenium.support.PageFactory;
import renastech.utils.Driver;

public abstract class PageFact {
    public PageFact() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
