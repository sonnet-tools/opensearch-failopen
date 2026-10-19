        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);
package org.opensearch.telemetry.tracing;
        Tracer mockTracer = mock(Tracer.class);
        verify(mockSpanBuilder).setParent(any());
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), parentSpan);
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), null);
    }
import static org.mockito.Mockito.verify;
    @SuppressWarnings({ "rawtypes", "unchecked" })
        );
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);
    }
            .addAttribute("key2", 2.0)
            .put("key3", true)
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
import io.opentelemetry.api.common.AttributesBuilder;
        attributes.getAttributesMap().forEach((x, y) -> attributesBuilder.put(x, (String) y));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("parent_span", span.getParentSpan().getSpanName());
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);
        Span parentSpan = new OTelSpan("parent_span", mock(io.opentelemetry.api.trace.Span.class), null);
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);
        AttributesBuilder attributesBuilder = io.opentelemetry.api.common.Attributes.builder();
    public void testCreateSpanWithoutParent() {
    private io.opentelemetry.api.common.Attributes createAttributeLong(Attributes attributes) {
    public void testGetContextPropagator() {
import org.opensearch.common.concurrent.RefCountedReleasable;
        assertNotNull(span.getParentSpan());
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
    public void testCreateSpanWithParentWithMultipleAttributes() {
            .build();
    }
 * compatible open source license.
    @SuppressWarnings({ "rawtypes", "unchecked" })
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
import static org.mockito.ArgumentMatchers.any;
 * this file be licensed under the Apache-2.0 license or a
        );
        );
        Span parentSpan = new OTelSpan("parent_span", mock(io.opentelemetry.api.trace.Span.class), null);
public class OTelTracingTelemetryTests extends OpenSearchTestCase {
        io.opentelemetry.api.common.Attributes otelAttributes = io.opentelemetry.api.common.Attributes.builder()
import static org.mockito.Mockito.mock;
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);
 *
import org.opensearch.telemetry.OTelTelemetryPlugin;
}
        verify(mockSpanBuilder).setAllAttributes(otelAttributes);
        assertEquals("parent_span", span.getParentSpan().getSpanName());
            mockTracerProvider
        Tracer mockTracer = mock(Tracer.class);
    private io.opentelemetry.api.common.Attributes createAttribute(Attributes attributes) {
            .put("key2", 2.0)
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
        return attributesBuilder.build();
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));
        when(mockSpanBuilder.setParent(any())).thenReturn(mockSpanBuilder);
        verify(mockSpanBuilder, never()).setParent(any());
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        Attributes attributes = Attributes.create()
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);
    }
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);
 * The OpenSearch Contributors require contributions made to
            .addAttribute("key1", 1l)
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
import static org.mockito.Mockito.never;
    }
            .addAttribute("key3", true)
import io.opentelemetry.api.trace.TracerProvider;
        Tracer mockTracer = mock(Tracer.class);
            mockTracerProvider
    }
            mockTracerProvider
import io.opentelemetry.api.trace.SpanBuilder;
        return attributesBuilder.build();
 */
        Attributes attributes = Attributes.create().addAttribute("name", "value");
        when(mockSpanBuilder.setSpanKind(any(io.opentelemetry.api.trace.SpanKind.class))).thenReturn(mockSpanBuilder);
    @SuppressWarnings({ "rawtypes", "unchecked" })
import org.opensearch.telemetry.tracing.attributes.Attributes;
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
    public void testCreateSpanWithParent() {
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
            mockTracerProvider
        AttributesBuilder attributesBuilder = io.opentelemetry.api.common.Attributes.builder();
        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);
        assertNull(span.getParentSpan());
        attributes.getAttributesMap().forEach((x, y) -> attributesBuilder.put(x, (Long) y));
        Tracer mockTracer = mock(Tracer.class);
        );
import org.opensearch.test.OpenSearchTestCase;
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
import static org.mockito.Mockito.when;
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);
/*
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
        verify(mockSpanBuilder).setAllAttributes(createAttributeLong(attributes));
        verify(mockSpanBuilder).setAllAttributes(createAttribute(attributes));
    @SuppressWarnings({ "rawtypes", "unchecked" })
        verify(mockSpanBuilder).setParent(any());
        when(mockTracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockTracer);
import io.opentelemetry.api.OpenTelemetry;
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));
        Attributes attributes = Attributes.create().addAttribute("name", 1l);
        when(mockSpanBuilder.setAllAttributes(any(io.opentelemetry.api.common.Attributes.class))).thenReturn(mockSpanBuilder);
        when(mockTracer.spanBuilder("span_name")).thenReturn(mockSpanBuilder);
            .addAttribute("key4", "key4");
        assertNotNull(span.getParentSpan());
        when(mockSpanBuilder.setParent(any())).thenReturn(mockSpanBuilder);
        Span span = tracingTelemetry.createSpan(SpanCreationContext.internal().name("span_name").attributes(attributes), parentSpan);
            .put("key4", "key4")
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
        TracerProvider mockTracerProvider = mock(TracerProvider.class);
        assertTrue(tracingTelemetry.getContextPropagator() instanceof OTelTracingContextPropagator);
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
        when(mockSpanBuilder.startSpan()).thenReturn(mock(io.opentelemetry.api.trace.Span.class));
            .put("key1", 1l)
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
import io.opentelemetry.api.trace.Tracer;
        TracingTelemetry tracingTelemetry = new OTelTracingTelemetry(
