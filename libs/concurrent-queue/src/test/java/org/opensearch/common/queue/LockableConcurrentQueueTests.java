        boolean isHeldByCurrentThread() {
        });
    }
        final String id;
        // Entry should be unlocked after addAndUnlock
        seedEntry(queue, e2);
                        if (entry != null) {
        int count = 0;
    public void testLockAndPollSkipsAlreadyLockedEntries() throws Exception {
        // e1 and e2 were incompatible and should have been dropped
        }
 * SPDX-License-Identifier: Apache-2.0
/**
    }
            return "LockableEntry{" + id + "}";
            locked.countDown();
        seedEntry(queue, new LockableEntry("old"));
    /** Helper: lock the entry, add it to the queue, which unlocks it. */
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        assertTrue(polled.isHeldByCurrentThread());
            assertNotNull(polled);
        LockableEntry c = new LockableEntry("c");
            count++;
                        }
        assertSame(e3, result);
        int numEntries = 20;
        }
    public void testAddAndUnlockMakesEntryAvailable() {
        assertNull(queue.lockAndPoll());
        @Override
    public void testLockAndPollWithRejectsAllIncompatible() {
    }
            remaining++;
            } finally {
        LockableEntry e2 = new LockableEntry("old");
        }
        seedEntry(queue, b);
        assertFalse(queue.remove(entry));
        while ((polled = queue.lockAndPoll()) != null) {
        LockableEntry entry = new LockableEntry("a");
        assertFalse(entry.isLocked());
}
        seedEntry(queue, a);
            release.countDown();
        }
    private static void seedEntry(LockableConcurrentQueue<LockableEntry> queue, LockableEntry entry) {
        assertTrue(queue.remove(entry));
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
                    barrier.await();
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        }
        LockableEntry polled = queue.lockAndPoll();
        LockableEntry a = new LockableEntry("a");
        seedEntry(queue, entry);
        polled.unlock();
                    latch.countDown();
        CountDownLatch locked = new CountDownLatch(1);
            polled.unlock();
            LockableEntry entry = new LockableEntry("entry-" + i);
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 2);
            return delegate.isHeldByCurrentThread();
        assertNull(queue.lockAndPollWithRejects(e -> true));
                release.await();
    public void testMultipleEntries() {
 * Tests for {@link LockableConcurrentQueue}.
    public void testRemoveNonExistentEntry() {
        latch.await();
import java.util.concurrent.locks.ReentrantLock;
        seedEntry(queue, b);
    }
                    throw new RuntimeException(e);
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        assertEquals(numEntries, remaining);
        public boolean tryLock() {
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;
    }
        AtomicInteger pollCount = new AtomicInteger();
 * compatible open source license.
        }
        LockableEntry polled = queue.lockAndPoll();
        entry.lock();
        assertTrue(polled.isHeldByCurrentThread());
                            queue.addAndUnlock(entry);
                }
                try {
    public void testLockAndPollReturnsNullOnEmpty() {
                    for (int i = 0; i < opsPerThread; i++) {
        int opsPerThread = 50;
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        LockableEntry e3 = new LockableEntry("current");
        public void unlock() {
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        assertNull(queue.lockAndPoll());
        LockableEntry polled;
        assertNull(queue.lockAndPollWithRejects(e -> e.id.equals("new")));
            try {
        assertEquals(3, count);
                    }
            return delegate.tryLock();
        LockableEntry b = new LockableEntry("b");
    }
        seedEntry(queue, new LockableEntry("old"));
        assertNull(queue.lockAndPoll());
        seedEntry(queue, entry);
    public void testLockAndPollWithRejectsEmptyQueue() {
                            // Return it — entry is already locked by lockAndPoll
        locked.await();
                            pollCount.incrementAndGet();
        seedEntry(queue, c);
    /**
            a.lock();
            } catch (InterruptedException e) {
            polled.unlock();
        assertTrue(result.isHeldByCurrentThread());
        // Queue should be empty after all incompatible entries were dropped
        seedEntry(queue, e3);
                Thread.currentThread().interrupt();
    }
            entry.unlock();
/*
        assertNotNull(polled);
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
            delegate.unlock();
        private final ReentrantLock delegate = new ReentrantLock();
            this.id = id;
        queue.addAndUnlock(entry);
    static class LockableEntry implements Lockable {
        }
        CountDownLatch latch = new CountDownLatch(numThreads);
        LockableEntry entry;
        LockableEntry entry = new LockableEntry("a");
    }
        seedEntry(queue, a);
        }
            seedEntry(queue, entry);
            new Thread(() -> {
        @Override
 * The OpenSearch Contributors require contributions made to
        try {
        while ((entry = queue.lockAndPoll()) != null) {
        public void lock() {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
                            assertTrue(entry.isHeldByCurrentThread());
        int numThreads = 4;
        LockableEntry b = new LockableEntry("b");
        }
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 4);
 *
        @Override
import java.util.LinkedList;
        LockableEntry entry = new LockableEntry("a");
        locker.start();
        LockableEntry entry = new LockableEntry("a");
public class LockableConcurrentQueueTests extends OpenSearchTestCase {
     */
import org.opensearch.test.OpenSearchTestCase;
        assertNull(queue.lockAndPoll());
    }
    }
        assertSame(entry, polled);
        LockableEntry a = new LockableEntry("a");
        Thread locker = new Thread(() -> {
    public void testConcurrentLockAndPollAndAddAndUnlock() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    public void testLockAndPollWithRejectsReturnsCompatibleEntry() {
     * A simple lockable entry for testing.
            return delegate.isLocked();
        public String toString() {
        LockableEntry e1 = new LockableEntry("old");
        polled.unlock();
        entry.lock();
            }).start();
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
            delegate.lock();
                        LockableEntry entry = queue.lockAndPoll();
                a.unlock();
        for (int t = 0; t < numThreads; t++) {
        CountDownLatch release = new CountDownLatch(1);
    public void testLockAndPollReturnsLockedEntry() {
    }
            assertTrue(polled.isHeldByCurrentThread());
        seedEntry(queue, e1);
        boolean isLocked() {
        @Override
        queue.addAndUnlock(entry);
        } finally {
        }
            }
 */
        LockableEntry result = queue.lockAndPollWithRejects(e -> e.id.equals("current"));
            locker.join();
import java.util.concurrent.CountDownLatch;
            assertTrue(polled.isHeldByCurrentThread());
            assertSame(b, polled);
        }
        // Lock 'a' from a different thread so tryLock fails for the current thread
 */
            LockableEntry polled = queue.lockAndPoll();
    }
        LockableEntry(String id) {
    }
                } finally {
        for (int i = 0; i < numEntries; i++) {
        assertNotNull(polled);
package org.opensearch.common.queue;
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        }
        result.unlock();
        // All entries should still be in the queue (returned after use)
        int remaining = 0;
    public void testRemoveEntry() {
                } catch (Exception e) {
