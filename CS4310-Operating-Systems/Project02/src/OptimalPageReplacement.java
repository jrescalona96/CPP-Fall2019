import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class OptimalPageReplacement {
    public static void main(String[] args) {

        try {
            // DECLARATIONS //
            int pageFrameSize = Integer.parseInt(args[0]);
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File("reference_strings_" + pageFrameSize + ".txt")));
            String referenceString = "";
            String optimalPage = "";
            String page = new String();
            Queue<String> pageTable;
            int numberOfPageFaults = 0;

            // TRAVERSE FILE //
            while (reader.readLine() != null) {
                // INITIALIZATIONS //
                pageTable = new LinkedList<String>();
                pageFrameSize = Integer.parseInt(reader.readLine()); // Page Frame
                reader.readLine(); // Skip header text
                referenceString = reader.readLine(); // Read reference String

                System.out.printf("\nPage Frame size: %d\n", pageFrameSize);
                // START JOB //
                for (int i = 0; i < referenceString.length(); i++) {
                    System.out.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    // read next page
                    page = String.valueOf(referenceString.charAt(i));
                    if (pageTable.size() < pageFrameSize) {
                        // initialize page table
                        if (pageFault(page, pageTable)) {
                            numberOfPageFaults++; // incerement page fault counter
                            System.out.printf("\nPage Fault: %s not found!\n", page);
                            pageTable.add(page);
                        }
                    } else {
                        // check if page is Fault
                        if (pageFault(page, pageTable)) {
                            numberOfPageFaults++; // incerement page fault counter
                            // find optimal page to replace
                            optimalPage = findOptimalPage(referenceString.substring(i, referenceString.length()),
                                    pageTable);
                            pageTable = updatePageTable(optimalPage, pageTable);
                            System.out.printf("\nFault: %s\n", page);
                            pageTable.remove(); // remove latest page to appear
                            pageTable.add(page); // add new page
                        }
                    }
                    // print current page table //
                    printPageTable(pageTable);
                }
            }
            reader.close();
            System.err.println("Number of page Faults = " + numberOfPageFaults);
            System.out.println("\nAll jobs Done!");

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
        pageTableCopy.addFirst(page);
        // check for overflow. happens when there are no more options to choose from at the end of the reference string. 
        if(pageTableCopy.size() > pageTable.size()) {
            pageTableCopy.remove();
        }
        // return pageTableCopy;
        return pageTableCopy;
    }

    // generic method to print Queue
    public static <T> void printPageTable(Queue<T> queue) {
        Queue<T> temp = new LinkedList<T>(queue);
        System.out.println();
        while (temp.size() > 0) {
            System.out.print(temp.remove() + " | ");
        }
        System.out.println();
    }
}