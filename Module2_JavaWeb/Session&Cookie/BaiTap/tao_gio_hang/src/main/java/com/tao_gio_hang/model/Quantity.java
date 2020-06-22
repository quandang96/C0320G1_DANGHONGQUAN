package com.tao_gio_hang.model;

public class Quantity {
    private int count;

    public Quantity() {
    }

    public Quantity(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }
    public int decrement(){
        return count--;
    }
}
