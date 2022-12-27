package com.book_order.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer quantity;
    private Integer  stock;

    @OneToMany(mappedBy = "book")
    private Set<BookOrder> bookOrders;

    public Book() {
    }

    public Book(Integer id, String title, Integer quantity, Integer stock, Set<BookOrder> bookOrders) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.stock = stock;
        this.bookOrders = bookOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(Set<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }
}
