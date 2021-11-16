package pages;

import elements.InputField;
import elements.TextAreaField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {

    public static final String NEW_ACCOUNT_URL = "https://dms4.lightning.force.com/lightning/o/Account/new";
    public By SAVE_MODAL_BUTTON = By.xpath("//*[contains(@class,'forceActionButton')]//*[text()='Save']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openNewAccountModal() {
        driver.get(NEW_ACCOUNT_URL);
        return this;
    }

    public NewAccountModalPage clickSave() {
        driver.findElement(SAVE_MODAL_BUTTON).click();
        return this;
    }

    public HomePage createAccount(String accountName, String website, String description, String billingAddress) {
        new InputField(driver, "Account Name").writeText(accountName);
        new InputField(driver, "Website").writeText(website);
        new TextAreaField(driver, "Description").writeText(description);
        new TextAreaField(driver, "Billing Street").writeText(billingAddress);
        clickSave();
        return new HomePage(driver);
    }

}