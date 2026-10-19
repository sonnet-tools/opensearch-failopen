    /**  
        FakeChild childB = new FakeChild(8, "stats-from-B");
        @Override  
 */  
        private final List<StageStateListener> listeners = new ArrayList<>();
        failing.fire(StageExecution.State.FAILED);  
        childA.fireSucceeded();
        assertEquals(StageExecution.State.CANCELLED, parent.fakeState);
     * Parent stub for tests that exercise the parent-state listener installed by
        public void cancel(String reason) {
        assertSame(child.failure, parent.capturedFailure);
            return false;
            return new StageMetrics();  
import java.util.ArrayList;
        parent.attachChildren(List.of(failing), scheduler);  
        // Capture metadata at the moment the cascade hands it off — i.e., before scheduling.  
    public void testAllChildrenCancelledDrivesParentTerminal() {  
        childB.fakeState = StageExecution.State.CREATED;
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
        public void cancel(String reason) {  
        parent.attachChildren(List.of(child), scheduler);
import static org.mockito.Mockito.never;  
    }
            fire(State.SUCCEEDED);
import static org.mockito.ArgumentMatchers.any;
        }  
     * Cancelled-child contract: the cascade closes the parent's per-child input (so a parent reduce
            State previous = fakeState;  
        public boolean failWithCause(Exception cause) {
    }  
     * Closing an eager parent's input can wake its drain and make it report success inline.  
        FakeChild b = new FakeChild(2);
        String cancelReason;
     * to RUNNING — they need to run concurrently with their children's feeds (e.g. a
            parent.fakeState.isTerminal()
        FakeChild child = new FakeChild(1);
        FakeChild cancelled = new FakeChild(1);
            this(stageId, false);
        }  
        AtomicReference<Map<Integer, Object>> consumed = new AtomicReference<>();
import static org.mockito.ArgumentMatchers.eq;  
public class AttachChildrenTests extends OpenSearchTestCase {  
            return stageId;
        child.fire(StageExecution.State.SUCCEEDED);
        StageExecution eagerParent = mock(StageExecution.class, CALLS_REAL_METHODS);
        public void addStateListener(StageStateListener listener) {  
            onStarted.onResponse(null);
    // ---- Phantom-task probes: does a CANCELLED child strand the parent (never terminal)? ----
        FakeChild childB = new FakeChild(2);
            fakeState = target;  
        @Override  
 * Tests for {@link StageExecution#attachChildren} — the cascade's three behaviours:
        }  
        Consumer<StageExecution> scheduler = stage -> fail("must NOT schedule on child cancellation");
 */
            State previous = fakeState;
            return new StageMetrics();  
        private final boolean succeedOnClose;  
        assertNull("parent must NOT be scheduled when a child was cancelled", scheduled.get());
        parent.attachChildren(List.of(childA, childB), scheduler);
    private static final class FakeChild implements StageExecution {
        assertTrue(  
            this(stageId, null);
        boolean childInputClosed;
        }
     */  
        parent.attachChildren(List.of(failing, stillRunning, alreadyDone), scheduler);
        FakeChild childA = new FakeChild(7, "broadcast-bytes-A");
        child.failure = new RuntimeException("injected shard failure");  
        FakeChild cancelled = new FakeChild(5);  // no failure recorded
        FakeChild alreadyDone = new FakeChild(3);
            return fakeState;
        assertNotNull("still-running sibling must have been cancelled", stillRunning.cancelReason);  
        @Override
import java.util.Map;
        a.fireSucceeded();  
        }  
        org.mockito.Mockito.when(eagerParent.schedulesEagerly()).thenReturn(true);  
        org.mockito.Mockito.when(parent.schedulesEagerly()).thenReturn(true);
        scheduled.set(null);
    public void testFailedChildPropagatesDirectlyToParent() {
        FakeChild child = new FakeChild(1);
        verify(eagerParent).closeChildInput(eq(33));  
    public void testCancelledChildClaimsTerminalBeforeClosingInput() {  
     * Default (non-streaming) parents keep today's contract: scheduled only when all
        @Override
     * silently drop the signal for a future buffered multi-input backend.
     * {@link #fakeState} is queried by the cascade's parent-listener via {@link #getState()}.  
 *
        }
        FakeChild succeeded = new FakeChild(2);
        Consumer<StageExecution> scheduler = stage -> {
                l.onStateChange(previous, target);
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
            return null;  
        StageExecution defaultParent = mock(StageExecution.class, CALLS_REAL_METHODS);
     * (terminal) rather than being scheduled — there is nothing left to run.  
        FakeChild child = new FakeChild(1);
        Consumer<StageExecution> scheduler = scheduled::set;
        public void onTaskTerminal(StageTask task, Exception cause) {}  
        public Object publishedMetadata() {
     * and must NOT be failed (cancel is not a failure).
        }
    }  
        parent.attachChildren(List.of(cancelled), scheduler);  
        FakeChild c = new FakeChild(33);
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();  
        FakeParent parent = new FakeParent(99);
     * never unregistered (the phantom-task leak). The parent must NOT be scheduled (nothing to run)  
        child.fire(StageExecution.State.CANCELLED);
    /**
        assertEquals("parent with a cancelled child must terminate as CANCELLED", StageExecution.State.CANCELLED, parent.fakeState);
        FakeParent parent = new FakeParent(99);  
        assertSame("parent scheduled after all-children-SUCCEEDED", parent, scheduled.get());
        verify(defaultParent).closeChildInput(eq(11));
            listeners.add(listener);
        Exception capturedFailure;  
            return stageId;
    /**  
        c.fakeState = StageExecution.State.CREATED;
    public void testHandsOffPublishedMetadataBeforeScheduling() {
        FakeChild childB = new FakeChild(2);
        public State getState() {  
     * Waiting for all-children-SUCCEEDED would deadlock on a bounded input mpsc.  
        assertNull("not scheduled until last child succeeds", scheduled.get());  
        @Override
        );  
        parent.attachChildren(List.of(cancelled, succeeded), scheduled::set);
    public void testSchedulesParentOnceAllChildrenSucceed() {
     * Minimal child stub: append listeners + fire transitions; carries optional metadata + failure;
        // Cancel IS propagated so the parent reaches terminal (phantom-task fix); not failed, not metadata-consumed.
        assertSame("eager parent scheduled on first child RUNNING", parent, scheduled.get());
        assertNull("already-terminal sibling must not be re-cancelled", alreadyDone.cancelReason);
        FakeParent parent = new FakeParent(99);
            this.stageId = stageId;  
        }  
        @Override  
        verify(parent).failWithCause(failing.failure);  
        parent.attachChildren(List.of(childA, childB), scheduler);
    public void testEagerParentSchedulesOnFirstChildRunning() {
        verify(parent, never()).consumeChildMetadata(any());
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();  
     * drain blocked on {@code streamNext} sees EOF and unwinds) AND propagates cancel to the parent  
        }
        FakeParent(int stageId, boolean succeedOnClose) {
     * Backends without per-child resources inherit the default {@code closeChildInput}  
        @Override
        child.fire(StageExecution.State.RUNNING);
    }
        public void addStateListener(StageStateListener listener) {  
            this.succeedOnClose = succeedOnClose;  
 * SPDX-License-Identifier: Apache-2.0
            if (fakeState.isTerminal()) return false;
import java.util.List;  
        verify(defaultParent).closeChildInput(eq(22));  
        }
        FakeChild a = new FakeChild(11);  
        }
        child.fakeState = StageExecution.State.CREATED;
     * pending count never drains, the root never mirrors to the query, and the coordinator task is
        public void closeChildInput(int childStageId) {
    }  
            assertEquals("broadcast-bytes-A", consumed.get().get(7));
        FakeChild childA = new FakeChild(1);
            if (succeedOnClose) {  
import java.util.function.Consumer;  
        // EOF released to the reduce input (the leak fix).  
                transitionTo(State.SUCCEEDED);
        FakeChild failing = new FakeChild(1);
        childB.fireSucceeded();  
        );  
 * scheduler dispatch on all-SUCCEEDED, direct propagation on FAILED / CANCELLED,
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
        childC.fireSucceeded();
        assertTrue(  
    /** Same race for cancellation: CANCELLED must win before EOF can report success. */
 * to the parent's {@code consumeChildMetadata} before scheduling.
            listeners.add(listener);
        @Override
    /**
        childB.fireSucceeded();
        }
        private boolean transitionTo(State target) {  
            childInputClosed = true;
    public void testDefaultParentDoesNotScheduleOnChildRunning() {
        assertSame("default-mode parent scheduled on all-SUCCEEDED", parent, scheduled.get());  
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
    /** PROBE 2: ALL children CANCELLED (full bottom-up cancel of leaves). Parent terminal? */
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);  
        }
        parent.attachChildren(List.of(cancelled, stillRunning), stage -> {});  
            cancelReason = reason;
        failing.failure = new RuntimeException("kaboom");  
        b.fireSucceeded();
        Consumer<StageExecution> scheduler = stage -> fail("must NOT schedule on child failure");
        @Override
        assertNotNull("scheduler should have run", consumed.get());
        succeeded.fire(StageExecution.State.SUCCEEDED);
        FakeChild(int stageId) {
     * streaming reduce whose drain pulls native output while children push batches).
        private final Object metadata;
            return failure;  
     * Eager (streaming) parents must be scheduled as soon as the first child transitions  
    public void testSiblingsAreCancelledWhenParentReachesFailedTerminal() {
        private final int stageId;
     * any siblings still running must be cancelled so they don't keep producing into a
        org.mockito.Mockito.doAnswer(inv -> {
import org.opensearch.core.action.ActionListener;
    }  
            onStarted.onResponse(null);
        }  
        a.fire(StageExecution.State.CANCELLED);  
        failing.failure = new RuntimeException("kaboom");
 * The OpenSearch Contributors require contributions made to  
            fakeState = terminal;
 * and the metadata channel that ferries each child's {@code publishedMetadata}  
        verify(parent, never()).consumeChildMetadata(any());
        public int getStageId() {
            consumed.set(new HashMap<>(inv.getArgument(0)));
        cancelled.fire(StageExecution.State.CANCELLED);
    /**
        verify(parent).closeChildInput(eq(5));
    // query task never unregisters → phantom task (observed as a query/ppl task stuck for hours  
        verify(parent, never()).failWithCause(any());
        FakeChild stillRunning = new FakeChild(2);
        @Override
    public void testCancelledPlusSucceededChildDrivesParentTerminalNotScheduled() {
import static org.mockito.Mockito.mock;
        assertEquals(StageExecution.State.FAILED, parent.fakeState);  
    }  
            // Verify the metadata handoff happened BEFORE this scheduler runs.
        State fakeState = State.RUNNING;  
        @Override  
        public Exception getFailure() {
        void fireSucceeded() {
        eagerParent.attachChildren(List.of(c), stage -> {});  
    // with zero CPU). These tests pin which child-state combinations strand the parent.
        c.fire(StageExecution.State.RUNNING);
        }
        @Override
        Exception failure;
        public int getStageId() {
        failing.fire(StageExecution.State.FAILED);
        public boolean failWithCause(Exception cause) {
            transitionTo(State.CANCELLED);  
        parent.attachChildren(List.of(child), stage -> {});  
        b.fire(StageExecution.State.CANCELLED);
        );
     * {@link #cancel(String)} actually transition {@link #fakeState} and fire listeners,
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);  
        Consumer<StageExecution> scheduler = scheduled::set;
    }
import static org.mockito.Mockito.verify;
     * {@link StageExecution#attachChildren}: {@link #failWithCause(Exception)} and  
            if (fakeState.isTerminal()) return false;
        }
     */
            assertNotNull("metadata should be handed off before scheduling", consumed.get());  
    public void testCancelledChildWithRunningSiblingDoesNotStrandParent() {
                l.onStateChange(previous, terminal);  
        }).when(parent).consumeChildMetadata(any());
            return fakeState;
        parent.attachChildren(List.of(childA, childB, childC), scheduler);
        FakeChild stillRunning = new FakeChild(2); // stays RUNNING, never fires terminal  
            "parent must reach a terminal state when all children are cancelled. parent state=" + parent.fakeState,
        parent.attachChildren(List.of(a, b), stage -> {});
     */
        };
            capturedFailure = cause;  
    }  
        public State getState() {  
        public void start(ActionListener<Void> onStarted) {
}
            parent.fakeState.isTerminal()
        FakeParent parent = new FakeParent(99, true);
        public StageMetrics getMetrics() {
     * so it reaches a terminal state. Without the propagation the parent strands in RUNNING, its
        childB.fire(StageExecution.State.RUNNING);  
    /**
    public void testCancelledChildClosesInputAndPropagatesCancelToParent() {  
        }
    /** PROBE 1: one child CANCELLED, sibling still RUNNING. Does the parent ever reach terminal? */  
        childA.fakeState = StageExecution.State.CREATED;  
        FakeChild childC = new FakeChild(9, null);  // publishes nothing  
        // default schedulesEagerly() == false  
    public void testFailedChildClaimsTerminalBeforeClosingInput() {
        private final int stageId;  
        assertNull("default-mode parent must NOT schedule on child RUNNING", scheduled.get());
    }  
        public Exception getFailure() {
        @Override
            for (StageStateListener l : listeners)
        Consumer<StageExecution> scheduler = stage -> {};  
        }  
        FakeParent parent = new FakeParent(99);
 * compatible open source license.
     * which is what triggers the sibling-cancel sweep.
        public StageMetrics getMetrics() {
        Consumer<StageExecution> scheduler = scheduled::set;
        public void start(ActionListener<Void> onStarted) {
        FakeChild b = new FakeChild(22);
            this.metadata = metadata;
     * slot so the count drains to 0; with a cancelled child present the parent reaches CANCELLED
        State fakeState = State.RUNNING;
     * Per-input EOF hook fires on every child SUCCEEDED, regardless of scheduling mode.
        childA.fire(StageExecution.State.RUNNING);
    /**  
        FakeParent parent = new FakeParent(99, true);
     * records the {@code cancel(reason)} that the sibling-sweep test asserts against. Mutable
    private static final class FakeParent implements StageExecution {
import org.opensearch.test.OpenSearchTestCase;
     */  
            assertEquals("stats-from-B", consumed.get().get(8));
            "parent must reach a terminal state (not strand) once all children are accounted for; " + "parent state=" + parent.fakeState,
            parent.fakeState.isTerminal()
     */
        assertTrue("cancelled child input must still be closed", parent.childInputClosed);
            "parent must reach a terminal state after a child is cancelled; otherwise the coordinator "
        defaultParent.attachChildren(List.of(a, b), stage -> {});
        parent.attachChildren(List.of(child), stage -> {});
import java.util.HashMap;
        }
        }
        }  
        }
        assertNull("subsequent child RUNNING must not re-schedule", scheduled.get());
     */  
        childA.fireSucceeded();
import static org.mockito.Mockito.CALLS_REAL_METHODS;
        @Override
/*  
        private final List<StageStateListener> listeners = new ArrayList<>();
        @Override  
        child.fire(StageExecution.State.FAILED);
        FakeChild(int stageId, Object metadata) {
    /**
        FakeChild childA = new FakeChild(1);
    /**
     * PROBE 3: one CANCELLED + one SUCCEEDED. The cancelled child must still account for its pending
     * children SUCCEEDED. A child reaching RUNNING must not trigger the parent.
        @Override
                + "query task never unregisters (phantom). parent state="
        cancelled.fire(StageExecution.State.CANCELLED);  
            scheduled.set(stage);
            this.stageId = stageId;
        @Override
        assertNull("not scheduled until any child enters RUNNING", scheduled.get());  
        cancelled.fire(StageExecution.State.CANCELLED);
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
    public void testCloseChildInputFiresOnEveryChildSucceededRegardlessOfMode() {
        public void onTaskTerminal(StageTask task, Exception cause) {}
            return transitionTo(State.FAILED);
        FakeChild a = new FakeChild(1);
    }
        @Override  
        FakeParent(int stageId) {  
            return metadata;  
        verify(parent).cancel(any());  
    }
        c.fire(StageExecution.State.SUCCEEDED);
    // A parent that never reaches terminal never fires mirrorRootStateToQuery → the coordinator
        alreadyDone.fakeState = StageExecution.State.SUCCEEDED;  
        void fire(State terminal) {
     * terminal state wins and the query incorrectly returns partial/empty results.
                + parent.fakeState,  
     * A child failure must claim FAILED before that EOF is published, or the successful
/**  
            return true;  
            }
        assertTrue(  
        }
     * Sibling-cancel sweep: when one child fails and the parent transitions to FAILED,  
        @Override  
    }
     */  
            return capturedFailure;  
    }
        FakeChild failing = new FakeChild(1);
        FakeChild cancelled = new FakeChild(1);  
     * sink whose owner has terminated.
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("failed child input must still be closed", parent.childInputClosed);
package org.opensearch.analytics.exec.stage;
        // Subsequent RUNNING transitions on other children must not re-schedule.
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);  
    }
            assertFalse("null-publishing child must not appear in map", consumed.get().containsKey(9));  
        @Override
        }
        assertEquals("parent must reach FAILED from child failure", StageExecution.State.FAILED, parent.fakeState);
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);  
            for (StageStateListener l : listeners)
        }
import java.util.concurrent.atomic.AtomicReference;
     * no-op; this test guards against re-introducing an eager-mode gate that would
     */  
     */
