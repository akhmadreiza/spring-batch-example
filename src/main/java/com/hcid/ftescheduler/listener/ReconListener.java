package com.hcid.ftescheduler.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class ReconListener extends JobExecutionListenerSupport {
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            //TODO add new logic to check to RTD table and hit their api to notify
            System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}
