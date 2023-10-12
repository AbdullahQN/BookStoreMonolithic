package com.abdullah.BookStoreMonolithic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Order order, double amount) {
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setPaymentSuccessful(true); // Implement actual payment processing
        return paymentRepository.save(payment);
    }

    // Implement other payment-related methods
}
