package com.info.spring.sprintBatchDB;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	String springConfig[]= 
		{
				"spring/batch/config/database.xml", 
				"spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml" 
		};
	ApplicationContext context=new ClassPathXmlApplicationContext(springConfig);
	
	JobLauncher jobLauncher = context.getBean("jobLauncher",JobLauncher.class);
	Job job = context.getBean("reportJob",Job.class);
	try {

		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		System.out.println("Execution Status :"+jobExecution.getStatus());
	} catch (Exception e) {
	e.printStackTrace();
	}
	System.out.println("finally Done it..");
}
}
