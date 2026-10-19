 *  
        return observedBytes;  
 * @opensearch.internal
    public BroadcastSizeExceededException(long observed, long limit) {
    /** The configured cap, in bytes. */  
 *
 * failing — pre-flight row estimates can under-count filter/semijoin selectivity, so a build CBO  
        super(  
    /** Bytes the build side actually accumulated before the cap tripped. */
                + observed  
                + " bytes). "  
    public long limitBytes() {
    }  
 * (sourced from {@code analytics.mpp.broadcast.max_bytes}).
            "Broadcast build-side payload exceeded the configured limit "
 * judged small enough can still overflow at runtime.
                + "Raise analytics.mpp.broadcast.max_bytes, narrow the query, or set analytics.mpp.enabled=false."
 *
 * <p>This is a <b>cross-boundary contract type</b>, which is why it lives in the SPI rather than a
 */  
 * {@link ExchangeSinkProvider#createBroadcastCaptureSink(org.apache.arrow.memory.BufferAllocator, org.apache.calcite.rel.type.RelDataType, long)}
 *  
 */
package org.opensearch.analytics.spi;
/*  
}
    }
        return limitBytes;
    private final long observedBytes;
 * enforces it, and the engine must recognize the breach to react. The coordinator's  
 * Thrown by a backend's broadcast build-side capture sink when the accumulated build payload
 * SPDX-License-Identifier: Apache-2.0
                + " bytes, limit="
/**
 * <p>Carries the observed and limit byte counts so callers can log an actionable message.  
 * backend module: the engine sets the cap, the SPI carries it into the backend, the backend
 * compatible open source license.
 * {@code analytics.mpp.enabled=false}.
 * Operator remediations: raise {@code analytics.mpp.broadcast.max_bytes}, narrow the query, or set
 * exceeds the runtime cap the engine passed via  
        );
        this.limitBytes = limit;
    public long observedBytes() {
    }
        this.observedBytes = observed;  
                + limit
 * broadcast made ineligible, so CBO falls back to hash-shuffle / coordinator-centric instead of
                + "(observed="
 * this file be licensed under the Apache-2.0 license or a
public final class BroadcastSizeExceededException extends RuntimeException {  
    private final long limitBytes;  
 * {@code DefaultPlanExecutor} catches it (walking the cause chain) and re-plans the query with
 * The OpenSearch Contributors require contributions made to  
