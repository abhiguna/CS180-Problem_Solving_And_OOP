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
public class Bookstore {
    private double row;
    private double col;
    private Book[][][] bookshelf;

    public Bookstore(int row, int col, Book[] books) {
        this.row = row;
        this.col = col;
        bookshelf = new Book[10][row][col];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < row; j++) {
                for (int z = 0; z < col; z++) {
                    int index = ((row) * j) + z + ((row)* (col) * i);
                    if (index <= books.length - 1) {
                        bookshelf[i][j][z] = books[index];
                    } else {
                        break;
                    }

                }
            }
        }

    }
    public String lookUpName(String name) {
        for (int i = 0; i < bookshelf.length; i++) {
            for (int j = 0; j < bookshelf[i].length; j++) {
                for (int z = 0; z < bookshelf[i][j].length; z++) {
                    Book tempBook = bookshelf[i][j][z];
                    if ((tempBook).getName().equals(name)) {
                        return "Book: " + tempBook.getName() + " " + tempBook.getBookISBN() + " " +
                                tempBook.getAuthor() + " " + tempBook.getLowestPrice();
                    }
                }
            }
        }
        return "";
    }
    public String lookUpBookISBN(int bookISBN) {
        for (int i = 0; i < bookshelf.length; i++) {
            for (int j = 0; j < bookshelf[i].length; j++) {
                for (int z = 0; z < bookshelf[i][j].length; z++) {
                    Book tempBook = bookshelf[i][j][z];
                    if ((tempBook).getBookISBN() == (bookISBN)) {
                        return "Book: " + tempBook.getName() + " " + tempBook.getBookISBN() + " " +
                                tempBook.getAuthor() + " " + tempBook.getLowestPrice();
                    }
                }
            }
        }
        return "";
    }
    public Book[][][] getBookshelf() {
        return bookshelf;
    }

}
