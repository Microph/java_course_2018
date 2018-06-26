package testHarryPotter;

import static org.junit.Assert.*;

import org.junit.Test;

import harryPotter.Book;
import harryPotter.BookBuilder;
import harryPotter.BookItem;
import harryPotter.Order;

public class TestHarryPotter {

    @Test
    public void test() {
        Book book1 = Book.CreateHarryPotter1();
        Book book2 = Book.CreateHarryPotter2();
    }
    
    @Test
    public void createBookWithConstructor() {
        Book book1 = new Book("H1", 8, 2);
        Book book2 = new Book("H1", 8, 2);
        assertEquals(book1, book2);
    }
    
    @Test
    public void createBookWithBuilder() {
        Book book1 = new BookBuilder()
                            .setName("H1")
                            .setPrice(8d)
                            .setStock(2)
                            .build();
        Book book2 = new Book("H1", 8, 2);
        assertEquals(book1, book2);
    }
    
    @Test
    public void createEmptyOrder() {
        Book book1 = new Book("H1", 8, 2);
        BookItem bookItem = new BookItem(book1, 1);
        Order order = new Order();
        order.addItem(bookItem);
        order.process();
        
        assertEquals(2, order.getBookAmount());
        assertEquals(16, order.getTotalPrice(), 2);
        assertEquals(16 * 0.05, order.getDiscount(), 2);
        assertEquals(16 - (16 * 0.05), order.getNetPrice(), 2);
    }

}