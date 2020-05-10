/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class Python extends ProgrammingLanguage {
    public Python(String filename) {
        super("Python Virtual Machine (PVM)", ".py",
                "python " + filename, "", filename);
    }

    public String toString() {
        return "The standard version of Python uses the " + getCompiler() +
                " compiler. All versions of Python have file extensions with " + getExtension() +
                ". To run the file " + getFilename() + " you would need the following command: " + getRunConfig();
    }

    public void printStrengths() {
        System.out.println("Python has simple syntax and is easily extensible.");
    }

    public void printWeaknesses() {
        System.out.println("Python is slower than other languages and not suited for mobile development.");
    }

    public boolean isObjectOriented() {
        return true;
    }
}
