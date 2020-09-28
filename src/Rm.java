/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class Rm implements Commands {

    String path;
    FileHierarchy currentDir;

    public Rm(String path, FileHierarchy currentDir) {
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
                if (currentDir instanceof Directory) {
                    for (int i = 0; i < ((Directory) currentDir).Docs.size(); i++) {
                        if (((Directory) currentDir).Docs.get(i).docName.equals(dirs[j])) {
                            currentDir = ((Directory) currentDir).Docs.get(i);
                            ok = 1;
                            break;
                        }
                    }
                }
                if (ok == 0) {
                    System.err.println("rm: " + path + ": No such file or directory");
                    break;
                }
            }
        }
        currentDir.parentDir.Docs.remove(currentDir);
    }

}
