            callCount.incrementAndGet();
        // production does: the frozen flag is already set before the merge completes.  
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        Segment s1 = new Segment(1L, Collections.emptyMap());
        }
        // Register first listener — fires via double-check  
        Thread[] threads = new Thread[threadsPerSide * 2];  
        when(oneMerge.getTotalSizeInBytes()).thenReturn(100L);
        // hasPendingMerges: true on first call (executeMerge loop enters), then false for subsequent checks  
                            scheduler.freeze();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        // getNextMerge: return oneMerge first, then null
            false, // finally block: hasPendingMerges for drain check  
            listenerFired.set(true);
    public void testConcurrentUnfreeze_ExactlyOneTransition_TriggersMergesOnce() throws Exception {
        MergeResult mockMergeResult = mock(MergeResult.class);  
        final Throwable deserialized;
        CountDownLatch mergeStarted = new CountDownLatch(1);
        MergeDrainTimeoutException ex = new MergeDrainTimeoutException(testShardId, 3, true, "90s");  
        assertFalse("hasPendingMerges should delegate to handler when handler reports false", scheduler.hasPendingMerges());
            try {
        OneMerge oneMerge = new OneMerge(Collections.singletonList(s1));  
        assertTrue("Listener should have been fired", listenerFired.get());
    public void testConcurrentOnDrained_AllListenersFireWhenAlreadyDrained() throws Exception {
            return new MergeResult(Collections.emptyMap());  
     * a running force merge because {@code activeMerges} was never incremented.
        assertNull("concurrent onDrained() must not throw", error.get());  
        }
    @Override
        assertNull("concurrent freeze() must not throw", error.get());
    public void testOnDrained_ListenerExceptionIsolation_OtherListenersStillFire() throws Exception {  
 */  
    public void testOnDrained_MergesPending_RegistersListener() {  
     * When no merges are active or pending, onDrained should fire the listener immediately.
        AtomicBoolean first = new AtomicBoolean(false);  
        terminate(threadPool);  
     * 1. First check: activeMerges &gt; 0 or hasPendingMerges = true - goes to add listener
            try (StreamInput in = out.bytes().streamInput()) {
        Segment s1 = new Segment(1L, Collections.emptyMap());
        for (Thread t : threads) {
        scheduler.onDrained(() -> listenerCalled.set(true));  
    /**
        // Trigger merges - this calls findAndRegisterMerges() then executeMerge() which calls submitMergeTask()
    /**
            threads[i] = new Thread(() -> {
        mergeCanProceed.countDown();
     */  
            });  
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
                    barrier.await();  
        AtomicInteger fired = new AtomicInteger(0);  
        Thread.sleep(50);
     * This tests the exception isolation in the submitMergeTask finally block by verifying
     * Before the fix, force merges never incremented {@code activeMerges}, making them invisible  
        AtomicBoolean listenerFired = new AtomicBoolean(false);  
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {
    }  
        when(mockHandler.getNextMerge()).thenReturn(oneMerge, (OneMerge) null);
    /**
        // Now let the merge complete  
        ShardId testShardId = new ShardId(new org.opensearch.core.index.Index("my-index", "uuid"), 2);
        AtomicReference<Throwable> error = new AtomicReference<>();
        }
        // Register listeners individually via the double-check path.
     */  
        assertTrue("Merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);  
        }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
        forceMergeThread.setDaemon(true);
        // Reset hasPendingMerges stub for the full flow:  
        });  
        });  
            }  
            mergeStarted.countDown();
        AtomicInteger transitions = new AtomicInteger(0);
     * message — the fallback signal the coordinator matches on for mixed-version clusters.
     * kick off a spurious merge cycle.
            });
     * Verifies the TOCTOU double-check: listener fires if merges drain between first check and add.
            t.join();
        MergeHandler mockHandler = mock(MergeHandler.class);
     */
        assertEquals("every listener must fire inline when already drained", numThreads, fired.get());
                    }  
        CountDownLatch latch = new CountDownLatch(3);
    // ── Additional tests for listener firing, TOCTOU race, exception isolation, and counts ──
        assertTrue(ex.getMessage().contains("Active merges: 3"));  
     * <p>
    public void testOnDrained_AlreadyDrained_FiresListenerImmediately() {
     * when the last merge completes.  
        assertTrue("Merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
    /**
     * counts are consistent (frozen→unfrozen transitions never exceed the freezes that preceded them)
            threads[i] = new Thread(() -> {  
        when(mockHandler.getNextMerge()).thenReturn(oneMerge, (OneMerge) null);  
import org.opensearch.threadpool.TestThreadPool;
        // In production, freeze() is called and blocks until merge completes, setting
                } catch (Throwable t) {
 * - Registers listener and returns false when merges are active
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);  
    /**
 * this file be licensed under the Apache-2.0 license or a
                }
        });
     * timeout) plus the stable {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER} in its
        int numThreads = 8;
        // Wait for merge to actually start
                forceMergeError.set(e);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
            threads[i] = new Thread(() -> {  
            mergeCanProceed.await(10, TimeUnit.SECONDS);  
        assertTrue(ex.getMessage().contains("90s"));
     * {@link MergeDrainTimeoutException}. The type is registered with the {@code OpenSearchException}
public class MergeSchedulerOnDrainedTests extends OpenSearchTestCase {  
import java.util.Collections;
     * When merges are pending, onDrained should register the listener (not fire immediately).
import org.opensearch.core.common.io.stream.StreamInput;  
/*  
        forceMergeThread.setDaemon(true);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);  
        });
            threads[i].start();
        assertTrue(typed.getMessage().contains("Active merges: 4"));  
        for (int i = 0; i < numThreads; i++) {  
        forceMergeThread.start();
        assertEquals("active merges must survive serialization", 4, typed.getActiveMerges());
        // After force merge completes, drain listener should have fired
        assertEquals("activeMerges should be 0 after force merge", 0, scheduler.getActiveMergeCount());
                    }  
        assertNull("forceMerge should complete without error", forceMergeError.get());  
            false, // executeMerge loop: after getNextMerge returns oneMerge, loop checks again
        Thread[] threads = new Thread[numThreads];
        // Register 3 listeners while merges are pending
        // Now simulate merges draining: register a new listener when handler says "no pending"  
     * 3. Second check: activeMerges == 0 and hasPendingMerges = false - fires the listener immediately  
     * completes and activeMerges decrements to 0.
        // but we don't call freeze() (which would block). Instead, simulate what
                deserialized = in.readException();
        assertTrue("4th listener should be called immediately when already drained", fourthFired.get());
     */
        // Register an onDrained listener BEFORE triggering merges.
            threads[i].start();
        when(mockHandler.hasPendingMerges()).thenReturn(true);
    /**
import java.util.concurrent.atomic.AtomicInteger;
                        } else {  
        CyclicBarrier barrier = new CyclicBarrier(threadsPerSide * 2);
                try {
     * Verifies that {@code hasPendingMerges} delegates to the underlying merge handler. Reports  
    }
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
            true,  // onDrained double-check: activeMerges==0 but pending=true, so don't fire yet  
        when(mockHandler.hasPendingMerges()).thenReturn(
     */
    }
import org.opensearch.threadpool.ThreadPool;  
        AtomicReference<Throwable> error = new AtomicReference<>();
                    barrier.await();
        assertTrue("onDrained listener must fire after force merge completes", drainListenerFired.get());  
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));  
        assertEquals("activeMerges should be 1 during force merge", 1, scheduler.getActiveMergeCount());  
            latch.countDown();  
        int iterations = 200;  
     * Verifies MergeDrainTimeoutException carries its diagnostic detail (shard, merge counts,  
        // But that's complex. Let's just release the merge from another thread after
                            scheduler.unfreeze();
        for (int i = 0; i < numThreads; i++) {
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        MergeHandler mockHandler = mock(MergeHandler.class);
     */
        int numThreads = 8;  
     * Verifies that {@code getActiveMergeCount()} correctly includes a running force merge.
        when(mockHandler.hasPendingMerges()).thenReturn(false);  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
            latch.countDown();
        // Register third listener — fires via double-check, unaffected by second's exception  
                    if (scheduler.freeze()) {
        assertTrue(typed.getMessage().contains("90s"));
        assertTrue("scheduler should be frozen after explicit freeze", scheduler.isFrozen());
    public void setUp() throws Exception {
        // Each onDrained call is independent — if one listener throws during its own
                // ignore
        when(mockHandler.hasPendingMerges()).thenReturn(false);  
        MergeHandler mockHandler = mock(MergeHandler.class);
        // Use a latch to control merge timing: the merge blocks until we release it,
        } catch (RuntimeException e) {
        CountDownLatch mergeCanProceed = new CountDownLatch(1);
                }
        // Re-stub getNextMerge (reset)
        CountDownLatch mergeStarted = new CountDownLatch(1);
        // Release the merge — now it completes, finally block runs with frozen=true  
        when(mockHandler.hasPendingMerges()).thenReturn(true, false);
}  
            true,  // onDrained first check: returns true, so listener is registered
     * Verifies that getActiveMergeCount returns 0 when no merges have been submitted.  
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
            assertEquals("Intentional test exception", e.getMessage());  
        when(mockHandler.hasPendingMerges()).thenReturn(true, false, true, false, true, false);
    /**
        // Register listener - should not fire yet (hasPendingMerges is true)
     * Many threads call {@link MergeScheduler#freeze()} simultaneously. The {@code compareAndSet}  
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
                        }
import org.opensearch.index.engine.dataformat.MergeResult;  
                    }
                    for (int n = 0; n < iterations; n++) {  
     * registers an onDrained listener, and verifies the listener fires when the merge task  
     */  
        // We can't call freeze() because it calls awaitPendingMerges() which blocks.
        // Wait for the merge to actually start on the thread pool
        // triggerMerges() registers new merges only when not frozen; only the winning unfreeze runs it.
        scheduler.onDrained(() -> first.set(true));
 * compatible open source license.
        assertEquals("No listeners should have fired yet", 0, callCount.get());
     * Verifies that one listener throwing an exception doesn't prevent other listeners from running.  
        assertFalse("hasPendingMerges must survive serialization", typed.hasPendingMerges());  
        assertTrue("Listener should fire via the double-check after add", listenerFired.get());
        scheduler.freeze();
        // Give freeze() time to set the frozen flag (it sets frozen first, then blocks on await)  
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);  
        // second call returns false (double-check succeeds, fires the listener)
        scheduler.triggerMerges();
     * consistent state.  
        for (Thread t : threads) {  
        assertTrue(typed.getMessage().contains("pending: no"));
            "should round-trip as a typed MergeDrainTimeoutException, got: " + deserialized.getClass().getName(),
        CountDownLatch mergeCanProceed = new CountDownLatch(1);
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
     * {@code findAndRegisterMerges()}) runs only for that single winner — a redundant unfreeze must not
        scheduler.onDrained(() -> {
                    error.compareAndSet(null, t);
    private MergeScheduler newIdleScheduler(MergeHandler mockHandler) {
        forceMergeThread.join(10_000);
        assertNull("concurrent freeze/unfreeze must not throw or deadlock", error.get());
     */
    public void testSubmitMergeTask_FinallyBlock_FiresListenersWhenLastMergeCompletes() throws Exception {  
        assertTrue("hasPendingMerges should delegate to handler when handler reports true", scheduler.hasPendingMerges());
     * Verifies the merge-drain timeout round-trips through wire serialization as a typed  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
        }  
        assertFalse("scheduler should be unfrozen after explicit unfreeze", scheduler.isFrozen());  
            final boolean freezer = (i % 2 == 0);
     */
     * to the tiering drain mechanism.
     * Uses a real MergeScheduler with a mock MergeHandler that transitions from "has pending" to "drained".  
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        scheduler.onDrained(() -> {
    @Override
        // Mock MergeResult
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        assertEquals("No listeners should have fired yet", 0, callCount.get());
        // calling freeze() (which blocks).
        });  
        CountDownLatch latch = new CountDownLatch(1);
        // Now freeze the scheduler — the merge is in-flight, so frozen flag is set
     * and the scheduler never throws. After the storm, an explicit freeze/unfreeze drives it to a known,
        assertTrue("marker must survive serialization", typed.getMessage().contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER));
                        transitions.incrementAndGet();
        super.setUp();  
    }  
        // Since activeMerges is 0 (we never started any) and hasPendingMerges is now false,
        AtomicReference<Throwable> error = new AtomicReference<>();  
        int numThreads = 8;
        assertNotNull("message must survive serialization", typed.getMessage());
     */  
        // After merge completes, activeMerges should be back to 0
import java.util.concurrent.CountDownLatch;  
            callCount.incrementAndGet();  
    public void testConcurrentFreeze_ExactlyOneTransitionWins() throws Exception {
            t.join();
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        // Now freeze and try to drain — should NOT fire immediately
        MergeHandler mockHandler = mock(MergeHandler.class);  
import org.opensearch.storage.action.tiering.MergeDrainTimeoutException;
                try {
     * Concurrent freeze racing concurrent unfreeze on the same scheduler. The CAS guards guarantee the  
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {  
     */
        // The TOCTOU double-check path should fire the new listener immediately
     * Simulates active merges going from N→0 and verifies all registered listeners fire.
        // Converge to a known state: a final freeze must win exactly once if currently unfrozen.
        Thread[] threads = new Thread[numThreads];
     */
     * the tiering race condition where {@code onMergesDrained} would fire immediately during
        OneMerge oneMerge = new OneMerge(Collections.singletonList(s1));
            } catch (Exception e) {
     * {@code CopyOnWriteArrayList} + inline-fire path must be safe under concurrent registration.
     * back to the concrete type with its shard id, typed active count, pending flag, and message  
package org.opensearch.index.engine.dataformat.merge;
                scheduler.forceMerge(1);
        // doMerge blocks until we release the latch — simulates a long-running merge  
        assertEquals("exactly one freeze() should win the transition", 1, transitions.get());  
        }
        AtomicBoolean listenerFired = new AtomicBoolean(false);
     */  
        // Register 3 listeners  
        // Start force merge on a FORCE_MERGE-named thread (required by assertion)
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        assertFalse("onDrained listener must NOT fire while force merge is in-flight", drainListenerFired.get());
            threads[i].start();  
        AtomicReference<Throwable> error = new AtomicReference<>();
     * Many threads register an {@code onDrained} listener concurrently while the scheduler is already  
        assertTrue("scheduler must end frozen", scheduler.isFrozen());
        mergeCanProceed.countDown();
     * serialization registry, so between nodes on the registered version (or newer) it deserializes
import java.util.concurrent.CyclicBarrier;
        when(oneMerge.getTotalNumDocs()).thenReturn(10L);  
    }  
import org.opensearch.common.settings.Settings;
        // doMerge returns the mock result
        // Register a 4th listener — this should fire immediately via the inline check
        scheduler.onDrained(() -> {  
            latch.countDown();
    }
    }
        scheduler.onDrained(() -> third.set(true));
    /**
     * Many threads call {@link MergeScheduler#unfreeze()} simultaneously on a frozen scheduler. Exactly
     * guard must let exactly one caller win the unfrozen→frozen transition; the rest are no-ops.
                    barrier.await();
            }  
     * Multiple listeners can be registered and all fire when merges drain.  
     * Integration test: exercises the REAL {@code submitMergeTask} finally block firing listeners
        assertTrue("Third listener should have fired (isolated from second's exception)", third.get());
            callCount.incrementAndGet();
        AtomicInteger callCount = new AtomicInteger(0);
        MergeHandler mockHandler = mock(MergeHandler.class);
                try {
        // Verify activeMerges reflects the running force merge  
    }
        for (int i = 0; i < numThreads; i++) {  
            false  // executeMerge re-call in finally block
            } catch (Exception e) {  
import static org.mockito.Mockito.mock;
        when(mockHandler.hasPendingMerges()).thenReturn(true).thenReturn(false);
        when(mockHandler.hasPendingMerges()).thenReturn(false);
     * drained (no active or pending merges). Every listener must fire inline exactly once — the
        scheduler.onDrained(() -> listenerFired.set(true));
    public void testHasPendingMerges_DelegatesToMergeHandler() {  
        when(mockHandler.doMerge(oneMerge)).thenAnswer(invocation -> {
            t.join();  
     * one caller wins the frozen→unfrozen transition, and {@code triggerMerges()} (hence  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
        verify(mockHandler, times(1)).findAndRegisterMerges();
        MergeHandler mockHandler = mock(MergeHandler.class);
        Thread freezeThread = new Thread(() -> scheduler.freeze());  
import java.util.concurrent.TimeUnit;
        // the flag first. Here we replicate just the flag setting.  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import static org.mockito.Mockito.when;
        // invariant holds by checking isFrozen() returns true due to settings.
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        when(mockHandler.hasPendingMerges()).thenReturn(true);
 * - Returns true immediately when already drained (no active or pending merges)  
    }  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        // Simplest: use a scheduler that's frozen via the tiering state setting.  
                }  
        );  
     * (including {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER}) preserved.
        MergeHandler mockHandler = mock(MergeHandler.class);
        when(mockHandler.doMerge(oneMerge)).thenReturn(mockMergeResult);
            mergeStarted.countDown();
     * Verifies that an in-flight force merge blocks {@code onDrained} from firing immediately.
        }
        MergeHandler mockHandler = mock(MergeHandler.class);  
        // Mock OneMerge  
        assertEquals("Active merges should be 0 after completion", 0, scheduler.getActiveMergeCount());
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);  
        assertEquals("activeMerges should be 1 during force merge", 1, scheduler.getActiveMergeCount());
     * The scheduler must end frozen with no exceptions.
            try {
            mergeCanProceed.await();  // Wait until test allows merge to proceed
        return new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
            out.writeException(original);  
                }  
        assertEquals("active merges accessor", 3, ex.getActiveMerges());
        CountDownLatch mergeCanProceed = new CountDownLatch(1);  
        assertEquals("activeMerges should be 0 before force merge", 0, scheduler.getActiveMergeCount());
    public void testMergeDrainTimeoutException_CarriesData() {
        }  
                    if (scheduler.unfreeze()) {  
        );
        OneMerge oneMerge = mock(OneMerge.class);
        assertEquals("exactly one unfreeze() should win the transition", 1, transitions.get());
        assertTrue(ex.getMessage().contains(testShardId.toString()));
                    error.compareAndSet(null, t);
    /**
            mergeCanProceed.await(10, TimeUnit.SECONDS);
                    error.compareAndSet(null, t);
     */
        AtomicBoolean third = new AtomicBoolean(false);
        for (int i = 0; i < threadsPerSide * 2; i++) {
                        if (freezer) {
        assertEquals("Active merge count should be 0 initially", 0, scheduler.getActiveMergeCount());
        assertFalse("scheduler must end unfrozen", scheduler.isFrozen());  
                    scheduler.onDrained(fired::incrementAndGet);
            t.join();
import org.opensearch.core.index.shard.ShardId;
/**  
 * - Multiple listeners can be registered concurrently  
        super.tearDown();
                } catch (Throwable t) {  
            }
 * SPDX-License-Identifier: Apache-2.0
            });
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertNull("concurrent unfreeze() must not throw", error.get());
        // Initially there are pending merges
     */
        // The listener should have fired via the double-check path
     * This exercises the code path where:  
     * pending state orthogonally — the active-count is unchecked here.
        }, ThreadPool.Names.FORCE_MERGE + "-test");
     * 2. Listener is added to the list
     */
        Thread[] threads = new Thread[numThreads];
import java.util.concurrent.atomic.AtomicReference;
    /**
            scheduler.onDrained(() -> { throw new RuntimeException("Intentional test exception"); });
        freezeThread.join(5000);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        // Drain listener must NOT have fired — force merge is still running  
import org.opensearch.test.OpenSearchTestCase;
        MergeHandler mockHandler = mock(MergeHandler.class);  
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        AtomicInteger callCount = new AtomicInteger(0);  
    public void testConcurrentFreezeAndUnfreeze_RemainsConsistent() throws Exception {
        scheduler.onDrained(callCount::incrementAndGet);
    public void testMergeDrainTimeoutException_RoundTripsAsTypedException() throws Exception {  
        assertTrue(  
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
     */  
                        transitions.incrementAndGet();
        AtomicBoolean listenerCalled = new AtomicBoolean(false);  
        AtomicBoolean fourthFired = new AtomicBoolean(false);
        assertTrue("Listener should be called immediately when already drained", listenerCalled.get());  
    public void tearDown() throws Exception {
    /**
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        MergeHandler mockHandler = mock(MergeHandler.class);
 * Tests for {@link MergeScheduler#onDrained(Runnable)} listener functionality.
        assertTrue("hasPendingMerges accessor", ex.hasPendingMerges());  
import static org.mockito.Mockito.times;
 */
        assertFalse("Listener should not be called yet when merges are pending", listenerCalled.get());
        // the listener fires immediately inline  
        AtomicReference<Exception> forceMergeError = new AtomicReference<>();
import org.opensearch.index.engine.exec.Segment;
    /**
    public void testOnDrained_MultipleListeners_AllFire() {
        // First call to hasPendingMerges returns true (first check fails, goes to add),  
        // Wait for the freeze thread to finish
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        try {  
    }  
     * The drain listener must only fire after the force merge completes. This tests the fix for  
        Thread forceMergeThread = new Thread(() -> {  
    /**  
        when(mockHandler.findForceMerges(1)).thenReturn(Collections.singletonList(oneMerge));  
        MergeDrainTimeoutException original = new MergeDrainTimeoutException(testShardId, 4, false, "90s");
        }, ThreadPool.Names.FORCE_MERGE + "-test");  
        // The exception propagates from onDrained but does not corrupt internal state
        forceMergeThread.start();  
import org.opensearch.test.IndexSettingsModule;  
        scheduler.onDrained(callCount::incrementAndGet);  
    public void testGetActiveMergeCount_InitiallyZero() {
     * and firing of subsequent listeners).
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);  
    /**
        // Wait for the merge task to complete on the MERGE thread pool  
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);
        assertEquals("activeMerges should be 0 after force merge", 0, scheduler.getActiveMergeCount());
        for (Thread t : threads) {
                } catch (Throwable t) {
    /**
    }
 * - Double-check safety: listener fires if merges drain between check and add
        when(mockMergeResult.getMergedWriterFileSet()).thenReturn(Collections.emptyMap());
        when(mockHandler.hasPendingMerges()).thenReturn(false);
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));
        for (Thread t : threads) {
 * The OpenSearch Contributors require contributions made to  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
    public void testOnDrained_DoubleCheckRace_ListenerFiresImmediately() throws Exception {
    // ── Concurrency tests for the tiering freeze/unfreeze transitions (parallel tier/cancel) ──
    private ThreadPool threadPool;
        when(mockHandler.hasPendingMerges()).thenReturn(true);
        forceMergeThread.join(10_000);  
        freezeThread.start();
        int threadsPerSide = 4;
        assertTrue(ex.getMessage().contains("pending: yes"));
 *
        when(mockHandler.hasPendingMerges()).thenReturn(true);
    /**
    public void testGetActiveMergeCount_IncludesForceMerge() throws Exception {  
        threadPool = new TestThreadPool(getTestName());
        MergeDrainTimeoutException typed = (MergeDrainTimeoutException) deserialized;
                } catch (Throwable t) {
     * Creates a MergeScheduler with a real ThreadPool and a mock MergeHandler, triggers a merge,
                    error.compareAndSet(null, t);  
        scheduler.onDrained(callCount::incrementAndGet);
    }
        MergeScheduler scheduler = newIdleScheduler(mock(MergeHandler.class));
        ShardId testShardId = new ShardId(new org.opensearch.core.index.Index("my-index", "uuid"), 0);
import java.util.concurrent.atomic.AtomicBoolean;  
    }  
            return mockMergeResult;
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
        assertTrue(ex.getMessage().contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER));
        mergeCanProceed.countDown();
        // allowing us to freeze the scheduler while the merge is in-flight.
        scheduler.unfreeze();
            true,  // findAndRegisterMerges is a no-op (mocked), executeMerge loop condition
        scheduler.onDrained(() -> drainListenerFired.set(true));
    }  
    }  
            latch.countDown();
        assertTrue("First listener should have fired", first.get());
        }  
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
    }
        AtomicInteger transitions = new AtomicInteger(0);  
        assertTrue("Listener should fire when last merge completes", latch.await(5, TimeUnit.SECONDS));
            });
        AtomicBoolean drainListenerFired = new AtomicBoolean(false);  
            mergeStarted.countDown(); // Signal that merge has started  
    }
            deserialized instanceof MergeDrainTimeoutException
    public void testOnDrained_ListenersFire_WhenMergesGoFromNToZero() throws Exception {
        });
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
     * that the onDrained double-check path fires listeners individually (each call to onDrained
            threads[i].start();
        // Register second listener — throws, but fires via double-check
 * Verifies:
import static org.mockito.Mockito.verify;  
 * - Fires all registered listeners when last merge completes
        scheduler.onDrained(() -> listenerCalled.set(true));
        assertFalse("Listener should not have fired yet", listenerFired.get());
        MergeScheduler scheduler = newIdleScheduler(mockHandler);  
        ShardId testShardId = new ShardId(indexSettings.getIndex(), 0);
    }  
        CountDownLatch mergeStarted = new CountDownLatch(1);  
    /**
        scheduler.onDrained(() -> fourthFired.set(true));  
        // double-check firing, it doesn't affect the next onDrained call.  
        scheduler.onDrained(() -> {  
        assertTrue("explicit freeze should transition from the known unfrozen state", scheduler.freeze());
    }  
import org.opensearch.index.IndexSettings;
    public void testOnDrained_BlockedByInFlightForceMerge() throws Exception {
            return new MergeResult(Collections.emptyMap());
        }  
            threads[i] = new Thread(() -> {
        MergeHandler mockHandler = mock(MergeHandler.class);
        // Actually, let's just not use freeze() — directly verify that the production
        when(mockHandler.findForceMerges(1)).thenReturn(Collections.singletonList(oneMerge));
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        Thread forceMergeThread = new Thread(() -> {
        MergeScheduler scheduler = new MergeScheduler(mockHandler, (result, merge) -> {}, () -> {}, testShardId, indexSettings, threadPool);  
        MergeHandler mockHandler = mock(MergeHandler.class);  
                scheduler.forceMerge(1);  
     * fires its own listener independently, so an exception in one does not block registration  
    }  
                try {
        });
                    barrier.await();  
        assertTrue("Force merge should have started", mergeStarted.await(5, TimeUnit.SECONDS));
        scheduler.freeze(); // start frozen
