 * the hard per-query footprint budget (the byte budget derived from  
 *
 * the budget, the buffer manager enforces it on the producer-transport path, and the engine
 * and the backend's {@code ReduceSizeExceededException}.
     * hard disk ceiling {@code analytics.mpp.shuffle.spill.max_bytes}, or a spill write hit a disk-full  
    }  
        this.observedBytes = observed;  
 * then drains the accumulated {@code byte[]} chunks (held ON the JVM heap), so a node's live shuffle
     * @param observed bytes the node would hold on disk had the chunk been spilled
     * disk, a higher {@code spill.max_bytes}, or a narrower query.
    /** Bytes the buffer would have held had the chunk been accepted. */
 * This is distinct from the soft backpressure-reject path (admission returning {@code REJECT_RETRY}  
            observed,  
 * footprint is the SUM across all its buffers. A query whose own shuffle exceeds the per-query budget  
    public ShuffleBufferExceededException(long observed, long limit) {
 *  
                + " bytes). "  
                + "narrow the query, or set analytics.mpp.enabled=false. "
 * <p><b>Cross-boundary contract type</b> (hence in the SPI, not a backend module): the engine sets
                + "the query run by spilling buffered shuffle bytes to disk."
 */  
     * / I/O error. Unlike the on-heap budget breach, raising heap can't help — the remediation is more
        );
                + "Raise analytics.mpp.shuffle.spill.max_bytes (or free disk on the data node), "
 * which handles transient cross-query contention that WILL clear as other queries release buffers.
    public long observedBytes() {
                + "(observed="
            "Hash-shuffle query exceeded the disk-spill ceiling "
 * when the NODE total is momentarily over budget but the query still fits its share → sender retry),
    public static ShuffleBufferExceededException forDiskCeiling(long observed, long limit) {
     * @param limit    the configured {@code spill.max_bytes} disk ceiling
        this.limitBytes = limit;
                + observed
     */  
    }
 * compatible open source license.
    private final long observedBytes;
                + "Raise analytics.mpp.shuffle.node_budget_percent (or give the node more heap), "
                + "(observed="  
 * or set {@code analytics.mpp.enabled=false}.
/**
        return new ShuffleBufferExceededException(
 * <p>The shuffle consumer is buffer-all-then-drain: a worker blocks until both producer sides finish,
 * this file be licensed under the Apache-2.0 license or a
 * Thrown on a data node when a SINGLE hash-shuffle query's accumulated Arrow-IPC payload would exceed
                + limit
 * design</b>: it fails the query fast rather than letting the on-heap buffer grow until the node OOMs.
        super(  
 * The OpenSearch Contributors require contributions made to  
    /**
                + " bytes, limit="
     * The terminal failure when disk spill is ENABLED: the node-wide spill footprint would exceed the
 * {@code analytics.mpp.shuffle.node_budget_percent} — a percent of max heap; node budget == per-query
    }
        return limitBytes;
            "Hash-shuffle query exceeded its per-query on-heap budget "
     *  
}
        return observedBytes;  
 * SPDX-License-Identifier: Apache-2.0
                + " bytes), or a spill write hit a disk-full / I/O error. "
                + limit  
 * can never be consumed even on an otherwise idle node — so this breach is <b>non-retryable by
 *  
                + "Alternatively enable disk spill (analytics.mpp.shuffle.spill.enabled=true) to let "  
 *  
    }
package org.opensearch.analytics.spi;
            limit,
public final class ShuffleBufferExceededException extends RuntimeException {  
 * <p>Carries observed and limit byte counts. Operator remediations: raise  
        super(message);
                + " bytes, limit="
    private ShuffleBufferExceededException(long observed, long limit, String message) {
    private final long limitBytes;  
        this.limitBytes = limit;
    public long limitBytes() {
        );
    }
                + observed  
/*  
                + "narrow the query, or set analytics.mpp.enabled=false."  
 * recognizes the breach to surface an actionable failure. Mirrors {@link BroadcastSizeExceededException}  
 * max, so a lone query may use the whole budget but no single query may exceed it).
        this.observedBytes = observed;  
 * @opensearch.internal
    /** The configured hard ceiling, in bytes. */  
 * {@code analytics.mpp.shuffle.node_budget_percent} (or give the node more heap), narrow the query,
 */
 *
