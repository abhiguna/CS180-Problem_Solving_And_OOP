/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class Java extends ProgrammingLanguage {
    public Java(String filename) {
        super("Java Virtual Machine (JVM)", ".java", "javac " + filename + " && java "
                + filename.substring(0, filename.length() - 5), "", filename);
    }

    public String toString() {
        return "Java uses the " + getCompiler() + " compiler, and has file extensions with " + getExtension() +
                ". To run the file " + getFilename() + " you would need the following command: " + getRunConfig();
    }

    public void printStrengths() {
        System.out.println("Java is a general purpose object-oriented language, " +
                "making it well suited for most general development.");
    }

    public void printWeaknesses() {
        System.out.println("Because Java is run on a virtual machine, it can be slower than other languages.");
    }

    public boolean isObjectOriented() {
        return true;
    }
}
