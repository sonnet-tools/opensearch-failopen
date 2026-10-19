     * {@link BlockCache#cacheName()} of the cache returned by
     * @param bytes the exact SSD bytes reserved for this plugin's block cache
     * <p>Called once, before {@code createComponents()}.
     */
     * Returns the node-scoped {@link BlockCache} published by this plugin, or
     * {@code 0} — no allocation requested.
     * @return the cache, or {@link Optional#empty()}; never {@code null}
     * {@link #getBlockCache()}.  
     * @return cache name; must be unique across all registered providers
 * warm-node startup:
 *       block caches. The remainder goes to the file cache.</li>
     */
@ExperimentalApi  
 * The OpenSearch Contributors require contributions made to  
    /**
}
     * @param totalBudgetBytes total warm-cache SSD budget in bytes
import org.opensearch.common.annotation.ExperimentalApi;
     * @return bytes requested; must be &ge; 0  
 * to not implementing this interface — consumers see no cache and fall back to  
 *       into {@code NodeCacheService} after {@code createComponents} returns.</li>
    default double dataToCapacityRatio(Settings settings) {
     * A value of {@code 5.0} means one byte of cache SSD can serve five bytes of
    default long requestedCapacityBytes(Settings settings, long totalBudgetBytes) {
 * SPI for plugins that publish a node-scoped {@link BlockCache}.
 * compatible open source license.
 * <p>A plugin implements this interface to participate in two phases of  
 * is configured to zero) without changing its SPI participation.
 *
     * Returns the unique name of the cache backend this provider produces.
     */
        return 1.0;  
     * {@link Optional#empty()} if no cache is available (e.g. capacity is zero).  
 * SPDX-License-Identifier: Apache-2.0
 *       sums the results to determine how much SSD capacity to reserve for  
 */
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
     *  
 *   <li><b>Construction phase</b> (inside {@code createComponents}): the plugin
package org.opensearch.plugins;
/**  
public interface BlockCacheProvider {
 * <ol>  
    /**  
     *
    /**  
     * @param settings         the node settings
 * <p>Returning {@link Optional#empty()} from {@link #getBlockCache()} is equivalent
 * </ol>  
     * <p>Called after {@code createComponents} completes.
     *
    }
    /**  
     * @param settings the node settings
     *  
        // Default no-op for backward compatibility.
     * Called by core after the budget phase to inform this plugin of the exact
     * <p>Used by warm-node capacity reporting ({@code WarmFsService}) to estimate  
    }
    /**  
 * no-cache behaviour. This lets a plugin no-op at runtime (e.g. when capacity
     * <p>Called before any {@code createComponents()} invocation so the budget  
     *  
/*  
     *
     * Returns the data-to-cache amplification ratio for this plugin's block cache.
     */  
 *
     * remote data. The default is {@code 1.0} (no amplification).  
     * @return the ratio; must be &ge; 1.0  
     *
 * @opensearch.experimental
     *
 */  
     * duplicate registrations at startup. Should match
     *
     * {@code createComponents()} instead of re-deriving their capacity.  
    Optional<BlockCache> getBlockCache();  
     * how many bytes of remote data this cache's SSD reservation can serve.
 *  
     *
    default void setReservedCapacityBytes(long bytes) {  
    String cacheName();
     * bytes reserved for it. Plugins should store this value and use it in
 *       creates its {@link BlockCache} instance using the capacity it requested,  
 *       then publishes it via {@link #getBlockCache()}. Core wires the instance
 *       {@link #requestedCapacityBytes} on every registered provider and
 *
    }
        return 0L;  
import java.util.Optional;
     * Returns the SSD bytes this plugin wants from the total warm-cache budget.
     */
     * can be partitioned before other caches are created. The default returns
 *   <li><b>Budget phase</b> (before {@code createComponents}): core calls
     * <p>Used as the map key when core collects all providers, and to detect  
 *
