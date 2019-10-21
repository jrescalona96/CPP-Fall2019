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
        String status = "@";
        int startTime = 0, endTime = 0;
        String size = args[0];
        ArrayList<Integer> completion = new ArrayList<Integer>();

        // print header //
        // System.out.printf("\nTest Case = %s data points\n", size);
        // System.out.println("Name  S.T.  E.T.  Stat");

        try {
            // declarations //
            File input = new File("../jobs/job_" + size +"_" + args[1] + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            // run jobs to end //
            while ((jobName = reader.readLine()) != null) {
                timeToFin = Integer.parseInt(reader.readLine());
                startTime = endTime;
                endTime = startTime + timeToFin;
                status += endTime;
                //System.out.printf("%-6s%-6d%-6d%-6s\n", jobName, startTime, endTime, status);
                status = "@";
                completion.add(endTime);
            }
            // System.out.println();

            double sum = 0;
            for(int i : completion) {
                sum+=i;
            }
            double mean = sum/Integer.parseInt(size);
            // log and print E.T. //
            //System.out.printf("\nMean Turnaround Time= %.2f ms\n", mean);
            System.out.println(mean);

            reader.close();
        } catch (Exception e) {
            System.err.println("File error " + e.getClass());
        }
    }
}
