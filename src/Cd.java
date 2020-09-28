/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class Cd implements Commands {

    String path;
    Directory currentDir;

    public Cd(String path, Directory currentDir) {
        this.path = path;
        this.currentDir = currentDir;
    }

    @Override
    public void execute() {
        String[] dirs = path.split("/");
        for (int j = 1; j < dirs.length; j++) {
            if (dirs[j].equals("..")) {
                currentDir = currentDir.parentDir;
            } else if (!dirs[j].equals(".")) {
                int ok = 0;
                for (int i = 0; i < currentDir.Docs.size(); i++) {
                    if (currentDir.Docs.get(i).docName.equals(dirs[j])) {
                        currentDir = (Directory) currentDir.Docs.get(i);
                        ok = 1;
                    }
                }
                if (ok == 0) {
                    System.err.println("cd: " + path + ": No such directory");
                }
            }
        }
    }
}
