package com.hcid.ftescheduler.writer;

import com.hcid.ftescheduler.model.ArtajasaFileRecon;
import com.hcid.ftescheduler.model.ArtajasaFileReconHeader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReconItemWriter<T> implements ItemWriter<T> {
    @Override
    public void write(List<? extends T> list) throws Exception {
        for (T content : list) {
            if (content != null) {
                if (content instanceof ArtajasaFileRecon) {
                    System.out.println("data : " + content.toString());
                } else if (content instanceof ArtajasaFileReconHeader) {
                    System.out.println("data : " + content.toString());
                }
            }
        }
    }
}
