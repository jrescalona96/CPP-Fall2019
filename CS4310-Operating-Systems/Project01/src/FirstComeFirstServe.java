import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.PrintWriter;

class FirstComeFirstServe {
    public static void main(String[] args) {

        // declarations //
        String jobName = "";
        int timeToFin = 0;
        String status = "Completed @ ";
        int startTime = 0, endTime = 0;
        double t1;
        String size = args[0];
        String ith = args[1];
        System.out.println(size + " " + ith);
        // print header //
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|   Name   |   Start Time   |   End Time    |       Status      |");
        System.out.println("-----------------------------------------------------------------");

        try {
            // declarations //
            File input = new File("jobs/jobs_" + size + "-" + ith + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            // log start time //
            t1 = System.nanoTime() / 1000000;

            // run jobs to end //
            while ((jobName = reader.readLine()) != null) {
                timeToFin = Integer.parseInt(reader.readLine());
                startTime = endTime;
                endTime = startTime + timeToFin;
                status += endTime;
                System.out.printf("|   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime, status);
                status = "Completed @ ";
            }
            System.out.println("-----------------------------------------------------------------");

            // log and print end time //
            System.out.println("Total Time Elapse = " + (System.nanoTime() / 1000000 - t1) + "ms\n");

            reader.close();
        } catch (Exception e) {
            System.err.println("File error " + e.getClass());
        }

        // run job and output to file //
        runToFile(args);
    }

    public static void runToFile(String[] size) {
        String jobName = "";
        int timeToFin = 0;
        int startTime = 0;
        int endTime = 0;
        String status = "Completed @ ";
        try {
            File output = new File("result_" + size[0] + "-" + size[1] + ".txt");
            File input = new File("jobs/jobs_" + size[0] + "-" + size[1] + ".txt");
            PrintWriter wr = new PrintWriter(output);
            BufferedReader reader = new BufferedReader(new FileReader(input));
            // Print Header for Schedule Table
            wr.write("-----------------------------------------------------------------\n");
            wr.write("|   Name   |   Start Time   |   End Time    |       Status      |\n");
            wr.write("-----------------------------------------------------------------\n");

            while ((jobName = reader.readLine()) != null) {
                timeToFin = Integer.parseInt(reader.readLine());
                startTime = endTime;
                endTime = startTime + timeToFin;
                status += endTime;
                wr.write(String.format("|   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime,
                        status));
                status = "Completed @ ";
            }
            wr.write("-----------------------------------------------------------------\n");
            reader.close();
            wr.flush();
            wr.close();
        } catch (Exception e) {
            System.err.println("File error " + e.getClass());
        }
    }
}