package com.javahowtouse.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

	private String message[]= {"javahowTouse.com","welcome to Spring batch Example",
	                "we use h2 datadase for this Example"};
	private int count=0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(count<message.length) {
			return message[count++];
		}else {
			count=0;
		}
		return null;
	}

}
