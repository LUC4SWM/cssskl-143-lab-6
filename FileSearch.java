import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch{

    public static String searchFiles(File path, String target) {
        // TODO
        List<File> directoriesToExamine = new ArrayList<>();
        directoriesToExamine.add(path);

        while (!directoriesToExamine.isEmpty()) {
            File directory = directoriesToExamine.removeFirst();
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        directoriesToExamine.add(file);
                    } else {
                        if (file.getName().equals(target)) {
                            return file.getAbsolutePath();
                        }
                    }
                }
            }
        }
        return "File not found.";
    }

   public static String recursiveSearch(File path, String target) {
// TODO
       File[] files = path.listFiles();
       if (files != null) {
           for (File f : files) {
               if (f.isDirectory()) {
                   String res = recursiveSearch(f, target);
                   if (!res.equals("File not FOUND!")) {
                       return res;
                   }
               } else {
                   if (path.isFile() && path.getName().equals(target)) {
                       return path.getAbsolutePath();
                   }
               }
           }
       }
       return "Not found.";
   }
public static void main(String[] args) {
    System.out.println("Result: " + searchFiles(new File("c:\\"), "hw3.zip"));
    System.out.println("Result: " + recursiveSearch(new File("c:\\"), "hw3.zip"));
}
}
