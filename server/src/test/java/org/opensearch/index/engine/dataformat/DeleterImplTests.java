                }  
            } catch (Exception e) {  
        deleter.recordBufferedDeletes("doc2");  
        for (int cycle = 0; cycle < 5; cycle++) {
        assertEquals(42L, d.generation());  
                        try {
                exception.set(e);  
        for (int t = 0; t < numWriters; t++) {  
        assertNotNull(drained);
            assertTrue("Drained id '" + id + "' was not successfully recorded", successfullyRecorded.contains(id));
        deleter.recordBufferedDeletes("doc1");
        }
                    }
                for (int i = 0; i < numOperations / 4; i++) {
                deleter.deactivate();  
        assertEquals(3, totalDeletes);
                    if (deleter.isActive()) {  
                }
            final int threadId = t;
 * SPDX-License-Identifier: Apache-2.0
        });
        Queue<String> bufferedDeletes = deleter.deactivate();  
                assertNotNull(bufferedDeletes);  
                } finally {  
                        deleter.recordBufferedDeletes("unguarded" + i);
                            break;
public class DeleterImplTests extends OpenSearchTestCase {  
            });
            executor.submit(() -> {
            }
                } finally {
                    startLatch.await();  
        executor.shutdown();  
        assertTrue(bufferedDeletes.contains("doc2"));
        });  
    public void testRepeatedCloseDeactivateCycles() throws IOException {  
    }
        assertEquals("third", bufferedDeletes.poll());
            });
        executor.submit(() -> {
        assertFalse(deleter.isActive());  
            executor.submit(() -> {
            }
                startLatch.await();  
            } catch (Exception e) {
        deleter.recordBufferedDeletes("first");
            try {
                    }
                    Thread.yield();  
    public void testClose() throws IOException {
                    // Expected for some threads if deleter becomes inactive  
        for (int t = 0; t < numThreads; t++) {  
    }
        CountDownLatch startLatch = new CountDownLatch(1);
                totalDeletes += result.size();
                barrier.await();  
                completeLatch.countDown();  
                            break;
import java.util.concurrent.CountDownLatch;
                        }
    }
                // Expected when deleter becomes inactive
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));  
                Thread.sleep(30);
    }  
        });  
            } finally {  
            } finally {  
            }
        // At least one writer should succeed  
        executor.shutdown();  
import java.util.concurrent.TimeUnit;
            }
            final int threadId = t;
                for (int i = 0; i < numOperations / 4; i++) {
            assertTrue("Successfully recorded id '" + id + "' was lost during deactivation", drainedSet.contains(id));  
        deleter.deactivate();
        executor.submit(() -> {
                }
            when(w.generation()).thenReturn((long) cycle);  
    /** Concurrent recording and deactivation must leave the buffer consistent. */  
                completeLatch.countDown();
                try {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                    for (int j = 0; j < 10; j++) {
                            successfullyRecorded.add(id);  
                        String id = "t" + threadId + "_d" + i;  
                startLatch.await();
            final int threadId = i;  
        // Unguarded recording thread — must either succeed or throw IllegalStateException, never corrupt
                        break;
    public void testCloseIsIdempotent() throws IOException {
    }
                for (int i = 0; i < 100; i++) {
                            break;
                        successCount.incrementAndGet();  
        Writer<?> writer = mock(Writer.class);  
        assertTrue(deleter.isActive());
import org.opensearch.test.OpenSearchTestCase;
    public void testRecordBufferedDeletes() {  
        assertTrue(deleter.recordBufferedDeletes("doc1"));
        int totalDeletes = 0;
        int numOperations = 1000;
        Set<String> seen = new HashSet<>();  
                            if (success) {
            } catch (Exception e) {
                    completeLatch.countDown();
            try {
                    // Expected  
        assertTrue(deleter.recordBufferedDeletes("doc1"));
    }
        int numWriters = 2;  
            executor.submit(() -> {
                barrier.await();
                            }  
    }
                for (int i = 0; i < 50; i++) {
                    try {  
            try {  
            assertTrue(d.isActive());
        for (int i = 0; i < numThreads; i++) {  
import java.util.concurrent.CyclicBarrier;  
import static org.mockito.Mockito.mock;  
            executor.submit(() -> {
        assertEquals(numThreads, bufferedDeletes.size());
        assertTrue(bufferedDeletes.isEmpty());
}
        assertTrue(deleter.isActive());  
    public void testRecordBufferedDeletesWhenInactive() {
                barrier.await();
            Queue<String> drained = d.deactivate();  
        int nonEmptyResults = 0;  
            } catch (Exception e) {  
                } catch (Exception e) {
        executor.shutdown();
        assertEquals(2, bufferedDeletes.size());
                        try {  
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));
    public void testDeactivateWhenAlreadyInactive() {
package org.opensearch.index.engine.dataformat;
        deleter.recordBufferedDeletes("doc1");  
        assertTrue(bufferedDeletes.isEmpty());
        AtomicInteger successCount = new AtomicInteger(0);  
        deleter.recordBufferedDeletes("doc2");  
    }
                        } catch (IllegalStateException e) {  
    }
                    // Unexpected
        Queue<String> drained = drainedRef.get();
            });  
                }  
        });  
    // ===== Basic functionality tests =====
        firstFuture.get(10, TimeUnit.SECONDS);
            d.recordBufferedDeletes("doc" + cycle);  
        assertTrue(writerSuccessCount.get() >= 1);
        AtomicInteger readerSuccessCount = new AtomicInteger(0);
        for (int i = 0; i < numDeletes; i++) {
        int numThreads = 8;
        }
    }  
                try {  
            try {  
        startLatch.countDown();
        });
    @Override
                } finally {
                } catch (Exception e) {
        CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                    barrier.await();
                    Queue<String> result = deleter.deactivate();
        AtomicInteger totalRecorded = new AtomicInteger(0);  
                    for (int i = 0; i < writesPerWriter; i++) {
        assertFalse(deleter.isActive());  
        assertEquals(1L, deleter.generation());
            executor.submit(() -> {
            assertTrue(drained.isEmpty());
        startLatch.countDown();  
        // First recording thread
            });
                        } catch (IllegalStateException e) {  
        // Only one thread should get the buffered deletes, others should get empty queues
                try {
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));  
        assertFalse(deleter.isActive());
                nonEmptyResults++;
        int deletesPerThread = 50;  
    }  
 */  
        }  
                }
                // Expected
                    completeLatch.countDown();  
                }  
        AtomicBoolean deactivateCompleted = new AtomicBoolean(false);
        assertEquals(totalRecorded.get(), drained.size());
        executor.shutdown();
    public void testConcurrentReadWriteLockContention() throws Exception {
        Future<?> deactivateFuture = executor.submit(() -> {
                Thread.sleep(50); // Let other threads run first
        assertFalse(deleter.isActive());
        deactivateFuture.get(10, TimeUnit.SECONDS);  
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
        });
                } catch (Exception e) {
                Thread.sleep(50);
                            deleter.recordBufferedDeletes("w" + threadId + "_" + i);
            d.close();  
        Queue<String> drained = drainedRef.get();  
                exception.set(e);  
                    }
                try {
        }
                } catch (Exception e) {  
                }
                            deleter.recordBufferedDeletes("mixed" + i);
    public void testDeactivateUnderHighWriteContention() throws Exception {
        assertEquals(1, nonEmptyResults);  
        AtomicInteger writerSuccessCount = new AtomicInteger(0);
                    if (i % 100 == 0) Thread.yield();  
    public void testConcurrentMultipleDeactivations() throws Exception {  
        CyclicBarrier barrier = new CyclicBarrier(3);  
import java.util.concurrent.Future;  
        for (int i = 0; i < numThreads; i++) {
            }  
                    try {
            try {  
        CountDownLatch completeLatch = new CountDownLatch(numReaders + numWriters);  
        }  
        assertFalse(deleter.isActive());
            } finally {
                    }  
        CountDownLatch startLatch = new CountDownLatch(1);
                    startLatch.await();  
                }
import java.util.concurrent.atomic.AtomicReference;
                drainedRef.set(deleter.deactivate());
            try {  
            executor.submit(() -> {
    // ===== Race condition: exactly-once draining guarantee =====
        // Second recording thread
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> deleter.recordBufferedDeletes("doc1"));
                // Unexpected
        secondFuture.get(10, TimeUnit.SECONDS);
        assertNull(exception.get());
                    Thread.sleep(100); // Let readers run first
 * The OpenSearch Contributors require contributions made to  
        CountDownLatch startLatch = new CountDownLatch(1);
    }
    // ===== Multi-threading tests =====
        // Add some buffered deletes first
                // Expected
                        try {
        }
        for (int i = 0; i < numReaders; i++) {
        Future<?> secondFuture = executor.submit(() -> {
 * this file be licensed under the Apache-2.0 license or a
        mockWriter = mock(Writer.class);
        assertEquals(numThreads, successCount.get());
                        }  
        deleter.recordBufferedDeletes("doc1");
    }  
        startLatch.countDown();
            if (!result.isEmpty()) {  
        assertEquals(numDeletes, drained.size());
    public void setUp() throws Exception {  
        expectThrows(IllegalStateException.class, () -> deleter.recordBufferedDeletes("final"));  
        // Writer threads (deactivate)
import java.util.HashSet;  
            } finally {
        deleter.recordBufferedDeletes("third");
    }  
                        }
 *
                for (int i = 0; i < numOperations / 4; i++) {  
            } catch (Exception e) {
        }
import java.util.concurrent.atomic.AtomicInteger;  
        Set<String> successfullyRecorded = ConcurrentHashMap.newKeySet();  
                    try {  
                }
                    }
            }
            try {  
                            deleter.recordBufferedDeletes(id);
        for (String id : drained) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);  
            });
                try {
import java.util.List;
                    }  
        assertEquals("first", bufferedDeletes.poll());
        for (Queue<String> result : results) {
                        } catch (IllegalStateException e) {
        CyclicBarrier barrier = new CyclicBarrier(numWriters + 1);
                    if (i % 100 == 0) Thread.yield();
                    if (success) {
import java.util.concurrent.ExecutorService;
            }
    }
                        deleter.recordBufferedDeletes("second" + i);
                        try {
                                readerSuccessCount.incrementAndGet();
            } catch (Exception e) {
                    results.add(result);
                    try {  
        when(writer.generation()).thenReturn(42L);
    // ===== High-volume stress test =====
    public void testConcurrentRecordAndDeactivate() throws Exception {
        // Mixed operations thread: guarded recording
        CountDownLatch startLatch = new CountDownLatch(1);
        });
        }  
        assertFalse(deleter.isActive());
            Writer<?> w = mock(Writer.class);
        int numThreads = 20;
        List<Queue<String>> results = Collections.synchronizedList(new ArrayList<>());
                } catch (Exception e) {
/*  
            }
                    } catch (IllegalStateException e) {
    }
                    if (i % 100 == 0) Thread.yield();
                drainedRef.set(deleter.deactivate());  
                            // Expected when deleter becomes inactive
        ExecutorService executor = Executors.newFixedThreadPool(4);  
        startLatch.countDown();
    }
        Queue<String> bufferedDeletes = deleter.deactivate();
            assertFalse(d.isActive());
import java.util.Set;  
        ExecutorService executor = Executors.newFixedThreadPool(numWriters + 1);
                        deleter.recordBufferedDeletes("first" + i);
                    barrier.await();
        int numReaders = 10;
        }  
    public void testGenerationMatchesWriter() {
import java.util.concurrent.Executors;
        for (String id : drainedSet) {
                    startLatch.await();  
        Queue<String> bufferedDeletes = deleter.deactivate();
                    } catch (IllegalStateException e) {  
                startLatch.await();
                try {  
    public void testRecordBufferedDeletesDuplicateIds() {  
        }
        Future<?> firstFuture = executor.submit(() -> {
        CountDownLatch completeLatch = new CountDownLatch(4);
                startLatch.await();
                    for (int i = 0; i < deletesPerThread; i++) {
        assertNotNull(drained);  
                    }
                        Thread.yield();
            });
        // Final state should be inactive
                // Expected when deleter becomes inactive  
        int numThreads = 5;  
                    }
    public void testStateConsistencyAfterConcurrentOperations() throws Exception {
        assertTrue(bufferedDeletes.contains("doc1"));  
        ExecutorService executor = Executors.newFixedThreadPool(3);
            }  
            }  
        deleter.close();  
            try {  
                completeLatch.countDown();
                        }  
                completeLatch.countDown();
        // Deactivation thread  
import java.util.ArrayList;
        deleter.close();  
            assertTrue(deleter.recordBufferedDeletes("doc" + i));  
            DeleterImpl<Writer<?>> d = new DeleterImpl<>(w);
        }
        executor.submit(() -> {
        deleter = new DeleterImpl<>(mockWriter);
        assertTrue(deactivateCompleted.get());
                    Thread.yield();  
    public void testDeactivate() {
                        break;
        assertTrue(exception.getMessage().contains("Cannot record a delete on a closed deleter"));
                            totalRecorded.incrementAndGet();
                    }
                            boolean success = deleter.recordBufferedDeletes("buffered" + threadId + "_" + j);  
    private Writer<?> mockWriter;
        Queue<String> bufferedDeletes = deleter.deactivate();  
import java.util.concurrent.ConcurrentHashMap;
                    completeLatch.countDown();  
                Queue<String> bufferedDeletes = deleter.deactivate();
        executor.submit(() -> {
                        break;
import java.util.Collections;
                }
            } catch (Exception e) {
        // Buffer-only thread
        CountDownLatch completeLatch = new CountDownLatch(numThreads);  
                deactivateCompleted.set(true);
        executor.shutdown();
                    boolean success = deleter.recordBufferedDeletes("doc" + threadId);
        assertEquals(2, bufferedDeletes.size());
    }  
                }
                    completeLatch.countDown();
        executor.shutdown();  
    }
                        // Expected when deleter becomes inactive  
        int numDeletes = 10_000;
    public void testBasicFunctionality() {  
import java.util.Queue;
        Queue<String> bufferedDeletes = deleter.deactivate();
        assertTrue(completeLatch.await(30, TimeUnit.SECONDS));  
        deleter.recordBufferedDeletes("doc3");
        Set<String> drainedSet = new HashSet<>(drained);  
                        break; // Deleter became inactive  
        executor.shutdown();
        AtomicReference<Exception> exception = new AtomicReference<>();
        assertTrue(deleter.recordBufferedDeletes("doc1"));
        assertFalse(deleter.isActive());
                    // Expected
        Queue<String> drained = deleter.deactivate();  
        CountDownLatch completeLatch = new CountDownLatch(numThreads);
        // Any subsequent operations should fail appropriately
        int numWriters = 16;
                barrier.await();
        assertFalse(deleter.isActive());  
            assertTrue("Duplicate id found: " + id, seen.add(id));
        // Reader threads (recordBufferedDeletes holds the read lock)
        super.setUp();
        for (int i = 0; i < numWriters; i++) {  
                    writerSuccessCount.incrementAndGet();  
        deleter.deactivate();  
        assertTrue(completeLatch.await(15, TimeUnit.SECONDS));
                barrier.await();
import java.util.concurrent.atomic.AtomicBoolean;
            } catch (Exception e) {
        AtomicReference<Queue<String>> drainedRef = new AtomicReference<>();
                } finally {
    private DeleterImpl<Writer<?>> deleter;  
    public void testConcurrentBufferedDeleteRecording() throws Exception {
        deleter.recordBufferedDeletes("second");  
        ExecutorService executor = Executors.newFixedThreadPool(numThreads + 1);
        int writesPerWriter = 100;  
    public void testHighVolumeBufferedDeletesThenDrain() {  
        Queue<String> bufferedDeletes = deleter.deactivate();
        AtomicReference<Queue<String>> drainedRef = new AtomicReference<>();
    }  
                    } catch (IllegalStateException e) {
                } catch (Exception e) {  
                        } catch (IllegalStateException e) {
        for (String id : successfullyRecorded) {
        executor.submit(() -> {
                    } catch (IllegalStateException e) {
        });
                    deleter.deactivate();
    public void testDeactivatePreservesOrder() {
                    startLatch.await();  
import static org.mockito.Mockito.when;
                exception.set(e);  
    public void testBufferedDeletesNotLostDuringConcurrentDeactivation() throws Exception {
                        // Expected when deleter becomes inactive  
 * compatible open source license.
        assertFalse(deleter.isActive());
        when(mockWriter.generation()).thenReturn(1L);  
        executor.submit(() -> {  
                Thread.sleep(200); // Let other threads run
            try {
                    // Unexpected
        assertTrue(deleter.isActive());
        }  
        DeleterImpl<Writer<?>> d = new DeleterImpl<>(writer);
                    // Some failures expected
            final int threadId = i;  
            } catch (Exception e) {
    }
        // Deactivate thread
        deleter.close();
                // Unexpected
import java.io.IOException;  
    public void testDeactivateWithNoBufferedDeletes() {
        });
                        deleter.recordBufferedDeletes("buffer" + i);
        ExecutorService executor = Executors.newFixedThreadPool(numReaders + numWriters);
        assertEquals("second", bufferedDeletes.poll());  
        assertTrue(deleter.recordBufferedDeletes("doc2"));
