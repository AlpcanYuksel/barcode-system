package com.barcode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BarcodeSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BarcodeSystemApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BarcodeSystemApplication.class);
	}

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
