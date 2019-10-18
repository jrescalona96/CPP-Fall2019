import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;

class CSVWriter {
    private File out_file;
    private FileWriter wr;

    public CSVWriter(String path, String name) {
        try {
            File f = new File(path + name + ".csv");
            out_file = f;
        } catch (Exception e) {
            System.err.println(e.getClass());
        }
    }

    public void write(String s) {
        wr = new FileWriter(out_file);
        wr.append("," + s);
        wr.append("\n");
    }

    public void closeWriter(FileWriter wr) {
        wr.close();
    }
}