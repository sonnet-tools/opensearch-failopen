            LockableEntry entry = new LockableEntry("entry-" + i);
        assertTrue(polled.isHeldByCurrentThread());
            delegate.unlock();
    public void testMultipleEntries() {
public class LockableConcurrentQueueTests extends OpenSearchTestCase {  
            polled.unlock();  
        }
        boolean isHeldByCurrentThread() {
                try {
     */
            polled.unlock();  
            assertTrue(polled.isHeldByCurrentThread());
        LockableEntry c = new LockableEntry("c");
        }  
            entry.unlock();
        LockableEntry polled = queue.lockAndPoll();
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 2);
    public void testLockAndPollWithRejectsReturnsCompatibleEntry() {
        // e1 and e2 were incompatible and should have been dropped
        seedEntry(queue, e3);  
                    barrier.await();  
    public void testLockAndPollReturnsNullOnEmpty() {  
    public void testLockAndPollWithRejectsAllIncompatible() {
            } finally {  
        assertNull(queue.lockAndPoll());
        }  
        public void lock() {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
            locked.countDown();
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        LockableEntry entry = new LockableEntry("a");  
        polled.unlock();
            locker.join();  
        // Lock 'a' from a different thread so tryLock fails for the current thread
        while ((polled = queue.lockAndPoll()) != null) {
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(queue.remove(entry));
            a.lock();  
                a.unlock();
        }
        seedEntry(queue, a);
    public void testConcurrentLockAndPollAndAddAndUnlock() throws Exception {
        seedEntry(queue, c);  
    }  
        }
                release.await();  
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        AtomicInteger pollCount = new AtomicInteger();
        }  
        seedEntry(queue, entry);
        assertTrue(queue.remove(entry));  
        LockableEntry entry = new LockableEntry("a");
    /** Helper: lock the entry, add it to the queue, which unlocks it. */  
import java.util.LinkedList;  
 * Tests for {@link LockableConcurrentQueue}.
            } catch (InterruptedException e) {
    }
/*  
    /**
    public void testRemoveEntry() {
        LockableEntry a = new LockableEntry("a");
        seedEntry(queue, new LockableEntry("old"));
        // All entries should still be in the queue (returned after use)
        seedEntry(queue, new LockableEntry("old"));  
        int opsPerThread = 50;
        int count = 0;
    }
    }
    public void testAddAndUnlockMakesEntryAvailable() {
    public void testLockAndPollSkipsAlreadyLockedEntries() throws Exception {  
            this.id = id;
        queue.addAndUnlock(entry);  
        try {
            new Thread(() -> {
            }
    }
        }
        entry.lock();
 */  
        seedEntry(queue, b);
        private final ReentrantLock delegate = new ReentrantLock();
        public boolean tryLock() {
 * compatible open source license.
        LockableEntry polled = queue.lockAndPoll();
    }  
        LockableEntry a = new LockableEntry("a");  
        LockableEntry b = new LockableEntry("b");  
    }
        LockableEntry e1 = new LockableEntry("old");
                    }  
        latch.await();  
        locked.await();
            assertTrue(polled.isHeldByCurrentThread());
            LockableEntry polled = queue.lockAndPoll();
        seedEntry(queue, a);
            assertSame(b, polled);
                    latch.countDown();
            delegate.lock();  
/**  
        assertNull(queue.lockAndPollWithRejects(e -> true));
                        LockableEntry entry = queue.lockAndPoll();
    static class LockableEntry implements Lockable {
    public void testLockAndPollWithRejectsEmptyQueue() {
        polled.unlock();  
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 4);
            remaining++;  
                    for (int i = 0; i < opsPerThread; i++) {
        LockableEntry e3 = new LockableEntry("current");  
                    throw new RuntimeException(e);
            try {
import java.util.concurrent.CyclicBarrier;
        }
            count++;
            return delegate.isHeldByCurrentThread();
        seedEntry(queue, b);  
    public void testRemoveNonExistentEntry() {
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);  
                            assertTrue(entry.isHeldByCurrentThread());
        boolean isLocked() {
        int numThreads = 4;  
        CountDownLatch locked = new CountDownLatch(1);  
        int numEntries = 20;  
        assertSame(e3, result);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(3, count);  
        }
        Thread locker = new Thread(() -> {
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        CountDownLatch latch = new CountDownLatch(numThreads);  
        entry.lock();
 * The OpenSearch Contributors require contributions made to  
 */
        @Override  
package org.opensearch.common.queue;
        assertEquals(numEntries, remaining);
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);  
                            // Return it — entry is already locked by lockAndPoll  
        @Override  
        LockableEntry(String id) {  
    }
                } catch (Exception e) {
        public void unlock() {  
        LockableEntry e2 = new LockableEntry("old");
                        }
        assertSame(entry, polled);
import java.util.concurrent.CountDownLatch;
        final String id;  
        seedEntry(queue, e2);
}  
    private static void seedEntry(LockableConcurrentQueue<LockableEntry> queue, LockableEntry entry) {
import java.util.concurrent.locks.ReentrantLock;
    public void testLockAndPollReturnsLockedEntry() {  
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        assertNull(queue.lockAndPollWithRejects(e -> e.id.equals("new")));  
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);  
        LockableEntry entry = new LockableEntry("a");
            return delegate.tryLock();
        LockableEntry result = queue.lockAndPollWithRejects(e -> e.id.equals("current"));
        for (int i = 0; i < numEntries; i++) {
        assertNull(queue.lockAndPoll());
        } finally {
        int remaining = 0;
            return delegate.isLocked();  
        LockableEntry b = new LockableEntry("b");
    }
        }
        assertNull(queue.lockAndPoll());
        });  
        LockableEntry polled;  
                Thread.currentThread().interrupt();
    }
        queue.addAndUnlock(entry);  
        seedEntry(queue, e1);
     * A simple lockable entry for testing.  
        // Queue should be empty after all incompatible entries were dropped
            seedEntry(queue, entry);  
            }).start();  
                }
        assertNull(queue.lockAndPoll());  
        }
        }
            assertNotNull(polled);  
                            pollCount.incrementAndGet();
        seedEntry(queue, entry);  
    }  
        assertTrue(polled.isHeldByCurrentThread());  
        // Entry should be unlocked after addAndUnlock
                            queue.addAndUnlock(entry);
    }
        @Override
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        LockableEntry entry = new LockableEntry("a");  
                } finally {  
                        if (entry != null) {  
        locker.start();
        while ((entry = queue.lockAndPoll()) != null) {
import java.util.concurrent.atomic.AtomicInteger;  
            return "LockableEntry{" + id + "}";
        public String toString() {
 * this file be licensed under the Apache-2.0 license or a
            release.countDown();
    }
        LockableEntry entry;  
        LockableConcurrentQueue<LockableEntry> queue = new LockableConcurrentQueue<>(LinkedList::new, 1);
        result.unlock();
 *
        for (int t = 0; t < numThreads; t++) {  
        assertTrue(result.isHeldByCurrentThread());
        @Override
        assertFalse(entry.isLocked());
        assertNotNull(polled);  
        CountDownLatch release = new CountDownLatch(1);
        assertNotNull(polled);
