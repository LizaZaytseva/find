package com.lizazaitseva.find;

/**
 * Поиск файла с заданным в командной строке именем в указанной ключом -d директории,
 * по умолчанию в текущей директории.
 * Ключ -r указывает на необходимость поиска также во всех поддиректориях.
 * <p>
 * Command Line: find [-r] [-d directory] filename.txt
 * <p>
 * Кроме самой программы, следует написать автоматические тесты к ней.
 */

public class Main {
    public static void main(String[] args) {
        String directoryToSearch = "";
        String filename = "";
        boolean isSubDirs = false;

        if (args.length == 0) {
            soutHelp();
            return;
        } else {
            if (checkIsNotKey(args[args.length - 1])) {
                filename = args[args.length - 1];
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-r")) {
                        isSubDirs = true;
                    }
                    if (args[i].equals("-d")) {
                        if (checkIsNotKey(args[i + 1]) && !(args[i + 1].equals(filename)))
                            directoryToSearch = args[i + 1];
                        else {
                            System.out.println("Invalid input format:(");
                            soutHelp();
                            return;
                        }
                    }
                }
                Find finder = new Find(filename, isSubDirs);
                finder.search(directoryToSearch);
            } else {
                soutHelp();
                return;
            }
        }
    }

    private static boolean checkIsNotKey(String arg) {
        return !(arg.equals("-r") || arg.equals("-d"));
    }

    private static void soutHelp() {
        System.out.println("Usage: find [-r] [-d directory] filename.txt +\n" +
                "                \"Parameters:" +" \n" +
                "                \"The-r switch indicates that all subdirectories should also be searched" + "\n" +
                "                \"Search for a file with the specified command line name in the specified - d directory");
    }
}

