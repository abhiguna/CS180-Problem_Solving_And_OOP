/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class AccessoryMethods {
    public static boolean isPlatformIndependent(ProgrammingLanguage p1) {
        if (p1.getExtension().equals(".java")) {
            return true;
        } else if (p1.getExtension().equals(".py")) {
            return true;
        } else if (p1.getExtension().equals(".c")) {
            return false;
        } else if (p1.getExtension().equals(".cpp")) {
            return false;
        } else {
            System.out.println("Error, invalid language!");
            return false;
        }
    }

    public static String compilerAge(ProgrammingLanguage p1) {
        if (p1.getExtension().equals(".java")) {
            return "2019";
        } else if (p1.getExtension().equals(".py")) {
            return "2019";
        } else if (p1.getExtension().equals(".c")) {
            return "2018";
        } else if (p1.getExtension().equals(".cpp")) {
            return "2017";
        } else {
            return "Invalid";
        }
    }

    public static String identifyLanguage(String filename) {
        if (filename.indexOf(".java") != -1) {
            return "Java";
        } else if (filename.indexOf(".c") != -1) {
            return "C";
        } else if (filename.indexOf(".cpp") != -1) {
            return "C++";
        } else if (filename.indexOf(".py") != -1) {
            return "Python";
        } else {
            return "Unknown Language";
        }
    }
}
