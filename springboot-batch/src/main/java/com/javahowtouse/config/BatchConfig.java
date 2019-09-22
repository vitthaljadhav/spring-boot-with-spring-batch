package com.javahowtouse.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javahowtouse.processor.Processor;
import com.javahowtouse.reader.Reader;
import com.javahowtouse.status.JobCompleteListener;
import com.javahowtouse.writer.Writer;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listerner()).flow(orderStep1()).end().build();
	}
	
	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<String,String> chunk(1)
				.reader(new Reader()).processor(new Processor()).writer(new Writer()).build();
	}
	
	@Bean
	public JobExecutionListener listerner() {
		return new JobCompleteListener();
	}
}
