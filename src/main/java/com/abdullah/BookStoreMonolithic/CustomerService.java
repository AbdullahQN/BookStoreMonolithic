package com.abdullah.BookStoreMonolithic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found with email: " + email);
        }
        return new User(customer.getEmail(), customer.getPassword(), getAuthorities(customer.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String string) {
        //return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + string.name()));
        return Collections.singleton(new SimpleGrantedAuthority("user"));
    }
}