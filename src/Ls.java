
import java.io.PrintWriter;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class Ls implements Commands{
    
    Directory currentDir;
    PrintWriter writer;
    
    public Ls(Directory currentDir, PrintWriter writer){
        this.currentDir = currentDir;
        this.writer = writer;
    }

    @Override
    public void execute() {
        
        Collections.sort(currentDir.Docs);
        for(int i = 0; i < currentDir.Docs.size(); i++){
            writer.println(currentDir.Docs.get(i).docName);
        }
    }
    
}
