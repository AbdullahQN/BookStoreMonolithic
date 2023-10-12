package com.abdullah.BookStoreMonolithic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframeworkl.security.
import org.springframework.security.web.SecurityFilterChain;


// @Configuration
//  @EnableWebMvc
//  public class SecurityConfig {

//         @Bean
//         public WebSecurityCustomizer webSecurityCustomizer() {
//                 return (web) -> web.ignoring()
//                                 .requestMatchers("/resources/**");
//         }

//         @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//                 http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
//                                 .hasRole("USER").and()
//                                 // Possibly more configuration ...
//                                 .formLogin() // enable form based log in
//                                 // set permitAll for all URLs associated with Form Login
//                                 .permitAll();
//                 return http.build();
//         }

//         @Bean
//         public UserDetailsService userDetailsService() {
//                 UserDetails user = User.withDefaultPasswordEncoder()
//                         .username("user")
//                         .password("password")
//                         .roles("USER")
//                         .build();
//                 UserDetails admin = User.withDefaultPasswordEncoder()
//                         .username("admin")
//                         .password("password")
//                         .roles("ADMIN", "USER")
//                         .build();
//                 return new InMemoryUserDetailsManager(user, admin);
//         }
//         @Bean
// public PasswordEncoder passwordEncoder() {
//     return new BCryptPasswordEncoder();
// }

//         // Possibly more bean methods ...
//  }

//  @Configuration
//  @EnableWebMvc
//  public class SecurityConfig {

//         @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//                 http.authorizeHttpRequests().requestMatchers("/**").hasRole("USER").and().formLogin();
//                 return http.build();
//         }

//         @Bean
//         public UserDetailsService userDetailsService() {
//                 UserDetails user = User.withDefaultPasswordEncoder()
//                         .username("user")
//                         .password("password")
//                         .roles("USER")
//                         .build();
//                 return new InMemoryUserDetailsManager(user);
//         }
//  }
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfiguration {
//     @Autowired
//     private CustomerService customerService;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .requestMatchers("/books/**").permitAll()
//                 .requestMatchers("/orders/create").hasRole("USER")
//                 .requestMatchers("/admin/**").hasRole("ADMIN")
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/home")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .logoutUrl("/logout")
//                 .permitAll();
//     }

//         // @Bean
//         // public UserDetailsService userDetailsService() {
//         //         UserDetails user = User.withUsername("user")
//         //                 .password("password")
//         //                 .roles("USER")
//         //                 .build();
//         //         return new InMemoryUserDetailsManager(user);
//         // }
                
//         @Bean
//         public UserDetailsService userDetailsService() {
//                 UserDetails user = User.withDefaultPasswordEncoder()
//                         .username("user")
//                         .password("password")
//                         .roles("USER")
//                         .build();
//                 return new InMemoryUserDetailsManager(user);
//         }



//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }





// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfiguration {
//     @Autowired
//     private CustomerService customerService;

//     @Autowired
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .requestMatchers("/books/**").permitAll()
//                 .requestMatchers("/orders/create").hasRole("USER")
//                 .requestMatchers("/admin/**").hasRole("ADMIN")
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/home")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .logoutUrl("/logout")
//                 .permitAll();
//     }

//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(customerService).passwordEncoder(passwordEncoder());
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }



@Configuration
 @EnableWebSecurity
 public class FormLoginSecurityConfig {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
            .authorizeRequests()
                .requestMatchers("/books/**").permitAll()
                .requestMatchers("/orders/create").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll();
         return http.build();
     }

     @Bean
     public UserDetailsService userDetailsService() {
         UserDetails user = User.withDefaultPasswordEncoder()
             .username("user")
             .password("password")
             .roles("USER")
             .build();
         return new InMemoryUserDetailsManager(user);
     }
 }
