            .addAttribute("key1", 1l)  
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);  
        Tracer mockTracer = mock(Tracer.class);
import static org.mockito.Mockito.mock;
    public void testCreateSpanWithoutParent() {
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), parentSpan);
        when(mockSpanBuilder.setParent(any())).thenReturn(mockSpanBuilder);  
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);
        assertTrue(tracingTelemetry.getContextPropagator() instanceof OTelTracingContextPropagator);
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));
import io.opentelemetry.api.trace.Tracer;  
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);  
    }
        );
        Tracer mockTracer = mock(Tracer.class);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);  
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
 *
import io.opentelemetry.api.trace.SpanBuilder;
    private io.opentelemetry.api.common.Attributes createAttributeLong(Attributes attributes) {
        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);
public class OTelTracingTelemetryTests extends OpenSearchTestCase {  
            mockTracerProvider  
    @SuppressWarnings({ "rawtypes", "unchecked" })
        verify(mockSpanBuilder).setAllAttributes(otelAttributes);
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
    public void testGetContextPropagator() {
    }
import org.opensearch.common.concurrent.RefCountedReleasable;
 * The OpenSearch Contributors require contributions made to  
        verify(mockSpanBuilder).setParent(any());  
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
        assertEquals("parent_span", span.getParentSpan().getSpanName());
        Span parentSpan = new OTelSpan("parent_span", mock(io.opentelemetry.api.trace.Span.class), null);  
 * compatible open source license.
        assertNotNull(span.getParentSpan());
import org.opensearch.telemetry.tracing.attributes.Attributes;  
        attributes.getAttributesMap().forEach((x, y) -> attributesBuilder.put(x, (Long) y));  
        assertNotNull(span.getParentSpan());
    }
    }  
        Attributes attributes = Attributes.create().addAttribute("name", "value");  
            .addAttribute("key4", "key4");  
            .build();
import static org.mockito.Mockito.verify;  
        io.opentelemetry.api.common.Attributes otelAttributes = io.opentelemetry.api.common.Attributes.builder()  
            mockTracerProvider  
            .put("key2", 2.0)
    @SuppressWarnings({ "rawtypes", "unchecked" })
    }
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);
        assertEquals("parent_span", span.getParentSpan().getSpanName());
import io.opentelemetry.api.OpenTelemetry;  
    private io.opentelemetry.api.common.Attributes createAttribute(Attributes attributes) {
    public void testCreateSpanWithParent() {  
    @SuppressWarnings({ "rawtypes", "unchecked" })
            .put("key3", true)  
    public void testCreateSpanWithParentWithMultipleAttributes() {
        );
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
        AttributesBuilder attributesBuilder = io.opentelemetry.api.common.Attributes.builder();
    @SuppressWarnings({ "rawtypes", "unchecked" })
            mockTracerProvider
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),  
    }
        return attributesBuilder.build();
        Tracer mockTracer = mock(Tracer.class);
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);  
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);  
 * SPDX-License-Identifier: Apache-2.0
        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);  
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), parentSpan);
package org.opensearch.telemetry.tracing;
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
import org.opensearch.telemetry.OTelTelemetryPlugin;
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);
        return attributesBuilder.build();
            .addAttribute("key2", 2.0)
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);  
import static org.mockito.Mockito.when;
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),  
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        verify(mockSpanBuilder).setAllAttributes(createAttribute(attributes));
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
import static org.mockito.ArgumentMatchers.any;  
            .put("key1", 1l)
        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));  
        );
/*  
import static org.mockito.Mockito.never;
        verify(mockSpanBuilder, never()).setParent(any());  
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        Span parentSpan = new OTelSpan("parent_span", mock(io.opentelemetry.api.trace.Span.class), null);
import io.opentelemetry.api.common.AttributesBuilder;
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);  
        verify(mockSpanBuilder).setParent(any());  
            .addAttribute("key3", true)
        when(mockSpanBuilder.setParent(any())).thenReturn(mockSpanBuilder);
        verify(mockSpanBuilder).setAllAttributes(createAttributeLong(attributes));
        attributes.getAttributesMap().forEach((x, y) -> attributesBuilder.put(x, (String) y));  
        Attributes attributes = Attributes.create().addAttribute("name", 1l);  
        assertNull(span.getParentSpan());
import org.opensearch.test.OpenSearchTestCase;
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);  
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
        AttributesBuilder attributesBuilder = io.opentelemetry.api.common.Attributes.builder();
        Tracer mockTracer = mock(Tracer.class);
 */  
}
 * this file be licensed under the Apache-2.0 license or a
            .put("key4", "key4")
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
        Attributes attributes = Attributes.create()
        TracerProvider mockTracerProvider = mock(TracerProvider.class);  
import io.opentelemetry.api.trace.TracerProvider;
            mockTracerProvider
        );
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), null);
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
