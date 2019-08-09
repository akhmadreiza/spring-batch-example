package com.hcid.ftescheduler.processor;

import com.hcid.ftescheduler.model.ArtajasaFileReconHeader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReconHeaderItemProcessor implements ItemProcessor<ArtajasaFileReconHeader, ArtajasaFileReconHeader> {
    @Override
    public ArtajasaFileReconHeader process(ArtajasaFileReconHeader source) throws Exception {

        String recordSequence = source.getLineFlag();

        ArtajasaFileReconHeader resultArtajasaFileReconHeader = null;

        if (recordSequence.equalsIgnoreCase("BEGIN")) {
            resultArtajasaFileReconHeader = new ArtajasaFileReconHeader(source.getLineFlag(), source.getStatus(),
                    source.getPartnerInstId(), source.getPartnerName(), source.getTotalTransaction(), source.getDateTimeReport());
        }

        return resultArtajasaFileReconHeader;
    }
}
