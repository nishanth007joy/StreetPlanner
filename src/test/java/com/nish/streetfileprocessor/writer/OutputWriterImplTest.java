package com.nish.streetfileprocessor.writer;

import org.junit.Test;

import com.nish.streetfileprocessor.basetest.BaseTest;

public class OutputWriterImplTest extends BaseTest {

    private OutputWriter outputWriter = new OutputWriterImpl();

    @Test
    public void testWriteProcessingReport() {
        String reportText = "failed,5,3,2";
        outputWriter.writeProcessingReport(reportText);
    }

}
