     */  
    }
    }
    /**
    // update the flag to true or set the corresponding system property to true  
        return new ArrayList<>(spanMap.values());
            spanData.setHasEnded(true);  
import java.util.List;
            span.getSpanName(),
    @Override  
     * Return list of mock span data at any point of time.
/*  
        StackTraceElement[] stackTrace = isStackTraceForSpanEnabled ? Thread.currentThread().getStackTrace() : null;
                validators.validate(spanData, 1);
import java.util.Arrays;
            parentSpanId,
    }  
        if (spanData != null) {
     */
            System.nanoTime(),  
            (span instanceof MockSpan) ? ((MockSpan) span).getAttributes() : Map.of()
            stackTrace,  
        }
    public static void validateTracingStateOnShutdown() {  
/**  
 * SPDX-License-Identifier: Apache-2.0
    /**  
    // If you want to see the stack trace for each spanData, then
        spanMap.put(span.getSpanId(), toMockSpanData(span));  
            span.getSpanId(),  
    private static Map<String, MockSpanData> spanMap = new ConcurrentHashMap<>();  
        }  
}  
        return spanData;  
            try {  
    // Note: Enabling this might lead to OOM issues while running ITs.
    private static final boolean isStackTraceForSpanEnabled = Booleans.parseBoolean(  
import org.opensearch.common.Booleans;
 */  
    public void onStart(Span span) {
import org.opensearch.test.telemetry.tracing.validators.AllSpansAreEndedProperly;  
    );
package org.opensearch.test.telemetry.tracing;
import java.util.Map;  
public class StrictCheckSpanProcessor implements SpanProcessor {  
     * Base constructor.
    @Override
            span.getTraceId(),
 *
import java.util.ArrayList;  
    }
            }
 * The OpenSearch Contributors require contributions made to  
 * Strict check span processor to validate the spans.
                spanMap.clear();  
 * compatible open source license.
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.telemetry.tracing.Span;
        List<MockSpanData> spanData = new ArrayList<>(spanMap.values());
    // This is helpful in debugging the tests. Default value is false.
                throw e;
                Arrays.asList(new AllSpansAreEndedProperly(), new AllSpansHaveUniqueId())
    /**
    }
            spanData.setEndEpochNanos(System.nanoTime());
    private MockSpanData toMockSpanData(Span span) {
        System.getProperty("tests.telemetry.span.stack_traces", "false")
        );
            } catch (Error e) {
    public void onEnd(Span span) {
 */
     * Ensures the strict check succeeds for all the spans.
    public List<MockSpanData> getFinishedSpanItems() {
            TelemetryValidators validators = new TelemetryValidators(  
        // Setting EndEpochTime and HasEnded value to true on completion of span.  
    public StrictCheckSpanProcessor() {}
            );
        if (spanData.size() != 0) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.telemetry.tracing.validators.AllSpansHaveUniqueId;
     */  
        MockSpanData spanData = spanMap.get(span.getSpanId());
            false,
        String parentSpanId = (span.getParentSpan() != null) ? span.getParentSpan().getSpanId() : "";  
        MockSpanData spanData = new MockSpanData(
