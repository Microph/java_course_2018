package harryPotter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private List<BookItem> bookItemList = new ArrayList<BookItem>(); //bookItem เป็น data structure แสดงหนังสือทั้งหมดที่คนๆ นึงสั่งซื้อ
    private int bookAmount; //ได้หลัง process
    private double totalPrice; //ได้หลัง process
    private double netPrice; //ได้หลัง process
    private double discount; //ได้หลัง process

    public int getBookAmount() {
        // TODO Auto-generated method stub
        return bookAmount;
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
        for (BookItem previousBookItem : this.bookItemList) {
            if(previousBookItem.getBookName().equals(bookItem.getBookName())) {
                previousBookItem.setQuantity(previousBookItem.getQuantity() + bookItem.getQuantity());
                return;
            }
        }
        this.bookItemList.add(bookItem);
    }

    public void process() {
        //calculate book amount
        this.bookAmount = 0;
        for (BookItem aBookItem : bookItemList) {
            this.bookAmount += aBookItem.getQuantity();
        }
        
        //calculate total price
        this.totalPrice = 0;
        for (BookItem bookItem : bookItemList) {
            this.totalPrice += bookItem.getTotalPrice();
        }
        
        //calculate best discount possible
        this.discount = calculateBestDiscount();
        
        //calculate net price
        this.netPrice = this.totalPrice - this.discount;
    }

    public double calculateBestDiscount() {
        //arrange books into new structure
        List<BookPackForDiscountCalculation> bookPacksForDiscountCalculation = new ArrayList<>();
        while(hasBooksLeft()) {
            BookPackForDiscountCalculation tempBookPack = new BookPackForDiscountCalculation();
            for (BookItem bookItem : bookItemList) {
                if(bookItem.getQuantity() > 0) {
                    bookItem.setQuantity(bookItem.getQuantity() - 1);
                    tempBookPack.addBook(bookItem.getBook());
                }
            }
            bookPacksForDiscountCalculation.add(tempBookPack);
        }
        
        //try to change any 5-3 pair to 4-4 pair
        List<BookPackForDiscountCalculation> threeBookPacks = new ArrayList<>();
        List<BookPackForDiscountCalculation> fiveBookPacks = new ArrayList<>();
        for(BookPackForDiscountCalculation bookPack : bookPacksForDiscountCalculation) {
            if(bookPack.getBookListSize() == 3) {
                threeBookPacks.add(bookPack);
            }
            else if(bookPack.getBookListSize() == 5) {
                fiveBookPacks.add(bookPack);
            }
        }
        
        for(BookPackForDiscountCalculation packToBeAdded : threeBookPacks) {
            if(fiveBookPacks.isEmpty()) {
                break;
            }
            
            BookPackForDiscountCalculation packToBeRemoved = fiveBookPacks.get(0);
            fiveBookPacks.remove(packToBeRemoved);
            for (Book bookFromFivePack : packToBeRemoved.getBookList()) {
                if(!packToBeAdded.getBookList().contains(bookFromFivePack)) {
                    packToBeRemoved.getBookList().remove(bookFromFivePack);
                    packToBeAdded.getBookList().add(bookFromFivePack);
                    break;
                }
            }
        }

        double totalDiscount = 0;
        for (BookPackForDiscountCalculation pack : bookPacksForDiscountCalculation) {
            totalDiscount += pack.getDiscount();
            //Debug print packagings
            /*for (Book book : pack.getBookList()) {
                System.out.print(book.getName() + ", ");
            }
            System.out.println();*/
        }

        return totalDiscount;
    }
    
    private boolean hasBooksLeft() {
        for (BookItem bookItem : bookItemList) {
            if(bookItem.getQuantity() > 0)
                return true;
        }
        return false;
    }

}
