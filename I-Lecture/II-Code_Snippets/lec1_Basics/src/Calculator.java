import java.util.*;

public class Calculator {
    int x;
    int y;
    public Calculator(int givenX, int givenY) {
        this.x = givenX;
        this.y = givenY;
    }

    int add() {
        return this.x + this.y;
    }

    public static void main(String[] args) {
        Calculator newCalc = new Calculator(3,2);
        System.out.printf("Sum is %d", newCalc.add());
    }

}
