        assertSame("captured cause is the thrown exception", boom, exec.getFailure());
    }  
import static org.mockito.Mockito.never;  
import static org.mockito.Mockito.mock;
            return materializeReturn;  
        assertEquals(1, exec.tasks().size());
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
        List<Integer> callOrder = new ArrayList<>();
            transitionTo(target);
            captureFailure(e);  
        assertEquals(StageTaskState.SKIPPED, exec.tasks().get(2).state());  
    /** materializeTasks() throwing must mark the stage FAILED with the thrown cause, not leak. */
        assertEquals(StageExecution.State.CREATED, exec.getState());
        verify(parentTask).cancel("reason");
    public void testCaptureFailureIsIdempotent() {  
     */
        });  
        exec.materializeReturn = List.of(task(14, 0), task(14, 1));  
        exec.doTransitionTo(StageExecution.State.CANCELLED);
        assertEquals("setup: four tasks, stage running", StageExecution.State.RUNNING, exec.getState());
     * A cancel sweep marks the task CANCELLED; a skip already in flight then finds it terminal and must  
        assertEquals("a partly-skipped stage still succeeds", StageExecution.State.SUCCEEDED, exec.getState());  
        exec.addStateListener((from, to) -> { throw new RuntimeException("boom"); });
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        }
    }
        List<StageTask> materializeReturn = List.of();
        List<StageExecution.State> toCapture = new ArrayList<>();
        List<String> order = new ArrayList<>();  
        exec.skipTask(exec.tasks().get(0));  
 * The OpenSearch Contributors require contributions made to  
    /**
        @Override  
import org.opensearch.test.OpenSearchTestCase;
    /**
        assertNull("getFailure() must be null when captureFailure was never called", exec.getFailure());
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        exec.skipTask(exec.tasks().get(1));
 * concrete subclass that adds no behavior beyond what the base provides.  
    // ─── test-only concrete subclass ────────────────────────────────────
        }
    /**  
        exec.materializeThrow = boom;
        RuntimeException boom = new RuntimeException("resolve failed");
     * SUCCEEDED — without {@code skipTask} settling the skipped ones, the stage would hang in RUNNING.
        TestStageExecution exec = new TestStageExecution(mockStage(13));
        exec.start(ActionListener.wrap(v -> {}, e -> {}));  
        TestStageExecution exec = new TestStageExecution(mockStage(10)) {
import static org.mockito.Mockito.verify;
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        exec.onTaskTerminal(exec.tasks().get(0), null);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(StageTaskState.SKIPPED, exec.tasks().get(1).state());
    }
        exec.materializeReturn = List.of(task);
        when(parentTask.isCancelled()).thenReturn(true);
    public void testSettleSkippedAfterCancelDoesNotResettle() {  
import static org.mockito.ArgumentMatchers.any;
        public void doTransitionTo(StageExecution.State target) {
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());  
        exec.addStateListener((from, to) -> order.add("listener:" + to));
        assertEquals("one task still outstanding, so the stage is still running", StageExecution.State.RUNNING, exec.getState());
        exec.doTransitionTo(StageExecution.State.RUNNING);
 */
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        protected List<StageTask> materializeTasks() {
        TestStageExecution exec = new TestStageExecution(mockStage(1));
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);  
import java.util.List;
        exec.skipTask(exec.tasks().get(0));
import org.opensearch.analytics.planner.dag.Stage;  
     * cancellation service tears down in-flight data-node work.
        return new LocalStageTask(new StageTaskId(stageId, partition), l -> l.onResponse(null));  
        }
        TestStageExecution exec = new TestStageExecution(mockStage(0));  
        assertEquals(StageExecution.State.FAILED, exec.getState());  
    }
        return stage;  
    private static StageTask task(int stageId, int partition) {
        exec.cancel("reason");
    // ── skipTask: the terminal for a task that is never dispatched ──  
        exec.tasks().get(3).transitionTo(StageTaskState.FINISHED);  
 * this file be licensed under the Apache-2.0 license or a
        when(stage.getStageId()).thenReturn(stageId);
        assertEquals("every task skipped is still a success", StageExecution.State.SUCCEEDED, exec.getState());
        assertEquals(StageExecution.State.CREATED, fromCapture.get(0));
        exec.addStateListener((from, to) -> callOrder.add(2));  
    }  
    }
    }
        assertNull("skipping is not a failure", exec.getFailure());
            }
    public void testInitialStateIsCreated() {
        exec.start(ActionListener.wrap(v -> {}, e -> {}));  
        assertEquals("cancel wins; the skip is dropped", StageTaskState.CANCELLED, exec.tasks().get(0).state());
 */  
        // Transition to CREATED (the current state) — should be a no-op  
        TestStageExecution exec = new TestStageExecution(mockStage(12), parentTask);  
        Exception first = new RuntimeException("first");  
    }
        exec.skipTask(exec.tasks().get(2));
        exec.addStateListener((from, to) -> callOrder.add(2));
        assertEquals("state must have transitioned despite listener exception", StageExecution.State.RUNNING, exec.getState());  
    private static Stage mockStage(int stageId) {  
        TestStageExecution exec = new TestStageExecution(mockStage(2));
 * Tests for {@link AbstractStageExecution}. Uses a minimal test-only
        assertEquals(StageExecution.State.RUNNING, toCapture.get(0));  
     * Engine-internal cancel must propagate to the query-level {@code CancellableTask} so OpenSearch's  
        // Two dispatched and finished, two never sent.  
        TestStageExecution exec = new TestStageExecution(mockStage(4));
        exec.addStateListener((from, to) -> callOrder.add(3));
        exec.doTransitionTo(StageExecution.State.SUCCEEDED);  
        exec.addStateListener((from, to) -> callOrder.add(3));  
        Exception second = new RuntimeException("second");
    public void testStartPublishesMaterializedTasksAndTransitionsToRunning() {
    }
    public void testStartTransitionsToFailedWhenMaterializeThrows() {
/*  
        assertEquals(1, fromCapture.size());
    }
     * A mix of finished and skipped tasks must still drive the pending counter to zero and reach  
            @Override
package org.opensearch.analytics.exec.stage;
     */
    public void testDoubleSettleSkippedIsANoOp() {
        TestStageExecution exec = new TestStageExecution(mockStage(8));
    public void testCancelPropagatesToParentTaskWhenProvided() {  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        assertEquals("three of four settled — still running", StageExecution.State.RUNNING, exec.getState());  
        assertSame("getFailure() must return the first captured exception", first, exec.getFailure());
import static org.mockito.Mockito.when;
                order.add("hook:" + terminal);
    public void testStartWithEmptyMaterializedTasksTransitionsStraightToSucceeded() {  
        exec.doTransitionTo(StageExecution.State.RUNNING);
        assertSame(task, exec.tasks().get(0));
        TestStageExecution exec = new TestStageExecution(mockStage(11), parentTask);
            super(stage, null, List.of(), parentTask);
    }
    }  
    public void testListenerExceptionIsSwallowedAndSubsequentListenersStillFire() {
        TestStageExecution exec = new TestStageExecution(mockStage(7));  
        exec.tasks().get(0).transitionTo(StageTaskState.RUNNING);
    private static class TestStageExecution extends AbstractStageExecution {  
    public void testMultipleListenersAllFireInRegistrationOrder() {  
        assertEquals("second and third listeners must still fire", List.of(2, 3), callOrder);
public class AbstractStageExecutionTests extends OpenSearchTestCase {
        assertTrue("listener should not fire on same-state transition", toCapture.isEmpty());  
        }  
        exec.doCaptureFailure(second);  
        Stage stage = mock(Stage.class);
        exec.onTaskTerminal(exec.tasks().get(3), null);
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
            fromCapture.add(from);
    // ─── tests ─────────────────────────────────────────────────────────  
 * compatible open source license.
        exec.doTransitionTo(StageExecution.State.CREATED);
     * The {@code onTerminalTransition} hook must fire before state listeners: it does stage-internal
        exec.addStateListener((from, to) -> {  
        }
    public void testTransitionToFiresListenersWithFromAndTo() {
        public void doCaptureFailure(Exception e) {
     * leave it alone — the counter decrement belongs to whoever won the CAS.
        exec.doCaptureFailure(first);
        exec.tasks().get(0).transitionTo(StageTaskState.FINISHED);
    /** No double-cancel when the parent task is already cancelled (external-cancel path). */
            toCapture.add(to);
    }  
        assertEquals(List.of(1, 2, 3), callOrder);
/**
        exec.materializeReturn = List.of();  // explicit
     */  
    // ─── helpers ────────────────────────────────────────────────────────
    /** Base owns the start template: materializeTasks → publishTasksAndStart. */
 *
        TestStageExecution(Stage stage) {
            this(stage, mock(AnalyticsQueryTask.class));  
        List<StageExecution.State> toCapture = new ArrayList<>();  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        TestStageExecution exec = new TestStageExecution(mockStage(3));
        exec.cancel("test");
    public void testStageWithSomeTasksSkippedAndSomeFinishedReachesSucceeded() {  
            protected void onTerminalTransition(State terminal) {  
        assertTrue("no tasks published", exec.tasks().isEmpty());
     */
        exec.skipTask(exec.tasks().get(1));
    public void testGetFailureNullWhenNoFailureCaptured() {
     * A repeat skip must be a no-op — double-settling would drive the pending counter negative. The
        List<Integer> callOrder = new ArrayList<>();  
        exec.skipTask(exec.tasks().get(0));  // repeat: must not decrement again
        RuntimeException materializeThrow;  
        exec.tasks().get(3).transitionTo(StageTaskState.RUNNING);
        assertEquals(StageExecution.State.RUNNING, exec.getState());  
        TestStageExecution exec = new TestStageExecution(mockStage(16));
    /**
    }  
    /**
        exec.materializeReturn = List.of(task(16, 0));
    public void testCancelSkipsParentTaskWhenAlreadyCancelled() {
    }
        assertEquals(List.of("hook:SUCCEEDED", "listener:SUCCEEDED"), order);
     */
    public void testTransitionToNoOpsOnSameState() {  
        TestStageExecution exec = new TestStageExecution(mockStage(6));  
    public void testOnTerminalTransitionHookFiresBeforeStateListeners() {
        TestStageExecution exec = new TestStageExecution(mockStage(5));
        };  
        TestStageExecution exec = new TestStageExecution(mockStage(9));  
        exec.cancel("reason");
        StageTask task = new LocalStageTask(new StageTaskId(7, 0), l -> l.onResponse(null));
        assertEquals(StageTaskState.CANCELLED, exec.tasks().get(0).state());  
}
     * cleanup that the listener cascade (which may tear down query-level resources) depends on.  
import org.opensearch.core.action.ActionListener;
        when(parentTask.isCancelled()).thenReturn(false);
    /** Empty task list short-circuits CREATED → SUCCEEDED — concrete stages don't need the branch. */
    }
        verify(parentTask, never()).cancel(any());  
        TestStageExecution exec = new TestStageExecution(mockStage(14));
        TestStageExecution(Stage stage, AnalyticsQueryTask parentTask) {  
     * task's own CAS is the guard, and skipping every task is still a success.
    }
    }
        exec.addStateListener((from, to) -> callOrder.add(1));
        exec.addStateListener((from, to) -> toCapture.add(to));
    }
            if (materializeThrow != null) throw materializeThrow;
import java.util.ArrayList;
        exec.doTransitionTo(StageExecution.State.RUNNING);  
        exec.materializeReturn = List.of(task(13, 0), task(13, 1), task(13, 2), task(13, 3));
        List<StageExecution.State> fromCapture = new ArrayList<>();
