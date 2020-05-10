/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
import java.util.*;
import java.util.function.DoubleToIntFunction;

public class Driver extends AccessoryMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Input the file you would like to process:");
        String fileName = scanner.nextLine();
        System.out.println("Here is your selected file's language information:");
        System.out.println("-----");
        ProgrammingLanguage p1 = null;
        String language = "";
        if (fileName.indexOf(".java") != -1) {
            p1 = new Java(fileName);
            language = identifyLanguage(fileName);
        } else if (fileName.indexOf(".cpp") != -1) {
            p1 = new CPlusPlus(fileName);
            language = identifyLanguage(fileName);
        } else if (fileName.indexOf(".c") != -1) {
            p1 = new C(fileName);
            language = identifyLanguage(fileName);
        } else if (fileName.indexOf(".py") != -1) {
            p1 = new Python(fileName);
            language = identifyLanguage(fileName);
        } else {
            //ProgrammingLanguage p1 = new ProgrammingLanguage(fileName);
            language = identifyLanguage(fileName);
        }
        if (p1 != null) {
            System.out.println(p1.toString());
            if (isPlatformIndependent(p1)) {
                System.out.println("It is platform independent.");
                System.out.println("The compiler was last updated in " + compilerAge(p1) + ".");
            } else {
                System.out.println("It is not platform independent.");
                System.out.println("The compiler was last updated in " + compilerAge(p1) + ".");
            }
            p1.printStrengths();
            p1.printWeaknesses();
            System.out.println("-----");
        }


    }
}
