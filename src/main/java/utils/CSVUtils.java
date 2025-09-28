package utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCSV(String filePath) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> data = new ArrayList<>();
        String[] line;
        // Skip header row
        reader.readNext();
        while ((line = reader.readNext()) != null) {
            data.add(line);
        }
        reader.close();
        return data;
    }
}