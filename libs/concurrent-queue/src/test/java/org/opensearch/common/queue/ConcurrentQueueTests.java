    public void testPollWithPredicateFiltering() {
 */
        Integer first = queue.pollAndDropIncompatible(n -> n >= 10, n -> true);
import java.util.concurrent.CountDownLatch;
 * this file be licensed under the Apache-2.0 license or a
    }
                } finally {
    }
                } catch (Exception e) {
        assertEquals(Integer.valueOf(2), queue.poll(e -> true));
        CyclicBarrier barrier = new CyclicBarrier(numThreads * 2);
}
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        }
    }
        assertTrue(e.getMessage().contains("concurrency must be in"));
        assertTrue(first >= 10);
        assertEquals(Integer.valueOf(2), result);
                    barrier.await();
        // Entry should still be there
        queue.add(4);  // compatible and canSelect=true
        queue.add(5);
            }).start();
        assertEquals(Integer.valueOf(2), queue.poll(n -> n % 2 == 0));
        // Producer threads
    }
                    Integer item;
        Integer result = queue.pollAndDropIncompatible(n -> n % 2 == 0, n -> true);
        assertFalse(queue.remove("a"));
    }
        // 1 was rejected (removed), 2 should still be in queue (compatible but not selectable)
        }
                    barrier.await();
        // Consumer threads
    }
    }
            queue.add(i);
/**
        );
        CountDownLatch addLatch = new CountDownLatch(numThreads);
                    }
        assertNull(queue.poll(e -> true));
                    for (int i = 0; i < itemsPerThread; i++) {
    }
            polled.incrementAndGet();
        assertEquals("a", queue.poll(e -> true));
    }
 *
        assertTrue(queue.remove("a"));
        queue.add("a");
    public void testPollReturnsNullOnEmpty() {
    public void testMaxConcurrency() {
        assertNull(result);
        queue.add("a");
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ConcurrentQueue<>(LinkedList::new, 257));
        while (queue.poll(e -> true) != null) {
        queue.add("a");
        assertNull(result);
    }
                    pollLatch.countDown();
import java.util.concurrent.atomic.AtomicInteger;
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
        Integer result = queue.pollAndDropIncompatible(n -> n % 2 == 0, n -> true);
    }
        queue.add(1);
        queue.add("a");
    }
                    throw new RuntimeException(e);
        // Drop 0-9 as incompatible, select first compatible entry (>= 10)
    // --- Tests for pollWithRejects ---
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        assertNull(queue.poll(e -> true));
    public void testPollAndDropIncompatibleEmptyQueue() {
        queue.add(1);  // incompatible
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        assertEquals("b", queue.poll(e -> true));
        // Poll only even numbers
            new Thread(() -> {
        Integer result = queue.pollAndDropIncompatible(n -> true, n -> true);
        queue.add(3);
            }).start();
                        totalPolled.incrementAndGet();
    public void testMinConcurrency() {
        CountDownLatch pollLatch = new CountDownLatch(numThreads);
        int count = 1; // counting the first result
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 1);
 */
    }
        // Compatible: even numbers. canSelect: always true.
        assertEquals("a", queue.poll(e -> true));
                try {
    public void testPollAndDropIncompatibleMultipleStripes() {
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, ConcurrentQueue.MIN_CONCURRENCY);
        // Remaining: 1, 3
    }
    }
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 2);
        // 1 was rejected (removed), 3 still in queue (after the match, not scanned)
        assertEquals(count, polled.get());
        for (int t = 0; t < numThreads; t++) {
    public void testPollPredicateAlwaysFalse() {
        assertEquals(numThreads * itemsPerThread, totalPolled.get());
        assertEquals(Integer.valueOf(3), queue.poll(e -> true));
        for (int i = 0; i < 20; i++) {
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 4);
    public void testMultipleStripes() {
 * The OpenSearch Contributors require contributions made to
        assertNull(queue.poll(e -> false));
        queue.add(1);
        assertNull(queue.poll(e -> true));
 * Tests for {@link ConcurrentQueue}.
import org.opensearch.test.OpenSearchTestCase;
        queue.add("b");
 * compatible open source license.
        assertNull(queue.poll(e -> true));
                    }
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, ConcurrentQueue.MAX_CONCURRENCY);
        // All removed as incompatible
                    addLatch.countDown();
        assertEquals(Integer.valueOf(4), result);
    }
    public void testPollAndDropIncompatibleReturnsCompatibleAndDropsIncompatible() {
                    throw new RuntimeException(e);
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 4);
        assertEquals(10, count);
    public void testRemoveExistingEntry() {
        queue.add("a");
        for (int t = 0; t < numThreads; t++) {
import java.util.LinkedList;
 * SPDX-License-Identifier: Apache-2.0
        Integer result = queue.pollAndDropIncompatible(
            count++;
        int itemsPerThread = 250;
public class ConcurrentQueueTests extends OpenSearchTestCase {
            final int threadId = t;
                }
        int numThreads = 4;
                    addLatch.await(); // Wait for all adds to complete
        queue.add(2);  // compatible but canSelect=false
        // Poll all remaining entries
        int count = 100;
        assertTrue(e.getMessage().contains("concurrency must be in"));
        assertEquals("a", queue.poll(e -> true));
        ConcurrentQueue<String> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        assertEquals(Integer.valueOf(3), queue.poll(e -> true));
        while ((entry = queue.poll(e -> true)) != null) {
                } catch (Exception e) {
        assertEquals(Integer.valueOf(1), queue.poll(e -> true));
    public void testRemoveFromEmpty() {
        }
        assertNotNull(first);
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 4);
        pollLatch.await();
        queue.add("a");
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 8);
                } finally {
        Integer entry;
    }
    public void testAddAndPollSingleThread() {
            n -> n > 3             // canSelect: > 3
        AtomicInteger totalPolled = new AtomicInteger();
        assertEquals("a", queue.poll(e -> true));
    public void testPollAndDropIncompatibleSkipsCompatibleButUnselectable() {
        }
        assertEquals("a", queue.poll(e -> true));
        assertNull(queue.poll(e -> true));
import java.util.concurrent.CyclicBarrier;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ConcurrentQueue<>(LinkedList::new, 0));
package org.opensearch.common.queue;
        AtomicInteger polled = new AtomicInteger();
        // With higher concurrency, entries distribute across stripes
                    while ((item = queue.poll(e -> true)) != null) {
    }
        queue.add(2);
    public void testConcurrencyBoundsLow() {
                }
    public void testPollAndDropIncompatibleAllIncompatible() {
        queue.add("b");
        assertNull(queue.poll(e -> true)); // 1 was removed
        queue.add(1);
            queue.add(i);
            n -> n % 2 == 0,       // compatible: even
    public void testConcurrencyBoundsHigh() {
        assertEquals("b", queue.poll(e -> true));
    public void testRemoveNonExistentEntry() {
        }
                try {
/*
        queue.add(3);
        assertNull(queue.poll(n -> n % 2 == 0));
        queue.add(3);
                        queue.add(threadId * itemsPerThread + i);
    public void testConcurrentAddAndPoll() throws Exception {
        assertFalse(queue.remove("z"));
        queue.add(2);
        }
        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(LinkedList::new, 1);
