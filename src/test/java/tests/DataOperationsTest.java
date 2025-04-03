package tests;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import pages.GoogleSheetsPage;
import base.BaseTest;

public class DataOperationsTest extends BaseTest {
    GoogleSheetsPage sheets;
    private static final String SHEET_URL = "https://docs.google.com/spreadsheets/d/your-sheet-id";

    @BeforeMethod
    public void openSheet() {
        sheets = new GoogleSheetsPage(driver);
        driver.get(SHEET_URL);
    }

    @Test
    public void testSorting() {
        sheets.enterData("A1", "Zebra");
        sheets.enterData("A2", "Apple");
        sheets.sortColumnAscending("A");
        
        // Verify sorting
        assertEquals(sheets.getCellValue("A1"), "Apple");
        assertEquals(sheets.getCellValue("A2"), "Zebra");
    }
}
