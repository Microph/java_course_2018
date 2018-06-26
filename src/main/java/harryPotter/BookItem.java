package harryPotter;

public class BookItem {
    Book book;
    public Book getBook() {
        return book;
    }

    int quantity;
    
    public BookItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

}
