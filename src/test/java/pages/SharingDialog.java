package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SharingDialog extends BasePage {
    private By shareButton = By.cssSelector("div[aria-label='Share'][role='button']");
    private By emailInput = By.cssSelector("input[type='email']");
    private By permissionsDropdown = By.cssSelector("select[aria-label='Permissions']");
    private By sendButton = By.cssSelector("div[aria-label='Send']");

    public SharingDialog(WebDriver driver) {
        super(driver);
    }

    public void shareWithEditor(String email) {
        click(shareButton);
        sendKeys(emailInput, email);
        new Select(waitForVisibility(permissionsDropdown)).selectByVisibleText("Editor");
        click(sendButton);
    }
}