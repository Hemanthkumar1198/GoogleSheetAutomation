package tests;

import org.testng.annotations.*;
import pages.GoogleSheetsPage;
import base.BaseTest;
import utils.PerformanceMonitor;

public class PerformanceTest extends BaseTest {
    private GoogleSheetsPage sheets;

    @BeforeMethod
    public void setup() {
        sheets = new GoogleSheetsPage(driver);
    }

    @Test
    public void testLargeDataset() {
        PerformanceMonitor.start("Large data load");
        // Use actual API integration here
        PerformanceMonitor.stop("Large data load");
        assertTrue(PerformanceMonitor.getDuration("Large data load") < 5000);
    }
}