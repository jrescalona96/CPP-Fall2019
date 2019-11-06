import java.io.*;
import java.util.*;

class GenerateData {
    public static void main(String[] args) {

        // read size from console
        int refStringLength = 30;
        int numberOfRefStrings = 50;
        String refString = "";
        Random rand = new Random();
        int pageFrameSize = Integer.parseInt(args[0]);

        // create file
        try {
            File file = new File("reference_strings_" + pageFrameSize +".txt");
            PrintWriter wr = new PrintWriter(file);

            // generate strings               
            for (int j = 0; j < numberOfRefStrings; j++) {
                wr.write("Number of page frame value:\n");
                wr.write(pageFrameSize + "\n");
                for (int k = 0; k < refStringLength; k++) {
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