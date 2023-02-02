package com.delfa.learning.wrapper;

import com.delfa.learning.model.CustomerWallet;
import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String address;
    private Long userId;
    private CustomerWallet wallet;

}
