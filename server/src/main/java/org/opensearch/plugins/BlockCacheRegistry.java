import java.util.Optional;
    /**
    /**
 */
     * @return the matching cache, or empty
    Optional<BlockCache> get(String name);  
     */
     * Returns the registered {@link BlockCache} whose {@link BlockCache#cacheName()} equals  
/**  
     * Returns all registered {@link BlockCache} instances.  
 *
     * @param name the cache name; see constants in {@link BlockCacheConstants}  
    List<BlockCache> all();
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
     *
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
package org.opensearch.plugins;
}  
     * {@code name}, or {@link Optional#empty()} if no such cache is registered.
 * compatible open source license.
     */
/*  
 * Lookup interface for registered {@link BlockCache} instances by name.
import org.opensearch.common.annotation.ExperimentalApi;
public interface BlockCacheRegistry {  
 * @opensearch.experimental  
