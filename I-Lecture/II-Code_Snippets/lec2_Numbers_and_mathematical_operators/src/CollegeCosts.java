import java.util.Scanner;

public class CollegeCosts {
    public static void main(String[] args) {
        Scanner in;

        //Input Variables
        String firstName, lastName;
        double semesterTuition, monthlyRent, monthlyFood;
        double annualInterest;
        int years;

        //computed variables
        double yearlyCost, fourYearCost, monthlyInterest;
        double monthlyPayment, totalLoanCost;

        System.out.printf("Welcome to the College Cost Calculator!\n");
        in = new Scanner(System.in);

        //Prompt for input values...
        System.out.printf("Enter your first name: ");
        firstName = in.next();
        System.out.printf("Enter your last name: ");
        lastName = in.next();
        System.out.printf("Enter tuition per semester: $");
        semesterTuition = in.nextDouble();
        System.out.printf("Enter rent per month: $");
        monthlyRent = in.nextDouble();
        System.out.printf("Enter food cost per month: $");
        monthlyFood = in.nextDouble();
        System.out.printf("Annual interest rate: ");
        annualInterest = in.nextDouble();
        System.out.printf("Years to pay back your loan: ");
        years = in.nextInt();

        // compute results...
        yearlyCost = semesterTuition * 2.0 + (monthlyRent + monthlyFood) * 12.0;
        fourYearCost = yearlyCost * 4.0;
        monthlyInterest = annualInterest / 12.0;
        monthlyPayment = fourYearCost * monthlyInterest / (1.0 - Math.pow(1.0 + monthlyInterest, -years * 12.0));
        totalLoanCost = monthlyPayment * 12.0 * years;

        // Print results...
        System.out.printf("\n");
        System.out.printf("College costs for %s %s\n",
                            firstName, lastName);
        System.out.printf("********************\n");
        System.out.printf("Yearly cost:     $%10.2f\n", yearlyCost);
        System.out.printf("Four year cost:     $%10.2f\n", fourYearCost);
        System.out.printf("Monthly loan payment:     $%10.2f\n", monthlyPayment);
        System.out.printf("Total loan cost:     $%10.2f\n", totalLoanCost);
    }

}
