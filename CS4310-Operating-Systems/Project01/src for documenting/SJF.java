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
        Map<String, Integer> unsortedJobsMap = new HashMap<String, Integer>();
        ArrayList<Integer> completion = new ArrayList<Integer>();
        // read and store data
        try {
            File input = new File("../jobs/job_" + size +"_"+args[1]+ ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            // read and store jobs into tempHashMap
            while ((jobName = reader.readLine()) != null) {
                burstTime = Integer.parseInt(reader.readLine()); // read time
                unsortedJobsMap.put(jobName, burstTime); // add to Map*************************************************************************
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
            Collections.sort(timesList);

            for (Integer i: timesList) {
                for (Map.Entry<String, Integer> job : unsortedJobsMap.entrySet()) {
                    if(job.getValue() == i) {
                        if(!namesList.contains(job.getKey())){
                            namesList.add(job.getKey());
                        }
                    }
                }
            }
            
            // System.out.printf("\nTest Case = %s data points\n", size);
            // System.out.println("Name  S.T.  E.T.  Stat");

            // run jobs //
            String status = "@";
            int startTime = 0, endTime = 0;
            Integer timeToFinish;
            for (String name : namesList) {
                jobName = name;
                timeToFinish = unsortedJobsMap.get(name);
                startTime = endTime;
                endTime = startTime + timeToFinish;
                status += endTime;
                //System.out.printf("%-9s%-6d%-6d%-6s\n", jobName, startTime, endTime, status);
                // reset status
                status = "@";
                completion.add(endTime);
            }

            // System.out.println("    -----------------------------------------------------------------");

            //compute mean turn around time
            double sum = 0;
            for(int i : completion) {
                sum+=i;
            }
            double mean = sum/Integer.parseInt(size);
            // log and print end time //
            //System.out.printf("\nMean Turnaround Time= %.2f ms\n", mean);
            System.out.println(mean);

        } catch (Exception e) {
            System.err.println(e.getClass());
        }
    }
}