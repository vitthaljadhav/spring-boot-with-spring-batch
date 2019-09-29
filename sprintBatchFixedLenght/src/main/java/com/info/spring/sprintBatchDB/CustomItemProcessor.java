package com.info.spring.sprintBatchDB;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		System.out.println("Processing : " + item);
		item.setEarning(item.getEarning().toUpperCase());
		return item;
	}

}
