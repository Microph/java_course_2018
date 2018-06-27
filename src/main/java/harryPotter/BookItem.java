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
    
    public BookItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
    
    //law of delimiter
    public double getTotalPrice() {
        return book.getPrice() * this.quantity;
    }

}
