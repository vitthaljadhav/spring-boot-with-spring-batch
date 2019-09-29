package com.infotech.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication
public class SpringBootBatchXmlToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchXmlToDbApplication.class, args);
	}
}
