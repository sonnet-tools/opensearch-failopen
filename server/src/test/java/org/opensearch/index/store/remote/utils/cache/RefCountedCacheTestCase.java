        assertUsage(0, 0);  
        assertUsage(0, 0);  
        assertEquals(20L, refCountedCache.prune(path -> true));
        refCountedCache.put("1", 10L);  
        assertEquals(1, refCountedCache.stats().replaceCount());
        assertEquals(0, refCountedCache.activeUsage());
        assertEquals(0L, refCountedCache.usage());  
        assertEquals(2, refCountedCache.stats().hitCount());
        refCountedCache.remove("1");
        assertNotNull(refCountedCache.getRef("1"));
        assertEquals(1, refCountedCache.stats().hitCount());
    }
        refCountedCache.compute("1", (k, v) -> null);
        assertEquals(1, (int) refCountedCache.getRef("1"));
        assertEquals(0, refCountedCache.stats().replaceCount());
 * compatible open source license.
        refCountedCache.put("2", 10L);
        refCountedCache.put("1", 10L);
        assertEquals(0, refCountedCache.stats().removeCount());  
    static final int CAPACITY = 100;
            refCountedCache.put(key, 25L);
package org.opensearch.index.store.remote.utils.cache;
        assertEquals(0, (int) refCountedCache.getRef("1"));
        refCountedCache.decRef("1");
        assertEquals(0, refCountedCache.stats().hitCount());  
        refCountedCache.put("1", 25L);  
        final long newValue = refCountedCache.compute("1", (k, v) -> 30L);  
        assertNull(refCountedCache.get("1"));
        assertUsage(0, 0);  
        assertEquals(1, refCountedCache.stats().replaceCount());
    }
        assertEquals(0, refCountedCache.stats().hitCount());
        refCountedCache.decRef("1");
        refCountedCache.put("2", 10L);
        refCountedCache.compute("1", (k, v) -> null);
        refCountedCache.put("2", 80L);
 * SPDX-License-Identifier: Apache-2.0
        assertNull(refCountedCache.get("2"));
        assertNotNull(refCountedCache.getRef("1"));
        assertEquals(1, refCountedCache.stats().removeCount());  
            refCountedCache.decRef(key);
        refCountedCache.put("3", 10L);  
        refCountedCache.decRef("1");  
        assertEquals(10L, refCountedCache.usage());
    public void testComputeStats() {
        assertEquals(25L, refCountedCache.usage());  
}
        assertEquals(10L, refCountedCache.activeUsage());  
        assertNull(refCountedCache.get("1"));
        assertEquals(0, refCountedCache.stats().removeCount());  
        assertEquals(125L, refCountedCache.activeUsage());
    }  
        assertEquals(1, refCountedCache.stats().removeCount());
        assertEquals(10L, refCountedCache.usage());
 *
        assertEquals(20L, refCountedCache.prune());
        refCountedCache.decRef("2");
        assertNull(refCountedCache.get("1"));
        assertNull(refCountedCache.get("1"));
    public void testComputeRemapNotExists() {
        assertNotNull(refCountedCache.get("5"));
        refCountedCache.decRef("1");
    public void testEviction() {
        assertUsage(25, 0);
    }
    protected RefCountedCacheTestCase(RefCountedCache<String, Long> refCountedCache) {
        assertEquals(1, refCountedCache.stats().missCount());  
    public void testActiveUsageGreaterThanCapacity() {
        assertEquals(0, refCountedCache.stats().evictionCount());
    public void testReferenceCountingItemsThatDoNotExist() {
        assertUsage(30, 30);
        assertEquals(1, refCountedCache.stats().hitCount());
        assertEquals(0, refCountedCache.stats().hitCount());
/*  
    }  
        final long newValue = refCountedCache.compute("1", (k, v) -> v + 5);  
        assertEquals(10L, refCountedCache.activeUsage());  
import org.opensearch.test.OpenSearchTestCase;
    public void testUsageWithIncrementAndDecrement() {  
        refCountedCache.put("3", 80L);
        assertUsage(30, 0);
        }
        assertNull(refCountedCache.compute("1", (k, v) -> null));
        }  
        this.refCountedCache = refCountedCache;  
        assertEquals(10L, (long) refCountedCache.get("3"));
    }  
        assertNull(refCountedCache.get("2"));
        assertEquals(1, refCountedCache.stats().missCount());  
        assertEquals(usage, refCountedCache.usage());
        refCountedCache.put("1", 10L);
        assertEquals(1, refCountedCache.stats().replaceCount());
        assertUsage(30, 30);
        assertNull(refCountedCache.get("1"));  
        refCountedCache.remove("3");  
    private final RefCountedCache<String, Long> refCountedCache;  
        assertUsage(30, 0);
        refCountedCache.decRef("2");  
        assertEquals(0L, refCountedCache.usage());
        refCountedCache.put("1", 25L);
        refCountedCache.prune();
        refCountedCache.incRef("1");
        assertEquals(0L, refCountedCache.usage());  
        refCountedCache.put("2", 10L);
        refCountedCache.compute("1", (k, v) -> 10L);
    public void testComputeRemapExists() {  
        assertEquals(1, refCountedCache.stats().evictionCount());
    }
    public void testBasicGetAndPutAndRemove() {  
            final String key = Integer.toString(i);  
    }
        refCountedCache.decRef("1");  
        assertNull(refCountedCache.get("1"));
        assertNotNull(refCountedCache.get("3"));  
 * this file be licensed under the Apache-2.0 license or a
    public void testComputeRemoveWhenNotExists() {
            final String key = Integer.toString(i);  
    }
        assertNull(refCountedCache.get("1"));  
        refCountedCache.compute("1", (k, v) -> 10L);
        assertEquals(0L, refCountedCache.activeUsage());  
        for (int i = 1; i <= 5; i++) {
    }
abstract class RefCountedCacheTestCase extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals(0, refCountedCache.stats().missCount());  
        refCountedCache.put("1", 1L);
        assertEquals(75L, refCountedCache.activeUsage());
        assertEquals(1, refCountedCache.stats().missCount());  
        assertNull(refCountedCache.getRef("1"));  
        assertUsage(0, 0);
        assertEquals(1, refCountedCache.stats().missCount());  
        assertEquals(0L, refCountedCache.activeUsage());
        refCountedCache.put("3", 10L);  
        refCountedCache.put("1", 10L);
    private void assertUsage(long usage, long activeUsage) {  
        assertNotNull(refCountedCache.getRef("1"));
        assertUsage(0, 0);  
        assertEquals(0, refCountedCache.stats().removeCount());  
        assertEquals(0, refCountedCache.stats().replaceCount());
        assertEquals(30L, (long) refCountedCache.get("1"));
        refCountedCache.put("1", 2L);  
    public void testPrune() {
        assertEquals(activeUsage, refCountedCache.activeUsage());
        assertEquals(30L, (long) refCountedCache.get("1"));
        assertEquals(30L, newValue);
        assertEquals(30L, refCountedCache.usage());
        refCountedCache.decRef("1");
        assertEquals(75L, refCountedCache.usage());
        assertEquals(0, refCountedCache.stats().removeCount());  
        assertEquals(10L, (long) refCountedCache.get("3"));
        assertEquals(0, refCountedCache.stats().removeCount());
        assertEquals(0, refCountedCache.stats().replaceCount());
        assertEquals(1, refCountedCache.stats().hitCount());  
        refCountedCache.clear();
        assertEquals(30L, newValue);
        assertNull(refCountedCache.get("1"));
        assertEquals(0L, refCountedCache.prune(path -> false));  
        assertNull(refCountedCache.get("1"));  
        refCountedCache.decRef("1");
        assertNull(refCountedCache.get("2"));
        refCountedCache.get("1");
        assertEquals(1, refCountedCache.stats().missCount());  
        assertEquals(2, refCountedCache.stats().hitCount());
        refCountedCache.compute("1", (k, v) -> 20L);
        assertNull(refCountedCache.get("1"));
        refCountedCache.incRef("1");
 */  
    public void testPruneWithPredicate() {
    }  
    }
        refCountedCache.decRef("1");
        assertEquals(10L, refCountedCache.usage());
        assertNull(refCountedCache.get("2"));
    // fat rha h
        assertUsage(0, 0);
    }  
        assertNull(refCountedCache.compute("1", (k, v) -> null));
        refCountedCache.put("3", 10L);
        assertEquals(125L, refCountedCache.usage());  
        assertEquals(1, (int) refCountedCache.getRef("1"));
        assertEquals(0, refCountedCache.stats().missCount());
    public void testStats() {
            refCountedCache.put(key, 25L);
        assertEquals(0, refCountedCache.activeUsage());
        refCountedCache.put("1", 10L);
        refCountedCache.decRef("2");  
        for (int i = 1; i <= 5; i++) {
        assertEquals(10L, (long) refCountedCache.get("1"));  
    }  
        assertNotNull(refCountedCache.get("4"));
    public void testClear() {  
    public void testComputeRemoveWhenExists() {
    }
        assertEquals(0, refCountedCache.stats().replaceCount());
        refCountedCache.decRef("1");
