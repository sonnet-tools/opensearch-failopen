package org.opensearch.common.queue;
        LockableEntry item = pool.getAndLock();
        expectThrows(UnsupportedOperationException.class, () -> all.add(new LockableEntry("rogue")));
        LockablePool<LockableEntry> pool = createPool();
        @Override
}
        IllegalStateException ex = expectThrows(IllegalStateException.class, pool::getAndLock);
        LockablePool<LockableEntry> pool = createPool();
    }
    }
        assertSame(fresh, next);
        LockableEntry item = pool.getAndLock();
import java.util.concurrent.locks.ReentrantLock;
        assertFalse(pool.isRegistered(stranger));
        assertEquals("LockablePool is already closed", ex.getMessage());
import java.util.List;
        LockablePool<LockableEntry> pool = createPool();
        pool.releaseAndUnlock(b);
        LockableEntry a = pool.getAndLock();
        public void unlock() {
        pool.releaseAndUnlock(first);
        pool.releaseAndUnlock(item);
        pool.close();
        pool.releaseAndUnlock(fresh);
    }
            assertNotNull(item);
        pool.releaseAndUnlock(second);
        List<LockableEntry> checked = pool.checkoutAll();
 */
        assertNotNull(releasable);
        LockablePool<LockableEntry> pool = createPool();
        pool.releaseAndUnlock(item);
    }
        assertTrue(item.isHeldByCurrentThread());
    public void testEvaluateAllAndLockMatchesFirstCompatibleItem() throws IOException {
        assertEquals("LockablePool is already closed", ex.getMessage());
        pool.releaseAndUnlock(item);
        LockablePool<LockableEntry> pool = createPool();
        pool.close();
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry second = pool.getAndLock();
        LockableEntry item = pool.getAndLock();
        assertNull(releasable);
        assertNotSame(item, result);
        LockableEntry first = pool.getAndLock();
    public void testEvaluateAllAndLockThrowsWhenPoolClosed() throws IOException {
        private final ReentrantLock delegate = new ReentrantLock();
    }
        LockableEntry a = pool.getAndLock();
    }
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> pool.evaluateAllAndLock(e -> true));
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry result = pool.getAndLock(e -> true);
        LockablePool<LockableEntry> pool = createPool();
        LockablePool<LockableEntry> pool = createPool();
        pool.releaseAndUnlock(item);
        // Checkout the item so it becomes unregistered, then evaluate
        pool.releaseAndUnlock(item);
    }
    }
 * The OpenSearch Contributors require contributions made to
    /**
    public void testIsRegisteredFalseForUnknownItem() {
        // Reject the existing item
        assertNotNull(item);
        pool.releaseAndUnlock(item);
    }
/**
    }
        LockableEntry first = pool.getAndLock();
    }
    public void testClosedPoolThrowsOnGetAndLock() throws IOException {
        @Override
        assertFalse(item.isHeldByCurrentThread());
import java.io.Closeable;
    public void testEvaluateAllAndLockReturnsCloseableForMatchingItem() throws IOException {
        pool.releaseAndUnlock(item);
    }
        pool.releaseAndUnlock(item);
        }
        Closeable releasable = pool.evaluateAllAndLock(e -> e.id.equals(item.id));
        Closeable releasable = pool.evaluateAllAndLock(e -> true);
        }
    }
        Closeable releasable = pool.evaluateAllAndLock(e -> e.id.equals(second.id));
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry second = pool.getAndLock(e -> !e.id.equals(first.id));
        pool.releaseAndUnlock(result);
    public void testGetAndLockReturnsLockedItem() {
        }
import java.io.IOException;
        IllegalStateException ex = expectThrows(IllegalStateException.class, pool::checkoutAll);
    public void testFilteredGetAndLockReturnsCompatibleItem() {
/*
        pool.releaseAndUnlock(item);
            count++;
        final String id;
 * SPDX-License-Identifier: Apache-2.0
        // Next poll should return fresh, not the rejected item
import org.opensearch.test.OpenSearchTestCase;
        LockableEntry item = pool.getAndLock();
        assertTrue(all.contains(fresh));
        LockablePool<LockableEntry> pool = createPool();
        releasable.close();
 * this file be licensed under the Apache-2.0 license or a
    }
        LockablePool<LockableEntry> pool = createPool();
        assertTrue(all.contains(item));
    public void testIteratorReturnsSnapshot() {
        Closeable releasable = pool.evaluateAllAndLock(e -> false);
        releasable.close();
    public void testCheckoutAllReturnsAllItems() {
        pool.releaseAndUnlock(result);
        LockableEntry item = pool.getAndLock();
    }
        LockableEntry item = pool.getAndLock();
    public void testEvaluateAllAndLockReturnsNullOnEmptyPool() {
    }
        assertEquals(1, checked.size());
    private LockablePool<LockableEntry> createPool() {
        }
        List<LockableEntry> all = pool.checkoutAll();
        pool.releaseAndUnlock(second);
    public void testFilteredGetAndLockRejectsIncompatibleItem() {
        assertTrue("checkoutAll on empty pool should return empty list", all.isEmpty());
    private static int idCounter = 0;
        LockableEntry fresh = pool.getAndLock(e -> !e.id.equals(item.id));
        Closeable releasable = pool.evaluateAllAndLock(e -> true);
        assertEquals(1, count);
        LockablePool<LockableEntry> pool = createPool();
        pool.releaseAndUnlock(next);
        LockableEntry b = pool.getAndLock();
        assertSame("Released item should be reused", first, second);
        LockablePool<LockableEntry> pool = createPool();
        int count = 0;
        pool.releaseAndUnlock(a);
        LockableEntry stranger = new LockableEntry("stranger");
        assertNull(releasable);
        LockableEntry item = pool.getAndLock();
        assertFalse("checkoutAll should return at least one item", all.isEmpty());
    // --- Tests for filtered getAndLock with rejection ---
            return delegate.tryLock();
    public void testIsRegisteredTrueForPoolItem() {
        // a and b may be the same item (reuse), so pool may have 1 or 2 items
        pool.close();
    static class LockableEntry implements Lockable {
            delegate.lock();
        LockableEntry item = pool.getAndLock();
            return delegate.isHeldByCurrentThread();
        LockableEntry result = pool.getAndLock(e -> !e.id.equals(item.id));
        assertEquals(2, all.size());
        }
    }
    }
    public void testCheckoutAllReturnsUnmodifiableList() {
        LockableEntry(String id) {
    public void testCheckoutAllOnEmptyPoolReturnsEmptyList() {
        List<LockableEntry> all = pool.checkoutAll();
        @Override
        assertNull(releasable);
        assertNotNull(releasable);
        for (LockableEntry item : pool) {
    public void testEvaluateAllAndLockReturnsNullWhenNoMatch() {
        assertTrue(second.isHeldByCurrentThread());
        assertSame(item, result);
        LockablePool<LockableEntry> pool = createPool();
        LockablePool<LockableEntry> pool = createPool();
        assertFalse(item.isHeldByCurrentThread());
        pool.releaseAndUnlock(first);
        LockableEntry next = pool.getAndLock();
import java.util.LinkedList;
        pool.releaseAndUnlock(a);
        // Pool is now empty — item unregistered
            this.id = id;
        List<LockableEntry> all = pool.checkoutAll();
    }
            delegate.unlock();
    public void testReleaseAndUnlockAllowsReuse() {
        pool.releaseAndUnlock(fresh);
        LockablePool<LockableEntry> pool = createPool();
        public void lock() {
 *
        LockablePool<LockableEntry> pool = createPool();
 */
     */
        assertFalse(first.isHeldByCurrentThread());
        pool.releaseAndUnlock(item);
        boolean isHeldByCurrentThread() {
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry fresh = pool.getAndLock(e -> !e.id.equals(item.id));
    }
    // --- Tests for evaluateAllAndLock ---
    }
    public void testCheckoutAllIncludesRejectedItems() {
public class LockablePoolTests extends OpenSearchTestCase {
    public void testEvaluateAllAndLockUnlocksItemRemovedAfterLock() throws IOException {
        }
        public boolean tryLock() {
 * Tests for {@link LockablePool}.
    }
        List<LockableEntry> all = pool.checkoutAll();
        assertTrue(item.isHeldByCurrentThread());
    public void testClosedPoolThrowsOnCheckoutAll() throws IOException {
    public void testRejectedItemNotReturnedBySubsequentPoll() {
        // Reject the existing item — predicate fails, pool creates new via supplier
 * compatible open source license.
        LockableEntry item = pool.getAndLock();
        assertEquals("LockablePool is already closed", ex.getMessage());
        // Reject it
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry item = pool.getAndLock();
     * A simple lockable entry for testing.
        assertTrue(pool.isRegistered(item));
        return new LockablePool<>(() -> new LockableEntry("entry-" + idCounter++), LinkedList::new, 1);
