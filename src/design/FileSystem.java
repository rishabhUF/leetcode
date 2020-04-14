package design;

import java.io.File;

public class FileSystem {

    public static void main(String[] args) {
        String maindirpath = "C:\\Users\\Gaurav Miglani\\Desktop\\Test";
        File file = new File(maindirpath);

        if(file.exists() && file.isDirectory()) {
            FileSystem.getFiles(file.listFiles(), 0, 0);
        }

    }

    private static void getFiles(File[] file, int index, int level) {
        if(index == file.length)
            return;

        for(int i = 0; i < level; i++) {
            System.out.println("\t");
        }

        if(file[index].isFile()) {
            System.out.println("[" + file[index].getName() + "]");
        }

        if(file[index].isDirectory()) {
            System.out.println("[" + file[index].getName() + "]");
            getFiles(file[index].listFiles(), 0, 0);
        }

        getFiles(file, ++index, level+1);
    }
}
