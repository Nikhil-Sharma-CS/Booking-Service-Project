package org.example.Booking.Service.Service;

import com.opencsv.CSVReader;
import org.example.Booking.Service.Model.seat;
import org.example.Booking.Service.Model.seat_price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//This class is used to import data from the csv files provided in the resources of the application

@Component
public class DataImportRunner implements CommandLineRunner {

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatPriceService seatPriceService;

    @Override
    public void run(String... args) throws Exception {
        // Replace "path/to/your/file.csv" with the actual path to your CSV file
        String csvFilePath = "src/main/resources/CSV files/Seats - MOCK_DATA.csv";
        String csvFilePath2 = "src/main/resources/CSV files/SeatPricing - MOCK_DATA.csv";

        List<seat> data = readDataFromCSV(csvFilePath);

        List<seat_price> data2 = readDataFromCSV2(csvFilePath2);

        seatService.importData(data);

        seatPriceService.importData(data2);
    }

    private List<seat_price> readDataFromCSV2(String FilePath2) {
        List<seat_price> data2 = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(FilePath2))) {
            String[] line;
            boolean first = true;
            while ((line = reader.readNext()) != null) {

                if(first)
                {
                    first = false;
                    continue;
                }

                seat_price entity = new seat_price();
                entity.setId(Integer.valueOf(line[0])); // Assuming the first column is the name
                entity.setSclass(line[1]); // Assuming the second column is the email
                entity.setMinprice(Double.valueOf(line[2]));
                entity.setNormalprice(Double.valueOf(line[3]));
                entity.setMaxprice(Double.valueOf(line[4]));

                // Set additional fields if present in the CSV
                data2.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data2;
    }

    private List<seat> readDataFromCSV(String FilePath) {
        List<seat> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(FilePath))) {
            String[] line;
            boolean first = true;
            while ((line = reader.readNext()) != null) {

                if(first)
                {
                    first = false;
                    continue;
                }

                seat entity = new seat();
                entity.setId(Integer.valueOf(line[0])); // Assuming the first column is the name
                entity.setIdentifier(line[1]); // Assuming the second column is the email
                entity.setSclass(line[2]);
                entity.setIsbooked(Boolean.parseBoolean(line[3]));

                // Set additional fields if present in the CSV

                data.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
