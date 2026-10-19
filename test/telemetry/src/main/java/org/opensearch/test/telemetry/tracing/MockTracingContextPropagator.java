    }  
            String traceId = values[0];  
        }
    public void inject(Span currentSpan, BiConsumer<String, String> setter) {
 * Mock {@link TracingContextPropagator} to persist the span for internode communication.  
 */  
package org.opensearch.test.telemetry.tracing;
    @Override  
        String value = props.get(TRACE_PARENT);  
        } else {  
    public Optional<Span> extractFromHeaders(Map<String, Collection<String>> headers) {  
/**
    /**
import org.opensearch.telemetry.tracing.attributes.Attributes;
import java.util.Map;  
            String spanId = values[1];
import java.util.Collection;
        if (headers != null) {
            String traceParent = String.format(Locale.ROOT, "%s%s%s", traceId, SEPARATOR, spanId);
 * The OpenSearch Contributors require contributions made to  
        if (value != null) {
            String[] values = value.split(SEPARATOR);
        this.spanProcessor = spanProcessor;
import java.util.function.BiConsumer;
    private static final String SEPARATOR = "~";
        }
            setter.accept(TRACE_PARENT, traceParent);  
        } else {  
import java.util.Optional;
    }
 *
            return Optional.empty();
}  
    private final SpanProcessor spanProcessor;  
        if (currentSpan instanceof MockSpan) {
import org.opensearch.telemetry.tracing.SpanKind;  
 */
                .collect(Collectors.toMap(Map.Entry::getKey, e -> Strings.collectionToCommaDelimitedString(e.getValue())));
    @Override
    public MockTracingContextPropagator(SpanProcessor spanProcessor) {  
     */
        }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import java.util.stream.Collectors;  
    }
                .stream()  
            String spanId = currentSpan.getSpanId();
     * @param spanProcessor span processor.
import org.opensearch.telemetry.tracing.TracingContextPropagator;
            return Optional.of(new MockSpan(null, null, traceId, spanId, spanProcessor, Attributes.EMPTY, SpanKind.INTERNAL));
    @Override
    private static final String TRACE_PARENT = "traceparent";
import org.opensearch.core.common.Strings;
import org.opensearch.telemetry.tracing.Span;
 * SPDX-License-Identifier: Apache-2.0
            Map<String, String> convertedHeader = headers.entrySet()
/*  
    public Optional<Span> extract(Map<String, String> props) {
            return extract(convertedHeader);
     * Constructor  
            return Optional.empty();
import java.util.Locale;
            String traceId = currentSpan.getTraceId();  
public class MockTracingContextPropagator implements TracingContextPropagator {
    }
