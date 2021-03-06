// First-In First-Out Page Replacement Algorithm //
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

class FIFOPageReplacement {
    public static void main(String[] args) {
        try {
            // DECLARATIONS //
            int pageFrameSize = Integer.parseInt(args[0]);
            // open file to read
            BufferedReader reader = new BufferedReader(new FileReader(new File("reference_strings_" + pageFrameSize + ".txt")));
            // create and open file to write results
            FileWriter fileWriter = new FileWriter("FIFOPageReplacement_Result_" + pageFrameSize + ".txt");
            PrintWriter writer = new PrintWriter(fileWriter);
            Queue<String> pageTable;
            String referenceString = "";
            String page = new String();
            double numberOfPageFaults = 0.0;
            double numberOfStrings = 0.0;
            double average = 0.0;
            // TRAVERSE FILE //
            while (reader.readLine() != null) {
                // INIT //
                pageTable = new LinkedList<String>();
                pageFrameSize = Integer.parseInt(reader.readLine()); // Page Frame
                reader.readLine(); // Skip header text
                referenceString = reader.readLine(); // Read reference String
                numberOfStrings++; // page counter

                // print header
                System.out.printf("\n****************************************************************************\n");
                System.out.printf("Reference String: %s\nPage Frame size: %d", referenceString, pageFrameSize);
                System.out.printf("\n****************************************************************************");
                writer.printf("\n****************************************************************************\n");
                writer.printf("Reference String: %s\nPage Frame size: %d", referenceString, pageFrameSize);
                writer.printf("\n****************************************************************************");

                // START JOB //
                for (int i = 0; i < referenceString.length(); i++) {
                    // read next page
                    System.out.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    writer.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    page = String.valueOf(referenceString.charAt(i));
                    // initialize pageTable
                    if (pageTable.size() < pageFrameSize) {
                        if (pageFault(page, pageTable)) {
                            // initialize page table
                            System.out.printf(" => Page Fault: %s not found!", page);
                            writer.printf(" => Page Fault: %s not found!", page);
                            numberOfPageFaults++; // incerement page fault counter
                            pageTable.add(page);
                        }
                    } else {
                        // check if page is Fault
                        if (pageFault(page, pageTable)) {
                            System.out.printf(" => Page Fault: %s not found!", page);
                            writer.printf(" => Page Fault: %s not found!", page);
                            numberOfPageFaults++; // incerement page fault counter
                            pageTable.remove(); // remove oldest page
                            pageTable.add(page); // add new page
                        }
                    }
                    // print current page table //
                    System.out.print(" => /");
                    writer.print(" => /");
                    for(String s:pageTable) {
                        System.out.print(s + "/");
                        writer.print(s + "/");
                    }
                }
                System.out.printf("\n****************************************************************************\n");
                System.out.printf("Page Faults = %.0f", numberOfPageFaults);
                System.out.printf("\n****************************************************************************\n");
                writer.printf("\n****************************************************************************\n");
                writer.printf("Page Faults = %.0f", numberOfPageFaults);
                writer.printf("\n****************************************************************************\n");
            }
            // solve for average page faults
            average = numberOfPageFaults/numberOfStrings;

            // print final results to console
            System.out.printf("\n****************************************************************************");
            System.out.printf("\n%.0f Strings Done.", numberOfStrings);
            System.out.printf("\nNumber of page Faults = %.0f", numberOfPageFaults);
            System.out.printf("\nAverage page faults = %.2f", average);
            System.out.printf("\n****************************************************************************");
             
            // print final results to text file
            writer.printf("\n\n****************************************************************************");
            writer.printf("\n%.0f Strings Done.", numberOfStrings);
            writer.printf("\nNumber of page Faults = %.0f", numberOfPageFaults);
            writer.printf("\nAverage page faults = %.2f", average);
            writer.printf("\n****************************************************************************");

            // close reader and writer
            reader.close();
            writer.close();

        } catch (Exception err) {
            System.err.println("Enter Page Frame size as args." + err.getClass());
        }
    }

    // HELPER FUNCTIONS //
    public static boolean pageFault(String page, Queue<String> pageTable) {
        boolean res = false;
        if (!pageTable.contains(page)) {
            res = true;
        }
        return res;
    }
}