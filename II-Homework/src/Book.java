import java.util.*;
/**
 * Program Name
 *
 * brief description of the program
 *
 * a list of your sources of help (if any)
 *
 * @author Abhishek Gunasekar, CS 180 Black
 * @version 09/24/19
 *
 */
public class Book {
    private String name;
    private int bookISBN;
    private double[] prices;
    private String author;

    public Book(String name, int bookISBN, double[] prices, String author) {
        this.name = name;
        this.bookISBN = bookISBN;
        this.prices = prices;
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public int getBookISBN() {
        return bookISBN;
    }
    public String getAuthor() {
        return author;
    }
    public double getLowestPrice() {
        double lowPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowPrice) {
                lowPrice = prices[i];
            }
        }
        return lowPrice;
    }
    public String toString() {
        return "Book: " + name + " " + bookISBN + " " + author + " " + this.getLowestPrice();
    }
}
