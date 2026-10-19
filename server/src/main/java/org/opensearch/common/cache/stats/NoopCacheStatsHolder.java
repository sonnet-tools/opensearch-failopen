        immutableCacheStatsHolder = new ImmutableCacheStatsHolder(dummyNode, new String[0], List.of(), dummyStoreName);
        return singletonInstance;
 * The OpenSearch Contributors require contributions made to  
 */  
    }
    @Override
    public static NoopCacheStatsHolder getInstance() {
    @Override
    public void incrementItems(List<String> dimensionValues) {}  
 * Returns all-zero stats when calling getImmutableCacheStatsHolder(). Always returns 0 for count().
/**  
        return 0;
 * compatible open source license.
    @Override
    }  
import java.util.List;
    public void removeDimensions(List<String> dimensionValues) {}
    }
        return immutableCacheStatsHolder;  
    public void incrementHits(List<String> dimensionValues) {}  
/*  
    private NoopCacheStatsHolder() {}
 *
    public void incrementMisses(List<String> dimensionValues) {}  
 */
    public void incrementSizeInBytes(List<String> dimensionValues, long amountBytes) {}  
    private static final String dummyStoreName = "noop_store";  
    @Override
    public ImmutableCacheStatsHolder getImmutableCacheStatsHolder(String[] levels) {
}
 * A dummy version of CacheStatsHolder, which cache implementations use when FeatureFlags.PLUGGABLE_CACHES is false.
    @Override
    @Override
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.cache.stats;
    public void decrementSizeInBytes(List<String> dimensionValues, long amountBytes) {}  
    public void decrementItems(List<String> dimensionValues) {}  
    public void incrementEvictions(List<String> dimensionValues) {}  
    public long count() {  
    @Override
    @Override
    private static final NoopCacheStatsHolder singletonInstance = new NoopCacheStatsHolder();
    }  
public class NoopCacheStatsHolder implements CacheStatsHolder {
    @Override
    public void reset() {}  
    @Override
    @Override
    private static final ImmutableCacheStatsHolder immutableCacheStatsHolder;
        DefaultCacheStatsHolder.Node dummyNode = new DefaultCacheStatsHolder.Node("", false);
    static {  
 * SPDX-License-Identifier: Apache-2.0
 * A singleton instance is used for memory purposes.  
