package com.vladimir.kornilov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MyWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebFluxApplication.class, args);
	}

}
