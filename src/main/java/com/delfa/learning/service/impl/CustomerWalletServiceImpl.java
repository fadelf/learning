package com.delfa.learning.service.impl;

import com.delfa.learning.model.CustomerWallet;
import com.delfa.learning.repository.CustomerWalletRepository;
import com.delfa.learning.service.CustomerWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerWalletServiceImpl implements CustomerWalletService {

    @Autowired
    CustomerWalletRepository customerWalletRepository;

    @Override
    public List<CustomerWallet> getAllCustomerWallet() {
        return customerWalletRepository.findAll();
    }

    @Override
    public CustomerWallet saveCustomerWallet(CustomerWallet customerWallet) {
        return customerWalletRepository.save(customerWallet);
    }
}
