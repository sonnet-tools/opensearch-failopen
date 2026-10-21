 * Exercises dispatch + retry seam in isolation, using a fake stage + fake runner — no real
        assertEquals("retry attempt transitioned to RUNNING", StageTaskState.RUNNING, retryTask.state());
    // ─── helpers ──────────────────────────────────────────────────────────
    }
    /** Records every run() invocation with its handle so tests can drive lifecycle manually. */
        assertEquals("retry attempt dispatched via same runner", 2, stage.runner.dispatched.size());
        scheduler.scheduleStage(stage);
        @Override
            for (StageStateListener l : stateListeners) {
            lastTerminalCause.set(cause);
        scheduler.scheduleStage(stage);
     * Simulates the "No ReaderContext" bug scenario: task cancelled on data node (stream error) →
    /**
        assertEquals(StageTaskState.RUNNING, retryTask.state());
     * Retry-aware stage with exhaustion: first onFailed → retargetForRetry returns alternate →
        scheduler.scheduleStage(stage);
        org.mockito.Mockito.doAnswer(invocation -> {
                stage.runner.dispatched.size()
        java.util.Map<Integer, org.opensearch.analytics.planner.dag.ShardExecutionTarget> targetMap = new java.util.HashMap<>();
        StageTask originalTask = makeTask(0);
        assertSame(retryTask, stage.runner.dispatched.get(1).task);
        final List<Dispatch> dispatched = new ArrayList<>();
        }
    }
                stage.terminalCalls.get()
        assertNotSame("target no longer points to primary", primaryTarget, targetMap.get(0));
        assertNull("success — null cause", stage.lastTerminalCause.get());
            StageExecution.State.SUCCEEDED }) {
    }
    }
     * failure propagates to {@code onTaskTerminal} so per-attempt bookkeeping cleans up.
    /** Scheduler must skip dispatch when start() transitions the stage straight to a terminal. */
        assertSame("second failure propagated as terminal cause", second, stage.lastTerminalCause.get());
            targetMap.put(ordinal, target);
            java.util.Collections.emptySet(),
            java.util.Collections.emptyMap(),
        final CapturingRunner runner = new CapturingRunner();
    }
        FakeStage(StageTask... tasks) {
     */
    }
        FakeStage stage = new FakeStage(originalTask);
    public void testRetryAfterCancelledStreamUsesNewAttemptOnSuccess() {
    @Override
        })
    /** Default path (no retry): handle.onFailed → task FAILED + stage.onTaskTerminal(task, cause). */
    public void testHandleOnFailedPropagatesWhenNoRetryAvailable() {
        }
 * Unit tests for {@link QueryScheduler#scheduleStage} and {@link QueryScheduler#handleFor}.
     * Retry then success: original attempt fails, retry succeeds. Pins the contract
    private static final class FakeStage implements StageExecution {
        }
        assertSame("before retry, target points to primary", primaryTarget, targetMap.get(0));
                org.mockito.ArgumentMatchers.any()
        }
        }
        org.opensearch.core.index.shard.ShardId shardId = new org.opensearch.core.index.shard.ShardId("test_idx", "uuid", 0);
    public void testScheduleStageSkipsDispatchWhenStageEntersTerminalDuringStart() {
        assertEquals("replica node is the fetch target", "replica", targetMap.get(0).node().getId());
                cause,
        }
        handle.onFailure(new org.opensearch.core.tasks.TaskCancelledException("query cancelled"));
        final List<StageStateListener> stateListeners = new ArrayList<>();
     */
     */
    /**
        handle.onFailure(second);
        final AtomicReference<Exception> lastTerminalCause = new AtomicReference<>();
        assertSame("retry task dispatched", retryTask, stage.runner.dispatched.get(1).task);
     * so the test isolates scheduler behavior from state-machine machinery.
import org.opensearch.analytics.exec.task.TaskRunner;
                org.mockito.ArgumentMatchers.anyInt(),
        assertEquals("terminal called once", 1, stage.terminalCalls.get());
        assertEquals("retry FINISHED", StageTaskState.FINISHED, retryTask.state());
 * The OpenSearch Contributors require contributions made to
        handle.onResponse(null);
        });
        assertEquals("retry dispatched after cancellation", 2, stage.runner.dispatched.size());
        assertEquals(StageTaskState.FAILED, stage.tasks().get(0).state());
 */
        @Override
     * retarget returns empty → propagates to onTaskTerminal. Pins the contract that BOTH
        // Simulate updateResolvedTarget after retry succeeds on replica
        assertSame("retry reuses the original handle", handle, stage.runner.dispatched.get(1).handle);
        );
        }
            return lastTerminalCause.get();
import java.util.Optional;
        stage.retryQueue.add(Optional.of(retryTask));  // first onFailed → retry
     */
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
        scheduler.scheduleStage(stage);
        }
        assertEquals("terminal callback fired exactly once", 1, stage.terminalCalls.get());
        assertEquals("superseded original attempt stays FAILED", StageTaskState.FAILED, originalTask.state());
        }
                1,
        assertEquals("terminal propagation after retry exhausted", 1, stage.terminalCalls.get());
    public void testUpdateResolvedTargetReplacesStaleEntry() {
        // First attempt fails → dispatch retry
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
/**
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        public StageMetrics getMetrics() {
            );
    public void testHandleOnCompletedTransitionsTaskAndCallsOnTerminal() {
        handle.onResponse(null);
    }
        @Override
            return runner;
            new org.opensearch.analytics.planner.dag.ShardExecutionTarget(replicaNode, shardId, 0);
import org.opensearch.analytics.exec.stage.StageStateListener;
        org.mockito.Mockito.when(config.getResolvedTargets(0)).thenReturn(targetMap);
        org.opensearch.analytics.planner.dag.ShardExecutionTarget primaryTarget =
    }
        RuntimeException second = new RuntimeException("retry attempt failed");
            State from = state;
        // Second failure on the retry — stage has exhausted alternates.
 * SPDX-License-Identifier: Apache-2.0
        record Dispatch(StageTask task, ActionListener<Void> handle) {
     * where to send fetch requests, so the map must reflect the node that actually ran the query.
import org.opensearch.transport.TransportService;
            return new StageMetrics();
        public TaskRunner taskRunner() {
        FakeStage stage = new FakeStage(originalTask);
            FakeStage stage = new FakeStage(makeTask(0));
    }
    /** Happy path: scheduler iterates tasks, transitions each to RUNNING, runs them. */
 * this file be licensed under the Apache-2.0 license or a
    public void testRetryExhaustionMarksBothOriginalAndRetryAttemptsFailed() {
        @Override
        }
        }
            );
        @Override
        FakeStage stage = new FakeStage(makeTask(0));
        // Retry dispatched to replica
                org.mockito.ArgumentMatchers.anyInt(),
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
        for (StageTask t : stage.tasks()) {
    }
     */
        FakeStage stage = new FakeStage();  // empty tasks
            new org.opensearch.analytics.planner.dag.ShardExecutionTarget(primaryNode, shardId, 0);
    private QueryScheduler scheduler;
        assertEquals("no terminal yet — stage stays RUNNING during retry", 0, stage.terminalCalls.get());
import org.opensearch.analytics.exec.stage.StageMetrics;
        org.opensearch.cluster.node.DiscoveryNode replicaNode = new org.opensearch.cluster.node.DiscoveryNode(
        config.updateResolvedTarget(0, 0, replicaTarget);
            );
import org.opensearch.core.action.ActionListener;
        @Override
import org.opensearch.tasks.TaskManager;
    }
        stage.retryQueue.add(Optional.empty());        // second onFailed → give up
                1,
     * is always wrong, regardless of which terminal state it landed in. Original
        assertEquals("onTaskTerminal called with no cause", 1, stage.terminalCalls.get());
import org.opensearch.analytics.exec.stage.StageTaskState;
        StageTask originalTask = makeTask(0);
            StageExecution.State.CANCELLED,
/*
            buildNewFakeTransportAddress(),
 */
     * Test stage implementing {@link StageExecution} directly. Bypasses AbstractStageExecution
            stage.retryQueue.add(Optional.of(retryTask));
     * fix for the "No ReaderContext" bug — the LM fetch uses getResolvedTargets() to decide
        org.opensearch.analytics.planner.dag.ShardExecutionTarget replicaTarget =
        org.opensearch.cluster.node.DiscoveryNode primaryNode = new org.opensearch.cluster.node.DiscoveryNode(
    public void testRetrySuccessTransitionsCorrectTaskStates() {
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
            return null;
        final List<Optional<StageTask>> retryQueue = new ArrayList<>();
            assertSame(
            scheduler.scheduleStage(stage);
        FakeStage stage = new FakeStage(makeTask(0), makeTask(1));
        assertEquals("original marked FAILED", StageTaskState.FAILED, originalTask.state());
                "onTaskTerminal still fires (stage=" + terminalState + ") so per-attempt bookkeeping cleans up",
import java.util.concurrent.atomic.AtomicInteger;
                stage.lastTerminalCause.get()
        FakeStage stage = new FakeStage(makeTask(0));
        stage.startTarget = StageExecution.State.SUCCEEDED;  // start() goes CREATED→SUCCEEDED directly
                "no retry dispatch when stage is " + terminalState + " — short-circuit must skip retargetForRetry",
        assertEquals("each task should have been dispatched once", 2, stage.runner.dispatched.size());
     * is left in RUNNING. This was the gap that motivated tracking the current attempt
    /**
    /**
 * compatible open source license.
    public void testTerminalStageSkipsRetryAndPropagatesOriginalCause() {
        assertNull(stage.lastTerminalCause.get());
            StageExecution.State.FAILED,
import java.util.concurrent.atomic.AtomicReference;
        assertNotSame("currentAttempt differs from original — updateResolvedTarget condition met", originalTask, retryTask);
     * retry on replica succeeds → verify that currentAttempt (the retry) is different from the
import org.opensearch.analytics.exec.stage.StageTask;
            return state;
        // Retry succeeds — retry attempt transitions to FINISHED, original stays FAILED.
    public void setUp() throws Exception {
        StageTask retryTask = makeTask(0);
        super.setUp();
import java.util.List;
        scheduler = new QueryScheduler(mock(StageExecutionBuilder.class), transportService);
        FakeStage stage = new FakeStage(originalTask);
     * that the superseded original ends in FAILED and the retry ends in FINISHED — neither
        assertEquals(StageTaskState.FINISHED, stage.tasks().get(0).state());
        }
        public void start(ActionListener<Void> onStarted) {
            this.tasks = List.of(tasks);
            assertEquals(
                "original cause propagated, not wrapped or replaced (stage=" + terminalState + ")",
        assertNull("success path passes null cause to onTaskTerminal", stage.lastTerminalCause.get());
     */
        // Retry succeeds on replica — this is where updateResolvedTarget should fire
        public State getState() {
    }
        final List<StageTask> tasks;
            org.opensearch.Version.CURRENT
            terminalCalls.incrementAndGet();
        final AtomicInteger terminalCalls = new AtomicInteger();
     * in the handle.
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
            RuntimeException cause = new RuntimeException("dispatch failed after stage terminal=" + terminalState);
        StageTask retryTask = makeTask(0);  // same slot id — retry is a new attempt at the same partition
        handle.onFailure(new RuntimeException("first attempt failed"));
        @Override
import org.opensearch.test.OpenSearchTestCase;
            stateListeners.add(listener);
        for (StageExecution.State terminalState : new StageExecution.State[] {
     * ({@link StageExecution.State#CANCELLED}, {@link StageExecution.State#FAILED},
        targetMap.put(0, primaryTarget);
        @Override
            java.util.Collections.emptyMap(),
        @Override
            assertEquals(
        // Simulate recordResolvedTargets at plan time — records primary
        public Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
    }
        RuntimeException first = new RuntimeException("first attempt failed");
        // After fix: target now points to replica
     * the original attempt and the retry attempt end in FAILED — neither is left as RUNNING.
    private static final class CapturingRunner implements TaskRunner<StageTask> {
            state = startTarget;
        assertSame("after updateResolvedTarget, target points to replica", replicaTarget, targetMap.get(0));
     * scheduler dispatches alternate via runner with the SAME handle. Second onFailed →
import java.util.ArrayList;
            }
        }
        scheduler.scheduleStage(stage);
                l.onStateChange(from, startTarget);
        assertEquals("initial dispatch", 1, stage.runner.dispatched.size());
        RuntimeException cause = new RuntimeException("boom");
     * Verifies that {@link QueryContext#updateResolvedTarget} correctly replaces a stale
        public void cancel(String reason) {}
            .updateResolvedTarget(
        public Exception getFailure() {
        handle.onFailure(cause);
            assertEquals("task transitioned to RUNNING before dispatch", StageTaskState.RUNNING, t.state());
        assertEquals("retry attempt marked FINISHED on success", StageTaskState.FINISHED, retryTask.state());
        State state = State.CREATED;
        @Override
        handle.onFailure(first);
            org.opensearch.analytics.planner.dag.ShardExecutionTarget target = invocation.getArgument(2);
        StageTask originalTask = makeTask(0);
        );
 *
        public List<StageTask> tasks() {
        stage.retryQueue.add(Optional.of(retryTask));
        return new ShardStageTask(new StageTaskId(0, partitionId), new ExecutionTarget(null) {
            return retryQueue.isEmpty() ? Optional.empty() : retryQueue.remove(0);
        @Override
        assertEquals("retry attempt marked FAILED on exhaustion", StageTaskState.FAILED, retryTask.state());
        @Override
        scheduler.scheduleStage(stage);
}
        handle.onResponse(null);
    /**
        public int getStageId() {
            return tasks;
            dispatched.add(new Dispatch(task, handle));
        assertEquals("original attempt marked FAILED when superseded by retry", StageTaskState.FAILED, originalTask.state());
            int ordinal = invocation.getArgument(1);
     * or {@link StageExecution.State#SUCCEEDED}), the scheduler must NOT consult
        QueryContext config = mock(QueryContext.class);
    public void testScheduleStageRunsEachTaskAfterTransitioningRunning() {
            org.opensearch.Version.CURRENT
    private static StageTask makeTask(int partitionId) {
        assertSame(cause, stage.lastTerminalCause.get());
     * in the fix (QueryScheduler checks currentAttempt != task after retry success).
        // because currentAttempt (retryTask) != task (originalTask)
        StageTask retryTask = makeTask(0);
            stage.state = terminalState;
            buildNewFakeTransportAddress(),
            );
        }
import static org.mockito.Mockito.when;
        // Here currentAttempt == retryTask, task == originalTask → they're different → fix triggers.
            "primary",
        State startTarget = State.RUNNING;  // override to simulate empty-target → SUCCEEDED, etc.
            "replica",
import static org.mockito.Mockito.mock;
        stage.retryQueue.add(Optional.of(retryTask));
import org.opensearch.analytics.exec.stage.StageTaskId;
            return 0;
        // The fix checks: if (currentAttempt != task && stage instanceof ShardFragmentStageExecution)
    /**
        assertEquals(StageTaskState.FAILED, originalTask.state());
     * primary target with the replica target after a successful retry. This is the data-layer
        // Data node cancels the stream — propagates as TaskCancelledException to coordinator
        when(transportService.getTaskManager()).thenReturn(mock(TaskManager.class));
            onStarted.onResponse(null);
package org.opensearch.analytics.exec;
            handle.onFailure(cause);
            ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
public class QuerySchedulerTests extends OpenSearchTestCase {
     * original task when onResponse fires. This is the condition that triggers updateResolvedTarget
            int stageId = invocation.getArgument(0);
        assertEquals("retry is RUNNING", StageTaskState.RUNNING, retryTask.state());
        }
            // Stage transitions terminally before the in-flight task's failure arrives.
import org.opensearch.analytics.exec.stage.StageExecution;
        assertTrue("no tasks dispatched", stage.runner.dispatched.isEmpty());
 * graph, no Guice wiring.
        public void run(StageTask task, ActionListener<Void> handle) {
import org.opensearch.analytics.planner.dag.ExecutionTarget;
            java.util.Collections.emptySet(),
        public void onTaskTerminal(StageTask task, Exception cause) {
            assertEquals("initial dispatch (state=" + terminalState + ")", 1, stage.runner.dispatched.size());
     * Terminal-stage short-circuit: once the stage enters ANY terminal state
     * {@code retargetForRetry}. Spawning new dispatch work for a stage that's done
            .when(config)
        public void addStateListener(StageStateListener listener) {
            StageTask retryTask = makeTask(0);  // would be returned if retargetForRetry were called
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
        // Before fix: target points to primary
    /** handle.onCompleted → task FINISHED + stage.onTaskTerminal(task, null). */
        assertEquals("no further dispatch", 2, stage.runner.dispatched.size());
        scheduler.scheduleStage(stage);
        TransportService transportService = mock(TransportService.class);
