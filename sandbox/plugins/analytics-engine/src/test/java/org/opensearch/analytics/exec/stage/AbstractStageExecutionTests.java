        List<StageTask> materializeReturn = List.of();
        exec.materializeThrow = boom;
    }
        exec.tasks().get(3).transitionTo(StageTaskState.FINISHED);
    /**
import org.opensearch.analytics.planner.dag.Stage;
            toCapture.add(to);
        TestStageExecution(Stage stage, AnalyticsQueryTask parentTask) {
        exec.doTransitionTo(StageExecution.State.SUCCEEDED);
    /** materializeTasks() throwing must mark the stage FAILED with the thrown cause, not leak. */
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
    }
        exec.skipTask(exec.tasks().get(0));
        }
     * cleanup that the listener cascade (which may tear down query-level resources) depends on.
    // ─── test-only concrete subclass ────────────────────────────────────
        TestStageExecution exec = new TestStageExecution(mockStage(2));
        }
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        Exception first = new RuntimeException("first");
        assertEquals("second and third listeners must still fire", List.of(2, 3), callOrder);
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        exec.cancel("reason");
        assertEquals(List.of(1, 2, 3), callOrder);
    // ─── tests ─────────────────────────────────────────────────────────
        TestStageExecution exec = new TestStageExecution(mockStage(5));
 * SPDX-License-Identifier: Apache-2.0
    }
        @Override
    public void testTransitionToNoOpsOnSameState() {
     */
        exec.addStateListener((from, to) -> callOrder.add(2));
        RuntimeException boom = new RuntimeException("resolve failed");
    /**
        TestStageExecution exec = new TestStageExecution(mockStage(14));
}
import static org.mockito.ArgumentMatchers.any;
        TestStageExecution exec = new TestStageExecution(mockStage(4));
        exec.onTaskTerminal(exec.tasks().get(3), null);
    private static class TestStageExecution extends AbstractStageExecution {
        assertNull("getFailure() must be null when captureFailure was never called", exec.getFailure());
        assertEquals(1, fromCapture.size());
        exec.skipTask(exec.tasks().get(0));
        assertEquals(StageExecution.State.CREATED, fromCapture.get(0));
        exec.doTransitionTo(StageExecution.State.CANCELLED);
        exec.tasks().get(0).transitionTo(StageTaskState.FINISHED);
     * task's own CAS is the guard, and skipping every task is still a success.
        when(parentTask.isCancelled()).thenReturn(false);
/**
        exec.addStateListener((from, to) -> callOrder.add(2));
        assertEquals("one task still outstanding, so the stage is still running", StageExecution.State.RUNNING, exec.getState());
        });
public class AbstractStageExecutionTests extends OpenSearchTestCase {
        Exception second = new RuntimeException("second");
        exec.skipTask(exec.tasks().get(1));
    public void testDoubleSettleSkippedIsANoOp() {
        StageTask task = new LocalStageTask(new StageTaskId(7, 0), l -> l.onResponse(null));
        TestStageExecution exec = new TestStageExecution(mockStage(11), parentTask);
            transitionTo(target);
    public void testListenerExceptionIsSwallowedAndSubsequentListenersStillFire() {
        exec.materializeReturn = List.of();  // explicit
    public void testCaptureFailureIsIdempotent() {
        assertEquals("a partly-skipped stage still succeeds", StageExecution.State.SUCCEEDED, exec.getState());
        // Two dispatched and finished, two never sent.
/*
            protected void onTerminalTransition(State terminal) {
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        TestStageExecution exec = new TestStageExecution(mockStage(1));
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
    /** Empty task list short-circuits CREATED → SUCCEEDED — concrete stages don't need the branch. */
        exec.doTransitionTo(StageExecution.State.RUNNING);
    /** Base owns the start template: materializeTasks → publishTasksAndStart. */
 */
     */
import static org.mockito.Mockito.never;
    }
     * SUCCEEDED — without {@code skipTask} settling the skipped ones, the stage would hang in RUNNING.
        exec.doTransitionTo(StageExecution.State.RUNNING);
    /**
        exec.addStateListener((from, to) -> {
    }
        exec.tasks().get(0).transitionTo(StageTaskState.RUNNING);
     * Engine-internal cancel must propagate to the query-level {@code CancellableTask} so OpenSearch's
        when(parentTask.isCancelled()).thenReturn(true);
        exec.doCaptureFailure(second);
        assertEquals(StageExecution.State.CREATED, exec.getState());
        TestStageExecution exec = new TestStageExecution(mockStage(13));
        assertEquals(1, exec.tasks().size());
import static org.mockito.Mockito.verify;
    public void testStageWithSomeTasksSkippedAndSomeFinishedReachesSucceeded() {
    public void testMultipleListenersAllFireInRegistrationOrder() {
        assertSame(task, exec.tasks().get(0));
            return materializeReturn;
import org.opensearch.test.OpenSearchTestCase;
     * A cancel sweep marks the task CANCELLED; a skip already in flight then finds it terminal and must
 */
     * A repeat skip must be a no-op — double-settling would drive the pending counter negative. The
 *
        TestStageExecution exec = new TestStageExecution(mockStage(3));
import org.opensearch.core.action.ActionListener;
        TestStageExecution exec = new TestStageExecution(mockStage(0));
        // Transition to CREATED (the current state) — should be a no-op
     * leave it alone — the counter decrement belongs to whoever won the CAS.
        assertEquals("three of four settled — still running", StageExecution.State.RUNNING, exec.getState());
        RuntimeException materializeThrow;
                order.add("hook:" + terminal);
     */
    }
        assertEquals("setup: four tasks, stage running", StageExecution.State.RUNNING, exec.getState());
 * this file be licensed under the Apache-2.0 license or a
        exec.materializeReturn = List.of(task);
     * cancellation service tears down in-flight data-node work.
        List<String> order = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
     * A mix of finished and skipped tasks must still drive the pending counter to zero and reach
        exec.materializeReturn = List.of(task(14, 0), task(14, 1));
        assertNull("skipping is not a failure", exec.getFailure());
        exec.addStateListener((from, to) -> order.add("listener:" + to));
 * Tests for {@link AbstractStageExecution}. Uses a minimal test-only
        TestStageExecution exec = new TestStageExecution(mockStage(6));
            captureFailure(e);
    /** No double-cancel when the parent task is already cancelled (external-cancel path). */
        assertEquals(StageExecution.State.FAILED, exec.getState());
    }
        }
        public void doTransitionTo(StageExecution.State target) {
        return new LocalStageTask(new StageTaskId(stageId, partition), l -> l.onResponse(null));
    }
        TestStageExecution exec = new TestStageExecution(mockStage(12), parentTask);
        exec.skipTask(exec.tasks().get(0));  // repeat: must not decrement again
        assertSame("captured cause is the thrown exception", boom, exec.getFailure());
        protected List<StageTask> materializeTasks() {
        assertEquals(StageTaskState.CANCELLED, exec.tasks().get(0).state());
        exec.doCaptureFailure(first);
        exec.tasks().get(3).transitionTo(StageTaskState.RUNNING);
    }
            fromCapture.add(from);
        }
    private static Stage mockStage(int stageId) {
        exec.addStateListener((from, to) -> { throw new RuntimeException("boom"); });
        exec.onTaskTerminal(exec.tasks().get(0), null);
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        assertEquals(StageExecution.State.RUNNING, exec.getState());
        List<StageExecution.State> toCapture = new ArrayList<>();
    }
        assertEquals(StageTaskState.SKIPPED, exec.tasks().get(2).state());
        List<Integer> callOrder = new ArrayList<>();
        };
    public void testGetFailureNullWhenNoFailureCaptured() {
            }
        verify(parentTask, never()).cancel(any());
    public void testCancelPropagatesToParentTaskWhenProvided() {
import java.util.List;
        TestStageExecution exec = new TestStageExecution(mockStage(10)) {
        exec.cancel("test");
    }
        exec.skipTask(exec.tasks().get(1));
    public void testStartTransitionsToFailedWhenMaterializeThrows() {
        exec.addStateListener((from, to) -> callOrder.add(1));
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
    }
        TestStageExecution exec = new TestStageExecution(mockStage(9));
    }
    // ─── helpers ────────────────────────────────────────────────────────
    /**
        List<Integer> callOrder = new ArrayList<>();
        exec.materializeReturn = List.of(task(13, 0), task(13, 1), task(13, 2), task(13, 3));
    }
    public void testCancelSkipsParentTaskWhenAlreadyCancelled() {
        }
        exec.cancel("reason");
        exec.doTransitionTo(StageExecution.State.CREATED);
    public void testOnTerminalTransitionHookFiresBeforeStateListeners() {
        exec.addStateListener((from, to) -> callOrder.add(3));
        assertTrue("no tasks published", exec.tasks().isEmpty());
    public void testTransitionToFiresListenersWithFromAndTo() {
        exec.materializeReturn = List.of(task(16, 0));
        exec.skipTask(exec.tasks().get(2));
    }
package org.opensearch.analytics.exec.stage;
            if (materializeThrow != null) throw materializeThrow;
        when(stage.getStageId()).thenReturn(stageId);
import java.util.ArrayList;
        assertEquals("every task skipped is still a success", StageExecution.State.SUCCEEDED, exec.getState());
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
    public void testStartWithEmptyMaterializedTasksTransitionsStraightToSucceeded() {
    private static StageTask task(int stageId, int partition) {
import static org.mockito.Mockito.when;
 * concrete subclass that adds no behavior beyond what the base provides.
import static org.mockito.Mockito.mock;
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
    }
    /**
            super(stage, null, List.of(), parentTask);
        TestStageExecution(Stage stage) {
    }
    // ── skipTask: the terminal for a task that is never dispatched ──
        TestStageExecution exec = new TestStageExecution(mockStage(7));
        assertSame("getFailure() must return the first captured exception", first, exec.getFailure());
    public void testInitialStateIsCreated() {
        assertEquals(StageTaskState.SKIPPED, exec.tasks().get(1).state());
        Stage stage = mock(Stage.class);
            this(stage, mock(AnalyticsQueryTask.class));
        assertEquals(StageExecution.State.RUNNING, toCapture.get(0));
        assertTrue("listener should not fire on same-state transition", toCapture.isEmpty());
     */
    public void testStartPublishesMaterializedTasksAndTransitionsToRunning() {
    public void testSettleSkippedAfterCancelDoesNotResettle() {
        List<StageExecution.State> toCapture = new ArrayList<>();
 * compatible open source license.
        return stage;
     * The {@code onTerminalTransition} hook must fire before state listeners: it does stage-internal
        TestStageExecution exec = new TestStageExecution(mockStage(16));
        List<StageExecution.State> fromCapture = new ArrayList<>();
        verify(parentTask).cancel("reason");
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
            @Override
        assertEquals("state must have transitioned despite listener exception", StageExecution.State.RUNNING, exec.getState());
        exec.addStateListener((from, to) -> toCapture.add(to));
        assertEquals(List.of("hook:SUCCEEDED", "listener:SUCCEEDED"), order);
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        public void doCaptureFailure(Exception e) {
        exec.addStateListener((from, to) -> callOrder.add(3));
    }
     */
        assertEquals("cancel wins; the skip is dropped", StageTaskState.CANCELLED, exec.tasks().get(0).state());
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        TestStageExecution exec = new TestStageExecution(mockStage(8));
    }
        exec.doTransitionTo(StageExecution.State.RUNNING);
