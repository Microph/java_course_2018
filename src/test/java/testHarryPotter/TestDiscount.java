package testHarryPotter;

import static org.junit.Assert.*;

import org.junit.Test;

import harryPotter.Book;
import harryPotter.BookItem;
import harryPotter.Order;

public class TestDiscount {

    @Test
    public void twoGroupOf4IsBetterThan5And3() {
        Book book1 = new Book("H1", 8, 2);
        Book book2 = new Book("H2", 8, 2);
        Book book3 = new Book("H3", 8, 2);
        Book book4 = new Book("H4", 8, 1);
        Book book5 = new Book("H5", 8, 1);
        BookItem bookItem1 = new BookItem(book1, 2);
        BookItem bookItem2 = new BookItem(book2, 2);
        BookItem bookItem3 = new BookItem(book3, 2);
        BookItem bookItem4 = new BookItem(book4, 1);
        BookItem bookItem5 = new BookItem(book5, 1);
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        
        assertEquals(12.8, order.getDiscount(), 0.0);
    }

}
