public class CNClient {
    public static void main(String[] args){
        ComplexNumber complexNumber = new ComplexNumber(1, -1);
        ComplexNumber c2 = new ComplexNumber(2, 2);
        System.out.println(complexNumber.reciprocal());
    }
}
