package tests;

import org.testng.annotations.*;
import pages.*;
import base.BaseTest;
import static org.testng.Assert.*;

public class SharingTest extends BaseTest {
    private GoogleSheetsPage sheets;
    private SharingDialog sharingDialog;

    @BeforeMethod
    public void setup() {
        sheets = new GoogleSheetsPage(driver);
        sharingDialog = new SharingDialog(driver);
        driver.get("https://docs.google.com/spreadsheets/d/your-sheet-id");
    }

    @Test
    public void testShareWithEditor() {
        // Single source of truth for share button click
        sheets.clickShareButton();
        sharingDialog.shareWithEditor("collaborator@example.com");
        assertTrue(sharingDialog.isSuccessMessageDisplayed());
    }

}