package com.hcid.ftescheduler.writer;

import com.hcid.ftescheduler.entity.FteRecon;
import com.hcid.ftescheduler.entity.FteReconSummary;
import com.hcid.ftescheduler.model.ArtajasaFileRecon;
import com.hcid.ftescheduler.model.ArtajasaFileReconHeader;
import com.hcid.ftescheduler.repository.FteReconRepository;
import com.hcid.ftescheduler.repository.FteReconSummaryRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
public class ReconItemWriter<T> implements ItemWriter<T> {

    @Value("#{jobParameters['batchId']}")
    private String batchId;

    private ExecutionContext executionContext;

    @Autowired
    FteReconRepository reconRepository;

    @Autowired
    FteReconSummaryRepository reconSummaryRepository;

    @BeforeStep
    public void setExecutionContext(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution.getExecutionContext();
        this.executionContext = executionContext;
    }

    @Override
    public void write(List<? extends T> list) throws Exception {
        for (T content : list) {
            if (content != null) {
                if (content instanceof ArtajasaFileRecon) {
                    ArtajasaFileRecon artajasaFileRecon = (ArtajasaFileRecon) content;
                    reconRepository.save(constructFteRecon(artajasaFileRecon, batchId));
                    System.out.println("data : " + content.toString());
                } else if (content instanceof ArtajasaFileReconHeader) {
                    ArtajasaFileReconHeader artajasaFileReconHeader = (ArtajasaFileReconHeader) content;
                    reconSummaryRepository.save(constructFteReconSummary(artajasaFileReconHeader, batchId));
                    System.out.println("data : " + content.toString());
                }
            }
            /*System.out.println("filename: " + fileName);*/
        }
    }

    private FteRecon constructFteRecon(ArtajasaFileRecon artajasaFileRecon, String fileId) {
        FteRecon fteRecon = new FteRecon();
        fteRecon.setId(UUID.randomUUID().toString());
        fteRecon.setAmount(BigDecimal.valueOf(Long.parseLong(artajasaFileRecon.getAmount())));
        fteRecon.setBenefBankCode(artajasaFileRecon.getBeneficiaryBankCode());
        fteRecon.setBenerAccId(artajasaFileRecon.getBeneficiaryAccountId());
        fteRecon.setDtimeTransaction(artajasaFileRecon.getDateTimeTransaction());
        fteRecon.setReferenceNo(artajasaFileRecon.getReferenceNumber());
        fteRecon.setSenderAccNo(artajasaFileRecon.getSenderAccountId());
        fteRecon.setStan(artajasaFileRecon.getStan());
        fteRecon.setSumId(fileId);
        return fteRecon;
    }

    private FteReconSummary constructFteReconSummary(ArtajasaFileReconHeader artajasaFileReconHeader, String fileId) {
        FteReconSummary fteReconSummary = new FteReconSummary();
        fteReconSummary.setId(fileId);
        fteReconSummary.setStatus(artajasaFileReconHeader.getStatus());
        fteReconSummary.setDtimeReport(artajasaFileReconHeader.getDateTimeReport());
        fteReconSummary.setPartnerId(artajasaFileReconHeader.getPartnerInstId());
        fteReconSummary.setTotalTransaction(artajasaFileReconHeader.getTotalTransaction());

        String currDateTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        fteReconSummary.setDtimeExecuted(currDateTime);

        return fteReconSummary;
    }
}
