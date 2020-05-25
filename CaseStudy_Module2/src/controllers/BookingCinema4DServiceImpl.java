package controllers;

import models.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinema4DServiceImpl {
    private static Queue<Customer> customers=new LinkedList<>();

    public static void addBookingCinema(Customer customer) {
        customers.add(customer);
    }

    public static Queue<Customer> getAllBookingCinema() {
        return customers;
    }
}
