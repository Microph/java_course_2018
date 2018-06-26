package harryPotter;

public class Order {
    private BookItem bookItem;
    private double totalPrice;
    private double netPrice;
    private double discount;

    public int getBookAmount() {
        // TODO Auto-generated method stub
        return bookItem.quantity;
    }

    public double getTotalPrice() {
        // TODO Auto-generated method stub
        return totalPrice;
    }

    public double getDiscount() {
        // TODO Auto-generated method stub
        return discount;
    }

    public double getNetPrice() {
        // TODO Auto-generated method stub
        return netPrice;
    }

    public void addItem(BookItem bookItem) {
        // TODO Auto-generated method stub
        this.bookItem = bookItem;
    }

    public void process() {
        // TODO IMPLEMENT THEM
        this.totalPrice = bookItem.getBook().getPrice();
        this.discount = 0;
        this.netPrice = getTotalPrice() - getDiscount();
    }

}
