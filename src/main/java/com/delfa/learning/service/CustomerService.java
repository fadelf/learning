package com.delfa.learning.service;

import com.delfa.learning.model.Book;
import com.delfa.learning.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);
}
