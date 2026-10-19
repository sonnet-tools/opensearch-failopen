 *  
import java.io.Closeable;
import java.util.Set;
package org.opensearch.arrow.spi;
    void addPoolGroupLimitListener(PoolGroup group, Consumer<Long> listener);  
     * Returns all registered pool names.
     * @return a handle to update stats from the native layer
     * Updates the minimum guaranteed bytes for a pool.  
     */
        long limit();  
     * @param group the group this pool belongs to for aggregated stats, or null  
    /**
/*  
 * guaranteed allocation and a maximum burst limit. Implementations may
public interface NativeAllocator extends Closeable {  
     * Handle for a virtual pool. Plugins update stats via this handle.  
     */
    PoolHandle getOrCreatePool(String poolName, long min, long max, PoolGroup group);  
     */
     */
     */
import java.util.function.Consumer;  
 *
     * @param poolName logical pool name
     *
     * Subsequent calls with the same name return the existing pool (first-call config wins).
         * @param peakBytes peak allocated bytes
 */
     * @param min minimum guaranteed bytes
         * @param childLimit maximum bytes for the child  
     * @param refresher runnable that updates pool stats  
         *
         * @return a child handle
 * Unified native memory allocator interface.
         * Update the current usage stats.
 * @opensearch.api
     */
        long peakBytes();  
     */
        /** Returns the current allocated bytes. */
     * @return an opaque pool handle
    /**  
 * this file be licensed under the Apache-2.0 license or a
         * @param allocatedBytes current allocated bytes  
        long allocatedBytes();  
     */
         * Creates a named child allocation within this pool.  
     * The consumer receives the new total effective limit (sum of all pools in the group).
        long limit();  
     * @param poolName logical pool name
    /**
         *
import java.util.function.Supplier;
     * @param newLimit new maximum bytes for the pool  
    void addStatsRefresher(Runnable refresher);
     *
         */
        /**  
        /** Releases this allocation handle. */
    /**
    /**
     * @param listener consumer that receives the new grouped limit in bytes
     * @param group the pool group to listen on  
     *  
 * <p>Manages memory pools under a shared budget. Each pool has a minimum  
        /** Returns current allocated bytes. */
     * Registers a listener invoked when the effective limit of a pool group changes.  
    /**
    /**
     * Registers a virtual pool with initial min/max and a callback
         * @param childName name for debugging
    Set<String> getAllPoolNames();
        /**
        void updateStats(long allocatedBytes, long peakBytes);  
 * The OpenSearch Contributors require contributions made to  
    interface VirtualPoolHandle {
 * compatible open source license.
     *
/**  
     * Opaque handle to a memory pool.
     */  
    interface PoolHandle {  
 * SPDX-License-Identifier: Apache-2.0
     * @param newMin new minimum bytes  
    void setPoolLimit(String poolName, long newLimit);
     * @param poolName logical pool name
    }
     * @param supplier returns [allocatedBytes, residentBytes]
 *
        /** Returns the configured limit. */
     * @param min minimum guaranteed bytes  
    /**
    /**
    /**  
     * Returns the named pool, creating it on first access.  
         */
     *
     * @param group the group this pool belongs to for aggregated stats
     * Adds a callback invoked before stats collection to refresh pool usage data.
    }
        /** Returns current limit. */
     * Updates the effective limit of an existing pool.  
 */  
     * @param poolName logical pool name  
     * invoked when the pool's limit changes.  
        /** Returns peak allocated bytes. */
    void setNativeMemoryStatsSupplier(Supplier<long[]> supplier);  
 * redistribute unused capacity across pools.
        long peakBytes();  
    VirtualPoolHandle registerVirtualPool(String poolName, long min, long max, PoolGroup group, Consumer<Long> limitSetter);  
        void close();  
     *
     * @param max initial maximum bytes (the pool's starting limit)
}
     * @param max maximum bytes this pool can allocate
     *
    void setPoolMin(String poolName, long newMin);
        PoolHandle newChild(String childName, long childLimit);  
     * @param limitSetter callback invoked when the pool limit changes  
        /** Returns the peak memory allocation. */
        long allocatedBytes();  
     * Sets the supplier for process-wide native memory stats.
     */
