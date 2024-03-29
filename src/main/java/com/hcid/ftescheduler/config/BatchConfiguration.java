package com.hcid.ftescheduler.config;

import com.hcid.ftescheduler.listener.ReconListener;
import com.hcid.ftescheduler.listener.ReconStepListener;
import com.hcid.ftescheduler.model.ArtajasaFileRecon;
import com.hcid.ftescheduler.model.ArtajasaFileReconHeader;
import com.hcid.ftescheduler.processor.ReconHeaderItemProcessor;
import com.hcid.ftescheduler.processor.ReconItemProcessor;
import com.hcid.ftescheduler.reader.ReconContentReader;
import com.hcid.ftescheduler.reader.ReconHeaderReader;
import com.hcid.ftescheduler.writer.ReconItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public ReconContentReader reconContentReader;

    @Autowired
    public ReconHeaderReader reconHeaderReader;

    @Autowired
    ResourcePatternResolver resoursePatternResolver;

    @Bean
    public Job processRecon(ReconListener listener, Step readReconFile, Step readReconFileHeader) {
        return jobBuilderFactory.get("processRecon")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(readReconFileHeader)
                .next(readReconFile)
                .build();
    }

    @Bean
    public Step readReconFile(ReconItemProcessor reconItemProcessor) {
        return stepBuilderFactory.get("readReconFile")
                .<ArtajasaFileRecon, ArtajasaFileRecon>chunk(100)
                .reader(reconContentReader.read())
                .processor(reconItemProcessor)
                .writer(reconItemWriter())
                .build();
    }

    @Bean
    public Step readReconFileHeader(ReconHeaderItemProcessor reconHeaderItemProcessor, ReconStepListener reconStepListener) {
        return stepBuilderFactory.get("readReconFileHeader")
                .listener(reconStepListener)
                .<ArtajasaFileReconHeader, ArtajasaFileReconHeader>chunk(100)
                .reader(reconHeaderReader.readHeader())
                .processor(reconHeaderItemProcessor)
                .writer(reconItemHeaderWriter())
                .listener(promotionListener())
                .build();
    }

    @Bean
    @StepScope
    public ReconItemWriter<ArtajasaFileRecon> reconItemWriter() {
        return new ReconItemWriter<ArtajasaFileRecon>();
    }

    @Bean
    @StepScope
    public ReconItemWriter<ArtajasaFileReconHeader> reconItemHeaderWriter() {
        return new ReconItemWriter<ArtajasaFileReconHeader>();
    }

    @Bean
    public ExecutionContextPromotionListener promotionListener() {
        ExecutionContextPromotionListener listener = new ExecutionContextPromotionListener();
        listener.setKeys(new String[]{"fileId"});
        return listener;
    }
}
