    }  
        this.startTime = System.nanoTime();
     * Returns whether the span is ended or not.
     */  
    public void addAttribute(String key, Boolean value) {
import org.opensearch.telemetry.tracing.SpanCreationContext;  
    public void addAttribute(String key, Double value) {
 */  
            long idLo = randomSupplier.get().nextLong();
        }
    public void endSpan() {
import java.util.HashMap;
        putMetadata(event, null);
import java.util.Random;  
    private final SpanProcessor spanProcessor;
            spanCreationContext.getSpanName(),  
    }  
        String spanName,
        }  
    private final Map<String, Object> metadata;  
    }
     * @param traceId       Trace ID  
    }
    @Override  
     */
            long id = randomSupplier.get().nextLong();
            parentSpan,
    ) {
            putMetadata("ERROR", exception.getMessage());
    @Override
    public MockSpan(  
     *
    }
    /**  
        super(spanName, parentSpan);  
    public String getTraceId() {  
     * @return value
        if (attributes != null) {  
            }
        this.traceId = traceId;  
     * @param spanProcessor Span Processor
import org.opensearch.telemetry.tracing.SpanKind;
    public MockSpan(SpanCreationContext spanCreationContext, Span parentSpan, SpanProcessor spanProcessor) {
     * @param attributes    attributes  
     */
            hasEnded = true;
    @Override
        String traceId,  
     * Constructor with traceId and SpanIds
/*  
    }
        return endTime;
        synchronized (lock) {
        putMetadata(key, value);
     * @param spanCreationContext      Span Creation context.  
import org.opensearch.telemetry.tracing.Span;
        }
    public String getSpanId() {
            return Long.toHexString(result);  
    private final Object lock = new Object();
        return traceId;
            IdGenerator.generateSpanId(),  
     * Returns attribute.  
 * MockSpan for testing and strict check validations. Not to be used for production cases.
            endTime = System.nanoTime();  
     */  
    /**  
import org.opensearch.telemetry.tracing.attributes.Attributes;
    private void putMetadata(String key, Object value) {
     * @param parentSpan    Parent Span
    private final String spanId;
        SpanProcessor spanProcessor,
    }
        metadata.put(key, value);
        putMetadata(key, value);
            this.metadata.putAll(attributes.getAttributesMap());
    public boolean hasEnded() {
    private Long endTime;
    }  
    public Long getStartTime() {
            SpanKind.INTERNAL  
        String spanId,
        synchronized (lock) {
            parentSpan != null ? parentSpan.getTraceId() : IdGenerator.generateTraceId(),
        return metadata;
package org.opensearch.test.telemetry.tracing;
            return hasEnded;  
        SpanKind spanKind
     *  
     */  
            if (hasEnded) {  
    @Override  
        putMetadata(key, value);
     * @param spanName      Span Name
    }
     * @param spanId        Span ID
        }
    private static final Supplier<Random> randomSupplier = ThreadLocalRandom::current;
    public void addEvent(String event) {  
        putMetadata(key, value);  
     * @param spanProcessor Span Processor
    }  
    }
    }  
     * @return span end status.
        );
     * Returns the attributes as map.  
        Attributes attributes,  
    private final SpanKind spanKind;  
     * @param key key
    private final String traceId;
                return;
    private boolean hasEnded;  
    private final Long startTime;
    @Override  
    @Override
    private static class IdGenerator {
        private static String generateSpanId() {  
 * this file be licensed under the Apache-2.0 license or a
        return metadata.get(key);
    /**
 */  
    }
    /**  
     * @return returns the attributes map.
        this.spanKind = spanKind;  
        Span parentSpan,
    /**
        if (exception != null) {  
     * Returns the start time of the span.
    public Object getAttribute(String key) {
     */
            long result = idLo | (idHi << 32);
 * compatible open source license.
        private static String generateTraceId() {
            spanProcessor,
        spanProcessor.onEnd(this);  
public class MockSpan extends AbstractSpan {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.AbstractSpan;
     * Base Constructor.
import java.util.concurrent.ThreadLocalRandom;
    }
        this.metadata = new HashMap<>();
}  
import java.util.Map;
        this.spanId = spanId;
    public void addAttribute(String key, String value) {
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
        this.spanProcessor = spanProcessor;
            spanCreationContext.getAttributes(),
        }
    }  
    /**
    }
     * @param parentSpan    Parent Span
/**
     * @return start time of the span.  
    public void addAttribute(String key, Long value) {  
     * Returns the start time of the span.
import java.util.function.Supplier;
 *
            long idHi = randomSupplier.get().nextLong();  
    public void setError(Exception exception) {
    /**
            return Long.toHexString(id);
    }  
        }
        return startTime;  
    @Override
    public Map<String, Object> getAttributes() {  
     * @return end time of the span.
     */  
     * @param spanKind      type of span.
    public Long getEndTime() {
        this(
        return spanId;  
