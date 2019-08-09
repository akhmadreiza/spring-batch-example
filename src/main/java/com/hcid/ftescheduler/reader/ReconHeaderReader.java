package com.hcid.ftescheduler.reader;

import com.hcid.ftescheduler.model.ArtajasaFileReconHeader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ReconHeaderReader {
    @Bean
    public FlatFileItemReader<ArtajasaFileReconHeader> readHeader() {
        FlatFileItemReader<ArtajasaFileReconHeader> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("D:\\fileTest\\disbursement-success-000001-20140604.rpt"));

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames(new String[]{"lineFlag", "status", "partnerInstId", "partnerName", "totalTransaction", "dateTimeReport"});
        delimitedLineTokenizer.setStrict(false);

        BeanWrapperFieldSetMapper<ArtajasaFileReconHeader> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<ArtajasaFileReconHeader>();
        beanWrapperFieldSetMapper.setTargetType(ArtajasaFileReconHeader.class);

        DefaultLineMapper<ArtajasaFileReconHeader> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        reader.setLineMapper(lineMapper);
        return reader;
    }
}
