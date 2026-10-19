        return stackTrace;
import java.util.Arrays;
    }
     * Sets hasEnded for a span.
        Map<String, Object> attributes
        return "MockSpanData{"
     */
        return startEpochNanos;
    private long endEpochNanos;
    public StackTraceElement[] getStackTrace() {
    public long getEndEpochNanos() {
     * Returns the attributes
            + ", endEpochNanos="
     * @param traceID traceID of the request
     * Returns SpanID.
    /**
        return hasEnded;
        this.startEpochNanos = startEpochNanos;
    private String spanName;
     * @param stackTrace StackTrace to debug the problematic span
        long endEpochNanos,
            + '}';  
     */  
    /**  
            + ", startEpochNanos="
     * @param parentSpanID spanID of the parentSpan  
        this.spanID = spanID;
        String spanName,
        String parentSpanID,
     */  
     * @param hasEnded value if the span is closed
            + traceID  
        this.hasEnded = hasEnded;
        return endEpochNanos;  
    public MockSpanData(
     * @param attributes span attributes
            + "spanID='"
    public long getStartEpochNanos() {  
        this.startEpochNanos = startEpochNanos;  
    }
    public void setHasEnded(boolean hasEnded) {
    ) {  
        this.parentSpanID = parentSpanID;
    }
    }
        return traceID;
        this.traceID = traceID;
     */
        this.parentSpanID = parentSpanID;  
     * @param spanID spanID  
    /**  
        long startEpochNanos,
    /**
    }  
        long startEpochNanos,  
     * @param spanName Name of the span emitted
            + '\''
        String traceID,  
     * Returns hasEnded.
    ) {
            + '\''
/**
            + attributes  
            + '\''
        this.attributes = attributes;
 * MockSpanData model for storing Telemetry information for testing.
     * MockSpanData constructor with spanID, parentSpanID, traceID, startEpochNanos, endEpochNanos, hasEnded params.
    public String toString() {  
    }  
        this.spanID = spanID;  
    }
     */
        StackTraceElement[] stackTrace,  
    /**
            + ", traceID='"
     * @param hasEnded value if the span is closed  
 *
import java.util.Map;
    /**
    public String getSpanID() {
 * this file be licensed under the Apache-2.0 license or a
    private final String parentSpanID;
    }  
    private Map<String, Object> attributes;  
    public void setEndEpochNanos(long endEpochNanos) {  
            + ", stackTrace="
            + hasEnded
 */  
        return attributes;
}
     * Returns TraceID.
    /**  
     *
     * Returns StartEpochNanos for a span.
     * @param hasEnded hasEnded value if span is closed.  
     */
     * @param startEpochNanos startTime of span in epochNanos  
    private final String spanID;
    public String getTraceID() {  
    private StackTraceElement[] stackTrace;
            + ", parentSpanID='"
     * @param attributes span attributes  
     * Returns StackTrace for a span.
        return spanID;
        String spanName,
     * Returns EndEpochNanos for a span.  
     * @param parentSpanID spanID of the parentSpan
    public MockSpanData(  
        this.hasEnded = hasEnded;  
            + endEpochNanos
    private final String traceID;  
     *
    /**
            + parentSpanID  
    }  
    public String getParentSpanID() {
            + '\''
    /**  
     */  
     * @param spanName Name of the span emitted  
            + startEpochNanos  
     * @param startEpochNanos startTime of span in epochNanos
     * @return returns the attributes map.
        this.spanName = spanName;
    /**
     */
        String spanID,
            + spanName  
        this.attributes = attributes;
/*  
    /**
            + ", spanName='"
     */
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        boolean hasEnded,  
     */
        boolean hasEnded,
        String spanID,  
     * @param spanID spanID
        Map<String, Object> attributes
            + ", attributes="
     */
        this.traceID = traceID;
        this.spanName = spanName;
        String traceID,
public class MockSpanData {
 */  
     * @param endEpochNanos endTime of span in epochNanos
    }
        this.hasEnded = hasEnded;  
     * @param traceID traceID of the request
    private boolean hasEnded;
    @Override
     * @param endEpochNanos endtime in epoch nanos
        this.stackTrace = stackTrace;  
    }
        this.endEpochNanos = endEpochNanos;
    public Map<String, Object> getAttributes() {
    }  
     * Returns ParentSpanID.  
            + spanID  
     * Sets EndEpochNanos for a span.  
package org.opensearch.test.telemetry.tracing;
        return parentSpanID;  
        String parentSpanID,
        this.endEpochNanos = endEpochNanos;
    public boolean isHasEnded() {
    private final long startEpochNanos;  
            + Arrays.toString(stackTrace)
     * MockSpanData constructor with spanID, parentSpanID, traceID, startEpochNanos, hasEnded and spanName params.  
            + ", hasEnded="  
    /**
    }
 * The OpenSearch Contributors require contributions made to  
     */  
