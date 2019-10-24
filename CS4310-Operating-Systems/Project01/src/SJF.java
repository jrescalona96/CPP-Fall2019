import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.*;

class SJF {
    public static void main(String[] args) {
        // declarations //
        String size = args[0];
        String jobName = ""; // temporarily hold job name
        Integer burstTime = 0; // temporarily hold job time
        String status = "Completed @ ";
        int startTime = 0, endTime = 0;
        Map<String, Integer> unsortedJobsMap = new HashMap<String, Integer>();
        ArrayList<Integer> completion = new ArrayList<Integer>();

        // read and store data
        try {
            File input = new File("../jobs/job_" + size + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            // read and store jobs into tempHashMap
            while ((jobName = reader.readLine()) != null) {
                burstTime = Integer.parseInt(reader.readLine()); // read time
                unsortedJobsMap.put(jobName, burstTime);// add to Map
            }
            reader.close(); // close reader

            // log start time //
            long t1 = System.currentTimeMillis();

            // sort times
            ArrayList<Integer> timesList = new ArrayList<Integer>();
            ArrayList<String> namesList = new ArrayList<String>();
            for (Map.Entry<String, Integer> job : unsortedJobsMap.entrySet()) {
                timesList.add(job.getValue());
            }

            Collections.sort(timesList); // sort arrayList times

            // create a list of names according to sorted timesList //
            // loop over timeList
            for (Integer i : timesList) {
                // loop over unsortedJobsMap and compare current time
                for (Map.Entry<String, Integer> job : unsortedJobsMap.entrySet()) {
                    // if current time us found
                    if (job.getValue() == i) {
                        // if name is not on namesList add it.
                        if (!namesList.contains(job.getKey())) {
                            namesList.add(job.getKey());
                        }
                    }
                }
            }

            // print header //
            System.out.printf("\n                         Test Case = %s data points                  \n", size);
            System.out.println("    -----------------------------------------------------------------");
            System.out.println("    |   Name   |   Start Time   |   End Time    |       Status      |");
            System.out.println("    -----------------------------------------------------------------");

            // run jobs //
            Integer timeToFinish;
            for (String name : namesList) {
                jobName = name; // get job name from hash map
                timeToFinish = unsortedJobsMap.get(name);
                ; // set time to finish
                startTime = endTime; // set start time to previous end time
                endTime = startTime + timeToFinish; // set end time to previous end time + burst time
                status += endTime; // add time to completion string
                // print results //
                System.out.printf("    |   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime,
                        status);
                status = "Completed @ "; // reset status string
                completion.add(endTime); // add completion time to arrayList
            }

            System.out.println("    -----------------------------------------------------------------");

            // compute mean turn around time
            double sum = 0;
            for (int i : completion) {
                sum += i;
            }
            double mean = sum / Integer.parseInt(size);

            // log and print end time //
            System.out.printf("Mean Turnaround Time= %.2f ms,\nTotal Time Elapse = %d ms\n", mean,
                    System.currentTimeMillis() - t1);

        } catch (Exception e) {
            System.err.println(e.getClass());
        }
    }
}