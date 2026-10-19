import io.opentelemetry.api.trace.TraceState;  
    public void testExtractTracerContextFromHttpHeader() {
import static org.mockito.Mockito.mock;
 * compatible open source license.
        assertEquals(TRACE_ID, span.getTraceId());  
        org.opensearch.telemetry.tracing.Span propagatedSpan = new OTelPropagatedSpan(Span.fromContext(Context.root()));  
        org.opensearch.telemetry.tracing.Span span = tracingContextPropagator.extractFromHeaders(requestHeaders).get();
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
}
/*  
    private static final String SPAN_ID = "bea205cd25756b5e";
        assertEquals(TRACE_ID, span.getTraceId());
    private static final String TRACE_ID = "4aa59968f31dcbff7807741afa9d7d62";
        TracingContextPropagator tracingContextPropagator = new OTelTracingContextPropagator(mockOpenTelemetry);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
import io.opentelemetry.api.trace.SpanContext;
import java.util.Arrays;  
    }
        Map<String, Collection<String>> requestHeaders = new HashMap<>();
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);  
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.telemetry.tracing.Span span = tracingContextPropagator.extractFromHeaders(new HashMap<>()).get();
        tracingContextPropagator.inject(span, (key, value) -> requestHeaders.put(key, value));
    }  
    public void testExtractTracerContextFromHttpHeaderEmpty() {
        Span mockSpan = mock(Span.class);
        when(mockOpenTelemetry.getPropagators()).thenReturn(ContextPropagators.create(W3CTraceContextPropagator.getInstance()));
        TracingContextPropagator tracingContextPropagator = new OTelTracingContextPropagator(mockOpenTelemetry);
import java.util.HashMap;
    }  
        TracingContextPropagator tracingContextPropagator = new OTelTracingContextPropagator(mockOpenTelemetry);
        TracingContextPropagator tracingContextPropagator = new OTelTracingContextPropagator(mockOpenTelemetry);  
    }
        org.opensearch.telemetry.tracing.Span span = tracingContextPropagator.extractFromHeaders(null).get();
        TracingContextPropagator tracingContextPropagator = new OTelTracingContextPropagator(mockOpenTelemetry);  
import java.util.Collection;
import io.opentelemetry.api.trace.TraceFlags;
        Map<String, String> requestHeaders = new HashMap<>();
        when(mockOpenTelemetry.getPropagators()).thenReturn(ContextPropagators.create(W3CTraceContextPropagator.getInstance()));
        when(mockOpenTelemetry.getPropagators()).thenReturn(ContextPropagators.create(W3CTraceContextPropagator.getInstance()));
public class OTelTracingContextPropagatorTests extends OpenSearchTestCase {
import io.opentelemetry.context.propagation.ContextPropagators;  
        assertEquals(propagatedSpan.getSpanId(), span.getSpanId());
        assertEquals("00-" + TRACE_ID + "-" + SPAN_ID + "-00", requestHeaders.get("traceparent"));
 *
import io.opentelemetry.api.trace.Span;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;  
        org.opensearch.telemetry.tracing.Span propagatedSpan = new OTelPropagatedSpan(Span.fromContext(Context.root()));
    }
        requestHeaders.put("traceparent", "00-" + TRACE_ID + "-" + SPAN_ID + "-00");
        assertEquals(propagatedSpan.getTraceId(), span.getTraceId());
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import static org.mockito.Mockito.when;  
        org.opensearch.telemetry.tracing.Span span = tracingContextPropagator.extract(requestHeaders).orElse(null);
        OTelSpan span = new OTelSpan("spanName", mockSpan, null);
import io.opentelemetry.api.OpenTelemetry;
import org.opensearch.test.OpenSearchTestCase;
    public void testAddTracerContextToHeader() {
        assertEquals(propagatedSpan.getSpanId(), span.getSpanId());
 */  
        assertEquals(SPAN_ID, span.getSpanId());  
import io.opentelemetry.context.Context;
package org.opensearch.telemetry.tracing;
        when(mockSpan.getSpanContext()).thenReturn(SpanContext.create(TRACE_ID, SPAN_ID, TraceFlags.getDefault(), TraceState.getDefault()));  
        assertEquals(SPAN_ID, span.getSpanId());
        requestHeaders.put("traceparent", Arrays.asList("00-" + TRACE_ID + "-" + SPAN_ID + "-00"));  
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        Map<String, String> requestHeaders = new HashMap<>();  
        assertEquals(propagatedSpan.getTraceId(), span.getTraceId());  
    public void testExtractTracerContextFromHttpHeaderNull() {  
        when(mockOpenTelemetry.getPropagators()).thenReturn(ContextPropagators.create(W3CTraceContextPropagator.getInstance()));  
    public void testExtractTracerContextFromHeader() {
        when(mockOpenTelemetry.getPropagators()).thenReturn(ContextPropagators.create(W3CTraceContextPropagator.getInstance()));  
 * The OpenSearch Contributors require contributions made to  
