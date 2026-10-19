        // Add some buffered deletes first
 * The OpenSearch Contributors require contributions made to
        }
        executor.shutdown();
                    // Unexpected
            } finally {
                    for (int j = 0; j < 10; j++) {
        executor.shutdown();
            when(w.generation()).thenReturn((long) cycle);
                    // Unexpected
    }
    public void testDeactivateWhenAlreadyInactive() {
        AtomicReference<Queue<String>> drainedRef = new AtomicReference<>();
        executor.submit(() -> {
 * compatible open source license.
                            break;
        assertTrue(bufferedDeletes.isEmpty());
            } finally {
                    if (i % 100 == 0) Thread.yield();
        // Writer threads (deactivate)
            try {
                // Unexpected
        assertEquals(1L, deleter.generation());
                for (int i = 0; i < numOperations / 4; i++) {
    public void setUp() throws Exception {
        assertTrue(deactivateCompleted.get());
        deleter.recordBufferedDeletes("doc1");
        }
/*
                    startLatch.await();
            });
    }
                exception.set(e);
            assertTrue("Drained id '" + id + "' was not successfully recorded", successfullyRecorded.contains(id));
                            deleter.recordBufferedDeletes(id);
        int numOperations = 1000;
    }
        // Deactivation thread
                    completeLatch.countDown();
        deleter.close();
        }
    }
        startLatch.countDown();
                        } catch (IllegalStateException e) {
                    startLatch.await();
import java.util.concurrent.CyclicBarrier;
            } catch (Exception e) {
        assertTrue(writerSuccessCount.get() >= 1);
                        try {
        ExecutorService executor = Executors.newFixedThreadPool(3);
            executor.submit(() -> {
    /** Concurrent recording and deactivation must leave the buffer consistent. */
                    deleter.deactivate();
            }
                        } catch (IllegalStateException e) {
                }
        int numWriters = 16;
        // Any subsequent operations should fail appropriately
                deleter.deactivate();
                            deleter.recordBufferedDeletes("w" + threadId + "_" + i);
        CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
            executor.submit(() -> {
        executor.shutdown();
    }
        Queue<String> drained = deleter.deactivate();
        deleter.deactivate();
    public void testRecordBufferedDeletes() {
        assertEquals(1, nonEmptyResults);
        for (int cycle = 0; cycle < 5; cycle++) {
import java.util.concurrent.atomic.AtomicReference;
            if (!result.isEmpty()) {
        deleter.recordBufferedDeletes("doc2");
        executor.submit(() -> {
            } finally {
            try {
                    try {
                } finally {
            assertFalse(d.isActive());
                    // Expected
import static org.mockito.Mockito.when;
            } catch (Exception e) {
            }
        executor.submit(() -> {
        Set<String> drainedSet = new HashSet<>(drained);
        deactivateFuture.get(10, TimeUnit.SECONDS);
            } catch (Exception e) {
import java.util.concurrent.ConcurrentHashMap;
                // Expected
        }
        CountDownLatch completeLatch = new CountDownLatch(numThreads);
        deleter.recordBufferedDeletes("doc1");
                    completeLatch.countDown();
        when(writer.generation()).thenReturn(42L);
        assertTrue(deleter.isActive());
            }
                }
                }
        executor.submit(() -> {
                        successCount.incrementAndGet();
                Thread.sleep(50);
                Queue<String> bufferedDeletes = deleter.deactivate();
                    Thread.sleep(100); // Let readers run first
        CountDownLatch startLatch = new CountDownLatch(1);
    // ===== Basic functionality tests =====
    }
        for (String id : drained) {
                } catch (Exception e) {
    }
        int deletesPerThread = 50;
        AtomicReference<Exception> exception = new AtomicReference<>();
        });
                    if (deleter.isActive()) {
            try {
                        // Expected when deleter becomes inactive
        assertFalse(deleter.isActive());
        assertEquals(2, bufferedDeletes.size());
    }
                        break;
    // ===== Multi-threading tests =====
            } catch (Exception e) {
                }
    public void testBufferedDeletesNotLostDuringConcurrentDeactivation() throws Exception {
                assertNotNull(bufferedDeletes);
                    results.add(result);
    public void testCloseIsIdempotent() throws IOException {
    public void testRepeatedCloseDeactivateCycles() throws IOException {
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
        int numWriters = 2;
    public void testStateConsistencyAfterConcurrentOperations() throws Exception {
            } catch (Exception e) {
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
            assertTrue("Successfully recorded id '" + id + "' was lost during deactivation", drainedSet.contains(id));
        Set<String> successfullyRecorded = ConcurrentHashMap.newKeySet();
            final int threadId = t;
        // Second recording thread
                }
                            break;
            }
                    // Expected for some threads if deleter becomes inactive
                }
                            // Expected when deleter becomes inactive
        assertFalse(deleter.isActive());
        Queue<String> bufferedDeletes = deleter.deactivate();
                            if (success) {
        CyclicBarrier barrier = new CyclicBarrier(3);
                    completeLatch.countDown();
                    } catch (IllegalStateException e) {
        assertEquals("third", bufferedDeletes.poll());
                            deleter.recordBufferedDeletes("mixed" + i);
            } finally {
        assertEquals(3, totalDeletes);
        AtomicInteger successCount = new AtomicInteger(0);
                        // Expected when deleter becomes inactive
            executor.submit(() -> {
                    // Some failures expected
import java.util.Set;
        int numThreads = 8;
        // First recording thread
        assertFalse(deleter.isActive());
                for (int i = 0; i < numOperations / 4; i++) {
        deleter.recordBufferedDeletes("doc3");
        // Mixed operations thread: guarded recording
                nonEmptyResults++;
                    for (int i = 0; i < deletesPerThread; i++) {
                } finally {
                        }
    }
            assertTrue("Duplicate id found: " + id, seen.add(id));
        }
            assertTrue(drained.isEmpty());
        executor.submit(() -> {
        CountDownLatch completeLatch = new CountDownLatch(numReaders + numWriters);
            try {
    public void testRecordBufferedDeletesDuplicateIds() {
                barrier.await();
        Queue<String> bufferedDeletes = deleter.deactivate();
                barrier.await();
        deleter.recordBufferedDeletes("first");
                startLatch.await();
        // Only one thread should get the buffered deletes, others should get empty queues
        int totalDeletes = 0;
        assertFalse(deleter.isActive());
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        assertFalse(deleter.isActive());
                try {
    public void testDeactivateUnderHighWriteContention() throws Exception {
        deleter.deactivate();
import java.util.concurrent.TimeUnit;
    // ===== Race condition: exactly-once draining guarantee =====
        assertTrue(deleter.isActive());
        for (int i = 0; i < numThreads; i++) {
                Thread.sleep(200); // Let other threads run
                        deleter.recordBufferedDeletes("buffer" + i);
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> deleter.recordBufferedDeletes("doc1"));
        assertFalse(deleter.isActive());
            }
                    }
        deleter = new DeleterImpl<>(mockWriter);
    }
                    Thread.yield();
                exception.set(e);
        assertTrue(bufferedDeletes.isEmpty());
                        break; // Deleter became inactive
                try {
        }
        // Unguarded recording thread — must either succeed or throw IllegalStateException, never corrupt
        deleter.recordBufferedDeletes("doc2");
                    Queue<String> result = deleter.deactivate();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                startLatch.await();
            } catch (Exception e) {
        assertEquals(42L, d.generation());
    private DeleterImpl<Writer<?>> deleter;
                } finally {
        CyclicBarrier barrier = new CyclicBarrier(numWriters + 1);
        Writer<?> writer = mock(Writer.class);
                            successfullyRecorded.add(id);
                            totalRecorded.incrementAndGet();
                    boolean success = deleter.recordBufferedDeletes("doc" + threadId);
                    writerSuccessCount.incrementAndGet();
                completeLatch.countDown();
        });
                        break;
            });
        assertTrue(completeLatch.await(15, TimeUnit.SECONDS));
                    } catch (IllegalStateException e) {
    public void testDeactivatePreservesOrder() {
        });
                    Thread.yield();
import java.util.concurrent.atomic.AtomicBoolean;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads + 1);
        AtomicInteger writerSuccessCount = new AtomicInteger(0);
            executor.submit(() -> {
                barrier.await();
        }
        for (int i = 0; i < numDeletes; i++) {
                for (int i = 0; i < numOperations / 4; i++) {
                            break;
                        String id = "t" + threadId + "_d" + i;
        Set<String> seen = new HashSet<>();
        });
            } catch (Exception e) {
    public void testHighVolumeBufferedDeletesThenDrain() {
        startLatch.countDown();
                }
    public void testGenerationMatchesWriter() {
                    }
        executor.shutdown();
        for (String id : successfullyRecorded) {
    }
                completeLatch.countDown();
        executor.shutdown();
        deleter.recordBufferedDeletes("third");
        Queue<String> drained = drainedRef.get();
                }
import java.util.concurrent.Future;
        assertTrue(completeLatch.await(30, TimeUnit.SECONDS));
                completeLatch.countDown();
    public void testDeactivate() {
        Queue<String> drained = drainedRef.get();
            d.close();
import java.util.List;
        // Buffer-only thread
                totalDeletes += result.size();
                        Thread.yield();
    }
                Thread.sleep(30);
                        break;
        assertEquals(numThreads, successCount.get());
        int nonEmptyResults = 0;
        ExecutorService executor = Executors.newFixedThreadPool(numReaders + numWriters);
                        }
                    if (i % 100 == 0) Thread.yield();
        assertTrue(deleter.isActive());
            }
        deleter.recordBufferedDeletes("doc1");
    public void testConcurrentMultipleDeactivations() throws Exception {
        CountDownLatch startLatch = new CountDownLatch(1);
                    barrier.await();
        deleter.close();
            Writer<?> w = mock(Writer.class);
        assertNull(exception.get());
        assertTrue(bufferedDeletes.contains("doc2"));
import java.util.Queue;
        Queue<String> bufferedDeletes = deleter.deactivate();
        super.setUp();
        }
                    } catch (IllegalStateException e) {
import java.util.HashSet;
        executor.submit(() -> {
        });
        for (int i = 0; i < numReaders; i++) {
                    }
                } catch (Exception e) {
                    if (success) {
                try {
        for (Queue<String> result : results) {
 *
        deleter.close();
        mockWriter = mock(Writer.class);
                try {
                            }
            try {
            });
                    }
import java.util.concurrent.ExecutorService;
package org.opensearch.index.engine.dataformat;
    }
            try {
            }
                        try {
 * SPDX-License-Identifier: Apache-2.0
        startLatch.countDown();
        // Final state should be inactive
                try {
                    try {
        Future<?> firstFuture = executor.submit(() -> {
            Queue<String> drained = d.deactivate();
        assertTrue(exception.getMessage().contains("Cannot record a delete on a closed deleter"));
        expectThrows(IllegalStateException.class, () -> deleter.recordBufferedDeletes("final"));
        for (String id : drainedSet) {
                    for (int i = 0; i < writesPerWriter; i++) {
        assertFalse(deleter.isActive());
        ExecutorService executor = Executors.newFixedThreadPool(numWriters + 1);
            final int threadId = i;
        executor.shutdown();
        assertFalse(deleter.isActive());
                    if (i % 100 == 0) Thread.yield();
        ExecutorService executor = Executors.newFixedThreadPool(4);
import java.io.IOException;
            try {
        });
                        }
            }
                    startLatch.await();
                } catch (Exception e) {
        executor.shutdown();
        assertFalse(deleter.isActive());
            } catch (Exception e) {
        AtomicReference<Queue<String>> drainedRef = new AtomicReference<>();
                        } catch (IllegalStateException e) {
    public void testClose() throws IOException {
                    }
                }
        }
    public void testRecordBufferedDeletesWhenInactive() {
            assertTrue(deleter.recordBufferedDeletes("doc" + i));
        for (int i = 0; i < numWriters; i++) {
                    // Expected
            } catch (Exception e) {
        });
        for (int t = 0; t < numThreads; t++) {
import java.util.concurrent.CountDownLatch;
        // Reader threads (recordBufferedDeletes holds the read lock)
                exception.set(e);
                    }
        AtomicInteger readerSuccessCount = new AtomicInteger(0);
        CountDownLatch completeLatch = new CountDownLatch(4);
        Queue<String> bufferedDeletes = deleter.deactivate();
            executor.submit(() -> {
        }
import java.util.ArrayList;
                // Unexpected
        assertTrue(deleter.recordBufferedDeletes("doc2"));
        int writesPerWriter = 100;
                drainedRef.set(deleter.deactivate());
                startLatch.await();
    }
import static org.mockito.Mockito.mock;
                drainedRef.set(deleter.deactivate());
    @Override
        DeleterImpl<Writer<?>> d = new DeleterImpl<>(writer);
        });
public class DeleterImplTests extends OpenSearchTestCase {
            }
            });
        startLatch.countDown();
                barrier.await();
        deleter.recordBufferedDeletes("second");
                        }
                for (int i = 0; i < 50; i++) {
        when(mockWriter.generation()).thenReturn(1L);
                deactivateCompleted.set(true);
 * this file be licensed under the Apache-2.0 license or a
        CountDownLatch startLatch = new CountDownLatch(1);
        Queue<String> bufferedDeletes = deleter.deactivate();
                } catch (Exception e) {
        int numThreads = 20;
                    try {
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicInteger;
        firstFuture.get(10, TimeUnit.SECONDS);
        for (int t = 0; t < numWriters; t++) {
                } catch (Exception e) {
        int numThreads = 5;
                        deleter.recordBufferedDeletes("second" + i);
import org.opensearch.test.OpenSearchTestCase;
    public void testConcurrentRecordAndDeactivate() throws Exception {
    }
    }
 */
        Queue<String> bufferedDeletes = deleter.deactivate();
                for (int i = 0; i < 100; i++) {
        // At least one writer should succeed
        int numDeletes = 10_000;
        assertNotNull(drained);
        assertTrue(deleter.recordBufferedDeletes("doc1"));
                    startLatch.await();
            }
        Future<?> deactivateFuture = executor.submit(() -> {
            final int threadId = t;
        }
        assertTrue(deleter.recordBufferedDeletes("doc1"));
                }
        assertEquals(2, bufferedDeletes.size());
    private Writer<?> mockWriter;
            });
            assertTrue(d.isActive());
        assertEquals(totalRecorded.get(), drained.size());
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));
                }
        int numReaders = 10;
        secondFuture.get(10, TimeUnit.SECONDS);
        AtomicInteger totalRecorded = new AtomicInteger(0);
        AtomicBoolean deactivateCompleted = new AtomicBoolean(false);
                startLatch.await();
    public void testConcurrentBufferedDeleteRecording() throws Exception {
            final int threadId = i;
                    barrier.await();
                    }
                        deleter.recordBufferedDeletes("first" + i);
        }
                completeLatch.countDown();
import java.util.Collections;
        assertTrue(deleter.recordBufferedDeletes("doc1"));
                barrier.await();
    }
            try {
    }
                    completeLatch.countDown();
        assertEquals("second", bufferedDeletes.poll());
        assertEquals(numThreads, bufferedDeletes.size());
                Thread.sleep(50); // Let other threads run first
            try {
            executor.submit(() -> {
                        try {
            });
        Future<?> secondFuture = executor.submit(() -> {
import java.util.concurrent.Executors;
                    try {
    }
        CountDownLatch startLatch = new CountDownLatch(1);
                                readerSuccessCount.incrementAndGet();
        });
        // Deactivate thread
                // Expected
                        deleter.recordBufferedDeletes("unguarded" + i);
                    } catch (IllegalStateException e) {
    public void testBasicFunctionality() {
        assertEquals(numDeletes, drained.size());
                            boolean success = deleter.recordBufferedDeletes("buffered" + threadId + "_" + j);
                    }
        CountDownLatch completeLatch = new CountDownLatch(numThreads);
            DeleterImpl<Writer<?>> d = new DeleterImpl<>(w);
        assertNotNull(drained);
                        try {
            d.recordBufferedDeletes("doc" + cycle);
    }
                // Expected when deleter becomes inactive
        assertEquals("first", bufferedDeletes.poll());
                    }
                        } catch (IllegalStateException e) {
                try {
}
    // ===== High-volume stress test =====
    }
    public void testDeactivateWithNoBufferedDeletes() {
                } finally {
    public void testConcurrentReadWriteLockContention() throws Exception {
        assertTrue(bufferedDeletes.contains("doc1"));
        List<Queue<String>> results = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < numThreads; i++) {
                // Expected when deleter becomes inactive
                } catch (Exception e) {
