 * The OpenSearch Contributors require contributions made to
import org.opensearch.analytics.planner.dag.QueryDAG;
            mock(ClusterService.class),
     */
        assertFalse("build leaf must not start for an already-cancelled task", buildExec.startInvoked);
        }
                // callback still points at wave 0's terminal roots and cancels nothing.
        );
/**
            new StageExecutionBuilder.SubGraph(buildExec, List.of(buildExec))
/*
        QueryScheduler scheduler = mock(QueryScheduler.class);
        when(builder.buildSubGraphWithSink(any(Stage.class), any(ExchangeSink.class), any(QueryContext.class), any())).thenReturn(
     * cancel see nothing, which is the bug surface this test guards.
import org.apache.arrow.vector.VectorSchemaRoot;
        @Override
            failure.get()
        public CompletableFuture<byte[]> ipcBytesFuture() {
        UnifiedDispatch dispatch = new UnifiedDispatch(
            State previous = state;
        Stage innerBuild = newRoleStage(/* stageId */ 0, Stage.StageRole.BROADCAST_BUILD);
        }
 * this file be licensed under the Apache-2.0 license or a
        AtomicReference<Throwable> failure = new AtomicReference<>();
            if (isTerminal(state)) {
            return stageId;
        assertNotNull(
        );
        }
        QueryDAG dag = new QueryDAG("qid", root);
        @Override
    }
import org.opensearch.analytics.exec.QueryContext;
    /**
        QueryContext ctx = mock(QueryContext.class);
        /** Drives SUCCEEDED, firing listeners — the transition the capture phase keys its wave advance off. */
        // the capture phase (collectBuildStages finds the build) and exercises the cancel wiring.
            }
        }
     * callback is installed once, by the first wave, and reads {@code activeRoots} so it can cancel whichever
            state = State.SUCCEEDED;
            /* preferMetadataDriver */ false,
            }
            throw new AssertionError("expected onFailure, got onResponse");
    private static final class FakeStageExecution implements StageExecution {
        }
     * {@link AnalyticsQueryTask#setOnCancelCallback(Runnable)} replays its callback synchronously because the
        AtomicInteger buildCalls = new AtomicInteger();
        public Exception getFailure() {
        QueryScheduler scheduler = mock(QueryScheduler.class);
            return CompletableFuture.completedFuture(new byte[] { 1, 2, 3 });
        FakeStageExecution(int stageId) {
        );
            if (isTerminal(state)) {
        // build's leaves are never dispatched.
        stage.setRole(role);
import org.opensearch.analytics.spi.ExchangeSink;
     * build execution to CANCELLED. The state listener must already be wired by then — otherwise
        private volatile State state = State.CREATED;
     * build listener BEFORE registering the cancel callback for exactly this reason.
        public void feed(VectorSchemaRoot batch) {}
        }
        public synchronized void addStateListener(StageStateListener listener) {
            /* preferMetadataDriver */ false,
        Stage stage = new Stage(stageId, null, List.of(children), null, null, null);
public class UnifiedDispatchTests extends OpenSearchTestCase {
            state = State.CANCELLED;
        dispatch.run(ctx, dag, buildStage -> mock(ExchangeSink.class), /* queryExecutionSink */ null, terminal);
            }
        // the task in the window described above.
    static final class FakeCaptureSink implements ExchangeSink {
        // The capture phase observes the already-cancelled task and bails before scheduling any leaf — the
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        public int getStageId() {
                l.onStateChange(previous, State.SUCCEEDED);
import static org.mockito.Mockito.never;
                l.onStateChange(previous, State.CANCELLED);
        Stage root = newRoleStage(/* stageId */ 2, Stage.StageRole.COORDINATOR_REDUCE, build);
            }
        verify(scheduler, never()).scheduleStage(any());
        assertTrue("precondition: wave 1 must have been reached", buildCalls.get() >= 2);
import java.util.concurrent.CompletableFuture;
            /* sortMergeJoinMinRows */ Long.MAX_VALUE
        // Nested broadcast: build 1's own build is build 0, so collectBuildWaves yields two waves,
     * {@code addStateListener} (which does not replay terminal states) never sees the transition and
                + "returns from its isCancelled() branch without cancelling its own roots or failing",
            mock(ClusterService.class),
        synchronized void succeed() {
        // 1) A parent task that's already cancelled — setOnCancelCallback will replay synchronously.
            // contract real stages honour — deferred stages notify on their async completion).
                return;
        @Override
     * Regression for cancellation landing BETWEEN capture waves (nested broadcast). The capture-phase cancel
            return state;
        @Override
     */
        public void start(ActionListener<Void> onStarted) {
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        when(scheduler.getStageExecutionBuilder()).thenReturn(builder);
        Stage build = newRoleStage(/* stageId */ 1, Stage.StageRole.BROADCAST_BUILD);
import java.util.Map;
        UnifiedDispatch dispatch = new UnifiedDispatch(
        );
import static org.mockito.Mockito.mock;
            "terminal must complete when cancellation lands between capture waves; otherwise the query "
     * Regression for the "task cancelled before the capture-phase listener is installed" race. If
        QueryDAG dag = new QueryDAG("qid", root);
            TaskId.EMPTY_TASK_ID,
     * task was already cancelled (user cancel landed during DAG rewrite), the cancel callback drives the
        FakeStageExecution innerExec = new FakeStageExecution(/* stageId */ 0);
        Stage outerBuild = newRoleStage(/* stageId */ 1, Stage.StageRole.BROADCAST_BUILD, innerBuild);
        }
        when(scheduler.getStageExecutionBuilder()).thenReturn(builder);
import java.util.List;
            for (StageStateListener l : listeners) {
                return;
        @Override
 * ({@code BroadcastJoinIT} / {@code GeneralSchedulerJoinIT}); this pins the listener-before-cancel-callback
     * {@code terminal.onFailure} never fires, leaving the query hung. {@link UnifiedDispatch} installs every
        private final int stageId;
        AnalyticsQueryTask task = new AnalyticsQueryTask(/* id */ 1L, "transport", "analytics_query", "qid", TaskId.EMPTY_TASK_ID, Map.of()
        cancelledTask.cancel("user cancel during DAG rewrite");
import static org.mockito.ArgumentMatchers.any;
        // 3) A DAG with a single BROADCAST_BUILD stage under the coordinator root, so UnifiedDispatch enters
        private static boolean isTerminal(State s) {
        innerExec.succeed();
        StageExecutionBuilder builder = mock(StageExecutionBuilder.class);
        );
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
            onStarted.onResponse(null);
        when(ctx.queryId()).thenReturn("qid");
     * still holds wave N's roots — which are terminal. {@code AbstractStageExecution#cancel} no-ops on a
        assertNotNull(
import org.opensearch.core.tasks.TaskId;
        // Drive wave 0 to SUCCEEDED. Its listener advances to wave 1, whose subgraph construction cancels
                + "callbacks; otherwise the query would hang",
    /**
    /**
import org.opensearch.analytics.exec.stage.StageExecution;
}
        when(ctx.parentTask()).thenReturn(task);
     * without cancelling its fresh roots or failing the terminal. Nothing completes the query: it hangs.
        @Override
import static org.mockito.Mockito.when;
    /** Capture-sink stand-in exposing the {@code ipcBytesFuture()} that {@code extractIpcBytes} reflects on. */
                task.cancel("user cancel between capture waves");
        FakeStageExecution outerExec = new FakeStageExecution(/* stageId */ 1);
        }
        @Override
            return null;
            "analytics_query",
 * compatible open source license.
        public State getState() {
        FakeStageExecution buildExec = new FakeStageExecution(/* stageId */ 1);
import java.util.concurrent.atomic.AtomicInteger;
        // 2) A fake StageExecution that records listeners and translates cancel(...) into a CANCELLED
            for (StageStateListener l : List.copyOf(listeners)) {
            startInvoked = true;
            this.stageId = stageId;
     * {@code isCancelled()} check has passed, and before wave N+1 publishes its own roots, {@code activeRoots}
            failure.get()
     * Hand-rolled StageExecution stand-in. Captures listeners; cancel(...) fires CANCELLED on any listeners
        assertTrue("precondition: task must be cancelled", cancelledTask.isCancelled());
     * present at cancel-time — the same contract AbstractStageExecution honors. Listeners attached AFTER
import org.opensearch.analytics.exec.stage.StageMetrics;
            Map.of()
                + "hangs — the one-shot cancel callback still points at wave 0's terminal roots, and wave 1 "
import org.opensearch.analytics.planner.dag.Stage;
            State previous = state;
package org.opensearch.analytics.exec.join;
        StageExecutionBuilder builder = mock(StageExecutionBuilder.class);
 *
        ActionListener<Iterable<VectorSchemaRoot>> terminal = ActionListener.wrap(v -> {
            }
        public StageMetrics getMetrics() {
        public synchronized void cancel(String reason) {
            "transport",
        when(builder.buildSubGraphWithSink(any(Stage.class), any(ExchangeSink.class), any(QueryContext.class), any())).thenAnswer(
        ActionListener<Iterable<VectorSchemaRoot>> terminal = ActionListener.wrap(v -> {
        }
        }
            return null;
    }
    }
            throw new AssertionError("expected onFailure, got onResponse");
            scheduler,
import org.opensearch.analytics.exec.stage.StageStateListener;
            invocation -> {
        @Override
 * dispatch (capture → inject → shuffle promotion → transport) is covered by the cluster ITs
        AnalyticsQueryTask cancelledTask = new AnalyticsQueryTask(/* id */ 1L,
            mock(CapabilityRegistry.class),
import org.opensearch.cluster.service.ClusterService;
            return s == State.SUCCEEDED || s == State.FAILED || s == State.CANCELLED;
    public void testRunFailsTerminalWhenTaskCancelledBetweenWaves() {
        // state-listener fire — the same contract AbstractStageExecution honors.
            "qid",
        private final List<StageStateListener> listeners = new ArrayList<>();
import static org.mockito.Mockito.verify;
        dispatch.run(ctx, dag, buildStage -> new FakeCaptureSink(), /* queryExecutionSink */ null, terminal);
        when(ctx.parentTask()).thenReturn(cancelledTask);
        }, failure::set);
        );
     * wave is in flight. But there is a window: after wave N's builds have all SUCCEEDED and its
            listeners.add(listener);
                // Wave 1 is being built. Cancel NOW: wave 0 has already succeeded and passed its
import java.util.ArrayList;
        @Override
     */
import org.opensearch.analytics.exec.QueryScheduler;
        return stage;
 * race the single general dispatcher inherited from the deleted {@code BroadcastDispatch}. The end-to-end
     * terminal state (its {@code transitionTo} returns false), so the callback fires no listener. Wave N+1 then
        }
        // innermost (build 0) first.
 */
            scheduler,
        Stage root = newRoleStage(/* stageId */ 2, Stage.StageRole.COORDINATOR_REDUCE, outerBuild);
import org.opensearch.core.action.ActionListener;
        when(ctx.queryId()).thenReturn("qid");
        );
 */
 * Unit tests for {@link UnifiedDispatch}'s broadcast-capture phase — specifically the cancel-before-run
 * ordering that a JVM test can assert deterministically.
import java.util.concurrent.atomic.AtomicReference;
                if (buildCalls.getAndIncrement() == 0) {
    public void testRunFailsTerminalWhenTaskCancelledBeforeRun() {
        QueryContext ctx = mock(QueryContext.class);
        }, failure::set);
        public void close() {}
        );
     * observes the cancellation in its own {@code isCancelled()} branch and returns without scheduling — and
                    return new StageExecutionBuilder.SubGraph(innerExec, List.of(innerExec));
                }
                return new StageExecutionBuilder.SubGraph(outerExec, List.of(outerExec));
            /* sortMergeJoinMinRows */ Long.MAX_VALUE
            "terminal.onFailure must fire when the task was cancelled before the capture phase installed its "
import org.opensearch.analytics.planner.CapabilityRegistry;
    }
    private static Stage newRoleStage(int stageId, Stage.StageRole role, Stage... children) {
        private volatile boolean startInvoked = false;
            // Synchronous fake: materialisation completes inline, so notify immediately (the
        AtomicReference<Throwable> failure = new AtomicReference<>();
                // isCancelled() check, but wave 1 has not yet published its roots, so the one-shot
            mock(CapabilityRegistry.class),
