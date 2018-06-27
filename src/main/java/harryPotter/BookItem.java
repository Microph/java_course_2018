package harryPotter;

public class BookItem {
    Book book; //ชนิดของหนังสือ
    int quantity; //จำนวนที่สั่งซื้อ
    
    public Book getBook() {
        return book;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //law of delimiter
    public String getBookName() {
        return book.getName();
    }
    
    //law of delimiter
    public double getTotalPrice() {
        return book.getPrice() * this.quantity;
    }
    
    public BookItem(Book book, int quantity) throws NotEnoughBooksInStockException {
        if(book.getStock() < quantity) {
            throw new NotEnoughBooksInStockException();
        }
        book.setStock(book.getStock() - quantity);
        this.book = book;
        this.quantity = quantity;
    }

}
