     * aggregated by fetching all plugins.  
import org.opensearch.common.cache.ICache;
     */
 * SPDX-License-Identifier: Apache-2.0
    Map<String, ICache.Factory> getCacheFactoryMap();  
 */  
 */
public interface CachePlugin {  
 * this file be licensed under the Apache-2.0 license or a
     * B: Map.of(ON_HEAP, new ADiskCache.Factor())
 * compatible open source license.
package org.opensearch.plugins;
     *
 * @opensearch.experimental  
     *  
 * The OpenSearch Contributors require contributions made to  
    String getName();
    /**
 *
@ExperimentalApi
import java.util.Map;
}  
     * If there are two implementations of this plugin, lets say A and B, each may return below which can be
     * For example:
     *
/*  
 * Plugin to extend cache related classes
     *             ON_HEAP, new AOnHeapCache.Factor())  
/**  
 *
     * A: Map.of(DISK, new ADiskCache.Factor(),
     * @return Map of cacheStoreType and an associated factory.
import org.opensearch.common.annotation.ExperimentalApi;
     * Returns a map of cacheStoreType and a factory via which objects can be created on demand.  
