package harryPotter;

import java.util.List;
import java.util.ArrayList;

public class BookPackForDiscountCalculation {
    private List<Book> bookList = new ArrayList<>();
    
    public void addBook(Book book) {
        bookList.add(book);
    }
    
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    
    public List<Book> getBookList() {
        return bookList;
    }
    
    public int getBookListSize() {
        return bookList.size();
    }

    public double getDiscount() {
        double totalPrice = 0;
        for (Book book : bookList) {
            totalPrice += book.getPrice();
        }
        
        double discountPercentage = 0;
        switch(bookList.size()) {
        case 2: discountPercentage = 0.05; break;
        case 3: discountPercentage = 0.10; break;
        case 4: discountPercentage = 0.20; break;
        case 5: discountPercentage = 0.25; break;
        default: discountPercentage = 0; 
        }
        
        return totalPrice * discountPercentage;
    }
}
