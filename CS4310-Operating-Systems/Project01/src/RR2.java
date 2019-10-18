import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Queue;

class RR2 {
    public static void main(String[] args) {
        Queue<String> nq = new LinkedList<String>();
        Queue<Integer> tq = new LinkedList<Integer>();
        String jobName = "";
        Integer burstTime;
        int size = Integer.parseInt(args[0]);

        // read and store data
        try {
            File input = new File("../jobs/job_" + size + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(input));
            // read and store jobs into Queues
            while ((jobName = reader.readLine()) != null) {
                burstTime = new Integer(reader.readLine()); // read time
                nq.add(jobName);
                tq.add(burstTime);
            }
            reader.close(); // close reader
            runScheduler(nq, tq, size);
        } catch (Exception e) {
            System.err.println(e.getClass());
        }
    }

    public static void runScheduler(Queue<String> nameQueue, Queue<Integer> timeQueue, int size) {
        // print header //
        System.out.printf("\n                         Test Case = %s data points                  \n", size);
        System.out.println("    -----------------------------------------------------------------");
        System.out.println("    |   Name   |   Start Time   |   End Time    |       Status      |");
        System.out.println("    -----------------------------------------------------------------");

        String jobName = "";
        Integer burstTime;

        String status = "";
        int startTime = 0, endTime = 0, timeLeft = 0, timeUsed = 0;
        final int SLICE = 2;

        // log start time //
        long t1 = System.nanoTime() / 1000000;

        while (nameQueue.size() > 0) {

            // process current job
            jobName = nameQueue.remove();
            burstTime = new Integer(timeQueue.remove());
            // record time before run (before slice)

            // decrease burst time by slice time
            timeLeft = burstTime - SLICE;

            // set start and end times
            timeUsed = burstTime - timeLeft;

            startTime = endTime;
            endTime = startTime + timeUsed;

            // test if job is completed
            if (timeLeft > 0) {
                nameQueue.add(jobName);
                timeQueue.add(timeLeft);
                status = "";
            } else {
                status = "Completed @ " + endTime;
            }
            System.out.printf("    |   %-7s|        %-8d|      %-9d| %-18s|\n", jobName, startTime, endTime, status);
            // reset status
            status = "";
        }

        System.out.println("    -----------------------------------------------------------------");

        // log and print end time //
        System.out.println("    Total Time Elapse = " + (System.nanoTime() / 1000000 - t1) + "ms\n");
    }
}