        service.refresh();
        assertEquals(0L, service.currentBytes(1L));
        long pool = 4L * 1024L * 1024L * 1024L;
                } catch (InterruptedException e) {  
        service.setBudgetSupplier(supplier);
        service.refresh();  
        assertTrue(service.hasSnapshotProvider());
}
import java.util.Collections;
    public void testCurrentBytesReturnsZeroForUnknownTaskId() {
    }
        assertEquals(100L, service.currentBytes(1L));
    }
            calls.incrementAndGet();
 * The OpenSearch Contributors require contributions made to  
    public void resetServiceBefore() {
        assertEquals(200L, service.currentBytes(2L));
        // A misbehaving backend that returns null must NOT propagate NPE through the read path.  
        service.refresh();  
        service = NativeMemoryUsageService.getInstance();  
    }  
        assertEquals(1, calls.get());
        Map<Long, Long> snapB = Map.of(1L, 200L);  
        assertTrue(service.hasSnapshotProvider());  
        service.currentBytes(2L);  
        assertEquals(2, calls.get());
    }
    @After
        // Reader threads must always see a consistent snapshot — never an in-flight mutation.
        // Until a backend opts in, the predicate must report false.
        service.setSnapshotSupplier(() -> {  
import org.junit.Before;  
 * don't leak into the next.
        assertSame(NativeMemoryUsageService.getInstance(), NativeMemoryUsageService.getInstance());
    public void testConcurrentRefreshAndRead() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
            readers[r] = new Thread(() -> {
                        long bytes = service.currentBytes(1L);
                    start.await();  
        refresher.start();  
        snapshot.put(20L, 200L);
            }
        service.getBudgetBytes();  
    public void testRefreshCallsSupplierExactlyOnce() {
                }
        Thread[] readers = new Thread[readerCount];
        }
    }  
    }
    public void testRefreshSwallowsRuntimeExceptionFromSupplier() {
    }  
                    for (int i = 0; i < iterationsPerReader; i++) {
                    service.refresh();
        // a partially-published map (e.g. a NullPointerException from an internal HashMap).
    public void testRefreshReplacesPreviousSnapshot() {  
        for (Thread reader : readers) {
import java.util.concurrent.TimeUnit;  
        AtomicInteger calls = new AtomicInteger();
        assertEquals(1, calls.get());
            calls.incrementAndGet();
                }
    }  
    public void testGetInstanceReturnsSameSingleton() {  
        AtomicInteger calls = new AtomicInteger();
        // A throwing supplier (e.g. transient FFM error) must not break the SBP scheduler tick.
        service.setBudgetSupplier(() -> pool);  
        LongSupplier supplier = () -> {  
        // supplier. This matters because the operator may flip the backend pool size at runtime.
        assertEquals(0L, service.getBudgetBytes());  
 */
    public void testDefaultBudgetIsZero() {
            readers[r].start();  
        assertEquals(2, service.snapshotView().size());
 * SPDX-License-Identifier: Apache-2.0
    public void testSetSnapshotSupplierFlipsHasSnapshotProvider() {
    @Before
/**
        service.refresh();
/*  
        service.refresh();
        Map<Long, Long> second = Map.of(2L, 200L);
    }  
    private NativeMemoryUsageService service;
        assertEquals(0L, service.currentBytes(99L));
        service.refresh();  
    public void testRefreshNullSnapshotFallsBackToEmpty() {
        assertEquals(0L, service.currentBytes(1L));  
                        }
    public void testGetBudgetBytesPropagatesPositive() {
        assertTrue("threads did not finish in time", done.await(30, TimeUnit.SECONDS));
                    done.countDown();  
        service.getBudgetBytes();
        service.setBudgetSupplier(() -> 1024L);  
        service.setSnapshotSupplier(() -> null);
        assertEquals(0L, service.currentBytes(1L));
        // finds the value from snapshot A OR from snapshot B, never something that would imply  
    public void testDefaultSnapshotIsEmpty() {
        assertTrue(service.snapshotView().isEmpty());
        service.setBudgetSupplier(() -> -42L);
        assertEquals(0L, service.getBudgetBytes());
    }  
    public void testSetBudgetSupplierWithNullIsNoOp() {
 * compatible open source license.
        service.getBudgetBytes();
        // Negative values from a misbehaving supplier must NOT flip threshold math; clamp to 0.  
        assertEquals(0L, service.currentBytes(1L));
 */  
import java.util.function.LongSupplier;
                        // Every observation must be 0 (between refreshes, transient), 100 (snapA),  
        service.resetForTesting();  
        }, "nm-service-refresher");
        assertEquals(1024L, service.getBudgetBytes());
        Thread refresher = new Thread(() -> {  
                            throw new AssertionError("inconsistent snapshot value: " + bytes);  
        AtomicInteger calls = new AtomicInteger();
        service.setBudgetSupplier(null);
        // invocation per refresh — for the DataFusion backend that maps to one FFM round-trip.
        // The service does NOT cache the budget — every getBudgetBytes call routes through the  
import java.util.concurrent.atomic.AtomicInteger;
        service.setSnapshotSupplier(null);
        assertTrue(service.hasSnapshotProvider());
        service.setSnapshotSupplier(() -> Map.of(1L, 100L));
        Supplier<Map<Long, Long>> supplier = Collections::emptyMap;  
        assertEquals(200L, service.currentBytes(20L));  
        assertEquals(1024L, service.getBudgetBytes());
        CountDownLatch start = new CountDownLatch(1);  
                try {
    public void resetServiceAfter() {
                Thread.currentThread().interrupt();
        Map<Long, Long> snapshot = new HashMap<>();
        // Singleton contract: every call returns the same instance.
        assertEquals(100L, service.currentBytes(1L));
        int readerCount = 4;
            return Collections.emptyMap();
    }
        snapshot.put(10L, 100L);  
    public void testRefreshLoadsSnapshot() {
        assertTrue(service.snapshotView().isEmpty());  
    }
        assertEquals(0L, service.currentBytes(randomNonNegativeLong()));
        CountDownLatch done = new CountDownLatch(readerCount + 1);
        // First refresh loads {1: 100}; second refresh loads {2: 200}. The map reference must
public class NativeMemoryUsageServiceTests extends OpenSearchTestCase {  
                start.await();
    }  
                for (int i = 0; i < iterationsPerReader; i++) {  
 * {@link #setUp()}/{@link #tearDown()} so suppliers installed by a prior test  
            return 64L;
        service.refresh();
                        // or 200 (snapB). Anything else implies inconsistent publication.
import org.opensearch.test.OpenSearchTestCase;
        int iterationsPerReader = 1_000;
        Supplier<Map<Long, Long>> supplier = Collections::emptyMap;  
            }, "nm-service-reader-" + r);
        assertEquals(0L, service.currentBytes(2L));
        assertTrue(service.snapshotView().isEmpty());  
        assertFalse(service.hasSnapshotProvider());
    public void testGetBudgetBytesClampsNegative() {
        // Previous supplier must still be active.  
import org.junit.After;
 *
    }
    }
import java.util.function.Supplier;  
        service.setSnapshotSupplier(supplier);
                done.countDown();  
        service.setSnapshotSupplier(() -> { throw new RuntimeException("boom"); });  
        service.refresh();
                        if (bytes != 0L && bytes != 100L && bytes != 200L) {
 *
                    Thread.currentThread().interrupt();
        service.resetForTesting();
        assertEquals(100L, service.currentBytes(10L));
        Map<Long, Long> first = Map.of(1L, 100L);  
            try {
                    }
        assertEquals(0L, service.currentBytes(1L));
        assertFalse(service.hasSnapshotProvider());  
        // A subsequent currentBytes call must NOT trigger another supplier invocation.
        service.currentBytes(1L);
        // We alternate between two non-overlapping snapshots and assert that every read either
 * <p>The service is a process-wide singleton. Each test must reset state in
        Map<Long, Long> snapA = Map.of(1L, 100L);
    }  
        service.setSnapshotSupplier(() -> Map.of(1L, 100L));  
        service.refresh();
    }  
        // currentBytes for any id with the default supplier must be 0.  
        start.countDown();  
import java.util.HashMap;  
        for (int r = 0; r < readerCount; r++) {  
        service.setSnapshotSupplier(() -> snapshot);
        refresher.join();
            reader.join();  
        assertTrue(service.hasSnapshotProvider());
        service.setBudgetSupplier(() -> 1024L);
        assertEquals(1024L, service.getBudgetBytes());
        assertEquals(3, calls.get());
    }
        AtomicInteger toggle = new AtomicInteger();
    public void testSetSnapshotSupplierWithNullIsNoOp() {
        assertEquals(0L, service.currentBytes(30L));
        service.setSnapshotSupplier(() -> calls.getAndIncrement() == 0 ? first : second);  
            } finally {
        });  
        service.resetForTesting();
import java.util.concurrent.CountDownLatch;
                } finally {
import java.util.Map;
        assertEquals(100L, service.currentBytes(1L));  
        // The SBP service refreshes once per tick. This must translate to exactly one supplier  
 * Unit tests for {@link NativeMemoryUsageService}.  
        assertEquals(pool, service.getBudgetBytes());
        service.setSnapshotSupplier(supplier);
        };  
    public void testBudgetSupplierInvokedEachCall() {
    public void testDefaultHasSnapshotProviderIsFalse() {  
        // swap atomically — entry 1 must no longer be present after the second refresh.
package org.opensearch.search.backpressure;
            } catch (InterruptedException e) {  
    public void testResetForTestingClearsState() {
        }
    }  
    }
        service.setSnapshotSupplier(() -> toggle.getAndIncrement() % 2 == 0 ? snapA : snapB);
        // null must NOT erase a working installation.  
        assertEquals(0L, service.getBudgetBytes());
