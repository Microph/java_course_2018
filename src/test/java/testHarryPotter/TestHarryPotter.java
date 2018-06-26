package testHarryPotter;

import static org.junit.Assert.*;

import org.junit.Test;

import harryPotter.Book;

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

}
