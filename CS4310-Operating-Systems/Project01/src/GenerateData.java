import java.io.*;
import java.util.*;

class GenerateData {
    public static void main(String[] args) {

        // read size from console
        int size = 0;
        ArrayList<String> jobs;
        ArrayList<String> times;
        Random rand = new Random();

        //initialize containers and parse string argument size
        try {
            size = Integer.parseInt(args[0]);
            jobs = new ArrayList<String>(size);
            times = new ArrayList<String>(size);
        } catch (Exception e) {
            System.err.println("Error in Job generation :" + e.getClass());
            throw new IllegalArgumentException("Invalid input");
        }

        // create file
        try {
                File file = new File("../jobs/job_" + size + ".txt");
                PrintWriter wr = new PrintWriter(file);
                String name = "Job";
                String burstTime = "";

                // generate numbers
                for (int i = 0; i < size; i++) {
                    name = "Job" + (i + 1) + "\n";
                    burstTime = Integer.toString(rand.nextInt(50) + 20);
                    jobs.add(name);
                    times.add(burstTime);
                }
                
                //shuffle array
                Collections.shuffle(jobs);
                Collections.shuffle(times);

                //write to file
                for (int i = 0; i < jobs.size(); i++) {
                    wr.write(jobs.get(i));
                    wr.write(times.get(i) + "\n");
                }

                wr.close();
        } catch (Exception e) {
            System.err.println("Error in Input file creation :" + e.getClass());
        }

    }
}