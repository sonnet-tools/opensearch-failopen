 * this file be licensed under the Apache-2.0 license or a
}
 *
    }
    /**  
    private final BufferAllocator importStagingAllocator;
     * the root so an import cannot fail part-way through an array, and long-lived because the Flight
     * Returns the node-scoped allocator Arrow C Data imports are staged on — unbounded and parented at
 * outstanding when {@code ArrowNativeAllocator.close()} walks the pool tree at
 * it, so a node has exactly one whatever the execution path.
 * Owns the coordinator-side {@link BufferAllocator} child of the framework's
     * {@code AnalyticsSearchService}; consumers must not close it.
     * @param importStagingAllocator the node-scoped import staging allocator owned by
 * {@code IllegalStateException: Allocator[ROOT] closed with outstanding child allocators}.
    public BufferAllocator getAllocator() {
 * <p>Without this, the allocator would be created and held by the Guice-managed  
 * {@code POOL_QUERY} pool. Acts as a thin Guice-bound holder so the analytics plugin
 * The OpenSearch Contributors require contributions made to  
        this.importStagingAllocator = importStagingAllocator;
 * {@link DefaultPlanExecutor} (which has no close hook), and would still be
    /** Returns the wrapped allocator. Consumers must not close it directly. */
 */  
 * <p>Also carries the node-scoped Arrow import staging allocator so the coordinator-reduce path can  
     */
     * having created the allocator under the right parent.  
     * {@code POOL_QUERY}). The caller (the plugin) retains responsibility for
        this.allocator = allocator;  
public final class CoordinatorAllocatorHandle implements AutoCloseable {
import org.apache.arrow.memory.BufferAllocator;
 * SPDX-License-Identifier: Apache-2.0
     * transport keeps charging it after the importing stream closes. Owned by  
    }
 *
 * can close the allocator deterministically on {@code Plugin.close()} — before the  
/*  
package org.opensearch.analytics.exec;
    public CoordinatorAllocatorHandle(BufferAllocator allocator, BufferAllocator importStagingAllocator) {
    }
/**  
 */  
     *        {@code AnalyticsSearchService}; borrowed here, never closed by this handle  
 * <p>The plugin owns the lifetime; consumers ({@code DefaultPlanExecutor}) only  
 * reach it. That one is <b>borrowed, not owned</b>: {@code AnalyticsSearchService} creates and closes
    private final BufferAllocator allocator;  
 *
     * Wraps an already-constructed coordinator allocator (typically a child of
 *
        allocator.close();  
    public BufferAllocator getImportStagingAllocator() {  
        return importStagingAllocator;
     */
 * compatible open source license.
    public void close() {
    @Override
 * shutdown — causing {@code BaseAllocator.close()} to throw  
    /**  
 * arrow-base plugin closes the root allocator.
        return allocator;  
     *
    }
 * read the underlying allocator via {@link #getAllocator()}.
