package com.javahowtouse.status;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompleteListener  extends JobExecutionListenerSupport{

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus()==BatchStatus.COMPLETED) {			
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
		//super.afterJob(jobExecution);
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		//super.beforeJob(jobExecution);
		if(jobExecution.getStatus()==BatchStatus.STARTING) {			
			System.out.println("BATCH JOB STARTED SUCCESSFULLY");
		}
	}

}
