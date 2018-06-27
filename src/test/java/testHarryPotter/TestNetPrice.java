package testHarryPotter;

import static org.junit.Assert.*;

import org.junit.Test;

import harryPotter.Book;
import harryPotter.BookItem;
import harryPotter.NotEnoughBooksInStockException;
import harryPotter.Order;

public class TestNetPrice {
    
    @Test
    public void noDiscounts() {
        Book book1 = new Book("H1", 8, 100);
        Book book2 = new Book("H2", 8, 100);
        Book book3 = new Book("H3", 8, 100);
        Book book4 = new Book("H4", 8, 100);
        Book book5 = new Book("H5", 8, 100);
        BookItem bookItem1;
        BookItem bookItem2;
        BookItem bookItem3;
        BookItem bookItem4;
        BookItem bookItem5;
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(0, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 1);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 1);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 1);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 2);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 2, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 0);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 3);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 3, order.getNetPrice(), 0.0);
    }
    
    @Test
    public void simpleDiscounts() {
        Book book1 = new Book("H1", 8, 100);
        Book book2 = new Book("H2", 8, 100);
        Book book3 = new Book("H3", 8, 100);
        Book book4 = new Book("H4", 8, 100);
        Book book5 = new Book("H5", 8, 100);
        BookItem bookItem1;
        BookItem bookItem2;
        BookItem bookItem3;
        BookItem bookItem4;
        BookItem bookItem5;
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 1);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 0);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 2 * 0.95, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 0);
            bookItem3 = new BookItem(book3, 1);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 0);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 3 * 0.9, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 1);
            bookItem3 = new BookItem(book3, 0);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 1);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 4 * 0.8, order.getNetPrice(), 0.0);
        
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 1);
            bookItem3 = new BookItem(book3, 1);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 1);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        assertEquals(8 * 5 * 0.75, order.getNetPrice(), 0.0);
    }

    @Test
    public void twoGroupOf4IsBetterThan5And3() {
        Book book1 = new Book("H1", 8, 2);
        Book book2 = new Book("H2", 8, 2);
        Book book3 = new Book("H3", 8, 2);
        Book book4 = new Book("H4", 8, 1);
        Book book5 = new Book("H5", 8, 1);
        BookItem bookItem1;
        BookItem bookItem2;
        BookItem bookItem3;
        BookItem bookItem4;
        BookItem bookItem5;
        try {
            bookItem1 = new BookItem(book1, 2);
            bookItem2 = new BookItem(book2, 2);
            bookItem3 = new BookItem(book3, 2);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 1);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        
        assertEquals(51.20, order.getNetPrice(), 0.0);
    }

    
    @Test
    public void trickyCase1() {
        Book book1 = new Book("H1", 8, 10);
        Book book2 = new Book("H2", 8, 10);
        Book book3 = new Book("H3", 8, 10);
        Book book4 = new Book("H4", 8, 10);
        Book book5 = new Book("H5", 8, 10);
        BookItem bookItem1;
        BookItem bookItem2;
        BookItem bookItem3;
        BookItem bookItem4;
        BookItem bookItem5;
        try {
            bookItem1 = new BookItem(book1, 5);
            bookItem2 = new BookItem(book2, 5);
            bookItem3 = new BookItem(book3, 4);
            bookItem4 = new BookItem(book4, 5);
            bookItem5 = new BookItem(book5, 4);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), order.getNetPrice(), 0.0);
    }
    
    @Test
    public void trickyCase2() {
        Book book1 = new Book("H1", 8, 10);
        Book book2 = new Book("H2", 8, 10);
        Book book3 = new Book("H3", 8, 10);
        Book book4 = new Book("H4", 8, 10);
        Book book5 = new Book("H5", 8, 10);
        BookItem bookItem1;
        BookItem bookItem2;
        BookItem bookItem3;
        BookItem bookItem4;
        BookItem bookItem5;
        try {
            bookItem1 = new BookItem(book1, 1);
            bookItem2 = new BookItem(book2, 2);
            bookItem3 = new BookItem(book3, 1);
            bookItem4 = new BookItem(book4, 1);
            bookItem5 = new BookItem(book5, 1);
        } catch (NotEnoughBooksInStockException e) {
            fail("Should not be here!");
            return;
        }
        Order order = new Order();
        order.addItem(bookItem1);
        order.addItem(bookItem2);
        order.addItem(bookItem3);
        order.addItem(bookItem4);
        order.addItem(bookItem5);
        order.process();
        
        assertEquals(8 + (8 * 5 * 0.75), order.getNetPrice(), 0.0);
    }
}
