        @Override
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        expectThrows(UnsupportedOperationException.class, exec::outputSource);
    }
        CapturingReducingSink backend = new CapturingReducingSink();  
            State prev = this.state;
                    exec.onTaskTerminal(task, null);  
        allocator = new RootAllocator();  
            }
        @Override
     */
        public State getState() {
        private final Stage stage;
            }
            });
        CapturingReducingSink backend = new CapturingReducingSink();  
                    task.transitionTo(StageTaskState.FINISHED);
        @SuppressWarnings("unchecked")  
        scheduleAndDispatch(exec);
        assertEquals("first close fires from cancel", 1, backend.closeCount);
        scheduleAndDispatch(exec);
    /** CancellableExchangeSink variant that records cancel/close ordering. */  
    /**  
        CancellableCapturingSink backend = new CancellableCapturingSink();
import static org.mockito.Mockito.mock;  
                    batch.close();
        super.setUp();
            this.failure = cause;  
        }  
    public void setUp() throws Exception {
        @Override
import org.opensearch.analytics.planner.dag.Stage;  
import java.util.HashMap;  
        exec.closeChildInput(0);
    private static QueryContext mockContext() {
    }
                ((Runnable) invocation.getArgument(0)).run();
import org.opensearch.analytics.exec.QueryContext;
        private State state = State.CREATED;
package org.opensearch.analytics.exec.stage;
        when(ctx.schedulerExecutor()).thenReturn(inlineExecutor());
        assertTrue("cancel() must be called on FAILED transition", backend.cancelCalled);
        public void close() {
 * Unit tests for {@link ReduceStageExecution}. Exercises both scheduling modes:
    /** Minimal child stage that can be manually failed to trigger the parent cascade. */  
    }
            return stage.getStageId();
        FakeChildExecution(Stage stage) {
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        CancellableCapturingSink backend = new CancellableCapturingSink();
import org.opensearch.analytics.spi.ExchangeSink;
            for (StageStateListener l : listeners) {  
        CapturingReducingSink backend = new CapturingReducingSink();
        FakeChildExecution child = new FakeChildExecution(childStageDef);  
 * The OpenSearch Contributors require contributions made to  
 * <ul>
import java.util.ArrayList;
        exec.cancel("user requested");  
import org.opensearch.analytics.exec.RowProducingSink;
            if (reduceFailure != null) {  
        public void close() {
        }
                public void onFailure(Exception cause) {
        CapturingReducingSink backend = new CapturingReducingSink();  
            reduceCalls.incrementAndGet();
            batch.close();  
        CapturingSink downstream = new CapturingSink();
        StreamingFakeSink backend = new StreamingFakeSink();  
        }  
        }
            return state;  
 *   <li><b>Streaming</b> — sink's {@code supportsEagerScheduling()} returns true,  
        assertFalse("closeChildInput on non-MultiInput sink must not close backend", backend.closed);  
        assertEquals("backend close fires exactly once across both calls", 1, backend.closeCount);
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
import org.opensearch.analytics.spi.CancellableExchangeSink;
import java.util.List;
        @Override
import java.util.concurrent.atomic.AtomicInteger;
        assertTrue("cancel() before close()", backend.cancelCalledBeforeClose);
        }  
                    exec.onTaskTerminal(task, cause);  
}
    }
            cancelCalled = true;
            closed = true;
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    }
        @Override
    // ── Streaming mode (supportsEagerScheduling = true) ───────────────────  
        public boolean supportsEagerScheduling() {  
                listener.onResponse(null);  
        assertTrue("close() must still be called after cancel()", backend.closed);  
        CapturingReducingSink backend = new CapturingReducingSink();  
                    closedChildIds.add(id);  
        assertTrue(backend.closed);
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, downstream);
        assertEquals(StageExecution.State.FAILED, exec.getState());  
        when(ctx.reduceExecutor()).thenReturn(inlineExecutor());
                listener.onFailure(reduceFailure);
                @Override
    // ── CancellableExchangeSink interaction ────────────────────────────────
    }  
            if (invocation.getMethod().getName().equals("execute")) {  
        assertFalse("cancel() must NOT be called on SUCCEEDED", backend.cancelCalled);
     * from ReducingExchangeSink (overriding the parent CapturingReducingSink's buffered
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    public void testFailFromChildAfterCancelDoesNotDoubleCloseBackendSink() {
 */
        assertEquals("backend not re-closed by no-op start()", 1, backend.closeCount);  
        final List<Integer> closedChildIds = new ArrayList<>();  
        assertTrue("close() must still be called", backend.closed);  
                }
        assertSame(boom, exec.getFailure());
        assertEquals("first terminal wins; cancel does not re-transition", StageExecution.State.FAILED, exec.getState());
        assertTrue("close still fires in onTerminalTransition for streaming", backend.closed);
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
import org.opensearch.core.action.ActionListener;
        assertEquals("backend close fires exactly once across both calls", 1, backend.closeCount);
        public void feed(VectorSchemaRoot batch) {
import org.apache.arrow.memory.BufferAllocator;
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());  
        private Exception failure;
        @Override
            for (VectorSchemaRoot batch : fed) {
        allocator.close();
        assertTrue("close() is still called on terminal", backend.closed);  
    }
                public void onResponse(Void unused) {
    public void testSuccessDoesNotCallCancellableExchangeSinkCancel() {
        exec.cancel("test cancellation");  
        RowProducingSink downstream = new RowProducingSink();
        }
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
     * Streaming-mode reducing sink — re-inherits the default supportsEagerScheduling=true
            }  
        CancellableCapturingSink backend = new CancellableCapturingSink();
 *   {@code close()}.</li>
            });
        }  
    }
        assertSame(cause, exec.getFailure());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());  
        );  
     * the parent's FAILED state before publishing child EOF. The terminal transition
        boolean closed = false;
        exec.cancel("user requested");
        assertTrue(exec.schedulesEagerly());
            task.transitionTo(StageTaskState.RUNNING);
    private Stage stageWithId(int id) {  
    private static ExecutorService inlineExecutor() {
        assertSame(backend, exec.inputSink(0));
        when(stage.getStageId()).thenReturn(id);
        assertTrue(backend.closed);  
    private static void scheduleAndDispatch(ReduceStageExecution exec) {
            this.stage = stage;
    }
    }
    public void tearDown() throws Exception {
    private static class CapturingReducingSink implements ReducingExchangeSink {
        }
     */
    }
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
    private static final class FakeChildExecution implements StageExecution {
    }  
        }
        assertSame(downstream, exec.outputSource());  
        StreamingFakeSink backend = new StreamingFakeSink();  
        public void reduce(ActionListener<Void> listener) {
        RuntimeException boom = new RuntimeException("drain failed");
        assertEquals(StageExecution.State.FAILED, exec.getState());
    @Override  
        QueryContext ctx = mock(QueryContext.class);  
        RuntimeException boom = new RuntimeException("reduce blew up");
    }
        CapturingReducingSink backend = new CapturingReducingSink();
        @Override
    }
                }
        public void cancel(String reason) {
        @Override  
     * cancels/closes the reduce sink to unblock its drain; the explicit per-child close  
import static org.mockito.Mockito.when;
            dispatcher.run(task, new ActionListener<>() {
    }
        exec.failWithCause(new RuntimeException("child failed"));
        backend.reduceFailure = boom;
        when(stage.getChildStages()).thenReturn(List.of());  
                @Override
                public void close() {
        Stage childStageDef = mock(Stage.class);  
import org.opensearch.test.OpenSearchTestCase;  
        boolean closed = false;
        return ctx;
    public void testBufferedStartInvokesReduceAndTerminalInvokesClose() {
import org.opensearch.analytics.exec.task.TaskRunner;
        @Override
        Exception cause = new RuntimeException("child failed");
        assertEquals(StageExecution.State.FAILED, exec.getState());  
                    task.transitionTo(StageTaskState.FAILED);
    }
        boolean cancelCalled = false;
                }
    // ── Buffered mode (default supportsEagerScheduling = false) ──────────  
        boolean transitioned = exec.failWithCause(cause);  
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), new CapturingReducingSink(), downstream);
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
import java.util.concurrent.ExecutorService;  
        assertEquals("each closeChildInput closed exactly one per-child wrapper", List.of(7, 11), backend.closedChildIds);  
    @Override  
            return childWrappers.computeIfAbsent(childStageId, id -> new ExchangeSink() {
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
            state = State.CANCELLED;
        ReduceStageExecution exec = new ReduceStageExecution(
        // Create a fake child stage that we can fail manually.
        child.failWith(new RuntimeException("shard exploded"));  
    }
            stageWithId(0),
    private static class CancellableCapturingSink extends CapturingReducingSink implements CancellableExchangeSink {
import org.apache.arrow.memory.RootAllocator;
    }
    public void testCancelCallsCancellableExchangeSinkCancelBeforeClose() {
    public void testBufferedSchedulesEagerlyIsFalse() {
    public void testStartTransitionsToFailedWhenReduceFiresOnFailure() {
    }  
        assertFalse(exec.schedulesEagerly());
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());  
        assertEquals("reduce was never invoked — cancel preceded body", 0, backend.reduceCalls.get());
        }  
        super.tearDown();  
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
import org.opensearch.analytics.spi.MultiInputExchangeSink;  
        assertSame(backend, exec.inputSink(7));
    public void testStreamingCloseChildInputClosesPerChildWrapper() {
        @Override  
     * still releases sinks that own independent inputs.
        exec.cancel("late external cancel");
        StreamingFakeSink backend = new StreamingFakeSink();  
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
            fed.add(batch);  
        assertTrue("close invoked from onTerminalTransition", backend.closed);
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("transition rejected — already terminal", transitioned);  
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    public void testStreamingSchedulesEagerlyIsTrue() {
        assertEquals(1, backend.reduceCalls.get());
        }  
        return stage;
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
/**  
        final Map<Integer, ExchangeSink> childWrappers = new HashMap<>();
            return true;
    }
import org.opensearch.analytics.spi.ReducingExchangeSink;
    public void testStreamingStartTransitionsToFailedWhenReduceFires() {
        when(childStageDef.getStageId()).thenReturn(childStageId);
        CapturingReducingSink backend = new CapturingReducingSink();
 *   <li><b>Buffered</b> — sink's {@code supportsEagerScheduling()} returns false  
        assertEquals("close fired once from cancel", 1, backend.closeCount);
        assertEquals("reduce invoked once from task body", 1, backend.reduceCalls.get());  
        boolean transitioned = exec.failWithCause(new RuntimeException("late child failure"));
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        }
 */  
        @Override
        when(ctx.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));  
        }  
    public void testFailFromChildClosesBackendSinkAndTransitions() {
    public void testBufferedInputSinkReturnsBackendSinkForAnyChildId() {  
        scheduleAndDispatch(exec);
    public void testOutputSourceReturnsDownstreamWhenItImplementsExchangeSource() {  
                public void feed(VectorSchemaRoot batch) {  
        if (dispatcher == null) return;
        }
        assertTrue(transitioned);
    public void testChildFailureFailsParentAndClosesChildInput() {  
 * </ul>  
        public void cancel() {  
        assertSame(backend, exec.inputSink(42));  
        assertNotNull(exec.getFailure());
        exec.closeChildInput(7);  
        }  
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        assertTrue("closeChildInput must be called for the failed child", backend.closedChildIds.contains(childStageId));
            listeners.add(listener);  
    // ── helpers ──────────────────────────────────────────────────────────
        }
/*  
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());  
    /**  
        assertTrue("cancel() must be called on CancellableExchangeSink", backend.cancelCalled);
    }
     * override); implements MultiInputExchangeSink for per-child wrapper EOF.  
        }  
            return new StageMetrics();
        for (StageTask task : exec.tasks()) {  
        CapturingReducingSink backend = new CapturingReducingSink();  
        CapturingReducingSink backend = new CapturingReducingSink();  
     * Regression: when a child stage transitions to FAILED, the cascade must claim
    public void testStartIsNoopAfterTerminalTransition() {
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
            return false;
 *   the corresponding per-child wrapper.</li>
    private static final class CapturingSink implements ExchangeSink {
            state = State.RUNNING;  
        @Override  
        public void feed(VectorSchemaRoot batch) {
    }
        final AtomicInteger reduceCalls = new AtomicInteger();  
 *
        exec.closeChildInput(11);
import java.util.Map;
                }
        scheduleAndDispatch(exec);
    public void testFailFromChildCallsCancellableExchangeSinkCancelBeforeClose() {
        @Override  
    }  
    }  
        boolean cancelCalledBeforeClose = false;  
            closed = true;  
            this.state = State.FAILED;
        int closeCount = 0;  
        return mock(ExecutorService.class, invocation -> {
            return null;
        // Fail the child — the cascade must fail the parent and still close input 5.
    public void testBufferedCloseChildInputIsNoopBecauseNotMultiInput() {  
        assertTrue("cancel() must fire before close()", backend.cancelCalledBeforeClose);
        scheduleAndDispatch(exec);  // start() returns no-op; no task body runs because state is already terminal
        @Override
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
    public void testOutputSourceThrowsWhenDownstreamDoesNotImplementExchangeSource() {  
    public void testCancelAfterFailFromChildDoesNotDoubleCloseBackendSink() {  
        assertEquals("first close fires from failWithCause's terminal transition", 1, backend.closeCount);  
            new CapturingSink()
        exec.failWithCause(new RuntimeException("child failed"));
        void failWith(Exception cause) {
            cancelCalledBeforeClose = !closed;
    }  
    public void testCancelClosesBackendSink() {
 *   (default). Task body invokes {@code reduce()}, terminal transition invokes
        exec.cancel("external cancel first");  
        RuntimeException reduceFailure;
            }
                @Override  
        public ExchangeSink sinkForChild(int childStageId) {  
 * compatible open source license.
    public void testStreamingStartInvokesReduceAndTransitionsToSucceeded() {
    /** Buffered-mode reducing sink — overrides supportsEagerScheduling to false. */  
            closeCount++;
        assertSame(boom, exec.getFailure());
        exec.attachChildren(List.of(child), r -> {});  
    }  
 *   sink implements {@link MultiInputExchangeSink}. {@code closeChildInput} closes
        public StageMetrics getMetrics() {
            } else {
        // No-op for non-MultiInput sinks — must not affect closed state.
    }  
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());  
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecution;  
        @Override
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("close still fires from onTerminalTransition on FAILED", backend.closed);
                return null;
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());  
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        StreamingFakeSink backend = new StreamingFakeSink();  
                batch.close();  
public class ReduceStageExecutionTests extends OpenSearchTestCase {
    }
    private static final class StreamingFakeSink extends CapturingReducingSink implements MultiInputExchangeSink {
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
            mockContext(),  
                @Override  
        assertEquals(StageExecution.State.FAILED, exec.getState());  
        CapturingReducingSink backend = new CapturingReducingSink();
    /** Bare ExchangeSink for the downstream slot. */  
        backend.reduceFailure = boom;
    }
        int childStageId = 5;
            onStarted.onResponse(null);
        public boolean supportsEagerScheduling() {
        scheduleAndDispatch(exec);  
        assertEquals(StageExecution.State.FAILED, exec.getState());
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        });
        StreamingFakeSink backend = new StreamingFakeSink();
import org.apache.arrow.vector.VectorSchemaRoot;  
    }
        // Wire the cascade: parent observes child state transitions.
    private BufferAllocator allocator;
            return failure;
        ReduceStageExecution exec = new ReduceStageExecution(stageWithId(0), mockContext(), backend, new CapturingSink());
        final List<VectorSchemaRoot> fed = new ArrayList<>();
        when(childStageDef.getChildStages()).thenReturn(List.of());
        public void addStateListener(StageStateListener listener) {
        assertFalse("downstream is not closed by reduce execution", downstream.closed);
    }
            new CapturingReducingSink(),
            fed.clear();
        @Override  
        public int getStageId() {  
        Stage stage = mock(Stage.class);
        assertEquals(StageExecution.State.FAILED, exec.getState());  
        }
        assertTrue(backend.closed);
        private final List<StageStateListener> listeners = new ArrayList<>();  
                l.onStateChange(prev, State.FAILED);
        }  
        public void start(ActionListener<Void> onStarted) {
        public Exception getFailure() {  
