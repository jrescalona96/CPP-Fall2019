import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class OptimalPageReplacement {
    public static void main(String[] args) {
        
        try {
            // DECLARATIONS //
            int pageFrameSize = Integer.parseInt(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(new File("reference_strings_" + pageFrameSize +".txt")));
            String referenceString = "";
            String page = new String();
            Queue<String> pageTable;
            int numberOfPageFault = 0;

            // TRAVERSE FILE //
            while(reader.readLine() != null) {
                // INITIALIZATIONS //
                pageTable = new LinkedList<String>();
                pageFrameSize = Integer.parseInt(reader.readLine()); // Page Frame
                reader.readLine(); // Skip header text
                referenceString = reader.readLine(); // Read reference String

                System.out.printf("\nPage Frame size: %d\n",  pageFrameSize);
                // START JOB //
                for (int i = 0; i < referenceString.length(); i++) {
                    System.out.printf("\nRemaining String: %s", referenceString.substring(i, referenceString.length()));
                    // read next page
                    page = String.valueOf(referenceString.charAt(i));
                    
                    if(pageTable.size() < pageFrameSize) {
                        //initialize pageTable
                        pageTable.add(page); 
                    } else {
                        // check if page is Fault
                        if(pageFault(page, pageTable)) {
                            // upadate page table
                            numberOfPageFault++; //incerement page fault counter
                            System.out.printf("\nFault: %s\n", page);
                            pageTable.remove(); //remove oldest page
                            pageTable.add(page); //add new page
                        } else {
                            // everytime there is a page hit, move that element to end of queue
                            pageTable = updatePageTable(page, pageTable);
                        }
                    }
                    // print current page table //
                    printPageTable(pageTable);
                }
            }
            reader.close();
            System.out.println("\nAll jobs Done!");

        } catch (Exception err) {
            System.err.println(err.getClass());
        }
    }

    // HELPER FUNCTIONS //

    // Returns true if there is a page fault, false otherwise
    public static boolean pageFault(String page, Queue<String> pageTable) {
        boolean res = false;
        if(!pageTable.contains(page)) {
            res = true;
        }
        return res;
    }
    
    // Method returns a new Queue with the latest accessed page at the end
    public static Queue<String> updatePageTable(String page, Queue<String> pageTable) {
        Queue<String> tableQueue = new LinkedList<String>(pageTable);
        Stack<String> tempStack = new Stack<String>();
        while(!tableQueue.isEmpty()) {
            // check if current table page == to page
            if(page != tableQueue.peek()) {
                // remove and store to stack
                tempStack.push(tableQueue.remove());
            } else {
                // remove matching item form queue
                tableQueue.remove();
            }
        }

        // add all elements of tempStack to tableQueue
        for (int i = 0; i < tempStack.size(); i++) {
            tableQueue.add(tempStack.pop());
        }
        //add page to end of queue
        tableQueue.add(page);

        return tableQueue;
    }

    //generic method to print Queue
    public static <T> void printPageTable(Queue<T> queue) {
        Queue<T> temp = new LinkedList<T>(queue);
        System.out.println();
        while(temp.size() > 0) {
            System.out.print(temp.remove() + " | ");
        }
        System.out.println();
    }
}