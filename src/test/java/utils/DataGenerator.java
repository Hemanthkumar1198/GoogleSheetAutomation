package utils;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class DataGenerator {
    public static void createLargeCSV(String path, int rows) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeNext(new String[]{"ID","Data"});
            for(int i=1; i<=rows; i++) {
                writer.writeNext(new String[]{String.valueOf(i), "Row " + i});
            }
        }
    }
}
