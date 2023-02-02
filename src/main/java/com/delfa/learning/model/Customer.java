package com.delfa.learning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty
    private Long id;

    @Column(name = "NAME")
    @JsonProperty
    private String name;

    @Column(name = "ADDRESS")
    @JsonProperty
    private String address;

    @Column(name = "USER_ID", unique = true, nullable = false)
    @JsonProperty
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WALLET_ID", referencedColumnName = "ID")
    private CustomerWallet customerWallet;

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
