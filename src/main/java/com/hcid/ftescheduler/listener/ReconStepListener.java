package com.hcid.ftescheduler.listener;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class ReconStepListener extends StepExecutionListenerSupport {
    StepExecution stepExecution;

    public StepExecution getStepExecution() {
        return stepExecution;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
}
