
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        // TODO code application logic here

        // Open the file that is the first command line parameter
        FileInputStream fstream = new FileInputStream(args[0]);
        try { // Get the object of DataInputStream
            DataInputStream in;
            in = new DataInputStream(fstream);

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(in));
            File file = new File(args[1]);
            file.createNewFile();

            PrintWriter writer;
            writer = new PrintWriter(new FileOutputStream(file, true));

            File fErrors = new File(args[2]);
            fErrors.createNewFile();
            PrintStream error = new PrintStream(fErrors);
            System.setErr(error);

            Directory root = new Directory("/", null);
            Directory currentDir = root;

            String line;
            while ((line = br.readLine()) != null) {
                String[] val = line.split(" ");

                if (val[0].equals("ls")) {
                    
                    Ls ls=new Ls(currentDir,writer);
                    ls.execute();
                    
                } else if (val[0].equals("pwd")) {

                    Pwd pwd = new Pwd(currentDir, writer);
                    pwd.execute();

                } else if (val[0].equals("cd")) {
                    
                    Directory dir;
                    if (val[1].charAt(0) == '/') {
                        dir = root;
                    } else {
                        dir = currentDir;
                    }
                    
                    Cd cd = new Cd(val[1], dir);
                    cd.execute();
                    currentDir = cd.currentDir;

                } else if (val[0].equals("cp")) {

                } else if (val[0].equals("mv")) {

                } else if (val[0].equals("rm")) {
                    
                      FileHierarchy dir;
                    if (val[1].charAt(0) == '/') {
                        dir = root;
                    } else {
                        dir = currentDir;
                    }
                    
                    Rm rm = new Rm(val[1], dir);
                    rm.execute();

                } else if (val[0].equals("touch")) {

                    Directory dir;
                    if (val[1].charAt(0) == '/') {
                        dir = root;
                    } else {
                        dir = currentDir;
                    }

                    Touch touch = new Touch(val[1], dir);
                    touch.execute();

                } else if (val[0].equals("mkdir")) {

                    Directory dir;
                    if (val[1].charAt(0) == '/') {
                        dir = root;
                    } else {
                        dir = currentDir;
                    }

                    Mkdir mkdir = new Mkdir(val[1], dir);
                    mkdir.execute();
                }
            }

            writer.close();
        } catch (IOException e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

}
