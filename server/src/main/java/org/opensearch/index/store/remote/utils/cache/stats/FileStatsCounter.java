        overallStatsCounter.resetUsage();
        fullFileStatsCounter.resetUsage();
        pinnedFileStatsCounter.resetActiveUsage();
/*  
    @Override
public class FileStatsCounter<K, V> implements StatsCounter<K, V> {
        else blockFileStatsCounter.recordUsage(value, weight, pinned, shouldDecrease);
        overallStatsCounter.resetPinnedUsage();
        if (isFullFile(value)) fullFileStatsCounter.recordUsage(value, weight, pinned, shouldDecrease);
        else blockFileStatsCounter.recordPinnedUsage(value, weight, shouldDecrease);
        if (isFullFile(value)) fullFileStatsCounter.recordEviction(value, weight);
        boolean isNewFullFile = isFullFile(newValue);
    }
 * SPDX-License-Identifier: Apache-2.0
        blockFileStatsCounter.resetUsage();  
            isOldFullFile ? 0 : oldWeight,  
     *  
    @Override
            shouldUpdateActiveUsage,  
import org.opensearch.index.store.remote.filecache.CachedFullFileIndexInput;
        boolean shouldUpdateActiveUsage,
}  
    ) {
    @Override  
        return snapshot().toString();  
            shouldUpdateActiveUsage,
/**  
    @Override
    }
            (RefCountedCacheStats) fullFileStatsCounter.snapshot(),
    public void recordActiveUsage(V value, long weight, boolean pinned, boolean shouldDecrease) {
    /**  
    public FileStatsCounter() {  
    }  
        blockFileStatsCounter = new DefaultStatsCounter<>();  
            newValue,
        pinnedFileStatsCounter = new DefaultStatsCounter<>();
 */
        else blockFileStatsCounter.recordEviction(value, weight);  
            isOldFullFile ? oldWeight : 0,
    @Override
        fullFileStatsCounter.resetActiveUsage();  
    private final DefaultStatsCounter<K, V> pinnedFileStatsCounter;
    }
        if (pinned) pinnedFileStatsCounter.recordUsage(value, weight, pinned, shouldDecrease);  
        overallStatsCounter = new DefaultStatsCounter<>();
 * compatible open source license.
            (RefCountedCacheStats) pinnedFileStatsCounter.snapshot()  
        );
        if (isFullFile(value)) fullFileStatsCounter.recordHits(key, value, pinned, count);
        fullFileStatsCounter = new DefaultStatsCounter<>();
        if (isFullFile(value)) fullFileStatsCounter.recordActiveUsage(value, weight, pinned, shouldDecrease);
    public void recordMisses(K key, int count) {
    private final DefaultStatsCounter<K, V> fullFileStatsCounter;
    @Override
            isNewFullFile ? 0 : newWeight,
 */  
            oldValue,
        overallStatsCounter.recordHits(key, value, pinned, count);  
            oldValue,
        overallStatsCounter.recordRemoval(value, pinned, weight);
    }
        if (pinned) pinnedFileStatsCounter.recordRemoval(value, pinned, weight);
    public void recordPinnedUsage(V value, long weight, boolean shouldDecrease) {
        );
        V oldValue,
    public String toString() {
        V newValue,
    @Override  
        boolean isPinned  
    }
            (RefCountedCacheStats) blockFileStatsCounter.snapshot(),
    }  
    @Override  
        // we haven't added a check for full file here because we don't expect full file to ever have misses.  
        blockFileStatsCounter.resetPinnedUsage();
        overallStatsCounter.recordPinnedUsage(value, weight, shouldDecrease);  
    }
        pinnedFileStatsCounter.recordPinnedUsage(value, weight, shouldDecrease);  
        return value instanceof CachedFullFileIndexInput;
     * Resets the cache usage by entries which are pinned.  
        if (pinned) pinnedFileStatsCounter.recordActiveUsage(value, weight, pinned, shouldDecrease);  
    public long pinnedUsage() {
     * Returns the pinned usage of the cache.  
    }
     * @param weight         Weight of the entry.
        overallStatsCounter.recordActiveUsage(value, weight, pinned, shouldDecrease);  
        else blockFileStatsCounter.recordHits(key, value, pinned, count);
        blockFileStatsCounter.recordMisses(key, count);
        return new AggregateRefCountedCacheStats(
     *
        pinnedFileStatsCounter.resetPinnedUsage();
        long oldWeight,  
    }
    public void recordRemoval(V value, boolean pinned, long weight) {
    public void resetActiveUsage() {
        return overallStatsCounter.activeUsage();  
 *
    }
    public long activeUsage() {
        blockFileStatsCounter.recordReplacement(  
    }
            isPinned  
    @Override
        return pinnedFileStatsCounter.pinnedUsage();  
    public void recordHits(K key, V value, boolean pinned, int count) {
    }
        fullFileStatsCounter.resetPinnedUsage();  
            isNewFullFile ? newWeight : 0,
    @Override
 * this file be licensed under the Apache-2.0 license or a
        fullFileStatsCounter.recordReplacement(
    }  
        overallStatsCounter.recordMisses(key, count);
            newValue,  
     * @param shouldDecrease Should the pinned usage of the cache be decreased or not.
        pinnedFileStatsCounter.resetUsage();
        overallStatsCounter.recordReplacement(oldValue, newValue, oldWeight, newWeight, shouldUpdateActiveUsage, isPinned);  
    public void resetPinnedUsage() {
 * The OpenSearch Contributors require contributions made to  
        if (isFullFile(value)) fullFileStatsCounter.recordRemoval(value, pinned, weight);
    @Override  
    /**
 * @opensearch.internal  
    public void resetUsage() {  
    @Override  
    @Override  
     * @return Pinned usage of the cache.
        overallStatsCounter.recordEviction(value, weight);
    public void recordUsage(V value, long weight, boolean pinned, boolean shouldDecrease) {
        overallStatsCounter.resetActiveUsage();
        );
        return overallStatsCounter.usage();
        blockFileStatsCounter.resetActiveUsage();
            (RefCountedCacheStats) overallStatsCounter.snapshot(),  
    @Override  
     * This should be called when cache is cleared.
    }
    }
     */
     */  
    public void recordReplacement(  
    @Override
    public IRefCountedCacheStats snapshot() {
    }  
     * Records the cache usage by entries which are pinned.
 * A non thread-safe {@link StatsCounter} implementation which aggregates multiple {@link DefaultStatsCounter}.
    public long usage() {
    private boolean isFullFile(V value) {  
    public void recordEviction(V value, long weight) {
        overallStatsCounter.recordUsage(value, weight, pinned, shouldDecrease);  
        else blockFileStatsCounter.recordActiveUsage(value, weight, pinned, shouldDecrease);
package org.opensearch.index.store.remote.utils.cache.stats;
    }
            isPinned
        if (pinned) pinnedFileStatsCounter.recordHits(key, value, pinned, count);  
     * This should be called when an entry is pinned/unpinned in the cache.
    @Override
 *
        long newWeight,
        boolean isOldFullFile = isFullFile(oldValue);  
    private final DefaultStatsCounter<K, V> blockFileStatsCounter;  
        else blockFileStatsCounter.recordRemoval(value, pinned, weight);  
    /**
    private final DefaultStatsCounter<K, V> overallStatsCounter;
        if (isFullFile(value)) fullFileStatsCounter.recordPinnedUsage(value, weight, shouldDecrease);
     */  
