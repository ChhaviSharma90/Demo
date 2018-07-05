package com.ibm.Products;

import java.util.logging.Logger;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication   {


    ProductRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
  
    public void run(String...args) throws Exception {

      repository.findById("1234");

        repository.findAll();

       repository.insert(new Product());

   //    repository.update(new Product("6677", "Prod4", "New-Passport"));

        repository.deleteById("1234");

       repository.findAll();

    }
}
