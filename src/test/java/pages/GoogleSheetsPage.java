package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class GoogleSheetsPage extends BasePage {
    
    private By cellLocator(String address) {
        return By.cssSelector("[aria-label='Cell " + address + "']");
    }

    public GoogleSheetsPage(WebDriver driver) {
        super(driver);
    }

    public void enterData(String cellAddress, String value) {
        click(cellLocator(cellAddress));
        WebElement cellInput = driver.switchTo().activeElement();
        cellInput.sendKeys(value + Keys.ENTER);
    }

    public void sortColumnAscending(String column) {
        By columnHeader = By.xpath("//div[text()='" + column + "']/ancestor::div[@role='columnheader']");
        click(columnHeader);
        click(By.xpath("//div[text()='Sort sheet A → Z']"));
    }

    public void resizeColumn(String column, int pixels) {
        WebElement header = driver.findElement(
            By.xpath("//div[text()='" + column + "']/ancestor::div[@role='columnheader']"));
        WebElement handle = header.findElement(By.className("column-resize-handle"));
        new Actions(driver).dragAndDropBy(handle, pixels, 0).perform();
    }

    public void importCSV(String filePath) {
        // Implement Google Sheets API integration for reliable CSV upload
        throw new UnsupportedOperationException("Use Google Sheets API for CSV imports");
    }
    
    private By shareButton = By.cssSelector("div[aria-label='Share'][role='button']");

    public void clickShareButton() {
        click(shareButton);
    }
}