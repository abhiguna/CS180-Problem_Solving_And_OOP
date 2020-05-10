import java.util.*;

public class FileExtensions {
    String findExtension(String filename) {
        int dot_location;

        if ((filename == null) || (filename.indexOf('.') == -1)) {
            return "";
        }

        dot_location = filename.indexOf('.');

        String extension = "";
        extension = filename.substring(dot_location, filename.length());
        return extension;
    }
}
