package com.badr.customerservice;

import com.badr.customerservice.entities.Customer;
import com.badr.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    private final CustomerService customerService;

    public CustomerServiceApplication(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){
        return args -> {
            List<String>  names = List.of("badr" , "ahmed" , "youssef");
            names.forEach(
                    name -> {
                        customerService.saveCustomer(Customer.builder().name(name).email(name+"@gmail.com").build());
                    }

            );
        };
    }

}
