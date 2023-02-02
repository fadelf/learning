package com.delfa.learning.controller;

import com.delfa.learning.model.Book;
import com.delfa.learning.model.Customer;
import com.delfa.learning.model.CustomerWallet;
import com.delfa.learning.service.CustomerService;
import com.delfa.learning.service.CustomerWalletService;
import com.delfa.learning.wrapper.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerWalletService customerWalletService;

    @RequestMapping(path = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAddress(customerRequest.getAddress());
        customer.setUserId(customerRequest.getUserId());
        customer.setCreatedBy("System");
        customer.setCustomerWallet(customerRequest.getWallet());

        customerService.saveCustomer(customer);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(path = "/list",
            method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomer() {
        List<Customer> customerList = customerService.getAllCustomer();

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
