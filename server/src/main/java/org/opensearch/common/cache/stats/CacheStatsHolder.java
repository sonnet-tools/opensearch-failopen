package org.opensearch.common.cache.stats;
    ImmutableCacheStatsHolder getImmutableCacheStatsHolder(String[] levels);  
    long count();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
    void decrementSizeInBytes(List<String> dimensionValues, long amountBytes);  
 */
    void incrementEvictions(List<String> dimensionValues);
 * SPDX-License-Identifier: Apache-2.0
    void incrementMisses(List<String> dimensionValues);  
}
    void incrementHits(List<String> dimensionValues);
    void reset();  
public interface CacheStatsHolder {  
    void removeDimensions(List<String> dimensionValues);
/**  
    void incrementSizeInBytes(List<String> dimensionValues, long amountBytes);
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 */  
 * An interface extended by DefaultCacheStatsHolder and NoopCacheStatsHolder.
    void incrementItems(List<String> dimensionValues);
    void decrementItems(List<String> dimensionValues);
