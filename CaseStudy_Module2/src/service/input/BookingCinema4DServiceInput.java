package service.input;

import models.Customer;
import service.interfaces.BookingCinema4DService;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinema4DServiceInput implements BookingCinema4DService {
    private static Queue<Customer> customers=new LinkedList<>();
@Override
    public  void addBookingCinema(Customer customer) {
        customers.add(customer);
    }
@Override
    public  Queue<Customer> getAllBookingCinema() {
        return customers;
    }
}
