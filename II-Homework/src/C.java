/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class C extends ProgrammingLanguage {
    public C(String filename) {
        super("gcc", ".c", "gcc -o " + filename.substring(0, filename.length() - 2) + " "
                + filename + " && ./" + filename.substring(0, filename.length() - 2), "-o", filename);
    }

    public String toString() {
        return "C uses the " + getCompiler() + " compiler, has file extensions with " + getExtension() +
                " and to run the file " + getFilename() + " you would need the following command: " + getRunConfig();
    }

    public void printStrengths() {
        System.out.println("C is a small language and provides programmers with low-level control.");
    }

    public void printWeaknesses() {
        System.out.println("C allows programmers to perform potentially dangerous actions with few checks.");
    }

    public boolean isObjectOriented() {
        return false;
    }
}
