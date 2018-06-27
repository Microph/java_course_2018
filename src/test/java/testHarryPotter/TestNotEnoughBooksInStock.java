package testHarryPotter;

import static org.junit.Assert.fail;

import org.junit.Test;

import harryPotter.Book;
import harryPotter.BookItem;
import harryPotter.NotEnoughBooksInStockException;

public class TestNotEnoughBooksInStock {

    @Test
    public void test() {
        Book book1 = new Book("H1", 8, 1);
        BookItem bookItem1;
        try {
            bookItem1 = new BookItem(book1, 2);
        } catch (NotEnoughBooksInStockException e) {
            // TODO Auto-generated catch block
            return;
        }
        fail("Should not be here!");
    }

}
