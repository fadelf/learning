package com.delfa.learning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty
    private Long id;

    @Column(name = "TITLE", nullable = false)
    @JsonProperty
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    @JsonProperty
    private String author;

    @Column(name = "GENRE")
    @JsonProperty
    private String genre;

    @Column(name = "PRICE")
    @JsonProperty
    private Double price;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
