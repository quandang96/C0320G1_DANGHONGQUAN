package sort;

import models.Customer;

import java.util.Comparator;

public class SortNameCustomer implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getNameCustomer().compareTo(o2.getNameCustomer())==0) {
            int year1 = new Integer(o1.getBirthday().substring(6,10));
            int year2 = new Integer(o2.getBirthday().substring(6,10));
            return year1 - year2;
        }
        return o1.getNameCustomer().compareTo(o2.getNameCustomer());
    }
}
