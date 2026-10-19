        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
            count++;
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 1);
                    barrier.await();  
        queue.add("b");
        assertNull(queue.poll(e -> false));
    }
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 4);  
        queue.add(2);  
        assertEquals(Integer.valueOf(3), queue.poll(e -> true));
        queue.add("a");
        assertNotNull(first);
        while ((entry = queue.poll(e -> true)) != null) {
        queue.add(4);  // compatible and canSelect=true  
        queue.add(3);
        Integer result = queue.pollAndDropIncompatible(n -> true, n -> true);
        // Drop 0-9 as incompatible, select first compatible entry (>= 10)  
        assertNull(queue.poll(n -> n % 2 == 0));  
 * this file be licensed under the Apache-2.0 license or a
        );
        assertEquals("b", queue.poll(e -> true));
        assertEquals(count, polled.get());
            queue.add(i);  
        Integer result = queue.pollAndDropIncompatible(
        // Compatible: even numbers. canSelect: always true.  
        CountDownLatch pollLatch = new CountDownLatch(numThreads);
        queue.add(2);
        queue.add(5);  
                    }  
        // Consumer threads  
            n -> n % 2 == 0,       // compatible: even  
        }  
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        // 1 was rejected (removed), 3 still in queue (after the match, not scanned)  
        assertEquals("a", queue.poll(e -> true));  
    }  
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);  
 * Tests for {@link ConcurrentQueue}.  
            new Thread(() -> {
        }
    }
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 4);
    public void testMaxConcurrency() {
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, ConcurrentQueue.MIN_CONCURRENCY);
    }
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        queue.add("a");  
        assertNull(queue.poll(e -> true));  
    public void testPollAndDropIncompatibleSkipsCompatibleButUnselectable() {
        // Entry should still be there
        pollLatch.await();  
        assertEquals(Integer.valueOf(3), queue.poll(e -> true));
        assertEquals(Integer.valueOf(2), queue.poll(e -> true));
import java.util.concurrent.CyclicBarrier;
        Integer entry;  
        // Remaining: 1, 3
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
    public void testPollAndDropIncompatibleMultipleStripes() {  
        assertEquals(numThreads * itemsPerThread, totalPolled.get());
    public void testPollPredicateAlwaysFalse() {
        // With higher concurrency, entries distribute across stripes
import java.util.LinkedList;  
                } finally {  
        assertNull(result);
                } catch (Exception e) {
                        queue.add(threadId * itemsPerThread + i);
        AtomicInteger totalPolled = new AtomicInteger();
        assertNull(queue.poll(e -> true));  
/*  
                    addLatch.await(); // Wait for all adds to complete
    public void testConcurrencyBoundsHigh() {
    }  
        assertNull(queue.poll(e -> true)); // 1 was removed
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);  
 * The OpenSearch Contributors require contributions made to  
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
        queue.add(1);
                    addLatch.countDown();
    public void testPollAndDropIncompatibleAllIncompatible() {
        for (int t = 0; t < numThreads; t++) {
                try {  
                }
        queue.add("a");
/**
        assertEquals(Integer.valueOf(1), queue.poll(e -> true));
 *
                    throw new RuntimeException(e);
        }
        assertEquals(Integer.valueOf(4), result);  
public class ConcurrentQueueTests extends OpenSearchTestCase {
        assertTrue(first >= 10);  
        // 1 was rejected (removed), 2 should still be in queue (compatible but not selectable)
        assertEquals("a", queue.poll(e -> true));
        for (int i = 0; i < 20; i++) {
        Integer result = queue.pollAndDropIncompatible(n -> n % 2 == 0, n -> true);
    }
        queue.add(1);
                    Integer item;  
                try {
        CountDownLatch addLatch = new CountDownLatch(numThreads);  
    }  
    }
    }
    public void testPollAndDropIncompatibleEmptyQueue() {
        // All removed as incompatible
    }
    public void testPollAndDropIncompatibleReturnsCompatibleAndDropsIncompatible() {  
        for (int t = 0; t < numThreads; t++) {
    public void testAddAndPollSingleThread() {
                    for (int i = 0; i < itemsPerThread; i++) {
        queue.add(3);
        int numThreads = 4;  
        assertEquals("b", queue.poll(e -> true));  
        // Poll all remaining entries
        CyclicBarrier barrier = new CyclicBarrier(numThreads * 2);
    public void testConcurrencyBoundsLow() {  
    }
        assertTrue(e.getMessage().contains("concurrency must be in"));
        queue.add(2);  // compatible but canSelect=false
        assertNull(queue.poll(e -> true));
        Integer first = queue.pollAndDropIncompatible(n -> n >= 10, n -> true);
    }  
        assertEquals(Integer.valueOf(2), queue.poll(n -> n % 2 == 0));
        queue.add("a");  
        assertNull(queue.poll(e -> true));
        assertEquals(10, count);
    public void testPollReturnsNullOnEmpty() {
        assertTrue(queue.remove("a"));
            queue.add(i);  
    public void testPollWithPredicateFiltering() {
        Integer result = queue.pollAndDropIncompatible(n -> n % 2 == 0, n -> true);
    public void testRemoveNonExistentEntry() {  
        assertEquals("a", queue.poll(e -> true));
                } catch (Exception e) {
        assertTrue(e.getMessage().contains("concurrency must be in"));
        assertEquals(Integer.valueOf(2), result);
                } finally {  
        queue.add(1);  
        assertFalse(queue.remove("a"));  
            polled.incrementAndGet();
        // Poll only even numbers  
import org.opensearch.test.OpenSearchTestCase;
                }
        assertFalse(queue.remove("z"));  
    public void testRemoveExistingEntry() {  
        assertNull(result);  
        }
    }
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 4);
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);  
package org.opensearch.common.queue;
 * compatible open source license.
        for (int i = 0; i < count; i++) {
            }).start();  
        assertNull(queue.poll(e -> true));
import java.util.concurrent.CountDownLatch;
            }).start();  
}  
    public void testMultipleStripes() {
            new Thread(() -> {
                    throw new RuntimeException(e);
        assertEquals("a", queue.poll(e -> true));
            n -> n > 3             // canSelect: > 3
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
    // --- Tests for pollWithRejects ---
        assertEquals("a", queue.poll(e -> true));
        }
        queue.add("a");  
        // Producer threads
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 8);  
        while (queue.poll(e -> true) != null) {
        queue.add("b");  
    }
 */
        int count = 100;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ConcurrentQueue<>(LinkedList::new, 257));  
                    }  
    }  
                        totalPolled.incrementAndGet();
    public void testConcurrentAddAndPoll() throws Exception {
 */  
        queue.add(3);
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, ConcurrentQueue.MAX_CONCURRENCY);
    }
        int count = 1; // counting the first result  
    public void testMinConcurrency() {
        AtomicInteger polled = new AtomicInteger();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ConcurrentQueue<>(LinkedList::new, 0));
    public void testRemoveFromEmpty() {
    }
        int itemsPerThread = 250;
                    while ((item = queue.poll(e -> true)) != null) {
    }
 * SPDX-License-Identifier: Apache-2.0
        queue.add(1);  // incompatible
import java.util.concurrent.atomic.AtomicInteger;  
        queue.add("a");  
                    barrier.await();
            final int threadId = t;  
        }  
                    pollLatch.countDown();
