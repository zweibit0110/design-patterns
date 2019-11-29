package com.deloitte.training.oodesignpatterns.behavioral.visitor;

public class Book implements Item {

    private int price;
    
    private String isbnNumber;
    
    private String name;

    public Book(int price, String isbn, String name) {
        this.price = price;
        this.isbnNumber = isbn;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Book{" + "price=" + price + ", isbnNumber=" + isbnNumber + ", name=" + name + '}';
    }

}
