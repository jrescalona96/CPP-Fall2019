// Least Recently used Page Replacement Algorithm //

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class LRUPageReplacement {
    public static void main(String[] args) {

        try {
            // DECLARATIONS //
            int pageFrameSize = Integer.parseInt(args[0]);
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File("reference_strings_" + pageFrameSize + ".txt")));
            String referenceString = "";
            String page = new String();
            Queue<String> pageTable;
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
                numberOfStrings++;
                System.out.printf("\nPage Frame size: %d\n", pageFrameSize);
                // START JOB //
                for (int i = 0; i < referenceString.length(); i++) {
                    // read next page
                    System.out.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    page = String.valueOf(referenceString.charAt(i));
                    // initialize pageTable
                    if (pageTable.size() < pageFrameSize) {
                        // initialize page table. If page fault, add to page table,else skip.
                        if (pageFault(page, pageTable)) {
                            System.out.printf("\nPage Fault: %s not found!\n", page);
                            numberOfPageFaults++; // incerement page fault counter
                            pageTable.add(page);
                        }
                    } else {
                        // check if page is Fault
                        if (pageFault(page, pageTable)) {
                            numberOfPageFaults++; // incerement page fault counter
                            // upadate page table
                            System.out.printf("\nFault: %s\n", page);
                            pageTable.remove(); // remove oldest page
                            pageTable.add(page); // add new page
                        } else {
                            // everytime there is a page hit, move that element to end of queue
                            pageTable = updatePageTable(page, pageTable);
                        }
                    }
                    // print current page table //
                    // printPageTable(pageTable);
                }
            }
            reader.close();
            average = numberOfPageFaults/numberOfStrings;
            System.err.println("Number of page Faults = " + numberOfPageFaults);
            System.out.printf("%f jobs Done!\n", numberOfStrings);
            System.out.println("Average page faults = " + average);

        } catch (Exception err) {
            System.err.println(err.getClass());
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

    public static Queue<String> updatePageTable(String page, Queue<String> pageTable) {
        Queue<String> pageTableCopy = new LinkedList<String>(pageTable);
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
        pageTableCopy.add(page);
        // return pageTableCopy;
        return pageTableCopy;
    }

    public static void printPageTable(Queue<String> pageTable) {
        Queue<String> temp = new LinkedList<String>(pageTable);
        System.out.println();
        while (temp.size() > 0) {
            System.out.print(temp.remove() + " | ");
        }
        System.out.println();
    }
}