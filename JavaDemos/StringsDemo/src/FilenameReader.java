// Demo code to demonstrate implementation of string methods

import java.util.Scanner;

public class FilenameReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Paste file path here: ");
        final String fPath = sc.nextLine();

        char sep;
        if (fPath.contains("/"))
            // UNIX users typical separator
            sep = '/';
        else
            // Windows users typical separator
            sep = '\\';

        char ext = '.';

        FilenameReader myHomePage = new FilenameReader(fPath, sep, ext);

        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());
    }
    private final String fullPath;
    private final char pathSeparator, extensionSeparator;

    public FilenameReader(String str, char sep, char ext) {
        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;
    }

    public String extension() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        return fullPath.substring(dot + 1);
    }

    public String filename() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(sep + 1, dot);
    }

    public String path() {
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(0, sep);
    }
}
