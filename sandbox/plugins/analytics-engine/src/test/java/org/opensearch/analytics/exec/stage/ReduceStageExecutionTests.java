            cancelCalled = true;
        when(childStageDef.getChildStages()).thenReturn(List.of());
            State prev = this.state;
    public void testCancelClosesBackendSink() {
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    private static final class CapturingSink implements ExchangeSink {
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
    }
/**
import org.opensearch.analytics.spi.ExchangeSink;
        CancellableCapturingSink backend = new CancellableCapturingSink();
        public void cancel(String reason) {
        when(stage.getChildStages()).thenReturn(List.of());
        assertTrue(transitioned);
        boolean cancelCalledBeforeClose = false;
            }
        public ExchangeSink sinkForChild(int childStageId) {
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        backend.reduceFailure = boom;
        exec.failWithCause(new RuntimeException("child failed"));
        public void start(ActionListener<Void> onStarted) {
            if (reduceFailure != null) {
        @Override
        allocator.close();
        exec.cancel("external cancel first");
    }
        when(ctx.reduceExecutor()).thenReturn(inlineExecutor());
        exec.cancel("test cancellation");
            if (invocation.getMethod().getName().equals("execute")) {
     */
            this.state = State.FAILED;
            dispatcher.run(task, new ActionListener<>() {
        assertEquals(StageExecution.State.FAILED, exec.getState());
     * the parent's FAILED state before publishing child EOF. The terminal transition
                public void close() {
        StreamingFakeSink backend = new StreamingFakeSink();
        assertFalse("transition rejected — already terminal", transitioned);
        assertTrue(backend.closed);
            batch.close();
        assertEquals("reduce was never invoked — cancel preceded body", 0, backend.reduceCalls.get());
        exec.cancel("user requested");
import static org.mockito.Mockito.when;
        }
        });
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        RuntimeException boom = new RuntimeException("drain failed");
        exec.closeChildInput(11);
        }
        when(ctx.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));
        StreamingFakeSink backend = new StreamingFakeSink();
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        public void addStateListener(StageStateListener listener) {
        }
        for (StageTask task : exec.tasks()) {
        }
    }
            closed = true;
                    exec.onTaskTerminal(task, cause);
        }
import java.util.Map;
        @Override
        }
        public boolean supportsEagerScheduling() {
        return mock(ExecutorService.class, invocation -> {
        // Fail the child — the cascade must fail the parent and still close input 5.
    @Override
        private Exception failure;
        @Override
import static org.mockito.Mockito.mock;
        ReduceStageExecution exec = new ReduceStageExecution(
    /** Buffered-mode reducing sink — overrides supportsEagerScheduling to false. */
        QueryContext ctx = mock(QueryContext.class);
            new CapturingSink()
        exec.closeChildInput(0);
        assertEquals(1, backend.reduceCalls.get());
        assertEquals(StageExecution.State.FAILED, exec.getState());
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
        }
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        public Exception getFailure() {
    }
        assertFalse("cancel() must NOT be called on SUCCEEDED", backend.cancelCalled);
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, downstream);
                    exec.onTaskTerminal(task, null);
            reduceCalls.incrementAndGet();
            cancelCalledBeforeClose = !closed;
        private final List<StageStateListener> listeners = new ArrayList<>();
        assertEquals("first close fires from cancel", 1, backend.closeCount);
        assertTrue("close() must still be called", backend.closed);
    public void testBufferedSchedulesEagerlyIsFalse() {
            return state;
        assertEquals("backend not re-closed by no-op start()", 1, backend.closeCount);
    }
                public void feed(VectorSchemaRoot batch) {
    public void tearDown() throws Exception {
    public void testFailFromChildCallsCancellableExchangeSinkCancelBeforeClose() {
                l.onStateChange(prev, State.FAILED);
        void failWith(Exception cause) {
            return true;
 */
                @Override
import java.util.concurrent.atomic.AtomicInteger;
    }
import java.util.List;
    private BufferAllocator allocator;
    /**
        @Override
        assertTrue("cancel() must fire before close()", backend.cancelCalledBeforeClose);
        RuntimeException reduceFailure;
 *   (default). Task body invokes {@code reduce()}, terminal transition invokes
        assertTrue("cancel() must be called on CancellableExchangeSink", backend.cancelCalled);
            listeners.add(listener);
        @Override
     * still releases sinks that own independent inputs.
import org.apache.arrow.memory.RootAllocator;
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        CapturingReducingSink backend = new CapturingReducingSink();
        boolean closed = false;
            task.transitionTo(StageTaskState.RUNNING);
 *   the corresponding per-child wrapper.</li>
    public void testChildFailureFailsParentAndClosesChildInput() {
            return stage.getStageId();
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
import org.opensearch.analytics.exec.RowProducingSink;
        final AtomicInteger reduceCalls = new AtomicInteger();
 * The OpenSearch Contributors require contributions made to
        return ctx;
        CapturingReducingSink backend = new CapturingReducingSink();
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
            return failure;
        CapturingReducingSink backend = new CapturingReducingSink();
    }
    private static ExecutorService inlineExecutor() {
        }
        }
        assertEquals("each closeChildInput closed exactly one per-child wrapper", List.of(7, 11), backend.closedChildIds);
        exec.cancel("late external cancel");
                }
public class ReduceStageExecutionTests extends OpenSearchTestCase {
    }
    /**
        if (dispatcher == null) return;
        assertFalse(exec.schedulesEagerly());
            }
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        assertTrue("close invoked from onTerminalTransition", backend.closed);
        CancellableCapturingSink backend = new CancellableCapturingSink();
                    closedChildIds.add(id);
    public void testFailFromChildAfterCancelDoesNotDoubleCloseBackendSink() {
    }
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        exec.cancel("user requested");
            this.stage = stage;
import org.opensearch.analytics.exec.QueryContext;
        public void close() {
        StreamingFakeSink backend = new StreamingFakeSink();
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        assertTrue(backend.closed);
/*
            stageWithId(0),
        @SuppressWarnings("unchecked")
import org.apache.arrow.vector.VectorSchemaRoot;
import org.opensearch.analytics.planner.dag.Stage;
    public void testStreamingSchedulesEagerlyIsTrue() {
        }
        @Override
    }
        when(stage.getStageId()).thenReturn(id);
        @Override
            for (VectorSchemaRoot batch : fed) {
    }
        assertEquals(StageExecution.State.FAILED, exec.getState());
        }
                ((Runnable) invocation.getArgument(0)).run();
        assertTrue("cancel() must be called on FAILED transition", backend.cancelCalled);
    public void testFailFromChildClosesBackendSinkAndTransitions() {
import java.util.HashMap;
    private Stage stageWithId(int id) {
    }
import org.opensearch.core.action.ActionListener;
        FakeChildExecution child = new FakeChildExecution(childStageDef);
        CapturingReducingSink backend = new CapturingReducingSink();
    }
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        scheduleAndDispatch(exec);
     * Regression: when a child stage transitions to FAILED, the cascade must claim
        assertSame(backend, exec.inputSink(0));
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    }
        assertSame(boom, exec.getFailure());
        assertSame(backend, exec.inputSink(7));
        assertEquals("close fired once from cancel", 1, backend.closeCount);
        assertEquals("first terminal wins; cancel does not re-transition", StageExecution.State.FAILED, exec.getState());
        when(childStageDef.getStageId()).thenReturn(childStageId);
        boolean transitioned = exec.failWithCause(cause);
        Stage childStageDef = mock(Stage.class);
        CapturingSink downstream = new CapturingSink();
    }
        int childStageId = 5;
            });
        CapturingReducingSink backend = new CapturingReducingSink();
    public void testStreamingStartInvokesReduceAndTransitionsToSucceeded() {
        CapturingReducingSink backend = new CapturingReducingSink();
    /** Bare ExchangeSink for the downstream slot. */
import org.opensearch.analytics.spi.ReducingExchangeSink;
        @Override
            fed.clear();
     * Streaming-mode reducing sink — re-inherits the default supportsEagerScheduling=true
        @Override
        }
    }
        scheduleAndDispatch(exec);  // start() returns no-op; no task body runs because state is already terminal
        assertFalse("downstream is not closed by reduce execution", downstream.closed);
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
                }
        // Create a fake child stage that we can fail manually.
        exec.closeChildInput(7);
 * Unit tests for {@link ReduceStageExecution}. Exercises both scheduling modes:
    }
        @Override
        backend.reduceFailure = boom;
            }
        public void feed(VectorSchemaRoot batch) {
    }
        assertEquals("backend close fires exactly once across both calls", 1, backend.closeCount);
    // ── helpers ──────────────────────────────────────────────────────────
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        public void feed(VectorSchemaRoot batch) {
        }
        Stage stage = mock(Stage.class);
        scheduleAndDispatch(exec);
        @Override
        @Override
        CancellableCapturingSink backend = new CancellableCapturingSink();
                return null;
    // ── Buffered mode (default supportsEagerScheduling = false) ──────────
    private static class CapturingReducingSink implements ReducingExchangeSink {
    }
        super.setUp();
        assertTrue("closeChildInput must be called for the failed child", backend.closedChildIds.contains(childStageId));
}
 * compatible open source license.
import org.opensearch.analytics.spi.CancellableExchangeSink;
            new CapturingReducingSink(),
            }
        // Wire the cascade: parent observes child state transitions.
        assertTrue("close() must still be called after cancel()", backend.closed);
import org.opensearch.analytics.exec.task.TaskRunner;
    }
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        super.tearDown();
    }
            state = State.CANCELLED;
        child.failWith(new RuntimeException("shard exploded"));
    /** Minimal child stage that can be manually failed to trigger the parent cascade. */
        @Override
        public StageMetrics getMetrics() {
        assertEquals("reduce invoked once from task body", 1, backend.reduceCalls.get());
                public void onResponse(Void unused) {
 */
        allocator = new RootAllocator();
        // No-op for non-MultiInput sinks — must not affect closed state.
                }
import java.util.concurrent.ExecutorService;
            return childWrappers.computeIfAbsent(childStageId, id -> new ExchangeSink() {
        @Override
    public void testCancelAfterFailFromChildDoesNotDoubleCloseBackendSink() {
    public void testBufferedCloseChildInputIsNoopBecauseNotMultiInput() {
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
                    batch.close();
    public void testStartTransitionsToFailedWhenReduceFiresOnFailure() {
        final List<Integer> closedChildIds = new ArrayList<>();
import java.util.ArrayList;
            closed = true;
    }
                    task.transitionTo(StageTaskState.FINISHED);
 *   sink implements {@link MultiInputExchangeSink}. {@code closeChildInput} closes
                listener.onResponse(null);
     */
            } else {
        }
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
                batch.close();
            mockContext(),
    private static void scheduleAndDispatch(ReduceStageExecution exec) {
        assertSame(cause, exec.getFailure());
import org.opensearch.test.OpenSearchTestCase;
        }
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
                @Override
            return false;
    }
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
    }
        public int getStageId() {
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        assertTrue("close still fires in onTerminalTransition for streaming", backend.closed);
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.analytics.spi.MultiInputExchangeSink;
        @Override
        boolean closed = false;
    private static final class FakeChildExecution implements StageExecution {
        assertEquals(StageExecution.State.FAILED, exec.getState());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        final Map<Integer, ExchangeSink> childWrappers = new HashMap<>();
 *
    public void testCancelCallsCancellableExchangeSinkCancelBeforeClose() {
        CapturingReducingSink backend = new CapturingReducingSink();
        private final Stage stage;
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
                @Override
        assertTrue("close() is still called on terminal", backend.closed);
    public void testStreamingCloseChildInputClosesPerChildWrapper() {
        assertSame(backend, exec.inputSink(42));
    }
            onStarted.onResponse(null);
 *   <li><b>Buffered</b> — sink's {@code supportsEagerScheduling()} returns false
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        public boolean supportsEagerScheduling() {
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("close still fires from onTerminalTransition on FAILED", backend.closed);
package org.opensearch.analytics.exec.stage;
                    task.transitionTo(StageTaskState.FAILED);
        assertTrue(backend.closed);
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecution;
 * <ul>
        scheduleAndDispatch(exec);
    public void testBufferedInputSinkReturnsBackendSinkForAnyChildId() {
        public void cancel() {
        CapturingReducingSink backend = new CapturingReducingSink();
        return stage;
    public void testOutputSourceThrowsWhenDownstreamDoesNotImplementExchangeSource() {
    public void testSuccessDoesNotCallCancellableExchangeSinkCancel() {
        }
        when(ctx.schedulerExecutor()).thenReturn(inlineExecutor());
        final List<VectorSchemaRoot> fed = new ArrayList<>();
        assertNotNull(exec.getFailure());
            return new StageMetrics();
            });
        expectThrows(UnsupportedOperationException.class, exec::outputSource);
                listener.onFailure(reduceFailure);
            for (StageStateListener l : listeners) {
    }
     * from ReducingExchangeSink (overriding the parent CapturingReducingSink's buffered
        assertEquals(StageExecution.State.FAILED, exec.getState());
        exec.failWithCause(new RuntimeException("child failed"));
        assertSame(boom, exec.getFailure());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), new CapturingReducingSink(), downstream);
    private static class CancellableCapturingSink extends CapturingReducingSink implements CancellableExchangeSink {
                @Override
        StreamingFakeSink backend = new StreamingFakeSink();
        }
        CapturingReducingSink backend = new CapturingReducingSink();
    /** CancellableExchangeSink variant that records cancel/close ordering. */
                }
        scheduleAndDispatch(exec);
    }
        assertTrue("cancel() before close()", backend.cancelCalledBeforeClose);
    // ── CancellableExchangeSink interaction ────────────────────────────────
 *   {@code close()}.</li>
        );
        @Override
     * cancels/closes the reduce sink to unblock its drain; the explicit per-child close
        public void reduce(ActionListener<Void> listener) {
    }
import org.apache.arrow.memory.BufferAllocator;
        assertFalse("closeChildInput on non-MultiInput sink must not close backend", backend.closed);
        private State state = State.CREATED;
        RuntimeException boom = new RuntimeException("reduce blew up");
        assertEquals("first close fires from failWithCause's terminal transition", 1, backend.closeCount);
        assertEquals("backend close fires exactly once across both calls", 1, backend.closeCount);
        StreamingFakeSink backend = new StreamingFakeSink();
    public void testStartIsNoopAfterTerminalTransition() {
    public void testStreamingStartTransitionsToFailedWhenReduceFires() {
            closeCount++;
    public void testOutputSourceReturnsDownstreamWhenItImplementsExchangeSource() {
        int closeCount = 0;
        FakeChildExecution(Stage stage) {
    private static final class StreamingFakeSink extends CapturingReducingSink implements MultiInputExchangeSink {
        RowProducingSink downstream = new RowProducingSink();
    public void testBufferedStartInvokesReduceAndTerminalInvokesClose() {
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        assertSame(downstream, exec.outputSource());
    }
        public State getState() {
        assertTrue(exec.schedulesEagerly());
            return null;
    // ── Streaming mode (supportsEagerScheduling = true) ───────────────────
        }
        assertEquals(StageExecution.State.FAILED, exec.getState());
            this.failure = cause;
    }
        scheduleAndDispatch(exec);
        CapturingReducingSink backend = new CapturingReducingSink();
            state = State.RUNNING;
        exec.attachChildren(List.of(child), r -> {});
        Exception cause = new RuntimeException("child failed");
            fed.add(batch);
    }
        public void close() {
                public void onFailure(Exception cause) {
 *   <li><b>Streaming</b> — sink's {@code supportsEagerScheduling()} returns true,
        }
    public void setUp() throws Exception {
        boolean cancelCalled = false;
     * override); implements MultiInputExchangeSink for per-child wrapper EOF.
        boolean transitioned = exec.failWithCause(new RuntimeException("late child failure"));
 * </ul>
    private static QueryContext mockContext() {
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
