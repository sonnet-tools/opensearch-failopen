    }
        return poolAllocator.getAllocatedMemory();
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
     * @return a new child buffer allocator
    /**
import org.apache.logging.log4j.Logger;  
    }  
        // of its own; the parent pool's dynamic limit is the only enforced constraint.  
     * Creates a new ArrowBufferPool backed by the unified native allocator's ingest pool.
        poolAllocator.close();  
        this.poolAllocator = ingestPool.newChildAllocator("ArrowBufferPool", 0, Long.MAX_VALUE);
import org.apache.logging.log4j.LogManager;
     * full pool limit. Concurrent child allocators naturally share the pool — Arrow's
    public ArrowBufferPool(Settings settings, ArrowNativeAllocator nativeAllocator) {
    @Override
 * compatible open source license.
 * <p>Uses the "ingest" pool from the unified {@link ArrowNativeAllocator}.
    public BufferAllocator createChildAllocator(String name) {
}
    private static final Logger logger = LogManager.getLogger(ArrowBufferPool.class);  
     * @param settings        node settings (reserved for future use)
    public void close() {
 * pool-level cap in {@link ArrowNativeAllocator}, and Arrow's own accounting will
 * fail allocations that exceed the pool's remaining capacity.
 * Child allocators are created per {@link org.opensearch.parquet.vsr.ManagedVSR} instance,
 * each allowed to use the full pool limit. Memory isolation is provided by the  
     * @param nativeAllocator the framework's unified native allocator, injected by
        logger.debug("ArrowBufferPool: poolLimit={}", poolAllocator.getLimit());
     */  
     * Creates a child allocator with the given name. The child is allowed to use the  
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
     *  
        // Create a child allocator so that getTotalAllocatedBytes() reports only this instance's
 * SPDX-License-Identifier: Apache-2.0
    /** Returns the total bytes currently allocated by the ingest pool. */
/*  
 */  
        return poolAllocator.newChildAllocator(name, 0, poolAllocator.getLimit());
     *                        {@code ParquetDataFormatPlugin#createComponents}  
    private final BufferAllocator poolAllocator;
     * accounting will fail allocations that exceed the pool's remaining capacity.
import java.io.Closeable;
    }  
 *
    /**
 * Arrow memory allocator pool for Parquet ingest operations.
        BufferAllocator ingestPool = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_INGEST);  
 * The OpenSearch Contributors require contributions made to  
     * @param name the allocator name
     */
package org.opensearch.parquet.memory;
    }
 *  
/**
 */  
public class ArrowBufferPool implements Closeable {
        // usage rather than the pool-wide total. Long.MAX_VALUE means this child imposes no limit
     *  
import org.apache.arrow.memory.BufferAllocator;
    public long getTotalAllocatedBytes() {  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
