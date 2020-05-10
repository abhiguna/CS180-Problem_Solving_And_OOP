public class BookClient {
    public static void main(String[] args){
        double[] prices = {1.0,2.0,3.0};
        Book[] books = {new Book("A", 1, prices, "Abhi"), new Book("B", 1, prices, "Abhi"), new Book("C", 1, prices, "Abhi"),new Book("D", 1, prices, "Abhi"),new Book("E", 1, prices, "Abhi"),new Book("F", 1, prices, "Abhi"),new Book("G", 1, prices, "Abhi"),new Book("H", 1, prices, "Abhi"),new Book("I", 1, prices, "Abhi"),new Book("J", 1, prices, "Abhi")};
        Bookstore shelf = new Bookstore(3,3,books);
        System.out.println(shelf.lookUpName("B"));
    }
}
