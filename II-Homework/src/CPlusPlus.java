/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class CPlusPlus extends ProgrammingLanguage {
    public CPlusPlus(String filename) {
        super("g++", ".cpp", "g++ -o " + filename.substring(0, filename.length() - 4) +
                " " + filename + " && ./" + filename.substring(0, filename.length() - 4), "-o", filename);
    }

    public String toString() {
        return "One of the compilers C++ uses is the " + getCompiler() + " compiler. It has file extensions with "
                + getExtension() + ". To run the file " + getFilename() + " you would need the following command: "
                + getRunConfig();
    }

    public void printStrengths() {
        System.out.println("C++ brings together low-level management with high-level object-oriented features.");
    }

    public void printWeaknesses() {
        System.out.println("C++ is a large, complex language and requires manual memory management.");
    }

    public boolean isObjectOriented() {
        return true;
    }
}
