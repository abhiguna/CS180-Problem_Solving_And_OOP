/**
 *
 *
 * @author Abhishek Gunasekar
 *
 *
 *
 */

import java.sql.SQLOutput;
//import java.util.*;
import java.lang.Math;
import java.util.Scanner;

public class BusinessCard {

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = userInput.nextLine();
        System.out.print("Enter your Year of Birth: ");
        int yOfBirth = userInput.nextInt();
        System.out.print("Enter your GPA: ");
        double gpa = userInput.nextDouble();
        userInput.nextLine();
        System.out.print("Enter your Major: ");
        String majorOfStudent = userInput.nextLine();
        System.out.print("Enter your Email: ");
        String email = userInput.nextLine();
        int age = 2019 - yOfBirth;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Name:  " + name);
        System.out.println("Age:   " + age );
        System.out.printf("GPA:   %.2f", gpa);
        System.out.println();
        System.out.println("Major: " + majorOfStudent);
        System.out.println("Email: " + email);
     }
}
