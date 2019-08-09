package com.hcid.ftescheduler.processor;

import com.hcid.ftescheduler.model.ArtajasaFileRecon;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReconItemProcessor implements ItemProcessor<ArtajasaFileRecon, ArtajasaFileRecon> {
    @Override
    public ArtajasaFileRecon process(ArtajasaFileRecon source) {
        String recordSequence = source.getRecordSequence();

        ArtajasaFileRecon resultArtajasaFileRecon = null;

        if (!recordSequence.equalsIgnoreCase("BEGIN") && !recordSequence.equalsIgnoreCase("END")) {
            resultArtajasaFileRecon = new ArtajasaFileRecon(source.getRecordSequence(), source.getDateTimeTransaction(),
                    source.getStan(), source.getReferenceNumber(), source.getSenderAccountId(), source.getBeneficiaryBankCode(),
                    source.getBeneficiaryAccountId(), source.getAmount());
        }

        return resultArtajasaFileRecon;
    }
}
