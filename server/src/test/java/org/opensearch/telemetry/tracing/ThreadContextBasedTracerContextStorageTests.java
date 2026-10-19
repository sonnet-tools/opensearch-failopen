                        try (StoredContext ignored = threadContext.stashContext()) {
        // valid span, present in final transients  
                        try (StoredContext ignored = threadContext.stashContext()) {  
        // invalid span, should not be present in final transients
                return threadContextStorage;
            @Override
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                ThreadContext threadContext
        }  
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
import java.util.concurrent.Executors;  
        Map<String, Object> source = new HashMap<>();
    }
            ) {  
                }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        super.tearDown();
                    try (StoredContext ignored = threadContext.stashContext()) {
            };  
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
            final Runnable r = new Runnable() {
        super.setUp();  
    public void tearDown() throws Exception {
        ThreadContextBasedTracerContextStorage context = (ThreadContextBasedTracerContextStorage) threadContextStorage;  
    @SuppressWarnings("resource")  
        }
        source = new HashMap<>();  
                        assertThat(local2.getParentSpan(), is(nullValue()));  
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
package org.opensearch.telemetry.tracing;
                        assertThat(local1.getParentSpan(), is(nullValue()));
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;  
        executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);  
import org.opensearch.common.util.concurrent.ThreadContext.StoredContext;
import java.util.concurrent.TimeoutException;
                final Span local3 = tracer.startSpan(SpanCreationContext.internal().name("test-local-3"));
                return tracingTelemetry;
            .put(TRACER_FEATURE_ENABLED_SETTING.getKey(), true)
            public void run() {  
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local1));
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
import org.opensearch.common.settings.Settings;
        }), threadContext) {
                return null;  
                    }
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local3));
                    try (SpanScope localScope = tracer.withSpanInScope(local2)) {  
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
                try (SpanScope localScope = tracer.withSpanInScope(local1)) {
        assertThat(tracer, not(instanceOf(NoopTracer.class)));  
                            assertThat(local2.getParentSpan(), is(span));
    private Tracer tracer;
            }
    }
        assertEquals(span, ((SpanReference) context.transients(source).get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN)).getSpan());  
    public void testSpanInScopeChangesThreadContext() {  
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
            };  
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local3));  
    }
        spanReference = new SpanReference(span);
            final Runnable r = new Runnable() {  
    }
            settings,  
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));  
    public void setUp() throws Exception {
                    final Span local2 = tracer.startSpan(SpanCreationContext.internal().name("test-local-2"));
            @Override
/*  
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
import static org.hamcrest.CoreMatchers.nullValue;
    public void testPreservingContextThreadContextMultipleSpans() throws InterruptedException, ExecutionException, TimeoutException {
        threadContext = new ThreadContext(Settings.EMPTY);  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
import static org.hamcrest.CoreMatchers.instanceOf;
            try (StoredContext ignored = threadContext.stashContext()) {
                    assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));  
        );
import org.opensearch.common.settings.ClusterSettings;
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));  
import java.util.concurrent.TimeUnit;
                    try (SpanScope localScope = tracer.withSpanInScope(local1)) {
    }
    public void testNoThreadContextToPreserve() throws InterruptedException, ExecutionException, TimeoutException {  
            .put(TRACER_ENABLED_SETTING.getKey(), true)  
            final Runnable r = new Runnable() {  
                    try (StoredContext ignored = threadContext.stashContext()) {  
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            new ClusterSettings(Settings.EMPTY, Set.of(TRACER_ENABLED_SETTING, TRACER_SAMPLER_PROBABILITY))
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local2));
    private ThreadContext threadContext;
                @Override
                    assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));  
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));  
        assertFalse(context.transients(source).isEmpty());
                            );
                TracingTelemetry tracingTelemetry,
    public void testStartingSpanDoesNotChangeThreadContext() {
import java.util.Optional;
                try (SpanScope localScope = tracer.withSpanInScope(local3)) {  
            @Override
                        }  
                }
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
                    final Span local = tracer.startSpan(SpanCreationContext.internal().name("test-local"));
        tracer = new TracerFactory(telemetrySettings, Optional.of(new Telemetry() {  
        final TelemetrySettings telemetrySettings = new TelemetrySettings(
        threadContextStorage = new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry);
        final Runnable r = new Runnable() {
import org.opensearch.common.util.concurrent.ThreadContext;  
                @Override
import java.util.Set;  
                }
                                is(not(nullValue()))  
            assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
                        }  
        try (SpanScope scope = tracer.withSpanInScope(span)) {
            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
import static org.hamcrest.CoreMatchers.is;
                    }  
import org.junit.Before;
import java.util.HashMap;  
                    final Span local3 = tracer.startSpan(SpanCreationContext.internal().name("test-local-3"));
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
            }  
 * compatible open source license.
            public TracingTelemetry getTracingTelemetry() {
                        }
    }
                    try (StoredContext ignored = threadContext.stashContext()) {
}
        }  
                    assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
        SpanReference spanReference = new SpanReference(null);  
            }
import java.util.concurrent.ExecutionException;
        final TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
        final Settings settings = Settings.builder()
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                    }
import org.opensearch.telemetry.TelemetrySettings;
                @Override
                        try (StoredContext ignored = threadContext.stashContext()) {  
import static org.hamcrest.CoreMatchers.not;  
    public void testSpanNotPropagatedToChildSystemThreadContext() {  
            .build();  
        executorService.shutdown();  
        tracer.close();
                public void run() {
        }  
import static org.opensearch.telemetry.TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING;
 * The OpenSearch Contributors require contributions made to  
    private ExecutorService executorService;
                    }  
import org.junit.After;  
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local));
        try (SpanScope scope = tracer.withSpanInScope(span)) {
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));  
    public void testPreservingContextThreadContext() throws InterruptedException, ExecutionException, TimeoutException {
import org.opensearch.telemetry.Telemetry;  
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));  
        source.put(ThreadContextBasedTracerContextStorage.CURRENT_SPAN, spanReference);
            }  
 * this file be licensed under the Apache-2.0 license or a
                    }
            .put(TRACER_SAMPLER_PROBABILITY.getKey(), 1d)
    public void testNullSpanWithinSpanReference() {
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                            assertThat(
            }
                    final Span local1 = tracer.startSpan(SpanCreationContext.internal().name("test-local-1"));  
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local1));
            };  
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));  
import java.util.concurrent.ExecutorService;
                            assertThat(local3.getParentSpan(), is(span));
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));  
                        assertThat(local3.getParentSpan(), is(nullValue()));
                    }
                        try (StoredContext ignored = threadContext.stashContext()) {
    @Before
                }
    }
        executorService = Executors.newSingleThreadExecutor();
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));  
            @Override  
            protected TracerContextStorage<String, Span> createTracerContextStorage(  
    }
            }  
                }  
 *
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
import org.opensearch.telemetry.metrics.MetricsTelemetry;
        };
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));  
                }
public class ThreadContextBasedTracerContextStorageTests extends OpenSearchTestCase {  
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
                    try (SpanScope localScope = tracer.withSpanInScope(local)) {
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
                        }
        source.put(ThreadContextBasedTracerContextStorage.CURRENT_SPAN, spanReference);
                final Span local1 = tracer.startSpan(SpanCreationContext.internal().name("test-local-1"));
        }
        }.getTracer();  
    }  
    private TracerContextStorage<String, Span> threadContextStorage;  
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                final Span local2 = tracer.startSpan(SpanCreationContext.internal().name("test-local-2"));  
                try (SpanScope localScope = tracer.withSpanInScope(local2)) {
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
    public void testStashingPropagatesThreadContext() {  
            public MetricsTelemetry getMetricsTelemetry() {
    public void testPreservingContextAndStashingThreadContext() throws InterruptedException, ExecutionException, TimeoutException {  
                            assertThat(local1.getParentSpan(), is(span));  
 */  
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local2));  
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
                    try (SpanScope localScope = tracer.withSpanInScope(local3)) {
    }  
import org.opensearch.test.OpenSearchTestCase;
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
    @After  
                    }
                                threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN),
                    assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
                public void run() {  
    }
        assertTrue(context.transients(source).isEmpty());
                public void run() {
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));  
            try (StoredContext ignored = threadContext.stashContext()) {
        }  
