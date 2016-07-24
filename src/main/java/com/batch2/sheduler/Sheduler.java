package com.batch2.sheduler;



import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Sheduler {
	
	 @Autowired
	  private JobLauncher jobLauncher;

	  @Autowired
	  private Job job;

	
	
	@Scheduled(fixedDelay = 25000)
	private void makeJob() {
		
				
		 try {

				String dateParam = new Date().toString();
				JobParameters param = 
				  new JobParametersBuilder().addString("date", dateParam).toJobParameters();
						
				System.out.println(dateParam);
						
				JobExecution execution = jobLauncher.run(job, param);
				System.out.println("Exit Status : " + execution.getStatus());

			    } catch (Exception e) {
				e.printStackTrace();
			    }
	}
}
