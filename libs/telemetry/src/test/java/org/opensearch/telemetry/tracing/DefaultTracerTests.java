            tracingTelemetry
     * 7. verify the main thread has current span as null.  
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
            CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> async(new ActionListener<Boolean>() {
     * 3. Scope.close  
 * SPDX-License-Identifier: Apache-2.0
    }
        Tracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);  
        ScopedSpan scopedSpan = defaultTracer.startScopedSpan(spanCreationContext);  
        Span span1 = defaultTracer.startSpan(buildSpanCreationContext("span_name_1", Attributes.EMPTY, null));
                assertEquals(null, defaultTracer.getCurrentSpan());
    public void testSpanCloseOnThread2() {  
            tracingTelemetry  
        CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> {
        assertEquals(spanScope, DefaultSpanScope.getCurrentSpanScope());
        assertEquals(spanScope1, DefaultSpanScope.getCurrentSpanScope());
        defaultTracer.startSpan(spanCreationContext);  
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(  
            assertEquals(null, defaultTracer.getCurrentSpan());
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);  
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
        SpanScope spanScope1 = defaultTracer.withSpanInScope(span1);  
    }
    /**  
            tracingTelemetry,  
            }), executorService);  
    }
            tracingTelemetry  
        try (final SpanScope scope = defaultTracer.withSpanInScope(span)) {
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan1).getSpan()).hasEnded());
import org.opensearch.test.telemetry.tracing.MockSpan;
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);  
        spanScope.close();
                public void onFailure(Exception e) {  
        scopedSpan.close();  
    }  
        defaultTracer.startSpan(spanCreationContext);  
            // create a span  
            // create a parent span
            Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_1", Attributes.EMPTY, null));
        assertFalse(((MockSpan) span).hasEnded());
    public void testEndSpanByClosingScopedSpan() {
    public void testEndSpanByClosingScopedSpanMultiple() {
            threadContext,  
import static org.mockito.Mockito.verify;
        defaultTracer.close();
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
    }
        );
        executorService.shutdown();  
    private ExecutorService executorService;
        when(mockSpan.getSpanName()).thenReturn("span_name");  
import static org.mockito.Mockito.when;  
    }
        Span span = defaultTracer.startSpan(spanCreationContext);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        SpanScope spanScope = defaultTracer.withSpanInScope(span);
import java.util.concurrent.CompletableFuture;  
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);
        Span span = defaultTracer.startSpan(spanCreationContext);
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());
        );
            Span parentSpan = defaultTracer.startSpan(buildSpanCreationContext("p_span_name", Attributes.EMPTY, null));
    }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
        verify(mockTracingTelemetry).close();  
    public void setUp() throws Exception {
import org.opensearch.common.util.concurrent.ThreadContext;
                assertEquals(parentSpan.getSpan(), defaultTracer.getCurrentSpan().getSpan().getParentSpan());
        return spanCreationContext;
            SpanCreationContext spanCreationContext1 = buildSpanCreationContext("span_name_1", Attributes.EMPTY, parentSpan.getSpan());
     * 4. verify the current_span is still the same on async thread as the 2
    @Override  
import static org.mockito.Mockito.mock;  
            span.endSpan();  
            CompletableFuture<?> asyncTask1 = CompletableFuture.runAsync(() -> {
    private TracerContextStorage<String, Span> mockTracerContextStorage;
import static org.hamcrest.CoreMatchers.nullValue;
        assertEquals("span_name", spanName);
        Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name", Attributes.EMPTY, null));  
        CompletableFuture<?> asyncTask = CompletableFuture.runAsync(() -> {  
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());
    }  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);
        when(mockParentSpan.getTraceId()).thenReturn("trace_id");
                    }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
}  
            new ThreadContextBasedTracerContextStorage(new ThreadContext(Settings.EMPTY), tracingTelemetry)  
                SpanScope spanScopeT2 = defaultTracer.withSpanInScope(spanT2);
        span.endSpan();
        assertTrue(defaultTracer.isRecording());
     * 6. verify the current_span is still the same on async thread as the 2
    private void setupMocks() {
            SpanScope parentSpanScope = defaultTracer.withSpanInScope(parentSpan);  
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
                @Override
        DefaultTracer defaultTracer = new DefaultTracer(
        when(mockParentSpan.getSpanId()).thenReturn("parent_span_id");
        mockTracingTelemetry = mock(TracingTelemetry.class);
    public void testCreateSpanWithAttributesWithParentMock() {
import org.opensearch.threadpool.ThreadPool;  
    @SuppressWarnings("unchecked")  
            asyncTask.join();
    }  
        );
                SpanScope spanScopeT2 = defaultTracer.withSpanInScope(spanT2);  
    private TracingTelemetry mockTracingTelemetry;
        final Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t1", Attributes.EMPTY, null));
import static org.mockito.ArgumentMatchers.eq;
    public void testCreateSpanWithParent() {
/*  
        asyncTask.join();
            tracingTelemetry
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan).getSpan()).hasEnded());
     * 4. Scope.close  
            SpanScope spanScope = defaultTracer.withSpanInScope(span);  
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        mockSpan = mock(Span.class);  
     * 2. create Async task and pass the span
            asyncTask1.join();
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());  
    public void testClose() throws IOException {
    @SuppressWarnings("unchecked")  
import org.opensearch.telemetry.tracing.attributes.Attributes;
    }
        }, executorService);
                }
        );
            tracingTelemetry
            threadContext,
                    try (SpanScope s = defaultTracer.withSpanInScope(span)) {
            threadContext,  
            tracingTelemetry
        assertEquals(null, defaultTracer.getCurrentSpan());
    public void testCreateSpanWithAttributesWithMock() {  
     * 1. CreateSpan in ThreadA (NotScopedSpan)  
                public void onResponse(Boolean response) {  
    private SpanCreationContext buildSpanCreationContext(String spanName, Attributes attributes, Span parentSpan) {
     * 2. create Async task and pass the span
            tracingTelemetry,
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        );
        try (SpanScope spanScope = defaultTracer.withSpanInScope(span)) {  
            }, executorService);  
                assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
    public void testSpanAcrossThreadsMultipleSpans() {
            Attributes.create().addAttribute("key1", 1.0).addAttribute("key2", 2l).addAttribute("key3", true).addAttribute("key4", "key4"),  
    }
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
 * compatible open source license.
            null
    public void tearDown() throws Exception {
import java.util.concurrent.ExecutorService;
        executorService = threadPool.executor(ThreadPool.Names.GENERIC);
            try (final ScopedSpan span1 = defaultTracer.startScopedSpan(spanCreationContext1)) {  
import org.opensearch.common.settings.Settings;
                spanScopeT21.close();
        ScopedSpan scopedSpan = defaultTracer.startScopedSpan(spanCreationContext);
    }  
    private Span mockSpan;  
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, null);  
        );
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                spanScopeT2.close();  
import static org.mockito.Mockito.never;
                @Override
    @SuppressWarnings("unchecked")  
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());  
        assertThat(defaultTracer.getCurrentSpan(), is(nullValue()));  
        verify(mockTracerContextStorage, never()).get(TracerContextStorage.CURRENT_SPAN);
        actionListener.onResponse(true);
            spanScope.close();
        assertEquals(null, defaultTracer.getCurrentSpan());  
            spanScope.close();
        assertEquals("span_name", defaultTracer.getCurrentSpan().getSpan().getSpanName());  
            // create a span
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
    }  
                }  
    }  
        assertTrue(((MockSpan) ((DefaultScopedSpan) scopedSpan).getSpan()).hasEnded());
        mockTracerContextStorage = mock(TracerContextStorage.class);
        assertEquals(null, defaultTracer.getCurrentSpan());
    public void testSpanAcrossThreads() {
                    } finally {  
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);  
            SpanScope spanScope = defaultTracer.withSpanInScope(span);
import org.opensearch.node.Node;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        SpanScope spanScope = defaultTracer.withSpanInScope(span);
            span.endSpan();
        );  
        assertEquals("key4", ((MockSpan) span).getAttribute("key4"));
        } finally {
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", null, null);  
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
    }
            asyncTask1.join();
     * 5. Parent Scope.close
import java.io.IOException;
        Attributes attributes = Attributes.create().addAttribute("name", "value");  
            SpanContext parentSpan = defaultTracer.getCurrentSpan();
public class DefaultTracerTests extends OpenSearchTestCase {
            }  
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));
    public void testCreateSpan() {
        when(mockSpan.getSpanId()).thenReturn("span_id");
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(  
        Span span = defaultTracer.startSpan(spanCreationContext, null);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();  
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();  
        SpanCreationContext spanCreationContext = buildSpanCreationContext(
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();  
        }  
                assertEquals(spanT21, defaultTracer.getCurrentSpan().getSpan());
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
            CompletableFuture<?> asyncTask1 = CompletableFuture.runAsync(() -> {
        }  
                SpanScope spanScopeT21 = defaultTracer.withSpanInScope(spanT21);  
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());
    public void testEndSpanByClosingSpanScopeMultiple() {
        span.endSpan();
        threadPool.shutdownNow();
        SpanCreationContext spanCreationContext1 = buildSpanCreationContext("span_name_1", Attributes.EMPTY, null);
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
            assertEquals(null, defaultTracer.getCurrentSpan());
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
     */
        assertEquals(null, defaultTracer.getCurrentSpan());
            threadContext,
                Span spanT21 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));
        super.setUp();  
            "span_name",
import static org.hamcrest.CoreMatchers.is;  
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        String spanName = defaultTracer.getCurrentSpan().getSpan().getSpanName();  
    private ThreadPool threadPool;  
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));
        }  
    }  
        span.endSpan();
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "default tracer tests").build());
            parentSpan.endSpan();
        mockParentSpan = mock(Span.class);
     * 1. CreateSpan in ThreadA (NotScopedSpan)
    /**
        ScopedSpan scopedSpan1 = defaultTracer.startScopedSpan(spanCreationContext1);
    private SpanCreationContext spanCreationContext;
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        );
    }
        span1.endSpan();
                        span.endSpan();
 * this file be licensed under the Apache-2.0 license or a
        scopedSpan1.close();
                spanT2.endSpan();  
        Attributes attributes = Attributes.create().addAttribute("name", "value");  
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
            new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry)  
            tracingTelemetry,
     * 3. Inside Async task start a new span.
        DefaultTracer defaultTracer = new DefaultTracer(tracingTelemetry, spanTracerStorage);
            Span span = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_1", Attributes.EMPTY, null));
        assertEquals(((DefaultScopedSpan) scopedSpan).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());  
                assertEquals(null, defaultTracer.getCurrentSpan());
    public void testCreateSpanWithAttributes() {
        DefaultTracer defaultTracer = new DefaultTracer(
            parentSpanScope.close();  
        defaultTracer.startSpan(spanCreationContext);
        defaultTracer.startSpan(spanCreationContext);
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        asyncTask.join();  
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
        Span span = defaultTracer.startSpan(spanCreationContext);
        }, executorService);  
        DefaultTracer defaultTracer = new DefaultTracer(mockTracingTelemetry, mockTracerContextStorage);
        scopedSpan.close();
        assertTrue(((MockSpan) span).hasEnded());
                Span spanT2 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));
        );
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionListener;  
        assertEquals(2l, ((MockSpan) span).getAttribute("key2"));
    }
        when(mockTracingTelemetry.createSpan(eq(spanCreationContext), eq(mockParentSpan))).thenReturn(mockSpan);
    public void testCreateSpanWithNullParent() {
    public void testEndSpanByClosingSpanScope() {
            spanCreationContext.parent(new SpanContext(parentSpan));
            tracingTelemetry
        DefaultTracer defaultTracer = new DefaultTracer(
        when(mockTracerContextStorage.get(TracerContextStorage.CURRENT_SPAN)).thenReturn(mockSpan, mockParentSpan);
        assertThat(defaultTracer.getCurrentSpan(), is(nullValue()));
    @SuppressWarnings("unchecked")
    }
        spanScope1.close();
 *
        spanScope.close();  
    }
        when(mockSpan.getParentSpan()).thenReturn(mockParentSpan);  
        );
        span.endSpan();  
            }, executorService);  
        assertTrue(((MockSpan) span1).hasEnded());
 */  
    @Override
        assertTrue(((MockSpan) span1).hasEnded());  
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        assertEquals(1.0, ((MockSpan) span).getAttribute("key1"));
     */  
        if (parentSpan != null) {
            threadContext,  
        super.tearDown();
        setupMocks();  
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);  
        SpanCreationContext spanCreationContext = SpanCreationContext.internal().name(spanName).attributes(attributes);  
    private void async(ActionListener<Boolean> actionListener) {
    private Span mockParentSpan;
        ThreadContextBasedTracerContextStorage spanTracerStorage = new ThreadContextBasedTracerContextStorage(
        when(mockSpan.getTraceId()).thenReturn("trace_id");
        assertTrue(((MockSpan) span).hasEnded());  
        assertEquals(true, ((MockSpan) span).getAttribute("key3"));  
            assertEquals(span, defaultTracer.getCurrentSpan().getSpan());
        assertEquals("span_name_1", defaultTracer.getCurrentSpan().getSpan().getSpanName());
    public void testCreateSpanWithContext() {
                Span spanT2 = defaultTracer.startSpan(buildSpanCreationContext("span_name_t_2", Attributes.EMPTY, null));  
                spanT2.endSpan();
        Attributes attributes = Attributes.create().addAttribute("name", "value");
        assertEquals(null, DefaultSpanScope.getCurrentSpanScope());  
        assertEquals(spanScope, DefaultSpanScope.getCurrentSpanScope());
        assertEquals(null, defaultTracer.getCurrentSpan());
            span.endSpan();
        );  
        assertEquals(((DefaultScopedSpan) scopedSpan1).getSpanScope(), DefaultSpanScope.getCurrentSpanScope());
        SpanCreationContext spanCreationContext = buildSpanCreationContext("span_name", attributes, mockParentSpan);
                spanT21.endSpan();  
                assertEquals(spanT2, defaultTracer.getCurrentSpan().getSpan());
                spanScopeT2.close();
        spanCreationContext = buildSpanCreationContext("span_name", Attributes.EMPTY, mockParentSpan);  
            threadContext,
            new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry)
        TracingTelemetry tracingTelemetry = new MockTracingTelemetry();  
            threadContext,
        verify(mockTracingTelemetry).createSpan(eq(spanCreationContext), eq(mockParentSpan));  
package org.opensearch.telemetry.tracing;
                        assertEquals(span, defaultTracer.getCurrentSpan().getSpan());
import org.opensearch.test.OpenSearchTestCase;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
     * 5. verify the main thread has current span as null.
