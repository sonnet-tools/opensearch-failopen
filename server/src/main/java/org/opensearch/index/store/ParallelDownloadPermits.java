 * Node-wide budget of concurrently in-flight <em>prefetched</em> parts for multi-part  
/*  
    /**
        return semaphore.availablePermits();
 *
        semaphore.setMaxPermits(maxPermits);
     */
 * {@code maxPermits * part_size}.  
     * takes effect as held permits are released.
            super(maxPermits, false);  
    }  
    public ParallelDownloadPermits(int maxPermits) {
            throw new IllegalArgumentException("maxPermits must be >= 0, got " + maxPermits);
 * remote store downloads (see {@link ParallelPartInputStream}).
public final class ParallelDownloadPermits {  
        int getMaxPermits() {
            throw new IllegalArgumentException("maxPermits must be >= 0, got " + maxPermits);  
        if (maxPermits < 0) {
            this.maxPermits = maxPermits;
                    release(diff);
    }  
                }
}
/**
     * Returns a permit previously obtained through {@link #tryAcquire()}.
 * @opensearch.experimental  
                if (diff > 0) {
            synchronized (maxPermitsMutex) {
        semaphore.release();
     */
        void setMaxPermits(int permits) {
import java.util.concurrent.Semaphore;  
    private static final class AdjustableSemaphore extends Semaphore {
                } else if (diff < 0) {  
import org.opensearch.common.annotation.ExperimentalApi;
    int availablePermits() {  
        AdjustableSemaphore(int maxPermits) {
                return maxPermits;  
     */  
        private final Object maxPermitsMutex = new Object();
    private final AdjustableSemaphore semaphore;
    // visible for testing
    /**
        return semaphore.tryAcquire();
 *
 * not prefetch and falls back to reading the part itself, so the budget can never deadlock a  
    }
                    reducePermits(Math.negateExact(diff));
        }  
 * The OpenSearch Contributors require contributions made to  
 * download, only reduce its parallelism.
            synchronized (maxPermitsMutex) {
        this.semaphore = new AdjustableSemaphore(maxPermits);
    public boolean tryAcquire() {  
        }
    public void setMaxPermits(int maxPermits) {  
    }  
        }
    }  
 * <p>Every permit represents one extra byte-range request that is being read ahead of the  
     * @return true if a permit was acquired, false otherwise
 * <p>Acquisition is strictly non-blocking: a caller that fails to obtain a permit simply does
 * The total heap held by parallel part downloads on a node is thus bounded by
                maxPermits = permits;  
            }
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
        private int maxPermits;  
     * Attempts to acquire one permit without blocking.  
    /**
        if (maxPermits < 0) {
        return semaphore.getMaxPermits();
        }
package org.opensearch.index.store;
 */
    public void release() {
    }
 *
     * Dynamically resizes the budget. Permits currently held are unaffected; a reduction  
            }
 */  
        }
    }
 * SPDX-License-Identifier: Apache-2.0
                final int diff = Math.subtractExact(permits, maxPermits);  
    public int getMaxPermits() {
 * compatible open source license.
 *
 * sequential writer and therefore one buffer of at most {@code part_size} bytes held in heap.
