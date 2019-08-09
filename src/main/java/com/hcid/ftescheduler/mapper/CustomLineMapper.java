package com.hcid.ftescheduler.mapper;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class CustomLineMapper extends DefaultLineMapper<FieldSet> {
    private int totalItemsToRead;

    @Override
    public FieldSet mapLine(String line, int lineNumber) throws Exception {
        if (lineNumber > totalItemsToRead) {
            return null;
        }
        return super.mapLine(line, lineNumber);
    }
}
