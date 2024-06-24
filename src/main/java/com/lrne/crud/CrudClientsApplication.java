package com.lrne.crud;

import com.lrne.crud.entity.Client;
import com.lrne.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudClientsApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CrudClientsApplication.class, args);
	}

}
