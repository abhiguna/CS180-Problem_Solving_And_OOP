

import java.util.*;
public class Fibonacci {
    /**
     *
     * @author Abhishek Gunasekar
     * @param args
     */
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String finalDecision;
            System.out.println("Welcome to Fibonacci Sequencer");
            System.out.println();
        do{
            System.out.println("Enter an Option:");
            System.out.println("A for Sequence");
            System.out.println("B for Matrix");
            System.out.println("C for Fibonacci string");
            String option = userInput.nextLine();
            if(option.equalsIgnoreCase("A")){
                System.out.println("Enter 0 to exit");
                System.out.println("Enter Sequence:");
                int num = userInput.nextInt();
                while(num > 0){
                    System.out.println(fibonacciSequence(num));
                    num = userInput.nextInt();
                    userInput.nextLine();
                }
            }else if(option.equalsIgnoreCase("B")){
                System.out.println("Enter Dimensions:");
                String entireString = userInput.nextLine();
                int r = Integer.parseInt((entireString.substring(0, entireString.indexOf(" ")))); //https://www.javatpoint.com/java-char-to-int
                int c = Integer.parseInt((entireString.substring(entireString.indexOf(" ") + 1)));
                fibonacciMatrix(r, c);

            }else if(option.equalsIgnoreCase("C")){
                System.out.println("Enter Fibonacci String:");
                String fibString = userInput.nextLine();
                fibonacciString(fibString);
            }else{
                System.out.println("Input not valid");
            }
            System.out.println("Press Y to run again");
            finalDecision = userInput.nextLine();
        }while(finalDecision.equalsIgnoreCase("y"));
        while(!finalDecision.equalsIgnoreCase("Y")){
            System.out.println("Thank you using Fibonacci Sequencer");
            finalDecision = "y";
        }
    }
    public static int fibonacciSequence(int position){
        int[] sequence = new int[1000];
        sequence[0] = 0;
        sequence[1] = 1;
        for(int i = 2; i < 1000; i++){
            sequence[i] = sequence[i-1] + sequence[i-2];
        }
        return sequence[position];
    }
    public static void fibonacciMatrix(int row, int col){
       // System.out.println("row = " + row + " col = " + col);
        int[] sequence = new int[1000];
        sequence[0] = 1;
        sequence[1] = 1;
        for(int i = 2; i < 1000; i++){
            sequence[i] = sequence[i-1] + sequence[i-2];
            //System.out.println(sequence[i]);
        }
        int[][] grid = new int[row][col];
        for(int is = 0; is <row; is++){
            for(int j = 0; j < col; j++){
                grid[is][j] = sequence[j + row*is];
            }
        }
        for(int k = 0; k < row; k++){
            for(int l = 0; l < col; l++){
                if(l < col - 1){
                    System.out.print(grid[k][l] + " ");
                }else{
                    System.out.print(grid[k][l] + " \n");
                }

            }
        }

    }
    public static void fibonacciString(String fString){
        String reverseString = "";
        for(int i = fString.length() - 1; i >= 0; i--){
            reverseString+=fString.charAt(i);
        }
        String negString = "";
        for(int j = 0; j < reverseString.length(); j++){
            if(reverseString.charAt(j) == '0'){
                negString+="1";
            }else{
                negString+="0";
            }
        }
        System.out.println(negString);
    }
}
