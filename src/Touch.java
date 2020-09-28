/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ioanar
 */
public class Touch implements Commands {

    String path;
    Directory dir;

    public Touch(String path, Directory dir) {
        this.path = path;
        this.dir = dir;
    }

    @Override
    public void execute() {

        String[] dirs = path.split("/");
        for (int j = 1; j < dirs.length - 1; j++) {
            if (dirs[j].equals("..")) {
                dir = dir.parentDir;
            } else if (!dirs[j].equals(".")) {
                int ok = 0;
                for (int i = 0; i < dir.Docs.size(); i++) {

                    if (dir.Docs.get(i).docName.equals(dirs[j])) {
                        dir = (Directory) dir.Docs.get(i);
                        ok = 1;
                    }
                }
                if (ok == 0) {
                    System.err.println("mkdir: " + path + ": No such directory");
                }
            }
        }

        for (int i = 0; i < dir.Docs.size(); i++) {
            if (dir.Docs.get(i).docName.equals(dirs[dirs.length - 1])) {
                System.err.println("mkdir: cannot create directory " + path + ": Node exists");
            }
        }
        Document newDoc = new Document(dirs[dirs.length - 1], dir);
        dir.Docs.add(newDoc);
    }

}
