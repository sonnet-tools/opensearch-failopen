     *
 * compatible open source license.
    }
    @Override  
            activeUsage,  
        if (isPinned) pinnedUsage = pinnedUsage - oldWeight + newWeight;  
package org.opensearch.index.store.remote.utils.cache.stats;
/*  
        replaceCount++;
        this.removeCount = 0L;
        usage = usage - oldWeight + newWeight;
 *  
        this.evictionCount = 0L;
    }  
    public void recordActiveUsage(V value, long weight, boolean pinned, boolean shouldDecrease) {
    @Override
        long oldWeight,
 * SPDX-License-Identifier: Apache-2.0
        pinnedUsage += weight;
        usage -= weight;
    /**  
    public void resetPinnedUsage() {
 */  
 */
            hitCount,
    private long hitCount;
     * @return Pinned usage of the cache.  
    }
    /**  
    public String toString() {  
    /**
    public void recordPinnedUsage(V value, long weight, boolean shouldDecrease) {
        this.missCount = 0L;
        hitCount += count;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return this.usage;  
    public DefaultStatsCounter() {
 * The OpenSearch Contributors require contributions made to  
        boolean isPinned
        weight = shouldDecrease ? -1 * weight : weight;  
    @Override  
        this.removeWeight = 0L;  
        removeWeight += weight;  
     * @param weight         Weight of the entry.
    public void recordUsage(V value, long weight, boolean pinned, boolean shouldDecrease) {
    private long evictionCount;  
        this.evictionWeight = 0L;  
    }  
    public void recordEviction(V value, long weight) {  
    public long usage() {
    }
    public void recordRemoval(V value, boolean pinned, long weight) {
            replaceCount,
    }
            evictionWeight,
     * This should be called when cache is cleared.
     */  
    private long usage;
        this.activeUsage = 0L;
            missCount,
    public void recordReplacement(
    @Override
        activeUsage += weight;  
            removeCount,  
        if (shouldUpdateActiveUsage) activeUsage = activeUsage - oldWeight + newWeight;
     * @param shouldDecrease Should the pinned usage of the cache be decreased or not.
     */
    @Override
    }
        V newValue,
        usage += weight;  
     * Returns the pinned usage of the cache.
    @Override  
        return new RefCountedCacheStats(  
    /**
        return snapshot().toString();
    private long evictionWeight;
    public long pinnedUsage() {  
        this.usage = 0L;
        return this.pinnedUsage;
    }
    @Override
     * this tracks cache usage only by entries which are being referred.
    @Override
    @Override
    private long missCount;
        V oldValue,  
        this.hitCount = 0L;  
    }
 *
            evictionCount,  
    }
        this.replaceCount = 0L;
            usage,
        missCount += count;  
/**
        evictionCount++;
    private long pinnedUsage;  
    @Override
        this.usage = 0;
}
    public long activeUsage() {  
     * Records the cache usage by entries which are pinned.
     */  
    }
     */  
        weight = shouldDecrease ? -1 * weight : weight;
    public void resetUsage() {
     * this tracks cache usage on the system (as long as cache entry is in the cache)  
        this.activeUsage = 0;  
    @Override  
            pinnedUsage
        this.pinnedUsage = 0L;  
public class DefaultStatsCounter<K, V> implements StatsCounter<K, V> {  
            removeWeight,
        weight = shouldDecrease ? -1 * weight : weight;
        removeCount++;
        long newWeight,  
    public void recordHits(K key, V value, boolean pinned, int count) {  
    }  
    private long replaceCount;
     *  
    }
    private long removeWeight;
    private long removeCount;  
    ) {  
    public IRefCountedCacheStats snapshot() {
        evictionWeight += weight;
 * A non thread-safe {@link StatsCounter} implementation.
     * this tracks cache usage only by pinned entries.
    }
    /**  
    public void resetActiveUsage() {
    @Override
    @Override
     */
        usage -= weight;  
    }
     * This should be called when an entry is pinned/unpinned in the cache.
        );
    /**  
 * @opensearch.internal
    private long activeUsage;
    @Override
        return this.activeUsage;
    }  
     * Resets the cache usage by entries which are pinned.
     */
    public void recordMisses(K key, int count) {
    @Override
        boolean shouldUpdateActiveUsage,
    }
