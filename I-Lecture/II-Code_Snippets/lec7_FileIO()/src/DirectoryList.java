import java.util.*;
import java.io.*;

public class DirectoryList {
    // proxy method to setup recursion...
    ArrayList<File> directoryList(File root) {
        ArrayList<File> list = new ArrayList<File>();
        return directoryList(list, root);
    }

    // recursive method to walk the directory tree (preorder traversal)
    ArrayList<File> directoryList(ArrayList<File> list, File root) {
        list.add(root);
        if (root.isDirectory()) {
            for (File f : root.listFiles()) {
                directoryList(list, f);
            }
        }
        return list;
    }
}
