// Usage: java OptimalPageReplacement <page_size> i.e. java OptimalPageReplacement 3
// The program will then output on the console and a text file with the same results
// Optimal Page Replacement Algorithm
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.io.*;

class OptimalPageReplacement {
    public static void main(String[] args) {
        try {
            // DECLARATIONS //
            int pageFrameSize = Integer.parseInt(args[0]);
            // open file to read
            BufferedReader reader = new BufferedReader(new FileReader(new File("reference_strings_" + pageFrameSize + ".txt")));
            // create and open file to write results
            FileWriter fileWriter = new FileWriter("OptimalPageReplacement_Result_" + pageFrameSize + ".txt");
            PrintWriter writer = new PrintWriter(fileWriter);
            Queue<String> pageTable;
            String referenceString = "";
            String optimalPage = "";
            String page = new String();
            double numberOfPageFaults = 0.0;
            double numberOfStrings = 0.0;
            double average = 0.0;
            // TRAVERSE FILE //
            while (reader.readLine() != null) {
                // INITIALIZATIONS //
                pageTable = new LinkedList<String>();
                pageFrameSize = Integer.parseInt(reader.readLine()); // Page Frame
                reader.readLine(); // Skip header text
                referenceString = reader.readLine(); // Read reference String
                numberOfStrings++; //increment reference string counter

                // print header
                System.out.printf("\n****************************************************************************\n");
                System.out.printf("Reference String: %s\nPage Frame size: %d", referenceString, pageFrameSize);
                System.out.printf("\n****************************************************************************");
                writer.printf("\n****************************************************************************\n");
                writer.printf("Reference String: %s\nPage Frame size: %d", referenceString, pageFrameSize);
                writer.printf("\n****************************************************************************");

                // START JOB //
                for (int i = 0; i < referenceString.length(); i++) {
                    System.out.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    writer.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    // read next page
                    page = String.valueOf(referenceString.charAt(i));
                    if (pageTable.size() < pageFrameSize) {
                        // initialize page table
                        if (pageFault(page, pageTable)) {
                            numberOfPageFaults++; // incerement page fault counter
                            System.out.printf(" => Page Fault: %s not found!", page);
                            writer.printf(" => Page Fault: %s not found!", page);
                            pageTable.add(page);
                        }
                    } else {
                        // check if page is Fault
                        if (pageFault(page, pageTable)) {
                            System.out.printf(" => Page Fault: %s not found!", page);
                            writer.printf(" => Page Fault: %s not found!", page);
                            numberOfPageFaults++; // incerement page fault counter
                            // find optimal page to replace
                            optimalPage = findOptimalPage(referenceString.substring(i, referenceString.length()),
                                    pageTable);
                            pageTable = updatePageTable(optimalPage, pageTable);

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
            System.err.println(err.getClass());
        }
    }

    // HELPER FUNCTIONS //
    // Returns true if there is a page fault, false otherwise
    public static boolean pageFault(String page, Queue<String> pageTable) {
        boolean res = false;
        if (!pageTable.contains(page)) {
            res = true;
        }
        return res;
    }

    // Method returns the most optimal page to replace
    public static String findOptimalPage(String referenceString, Queue<String> pageTable) {
        Queue<String> pageTableCopy = new LinkedList<String>(pageTable);
        String optimalPage = "";
        int optimalPageIndex = 0;
        int tempIndex = 0;
        for (String page : pageTableCopy) {
            if (referenceString.contains(page)) {
                tempIndex = referenceString.indexOf(page);
                if (tempIndex > optimalPageIndex) {
                    optimalPage = page;
                    optimalPageIndex = tempIndex;
                }
            } else {
                return page;
            }
        }
        return optimalPage;
    }

    public static Queue<String> updatePageTable(String page, Queue<String> pageTable) {
        Deque<String> pageTableCopy = new LinkedList<String>(pageTable);
        for (int i = 0; i < pageTableCopy.size(); i++) {
            // check if page from table == page
            if (!page.equals(pageTableCopy.peek())) {
                // remove and push to back of queue
                pageTableCopy.add(pageTableCopy.remove());
            } else {
                // remove matching item form queue
                pageTableCopy.remove();
            }
        }
        // return pageTableCopy;
        return pageTableCopy;
    }
}