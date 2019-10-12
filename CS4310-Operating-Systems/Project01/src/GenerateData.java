import java.io.*;
import java.util.*;

class GenerateData {
    public static void main(String[] args) {

        // read size from console
        int size = 0;
        Random rand = new Random();
        try {
            size = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println("Error in Job generation :" + e.getClass());
            throw new IllegalArgumentException("Invalid input");
        }

        // create file
        try {
            for (int j = 0; j < 3; j++) {
                File file = new File("jobs/jobs_" + size + "-" + (j + 1) + ".txt");
                PrintWriter wr = new PrintWriter(file);
                String name = "Job";
                String burstTime = "";
                // generate numbers and write to file
                for (int i = 0; i < size; i++) {
                    name = "Job" + (i + 1) + "\n";
                    burstTime = Integer.toString(rand.nextInt(80) + 20);
                    wr.write(name);
                    wr.write(burstTime + "\n");
                }
                wr.close();
            }
        } catch (Exception e) {
            System.err.println("Error in Input file creation :" + e.getClass());
        }

    }
}