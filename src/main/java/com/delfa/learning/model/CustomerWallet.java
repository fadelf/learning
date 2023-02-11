package com.delfa.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "CUSTOMER_WALLET")
public class CustomerWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty
    private Long id;

    @Column(name = "BALANCE")
    @JsonProperty
    private Double balance;

    @OneToOne(mappedBy = "customerWallet")
    @JsonIgnore
    private Customer customer;

    @Column(name = "CREATED_ON", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column (name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @Column (name = "UPDATED_BY")
    private String updatedBy;
}
