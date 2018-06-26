package harryPotter;

public class BookBuilder {
    private String name;
    private double price;
    private int stock;
    
    public BookBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    public BookBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    
    public BookBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }
    
    public Book build() {
        return new Book(name, price, stock);
    }
}
