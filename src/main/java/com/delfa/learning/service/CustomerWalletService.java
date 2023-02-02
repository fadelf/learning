package com.delfa.learning.service;

import com.delfa.learning.model.CustomerWallet;

import java.util.List;

public interface CustomerWalletService {
    List<CustomerWallet> getAllCustomerWallet();

    CustomerWallet saveCustomerWallet(CustomerWallet customerWallet);
}
