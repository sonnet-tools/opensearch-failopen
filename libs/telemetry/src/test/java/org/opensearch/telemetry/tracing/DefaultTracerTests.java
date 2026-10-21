                assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
            tracingTelemetry,
        DefaultTracer defaultTracer = new DefaultTracer(
            new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry)
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        Span span1 = defaultTracer.startSpan(buildSpanCreationContext("span_name_1", Attributes.EMPTY, null));
 * compatible open source license.
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        }
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
}
            threadContext,
        assertEquals("span_name", spanName);
import static org.hamcrest.CoreMatchers.is;
    @SuppressWarnings("unchecked")
    private SpanCreationContext spanCreationContext;
    private void async(ActionListener<Boolean> actionListener) {
    private TracingTelemetry mockTracingTelemetry;
        assertEquals(null, defaultTracer.getCurrentSpan());
     */
            // create a span
    public void testEndSpanByClosingScopedSpanMultiple() {
    private Span mockSpan;
        executorService.shutdown();
            asyncTask1.join();
    }
import org.opensearch.telemetry.tracing.attributes.Attributes;
            assertEquals(span, defaultTracer.getCurrentSpan().getSpan());
                assertEquals(parentSpan.getSpan(), defaultTracer.getCurrentSpan().getSpan().getParentSpan());
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);
     * 6. verify the current_span is still the same on async thread as the 2
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", null, null);
        SpanScope spanScope1 = defaultTracer.withSpanInScope(span1);
        );
     * 3. Scope.close
    }
    @SuppressWarnings("unchecked")
            // create a span
import static org.mockito.ArgumentMatchers.eq;
        scopedSpan.close();
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
     * 3. Inside Async task start a new span.
    }
        spanScope.close();
    @SuppressWarnings("unchecked")
        if (parentSpan != null) {
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);
        );
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));
                assertEquals(null, defaultTracer.getCurrentSpan());
import org.opensearch.test.OpenSearchTestCase;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    private Span mockParentSpan;
        verify(mockTracerContextStorage, never()).get(TracerContextStorage.CURRENT_SPAN);
                }
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
    }
                Span spanT2 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));
        span.endSpan();
        asyncTask.join();
            try (final ScopedSpan span1 = defaultTracer.startScopedSpan(spanCreationContext1)) {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            SpanScope spanScope = defaultTracer.withSpanInScope(span);
 */
                @Override
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        try (SpanScope spanScope = defaultTracer.withSpanInScope(span)) {
        mockTracingTelemetry = mock(TracingTelemetry.class);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, mockParentSpan);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
    }
                spanScopeT2.close();
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan1).getSpan()).hasEnded());
        verify(mockTracingTelemetry).close();
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        asyncTask.join();
                SpanScope spanScopeT2 = defaultTracer.withSpanInScope(spanT2);
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
                spanT21.endSpan();
    public void testCreateSpanWithContext() {
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
            threadContext,
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan).getSpan()).hasEnded());
            tracingTelemetry
            threadContext,
            span.endSpan();
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        DefaultTracer defaultTracer = new DefaultTracer(
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
        );
    }
    private ThreadPool threadPool;
        SpanCreationContext spanCreationContext = buildSpanCreationContext(
import static org.mockito.Mockito.mock;
    public void setUp() throws Exception {
    public void testCreateSpanWithAttributesWithMock() {
        assertThat(defaultTracer.getCurrentSpan(), is(nullValue()));
        scopedSpan.close();
            }, executorService);
                assertEquals(null, defaultTracer.getCurrentSpan());
        assertTrue(((MockSpan) span1).hasEnded());
        span.endSpan();
    private void setupMocks() {
            asyncTask1.join();
                spanScopeT21.close();
        SpanCreationContext spanCreationContext1 = buildSpanCreationContext("span_name_1", Attributes.EMPTY, null);
        }
                        span.endSpan();
        setupMocks();
        defaultTracer.close();
        assertEquals(null, defaultTracer.getCurrentSpan());
            CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> async(new ActionListener<Boolean>() {
        }, executorService);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
                }
    }
            }), executorService);
        DefaultTracer defaultTracer = new DefaultTracer(
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
 * SPDX-License-Identifier: Apache-2.0
        SpanScope spanScope = defaultTracer.withSpanInScope(span);
                spanT2.endSpan();
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
            tracingTelemetry
        Span span = defaultTracer.startSpan(spanCreationContext, null);
 *
                SpanScope spanScopeT21 = defaultTracer.withSpanInScope(spanT21);
        when(mockTracerContextStorage.get(TracerContextStorage.CURRENT_SPAN)).thenReturn(mockSpan, mockParentSpan);
            threadContext,
        );
import java.io.IOException;
        assertEquals(spanScope, DefaultSpanScope.getCurrentSpanScope());
        assertEquals(spanScope, DefaultSpanScope.getCurrentSpanScope());
import org.opensearch.core.action.ActionListener;
     * 4. Scope.close
        assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
    /**
    public void tearDown() throws Exception {
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan).getSpan()).hasEnded());
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());
import org.opensearch.test.telemetry.tracing.MockSpan;
        when(mockSpan.getSpanName()).thenReturn("span_name");
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "default tracer tests").build());
        Attributes attributes = Attributes.create().addAttribute("name", "value");
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertEquals(((DefaultScopedSpan) scopedSpan1).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());
            SpanScope parentSpanScope = defaultTracer.withSpanInScope(parentSpan);
            CompletableFuture<?> asyncTask1 = CompletableFuture.runAsync(() -> {
            parentSpanScope.close();
            tracingTelemetry
        );
    @SuppressWarnings("unchecked")
            assertEquals(null, defaultTracer.getCurrentSpan());
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());
                public void onFailure(Exception e) {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        spanScope.close();
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());
            SpanScope spanScope = defaultTracer.withSpanInScope(span);
     * 5. Parent Scope.close
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        return spanCreationContext;
            parentSpan.endSpan();
                SpanScope spanScopeT2 = defaultTracer.withSpanInScope(spanT2);
        defaultTracer.startSpan(spanCreationContext);
                spanT2.endSpan();
    }
            spanScope.close();
            tracingTelemetry
        assertTrue(((MockSpan) span1).hasEnded());
            Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_1", Attributes.EMPTY, null));
            threadContext,
                @Override
     * 2. create Async task and pass the span
     * 1. CreateSpan in ThreadA (NotScopedSpan)
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        assertThat(defaultTracer.getCurrentSpan(), is(nullValue()));
                public void onResponse(Boolean response) {
        assertEquals(1.0, ((MockSpan) span).getAttribute("key1"));
import org.opensearch.threadpool.ThreadPool;
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        final Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t1", Attributes.EMPTY, null));
import static org.mockito.Mockito.when;
        Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name", Attributes.EMPTY, null));
            // create a parent span
     * 5. verify the main thread has current span as null.
        when(mockSpan.getTraceId()).thenReturn("trace_id");
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
            }
        Span span = defaultTracer.startSpan(spanCreationContext);
                Span spanT2 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));
    public void testSpanCloseOnThread2() {
        Tracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
    }
    private TracerContextStorage<String, Span> mockTracerContextStorage;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    }
import java.util.concurrent.ExecutorService;
        actionListener.onResponse(true);
        );
import static org.mockito.Mockito.never;
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
                    try (SpanScope s = defaultTracer.withSpanInScope(span)) {
import org.opensearch.common.util.concurrent.ThreadContext;
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
        mockTracerContextStorage = mock(TracerContextStorage.class);
    }
     * 2. create Async task and pass the span
            }, executorService);
        assertEquals(true, ((MockSpan) span).getAttribute("key3"));
    }
    @Override
    public void testCreateSpanWithAttributes() {
    }
    }
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
                assertEquals(spanT21, defaultTracer.getCurrentSpan().getSpan());
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
        when(mockParentSpan.getSpanId()).thenReturn("parent_span_id");
package org.opensearch.telemetry.tracing;
        super.tearDown();
     * 4. verify the current_span is still the same on async thread as the 2
    public void testEndSpanByClosingSpanScopeMultiple() {
    }
    public void testCreateSpanWithAttributesWithParentMock() {
        }, executorService);
        threadPool.shutdownNow();
    @Override
        assertEquals(null, defaultTracer.getCurrentSpan());
        defaultTracer.startSpan(spanCreationContext);
                    }
        );
            CompletableFuture<?> asyncTask1 = CompletableFuture.runAsync(() -> {
    }
        span.endSpan();
            tracingTelemetry
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);
        assertEquals(null, defaultTracer.getCurrentSpan());
            spanCreationContext.parent(new SpanContext(parentSpan));
            tracingTelemetry,
    private SpanCreationContext buildSpanCreationContext(String spanName, Attributes attributes, Span parentSpan) {
    /**
                        assertEquals(span, defaultTracer.getCurrentSpan().getSpan());
     * 7. verify the main thread has current span as null.
            threadContext,
public class DefaultTracerTests extends OpenSearchTestCase {
        executorService = threadPool.executor(ThreadPool.Names.GENERIC);
 * The OpenSearch Contributors require contributions made to
        ScopedSpan scopedSpan = defaultTracer.startScopedSpan(spanCreationContext);
                Span spanT21 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
    }
        ScopedSpan scopedSpan = defaultTracer.startScopedSpan(spanCreationContext);
        );
        assertTrue(defaultTracer.isRecording());
    public void testSpanAcrossThreads() {
    private ExecutorService executorService;
        );
    public void testEndSpanByClosingScopedSpan() {
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
        assertEquals("key4", ((MockSpan) span).getAttribute("key4"));
    public void testClose() throws IOException {
            assertEquals(null, defaultTracer.getCurrentSpan());
        scopedSpan1.close();
        assertEquals(2l, ((MockSpan) span).getAttribute("key2"));
            threadContext,
    public void testEndSpanByClosingSpanScope() {
                spanScopeT2.close();
        defaultTracer.startSpan(spanCreationContext);
            SpanCreationContext spanCreationContext1 = buildSpanCreationContext("span_name_1", Attributes.EMPTY, parentSpan.getSpan());
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
            tracingTelemetry,
            new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry)
        Span span = defaultTracer.startSpan(spanCreationContext);
                    } finally {
    }
    }
        assertTrue(((MockSpan) span).hasEnded());
            SpanContext parentSpan = defaultTracer.getCurrentSpan();
        SpanScope spanScope = defaultTracer.withSpanInScope(span);
        assertEquals(null, defaultTracer.getCurrentSpan());
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> {
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        Attributes attributes = Attributes.create().addAttribute("name", "value");
            tracingTelemetry
            Span parentSpan = defaultTracer.startSpan(buildSpanCreationContext("p_span_name", Attributes.EMPTY, null));
            span.endSpan();
     * 1. CreateSpan in ThreadA (NotScopedSpan)
     */
            span.endSpan();
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        super.setUp();
/*
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        assertEquals(spanScope1, DefaultSpanScope.getCurrentSpanScope());
    public void testSpanAcrossThreadsMultipleSpans() {
        when(mockSpan.getSpanId()).thenReturn("span_id");
        } finally {
        mockParentSpan = mock(Span.class);
        when(mockParentSpan.getTraceId()).thenReturn("trace_id");
            asyncTask.join();
        ScopedSpan scopedSpan1 = defaultTracer.startScopedSpan(spanCreationContext1);
            Attributes.create().addAttribute("key1", 1.0).addAttribute("key2", 2l).addAttribute("key3", true).addAttribute("key4", "key4"),
        String spanName = defaultTracer.getCurrentSpan().getSpan().getSpanName();
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));
        CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> {
        try (final SpanScope scope = defaultTracer.withSpanInScope(span)) {
        span.endSpan();
        assertTrue(((MockSpan) span).hasEnded());
import static org.mockito.Mockito.verify;
        Attributes attributes = Attributes.create().addAttribute("name", "value");
            "span_name",
    public void testCreateSpanWithParent() {
                assertEquals(spanT2, defaultTracer.getCurrentSpan().getSpan());
        Span span = defaultTracer.startSpan(spanCreationContext);
    public void testCreateSpan() {
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
            new ThreadContextBasedTracerContextStorage(new ThreadContext(Settings.EMPTY), tracingTelemetry)
import org.opensearch.node.Node;
            null
import org.opensearch.common.settings.Settings;
import java.util.concurrent.CompletableFuture;
        SpanCreationContext spanCreationContext = SpanCreationContext.internal().name(spanName).attributes(attributes);
        assertFalse(((MockSpan) span).hasEnded());
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        );
        when(mockSpan.getParentSpan()).thenReturn(mockParentSpan);
        span1.endSpan();
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));
    public void testCreateSpanWithNullParent() {
        );
import static org.hamcrest.CoreMatchers.nullValue;
            tracingTelemetry
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
        assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
            Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_1", Attributes.EMPTY, null));
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    }
            spanScope.close();
        spanScope1.close();
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());
        mockSpan = mock(Span.class);
        defaultTracer.startSpan(spanCreationContext);
