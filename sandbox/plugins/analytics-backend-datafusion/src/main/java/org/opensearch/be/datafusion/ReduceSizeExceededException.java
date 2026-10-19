 * before executing the join/aggregate. For large inputs (e.g. a TPC-H sf=10 join) that buffer  
        );  
            "Coordinator-reduce buffer exceeded the per-query memory budget "
                + limit  
 * narrow the query (better filters / fewer columns on the reduced inputs), or flip
 * would exceed the per-query coordinator memory budget (the limit of the query's Arrow
/**  
                + "Raise analytics.coordinator.buffer_limit, narrow the query, or set analytics.mpp.enabled=false."
 * {@code TaskCancelledException} — the sink accounts for the buffer size <em>before</em> each  
 *  
 * allocation and fails fast with this exception when the budget would be exceeded. Mirrors
 * <p>The coordinator-centric reduce buffers every reduced input fully in off-heap Arrow memory
 * Thrown by {@link DatafusionMemtableReduceSink} when buffering the next reduce input batch
 */  
package org.opensearch.be.datafusion;
 * compatible open source license.
                + " bytes, limit="
                + " bytes). "
 * allocator, set by {@code analytics.coordinator.buffer_limit}).  
}
 * <p>Operators have three remediations: raise the cap ({@code analytics.coordinator.buffer_limit}),
 */  
/*  
 * The OpenSearch Contributors require contributions made to  
                + "(observed="  
 * SPDX-License-Identifier: Apache-2.0
 *
public final class ReduceSizeExceededException extends RuntimeException {
 *
 * {@code analytics.mpp.enabled=false} to revert to a non-MPP path.  
    }
    public ReduceSizeExceededException(long observed, long limit) {  
 *
 * @opensearch.internal
        super(
 * fire mid-allocation — which leaks the in-flight buffers and surfaces as an opaque
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
 * can exceed the per-query budget. Rather than letting a raw {@link org.apache.arrow.memory.OutOfMemoryException}
 * this file be licensed under the Apache-2.0 license or a
 * {@link BroadcastSizeExceededException}.
                + observed
