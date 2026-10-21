 * this file be licensed under the Apache-2.0 license or a
        refCountedCache.remove("3");
        assertEquals(10L, refCountedCache.usage());
        assertEquals(0L, refCountedCache.activeUsage());
    }
        refCountedCache.put("1", 25L);
        assertEquals(1, refCountedCache.stats().replaceCount());
    public void testPrune() {
        assertEquals(0, (int) refCountedCache.getRef("1"));
        refCountedCache.put("3", 10L);
    }
        assertNull(refCountedCache.get("1"));
        assertEquals(0, refCountedCache.stats().replaceCount());
        assertEquals(0L, refCountedCache.prune(path -> false));
        refCountedCache.decRef("1");
    }
 */
        assertEquals(1, refCountedCache.stats().removeCount());
        assertEquals(30L, newValue);
        assertEquals(75L, refCountedCache.activeUsage());
        assertNull(refCountedCache.get("1"));
        refCountedCache.compute("1", (k, v) -> 10L);
    }
    public void testClear() {
        assertEquals(usage, refCountedCache.usage());
        assertEquals(0, refCountedCache.stats().missCount());
    }
        refCountedCache.decRef("2");
    public void testComputeStats() {
        refCountedCache.put("2", 10L);
    // fat rha h
        assertNull(refCountedCache.get("2"));
        assertEquals(0, refCountedCache.stats().removeCount());
    private void assertUsage(long usage, long activeUsage) {
        refCountedCache.compute("1", (k, v) -> 10L);
        assertEquals(0, refCountedCache.stats().replaceCount());
        assertEquals(10L, (long) refCountedCache.get("3"));
        assertUsage(0, 0);
        refCountedCache.put("3", 80L);
        assertEquals(1, (int) refCountedCache.getRef("1"));
        refCountedCache.put("1", 10L);
        assertEquals(1, refCountedCache.stats().missCount());
        assertNull(refCountedCache.get("1"));
        assertUsage(0, 0);
        assertEquals(1, refCountedCache.stats().removeCount());
        assertEquals(10L, refCountedCache.usage());
    public void testPruneWithPredicate() {
        assertNull(refCountedCache.get("2"));
 * The OpenSearch Contributors require contributions made to
    }
    }
    }
        assertNull(refCountedCache.get("1"));
        refCountedCache.compute("1", (k, v) -> 20L);
        assertUsage(30, 0);
        refCountedCache.decRef("2");
        refCountedCache.decRef("1");
            refCountedCache.put(key, 25L);
        assertNotNull(refCountedCache.getRef("1"));
        assertEquals(1, refCountedCache.stats().hitCount());
        assertUsage(0, 0);
        refCountedCache.compute("1", (k, v) -> null);
        assertEquals(0, refCountedCache.activeUsage());
        assertEquals(1, refCountedCache.stats().missCount());
        assertEquals(1, refCountedCache.stats().hitCount());
        refCountedCache.prune();
    public void testComputeRemoveWhenExists() {
        }
        refCountedCache.put("3", 10L);
        assertEquals(0L, refCountedCache.activeUsage());
        assertEquals(1, refCountedCache.stats().evictionCount());
 *
        assertNull(refCountedCache.compute("1", (k, v) -> null));
        refCountedCache.decRef("1");
        assertEquals(2, refCountedCache.stats().hitCount());
        assertEquals(1, (int) refCountedCache.getRef("1"));
            refCountedCache.decRef(key);
        assertEquals(0, refCountedCache.activeUsage());
        assertEquals(30L, (long) refCountedCache.get("1"));
        assertNull(refCountedCache.get("1"));
        refCountedCache.put("2", 10L);
    protected RefCountedCacheTestCase(RefCountedCache<String, Long> refCountedCache) {
    }
        assertUsage(0, 0);
        assertEquals(20L, refCountedCache.prune());
        assertEquals(1, refCountedCache.stats().replaceCount());
        assertEquals(0L, refCountedCache.usage());
        assertEquals(1, refCountedCache.stats().replaceCount());
        assertUsage(25, 0);
        assertEquals(0L, refCountedCache.usage());
        assertEquals(0, refCountedCache.stats().removeCount());
        final long newValue = refCountedCache.compute("1", (k, v) -> 30L);
        refCountedCache.clear();
    private final RefCountedCache<String, Long> refCountedCache;
        assertEquals(0, refCountedCache.stats().removeCount());
        assertEquals(1, refCountedCache.stats().missCount());
    public void testBasicGetAndPutAndRemove() {
        assertNull(refCountedCache.get("1"));
    public void testComputeRemapExists() {
    public void testStats() {
}
        refCountedCache.put("1", 10L);
        assertNotNull(refCountedCache.get("5"));
    public void testActiveUsageGreaterThanCapacity() {
        assertNull(refCountedCache.get("1"));
        assertEquals(30L, refCountedCache.usage());
        assertEquals(10L, refCountedCache.usage());
        refCountedCache.decRef("1");
        assertNotNull(refCountedCache.getRef("1"));
        refCountedCache.put("3", 10L);
        assertEquals(0, refCountedCache.stats().missCount());
        refCountedCache.put("1", 10L);
import org.opensearch.test.OpenSearchTestCase;
        assertNull(refCountedCache.get("1"));
        refCountedCache.remove("1");
        refCountedCache.decRef("1");
        for (int i = 1; i <= 5; i++) {
        final long newValue = refCountedCache.compute("1", (k, v) -> v + 5);
    }
            final String key = Integer.toString(i);
        assertNull(refCountedCache.get("2"));
        assertEquals(0, refCountedCache.stats().hitCount());
    }
        assertEquals(30L, (long) refCountedCache.get("1"));
        this.refCountedCache = refCountedCache;
        refCountedCache.put("1", 10L);
    }
        assertUsage(0, 0);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, refCountedCache.stats().hitCount());
        assertEquals(0, refCountedCache.stats().replaceCount());
    public void testComputeRemapNotExists() {
        refCountedCache.decRef("1");
    static final int CAPACITY = 100;
        }
        assertEquals(25L, refCountedCache.usage());
 * compatible open source license.
        refCountedCache.decRef("1");
        assertNull(refCountedCache.getRef("1"));
    }
        assertEquals(10L, (long) refCountedCache.get("3"));
        assertUsage(30, 30);
        assertNull(refCountedCache.get("1"));
        assertUsage(30, 0);
        assertEquals(125L, refCountedCache.activeUsage());
        assertEquals(0L, refCountedCache.usage());
        assertEquals(1, refCountedCache.stats().missCount());
    public void testComputeRemoveWhenNotExists() {
        assertUsage(30, 30);
        refCountedCache.decRef("1");
    public void testUsageWithIncrementAndDecrement() {
        refCountedCache.put("1", 25L);
        assertNotNull(refCountedCache.getRef("1"));
        assertNull(refCountedCache.compute("1", (k, v) -> null));
        refCountedCache.put("2", 10L);
        refCountedCache.put("1", 2L);
    }
        refCountedCache.get("1");
            refCountedCache.put(key, 25L);
        refCountedCache.incRef("1");
    public void testReferenceCountingItemsThatDoNotExist() {
        assertEquals(75L, refCountedCache.usage());
        refCountedCache.put("1", 10L);
package org.opensearch.index.store.remote.utils.cache;
        for (int i = 1; i <= 5; i++) {
        assertEquals(0, refCountedCache.stats().replaceCount());
            final String key = Integer.toString(i);
        assertNull(refCountedCache.get("2"));
        assertEquals(0, refCountedCache.stats().hitCount());
        refCountedCache.put("1", 1L);
        refCountedCache.decRef("1");
        assertEquals(10L, (long) refCountedCache.get("1"));
        assertEquals(1, refCountedCache.stats().missCount());
        assertEquals(0, refCountedCache.stats().evictionCount());
        refCountedCache.decRef("2");
        refCountedCache.put("2", 80L);
abstract class RefCountedCacheTestCase extends OpenSearchTestCase {
        assertEquals(10L, refCountedCache.activeUsage());
        refCountedCache.incRef("1");
        assertEquals(10L, refCountedCache.activeUsage());
        assertEquals(30L, newValue);
        refCountedCache.compute("1", (k, v) -> null);
        assertNotNull(refCountedCache.get("4"));
    }
    }
        assertEquals(2, refCountedCache.stats().hitCount());
        assertEquals(0, refCountedCache.stats().hitCount());
        assertNull(refCountedCache.get("1"));
        assertEquals(0, refCountedCache.stats().removeCount());
        assertEquals(125L, refCountedCache.usage());
        assertUsage(0, 0);
        assertEquals(0, refCountedCache.stats().removeCount());
        assertNotNull(refCountedCache.get("3"));
/*
        assertEquals(20L, refCountedCache.prune(path -> true));
        assertEquals(activeUsage, refCountedCache.activeUsage());
    public void testEviction() {
