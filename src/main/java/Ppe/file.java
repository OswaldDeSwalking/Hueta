package Ppe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class file {
    PrintStream createFile() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("Ppe");
        PrintStream printStream = new PrintStream(fos);
        return printStream;
    }
}
