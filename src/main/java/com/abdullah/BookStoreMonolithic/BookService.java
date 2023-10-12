package com.abdullah.BookStoreMonolithic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
   @Autowired
   private BookRepository bookRepository;

   public List<Book> getAllBooks() {
       return bookRepository.findAll();
   }

   public Book getBookById(Long id) {
       return bookRepository.findById(id).orElse(null);
   }
   

   // Implement other methods for managing books
}