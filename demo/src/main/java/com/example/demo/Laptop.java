package com.example.demo;

public class Laptop {
    private int id;

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    private double price;

    public Laptop() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
