package com.abdullah.BookStoreMonolithic;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   private Order order;
   private double amount;
   private boolean paymentSuccessful;
   // Other fields, getters, and setters
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Order getOrder() {
    return order;
}
public void setOrder(Order order) {
    this.order = order;
}
public double getAmount() {
    return amount;
}
public void setAmount(double amount) {
    this.amount = amount;
}
public boolean isPaymentSuccessful() {
    return paymentSuccessful;
}
public void setPaymentSuccessful(boolean paymentSuccessful) {
    this.paymentSuccessful = paymentSuccessful;
}

    

}

enum Role {
    USER, ADMIN
}

enum OrderStatus {
    PENDING, COMPLETED, CANCELED
}
