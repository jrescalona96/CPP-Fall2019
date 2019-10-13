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
        String jobName = ""; //temporarily hold job name
        Integer burstTime = 0; //temporarily hold job time
        double t1;
        Map<Integer, String> unsortedJobsMap = new HashMap<Integer, String>();
        //read and store data
        try {
            File input = new File("../jobs/job_" + size + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            //read and store jobs into tempHashMap
            while((jobName = reader.readLine())  != null)  {
                burstTime = Integer.parseInt(reader.readLine()); //read time
                unsortedJobsMap.put(burstTime, jobName); //add to Map
            }
            reader.close(); //close reader  

              
            // print header //
            System.out.printf("\n                         Test Case = %s data points                  \n", size);
            System.out.println("    -----------------------------------------------------------------");
            System.out.println("    |   Name   |   Start Time   |   End Time    |       Status      |");
            System.out.println("    -----------------------------------------------------------------");
  
            // log start time //
            t1 = System.nanoTime() / 1000000;
            
            //sort times
            ArrayList<Integer> timesList = new ArrayList<Integer>();
            for(Map.Entry<Integer, String> job : unsortedJobsMap.entrySet()) {
                timesList.add(job.getKey());
            }
            Collections.sort(timesList);   

            // run jobs //
            String status = "Completed @ ";
            int startTime = 0, endTime = 0;
            Integer timeToFinish;
            for(Integer t : timesList) {
                jobName = unsortedJobsMap.get(t);
                timeToFinish = t;
                startTime = endTime;
                endTime = startTime + timeToFinish;
                status += endTime;
                System.out.printf("    |   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime, status);
                status = "Completed @ "; 
            }

            System.out.println("    -----------------------------------------------------------------");

            // log and print end time //
            System.out.println("    Total Time Elapse = " + (System.nanoTime() / 1000000 - t1) + "ms\n");

        } catch (Exception e) {
            System.err.println(e.getClass());
        }      
    }
}