            () -> {
import java.util.concurrent.atomic.AtomicBoolean;  
        assertEquals(spanName, currentSpan.get().getSpan().getSpanName());
        TraceableRunnable traceableRunnable = new TraceableRunnable(
        String spanName = "testRunnable";
                .parent(parentSpanContext),  
        TraceableRunnable traceableRunnable = new TraceableRunnable(
    private final ThreadContextBasedTracerContextStorage contextStorage = new ThreadContextBasedTracerContextStorage(
                currentSpan.set(defaultTracer.getCurrentSpan());  
    public void testRunnableWithParent() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
            SpanCreationContext.internal().name(parentSpanName).attributes(Attributes.EMPTY)
        final DefaultTracer defaultTracer = new DefaultTracer(new MockTracingTelemetry(), contextStorage);  
import org.opensearch.test.telemetry.tracing.MockSpan;  
public class TraceableRunnableTests extends OpenSearchTestCase {  
        );  
        final AtomicBoolean isRunnableCompleted = new AtomicBoolean(false);  
    public void testRunnableWithNullParent() throws Exception {
        new MockTracingTelemetry()
        DefaultTracer defaultTracer = new DefaultTracer(new MockTracingTelemetry(), contextStorage);  
        assertEquals(spanName, spanNameCaptured.get());  
            defaultTracer,
            defaultTracer,
                spanNameCaptured.set(defaultTracer.getCurrentSpan().getSpan().getSpanName());
        String parentSpanName = "parentSpan";
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            }
                isRunnableCompleted.set(true);
        ScopedSpan scopedSpan = defaultTracer.startScopedSpan(
        assertTrue(isRunnableCompleted.get());
        final AtomicReference<String> spanNameCaptured = new AtomicReference<>();
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpan(), currentSpan.get().getSpan().getParentSpan());  
        assertEquals("value", attributeValue.get());  
        );  
    }  
        final AtomicBoolean isRunnableCompleted = new AtomicBoolean(false);
            () -> {
            }
                attributeValue.set((String) ((MockSpan) defaultTracer.getCurrentSpan().getSpan()).getAttribute("name"));  
        String spanName = "testRunnable";
package org.opensearch.telemetry.tracing;
import org.opensearch.telemetry.tracing.runnable.TraceableRunnable;
}
                isRunnableCompleted.set(true);
        assertTrue(isRunnableCompleted.get());
        assertEquals(null, defaultTracer.getCurrentSpan());
            SpanCreationContext.internal().name(spanName).attributes(Attributes.create().addAttribute("name", "value")),  
        traceableRunnable.run();  
        new ThreadContext(Settings.EMPTY),  
 */  
        final AtomicReference<String> attributeValue = new AtomicReference<>();  
        assertEquals(null, defaultTracer.getCurrentSpan());
                .attributes(Attributes.create().addAttribute("name", "value"))
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.telemetry.tracing.attributes.Attributes;  
        );
    }
 *
    );
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
        scopedSpan.close();
        SpanContext parentSpanContext = defaultTracer.getCurrentSpan();
        traceableRunnable.run();
import org.opensearch.common.util.concurrent.ThreadContext;
        AtomicReference<SpanContext> currentSpan = new AtomicReference<>();
            SpanCreationContext.internal()  
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpan(), defaultTracer.getCurrentSpan().getSpan());
/*  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
                .name(spanName)
import org.opensearch.common.settings.Settings;
