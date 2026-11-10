
import java.io.*;

public class Task2 {
    public static void main(String[] args) {

        long a = 0;
        long b = 1;

        try {
            FileWriter file = new FileWriter("fibonacci.csv");

            file.write("Index;Fibonacci\n");

            for (int i = 0; i < 60; i++) {
                file.write(i + ";" + a + "\n");

                long next = a + b;
                a = b;
                b = next;
            }

            file.close();

            System.out.println("Fibonacci CSV file created!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
