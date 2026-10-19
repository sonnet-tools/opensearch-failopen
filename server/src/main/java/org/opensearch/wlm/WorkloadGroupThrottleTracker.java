        return inFlightByBucket.size();
     *
        return admitted[0] == null ? null : releaseOnce(bucketKey, admitted[0]);
     * is actually evicted once it drains rather than merely reading back as zero.
    private Releasable releaseOnce(String bucketKey, AtomicInteger counter) {  
    }  
 * compatible open source license.
                admitted[0] = new AtomicInteger(1);
        });
 * Tracks in-flight requests per throttle bucket on a single node and enforces a per-node cap. A bucket's counter exists
    }  
     */  
    private final Map<String, AtomicInteger> inFlightByBucket = new ConcurrentHashMap<>();
     */  
 */  
import java.util.concurrent.atomic.AtomicBoolean;  
                release(bucketKey, counter);
        };  
            }
import java.util.Map;
public class WorkloadGroupThrottleTracker {
 */  
     * Attempts to admit one request into the bucket under the per-node limit. Returns {@code null} rather than throwing
        inFlightByBucket.compute(bucketKey, (k, existing) -> {
        assert nodeLimit > 0 : "nodeLimit must be positive";
/**  
            return existing;  
import org.opensearch.common.annotation.ExperimentalApi;
    int inFlight(String bucketKey) {
        return counter == null ? 0 : counter.get();  
 * The OpenSearch Contributors require contributions made to  
            assert existing == counter : "released a counter no longer mapped for bucket [" + bucketKey + "]";  
            }  
     */  
    /**  
     * Note this returns 0 both for an absent bucket and for one that is present with a zero count; use
            }  
    /**
        return () -> {
import java.util.concurrent.atomic.AtomicInteger;
}
 * refused acquire never publishes occupancy it is about to undo.
 * SPDX-License-Identifier: Apache-2.0
    }
    /**  
package org.opensearch.wlm;
     * @param nodeLimit the positive maximum number of concurrent in-flight requests this node may admit for the bucket  
        AtomicInteger counter = inFlightByBucket.get(bucketKey);
 * the per-key {@link ConcurrentHashMap#compute} region makes the limit check and increment one atomic transition, so a
     *         {@code null} if the bucket is already at the limit
        });
        final AtomicInteger[] admitted = new AtomicInteger[1];
     * Number of buckets currently holding a counter. Package-private for tests, which use it to assert that a bucket
            if (existing == null) {  
            admitted[0] = existing;
 *
@ExperimentalApi
     * {@link #bucketCount()} to distinguish them.
    public Releasable tryAcquire(String bucketKey, int nodeLimit) {
            existing.incrementAndGet();
    // The only decrement site; stays inside compute() so eviction can't race an acquire.  
     * Current in-flight count for a bucket, or 0 if the bucket has no active requests. Package-private for tests.  
import java.util.concurrent.ConcurrentHashMap;
 * scales with active buckets rather than the total population of users/roles. Fully local (no cross-node coordination);  
/*  
 * only while it has at least one in-flight request (created on first acquire, removed when it drains to zero), so memory
    int bucketCount() {
        inFlightByBucket.compute(bucketKey, (k, existing) -> {
     * rejection stack trace on the search hot path.  
    private void release(String bucketKey, AtomicInteger counter) {
     * when full, so the caller decides what a breach means (reject, or observe-only in MONITOR) without allocating a
    }
                return existing; // at the cap: the count is left untouched, so there is nothing to roll back
import org.opensearch.common.lease.Releasable;
            if (existing.get() >= nodeLimit) {
     * @param bucketKey the throttle bucket identifier
        // Check and increment in one compute() so a refused acquire never publishes a count it must roll back.  
            return counter.decrementAndGet() <= 0 ? null : existing;
    // Guards against a double close decrementing twice.
     * @return a {@link Releasable} that decrements the bucket's in-flight count exactly once when closed, or
 * this file be licensed under the Apache-2.0 license or a
    }  
            if (released.compareAndSet(false, true)) {  
        AtomicBoolean released = new AtomicBoolean(false);
                return admitted[0];
