package com.javahowtouse.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
	
		for (String msg : items) {
			System.out.println("Wrting the data :"+msg);
		}
	}

}
