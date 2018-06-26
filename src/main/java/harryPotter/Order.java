package harryPotter;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<BookItem> bookItemList = new ArrayList<BookItem>();
    private double totalPrice;
    private double netPrice;
    private double discount;

    public int getBookAmount() {
        // TODO Auto-generated method stub
        int amount = 0;
        for (BookItem aBookItem : bookItemList) {
            amount += aBookItem.getQuantity();
        }
        
        return amount;
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
        this.bookItemList.add(bookItem);
    }

    public void process() {
        double tempTotalPrice = 0;
        for (BookItem bookItem : bookItemList) {
            tempTotalPrice += bookItem.getBook().getPrice();
        }
        this.totalPrice = tempTotalPrice;
        
        // TODO Implement discount calculation
        this.discount = 0;
        
        this.netPrice = getTotalPrice() - getDiscount();
    }

}
