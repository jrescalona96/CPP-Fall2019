import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;

class FCFS {
    public static void main(String[] args) {
        // declarations //
        String jobName = "";
        int timeToFin = 0;
        String status = "Completed @ ";
        int startTime = 0, endTime = 0;
        String size = args[0];
        ArrayList<Integer> completion = new ArrayList<Integer>();

        // print header //
        System.out.printf("\n                        Test Case = %s data points                  \n", size);
        System.out.println("    -----------------------------------------------------------------");
        System.out.println("    |   Name   |   Start Time   |   End Time    |       Status      |");
        System.out.println("    -----------------------------------------------------------------");

        // log start time //
        long t1 = System.currentTimeMillis();

        try {
            // declarations //
            File input = new File("../jobs/job_" + size + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            // run jobs to end //
            while ((jobName = reader.readLine()) != null) {
                timeToFin = Integer.parseInt(reader.readLine()); // set timeToFinish = burst time
                startTime = endTime; // set start time to previous end time
                endTime = startTime + timeToFin; // set end time to previous end time + burst time
                status += endTime; //add time to completion string
                // print results //
                System.out.printf("    |   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime,
                        status);
                status = "Completed @ "; // reset status string
                completion.add(endTime); // add completion time to arrayList
            }
            System.out.println("    -----------------------------------------------------------------");

            //compute for mean turnaround time
            double sum = 0;
            for(int i : completion) {
                sum+=i;
            }
            double mean = sum/Integer.parseInt(size);
            // log and print end time //
            System.out.printf("Mean Turnaround Time= %.2f ms,\nTotal Time Elapse = %d ms\n", mean , (System.currentTimeMillis() - t1));
            reader.close(); //close reader
        } catch (Exception e) {
            System.err.println("File error " + e.getClass());
        }
    }

    public static void runToFile(String size) {
        // CSVWriter csvWriter = new CSVWriter("../data/", String.format("data" + size));
        // csvWriter.write("kamikazee");
        // csvWriter.write("king");
        // csvWriter.write("pin");
        // String jobName = "";
        // int timeToFin = 0;
        // int startTime = 0;
        // int endTime = 0;
        // String status = "Completed @ ";
        // try {
        // File output = new File("result_" + size + ".txt");
        // File input = new File("../jobs/job_" + size + ".txt");
        // PrintWriter wr = new PrintWriter(output);
        // BufferedReader reader = new BufferedReader(new FileReader(input));

        // // Print Header for Schedule Table
        // wr.write("
        // -----------------------------------------------------------------\n");
        // wr.write(" | Name | Start Time | End Time | Status |\n");
        // wr.write("`
        // -----------------------------------------------------------------\n");

        // while ((jobName = reader.readLine()) != null) {
        // timeToFin = Integer.parseInt(reader.readLine());
        // startTime = endTime;
        // endTime = startTime + timeToFin;
        // status += endTime;
        // wr.write(String.format(" | %-7s| %-8d| %-9d| %-18s|\n", jobName, startTime,
        // endTime,
        // status));
        // status = "Completed @ ";
        // }
        // wr.write("
        // -----------------------------------------------------------------\n");
        // wr.flush();
        // reader.close();
        // wr.close();
        // } catch (Exception e) {
        // System.err.println("File error: " + e.getClass());
        // }
    }
}
