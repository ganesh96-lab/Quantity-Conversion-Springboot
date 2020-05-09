package com.bridgelabz.quantitymeasurement.Service;
import com.bridgelabz.quantitymeasurement.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    private int customerIdCount=1;
    private List<Customer> customerList=new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        //customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    //wheneve we want to send list of customer
    public List<Customer>getCustomers(){
        return customerList;
    }

    //retrive only specific customer
    public Customer getCustomer(int customerId){
        return customerList.stream()
                .filter(c->c.getCustomerId()==customerId)
                .findFirst()
                .get();
    }

    //this method to return the customer object whatever updated
    public Customer updateCustomer(int customerId,Customer customer){
        customerList
                .stream()
                .forEach(c ->{
                    if (c.getCustomerId()==customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                } );
        return customerList
                .stream()
                .filter(c->c.getCustomerId()==customer.getCustomerId())
                .findFirst()
                .get();
    }

    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(c->{
                    if (c.getCustomerId()==customerId){
                        customerList.remove(c);
                    }
                });
    }
}
