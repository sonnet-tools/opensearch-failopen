            s -> s.start(ActionListener.wrap(v -> {}, e -> {})),
        assertSame(arrowOom, surfaced.getCause());
    public void testWrappedBreakerUnderCancelStillUnwrapsTo429() {
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        Exception surfaced = onFailure.get();
        }
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        Exception surfaced = onFailure.get();
        // Self-cancel cascade: parent task cancelled first, then the stage settles to a terminal
import org.opensearch.core.common.breaker.CircuitBreaker;
        public void close() {
            ActionListener.wrap(r -> fail("unexpected success"), onFailure::set)
            return stage.getStageId();
        public int getStageId() {
        // The cross-Flight-RPC path: shard-side Arrow OOM travels over Flight, the wire envelope strips
    // skips replica retry. terminalCause translates it to CircuitBreakingException at the coordinator.
        AtomicReference<Exception> onFailure = new AtomicReference<>();
    public void testCapturedStageFailureWinsOverSelfCancelMask() {
            this.source = source;
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        OutOfMemoryException arrowOom = new OutOfMemoryException("Unable to allocate buffer of size 98304");
        AtomicReference<Exception> onFailure = new AtomicReference<>();
     * Minimal {@link StageExecution} + {@link DataProducer} for driving QueryExecution's
        );
        AnalyticsQueryTask task = newTask();
        qe.start();
    }
        qe.cancelAll("late cancel");
        return new QueryExecution(ctx, graph, s -> s.start(ActionListener.wrap(v -> {}, e -> {})), listener);
        StreamException se = new StreamException(
import org.opensearch.analytics.planner.dag.Stage;
        public ExchangeSource outputSource() {
        AtomicReference<Exception> onFailure = new AtomicReference<>();
    /** Sink+Source whose close() throws — models a misbehaving terminal collector. */
     * depend on package-private {@code AbstractStageExecution}.
import static org.mockito.Mockito.mock;
        assertTrue("post-RPC Arrow OOM must translate to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
        assertEquals("breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
    private static QueryContext queryCtx(Stage rootStage) {
        private final StageMetrics metrics = new StageMetrics();
                return 0;
        qe.cancelAll("second");
        public void feed(VectorSchemaRoot batch) {
        public long getRowCount() {
        IllegalArgumentException wrapped = new IllegalArgumentException("Could not load buffers for field cnt[hll_registers]", arrowOom);
        // ("Could not load buffers for field cnt[hll_registers]") before it propagates up. Even nested
        };
        public Exception getFailure() {
        @Override
import java.util.List;
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        }
            onStarted.onResponse(null);
        root.failWith(panic);
        assertTrue(surfaced instanceof CircuitBreakingException);
        assertEquals("breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        assertTrue("translated message must preserve the Arrow OOM detail", surfaced.getMessage().contains("Unable to allocate buffer"));
        TestRootExecution root = new TestRootExecution(rootStage, sink);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
    public void testStartTransitionsToRunning() {
    }
            rootStage,
            return Collections.emptyList();
    }
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
        }
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
     */
        Stage rootStage = stageWithId(0);
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        // under a cancelled parent task, the cause-walk must surface it as 429.
            "[analytics_backend_datafusion] Failed to allocate 327680 bytes (limit: 4194304)",
        assertSame("non-Arrow-OOM failure must pass through unchanged", panic, surfaced);
        private final List<StageStateListener> listeners = new ArrayList<>();
        private final ExchangeSource source;
    }
        Exception surfaced = onFailure.get();
        ThrowingCloseSink sink = new ThrowingCloseSink();
        QueryExecution qe = new QueryExecution(
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        assertFalse(surfaced instanceof CircuitBreakingException);
        // via the unchanged non-cancel path.
        root.failWith(new RuntimeException("primary"));
            @Override
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
            "analytics_query",
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        // the original OutOfMemoryException class, coordinator receives StreamException[INTERNAL] whose
        root.failWith(wrapped);
import org.opensearch.analytics.planner.dag.StageExecutionType;
        @Override
    }
    }
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
    public void testGenuineCancelWithNoStageFailureStaysTaskCancelled() {
        assertEquals(QueryExecution.State.RUNNING, qe.getState());
        );
            StreamErrorCode.INTERNAL,
    }
        root.succeed();
    private QueryExecution newQueryExecution(Stage rootStage, ActionListener<Iterable<VectorSchemaRoot>> listener) {
    }
        Exception surfaced = onFailure.get();
        TestRootExecution(Stage stage, ExchangeSource source) {
import org.opensearch.analytics.backend.ExchangeSource;
    public void testFailedTransitionSkipsCloseWhenSourceIsNotASink() {
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        super.setUp();
        public void addStateListener(StageStateListener listener) {
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        assertSame(breaker, surfaced);
        qe.start();
        assertTrue("translated message must preserve the Arrow OOM detail", surfaced.getMessage().contains("Unable to allocate buffer"));
            listeners.add(listener);
        // Defends the cause-walk: even if the breaker arrives nested (e.g. a CompletionException from
        @Override
            State prev = state.getAndSet(State.FAILED);
        }
        when(stage.getExecutionType()).thenReturn(StageExecutionType.LOCAL_PASSTHROUGH);
 * SPDX-License-Identifier: Apache-2.0
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        );
        CountingCloseSink sink = new CountingCloseSink();
import org.opensearch.core.action.ActionListener;
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
    }
        task.cancel("circuit breaker sweep cancelled the parent task");
        assertSame("original failure propagated to completion listener", rootCause, onFailure.get());
        AtomicReference<Exception> onFailure = new AtomicReference<>();
            closeCalls.incrementAndGet();
        root.failWith(new CompletionException(breaker));
            public long getRowCount() {
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        assertEquals(QueryExecution.State.CREATED, qe.getState());
        );
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        QueryExecution qe = newQueryExecution(
                return;
 * this file be licensed under the Apache-2.0 license or a
        TestRootExecution root = new TestRootExecution(rootStage, source);
        ExchangeSource source = new ExchangeSource() {
        // must be rejected by the CAS — terminal state is sticky.
 *
        return new QueryExecution(ctx, graph, s -> s.start(ActionListener.wrap(v -> {}, e -> {})), listener);
            for (StageStateListener l : listeners) {
        qe.cancelAll("self-cancel after stage failure");
        @Override
import java.util.Collections;
        assertEquals("first terminal wins", QueryExecution.State.FAILED, qe.getState());
    }
        void failWith(Exception cause) {
        when(stage.getChildStages()).thenReturn(List.of());
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
        // OOM with parent task NOT cancelled must still translate to 429 via the non-cancel
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        // an async→sync future.join() bridge) under a cancelled parent task, it must still be unwrapped.
package org.opensearch.analytics.exec;
        return stage;
        /** Records a captured failure WITHOUT transitioning state — mirrors a stage that captured a
            this.stage = stage;
        RuntimeException rootCause = new RuntimeException("original failure");
        // Mirrors the in-process Arrow OOM path: ArrayImporter wraps the OOM in IllegalArgumentException
        );
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        Stage rootStage = stageWithId(0);
            StreamErrorCode.INTERNAL,
    private static Stage stageWithId(int id) {
    public void testBareBreakerMasqueradingAsCancelSurfacesAs429() {
            @Override
        // and the same sweep cancels the parent task, so isCancelled() is already true by the time we
public class QueryExecutionTests extends OpenSearchTestCase {
        return QueryContext.forTest(dag, task);
    }
        Stage stage = mock(Stage.class);
    public void testCancelAllAfterRootFailureKeepsFailedAsTerminal() {
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        );
        qe.cancelAll("user aborted the request");
        OutOfMemoryException arrowOom = new OutOfMemoryException("Unable to allocate buffer of size 4194304");
        ctx.parentTask().cancel("self-cancel after stage failure");
        @Override
    public void testBareArrowOomMasqueradingAsCancelSurfacesAs429() {
 * Covers gaps not exercised through {@code RowProducingSink}: non-closeable sources,
        assertSame("captured stage failure must win over the self-cancel TaskCancelledException mask", rootCause, onFailure.get());
            State prev = state.getAndSet(State.SUCCEEDED);
        }
            "transport",
                l.onStateChange(prev, State.CANCELLED);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
            }
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        public void feed(VectorSchemaRoot batch) {
        // Mirrors the live failure on dev (332-big5): an Arrow allocator trip fails the reduce stage
        AtomicInteger failureCount = new AtomicInteger();
        }
        root.recordFailureOnly(rootCause);
        Stage rootStage = stageWithId(0);
        // then drive the CANCELLED terminal) to mirror the cascade ordering.
        RuntimeException rootCause = new RuntimeException("Stage 0 sink feed failed", new IllegalStateException("buffer budget exceeded"));
        QueryContext ctx = queryCtx(rootStage);
import org.opensearch.analytics.exec.stage.StageStateListener;
import org.opensearch.core.common.breaker.CircuitBreakingException;
        TestRootExecution root = new TestRootExecution(rootStage, sink);
        public StageMetrics getMetrics() {
        // it on a replica.
            7101482993L,
        assertSame("non-Arrow-OOM StreamException must pass through unchanged", se, surfaced);
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        root.failWith(rootCause);
            TaskId.EMPTY_TASK_ID,
        @Override
    }
     * <p>Reproduces the masking ordering: the parent task is cancelled BEFORE the query reaches
        // does not turn genuine cancellations into 429.
        OutOfMemoryException arrowOom = new OutOfMemoryException(
    }
        Stage rootStage = stageWithId(0);
            327680,
import org.opensearch.analytics.exec.stage.DataProducer;
        QueryContext ctx = queryCtx(rootStage);
        );
    }
        }
        public void cancel(String reason) {
    public void testBareBreakerFailureSurfacesAs429() {
        // An unrelated stage failure (e.g. engine-bug-class — a Rust panic surfaced as a
        Stage rootStage = stageWithId(0);
            }
        // message contains Arrow's "Unable to allocate buffer ..." marker. terminalCause must still
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        RuntimeException panic = new RuntimeException("Execution error: Panic: byte array offset overflow");
                l.onStateChange(prev, State.SUCCEEDED);
 * compatible open source license.
        RuntimeException rootCause = new RuntimeException("stage failed");
     * the failing stage has captured a real cause. Without the fix, {@code terminalCause} would
        }
        task.cancel("circuit breaker sweep cancelled the parent task");
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        QueryDAG dag = new QueryDAG("q-test", rootStage);
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        assertSame("original Arrow OOM must be preserved as cause", arrowOom, surfaced.getCause());
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
 */
     * stage failure is the TRUE cause — {@code terminalCause} must surface it rather than masking
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
import org.opensearch.transport.stream.StreamException;
        @Override
        // Source doesn't implement ExchangeSink — walker must skip close, still fire onFailure.
        @Override
        root.failWith(breaker);
    }
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        public void onTaskTerminal(org.opensearch.analytics.exec.stage.StageTask task, Exception cause) {
            4194304,
        root.failWith(breaker);
    public void testNonArrowOomFailureSurfacesUnchanged() {
import org.opensearch.analytics.planner.dag.QueryDAG;
        assertEquals("translated breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        public Iterable<VectorSchemaRoot> readResult() {
        }
    public void testCancelAllTransitionsToCancelledIdempotently() {
    public void testQueryStateStartsAsCreated() {
            "java.lang.RuntimeException: Execution error: Panic: byte array offset overflow"
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
            return state.get();
            public Iterable<VectorSchemaRoot> readResult() {
        AnalyticsQueryTask task
    public void setUp() throws Exception {
import org.opensearch.core.tasks.TaskId;
 * Unit tests for {@link QueryExecution}'s terminal-sink close-on-failure contract.
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        // A stage that holds a captured failure but lands on CANCELLED (cascade), exactly as a
    // signal that an allocation was rejected against native.allocator.pool.query.max; it belongs
import java.util.concurrent.CompletionException;
        // (DatafusionReduceSink.reduce → onTaskTerminal → captureFailure), and the same trip then
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
        qe.start();
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        Stage rootStage = stageWithId(0);
    }
        qe.start();
        QueryContext ctx = QueryContext.forTest(dag, task);
        // No stage recorded a failure (getFailure()==null) and the parent task is cancelled: this is a
     */
            }
            throw new IllegalStateException("close() throws by design");
            for (StageStateListener l : listeners) {
        Stage rootStage = stageWithId(0);
        // INTERNAL-code StreamException whose message is NOT an Arrow allocator failure (e.g. a Rust
        @Override
        }
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        Stage rootStage = stageWithId(0);
        assertEquals("terminal sink closed exactly once on success", 1, sink.closeCalls.get());
            java.util.Map.of(),
            batch.close();
import org.opensearch.core.tasks.TaskCancelledException;
        assertEquals("translated breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        Stage rootStage = stageWithId(0);
import java.util.concurrent.atomic.AtomicReference;
        assertSame("breaker must be surfaced, not masked by the self-cancel", breaker, surfaced);
     * it behind {@code TaskCancelledException}, so the user sees the actionable reason.
            "Unable to allocate buffer of size 128 (rounded from 80) due to memory limit. Current allocation: 277821480"
        CircuitBreakingException breaker = new CircuitBreakingException(
 */
        CircuitBreakingException breaker = new CircuitBreakingException("Failed to allocate", CircuitBreaker.Durability.TRANSIENT);
        }
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
            "q-test",
        builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);
        @Override
        AnalyticsQueryTask task = new AnalyticsQueryTask(
        }
            }
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
    public void testWrappedArrowOomUnderCancelStillUnwrapsTo429() {
        root.failWith(arrowOom);
        assertSame("original StreamException must be preserved as cause", se, surfaced.getCause());
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        CountingCloseSink sink = new CountingCloseSink();
        // path so client/router treat it as back-pressure.
        Exception surfaced = onFailure.get();
        }
        }
    }
            for (StageStateListener l : listeners) {
        // A breaker captured directly as the root failure (parent task NOT cancelled) is surfaced as-is
    public void testFailedTransitionClosesClosableTerminalSinkExactlyOnce() {
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));
        private final Stage stage;
        }
            batch.close();
    // Same shape as Garov's CircuitBreakingException tests, but for Arrow Java's allocator-budget
            }
        @Override
    }
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        }
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));
         *  cause but then settled to CANCELLED via the self-cancel cascade rather than FAILED. */
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        @Override
        StreamException se = new StreamException(
        ActionListener<Iterable<VectorSchemaRoot>> listener,
    public void testStreamExceptionCarryingArrowOomMessageTranslatesTo429() {
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
import org.apache.arrow.vector.VectorSchemaRoot;
        // report. terminalCause must translate the Arrow OOM to CircuitBreakingException (HTTP 429),
            64,
            return true;
    public void testCloseRunsTerminalSinkOnSuccess() {
/*
        void recordFailureOnly(Exception cause) {
        }
    }
        task.cancel("user aborted the request");
        }
     *
        task.cancel("arrow allocator sweep cancelled the parent task");
            return 0;
        Stage rootStage = stageWithId(0);
        assertEquals("terminal sink close fires exactly once on FAILED", 1, sink.closeCalls.get());
import org.opensearch.analytics.spi.ExchangeSink;
        @Override
        CircuitBreakingException breaker = new CircuitBreakingException(
        assertSame("original stage failure must reach the listener even when terminal sink close throws", rootCause, onFailure.get());
        Stage rootStage = stageWithId(0);
        root.failWith(rootCause);
        // not mask it as TaskCancelledException (HTTP 500).
        final AtomicInteger closeCalls = new AtomicInteger();
    // in the same back-pressure / 429 class as CircuitBreakingException so FailAwareWeightedRouting
    // ── helpers ─────────────────────────────────────────────────────────
    }
        );
        Exception surfaced = onFailure.get();
        }
        Stage rootStage,
        qe.start();
            }
        // need 500 so it pages and FailAwareWeightedRouting can retry on a replica.
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
        }
        // The exact shape reproduced live on 91-d: the breaker is the root stage's captured failure
        @Override
import java.util.ArrayList;
/**
        // real top-down cancel and must remain a TaskCancelledException (HTTP 500) — proving the fix
        assertEquals("cancellation maps to HTTP 500", RestStatus.INTERNAL_SERVER_ERROR, ((OpenSearchException) surfaced).status());
import org.opensearch.transport.stream.StreamErrorCode;
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
    private static final class CountingCloseSink implements ExchangeSink, ExchangeSource {
        // so operators see a real "fix this" signal and FailAwareWeightedRouting can retry
    }
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
            // no-op
 * The OpenSearch Contributors require contributions made to
        // cancels the parent task via the child cancel sweep so isCancelled() is already true.
        task.cancel("arrow allocator sweep cancelled the parent task");
            graph,
        Exception surfaced = onFailure.get();
        qe.cancelAll("first");
        // panic surfaced via cross_rt_stream.rs) must NOT be re-classified as back-pressure — operators
        public State getState() {
    public void testBareArrowOomFailureSurfacesAs429() {
    /**
        QueryDAG dag = new QueryDAG("q-test", rootStage);
                return;
        root.succeed();
            return metrics;
        @Override
        assertEquals(QueryExecution.State.SUCCEEDED, qe.getState());
                return Collections.emptyList();
        }
        AnalyticsQueryTask task = newTask();
     * completion listener. Implemented against the public interface so we don't
        void succeed() {
import static org.mockito.Mockito.when;
        assertTrue(surfaced.getMessage().contains("Unable to allocate buffer"));
        return new AnalyticsQueryTask(1L, "transport", "analytics_query", "q-test", TaskId.EMPTY_TASK_ID, java.util.Map.of(), null);
        @Override
            1L,
import org.apache.arrow.memory.OutOfMemoryException;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        public void close() {
            return Collections.emptyList();
import org.opensearch.analytics.exec.stage.StageMetrics;
    ) {
        }
        Stage rootStage = stageWithId(0);
    }
        root.failWith(arrowOom);
        Stage rootStage = stageWithId(0);
        public long getRowCount() {
        // Query was already in FAILED before cancelAll. cancelAll's CANCELLED transition
import java.util.concurrent.atomic.AtomicInteger;
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
            return source;
        // child stage does when the query self-cancels after a sibling/downstream failure.
     * its terminal (the real scheduler cancels the task as part of the self-cancel cascade), and
    // ── Arrow OutOfMemoryException translation ──────────────────────────
        AtomicReference<Exception> onFailure = new AtomicReference<>();
            ctx,
    private static final class TestRootExecution implements StageExecution, DataProducer {
            "Could not load buffers for field cnt[hll_registers]: Binary not null. error message: "
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        public boolean failWithCause(Exception cause) {
            "[analytics_backend_datafusion] Failed to allocate 64 bytes (limit: 7101482993)",
        assertSame("original failure propagated despite non-sink source", rootCause, onFailure.get());
        AnalyticsQueryTask task = newTask();
        AnalyticsQueryTask task = newTask();
    /**
            }
        @Override
            ActionListener.wrap(r -> fail("unexpected success"), e -> failureCount.incrementAndGet())
        @Override
        AnalyticsQueryTask task = newTask();
        assertEquals(QueryExecution.State.CANCELLED, qe.getState());
    public void testStreamExceptionWithoutArrowOomMessageSurfacesUnchanged() {
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
    /** Sink+Source that counts close() invocations. */
    }
     * A query self-cancels its remaining stages once a stage fails (e.g. a reduce sink throwing
    }
        root.failWith(se);
        Stage rootStage = stageWithId(0);
        // while carrying the captured cause. Capture the failure without firing FAILED (record it,
        Stage rootStage = stageWithId(0);
        Stage rootStage = stageWithId(0);
import org.opensearch.test.OpenSearchTestCase;
        AtomicReference<Exception> onFailure = new AtomicReference<>();
    }
    private StageExecutionBuilder builder;
    @Override
        // surface this as CircuitBreakingException (HTTP 429), not as the raw 500 StreamException.
            CircuitBreaker.Durability.TRANSIENT
        Stage rootStage = stageWithId(0);
        Exception surfaced = onFailure.get();
    private static AnalyticsQueryTask newTask() {
import org.opensearch.core.rest.RestStatus;
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
            failure.compareAndSet(null, cause);
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        root.failWith(se);
        Stage rootStage = stageWithId(0);
            return failure.get();
        assertTrue("genuine cancel must stay TaskCancelledException", surfaced instanceof TaskCancelledException);
        // terminalCause must surface the breaker (HTTP 429), not mask it as TaskCancelledException (500).
        AtomicReference<Exception> onFailure = new AtomicReference<>();
 * throwing closes, and the close-fires-exactly-once invariant.
                return false;
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
     * see {@code task.isCancelled()} and return {@code TaskCancelledException}, hiding the cause.
            failWithCause(cause);
        public void start(ActionListener<Void> onStarted) {
            State prev = state.getAndSet(State.CANCELLED);
     * {@code ReduceSizeExceededException}). The parent task ends up cancelled, but the captured
    private QueryExecution newQueryExecution(
        private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        Exception surfaced = onFailure.get();
import org.opensearch.OpenSearchException;
    public void testFailedTransitionStillFiresOriginalFailureWhenTerminalSinkCloseThrows() {
    public void testRootStageSuccessTransitionsQueryToSucceeded() {
            return java.util.List.of();
    }
        public Iterable<VectorSchemaRoot> readResult() {
}
        Stage rootStage = stageWithId(0);
            failure.compareAndSet(null, cause);
            CircuitBreaker.Durability.TRANSIENT
    }
import org.opensearch.analytics.exec.stage.StageExecution;
        assertSame("nested breaker must be unwrapped, not masked by cancellation", breaker, surfaced);
    private static final class ThrowingCloseSink implements ExchangeSink, ExchangeSource {
        }
    }
        Exception surfaced = onFailure.get();
        root.failWith(rootCause);
        assertTrue("wrapped Arrow OOM must still translate to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
            return 0;
            null
        assertTrue("Arrow OOM must be translated to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
        assertFalse(surfaced instanceof CircuitBreakingException);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
                + "Unable to allocate buffer of size 98304 due to memory limit. Current allocation: 197104"
        public java.util.List<org.opensearch.analytics.exec.stage.StageTask> tasks() {
        Stage rootStage = stageWithId(0);
            }
        // RuntimeException) must NOT be re-classified as back-pressure. It needs HTTP 500
        qe.start();
        assertEquals("listener fired exactly once across two cancelAll calls", 1, failureCount.get());
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        TestRootExecution root = new TestRootExecution(rootStage, sink);
        @Override
        // Coordinator-local Arrow OOM (no cancel sweep): a direct in-process materialization
    // refusal (org.apache.arrow.memory.OutOfMemoryException — NOT a JVM OOM). Arrow OOM is the
        private final AtomicReference<Exception> failure = new AtomicReference<>();
        when(stage.getStageId()).thenReturn(id);
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
    }
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));
        RuntimeException rootCause = new RuntimeException("non-sink source path");
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
                l.onStateChange(prev, State.FAILED);
