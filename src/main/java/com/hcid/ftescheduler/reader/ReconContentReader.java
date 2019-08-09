package com.hcid.ftescheduler.reader;

import com.hcid.ftescheduler.model.ArtajasaFileRecon;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ReconContentReader {
    @Bean
    public FlatFileItemReader<ArtajasaFileRecon> read() {
        FlatFileItemReader<ArtajasaFileRecon> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("D:\\fileTest\\disbursement-success-000001-20140604.rpt"));

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames(new String[]{"recordSequence", "dateTimeTransaction", "stan", "referenceNumber",
                "senderAccountId", "beneficiaryBankCode", "beneficiaryAccountId", "amount"});
        delimitedLineTokenizer.setStrict(false);

        BeanWrapperFieldSetMapper<ArtajasaFileRecon> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<ArtajasaFileRecon>();
        beanWrapperFieldSetMapper.setTargetType(ArtajasaFileRecon.class);

        DefaultLineMapper<ArtajasaFileRecon> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        reader.setLineMapper(lineMapper);
        return reader;
    }
}
