package harryPotter;

public class Book {
    private String name; //ชื่อหนังสือ
    private double price; //ราคา ซึ่งเท่ากับ 8 เสมอตามโจทย์
    private int stock; //จำนวนที่มีในร้าน
    
    public double getPrice() {
        return price;
    }
    
    public Book(String name, double price, int stock) {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //NOT USED
    /*public static Book CreateHarryPotter1() {
        // TODO Auto-generated method stub
        return new Book("H1", 8, 2);
    }

    public static Book CreateHarryPotter2() {
        // TODO Auto-generated method stub
        return new Book("H2", 8, 2);
    }*/
}
