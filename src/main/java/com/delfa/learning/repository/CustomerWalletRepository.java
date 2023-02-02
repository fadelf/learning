package com.delfa.learning.repository;

import com.delfa.learning.model.CustomerWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Long> {
}
