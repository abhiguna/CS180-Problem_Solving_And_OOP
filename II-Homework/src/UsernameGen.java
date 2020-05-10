/**
 * @type    Homework #2
 *
 * @version 09/3/19
 *
 * @Author Abhishek Gunasekar
 */
import java.util.*;
public class UsernameGen{
    public static void main(String[] args){
        System.out.println("What is your full name?");
        Scanner userInput = new Scanner(System.in);
        String fullName = userInput.nextLine();
        System.out.println("What is your birth year?");
        int birthYear = userInput.nextInt();
        int age = 2019 - birthYear;
        fullName = fullName.toLowerCase();
        String userName = fullName.charAt(0) + (fullName.substring(fullName.indexOf(" ") + 1)) + age;
        System.out.println("Your username is " + userName);
    }

}


