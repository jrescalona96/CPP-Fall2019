import java.io.*;
import java.util.*;

class GenerateData {
    public static void main(String[] args) {

        // read size from console
        int refStringLength = 30;
        int numberOfRefStrings = 50;
        String refString = "";

        Random rand = new Random();

        // create file
        try {
            File file = new File("reference_strings.txt");
            PrintWriter wr = new PrintWriter(file);

            // generate strings
            for (int i = 0; i < numberOfRefStrings; i++) {
                wr.write("Number of page frame value:\n");
                wr.write(rand.nextInt(6) + 3 + "\n");
                for (int j = 0; j < refStringLength; j++) {
                    refString += String.valueOf(rand.nextInt(8));
                }
                wr.write("Reference String:\n");
                wr.write(refString + "\n");
                refString = "";
            }
            System.out.println("Done creating data!");

            wr.close();
        } catch (Exception e) {
            System.err.println("Error in Input file creation :" + e.getClass());
        }

    }
}