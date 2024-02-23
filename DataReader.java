import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DataReader {

    public static void main(String[] args) {
        String csvFile = "pirate_attacks.csv";
        ArrayList<MaritimeAttack> attacks = new ArrayList<MaritimeAttack>();

        try (Reader reader = new FileReader(csvFile);
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build())) {

            for (CSVRecord csvRecord : csvParser) {
                String date = csvRecord.get("date");
                String time = csvRecord.get("time");
                double longitude = Double.parseDouble(csvRecord.get("longitude"));
                double latitude = Double.parseDouble(csvRecord.get("latitude"));
                String attackType = csvRecord.get("attack_type");
                String locationDescription = csvRecord.get("location_description");
                String nearestCountry = csvRecord.get("nearest_country");
                String eezCountry = csvRecord.get("eez_country");
                double shoreDistance = Double.parseDouble(csvRecord.get("shore_distance"));
                double shoreLongitude = Double.parseDouble(csvRecord.get("shore_longitude"));
                double shoreLatitude = Double.parseDouble(csvRecord.get("shore_latitude"));
                String attackDescription = csvRecord.get("attack_description");
                String vesselName = csvRecord.get("vessel_name");
                String vesselType = csvRecord.get("vessel_type");
                String vesselStatus = csvRecord.get("vessel_status");
                String dataSource = csvRecord.get("data_source");

                MaritimeAttack attack = new MaritimeAttack(date, time, longitude, latitude, attackType,
                        locationDescription, nearestCountry, eezCountry, shoreDistance, shoreLongitude,
                        shoreLatitude, attackDescription, vesselName, vesselType, vesselStatus, dataSource);
                attacks.add(attack);
            }
            // System.out.println(attacks);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(getYearWithMostAttacks(attacks));
        BarGraph.plotYearlyAttacks(attacks);

    }

    public static int getYearWithMostAttacks(ArrayList<MaritimeAttack> attacks) {
        Map<Integer, Integer> yearCountMap = new HashMap<>();

        for (MaritimeAttack attack : attacks) {
            int year = Integer.parseInt(attack.getDate().split("-")[0]);
            yearCountMap.put(year, yearCountMap.getOrDefault(year, 0) + 1);
        }

        int maxYear = 0;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : yearCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxYear = entry.getKey();
            }
        }

        return maxYear;
    }

}
