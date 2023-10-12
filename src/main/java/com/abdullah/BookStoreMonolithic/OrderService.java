package com.abdullah.BookStoreMonolithic;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
   @Autowired
   private OrderRepository orderRepository;
   //@Autowired
   //private CustomerRepository customerRepository;

   public Order createOrder(Customer customer, List<Book> books) {
       Order order = new Order();
       order.setCustomer(customer);
       order.setBooks(books);
       order.setOrderDate(new Date());
       // Calculate the total amount and save the order
       // You can also implement payment processing here
       return orderRepository.save(order);
   }

   // Implement other methods for managing orders
}