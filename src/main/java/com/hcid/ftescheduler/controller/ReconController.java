package com.hcid.ftescheduler.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReconController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("processRecon")
    Job processRecon;

    @PostMapping(path = "/manual-recon")
    public ResponseEntity<String> manualScheduler() {
        //TODO execute job
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(processRecon, jobParameters);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (JobExecutionAlreadyRunningException e) {
            System.out.println("error: " + e);
            return new ResponseEntity<>("ERROR! JOB ALREADY RUNNING", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (JobRestartException e) {
            System.out.println("error: " + e);
            return new ResponseEntity<>("ERROR! JOB BEING RESTARTED", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (JobInstanceAlreadyCompleteException e) {
            System.out.println("error: " + e);
            return new ResponseEntity<>("ERROR! JOB ALREADY COMPLETED", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (JobParametersInvalidException e) {
            System.out.println("error: " + e);
            return new ResponseEntity<>("ERROR! INVALID JOB PARAMETERS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
