public class Counter {
    int x;
    static int y; //Static Variables - One memory location shared by all instances

    public static void main(String[] args) {
        Counter alice = new Counter();
        Counter bob = new Counter();

        alice.x = 10; alice.y = 42;

        bob.x = 50; bob.y = 99;

        System.out.println(alice.x);
        System.out.println(alice.y);
        System.out.println(bob.x);
        System.out.println(bob.y);

        alice.y++;

        System.out.println(alice.y);
        System.out.println(bob.y);

        bob.y++;

        System.out.println(alice.y);
        System.out.println(bob.y);
    }
}