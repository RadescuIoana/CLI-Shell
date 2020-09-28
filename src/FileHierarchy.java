/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class FileHierarchy implements Comparable{
    
    String docName;
    Directory parentDir;
    
    public FileHierarchy(){
        
    }
    
    public FileHierarchy(String docName, Directory parentDir) {
        this.docName = docName;
        this.parentDir = parentDir;
    }
    
      @Override
    public int compareTo(Object o) {
        return docName.compareTo(((FileHierarchy) o).docName);
    }
}
