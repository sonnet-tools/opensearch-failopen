public class NativeMemoryUsageServiceTests extends OpenSearchTestCase {
        assertEquals(1024L, service.getBudgetBytes());
    public void testResetForTestingClearsState() {
import java.util.Collections;
        service.refresh();
    @After
    }
            } finally {
        assertTrue(service.hasSnapshotProvider());
        service.setBudgetSupplier(() -> pool);
    }
        for (Thread reader : readers) {
    }
        refresher.start();
        service.refresh();
                }
    }
        Map<Long, Long> second = Map.of(2L, 200L);
    public void testRefreshNullSnapshotFallsBackToEmpty() {
package org.opensearch.search.backpressure;
        Map<Long, Long> snapA = Map.of(1L, 100L);
        // null must NOT erase a working installation.
    public void resetServiceBefore() {
        long pool = 4L * 1024L * 1024L * 1024L;
        }, "nm-service-refresher");
        service.refresh();
        service.setSnapshotSupplier(() -> { throw new RuntimeException("boom"); });
 */
        assertEquals(0L, service.currentBytes(1L));
        assertEquals(3, calls.get());
                    Thread.currentThread().interrupt();
        // a partially-published map (e.g. a NullPointerException from an internal HashMap).
    }
        refresher.join();
        service.refresh();
    public void testCurrentBytesReturnsZeroForUnknownTaskId() {
        service = NativeMemoryUsageService.getInstance();
                start.await();
        service.setSnapshotSupplier(() -> Map.of(1L, 100L));
        assertTrue(service.hasSnapshotProvider());
    }
        assertTrue("threads did not finish in time", done.await(30, TimeUnit.SECONDS));
    public void testDefaultSnapshotIsEmpty() {
        // swap atomically — entry 1 must no longer be present after the second refresh.
        Map<Long, Long> first = Map.of(1L, 100L);
    }
        Map<Long, Long> snapB = Map.of(1L, 200L);
        assertEquals(0L, service.getBudgetBytes());
    }
        service.setSnapshotSupplier(() -> calls.getAndIncrement() == 0 ? first : second);
        service.refresh();
        }
        service.refresh();
import org.opensearch.test.OpenSearchTestCase;
        service.setSnapshotSupplier(() -> Map.of(1L, 100L));
        Thread refresher = new Thread(() -> {
        service.setSnapshotSupplier(() -> snapshot);
    }
    public void testGetBudgetBytesClampsNegative() {
 * Unit tests for {@link NativeMemoryUsageService}.
        snapshot.put(20L, 200L);
/**
 * <p>The service is a process-wide singleton. Each test must reset state in
        assertEquals(2, calls.get());
        AtomicInteger calls = new AtomicInteger();
        service.resetForTesting();
    }
        assertEquals(0L, service.currentBytes(2L));
        service.getBudgetBytes();
        Supplier<Map<Long, Long>> supplier = Collections::emptyMap;
        service.setSnapshotSupplier(() -> null);
        assertEquals(100L, service.currentBytes(1L));
        assertEquals(2, service.snapshotView().size());
import java.util.concurrent.CountDownLatch;
                    }
        assertTrue(service.snapshotView().isEmpty());
            calls.incrementAndGet();
        service.setSnapshotSupplier(supplier);
        // A subsequent currentBytes call must NOT trigger another supplier invocation.
    }
                for (int i = 0; i < iterationsPerReader; i++) {
import java.util.concurrent.TimeUnit;
                        long bytes = service.currentBytes(1L);
        service.setBudgetSupplier(null);
        assertEquals(1, calls.get());
        assertEquals(0L, service.getBudgetBytes());
import java.util.Map;
        assertEquals(100L, service.currentBytes(10L));
import java.util.function.LongSupplier;
        assertEquals(1024L, service.getBudgetBytes());
        service.resetForTesting();
            return 64L;
 * SPDX-License-Identifier: Apache-2.0
    public void testDefaultHasSnapshotProviderIsFalse() {
        assertEquals(0L, service.currentBytes(1L));
            return Collections.emptyMap();
import java.util.concurrent.atomic.AtomicInteger;
        service.setSnapshotSupplier(() -> {
                    start.await();
        // currentBytes for any id with the default supplier must be 0.
        // Singleton contract: every call returns the same instance.
        assertEquals(0L, service.currentBytes(1L));
            reader.join();
        AtomicInteger calls = new AtomicInteger();
        // First refresh loads {1: 100}; second refresh loads {2: 200}. The map reference must
    }
                    for (int i = 0; i < iterationsPerReader; i++) {
        assertEquals(1, calls.get());
 * compatible open source license.
        CountDownLatch done = new CountDownLatch(readerCount + 1);
 */
                try {
        assertTrue(service.snapshotView().isEmpty());
            }
        service.setBudgetSupplier(supplier);
    @Before
        assertFalse(service.hasSnapshotProvider());
    public void testConcurrentRefreshAndRead() throws Exception {
 * don't leak into the next.
        LongSupplier supplier = () -> {
        start.countDown();
    }
        service.setBudgetSupplier(() -> -42L);
        CountDownLatch start = new CountDownLatch(1);
    public void testRefreshReplacesPreviousSnapshot() {
        }
                    service.refresh();
            } catch (InterruptedException e) {
            }, "nm-service-reader-" + r);
                }
                    done.countDown();
/*
        service.getBudgetBytes();
    public void testRefreshCallsSupplierExactlyOnce() {
        // Until a backend opts in, the predicate must report false.
        Supplier<Map<Long, Long>> supplier = Collections::emptyMap;
import java.util.function.Supplier;
            readers[r] = new Thread(() -> {
        };
    public void testSetSnapshotSupplierFlipsHasSnapshotProvider() {
        service.getBudgetBytes();
        AtomicInteger calls = new AtomicInteger();
        assertEquals(0L, service.currentBytes(30L));
    }
        Map<Long, Long> snapshot = new HashMap<>();
        // A throwing supplier (e.g. transient FFM error) must not break the SBP scheduler tick.
        // The service does NOT cache the budget — every getBudgetBytes call routes through the
    }
    }
        assertEquals(pool, service.getBudgetBytes());
        assertFalse(service.hasSnapshotProvider());
        assertEquals(0L, service.currentBytes(randomNonNegativeLong()));
    private NativeMemoryUsageService service;
        int readerCount = 4;
}
    public void testBudgetSupplierInvokedEachCall() {
    }
        // A misbehaving backend that returns null must NOT propagate NPE through the read path.
 *
            try {
        assertEquals(0L, service.getBudgetBytes());
        // Reader threads must always see a consistent snapshot — never an in-flight mutation.
        // We alternate between two non-overlapping snapshots and assert that every read either
        service.currentBytes(1L);
            calls.incrementAndGet();
    public void testSetSnapshotSupplierWithNullIsNoOp() {
                        // Every observation must be 0 (between refreshes, transient), 100 (snapA),
        assertEquals(1024L, service.getBudgetBytes());
    public void testRefreshSwallowsRuntimeExceptionFromSupplier() {
 * The OpenSearch Contributors require contributions made to
        Thread[] readers = new Thread[readerCount];
                Thread.currentThread().interrupt();
                        }
        assertEquals(200L, service.currentBytes(20L));
                } catch (InterruptedException e) {
    }
    public void testDefaultBudgetIsZero() {
        assertEquals(100L, service.currentBytes(1L));
import org.junit.After;
        service.refresh();
        service.currentBytes(2L);
        assertTrue(service.hasSnapshotProvider());
    public void testSetBudgetSupplierWithNullIsNoOp() {
        assertEquals(0L, service.currentBytes(1L));
        assertEquals(0L, service.currentBytes(99L));
        for (int r = 0; r < readerCount; r++) {
                            throw new AssertionError("inconsistent snapshot value: " + bytes);
        service.refresh();
        snapshot.put(10L, 100L);
        service.setSnapshotSupplier(supplier);
    public void testGetInstanceReturnsSameSingleton() {
            readers[r].start();
    public void testGetBudgetBytesPropagatesPositive() {
        service.refresh();
    }
        });
        service.resetForTesting();
        AtomicInteger toggle = new AtomicInteger();
        assertTrue(service.snapshotView().isEmpty());
        assertTrue(service.hasSnapshotProvider());
        int iterationsPerReader = 1_000;
        // invocation per refresh — for the DataFusion backend that maps to one FFM round-trip.
 * {@link #setUp()}/{@link #tearDown()} so suppliers installed by a prior test
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(100L, service.currentBytes(1L));
        service.setBudgetSupplier(() -> 1024L);
        // finds the value from snapshot A OR from snapshot B, never something that would imply
    public void resetServiceAfter() {
        // The SBP service refreshes once per tick. This must translate to exactly one supplier
        // Negative values from a misbehaving supplier must NOT flip threshold math; clamp to 0.
        service.setSnapshotSupplier(null);
    }
        assertEquals(200L, service.currentBytes(2L));
        assertSame(NativeMemoryUsageService.getInstance(), NativeMemoryUsageService.getInstance());
        assertEquals(0L, service.currentBytes(1L));
 *
                } finally {
        service.setBudgetSupplier(() -> 1024L);
        service.setSnapshotSupplier(() -> toggle.getAndIncrement() % 2 == 0 ? snapA : snapB);
        // supplier. This matters because the operator may flip the backend pool size at runtime.
        // Previous supplier must still be active.
import org.junit.Before;
                        if (bytes != 0L && bytes != 100L && bytes != 200L) {
                done.countDown();
    public void testRefreshLoadsSnapshot() {
                        // or 200 (snapB). Anything else implies inconsistent publication.
