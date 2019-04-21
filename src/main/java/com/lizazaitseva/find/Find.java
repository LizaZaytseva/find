package com.lizazaitseva.find;

import java.io.File;

public class Find {
    String filename;
    boolean isSubDirs;

    Find(String filename, boolean isSubDirs) {
        this.filename = filename;
        this.isSubDirs = isSubDirs;
    }

    public void search(String directoryToSearch) {
        File file = new File(directoryToSearch, filename);
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            return;
        } else {
            if (!isSubDirs) {
                System.out.println("File not found :(");
            } else {
                File dir = new File(directoryToSearch);
                File[] dirsAndFiles = dir.listFiles();
                if (dirsAndFiles != null) {
                    for (int i = 0; i < dirsAndFiles.length; i++) {
                        if (dirsAndFiles[i].isDirectory()) {
                            search(dirsAndFiles[i].getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("File not found :(");
                }
            }
        }
    }
}
