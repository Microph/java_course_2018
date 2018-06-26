package harryPotter;

public class Book {
    private String name;
    private double price;
    public double getPrice() {
        return price;
    }

    private int stock;
    
    public Book(String name, double price, int stock) {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static Book CreateHarryPotter1() {
        // TODO Auto-generated method stub
        return new Book("H1", 8, 2);
    }

    public static Book CreateHarryPotter2() {
        // TODO Auto-generated method stub
        return new Book("H2", 8, 2);
    }
}
