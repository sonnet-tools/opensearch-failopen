    }  
            return true;
        }  
        assertTrue("translated message must preserve the Arrow OOM detail", surfaced.getMessage().contains("Unable to allocate buffer"));
        // ("Could not load buffers for field cnt[hll_registers]") before it propagates up. Even nested  
            CircuitBreaker.Durability.TRANSIENT
        // An unrelated stage failure (e.g. engine-bug-class — a Rust panic surfaced as a
    private static final class ThrowingCloseSink implements ExchangeSink, ExchangeSource {
            return stage.getStageId();
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        // via the unchanged non-cancel path.  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        assertSame("original failure propagated to completion listener", rootCause, onFailure.get());
        ExchangeSource source = new ExchangeSource() {  
        TestRootExecution root = new TestRootExecution(rootStage, sink);  
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        AnalyticsQueryTask task
        qe.start();
        // does not turn genuine cancellations into 429.
import java.util.Collections;
            this.stage = stage;
    public void testStartTransitionsToRunning() {  
                l.onStateChange(prev, State.SUCCEEDED);  
        assertFalse(surfaced instanceof CircuitBreakingException);  
        }
        qe.start();  
        @Override
        public State getState() {
        // real top-down cancel and must remain a TaskCancelledException (HTTP 500) — proving the fix  
        root.succeed();  
        @Override
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
        }
        public void addStateListener(StageStateListener listener) {  
    }
    }  
    }  
    }
    public void testStreamExceptionCarryingArrowOomMessageTranslatesTo429() {  
import static org.mockito.Mockito.mock;
            "analytics_query",
    }  
        assertSame(breaker, surfaced);  
     * stage failure is the TRUE cause — {@code terminalCause} must surface it rather than masking  
        Stage rootStage = stageWithId(0);
        StreamException se = new StreamException(  
        /** Records a captured failure WITHOUT transitioning state — mirrors a stage that captured a  
        return new QueryExecution(ctx, graph, s -> s.start(ActionListener.wrap(v -> {}, e -> {})), listener);  
    }
        // Self-cancel cascade: parent task cancelled first, then the stage settles to a terminal  
        public boolean failWithCause(Exception cause) {
        assertSame("original failure propagated despite non-sink source", rootCause, onFailure.get());  
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
        qe.start();
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        assertEquals("cancellation maps to HTTP 500", RestStatus.INTERNAL_SERVER_ERROR, ((OpenSearchException) surfaced).status());  
/**
        // path so client/router treat it as back-pressure.
            failure.compareAndSet(null, cause);
        @Override
        Stage rootStage = stageWithId(0);
        root.failWith(wrapped);
            State prev = state.getAndSet(State.SUCCEEDED);
            return source;
        task.cancel("circuit breaker sweep cancelled the parent task");
        }  
            "java.lang.RuntimeException: Execution error: Panic: byte array offset overflow"  
        // panic surfaced via cross_rt_stream.rs) must NOT be re-classified as back-pressure — operators
        root.failWith(breaker);
    ) {
        // report. terminalCause must translate the Arrow OOM to CircuitBreakingException (HTTP 429),
 * Unit tests for {@link QueryExecution}'s terminal-sink close-on-failure contract.  
            "[analytics_backend_datafusion] Failed to allocate 64 bytes (limit: 7101482993)",
        when(stage.getStageId()).thenReturn(id);  
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        private final AtomicReference<Exception> failure = new AtomicReference<>();
        @Override  
public class QueryExecutionTests extends OpenSearchTestCase {
                + "Unable to allocate buffer of size 98304 due to memory limit. Current allocation: 197104"  
        // it on a replica.
        task.cancel("circuit breaker sweep cancelled the parent task");
            return Collections.emptyList();
    }
        TestRootExecution root = new TestRootExecution(rootStage, source);  
    public void testCloseRunsTerminalSinkOnSuccess() {
        assertEquals(QueryExecution.State.CREATED, qe.getState());  
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
     */
        Stage rootStage = stageWithId(0);  
            "Unable to allocate buffer of size 128 (rounded from 80) due to memory limit. Current allocation: 277821480"
        // The cross-Flight-RPC path: shard-side Arrow OOM travels over Flight, the wire envelope strips
        @Override
        AnalyticsQueryTask task = newTask();
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
            }  
        // under a cancelled parent task, the cause-walk must surface it as 429.
            @Override
    }
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        // surface this as CircuitBreakingException (HTTP 429), not as the raw 500 StreamException.
import java.util.List;  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
        return stage;  
    // refusal (org.apache.arrow.memory.OutOfMemoryException — NOT a JVM OOM). Arrow OOM is the
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
    }
import org.apache.arrow.vector.VectorSchemaRoot;
            return state.get();  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        root.failWith(arrowOom);
        qe.start();
                l.onStateChange(prev, State.FAILED);
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
    }
        );
        }  
    public void testQueryStateStartsAsCreated() {
        // OOM with parent task NOT cancelled must still translate to 429 via the non-cancel  
        root.failWith(rootCause);
                return false;
            ActionListener.wrap(r -> fail("unexpected success"), onFailure::set)
        public ExchangeSource outputSource() {
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        @Override
        root.failWith(breaker);  
        public long getRowCount() {  
            ctx,
            return java.util.List.of();  
        @Override  
    // in the same back-pressure / 429 class as CircuitBreakingException so FailAwareWeightedRouting
        public void close() {  
     * <p>Reproduces the masking ordering: the parent task is cancelled BEFORE the query reaches  
        Stage rootStage = stageWithId(0);
        @Override
    }
        qe.start();  
            for (StageStateListener l : listeners) {
                return Collections.emptyList();  
        // A breaker captured directly as the root failure (parent task NOT cancelled) is surfaced as-is
        assertTrue("translated message must preserve the Arrow OOM detail", surfaced.getMessage().contains("Unable to allocate buffer"));
import org.opensearch.OpenSearchException;  
         *  cause but then settled to CANCELLED via the self-cancel cascade rather than FAILED. */
        return new QueryExecution(ctx, graph, s -> s.start(ActionListener.wrap(v -> {}, e -> {})), listener);
    public void testBareArrowOomMasqueradingAsCancelSurfacesAs429() {
        }
 */  
        root.succeed();
            failure.compareAndSet(null, cause);  
        Stage rootStage,
        // Source doesn't implement ExchangeSink — walker must skip close, still fire onFailure.
        @Override
        }
    private static final class TestRootExecution implements StageExecution, DataProducer {
import java.util.concurrent.atomic.AtomicInteger;
        }
    }
import org.opensearch.test.OpenSearchTestCase;  
        CountingCloseSink sink = new CountingCloseSink();
        Stage rootStage = stageWithId(0);  
        assertFalse(surfaced instanceof CircuitBreakingException);
        ActionListener<Iterable<VectorSchemaRoot>> listener,  
     *
        };
        task.cancel("arrow allocator sweep cancelled the parent task");
            for (StageStateListener l : listeners) {
 * The OpenSearch Contributors require contributions made to  
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        assertSame("nested breaker must be unwrapped, not masked by cancellation", breaker, surfaced);  
        // need 500 so it pages and FailAwareWeightedRouting can retry on a replica.
        public StageMetrics getMetrics() {
    public void testNonArrowOomFailureSurfacesUnchanged() {  
}
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
    // skips replica retry. terminalCause translates it to CircuitBreakingException at the coordinator.
        return QueryContext.forTest(dag, task);
     * completion listener. Implemented against the public interface so we don't
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        RuntimeException rootCause = new RuntimeException("non-sink source path");  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        void succeed() {  
    }
            public Iterable<VectorSchemaRoot> readResult() {
        // terminalCause must surface the breaker (HTTP 429), not mask it as TaskCancelledException (500).
    }
    }  
        QueryContext ctx = queryCtx(rootStage);
    // ── helpers ─────────────────────────────────────────────────────────
import org.opensearch.analytics.planner.dag.QueryDAG;
        TestRootExecution root = new TestRootExecution(rootStage, sink);
            ActionListener.wrap(r -> fail("unexpected success"), e -> failureCount.incrementAndGet())
     * A query self-cancels its remaining stages once a stage fails (e.g. a reduce sink throwing
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
            327680,
    public void testFailedTransitionSkipsCloseWhenSourceIsNotASink() {
        }
        assertTrue("genuine cancel must stay TaskCancelledException", surfaced instanceof TaskCancelledException);
import org.opensearch.core.action.ActionListener;  
import static org.mockito.Mockito.when;  
        RuntimeException rootCause = new RuntimeException("original failure");  
            null
        );  
        assertSame("original StreamException must be preserved as cause", se, surfaced.getCause());
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        Exception surfaced = onFailure.get();
     * depend on package-private {@code AbstractStageExecution}.
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
            // no-op
        }
 * compatible open source license.
        // (DatafusionReduceSink.reduce → onTaskTerminal → captureFailure), and the same trip then  
        Stage rootStage = stageWithId(0);
            64,  
    }
     * it behind {@code TaskCancelledException}, so the user sees the actionable reason.
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        when(stage.getChildStages()).thenReturn(List.of());
        // Query was already in FAILED before cancelAll. cancelAll's CANCELLED transition
        }
            throw new IllegalStateException("close() throws by design");  
        qe.cancelAll("second");  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        qe.cancelAll("late cancel");
        assertTrue("post-RPC Arrow OOM must translate to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
            1L,
    }  
            }  
            rootStage,
        Exception surfaced = onFailure.get();
    @Override
    }
        }  
        assertSame("non-Arrow-OOM StreamException must pass through unchanged", se, surfaced);
        AnalyticsQueryTask task = newTask();  
        root.failWith(rootCause);
        private final ExchangeSource source;  
        ctx.parentTask().cancel("self-cancel after stage failure");  
        RuntimeException panic = new RuntimeException("Execution error: Panic: byte array offset overflow");  
        QueryDAG dag = new QueryDAG("q-test", rootStage);
     */  
    }
            return 0;
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
        assertEquals("terminal sink closed exactly once on success", 1, sink.closeCalls.get());  
        public Iterable<VectorSchemaRoot> readResult() {
        final AtomicInteger closeCalls = new AtomicInteger();
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        AnalyticsQueryTask task = new AnalyticsQueryTask(
        }  
        }
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        assertEquals("breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
    public void testGenuineCancelWithNoStageFailureStaysTaskCancelled() {
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
            CircuitBreaker.Durability.TRANSIENT
        assertEquals("terminal sink close fires exactly once on FAILED", 1, sink.closeCalls.get());  
import org.apache.arrow.memory.OutOfMemoryException;
        private final Stage stage;
 * SPDX-License-Identifier: Apache-2.0
        // an async→sync future.join() bridge) under a cancelled parent task, it must still be unwrapped.
        Exception surfaced = onFailure.get();
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        @Override  
            State prev = state.getAndSet(State.FAILED);  
        assertEquals(QueryExecution.State.CANCELLED, qe.getState());
        assertTrue(surfaced.getMessage().contains("Unable to allocate buffer"));
        RuntimeException rootCause = new RuntimeException("stage failed");  
        @Override
        // the original OutOfMemoryException class, coordinator receives StreamException[INTERNAL] whose
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);  
import org.opensearch.core.tasks.TaskCancelledException;
            }
        // child stage does when the query self-cancels after a sibling/downstream failure.
        public void close() {
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);  
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        assertSame("original stage failure must reach the listener even when terminal sink close throws", rootCause, onFailure.get());  
     * see {@code task.isCancelled()} and return {@code TaskCancelledException}, hiding the cause.  
        Stage rootStage = stageWithId(0);  
        private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);
/*  
        // The exact shape reproduced live on 91-d: the breaker is the root stage's captured failure
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        }
    }
    // signal that an allocation was rejected against native.allocator.pool.query.max; it belongs  
        QueryExecution qe = new QueryExecution(
        root.failWith(se);
        Exception surfaced = onFailure.get();
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
        void recordFailureOnly(Exception cause) {
    }
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
            return metrics;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());  
import java.util.concurrent.CompletionException;
        assertSame("captured stage failure must win over the self-cancel TaskCancelledException mask", rootCause, onFailure.get());
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        AtomicReference<Exception> onFailure = new AtomicReference<>();
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);  
        public long getRowCount() {
    public void testBareArrowOomFailureSurfacesAs429() {
    public void testStreamExceptionWithoutArrowOomMessageSurfacesUnchanged() {
        AnalyticsQueryTask task = newTask();
        );  
        qe.start();
        @Override
            batch.close();
            TaskId.EMPTY_TASK_ID,  
import org.opensearch.analytics.exec.stage.StageMetrics;
import org.opensearch.transport.stream.StreamException;
    /** Sink+Source whose close() throws — models a misbehaving terminal collector. */  
        OutOfMemoryException arrowOom = new OutOfMemoryException("Unable to allocate buffer of size 98304");  
            graph,  
        CircuitBreakingException breaker = new CircuitBreakingException(
                l.onStateChange(prev, State.CANCELLED);
        @Override  
        Stage rootStage = stageWithId(0);  
        // so operators see a real "fix this" signal and FailAwareWeightedRouting can retry  
        Stage rootStage = stageWithId(0);
        }
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));  
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
        root.failWith(rootCause);
        // must be rejected by the CAS — terminal state is sticky.
    private static Stage stageWithId(int id) {
        // Mirrors the in-process Arrow OOM path: ArrayImporter wraps the OOM in IllegalArgumentException
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
    public void testBareBreakerMasqueradingAsCancelSurfacesAs429() {
            s -> s.start(ActionListener.wrap(v -> {}, e -> {})),
        // cancels the parent task via the child cancel sweep so isCancelled() is already true.
                return;
            }  
        when(stage.getExecutionType()).thenReturn(StageExecutionType.LOCAL_PASSTHROUGH);
        Exception surfaced = onFailure.get();
import org.opensearch.analytics.planner.dag.Stage;  
    // Same shape as Garov's CircuitBreakingException tests, but for Arrow Java's allocator-budget
        QueryExecution qe = newQueryExecution(  
            "Could not load buffers for field cnt[hll_registers]: Binary not null. error message: "
        Stage rootStage = stageWithId(0);
            if (prev == State.FAILED || prev == State.SUCCEEDED || prev == State.CANCELLED) {
        Stage stage = mock(Stage.class);
            }  
        public Iterable<VectorSchemaRoot> readResult() {
        assertTrue("wrapped Arrow OOM must still translate to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
        TestRootExecution(Stage stage, ExchangeSource source) {  
                return 0;
                return;  
        return new AnalyticsQueryTask(1L, "transport", "analytics_query", "q-test", TaskId.EMPTY_TASK_ID, java.util.Map.of(), null);
    private static QueryContext queryCtx(Stage rootStage) {  
        root.failWith(new CompletionException(breaker));  
        Stage rootStage = stageWithId(0);  
        AnalyticsQueryTask task = newTask();  
            listeners.add(listener);
            this.source = source;
import org.opensearch.analytics.planner.dag.StageExecutionType;
            for (StageStateListener l : listeners) {
        assertTrue(surfaced instanceof CircuitBreakingException);
    }
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        qe.cancelAll("self-cancel after stage failure");
            }
        Stage rootStage = stageWithId(0);
            7101482993L,
        task.cancel("user aborted the request");
     * the failing stage has captured a real cause. Without the fix, {@code terminalCause} would
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        Exception surfaced = onFailure.get();
    public void testFailedTransitionStillFiresOriginalFailureWhenTerminalSinkCloseThrows() {  
package org.opensearch.analytics.exec;
        // INTERNAL-code StreamException whose message is NOT an Arrow allocator failure (e.g. a Rust  
        QueryContext ctx = QueryContext.forTest(dag, task);
        builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);
        ThrowingCloseSink sink = new ThrowingCloseSink();
            java.util.Map.of(),
        TestRootExecution root = new TestRootExecution(rootStage, sink);  
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
        // No stage recorded a failure (getFailure()==null) and the parent task is cancelled: this is a
        root.failWith(new RuntimeException("primary"));  
import org.opensearch.analytics.backend.ExchangeSource;
    }  
        OutOfMemoryException arrowOom = new OutOfMemoryException("Unable to allocate buffer of size 4194304");  
            return 0;
        private final StageMetrics metrics = new StageMetrics();
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
            }
        }
    public void testCancelAllTransitionsToCancelledIdempotently() {  
        assertEquals(QueryExecution.State.RUNNING, qe.getState());
            onStarted.onResponse(null);
        root.failWith(panic);
        public int getStageId() {  
     * Minimal {@link StageExecution} + {@link DataProducer} for driving QueryExecution's  
        StreamException se = new StreamException(
        CircuitBreakingException breaker = new CircuitBreakingException("Failed to allocate", CircuitBreaker.Durability.TRANSIENT);
 * throwing closes, and the close-fires-exactly-once invariant.
        );
        QueryContext ctx = queryCtx(rootStage);
        RuntimeException rootCause = new RuntimeException("Stage 0 sink feed failed", new IllegalStateException("buffer budget exceeded"));  
        QueryDAG dag = new QueryDAG("q-test", rootStage);  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);  
        AtomicInteger failureCount = new AtomicInteger();
        assertEquals("translated breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());  
        public java.util.List<org.opensearch.analytics.exec.stage.StageTask> tasks() {
     * {@code ReduceSizeExceededException}). The parent task ends up cancelled, but the captured
        OutOfMemoryException arrowOom = new OutOfMemoryException(
        Stage rootStage = stageWithId(0);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        assertSame(arrowOom, surfaced.getCause());  
        Exception surfaced = onFailure.get();  
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set));
            StreamErrorCode.INTERNAL,
        root.recordFailureOnly(rootCause);
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());  
        Exception surfaced = onFailure.get();  
        AnalyticsQueryTask task = newTask();  
        // and the same sweep cancels the parent task, so isCancelled() is already true by the time we  
            "transport",  
        @Override
import org.opensearch.core.common.breaker.CircuitBreaker;
        AtomicReference<Exception> onFailure = new AtomicReference<>();
import java.util.ArrayList;
    public void testCapturedStageFailureWinsOverSelfCancelMask() {
        void failWith(Exception cause) {
        assertEquals("listener fired exactly once across two cancelAll calls", 1, failureCount.get());  
        ExecutionGraph graph = ExecutionGraph.build(ctx, builder, s -> s.start(ActionListener.wrap(v -> {}, e -> {})));
        @Override  
        assertTrue("Arrow OOM must be translated to CircuitBreakingException", surfaced instanceof CircuitBreakingException);
        Exception surfaced = onFailure.get();  
     * its terminal (the real scheduler cancels the task as part of the self-cancel cascade), and
        }
        // Mirrors the live failure on dev (332-big5): an Arrow allocator trip fails the reduce stage
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        public void cancel(String reason) {
        newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
    private QueryExecution newQueryExecution(Stage rootStage, ActionListener<Iterable<VectorSchemaRoot>> listener) {
    public void testWrappedArrowOomUnderCancelStillUnwrapsTo429() {
        assertEquals("breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        }
        IllegalArgumentException wrapped = new IllegalArgumentException("Could not load buffers for field cnt[hll_registers]", arrowOom);
        @Override
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> {}, e -> {}));
 */  
    private static final class CountingCloseSink implements ExchangeSink, ExchangeSource {  
        }
import org.opensearch.core.common.breaker.CircuitBreakingException;
    private QueryExecution newQueryExecution(
import org.opensearch.transport.stream.StreamErrorCode;
        Exception surfaced = onFailure.get();  
        public void feed(VectorSchemaRoot batch) {
    public void testCancelAllAfterRootFailureKeepsFailedAsTerminal() {  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
            }  
            4194304,  
    }
        public void start(ActionListener<Void> onStarted) {  
import org.opensearch.analytics.exec.stage.DataProducer;
        Stage rootStage = stageWithId(0);  
        public void feed(VectorSchemaRoot batch) {  
            State prev = state.getAndSet(State.CANCELLED);  
        assertEquals(QueryExecution.State.SUCCEEDED, qe.getState());
    }
        task.cancel("arrow allocator sweep cancelled the parent task");
        // then drive the CANCELLED terminal) to mirror the cascade ordering.
    public void testFailedTransitionClosesClosableTerminalSinkExactlyOnce() {  
        // Coordinator-local Arrow OOM (no cancel sweep): a direct in-process materialization
    }  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        assertEquals("first terminal wins", QueryExecution.State.FAILED, qe.getState());  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
import org.opensearch.core.tasks.TaskId;
        );  
            "q-test",
    /** Sink+Source that counts close() invocations. */
 * this file be licensed under the Apache-2.0 license or a
        @Override  
import org.opensearch.analytics.exec.stage.StageStateListener;  
    public void setUp() throws Exception {  
        }  
            closeCalls.incrementAndGet();
    /**  
    private StageExecutionBuilder builder;  
        public void onTaskTerminal(org.opensearch.analytics.exec.stage.StageTask task, Exception cause) {
        qe.cancelAll("first");
            StreamErrorCode.INTERNAL,
        super.setUp();
        Stage rootStage = stageWithId(0);
        public Exception getFailure() {
 *
        root.failWith(se);
        // A stage that holds a captured failure but lands on CANCELLED (cascade), exactly as a
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        Stage rootStage = stageWithId(0);
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
        );
        assertEquals("translated breaker maps to HTTP 429", RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
    public void testWrappedBreakerUnderCancelStillUnwrapsTo429() {
    public void testRootStageSuccessTransitionsQueryToSucceeded() {
        root.failWith(arrowOom);
        // while carrying the captured cause. Capture the failure without firing FAILED (record it,
        // RuntimeException) must NOT be re-classified as back-pressure. It needs HTTP 500
            return failure.get();  
        qe.cancelAll("user aborted the request");
import java.util.concurrent.atomic.AtomicReference;  
        assertSame("original Arrow OOM must be preserved as cause", arrowOom, surfaced.getCause());  
        );  
import org.opensearch.analytics.exec.stage.StageExecution;  
        // message contains Arrow's "Unable to allocate buffer ..." marker. terminalCause must still  
        Stage rootStage = stageWithId(0);
    }  
        );  
        Stage rootStage = stageWithId(0);  
    // ── Arrow OutOfMemoryException translation ──────────────────────────  
    private static AnalyticsQueryTask newTask() {  
        // not mask it as TaskCancelledException (HTTP 500).
        Stage rootStage = stageWithId(0);  
        @Override  
            batch.close();
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        CircuitBreakingException breaker = new CircuitBreakingException(  
        TestRootExecution root = new TestRootExecution(rootStage, new CountingCloseSink());
            failWithCause(cause);  
        assertSame("breaker must be surfaced, not masked by the self-cancel", breaker, surfaced);
        @Override
        Stage rootStage = stageWithId(0);
        QueryExecution qe = newQueryExecution(rootStage, ActionListener.wrap(r -> fail("unexpected success"), onFailure::set), task);
            "[analytics_backend_datafusion] Failed to allocate 327680 bytes (limit: 4194304)",
 * Covers gaps not exercised through {@code RowProducingSink}: non-closeable sources,
        private final List<StageStateListener> listeners = new ArrayList<>();  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        assertSame("non-Arrow-OOM failure must pass through unchanged", panic, surfaced);
            return Collections.emptyList();  
    /**
        // Defends the cause-walk: even if the breaker arrives nested (e.g. a CompletionException from  
        }
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) surfaced).status());
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, s, cfg) -> root);
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
        CountingCloseSink sink = new CountingCloseSink();
        AtomicReference<Exception> onFailure = new AtomicReference<>();  
import org.opensearch.analytics.spi.ExchangeSink;
            public long getRowCount() {
    public void testBareBreakerFailureSurfacesAs429() {
import org.opensearch.core.rest.RestStatus;  
            @Override  
        }  
    }
