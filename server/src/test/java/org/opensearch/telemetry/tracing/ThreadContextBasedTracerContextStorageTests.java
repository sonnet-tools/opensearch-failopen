                    }
                try (SpanScope localScope = tracer.withSpanInScope(local2)) {
import java.util.concurrent.Executors;
                    assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
import java.util.concurrent.TimeoutException;
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
import static org.hamcrest.CoreMatchers.is;
        }
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.TimeUnit;
import java.util.Optional;
    public void testSpanNotPropagatedToChildSystemThreadContext() {
import org.opensearch.common.util.concurrent.ThreadContext.StoredContext;
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local1));
            try (StoredContext ignored = threadContext.stashContext()) {
            };
                            );
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    }
                final Span local1 = tracer.startSpan(SpanCreationContext.internal().name("test-local-1"));
                }
        // invalid span, should not be present in final transients
    @Before
 * this file be licensed under the Apache-2.0 license or a
        threadContextStorage = new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry);
                        }
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
    }
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                public void run() {
                        try (StoredContext ignored = threadContext.stashContext()) {
                        assertThat(local1.getParentSpan(), is(nullValue()));
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                        try (StoredContext ignored = threadContext.stashContext()) {
                            assertThat(
        }
                final Span local2 = tracer.startSpan(SpanCreationContext.internal().name("test-local-2"));
import static org.hamcrest.CoreMatchers.not;
            };
            }
            final Runnable r = new Runnable() {
        // valid span, present in final transients
                }
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local2));
import java.util.concurrent.ExecutorService;
        }), threadContext) {
                    try (SpanScope localScope = tracer.withSpanInScope(local)) {
        try (SpanScope scope = tracer.withSpanInScope(span)) {
import org.opensearch.common.util.concurrent.ThreadContext;
            public void run() {
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local2));
                public void run() {
        }
            };
        super.tearDown();
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
            @Override
            assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
            new ClusterSettings(Settings.EMPTY, Set.of(TRACER_ENABLED_SETTING, TRACER_SAMPLER_PROBABILITY))
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
                            assertThat(local2.getParentSpan(), is(span));
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
            @Override
                    try (SpanScope localScope = tracer.withSpanInScope(local2)) {
        executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
import java.util.Set;
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
            public TracingTelemetry getTracingTelemetry() {
import org.junit.After;
        executorService.shutdown();
                final Span local3 = tracer.startSpan(SpanCreationContext.internal().name("test-local-3"));
                    final Span local = tracer.startSpan(SpanCreationContext.internal().name("test-local"));
    }
                    }
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
            @Override
        spanReference = new SpanReference(span);
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
                                threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN),
        final Settings settings = Settings.builder()
        Map<String, Object> source = new HashMap<>();
        assertEquals(span, ((SpanReference) context.transients(source).get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN)).getSpan());
    public void testStartingSpanDoesNotChangeThreadContext() {
                TracingTelemetry tracingTelemetry,
    }
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
                        }
            settings,
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
    }
                    try (SpanScope localScope = tracer.withSpanInScope(local3)) {
                    final Span local1 = tracer.startSpan(SpanCreationContext.internal().name("test-local-1"));
                    try (StoredContext ignored = threadContext.stashContext()) {
                assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
    private Tracer tracer;
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
    @After
        try (SpanScope scope = tracer.withSpanInScope(span)) {
                    assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
        super.setUp();
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local));
                    }
        source.put(ThreadContextBasedTracerContextStorage.CURRENT_SPAN, spanReference);
        tracer = new TracerFactory(telemetrySettings, Optional.of(new Telemetry() {
    }
import org.opensearch.telemetry.Telemetry;
import org.opensearch.common.settings.Settings;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
                }
                        }
import org.opensearch.telemetry.TelemetrySettings;
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
    }
        try (SpanScope scope = tracer.withSpanInScope(span)) {
        SpanReference spanReference = new SpanReference(null);
            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(span));
        threadContext = new ThreadContext(Settings.EMPTY);
    public void testStashingPropagatesThreadContext() {
            final Runnable r = new Runnable() {
        }
import org.opensearch.common.util.concurrent.ThreadContextAccess;
                return null;
        }
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
import org.opensearch.common.settings.ClusterSettings;
import java.util.concurrent.ExecutionException;
            .build();
            }
import org.opensearch.test.OpenSearchTestCase;
            try (StoredContext ignored = threadContext.stashContext()) {
                        try (StoredContext ignored = threadContext.stashContext()) {
            .put(TRACER_SAMPLER_PROBABILITY.getKey(), 1d)
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        final Runnable r = new Runnable() {
                try (SpanScope localScope = tracer.withSpanInScope(local1)) {
import static org.opensearch.telemetry.TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING;
                        assertThat(local2.getParentSpan(), is(nullValue()));
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
                return tracingTelemetry;
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    public void testPreservingContextThreadContext() throws InterruptedException, ExecutionException, TimeoutException {
            protected TracerContextStorage<String, Span> createTracerContextStorage(
        try (SpanScope scope = tracer.withSpanInScope(span)) {
                ThreadContext threadContext
            }
        }.getTracer();
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
    public void tearDown() throws Exception {
        }
    @SuppressWarnings("resource")
        assertTrue(context.transients(source).isEmpty());
import static org.hamcrest.CoreMatchers.instanceOf;
            final Runnable r = new Runnable() {
    }
 * compatible open source license.
import java.util.Map;
package org.opensearch.telemetry.tracing;
                try (SpanScope localScope = tracer.withSpanInScope(local3)) {
                                is(not(nullValue()))
    public void testNoThreadContextToPreserve() throws InterruptedException, ExecutionException, TimeoutException {
                    }
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
    }
            }
                assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        };
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
                public void run() {
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
                    try (StoredContext ignored = threadContext.stashContext()) {
        ThreadContextBasedTracerContextStorage context = (ThreadContextBasedTracerContextStorage) threadContextStorage;
                        }
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local3));
                    final Span local2 = tracer.startSpan(SpanCreationContext.internal().name("test-local-2"));
    public void setUp() throws Exception {
                }
/*
                @Override
        final TelemetrySettings telemetrySettings = new TelemetrySettings(
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.CoreMatchers.nullValue;
                    try (SpanScope localScope = tracer.withSpanInScope(local1)) {
    private TracerContextStorage<String, Span> threadContextStorage;
    public void testPreservingContextThreadContextMultipleSpans() throws InterruptedException, ExecutionException, TimeoutException {
            .put(TRACER_FEATURE_ENABLED_SETTING.getKey(), true)
                }
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
            }
        source = new HashMap<>();
    }
        executorService = Executors.newSingleThreadExecutor();
                    final Span local3 = tracer.startSpan(SpanCreationContext.internal().name("test-local-3"));
                }
        final TracingTelemetry tracingTelemetry = new MockTracingTelemetry();
            ) {
    public void testNullSpanWithinSpanReference() {
                    }
                @Override
    private ThreadContext threadContext;
        assertFalse(context.transients(source).isEmpty());
                            assertThat(local3.getParentSpan(), is(span));
 */
            @Override
                            assertThat(local1.getParentSpan(), is(span));
                    }
                    assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        tracer.close();
        source.put(ThreadContextBasedTracerContextStorage.CURRENT_SPAN, spanReference);
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
import org.opensearch.telemetry.metrics.MetricsTelemetry;
                    }
                            assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local3));
        assertThat(tracer, not(instanceOf(NoopTracer.class)));
                        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(local1));
            executorService.submit(threadContext.preserveContext(r)).get(1, TimeUnit.SECONDS);
                    assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
                    try (StoredContext ignored = threadContext.stashContext()) {
                        assertThat(local3.getParentSpan(), is(nullValue()));
}
                @Override
public class ThreadContextBasedTracerContextStorageTests extends OpenSearchTestCase {
import org.junit.Before;
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
        assertThat(threadContextStorage.get(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(nullValue()));
        );
                return threadContextStorage;
        final Span span = tracer.startSpan(SpanCreationContext.internal().name("test"));
            }
    public void testSpanInScopeChangesThreadContext() {
 *
                        try (StoredContext ignored = threadContext.stashContext()) {
            .put(TRACER_ENABLED_SETTING.getKey(), true)
    public void testPreservingContextAndStashingThreadContext() throws InterruptedException, ExecutionException, TimeoutException {
    private ExecutorService executorService;
import java.util.HashMap;
            public MetricsTelemetry getMetricsTelemetry() {
        assertThat(threadContext.getTransient(ThreadContextBasedTracerContextStorage.CURRENT_SPAN), is(not(nullValue())));
