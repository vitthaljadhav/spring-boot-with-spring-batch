package com.javahowtouse.controller;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job processJob;

	@RequestMapping(value = "/invokejob", method = RequestMethod.GET)
	public String handle() {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(processJob, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Batch job has Been invike";
	}

}
