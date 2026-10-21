    }
        alreadyDone.fakeState = StageExecution.State.SUCCEEDED;
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
        @Override
 * Tests for {@link StageExecution#attachChildren} — the cascade's three behaviours:
        assertEquals("parent must reach FAILED from child failure", StageExecution.State.FAILED, parent.fakeState);
     * records the {@code cancel(reason)} that the sibling-sweep test asserts against. Mutable
        @Override
     */
        failing.fire(StageExecution.State.FAILED);
        }
            parent.fakeState.isTerminal()
    public void testCancelledChildClosesInputAndPropagatesCancelToParent() {
        parent.attachChildren(List.of(cancelled, succeeded), scheduled::set);
            fire(State.SUCCEEDED);
        verify(defaultParent).closeChildInput(eq(22));
/**
    public void testHandsOffPublishedMetadataBeforeScheduling() {
        verify(defaultParent).closeChildInput(eq(11));
        public int getStageId() {
        assertNotNull("still-running sibling must have been cancelled", stillRunning.cancelReason);
     * no-op; this test guards against re-introducing an eager-mode gate that would
        FakeChild cancelled = new FakeChild(1);
        State fakeState = State.RUNNING;
    public void testSchedulesParentOnceAllChildrenSucceed() {
        public StageMetrics getMetrics() {
    public void testDefaultParentDoesNotScheduleOnChildRunning() {
        verify(parent, never()).consumeChildMetadata(any());
        private final int stageId;
     * Cancelled-child contract: the cascade closes the parent's per-child input (so a parent reduce
        boolean childInputClosed;
            transitionTo(State.CANCELLED);
        FakeParent parent = new FakeParent(99);
     * slot so the count drains to 0; with a cancelled child present the parent reaches CANCELLED
    }
                transitionTo(State.SUCCEEDED);
        @Override
        private final int stageId;
     */
        assertNull("not scheduled until any child enters RUNNING", scheduled.get());
        parent.attachChildren(List.of(failing, stillRunning, alreadyDone), scheduler);
        assertTrue("cancelled child input must still be closed", parent.childInputClosed);
        public StageMetrics getMetrics() {
        org.mockito.Mockito.when(parent.schedulesEagerly()).thenReturn(true);
        assertNull("already-terminal sibling must not be re-cancelled", alreadyDone.cancelReason);
        @Override
        c.fakeState = StageExecution.State.CREATED;
        FakeChild cancelled = new FakeChild(1);
        public void cancel(String reason) {
    // ---- Phantom-task probes: does a CANCELLED child strand the parent (never terminal)? ----
        verify(eagerParent).closeChildInput(eq(33));
        );
        FakeChild childB = new FakeChild(8, "stats-from-B");
        cancelled.fire(StageExecution.State.CANCELLED);
    /**
        c.fire(StageExecution.State.SUCCEEDED);
        FakeChild childA = new FakeChild(7, "broadcast-bytes-A");
            consumed.set(new HashMap<>(inv.getArgument(0)));
     */
        verify(parent, never()).consumeChildMetadata(any());
        public void addStateListener(StageStateListener listener) {
        cancelled.fire(StageExecution.State.CANCELLED);
        void fireSucceeded() {
        @Override
    /** PROBE 2: ALL children CANCELLED (full bottom-up cancel of leaves). Parent terminal? */
import java.util.ArrayList;
            "parent must reach a terminal state after a child is cancelled; otherwise the coordinator "
        public void cancel(String reason) {
        failing.fire(StageExecution.State.FAILED);
            "parent must reach a terminal state (not strand) once all children are accounted for; " + "parent state=" + parent.fakeState,
            assertFalse("null-publishing child must not appear in map", consumed.get().containsKey(9));
     * streaming reduce whose drain pulls native output while children push batches).
        @Override
        };
        FakeChild child = new FakeChild(1);
        cancelled.fire(StageExecution.State.CANCELLED);
        assertSame("eager parent scheduled on first child RUNNING", parent, scheduled.get());
    /**
import org.opensearch.core.action.ActionListener;
        }
            onStarted.onResponse(null);
     * Default (non-streaming) parents keep today's contract: scheduled only when all
        }
    }
        parent.attachChildren(List.of(cancelled, stillRunning), stage -> {});
            parent.fakeState.isTerminal()
        @Override
        FakeParent(int stageId) {
        public int getStageId() {
            listeners.add(listener);
        FakeChild childC = new FakeChild(9, null);  // publishes nothing
            this.stageId = stageId;
    }
        parent.attachChildren(List.of(childA, childB, childC), scheduler);
    // with zero CPU). These tests pin which child-state combinations strand the parent.
     * Eager (streaming) parents must be scheduled as soon as the first child transitions
    }
            "parent must reach a terminal state when all children are cancelled. parent state=" + parent.fakeState,
 */
            capturedFailure = cause;
        FakeParent parent = new FakeParent(99);
        AtomicReference<Map<Integer, Object>> consumed = new AtomicReference<>();
        public Object publishedMetadata() {
        assertNull("not scheduled until last child succeeds", scheduled.get());
            return stageId;
        @Override
        verify(parent).closeChildInput(eq(5));
        FakeChild c = new FakeChild(33);
    /**
            assertEquals("broadcast-bytes-A", consumed.get().get(7));
        FakeChild child = new FakeChild(1);
    // A parent that never reaches terminal never fires mirrorRootStateToQuery → the coordinator
        Consumer<StageExecution> scheduler = scheduled::set;
        FakeParent(int stageId, boolean succeedOnClose) {
        @Override
        Consumer<StageExecution> scheduler = stage -> {};
            }
        child.fire(StageExecution.State.RUNNING);
        }
    }
        public void onTaskTerminal(StageTask task, Exception cause) {}
    /** PROBE 1: one child CANCELLED, sibling still RUNNING. Does the parent ever reach terminal? */
        }
        c.fire(StageExecution.State.RUNNING);
     */
                l.onStateChange(previous, terminal);
        defaultParent.attachChildren(List.of(a, b), stage -> {});
        b.fireSucceeded();
            cancelReason = reason;
        childA.fireSucceeded();
        childB.fakeState = StageExecution.State.CREATED;
    public void testFailedChildClaimsTerminalBeforeClosingInput() {
            return capturedFailure;
        assertNull("parent must NOT be scheduled when a child was cancelled", scheduled.get());
     * and must NOT be failed (cancel is not a failure).
        FakeParent parent = new FakeParent(99);
    public void testEagerParentSchedulesOnFirstChildRunning() {
        failing.failure = new RuntimeException("kaboom");
            return true;
    public void testCancelledChildClaimsTerminalBeforeClosingInput() {
        FakeChild b = new FakeChild(22);
     * Backends without per-child resources inherit the default {@code closeChildInput}
        assertNull("subsequent child RUNNING must not re-schedule", scheduled.get());
import static org.mockito.Mockito.never;
     * any siblings still running must be cancelled so they don't keep producing into a
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
 */
        FakeChild cancelled = new FakeChild(5);  // no failure recorded
     */
    /** Same race for cancellation: CANCELLED must win before EOF can report success. */
        }
        parent.attachChildren(List.of(child), scheduler);
    /**
 * The OpenSearch Contributors require contributions made to
        childA.fire(StageExecution.State.RUNNING);
        org.mockito.Mockito.doAnswer(inv -> {
        Consumer<StageExecution> scheduler = stage -> {
        b.fire(StageExecution.State.CANCELLED);
    }
        Consumer<StageExecution> scheduler = stage -> fail("must NOT schedule on child failure");
            return fakeState;
     * children SUCCEEDED. A child reaching RUNNING must not trigger the parent.
        parent.attachChildren(List.of(a, b), stage -> {});
import org.opensearch.test.OpenSearchTestCase;
        private boolean transitionTo(State target) {
            this.metadata = metadata;
        FakeParent parent = new FakeParent(99, true);
        assertEquals("parent with a cancelled child must terminate as CANCELLED", StageExecution.State.CANCELLED, parent.fakeState);
import java.util.concurrent.atomic.AtomicReference;
import static org.mockito.ArgumentMatchers.eq;
        scheduled.set(null);
        // Cancel IS propagated so the parent reaches terminal (phantom-task fix); not failed, not metadata-consumed.
     * Parent stub for tests that exercise the parent-state listener installed by
        assertTrue("failed child input must still be closed", parent.childInputClosed);
     * sink whose owner has terminated.
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
        FakeChild a = new FakeChild(1);
public class AttachChildrenTests extends OpenSearchTestCase {
            return transitionTo(State.FAILED);
import java.util.function.Consumer;
            listeners.add(listener);
        FakeChild(int stageId) {
        }
        }
            State previous = fakeState;
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
     * {@link #cancel(String)} actually transition {@link #fakeState} and fire listeners,
        String cancelReason;
        Exception capturedFailure;
    public void testAllChildrenCancelledDrivesParentTerminal() {
        }
        public void addStateListener(StageStateListener listener) {
        childB.fireSucceeded();
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
     * so it reaches a terminal state. Without the propagation the parent strands in RUNNING, its
        verify(parent).cancel(any());
     * pending count never drains, the root never mirrors to the query, and the coordinator task is
import java.util.HashMap;
        eagerParent.attachChildren(List.of(c), stage -> {});
        }
        // default schedulesEagerly() == false
        }
        }
        }
            assertNotNull("metadata should be handed off before scheduling", consumed.get());
            return stageId;
     * (terminal) rather than being scheduled — there is nothing left to run.
            for (StageStateListener l : listeners)
     * Sibling-cancel sweep: when one child fails and the parent transitions to FAILED,
import java.util.Map;
        }
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
        @Override
    }
        public void closeChildInput(int childStageId) {
        parent.attachChildren(List.of(failing), scheduler);
        child.fire(StageExecution.State.FAILED);
/*
        @Override
        @Override
        @Override
        // EOF released to the reduce input (the leak fix).
        public State getState() {
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
}
        @Override
    }
        Exception failure;
import static org.mockito.ArgumentMatchers.any;
        failing.failure = new RuntimeException("kaboom");
            this(stageId, false);
     */
            State previous = fakeState;
        Consumer<StageExecution> scheduler = stage -> fail("must NOT schedule on child cancellation");
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
            return false;
            if (fakeState.isTerminal()) return false;
        @Override
        parent.attachChildren(List.of(childA, childB), scheduler);
     */
     * Waiting for all-children-SUCCEEDED would deadlock on a bounded input mpsc.
        void fire(State terminal) {
        // Subsequent RUNNING transitions on other children must not re-schedule.
package org.opensearch.analytics.exec.stage;
            if (fakeState.isTerminal()) return false;
        private final List<StageStateListener> listeners = new ArrayList<>();
            this.succeedOnClose = succeedOnClose;
        assertSame(child.failure, parent.capturedFailure);
            return new StageMetrics();
        @Override
            return metadata;
    public void testCancelledPlusSucceededChildDrivesParentTerminalNotScheduled() {
        public boolean failWithCause(Exception cause) {
        FakeChild childA = new FakeChild(1);
        AtomicReference<StageExecution> scheduled = new AtomicReference<>();
        FakeChild alreadyDone = new FakeChild(3);
        parent.attachChildren(List.of(childA, childB), scheduler);
        FakeChild childA = new FakeChild(1);
            onStarted.onResponse(null);
        succeeded.fire(StageExecution.State.SUCCEEDED);
        assertNull("default-mode parent must NOT schedule on child RUNNING", scheduled.get());
        org.mockito.Mockito.when(eagerParent.schedulesEagerly()).thenReturn(true);
    private static final class FakeParent implements StageExecution {
import static org.mockito.Mockito.mock;
     */
        }
        FakeChild failing = new FakeChild(1);
        public Exception getFailure() {
        childB.fire(StageExecution.State.RUNNING);
        }
        public Exception getFailure() {
        );
        child.fire(StageExecution.State.CANCELLED);
        }
    public void testCancelledChildWithRunningSiblingDoesNotStrandParent() {
    }
        parent.attachChildren(List.of(cancelled), scheduler);
        public void start(ActionListener<Void> onStarted) {
        }
    /**
            if (succeedOnClose) {
    public void testFailedChildPropagatesDirectlyToParent() {
            fakeState = target;
        Consumer<StageExecution> scheduler = scheduled::set;
 * and the metadata channel that ferries each child's {@code publishedMetadata}
        FakeParent parent = new FakeParent(99);
        assertTrue(
import java.util.List;
     * silently drop the signal for a future buffered multi-input backend.
        FakeChild childB = new FakeChild(2);
        assertTrue(
        @Override
     * A child failure must claim FAILED before that EOF is published, or the successful
     * to RUNNING — they need to run concurrently with their children's feeds (e.g. a
            return new StageMetrics();
        FakeParent parent = new FakeParent(99, true);
    /**
        FakeChild failing = new FakeChild(1);
     * {@link #fakeState} is queried by the cascade's parent-listener via {@link #getState()}.
import static org.mockito.Mockito.verify;
        );
        }
    // query task never unregisters → phantom task (observed as a query/ppl task stuck for hours
        @Override
        public void start(ActionListener<Void> onStarted) {
     * PROBE 3: one CANCELLED + one SUCCEEDED. The cancelled child must still account for its pending
            for (StageStateListener l : listeners)
        @Override
            fakeState = terminal;
            assertEquals("stats-from-B", consumed.get().get(8));
    private static final class FakeChild implements StageExecution {
    }
            this(stageId, null);
 * scheduler dispatch on all-SUCCEEDED, direct propagation on FAILED / CANCELLED,
 * compatible open source license.
        FakeChild child = new FakeChild(1);
        childC.fireSucceeded();
    }
            return fakeState;
            // Verify the metadata handoff happened BEFORE this scheduler runs.
        }
        child.fakeState = StageExecution.State.CREATED;
     */
        StageExecution eagerParent = mock(StageExecution.class, CALLS_REAL_METHODS);
    }
     * never unregistered (the phantom-task leak). The parent must NOT be scheduled (nothing to run)
     * drain blocked on {@code streamNext} sees EOF and unwinds) AND propagates cancel to the parent
            return failure;
        parent.attachChildren(List.of(child), stage -> {});
    }
        a.fireSucceeded();
        assertEquals(StageExecution.State.CANCELLED, parent.fakeState);
            scheduled.set(stage);
 *
            parent.fakeState.isTerminal()
        public void onTaskTerminal(StageTask task, Exception cause) {}
        State fakeState = State.RUNNING;
        }
     * Minimal child stub: append listeners + fire transitions; carries optional metadata + failure;
        FakeChild(int stageId, Object metadata) {
        a.fire(StageExecution.State.CANCELLED);
            return null;
    }
        private final boolean succeedOnClose;
    /**
        Consumer<StageExecution> scheduler = scheduled::set;
    public void testCloseChildInputFiresOnEveryChildSucceededRegardlessOfMode() {
        childB.fireSucceeded();
        FakeChild b = new FakeChild(2);
        assertEquals(StageExecution.State.FAILED, parent.fakeState);
        FakeChild succeeded = new FakeChild(2);
        parent.attachChildren(List.of(child), stage -> {});
 * to the parent's {@code consumeChildMetadata} before scheduling.
        childA.fireSucceeded();
        assertTrue(
        FakeChild a = new FakeChild(11);
        childA.fakeState = StageExecution.State.CREATED;
        assertNotNull("scheduler should have run", consumed.get());
    /**
        FakeChild stillRunning = new FakeChild(2);
        public boolean failWithCause(Exception cause) {
        verify(parent, never()).failWithCause(any());
        }
        @Override
                + "query task never unregisters (phantom). parent state="
     * Per-input EOF hook fires on every child SUCCEEDED, regardless of scheduling mode.
            this.stageId = stageId;
        }).when(parent).consumeChildMetadata(any());
import static org.mockito.Mockito.CALLS_REAL_METHODS;
        verify(parent).failWithCause(failing.failure);
        StageExecution defaultParent = mock(StageExecution.class, CALLS_REAL_METHODS);
        child.failure = new RuntimeException("injected shard failure");
        private final List<StageStateListener> listeners = new ArrayList<>();
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
     * which is what triggers the sibling-cancel sweep.
     * terminal state wins and the query incorrectly returns partial/empty results.
    /**
        }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        }
     * {@link StageExecution#attachChildren}: {@link #failWithCause(Exception)} and
        assertSame("default-mode parent scheduled on all-SUCCEEDED", parent, scheduled.get());
        FakeChild childB = new FakeChild(2);
            childInputClosed = true;
        assertSame("parent scheduled after all-children-SUCCEEDED", parent, scheduled.get());
        private final Object metadata;
                l.onStateChange(previous, target);
        child.fire(StageExecution.State.SUCCEEDED);
                + parent.fakeState,
        FakeChild stillRunning = new FakeChild(2); // stays RUNNING, never fires terminal
        public State getState() {
        }
        // Capture metadata at the moment the cascade hands it off — i.e., before scheduling.
        StageExecution parent = mock(StageExecution.class, CALLS_REAL_METHODS);
    public void testSiblingsAreCancelledWhenParentReachesFailedTerminal() {
     * Closing an eager parent's input can wake its drain and make it report success inline.
