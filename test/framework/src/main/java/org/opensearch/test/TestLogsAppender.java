public class TestLogsAppender extends AbstractAppender {
                if (shouldCaptureMessage(element.toString())) capturedLogs.add(element.toString());  
    public TestLogsAppender(List<String> messagesToCapture) {  
 * SPDX-License-Identifier: Apache-2.0
        capturedLogs.clear();
import org.apache.logging.log4j.core.layout.PatternLayout;
                Thread.currentThread().interrupt();
    }
            if (shouldCaptureMessage(event.getThrown().toString())) capturedLogs.add(event.getThrown().toString());
        return messagesToCapture.stream().anyMatch(log::contains);
    // Clear captured logs  
    }
            try {
                Thread.sleep(100); // Wait for 100ms before checking again  
        return false;  
    }
import org.apache.logging.log4j.core.LogEvent;
        long startTime = System.currentTimeMillis();
 *
    private final List<String> capturedLogs = new ArrayList<>();  
    private final List<String> messagesToCapture;
}
            for (StackTraceElement element : event.getThrown().getStackTrace())
        }
    public boolean waitForLog(String expectedLog, long timeout, TimeUnit unit) {  
            }
        super("TestAppender", null, PatternLayout.createDefaultLayout(), false, Property.EMPTY_ARRAY);
        long timeoutInMillis = unit.toMillis(timeout);
        this.messagesToCapture = messagesToCapture;
            }  
/*  
                return true;  
            if (capturedLogs.stream().anyMatch(log -> log.contains(expectedLog))) {
 * Test logs appender that provides functionality to extract specific logs/exception messages and wait for it to show up
import org.apache.logging.log4j.core.appender.AbstractAppender;
/**
 */  
import java.util.List;
import java.util.ArrayList;  
        return new ArrayList<>(capturedLogs);  
    @Override  
        start();  
        if (event.getThrown() != null) {  
        if (shouldCaptureMessage(event.getMessage().getFormattedMessage())) capturedLogs.add(event.getMessage().getFormattedMessage());
    }  
 */
        while (System.currentTimeMillis() - startTime < timeoutInMillis) {
    public List<String> getCapturedLogs() {
import org.apache.logging.log4j.core.config.Property;  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test;
    }  
    public void append(LogEvent event) {
    public boolean shouldCaptureMessage(String log) {
 * @opensearch.internal  
import java.util.concurrent.TimeUnit;
    public void clearCapturedLogs() {
        }
            } catch (InterruptedException e) {
    }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
