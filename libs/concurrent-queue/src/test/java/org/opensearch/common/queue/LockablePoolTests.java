        LockableEntry first = pool.getAndLock();
package org.opensearch.common.queue;
        pool.releaseAndUnlock(result);
    public void testIsRegisteredFalseForUnknownItem() {  
    }  
        LockableEntry next = pool.getAndLock();  
        assertNull(releasable);  
    public void testClosedPoolThrowsOnCheckoutAll() throws IOException {
    public void testGetAndLockReturnsLockedItem() {  
            return delegate.tryLock();
    public void testCheckoutAllReturnsUnmodifiableList() {
        }
 * SPDX-License-Identifier: Apache-2.0
        @Override
        pool.releaseAndUnlock(item);
        LockableEntry result = pool.getAndLock(e -> !e.id.equals(item.id));  
        pool.releaseAndUnlock(item);
        assertSame(fresh, next);
        assertFalse(first.isHeldByCurrentThread());
        LockablePool<LockableEntry> pool = createPool();
        releasable.close();  
        pool.releaseAndUnlock(second);  
        @Override
    }  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> pool.evaluateAllAndLock(e -> true));  
        Closeable releasable = pool.evaluateAllAndLock(e -> true);
        }
    }
 * Tests for {@link LockablePool}.
     */
        }  
        pool.close();
    public void testEvaluateAllAndLockReturnsNullWhenNoMatch() {
        for (LockableEntry item : pool) {  
        pool.releaseAndUnlock(item);
        LockablePool<LockableEntry> pool = createPool();  
        pool.releaseAndUnlock(first);  
        // Checkout the item so it becomes unregistered, then evaluate  
        LockableEntry stranger = new LockableEntry("stranger");
        // Reject the existing item
    public void testCheckoutAllIncludesRejectedItems() {
    // --- Tests for evaluateAllAndLock ---
import org.opensearch.test.OpenSearchTestCase;
        pool.releaseAndUnlock(item);
        LockableEntry a = pool.getAndLock();
        LockablePool<LockableEntry> pool = createPool();  
 * The OpenSearch Contributors require contributions made to  
        LockableEntry item = pool.getAndLock();
 * compatible open source license.
        LockablePool<LockableEntry> pool = createPool();
        List<LockableEntry> checked = pool.checkoutAll();
        assertFalse(pool.isRegistered(stranger));  
    public void testClosedPoolThrowsOnGetAndLock() throws IOException {  
        public void lock() {
    /**
        pool.releaseAndUnlock(fresh);  
        assertTrue("checkoutAll on empty pool should return empty list", all.isEmpty());
public class LockablePoolTests extends OpenSearchTestCase {  
    }  
    public void testRejectedItemNotReturnedBySubsequentPoll() {
        assertSame(item, result);
    }
        assertEquals("LockablePool is already closed", ex.getMessage());
        LockableEntry item = pool.getAndLock();
import java.util.LinkedList;
        }  
    public void testEvaluateAllAndLockReturnsNullOnEmptyPool() {
        LockableEntry item = pool.getAndLock();
    public void testEvaluateAllAndLockReturnsCloseableForMatchingItem() throws IOException {
        IllegalStateException ex = expectThrows(IllegalStateException.class, pool::checkoutAll);
        assertTrue(item.isHeldByCurrentThread());
    public void testEvaluateAllAndLockUnlocksItemRemovedAfterLock() throws IOException {
        List<LockableEntry> all = pool.checkoutAll();
        LockablePool<LockableEntry> pool = createPool();
/**  
     * A simple lockable entry for testing.  
        LockableEntry item = pool.getAndLock();
    }  
        pool.releaseAndUnlock(next);
        pool.close();
        LockableEntry fresh = pool.getAndLock(e -> !e.id.equals(item.id));
    }  
        LockableEntry item = pool.getAndLock();
        pool.releaseAndUnlock(a);  
        LockablePool<LockableEntry> pool = createPool();  
    private static int idCounter = 0;  
        assertTrue(second.isHeldByCurrentThread());  
        releasable.close();
import java.util.List;  
    public void testEvaluateAllAndLockMatchesFirstCompatibleItem() throws IOException {  
        LockableEntry item = pool.getAndLock();  
        LockablePool<LockableEntry> pool = createPool();  
    }
    }  
        }
        boolean isHeldByCurrentThread() {
import java.io.IOException;
    }  
        LockablePool<LockableEntry> pool = createPool();
        assertEquals("LockablePool is already closed", ex.getMessage());
        LockablePool<LockableEntry> pool = createPool();  
        assertEquals(2, all.size());  
        public void unlock() {  
    }  
        @Override  
    }  
        LockablePool<LockableEntry> pool = createPool();  
    public void testIteratorReturnsSnapshot() {  
        // a and b may be the same item (reuse), so pool may have 1 or 2 items  
        Closeable releasable = pool.evaluateAllAndLock(e -> e.id.equals(second.id));
        LockablePool<LockableEntry> pool = createPool();  
        // Next poll should return fresh, not the rejected item
        LockableEntry(String id) {  
        LockableEntry a = pool.getAndLock();
    // --- Tests for filtered getAndLock with rejection ---  
        LockablePool<LockableEntry> pool = createPool();  
        LockablePool<LockableEntry> pool = createPool();
        assertFalse("checkoutAll should return at least one item", all.isEmpty());
        assertTrue(all.contains(fresh));
        LockableEntry item = pool.getAndLock();
        pool.releaseAndUnlock(result);  
 */  
        private final ReentrantLock delegate = new ReentrantLock();
/*  
    }
        assertFalse(item.isHeldByCurrentThread());
        LockableEntry second = pool.getAndLock(e -> !e.id.equals(first.id));
        final String id;  
        assertTrue(item.isHeldByCurrentThread());
            count++;
        LockablePool<LockableEntry> pool = createPool();
        List<LockableEntry> all = pool.checkoutAll();
    }  
    public void testCheckoutAllReturnsAllItems() {
    }
        expectThrows(UnsupportedOperationException.class, () -> all.add(new LockableEntry("rogue")));
        public boolean tryLock() {
    public void testCheckoutAllOnEmptyPoolReturnsEmptyList() {
        // Reject it
    }  
        pool.releaseAndUnlock(a);
        int count = 0;
        LockablePool<LockableEntry> pool = createPool();  
    }
 *
        Closeable releasable = pool.evaluateAllAndLock(e -> true);
        pool.releaseAndUnlock(item);  
        LockableEntry item = pool.getAndLock();
        assertNotSame(item, result);
        LockableEntry second = pool.getAndLock();
        LockableEntry item = pool.getAndLock();  
        // Pool is now empty — item unregistered
        LockablePool<LockableEntry> pool = createPool();
            delegate.unlock();
        return new LockablePool<>(() -> new LockableEntry("entry-" + idCounter++), LinkedList::new, 1);  
        LockablePool<LockableEntry> pool = createPool();
        LockableEntry item = pool.getAndLock();  
    }
        LockablePool<LockableEntry> pool = createPool();
    public void testEvaluateAllAndLockThrowsWhenPoolClosed() throws IOException {
            delegate.lock();  
        assertEquals(1, checked.size());
 * this file be licensed under the Apache-2.0 license or a
    static class LockableEntry implements Lockable {
        assertNotNull(releasable);
    }
        assertEquals(1, count);
            assertNotNull(item);
        assertTrue(all.contains(item));
        assertSame("Released item should be reused", first, second);
        // Reject the existing item — predicate fails, pool creates new via supplier
    public void testReleaseAndUnlockAllowsReuse() {
        assertTrue(pool.isRegistered(item));
        pool.releaseAndUnlock(b);
        LockableEntry b = pool.getAndLock();  
    private LockablePool<LockableEntry> createPool() {
import java.util.concurrent.locks.ReentrantLock;
    public void testFilteredGetAndLockReturnsCompatibleItem() {
        }  
 */
        IllegalStateException ex = expectThrows(IllegalStateException.class, pool::getAndLock);
        pool.releaseAndUnlock(item);
        pool.releaseAndUnlock(second);
        assertNull(releasable);
        assertNotNull(releasable);
        LockableEntry fresh = pool.getAndLock(e -> !e.id.equals(item.id));
        assertEquals("LockablePool is already closed", ex.getMessage());  
    public void testIsRegisteredTrueForPoolItem() {
        assertFalse(item.isHeldByCurrentThread());
        pool.releaseAndUnlock(fresh);  
        LockableEntry first = pool.getAndLock();
        pool.close();  
    }
        LockablePool<LockableEntry> pool = createPool();  
        pool.releaseAndUnlock(item);  
        Closeable releasable = pool.evaluateAllAndLock(e -> false);  
    }
}
        pool.releaseAndUnlock(item);
import java.io.Closeable;  
        Closeable releasable = pool.evaluateAllAndLock(e -> e.id.equals(item.id));  
    }
        List<LockableEntry> all = pool.checkoutAll();
            return delegate.isHeldByCurrentThread();
        List<LockableEntry> all = pool.checkoutAll();
        pool.releaseAndUnlock(item);
        assertNotNull(item);  
    public void testFilteredGetAndLockRejectsIncompatibleItem() {  
        LockableEntry result = pool.getAndLock(e -> true);
            this.id = id;
        LockablePool<LockableEntry> pool = createPool();
        assertNull(releasable);
        pool.releaseAndUnlock(first);
        pool.releaseAndUnlock(item);
