        when(mockMergeResult.getMergedWriterFileSet()).thenReturn(Collections.emptyMap());
        for (int i = 0; i < numThreads; i++) {
    public void testGetActiveMergeCount_IncludesForceMerge() throws Exception {
        MergeHandler mockHandler = mock(MergeHandler.class);
                            scheduler.unfreeze();
        assertTrue("Listener should fire when last merge completes", latch.await(5, TimeUnit.SECONDS));
            threads[i].start();
            true,  // findAndRegisterMerges is a no-op (mocked), executeMerge loop condition
                try {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
    /**
     * registers an onDrained listener, and verifies the listener fires when the merge task
        int numThreads = 8;
        }, ThreadPool.Names.FORCE_MERGE + "-test");
    public void testMergeDrainTimeoutException_CarriesData() {
        scheduler.onDrained(() -> {
     * {@link MergeDrainTimeoutException}. The type is registered with the {@code OpenSearchException}
    /**
    /**
 * - Multiple listeners can be registered concurrently
        when(mockHandler.hasPendingMerges()).thenReturn(true);
                scheduler.forceMerge(1);
     * Integration test: exercises the REAL {@code submitMergeTask} finally block firing listeners
        when(mockHandler.hasPendingMerges()).thenReturn(true, false);
        // Verify activeMerges reflects the running force merge
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                } catch (Throwable t) {
    /**
        assertTrue("4th listener should be called immediately when already drained", fourthFired.get());
import org.opensearch.index.engine.exec.Segment;
            try {
     */
    public void testHasPendingMerges_DelegatesToMergeHandler() {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        MergeHandler mockHandler = mock(MergeHandler.class);
    private ThreadPool threadPool;
     * Verifies that an in-flight force merge blocks {@code onDrained} from firing immediately.
        Segment s1 = new Segment(1L, Collections.emptyMap());
    public void testSubmitMergeTask_FinallyBlock_FiresListenersWhenLastMergeCompletes() throws Exception {
        // Register listener - should not fire yet (hasPendingMerges is true)
     * back to the concrete type with its shard id, typed active count, pending flag, and message
import org.opensearch.common.settings.Settings;
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));
                    barrier.await();
        });
            } catch (Exception e) {
                }
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {
        for (int i = 0; i < threadsPerSide * 2; i++) {
     * This tests the exception isolation in the submitMergeTask finally block by verifying
    }
     */
                forceMergeError.set(e);
    }
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        scheduler.onDrained(() -> fourthFired.set(true));
     * {@code findAndRegisterMerges()}) runs only for that single winner — a redundant unfreeze must not
    // ── Additional tests for listener firing, TOCTOU race, exception isolation, and counts ──
import org.opensearch.core.common.io.stream.StreamInput;
        AtomicReference<Throwable> error = new AtomicReference<>();
        assertEquals("activeMerges should be 0 after force merge", 0, scheduler.getActiveMergeCount());
     * and firing of subsequent listeners).
                        }
public class MergeSchedulerOnDrainedTests extends OpenSearchTestCase {
    // ── Concurrency tests for the tiering freeze/unfreeze transitions (parallel tier/cancel) ──
        });
        // second call returns false (double-check succeeds, fires the listener)
        assertEquals("every listener must fire inline when already drained", numThreads, fired.get());
    public void testConcurrentFreeze_ExactlyOneTransitionWins() throws Exception {
        AtomicBoolean listenerFired = new AtomicBoolean(false);
            deserialized instanceof MergeDrainTimeoutException
        MergeScheduler scheduler = newIdleScheduler(mockHandler);
        AtomicReference<Exception> forceMergeError = new AtomicReference<>();
                // ignore
    }
        super.tearDown();
        return new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
     * Verifies MergeDrainTimeoutException carries its diagnostic detail (shard, merge counts,
        assertNull("concurrent unfreeze() must not throw", error.get());
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        for (int i = 0; i < numThreads; i++) {
import java.util.concurrent.TimeUnit;
                    }
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
     * 1. First check: activeMerges &gt; 0 or hasPendingMerges = true - goes to add listener
                } catch (Throwable t) {
        CountDownLatch mergeStarted = new CountDownLatch(1);
        AtomicInteger transitions = new AtomicInteger(0);
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        Thread[] threads = new Thread[numThreads];
        when(mockHandler.hasPendingMerges()).thenReturn(false);
                        transitions.incrementAndGet();
 * - Double-check safety: listener fires if merges drain between check and add
     * When merges are pending, onDrained should register the listener (not fire immediately).
import java.util.concurrent.CyclicBarrier;
import org.opensearch.core.index.shard.ShardId;
                scheduler.forceMerge(1);
    /**
     * completes and activeMerges decrements to 0.
        assertTrue("scheduler should be frozen after explicit freeze", scheduler.isFrozen());
            t.join();
        when(oneMerge.getTotalNumDocs()).thenReturn(10L);
    public void testOnDrained_MergesPending_RegistersListener() {
        final Throwable deserialized;
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        // Actually, let's just not use freeze() — directly verify that the production
        assertEquals("No listeners should have fired yet", 0, callCount.get());
        // Register 3 listeners while merges are pending
            "should round-trip as a typed MergeDrainTimeoutException, got: " + deserialized.getClass().getName(),
        // triggerMerges() registers new merges only when not frozen; only the winning unfreeze runs it.
        MergeHandler mockHandler = mock(MergeHandler.class);
    public void testOnDrained_DoubleCheckRace_ListenerFiresImmediately() throws Exception {
        AtomicInteger callCount = new AtomicInteger(0);
     * fires its own listener independently, so an exception in one does not block registration
        MergeHandler mockHandler = mock(MergeHandler.class);
                    scheduler.onDrained(fired::incrementAndGet);
import java.util.concurrent.CountDownLatch;
        // production does: the frozen flag is already set before the merge completes.
     * <p>
        OneMerge oneMerge = new OneMerge(Collections.singletonList(s1));
    }
            out.writeException(original);
import org.opensearch.index.IndexSettings;
        mergeCanProceed.countDown();
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        assertFalse("Listener should not be called yet when merges are pending", listenerCalled.get());
    }
 * SPDX-License-Identifier: Apache-2.0
                    error.compareAndSet(null, t);
        assertEquals("active merges accessor", 3, ex.getActiveMerges());
    /**
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to
                } catch (Throwable t) {
        }
        // Each onDrained call is independent — if one listener throws during its own
            latch.countDown();
            try {
        MergeResult mockMergeResult = mock(MergeResult.class);
        assertTrue("explicit freeze should transition from the known unfrozen state", scheduler.freeze());
    }
 * Verifies:
        OneMerge oneMerge = mock(OneMerge.class);
        freezeThread.join(5000);
            threads[i].start();
import java.util.concurrent.atomic.AtomicInteger;
        // The exception propagates from onDrained but does not corrupt internal state
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
            t.join();
        // Register listeners individually via the double-check path.
            false, // executeMerge loop: after getNextMerge returns oneMerge, loop checks again
        when(mockHandler.hasPendingMerges()).thenReturn(true);
        Thread freezeThread = new Thread(() -> scheduler.freeze());
        forceMergeThread.start();
        int numThreads = 8;
    /**
        terminate(threadPool);
        assertTrue(typed.getMessage().contains("pending: no"));
    public void testGetActiveMergeCount_InitiallyZero() {
     * that the onDrained double-check path fires listeners individually (each call to onDrained
        assertTrue("marker must survive serialization", typed.getMessage().contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER));
                    barrier.await();
        for (Thread t : threads) {
        ShardId testShardId = new ShardId(new org.opensearch.core.index.Index("my-index", "uuid"), 2);
     */
     * message — the fallback signal the coordinator matches on for mixed-version clusters.
        assertTrue("onDrained listener must fire after force merge completes", drainListenerFired.get());
     */
     */
        assertNull("concurrent freeze() must not throw", error.get());
        // After merge completes, activeMerges should be back to 0
     */
    public void testOnDrained_BlockedByInFlightForceMerge() throws Exception {
        // Register a 4th listener — this should fire immediately via the inline check
        assertFalse("scheduler must end unfrozen", scheduler.isFrozen());
        MergeHandler mockHandler = mock(MergeHandler.class);
     * Concurrent freeze racing concurrent unfreeze on the same scheduler. The CAS guards guarantee the
        assertTrue("Merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        });
        // Reset hasPendingMerges stub for the full flow:
     */
     * Simulates active merges going from N→0 and verifies all registered listeners fire.
        CountDownLatch mergeCanProceed = new CountDownLatch(1);
        // Mock MergeResult
        });
import static org.mockito.Mockito.verify;
     * to the tiering drain mechanism.
    /**
            t.join();
        // invariant holds by checking isFrozen() returns true due to settings.
     * Verifies the merge-drain timeout round-trips through wire serialization as a typed
 */
                    barrier.await();
        assertEquals("Active merge count should be 0 initially", 0, scheduler.getActiveMergeCount());
        });
        // Simplest: use a scheduler that's frozen via the tiering state setting.
        when(mockHandler.hasPendingMerges()).thenReturn(true);
        assertEquals("Active merges should be 0 after completion", 0, scheduler.getActiveMergeCount());
        int iterations = 200;
        super.setUp();
    @Override
     */
    /**
        assertEquals("exactly one freeze() should win the transition", 1, transitions.get());
                }
     * The scheduler must end frozen with no exceptions.
        // Now simulate merges draining: register a new listener when handler says "no pending"
        MergeHandler mockHandler = mock(MergeHandler.class);
     */
        OneMerge oneMerge = new OneMerge(Collections.singletonList(s1));
     * Verifies that {@code getActiveMergeCount()} correctly includes a running force merge.
 */
     */
    public void tearDown() throws Exception {
        assertFalse("hasPendingMerges must survive serialization", typed.hasPendingMerges());
        scheduler.onDrained(callCount::incrementAndGet);
        assertTrue(typed.getMessage().contains("90s"));
package org.opensearch.index.engine.dataformat.merge;
    /**
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));
        }
                }
        assertNotNull("message must survive serialization", typed.getMessage());
        when(mockHandler.findForceMerges(1)).thenReturn(Collections.singletonList(oneMerge));
        threadPool = new TestThreadPool(getTestName());
            threads[i].start();
        // Register first listener — fires via double-check
        }
        mergeCanProceed.countDown();
        assertEquals("activeMerges should be 0 after force merge", 0, scheduler.getActiveMergeCount());
     * The drain listener must only fire after the force merge completes. This tests the fix for
        assertFalse("scheduler should be unfrozen after explicit unfreeze", scheduler.isFrozen());
        // Give freeze() time to set the frozen flag (it sets frozen first, then blocks on await)
            }
        AtomicBoolean listenerFired = new AtomicBoolean(false);
        AtomicInteger callCount = new AtomicInteger(0);
    public void testMergeDrainTimeoutException_RoundTripsAsTypedException() throws Exception {
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
            return new MergeResult(Collections.emptyMap());
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
import java.util.concurrent.atomic.AtomicBoolean;
    }
        forceMergeThread.join(10_000);
            true,  // onDrained double-check: activeMerges==0 but pending=true, so don't fire yet
                        transitions.incrementAndGet();
        Thread forceMergeThread = new Thread(() -> {
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {
        }
        assertTrue("Listener should fire via the double-check after add", listenerFired.get());
        assertTrue("Listener should have been fired", listenerFired.get());
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
import org.opensearch.storage.action.tiering.MergeDrainTimeoutException;
    public void testConcurrentUnfreeze_ExactlyOneTransition_TriggersMergesOnce() throws Exception {
        // Register 3 listeners
        when(mockHandler.hasPendingMerges()).thenReturn(true);
            latch.countDown();
        forceMergeThread.start();
        Thread.sleep(50);
            return new MergeResult(Collections.emptyMap());
        assertNull("concurrent onDrained() must not throw", error.get());
     * Verifies that getActiveMergeCount returns 0 when no merges have been submitted.
     */
        // Drain listener must NOT have fired — force merge is still running
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                } catch (Throwable t) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
    }
            threads[i] = new Thread(() -> {
            }
    }
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
     * and the scheduler never throws. After the storm, an explicit freeze/unfreeze drives it to a known,
        assertTrue("First listener should have fired", first.get());
        }
        assertEquals("No listeners should have fired yet", 0, callCount.get());
        AtomicReference<Throwable> error = new AtomicReference<>();
        scheduler.onDrained(callCount::incrementAndGet);
            } catch (Exception e) {
        try {
    public void testConcurrentFreezeAndUnfreeze_RemainsConsistent() throws Exception {
            callCount.incrementAndGet();
        scheduler.onDrained(() -> drainListenerFired.set(true));
        int numThreads = 8;
        AtomicReference<Throwable> error = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(3);
                        } else {
    public void testOnDrained_ListenersFire_WhenMergesGoFromNToZero() throws Exception {
        assertTrue("Third listener should have fired (isolated from second's exception)", third.get());
import org.opensearch.test.IndexSettingsModule;
            t.join();
import static org.mockito.Mockito.mock;
        // the listener fires immediately inline
                try {
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
import org.opensearch.threadpool.ThreadPool;
        assertTrue("scheduler must end frozen", scheduler.isFrozen());
        when(mockHandler.getNextMerge()).thenReturn(oneMerge, (OneMerge) null);
            try (StreamInput in = out.bytes().streamInput()) {
        // Wait for the merge to actually start on the thread pool
/**
        }
        freezeThread.start();
    }
        scheduler.onDrained(() -> {
        });
            threads[i].start();
        assertTrue("hasPendingMerges accessor", ex.hasPendingMerges());
    /**
        AtomicBoolean first = new AtomicBoolean(false);
    }
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < numThreads; i++) {
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
            false  // executeMerge re-call in finally block
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        scheduler.onDrained(() -> first.set(true));
            callCount.incrementAndGet();
        // allowing us to freeze the scheduler while the merge is in-flight.
        AtomicBoolean drainListenerFired = new AtomicBoolean(false);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        assertNull("forceMerge should complete without error", forceMergeError.get());
        when(mockHandler.hasPendingMerges()).thenReturn(true).thenReturn(false);
     */
     */
        scheduler.onDrained(() -> {
        // Wait for the freeze thread to finish
        assertTrue(typed.getMessage().contains("Active merges: 4"));
     * 3. Second check: activeMerges == 0 and hasPendingMerges = false - fires the listener immediately
            latch.countDown();
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        // We can't call freeze() because it calls awaitPendingMerges() which blocks.
                try {
        assertFalse("onDrained listener must NOT fire while force merge is in-flight", drainListenerFired.get());
import org.opensearch.test.OpenSearchTestCase;
     * consistent state.
     * Multiple listeners can be registered and all fire when merges drain.
     * the tiering race condition where {@code onMergesDrained} would fire immediately during
        Thread[] threads = new Thread[numThreads];
        assertEquals("activeMerges should be 1 during force merge", 1, scheduler.getActiveMergeCount());
     * When no merges are active or pending, onDrained should fire the listener immediately.
            });
    }
                    if (scheduler.freeze()) {
        CountDownLatch mergeStarted = new CountDownLatch(1);
        // but we don't call freeze() (which would block). Instead, simulate what
        MergeHandler mockHandler = mock(MergeHandler.class);
        // Now freeze and try to drain — should NOT fire immediately
    }
            listenerFired.set(true);
        when(mockHandler.getNextMerge()).thenReturn(oneMerge, (OneMerge) null);
        // doMerge returns the mock result
        scheduler.freeze(); // start frozen
        scheduler.onDrained(() -> {
                try {
        assertTrue(
        assertTrue("Force merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
        // Wait for the merge task to complete on the MERGE thread pool
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        // The listener should have fired via the double-check path
     * Verifies that one listener throwing an exception doesn't prevent other listeners from running.
     * (including {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER}) preserved.
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                    for (int n = 0; n < iterations; n++) {
        CountDownLatch mergeCanProceed = new CountDownLatch(1);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        scheduler.onDrained(callCount::incrementAndGet);
        Thread[] threads = new Thread[numThreads];
        when(mockHandler.hasPendingMerges()).thenReturn(false);
     * Before the fix, force merges never incremented {@code activeMerges}, making them invisible
            threads[i] = new Thread(() -> {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        assertEquals("activeMerges should be 1 during force merge", 1, scheduler.getActiveMergeCount());
            });
        for (Thread t : threads) {
        // hasPendingMerges: true on first call (executeMerge loop enters), then false for subsequent checks
        MergeDrainTimeoutException ex = new MergeDrainTimeoutException(testShardId, 3, true, "90s");
                    barrier.await();
    }
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        verify(mockHandler, times(1)).findAndRegisterMerges();
     */
            mergeStarted.countDown(); // Signal that merge has started
                    error.compareAndSet(null, t);
        Thread forceMergeThread = new Thread(() -> {
        // calling freeze() (which blocks).
    }
        MergeHandler mockHandler = mock(MergeHandler.class);
            mergeCanProceed.await();  // Wait until test allows merge to proceed
        assertTrue(ex.getMessage().contains("pending: yes"));
        MergeHandler mockHandler = mock(MergeHandler.class);
        });
        assertEquals("activeMerges should be 0 before force merge", 0, scheduler.getActiveMergeCount());
        // The TOCTOU double-check path should fire the new listener immediately
    /**
        // Wait for merge to actually start
            return mockMergeResult;
    private MergeScheduler newIdleScheduler(MergeHandler mockHandler) {
        // Since activeMerges is 0 (we never started any) and hasPendingMerges is now false,
        Segment s1 = new Segment(1L, Collections.emptyMap());
     * kick off a spurious merge cycle.
    }
import static org.mockito.Mockito.when;
        }
        }
            mergeCanProceed.await(10, TimeUnit.SECONDS);
            callCount.incrementAndGet();
 * - Returns true immediately when already drained (no active or pending merges)
        // Now freeze the scheduler — the merge is in-flight, so frozen flag is set
        assertEquals("exactly one unfreeze() should win the transition", 1, transitions.get());
     * serialization registry, so between nodes on the registered version (or newer) it deserializes
        AtomicInteger fired = new AtomicInteger(0);
     * a running force merge because {@code activeMerges} was never incremented.
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
            latch.countDown();
            threads[i] = new Thread(() -> {
        assertTrue("Listener should be called immediately when already drained", listenerCalled.get());
import java.util.Collections;
        // Use a latch to control merge timing: the merge blocks until we release it,
        CyclicBarrier barrier = new CyclicBarrier(threadsPerSide * 2);
        assertTrue(ex.getMessage().contains(testShardId.toString()));
                            scheduler.freeze();
        scheduler.onDrained(() -> third.set(true));
import org.opensearch.index.engine.dataformat.MergeResult;
        // But that's complex. Let's just release the merge from another thread after
import org.opensearch.threadpool.TestThreadPool;
     */
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        ShardId testShardId = new ShardId(new org.opensearch.core.index.Index("my-index", "uuid"), 0);
        // In production, freeze() is called and blocks until merge completes, setting
        );
     * Verifies that {@code hasPendingMerges} delegates to the underlying merge handler. Reports
 * Tests for {@link MergeScheduler#onDrained(Runnable)} listener functionality.
import static org.mockito.Mockito.times;
     */
    }
        when(mockHandler.doMerge(oneMerge)).thenReturn(mockMergeResult);
     * Many threads register an {@code onDrained} listener concurrently while the scheduler is already
 * - Registers listener and returns false when merges are active
        // After force merge completes, drain listener should have fired
        when(mockHandler.hasPendingMerges()).thenReturn(
        // Mock OneMerge
        // Start force merge on a FORCE_MERGE-named thread (required by assertion)
        // doMerge blocks until we release the latch — simulates a long-running merge
                    }
        assertTrue("Merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
    /**
        // Trigger merges - this calls findAndRegisterMerges() then executeMerge() which calls submitMergeTask()
        // double-check firing, it doesn't affect the next onDrained call.
            mergeCanProceed.await(10, TimeUnit.SECONDS);
            assertEquals("Intentional test exception", e.getMessage());
    /**
        MergeHandler mockHandler = mock(MergeHandler.class);
}
    public void setUp() throws Exception {
        when(mockHandler.hasPendingMerges()).thenReturn(true, false, true, false, true, false);
            threads[i] = new Thread(() -> {
        assertFalse("hasPendingMerges should delegate to handler when handler reports false", scheduler.hasPendingMerges());
        AtomicInteger transitions = new AtomicInteger(0);
            mergeStarted.countDown();
        // Now let the merge complete
            false, // finally block: hasPendingMerges for drain check
/*
        scheduler.onDrained(() -> listenerCalled.set(true));
    public void testOnDrained_MultipleListeners_AllFire() {
        } catch (RuntimeException e) {
        assertTrue(ex.getMessage().contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER));
        // the flag first. Here we replicate just the flag setting.
        // First call to hasPendingMerges returns true (first check fails, goes to add),
                    }
        // Initially there are pending merges
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        MergeHandler mockHandler = mock(MergeHandler.class);
    @Override
        assertTrue("hasPendingMerges should delegate to handler when handler reports true", scheduler.hasPendingMerges());
            scheduler.onDrained(() -> { throw new RuntimeException("Intentional test exception"); });
     * when the last merge completes.
    }
     * Many threads call {@link MergeScheduler#unfreeze()} simultaneously on a frozen scheduler. Exactly
     * drained (no active or pending merges). Every listener must fire inline exactly once — the
        }
 * this file be licensed under the Apache-2.0 license or a
        AtomicBoolean fourthFired = new AtomicBoolean(false);
        assertEquals("active merges must survive serialization", 4, typed.getActiveMerges());
            final boolean freezer = (i % 2 == 0);
        for (Thread t : threads) {
     * Many threads call {@link MergeScheduler#freeze()} simultaneously. The {@code compareAndSet}
        forceMergeThread.join(10_000);
                    if (scheduler.unfreeze()) {
                    error.compareAndSet(null, t);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        when(mockHandler.findForceMerges(1)).thenReturn(Collections.singletonList(oneMerge));
     * This exercises the code path where:
        }
        );
        when(oneMerge.getTotalSizeInBytes()).thenReturn(100L);
        assertNull("concurrent freeze/unfreeze must not throw or deadlock", error.get());
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
    /**
        // Re-stub getNextMerge (reset)
        scheduler.unfreeze();
    public void testOnDrained_ListenerExceptionIsolation_OtherListenersStillFire() throws Exception {
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        scheduler.triggerMerges();
     * timeout) plus the stable {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER} in its
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
    }
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        scheduler.onDrained(() -> listenerFired.set(true));
        // Register third listener — fires via double-check, unaffected by second's exception
     * Uses a real MergeScheduler with a mock MergeHandler that transitions from "has pending" to "drained".
        AtomicReference<Throwable> error = new AtomicReference<>();
        forceMergeThread.setDaemon(true);
     * Creates a MergeScheduler with a real ThreadPool and a mock MergeHandler, triggers a merge,
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        assertTrue(ex.getMessage().contains("90s"));
    /**
        scheduler.freeze();
        forceMergeThread.setDaemon(true);
     * 2. Listener is added to the list
            }
        MergeDrainTimeoutException original = new MergeDrainTimeoutException(testShardId, 4, false, "90s");
     * Verifies the TOCTOU double-check: listener fires if merges drain between first check and add.
        // Register second listener — throws, but fires via double-check
        int threadsPerSide = 4;
                }
        for (Thread t : threads) {
 * - Fires all registered listeners when last merge completes
        MergeDrainTimeoutException typed = (MergeDrainTimeoutException) deserialized;
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
            mergeStarted.countDown();
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));
    public void testConcurrentOnDrained_AllListenersFireWhenAlreadyDrained() throws Exception {
        }, ThreadPool.Names.FORCE_MERGE + "-test");
import java.util.concurrent.atomic.AtomicReference;
     * {@code CopyOnWriteArrayList} + inline-fire path must be safe under concurrent registration.
        scheduler.onDrained(() -> listenerCalled.set(true));
     */
        assertFalse("Listener should not have fired yet", listenerFired.get());
     * one caller wins the frozen→unfrozen transition, and {@code triggerMerges()} (hence
        // Converge to a known state: a final freeze must win exactly once if currently unfrozen.
        AtomicBoolean third = new AtomicBoolean(false);
     * guard must let exactly one caller win the unfrozen→frozen transition; the rest are no-ops.
        CountDownLatch mergeStarted = new CountDownLatch(1);
        CountDownLatch mergeCanProceed = new CountDownLatch(1);
                    error.compareAndSet(null, t);
 * compatible open source license.
     * pending state orthogonally — the active-count is unchecked here.
            });
                deserialized = in.readException();
    /**
        // Register an onDrained listener BEFORE triggering merges.
        assertTrue(ex.getMessage().contains("Active merges: 3"));
 *
            });
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        // Release the merge — now it completes, finally block runs with frozen=true
     * counts are consistent (frozen→unfrozen transitions never exceed the freezes that preceded them)
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        // getNextMerge: return oneMerge first, then null
        MergeHandler mockHandler = mock(MergeHandler.class);
    public void testOnDrained_AlreadyDrained_FiresListenerImmediately() {
                        if (freezer) {
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
            true,  // onDrained first check: returns true, so listener is registered
        mergeCanProceed.countDown();
        Thread[] threads = new Thread[threadsPerSide * 2];
