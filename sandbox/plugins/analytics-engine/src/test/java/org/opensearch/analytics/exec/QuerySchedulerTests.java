        record Dispatch(StageTask task, ActionListener<Void> handle) {
            return runner;  
        scheduler.scheduleStage(stage);  
        assertNotSame("target no longer points to primary", primaryTarget, targetMap.get(0));  
        State state = State.CREATED;
        assertEquals("retry attempt transitioned to RUNNING", StageTaskState.RUNNING, retryTask.state());
            RuntimeException cause = new RuntimeException("dispatch failed after stage terminal=" + terminalState);
        public StageMetrics getMetrics() {
        // Retry succeeds — retry attempt transitions to FINISHED, original stays FAILED.
                org.mockito.ArgumentMatchers.anyInt(),
            return state;
        StageTask retryTask = makeTask(0);  
        handle.onFailure(new org.opensearch.core.tasks.TaskCancelledException("query cancelled"));  
import org.opensearch.transport.TransportService;
    }
            onStarted.onResponse(null);
        assertEquals("retry attempt dispatched via same runner", 2, stage.runner.dispatched.size());
        handle.onResponse(null);
        assertSame("retry reuses the original handle", handle, stage.runner.dispatched.get(1).handle);  
            StageExecution.State.FAILED,  
            );
            state = startTarget;  
            return 0;
        assertEquals("no further dispatch", 2, stage.runner.dispatched.size());  
     * Terminal-stage short-circuit: once the stage enters ANY terminal state
        public TaskRunner taskRunner() {
        // Retry dispatched to replica
 *
        public void run(StageTask task, ActionListener<Void> handle) {
/**
            for (StageStateListener l : stateListeners) {
        FakeStage stage = new FakeStage(originalTask);
            StageExecution.State.SUCCEEDED }) {
        // Second failure on the retry — stage has exhausted alternates.
        public void cancel(String reason) {}  
import java.util.concurrent.atomic.AtomicInteger;
     * is always wrong, regardless of which terminal state it landed in. Original  
    }  
public class QuerySchedulerTests extends OpenSearchTestCase {  
        stage.startTarget = StageExecution.State.SUCCEEDED;  // start() goes CREATED→SUCCEEDED directly
        final List<StageTask> tasks;  
 * compatible open source license.
            // Stage transitions terminally before the in-flight task's failure arrives.
        handle.onFailure(first);
        when(transportService.getTaskManager()).thenReturn(mock(TaskManager.class));
        assertSame("before retry, target points to primary", primaryTarget, targetMap.get(0));
    /** Happy path: scheduler iterates tasks, transitions each to RUNNING, runs them. */  
 */
            stateListeners.add(listener);  
    /**
            org.opensearch.Version.CURRENT
        @Override
        config.updateResolvedTarget(0, 0, replicaTarget);
                org.mockito.ArgumentMatchers.any()
            java.util.Collections.emptySet(),
            StageTask retryTask = makeTask(0);  // would be returned if retargetForRetry were called  
        assertEquals("retry is RUNNING", StageTaskState.RUNNING, retryTask.state());  
        FakeStage(StageTask... tasks) {
                l.onStateChange(from, startTarget);
        }  
        FakeStage stage = new FakeStage(originalTask);
        @Override
            this.tasks = List.of(tasks);  
        scheduler.scheduleStage(stage);  
        assertEquals(StageTaskState.FAILED, stage.tasks().get(0).state());
        // First attempt fails → dispatch retry  
            .when(config)  
import java.util.List;
    }  
     * where to send fetch requests, so the map must reflect the node that actually ran the query.  
        assertEquals(StageTaskState.FAILED, originalTask.state());
     */
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
     */
        QueryContext config = mock(QueryContext.class);
        org.opensearch.core.index.shard.ShardId shardId = new org.opensearch.core.index.shard.ShardId("test_idx", "uuid", 0);
                stage.terminalCalls.get()
            return null;
        stage.retryQueue.add(Optional.of(retryTask));
     * or {@link StageExecution.State#SUCCEEDED}), the scheduler must NOT consult
        for (StageTask t : stage.tasks()) {  
    private static final class CapturingRunner implements TaskRunner<StageTask> {  
    /** handle.onCompleted → task FINISHED + stage.onTaskTerminal(task, null). */
            .updateResolvedTarget(
        StageTask originalTask = makeTask(0);
        org.mockito.Mockito.doAnswer(invocation -> {
     * scheduler dispatches alternate via runner with the SAME handle. Second onFailed →
    }
 * SPDX-License-Identifier: Apache-2.0
    /**  
        assertSame("after updateResolvedTarget, target points to replica", replicaTarget, targetMap.get(0));
     * Test stage implementing {@link StageExecution} directly. Bypasses AbstractStageExecution
        }  
        public Exception getFailure() {
        FakeStage stage = new FakeStage(originalTask);
        }
                stage.lastTerminalCause.get()  
        StageTask retryTask = makeTask(0);
            StageExecution.State.CANCELLED,
import org.opensearch.tasks.TaskManager;  
     * Simulates the "No ReaderContext" bug scenario: task cancelled on data node (stream error) →  
        FakeStage stage = new FakeStage(makeTask(0), makeTask(1));
            }  
/*  
            new org.opensearch.analytics.planner.dag.ShardExecutionTarget(replicaNode, shardId, 0);
        }
    public void testRetryExhaustionMarksBothOriginalAndRetryAttemptsFailed() {
    /**
     * Verifies that {@link QueryContext#updateResolvedTarget} correctly replaces a stale  
     * ({@link StageExecution.State#CANCELLED}, {@link StageExecution.State#FAILED},  
     * primary target with the replica target after a successful retry. This is the data-layer
        org.opensearch.cluster.node.DiscoveryNode primaryNode = new org.opensearch.cluster.node.DiscoveryNode(  
    public void testRetryAfterCancelledStreamUsesNewAttemptOnSuccess() {
            return retryQueue.isEmpty() ? Optional.empty() : retryQueue.remove(0);
 * The OpenSearch Contributors require contributions made to  
            new org.opensearch.analytics.planner.dag.ShardExecutionTarget(primaryNode, shardId, 0);
        assertEquals("original marked FAILED", StageTaskState.FAILED, originalTask.state());
        final AtomicInteger terminalCalls = new AtomicInteger();
            java.util.Collections.emptyMap(),  
    }
import org.opensearch.analytics.exec.stage.StageMetrics;  
    private static final class FakeStage implements StageExecution {
    }  
        assertNull(stage.lastTerminalCause.get());
                org.mockito.ArgumentMatchers.anyInt(),  
        final List<Optional<StageTask>> retryQueue = new ArrayList<>();  
     */  
        assertEquals(StageTaskState.FINISHED, stage.tasks().get(0).state());
 * Exercises dispatch + retry seam in isolation, using a fake stage + fake runner — no real  
        FakeStage stage = new FakeStage(makeTask(0));  
        assertEquals(StageTaskState.RUNNING, retryTask.state());  
        }
        public void start(ActionListener<Void> onStarted) {
        State startTarget = State.RUNNING;  // override to simulate empty-target → SUCCEEDED, etc.  
        final List<Dispatch> dispatched = new ArrayList<>();
                stage.runner.dispatched.size()
        final CapturingRunner runner = new CapturingRunner();
        public List<StageTask> tasks() {  
            State from = state;
package org.opensearch.analytics.exec;
import org.opensearch.analytics.exec.stage.StageTask;
        })
            dispatched.add(new Dispatch(task, handle));
    }
        final AtomicReference<Exception> lastTerminalCause = new AtomicReference<>();
        org.opensearch.analytics.planner.dag.ShardExecutionTarget primaryTarget =
        assertEquals("retry dispatched after cancellation", 2, stage.runner.dispatched.size());  
    private QueryScheduler scheduler;
        // The fix checks: if (currentAttempt != task && stage instanceof ShardFragmentStageExecution)  
import org.opensearch.analytics.exec.stage.StageTaskState;
    public void setUp() throws Exception {
import org.opensearch.analytics.exec.task.TaskRunner;  
        org.mockito.Mockito.when(config.getResolvedTargets(0)).thenReturn(targetMap);
        }  
            org.opensearch.analytics.planner.dag.ShardExecutionTarget target = invocation.getArgument(2);
     */
                1,
    // ─── helpers ──────────────────────────────────────────────────────────
        @Override  
    public void testUpdateResolvedTargetReplacesStaleEntry() {
        public Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
import java.util.ArrayList;
import org.opensearch.core.action.ActionListener;
        assertTrue("no tasks dispatched", stage.runner.dispatched.isEmpty());
            "primary",
            handle.onFailure(cause);  
     * retarget returns empty → propagates to onTaskTerminal. Pins the contract that BOTH
            buildNewFakeTransportAddress(),
        stage.retryQueue.add(Optional.of(retryTask));  // first onFailed → retry  
            return lastTerminalCause.get();
        });
    @Override
        }
        assertEquals("retry attempt marked FAILED on exhaustion", StageTaskState.FAILED, retryTask.state());  
        // because currentAttempt (retryTask) != task (originalTask)  
        org.opensearch.cluster.node.DiscoveryNode replicaNode = new org.opensearch.cluster.node.DiscoveryNode(
     * the original attempt and the retry attempt end in FAILED — neither is left as RUNNING.  
        final List<StageStateListener> stateListeners = new ArrayList<>();
        handle.onResponse(null);  
        @Override  
        public int getStageId() {
        super.setUp();  
        stage.retryQueue.add(Optional.of(retryTask));  
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("no terminal yet — stage stays RUNNING during retry", 0, stage.terminalCalls.get());  
        RuntimeException first = new RuntimeException("first attempt failed");
    }
     * is left in RUNNING. This was the gap that motivated tracking the current attempt  
        scheduler.scheduleStage(stage);
        // Here currentAttempt == retryTask, task == originalTask → they're different → fix triggers.
        assertNull("success — null cause", stage.lastTerminalCause.get());
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;  
            terminalCalls.incrementAndGet();
        assertEquals("terminal propagation after retry exhausted", 1, stage.terminalCalls.get());
        assertEquals("original attempt marked FAILED when superseded by retry", StageTaskState.FAILED, originalTask.state());
        assertEquals("retry attempt marked FINISHED on success", StageTaskState.FINISHED, retryTask.state());
        // After fix: target now points to replica
        }
     * original task when onResponse fires. This is the condition that triggers updateResolvedTarget
        // Before fix: target points to primary
     * retry on replica succeeds → verify that currentAttempt (the retry) is different from the
import static org.mockito.Mockito.mock;
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
        TransportService transportService = mock(TransportService.class);
        @Override
        assertEquals("each task should have been dispatched once", 2, stage.runner.dispatched.size());
        handle.onFailure(second);
    }  
            assertEquals("initial dispatch (state=" + terminalState + ")", 1, stage.runner.dispatched.size());
        assertEquals("retry FINISHED", StageTaskState.FINISHED, retryTask.state());
        RuntimeException cause = new RuntimeException("boom");
            int stageId = invocation.getArgument(0);  
     * failure propagates to {@code onTaskTerminal} so per-attempt bookkeeping cleans up.
            java.util.Collections.emptySet(),
            return new StageMetrics();  
            ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;  
        StageTask originalTask = makeTask(0);  
        StageTask originalTask = makeTask(0);  
            "replica",
     * Retry-aware stage with exhaustion: first onFailed → retargetForRetry returns alternate →  
            buildNewFakeTransportAddress(),  
        @Override  
        }
 * Unit tests for {@link QueryScheduler#scheduleStage} and {@link QueryScheduler#handleFor}.
        assertEquals("onTaskTerminal called with no cause", 1, stage.terminalCalls.get());  
        scheduler.scheduleStage(stage);
     * Retry then success: original attempt fails, retry succeeds. Pins the contract
            targetMap.put(ordinal, target);  
        java.util.Map<Integer, org.opensearch.analytics.planner.dag.ShardExecutionTarget> targetMap = new java.util.HashMap<>();
        FakeStage stage = new FakeStage(makeTask(0));  
    public void testHandleOnFailedPropagatesWhenNoRetryAvailable() {
        assertNull("success path passes null cause to onTaskTerminal", stage.lastTerminalCause.get());
            assertEquals(
    }
        assertSame("second failure propagated as terminal cause", second, stage.lastTerminalCause.get());
    /** Default path (no retry): handle.onFailed → task FAILED + stage.onTaskTerminal(task, cause). */
                1,  
     */
    private static StageTask makeTask(int partitionId) {  
        FakeStage stage = new FakeStage();  // empty tasks
        assertEquals("replica node is the fetch target", "replica", targetMap.get(0).node().getId());
            assertSame(  
            stage.retryQueue.add(Optional.of(retryTask));
            lastTerminalCause.set(cause);  
            );  
                "no retry dispatch when stage is " + terminalState + " — short-circuit must skip retargetForRetry",  
            FakeStage stage = new FakeStage(makeTask(0));
     * so the test isolates scheduler behavior from state-machine machinery.
        for (StageExecution.State terminalState : new StageExecution.State[] {
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
     * in the fix (QueryScheduler checks currentAttempt != task after retry success).  
        }
        org.opensearch.analytics.planner.dag.ShardExecutionTarget replicaTarget =  
            );
import java.util.Optional;  
        @Override  
        }  
    /** Scheduler must skip dispatch when start() transitions the stage straight to a terminal. */
        scheduler.scheduleStage(stage);
        }  
        // Retry succeeds on replica — this is where updateResolvedTarget should fire
}
        public State getState() {  
        // Data node cancels the stream — propagates as TaskCancelledException to coordinator
     * that the superseded original ends in FAILED and the retry ends in FINISHED — neither
        handle.onFailure(new RuntimeException("first attempt failed"));
            return tasks;
    public void testRetrySuccessTransitionsCorrectTaskStates() {  
     */
        StageTask retryTask = makeTask(0);  // same slot id — retry is a new attempt at the same partition
        stage.retryQueue.add(Optional.empty());        // second onFailed → give up
     * fix for the "No ReaderContext" bug — the LM fetch uses getResolvedTargets() to decide
    public void testScheduleStageRunsEachTaskAfterTransitioningRunning() {
import static org.mockito.Mockito.when;
        public void onTaskTerminal(StageTask task, Exception cause) {
        scheduler.scheduleStage(stage);  
            assertEquals(
 * this file be licensed under the Apache-2.0 license or a
        }
        );
        scheduler = new QueryScheduler(mock(StageExecutionBuilder.class), transportService);  
        return new ShardStageTask(new StageTaskId(0, partitionId), new ExecutionTarget(null) {
    /**
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
 * graph, no Guice wiring.
        @Override  
        // Simulate recordResolvedTargets at plan time — records primary  
        assertSame(cause, stage.lastTerminalCause.get());
                "original cause propagated, not wrapped or replaced (stage=" + terminalState + ")",
    /**
    }  
    /**  
    }
        assertEquals("terminal callback fired exactly once", 1, stage.terminalCalls.get());  
import org.opensearch.analytics.exec.stage.StageStateListener;
        @Override
import java.util.concurrent.atomic.AtomicReference;
        handle.onResponse(null);  
        assertEquals("superseded original attempt stays FAILED", StageTaskState.FAILED, originalTask.state());
                cause,
        ActionListener<Void> handle = stage.runner.dispatched.get(0).handle;
            org.opensearch.Version.CURRENT  
    public void testHandleOnCompletedTransitionsTaskAndCallsOnTerminal() {
    public void testTerminalStageSkipsRetryAndPropagatesOriginalCause() {  
        }
        public void addStateListener(StageStateListener listener) {
import org.opensearch.analytics.exec.stage.StageExecution;
        assertSame(retryTask, stage.runner.dispatched.get(1).task);
        // Simulate updateResolvedTarget after retry succeeds on replica
        handle.onFailure(cause);
            );
            java.util.Collections.emptyMap(),
        }
            int ordinal = invocation.getArgument(1);
import org.opensearch.analytics.planner.dag.ExecutionTarget;
 */  
        assertNotSame("currentAttempt differs from original — updateResolvedTarget condition met", originalTask, retryTask);
        assertEquals("terminal called once", 1, stage.terminalCalls.get());  
            assertEquals("task transitioned to RUNNING before dispatch", StageTaskState.RUNNING, t.state());
        @Override
        assertSame("retry task dispatched", retryTask, stage.runner.dispatched.get(1).task);
        assertEquals("initial dispatch", 1, stage.runner.dispatched.size());
        RuntimeException second = new RuntimeException("retry attempt failed");  
            scheduler.scheduleStage(stage);
        @Override
    public void testScheduleStageSkipsDispatchWhenStageEntersTerminalDuringStart() {  
            stage.state = terminalState;  
        );  
     * {@code retargetForRetry}. Spawning new dispatch work for a stage that's done
import org.opensearch.analytics.exec.stage.StageTaskId;  
    /** Records every run() invocation with its handle so tests can drive lifecycle manually. */
                "onTaskTerminal still fires (stage=" + terminalState + ") so per-attempt bookkeeping cleans up",
     * in the handle.
        @Override  
        scheduler.scheduleStage(stage);  
    }
        targetMap.put(0, primaryTarget);  
