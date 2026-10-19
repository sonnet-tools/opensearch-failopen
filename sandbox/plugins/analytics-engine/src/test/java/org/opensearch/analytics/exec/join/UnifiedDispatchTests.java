        public StageMetrics getMetrics() {
        private final int stageId;
            throw new AssertionError("expected onFailure, got onResponse");  
        // innermost (build 0) first.
            mock(CapabilityRegistry.class),
        Stage root = newRoleStage(/* stageId */ 2, Stage.StageRole.COORDINATOR_REDUCE, build);  
        dispatch.run(ctx, dag, buildStage -> mock(ExchangeSink.class), /* queryExecutionSink */ null, terminal);  
        return stage;
        // build's leaves are never dispatched.
import static org.mockito.Mockito.never;  
            return state;  
        UnifiedDispatch dispatch = new UnifiedDispatch(  
        assertTrue("precondition: wave 1 must have been reached", buildCalls.get() >= 2);
        public Exception getFailure() {
import org.opensearch.analytics.exec.QueryContext;
        @Override
                + "returns from its isCancelled() branch without cancelling its own roots or failing",
        StageExecutionBuilder builder = mock(StageExecutionBuilder.class);
                }  
    private static final class FakeStageExecution implements StageExecution {
        public CompletableFuture<byte[]> ipcBytesFuture() {  
        }  
import java.util.concurrent.atomic.AtomicReference;
    /**
            this.stageId = stageId;
 */
        );  
            // contract real stages honour — deferred stages notify on their async completion).  
        when(ctx.queryId()).thenReturn("qid");
        when(scheduler.getStageExecutionBuilder()).thenReturn(builder);
    public void testRunFailsTerminalWhenTaskCancelledBeforeRun() {
     * build execution to CANCELLED. The state listener must already be wired by then — otherwise
        }  
        // The capture phase observes the already-cancelled task and bails before scheduling any leaf — the
import org.opensearch.analytics.planner.dag.Stage;
        private volatile boolean startInvoked = false;
        }
            }  
import org.opensearch.analytics.exec.stage.StageMetrics;  
    public void testRunFailsTerminalWhenTaskCancelledBetweenWaves() {
        when(ctx.queryId()).thenReturn("qid");
        assertFalse("build leaf must not start for an already-cancelled task", buildExec.startInvoked);
            mock(CapabilityRegistry.class),  
        AnalyticsQueryTask cancelledTask = new AnalyticsQueryTask(/* id */ 1L,  
        public void start(ActionListener<Void> onStarted) {  
            throw new AssertionError("expected onFailure, got onResponse");
            new StageExecutionBuilder.SubGraph(buildExec, List.of(buildExec))  
                return;
import org.opensearch.analytics.planner.CapabilityRegistry;  
import org.opensearch.analytics.spi.ExchangeSink;  
                // isCancelled() check, but wave 1 has not yet published its roots, so the one-shot
        private final List<StageStateListener> listeners = new ArrayList<>();  
        );  
            Map.of()
                    return new StageExecutionBuilder.SubGraph(innerExec, List.of(innerExec));
        @Override
     * {@code addStateListener} (which does not replay terminal states) never sees the transition and  
        public int getStageId() {  
        );
        StageExecutionBuilder builder = mock(StageExecutionBuilder.class);  
        }
        @Override
import static org.mockito.ArgumentMatchers.any;
            return null;
        Stage stage = new Stage(stageId, null, List.of(children), null, null, null);
            }
                + "callbacks; otherwise the query would hang",
        // Nested broadcast: build 1's own build is build 0, so collectBuildWaves yields two waves,  
        dispatch.run(ctx, dag, buildStage -> new FakeCaptureSink(), /* queryExecutionSink */ null, terminal);
        // the capture phase (collectBuildStages finds the build) and exercises the cancel wiring.
import org.apache.arrow.vector.VectorSchemaRoot;
     * wave is in flight. But there is a window: after wave N's builds have all SUCCEEDED and its
        AtomicReference<Throwable> failure = new AtomicReference<>();
    }
            }
 * ({@code BroadcastJoinIT} / {@code GeneralSchedulerJoinIT}); this pins the listener-before-cancel-callback
            /* sortMergeJoinMinRows */ Long.MAX_VALUE
        synchronized void succeed() {  
        @Override
    }
            return CompletableFuture.completedFuture(new byte[] { 1, 2, 3 });
    }  
            if (isTerminal(state)) {
        );
            return stageId;
        @Override  
     * task was already cancelled (user cancel landed during DAG rewrite), the cancel callback drives the
import java.util.ArrayList;  
        }, failure::set);
    /**
/**
        QueryDAG dag = new QueryDAG("qid", root);
import java.util.Map;
     * Regression for the "task cancelled before the capture-phase listener is installed" race. If
        @Override  
            State previous = state;
        UnifiedDispatch dispatch = new UnifiedDispatch(
        // 3) A DAG with a single BROADCAST_BUILD stage under the coordinator root, so UnifiedDispatch enters  
     * {@code isCancelled()} check has passed, and before wave N+1 publishes its own roots, {@code activeRoots}
     * Hand-rolled StageExecution stand-in. Captures listeners; cancel(...) fires CANCELLED on any listeners  
        verify(scheduler, never()).scheduleStage(any());  
     * without cancelling its fresh roots or failing the terminal. Nothing completes the query: it hangs.  
            mock(ClusterService.class),
import java.util.concurrent.atomic.AtomicInteger;
            "qid",  
        cancelledTask.cancel("user cancel during DAG rewrite");
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        QueryContext ctx = mock(QueryContext.class);
            return null;
    }
     * callback is installed once, by the first wave, and reads {@code activeRoots} so it can cancel whichever  
        );  
 * compatible open source license.
        @Override
        public void close() {}
                l.onStateChange(previous, State.CANCELLED);
        }
            mock(ClusterService.class),
 * race the single general dispatcher inherited from the deleted {@code BroadcastDispatch}. The end-to-end  
 * SPDX-License-Identifier: Apache-2.0
        // 1) A parent task that's already cancelled — setOnCancelCallback will replay synchronously.
        assertNotNull(
            /* preferMetadataDriver */ false,
     */
        private volatile State state = State.CREATED;
        QueryScheduler scheduler = mock(QueryScheduler.class);  
            scheduler,  
            /* sortMergeJoinMinRows */ Long.MAX_VALUE
public class UnifiedDispatchTests extends OpenSearchTestCase {
     * build listener BEFORE registering the cancel callback for exactly this reason.
import org.opensearch.cluster.service.ClusterService;
     * {@code terminal.onFailure} never fires, leaving the query hung. {@link UnifiedDispatch} installs every
        // Drive wave 0 to SUCCEEDED. Its listener advances to wave 1, whose subgraph construction cancels  
            // Synchronous fake: materialisation completes inline, so notify immediately (the
            }  
                return new StageExecutionBuilder.SubGraph(outerExec, List.of(outerExec));
import org.opensearch.analytics.exec.stage.StageStateListener;
            listeners.add(listener);  
        FakeStageExecution(int stageId) {
            for (StageStateListener l : List.copyOf(listeners)) {  
     * {@link AnalyticsQueryTask#setOnCancelCallback(Runnable)} replays its callback synchronously because the  
        Stage innerBuild = newRoleStage(/* stageId */ 0, Stage.StageRole.BROADCAST_BUILD);
 * ordering that a JVM test can assert deterministically.  
            state = State.SUCCEEDED;
        }, failure::set);  
            TaskId.EMPTY_TASK_ID,
            State previous = state;
            "terminal.onFailure must fire when the task was cancelled before the capture phase installed its "  
            failure.get()  
 *
    static final class FakeCaptureSink implements ExchangeSink {
        innerExec.succeed();
        assertNotNull(
     * observes the cancellation in its own {@code isCancelled()} branch and returns without scheduling — and
        FakeStageExecution outerExec = new FakeStageExecution(/* stageId */ 1);
     */  
import static org.mockito.Mockito.when;
        when(ctx.parentTask()).thenReturn(task);  
        );
 */  
            /* preferMetadataDriver */ false,  
        // state-listener fire — the same contract AbstractStageExecution honors.
     * still holds wave N's roots — which are terminal. {@code AbstractStageExecution#cancel} no-ops on a  
     */  
        }  
        @Override  
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
import org.opensearch.test.OpenSearchTestCase;
        AtomicInteger buildCalls = new AtomicInteger();
import org.opensearch.core.tasks.TaskId;  
    private static Stage newRoleStage(int stageId, Stage.StageRole role, Stage... children) {
        when(builder.buildSubGraphWithSink(any(Stage.class), any(ExchangeSink.class), any(QueryContext.class), any())).thenAnswer(
        }
            startInvoked = true;
        }
        @Override  
        }
        AtomicReference<Throwable> failure = new AtomicReference<>();  
            for (StageStateListener l : listeners) {  
        // 2) A fake StageExecution that records listeners and translates cancel(...) into a CANCELLED
        AnalyticsQueryTask task = new AnalyticsQueryTask(/* id */ 1L, "transport", "analytics_query", "qid", TaskId.EMPTY_TASK_ID, Map.of()  
        stage.setRole(role);  
        when(scheduler.getStageExecutionBuilder()).thenReturn(builder);
import java.util.List;
            }  
        public void feed(VectorSchemaRoot batch) {}
            invocation -> {  
            failure.get()
        FakeStageExecution buildExec = new FakeStageExecution(/* stageId */ 1);  
        }  
        private static boolean isTerminal(State s) {
     * Regression for cancellation landing BETWEEN capture waves (nested broadcast). The capture-phase cancel
        /** Drives SUCCEEDED, firing listeners — the transition the capture phase keys its wave advance off. */
            state = State.CANCELLED;
        );
                return;
        public State getState() {
        Stage build = newRoleStage(/* stageId */ 1, Stage.StageRole.BROADCAST_BUILD);
        // the task in the window described above.
    }
                // callback still points at wave 0's terminal roots and cancels nothing.  
        ActionListener<Iterable<VectorSchemaRoot>> terminal = ActionListener.wrap(v -> {
                l.onStateChange(previous, State.SUCCEEDED);
     * cancel see nothing, which is the bug surface this test guards.
        ActionListener<Iterable<VectorSchemaRoot>> terminal = ActionListener.wrap(v -> {
        QueryScheduler scheduler = mock(QueryScheduler.class);  
import static org.mockito.Mockito.verify;
                // Wave 1 is being built. Cancel NOW: wave 0 has already succeeded and passed its
        public synchronized void cancel(String reason) {  
     * terminal state (its {@code transitionTo} returns false), so the callback fires no listener. Wave N+1 then
                task.cancel("user cancel between capture waves");
 * this file be licensed under the Apache-2.0 license or a
 * dispatch (capture → inject → shuffle promotion → transport) is covered by the cluster ITs
        Stage outerBuild = newRoleStage(/* stageId */ 1, Stage.StageRole.BROADCAST_BUILD, innerBuild);  
import java.util.concurrent.CompletableFuture;  
import org.opensearch.core.action.ActionListener;
import static org.mockito.Mockito.mock;
            "terminal must complete when cancellation lands between capture waves; otherwise the query "  
package org.opensearch.analytics.exec.join;
     * present at cancel-time — the same contract AbstractStageExecution honors. Listeners attached AFTER
        QueryDAG dag = new QueryDAG("qid", root);
                + "hangs — the one-shot cancel callback still points at wave 0's terminal roots, and wave 1 "
 * Unit tests for {@link UnifiedDispatch}'s broadcast-capture phase — specifically the cancel-before-run
/*  
        FakeStageExecution innerExec = new FakeStageExecution(/* stageId */ 0);  
        public synchronized void addStateListener(StageStateListener listener) {
 * The OpenSearch Contributors require contributions made to  
        when(ctx.parentTask()).thenReturn(cancelledTask);  
            return s == State.SUCCEEDED || s == State.FAILED || s == State.CANCELLED;  
import org.opensearch.analytics.exec.QueryScheduler;  
}  
            "transport",
        QueryContext ctx = mock(QueryContext.class);
            "analytics_query",
import org.opensearch.analytics.planner.dag.QueryDAG;
        Stage root = newRoleStage(/* stageId */ 2, Stage.StageRole.COORDINATOR_REDUCE, outerBuild);
        when(builder.buildSubGraphWithSink(any(Stage.class), any(ExchangeSink.class), any(QueryContext.class), any())).thenReturn(
            if (isTerminal(state)) {
    /** Capture-sink stand-in exposing the {@code ipcBytesFuture()} that {@code extractIpcBytes} reflects on. */
            onStarted.onResponse(null);
        );
import org.opensearch.analytics.exec.stage.StageExecution;
    /**
        }  
                if (buildCalls.getAndIncrement() == 0) {
        assertTrue("precondition: task must be cancelled", cancelledTask.isCancelled());
            scheduler,
