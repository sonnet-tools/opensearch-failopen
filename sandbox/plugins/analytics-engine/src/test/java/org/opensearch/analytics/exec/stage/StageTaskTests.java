 * {@link java.util.function.Consumer} for coordinator-local execution.
        StageTask task = new ShardStageTask(new StageTaskId(0, 0), newShardTarget());  
import java.util.concurrent.atomic.AtomicBoolean;  
        // body is not invoked just by holding the task — runner's job  
        ShardStageTask task = new ShardStageTask(new StageTaskId(7, 3), target);
        LocalStageTask task = new LocalStageTask(new StageTaskId(9, 0), body);
    }  
public class StageTaskTests extends OpenSearchTestCase {
package org.opensearch.analytics.exec.stage;
     * decrement the stage counter twice. The real race is a cancel sweep against a dispatch-side skip.
        assertEquals(StageTaskState.SKIPPED, task.state());
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
            ran.set(true);
        AtomicBoolean ran = new AtomicBoolean(false);  
        assertEquals(new StageTaskId(9, 0), task.id());
        };
    /**
        assertTrue(cancelledFirst.transitionTo(StageTaskState.CANCELLED));  
        assertEquals(StageTaskState.CREATED, task.state());
    // ── SKIPPED: a terminal that means "never sent, and that was correct" ──
        assertEquals(StageTaskState.CANCELLED, cancelledFirst.state());
    }  
        assertTrue("finishedAtMs stamped like any other terminal", task.finishedAtMs() > 0);
        assertFalse("nor a repeat of the same one", skippedFirst.transitionTo(StageTaskState.SKIPPED));
 * The OpenSearch Contributors require contributions made to  
        assertFalse("no transition back out", skippedFirst.transitionTo(StageTaskState.RUNNING));  
    private static ExecutionTarget newShardTarget() {
            assertTrue("finishedAtMs stamped on terminal", task.finishedAtMs() > 0);
 * SPDX-License-Identifier: Apache-2.0
     * Only the first terminal claims the task; later attempts return false so the caller doesn't  
import org.opensearch.test.OpenSearchTestCase;
        for (StageTask task : new StageTask[] {
            assertTrue(task.transitionTo(StageTaskState.FINISHED));  
            assertFalse("terminal is sticky", task.transitionTo(StageTaskState.FAILED));  
    }
            assertTrue(task.transitionTo(StageTaskState.RUNNING));
    public void testStateMachineSharedAcrossVariants() {
            new LocalStageTask(new StageTaskId(0, 0), l -> l.onResponse(null)) }) {
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
}  
 */  
        assertFalse("nor to another terminal", skippedFirst.transitionTo(StageTaskState.CANCELLED));
    public void testShardStageTaskCarriesExecutionTarget() {  
        };
        assertFalse(ran.get());
            new ShardStageTask(new StageTaskId(0, 0), newShardTarget()),  
    /**
     * {@code SKIPPED} must be terminal and reachable straight from CREATED — a skipped task is never
            assertEquals(StageTaskState.FINISHED, task.state());
            listener.onResponse(null);  
    }  
        assertTrue(StageTaskState.SKIPPED.isTerminal());
        StageTask cancelledFirst = new ShardStageTask(new StageTaskId(0, 1), newShardTarget());
        return new ExecutionTarget(null) {  
        ExecutionTarget target = newShardTarget();
        assertEquals(StageTaskState.CREATED, task.state());
            assertTrue("startedAtMs stamped on RUNNING", task.startedAtMs() > 0);  
 */  
    public void testLocalStageTaskCarriesListenerConsumerBody() {
     * dispatched, so a non-terminal SKIPPED would leave the stage RUNNING forever.  
        java.util.function.Consumer<org.opensearch.core.action.ActionListener<Void>> body = listener -> {
     */
 * compatible open source license.
/**
    }
        assertTrue(task.transitionTo(StageTaskState.SKIPPED));  
 * this file be licensed under the Apache-2.0 license or a
    public void testOnlyTheFirstTerminalClaimsTheTask() {  
        assertEquals(new StageTaskId(7, 3), task.id());
        assertEquals(StageTaskState.SKIPPED, skippedFirst.state());  
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
        assertFalse("cancel already settled it — the skip must not settle it again", cancelledFirst.transitionTo(StageTaskState.SKIPPED));
        StageTask skippedFirst = new ShardStageTask(new StageTaskId(0, 0), newShardTarget());
/*  
 * {@link ShardStageTask} carries an {@link ExecutionTarget}; {@link LocalStageTask} carries a body
        assertTrue(skippedFirst.transitionTo(StageTaskState.SKIPPED));
 * Tests the sealed {@link StageTask} hierarchy: a shared state machine plus per-variant payload.  
    }  
        assertSame(target, task.target());  
 *
     */
        assertSame(body, task.body());  
    public void testSkippedIsTerminalFromCreated() {
        }
            assertEquals(0L, task.finishedAtMs());
