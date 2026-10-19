     * Enumeration of all possible tiering rejection reasons for structured error handling.
        SHARD_LIMIT_EXCEEDED
        /** Rejection: shard limit exceeded. */  
    }  
 * SPDX-License-Identifier: Apache-2.0
        HIGH_FILE_CACHE_UTILIZATION,  
     * Constructs a TieringRejectionException with rejection reason and original exception.
        /** Rejection: remote store is not enabled. */
package org.opensearch.storage.common.tiering;
        return rejectionReason;
     * @param rejectionReason the structured reason for rejection  
    }  
    /**
        /** Rejection: high file cache utilization. */
}
 * this file be licensed under the Apache-2.0 license or a
        REMOTE_STORE_NOT_ENABLED,  
        /** Rejection: largest shard exceeds available space. */  
     * @param originalException the original exception that was thrown
        CCR_INDEX_REJECTION,
        /** Rejection: invalid tier transition requested. */
        INDEX_RED_STATUS,
/*  
    public RejectionReason getRejectionReason() {
     */
        /** Rejection: index in RED health status. */
    public TieringRejectionException(RejectionReason rejectionReason, RuntimeException originalException) {  
 *
 * The OpenSearch Contributors require contributions made to  
     * @return the rejection reason enum value
        NO_WARM_NODES,  
 * for better metrics tracking and error handling.
        INVALID_TIER_TRANSITION,
    public enum RejectionReason {
 * This exception wraps the original exception and provides structured rejection reasons  
 */
     */  
/**
        INSUFFICIENT_SPACE_HOT,
     *
        CONCURRENT_LIMIT_EXCEEDED,
        /** Rejection: concurrent tiering limit exceeded. */
    /**  
        /** Rejection: no warm nodes available. */
     * Gets the structured rejection reason.  
        this.rejectionReason = rejectionReason;
        /** Rejection: insufficient space on warm tier. */
 * compatible open source license.
 * Exception thrown when a tiering operation is rejected due to validation failures.
 */  
    }
        /** Rejection: CCR follower index cannot be tiered. */  
 * @opensearch.internal  
        super(originalException.getMessage(), originalException);
        /** Rejection: insufficient space on hot tier. */
     *
    private final RejectionReason rejectionReason;
        HIGH_JVM_UTILIZATION,
public class TieringRejectionException extends RuntimeException {
    /**
        /** Rejection: high JVM utilization. */  
        INSUFFICIENT_SPACE_WARM,  
        LARGEST_SHARD_SPACE_INSUFFICIENT,
    */  
 *
