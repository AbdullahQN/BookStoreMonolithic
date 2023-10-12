package com.abdullah.BookStoreMonolithic;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   private Customer customer;
   @ManyToMany
   private List<Book> books;
   public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Customer getCustomer() {
    return customer;
}
public void setCustomer(Customer customer) {
    this.customer = customer;
}
public List<Book> getBooks() {
    return books;
}
public void setBooks(List<Book> books) {
    this.books = books;
}
public Date getOrderDate() {
    return orderDate;
}
public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
}
private Date orderDate;
   // Other fields, getters, and setters
}