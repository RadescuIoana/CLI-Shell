
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class Directory extends FileHierarchy{
    
    ArrayList<FileHierarchy> Docs = new ArrayList<>();
    
    public Directory(){
    }
    
    public Directory(String docName, Directory parentDir){
        super(docName, parentDir);
    }
}
