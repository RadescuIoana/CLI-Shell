
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ioanar
 */
public class Pwd implements Commands {

    Directory currentDir;
    PrintWriter writer;

    public Pwd(Directory currentDir, PrintWriter writer) {
        this.currentDir = currentDir;
        this.writer = writer;
    }

    @Override
    public void execute() {
        String[] path = new String[100];
        int i = 0;
        if (currentDir.docName.equals("/")) {
            writer.println("/");
        } else {
            while (currentDir.parentDir != null) {
                path[i] = currentDir.docName;
                currentDir = currentDir.parentDir;
                i++;
            }

            for (int j = i-1; j >= 0; j--) {
                
                writer.print("/" + path[j]);
            }
            writer.println();
        }
    }
}
