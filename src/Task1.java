
import java.io.*;
import java.net.*;

public class Task1 {
    public static void main(String[] args) {

        double sum = 0;
        int count = 0;

        try {
            URL url = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String[] headers = reader.readLine().split(";");

            int column = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equals("UlkoTalo")) {
                    column = i;
                    break;
                }
            }

            if (column == -1) {
                System.out.println("UlkoTalo column not found");
                reader.close();
                return;
            }

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                if (data.length <= column) {
                    continue;
                }

                if (data[0].trim().startsWith("01.01.2023")) {

                    double temperature = Double.parseDouble(
                            data[column].trim().replace(",", ".")
                    );

                    sum = sum + temperature;
                    count++;
                }
            }

            reader.close();

            if (count > 0) {
                double average = sum / count;

                System.out.println("Average temperature: " + average);
                System.out.println("Measurements: " + count);
            } else {
                System.out.println("No data found");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
