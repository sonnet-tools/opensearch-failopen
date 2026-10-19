 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/**
 * {@link ShuffleBufferAccess#awaitReady} on the returned handle.
     * @return the number of buffers removed
     * failure). Idempotent — a no-op when the buffer is absent.  
 *  
     */
     * absent. Producer-side transport calls also use this lazy-creation pattern so the
 * <p>Implemented by analytics-engine's {@code ShuffleBufferManager}; the SPI exposes only the
 */  
package org.opensearch.analytics.spi;
 * consumer-side surface so backend handlers don't need a compile-time dependency on the
 * {@code (queryId, targetStageId, partitionIndex)} tuple. Backend hash-shuffle scan handlers  
public interface ShuffleBufferRegistry {
 * @opensearch.internal
    void removeBuffer(String queryId, int targetStageId, int partitionIndex);
/*  
     */
     * Removes the buffer for {@code (queryId, targetStageId, partitionIndex)} after its consuming
     * worker task has drained it. The buffer holds the partition's shuffled payload as on-heap  
    /**  
     * Returns the buffer for {@code (queryId, targetStageId, partitionIndex)}, creating it if
 *
 */  
 *
     * own terminal path. Idempotent — a no-op when the query has no buffers.
    ShuffleBufferAccess getOrCreate(String queryId, int targetStageId, int partitionIndex);
    /**
     *  
     * abnormally (task cancellation / abort) where individual consumer tasks may never reach their
     * consumer's first call here doesn't race the producer's first packet.  
}
 * call {@link #getOrCreate} when their {@code ShuffleScanInstructionNode} apply fires, then
     * Backstop for the per-buffer {@link #removeBuffer} cleanup: called when a query terminates  
     */
 * this file be licensed under the Apache-2.0 license or a
 * engine plugin's internals.  
 * compatible open source license.
    int clearForQuery(String queryId);  
     * {@code byte[]} lists; without removal these accumulate for the JVM's lifetime across queries
     * Removes ALL buffers belonging to {@code queryId} (every stage / partition on this node).
 * Per-node lookup that hands back a {@link ShuffleBufferAccess} for a given
     * and eventually OOM the node. Called from the consumer fragment's terminal path (success or
    /**
