package testHarryPotter;

import org.junit.Test;

import harryPotter.Book;
import harryPotter.BookBuilder;

public class TestHarryPotterBookConstructor {

    //NOT USED
    /*@Test
    public void createBookWithMethod() {
        Book book1 = Book.CreateHarryPotter1();
        Book book2 = Book.CreateHarryPotter2();
    }*/
    
    @Test
    public void createBookWithConstructor() {
        Book book1 = new Book("H1", 8, 2);
        Book book2 = new Book("H1", 8, 2);
    }
    
    @Test
    public void createBookWithBuilder() {
        Book book1 = new BookBuilder()
                            .setName("H1")
                            .setPrice(8d)
                            .setStock(2)
                            .build();
        Book book2 = new Book("H1", 8, 2);
    }
    
}
