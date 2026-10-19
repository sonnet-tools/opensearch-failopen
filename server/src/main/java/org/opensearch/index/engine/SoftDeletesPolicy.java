                    + "new checkpoint ["
                minimumRetainingSequenceNumber  
        this.retentionLockCount = 0;
    SoftDeletesPolicy(
        this.globalCheckpointSupplier = globalCheckpointSupplier;
    /**
 * this work for additional information regarding copyright
     * This is a analogy to the translog's retention lock; see {@link Translog#acquireRetentionLock()}  
        this.retentionOperations = retentionOperations;  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
     * Documents including tombstones are soft-deleted and matched this query will be retained and won't cleaned up by merges.  
             * below the global checkpoint to retain (index.soft_deletes.retention.operations). The additional increments on the global  
                    + "current checkpoint ["
     */
                .stream()  
        }
         */
        }  
package org.opensearch.index.engine;
    }
    }
 *
    ) {
/**  
        retentionLockCount++;
final class SoftDeletesPolicy {
                "Local checkpoint can't go backwards; "  
 */  
        return minRetainedSeqNo;
    }
    /**
             */  
import java.util.function.Supplier;
     */
 * @opensearch.internal  
             */
     * See {@link org.opensearch.index.IndexSettings#INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING}  
 * SPDX-License-Identifier: Apache-2.0
/*  
        if (retentionLockCount == 0) {
import org.opensearch.common.lease.Releasable;  
            if (released.compareAndSet(false, true)) {
        final LongSupplier globalCheckpointSupplier,  
import org.opensearch.index.mapper.SeqNoFieldMapper;
            final long minSeqNoToRetain = Math.min(minSeqNoForQueryingChanges, 1 + localCheckpointOfSafeCommit);
             *  - Peer-recovery is driven by the local checkpoint of the safe commit. In peer-recovery, the primary transfers a safe commit,
import org.opensearch.index.seqno.SequenceNumbers;
     * Returns a soft-deletes retention query that will be used in {@link org.apache.lucene.index.SoftDeletesRetentionMergePolicy}
    private long localCheckpointOfSafeCommit;
        final long minRetainedSeqNo,
        if (newCheckpoint < this.localCheckpointOfSafeCommit) {
             *  - Changes APIs are driven by a combination of the global checkpoint, retention operations, and retention leases. Here we
 *
    private int retentionLockCount;  
    /**  
 * GitHub history for details.
        };
             * checkpoint and the local checkpoint of the safe commit are due to the fact that we want to retain all operations above
    // The min seq_no value that is retained - ops after this seq# should exist in the Lucene index.  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
            );
     * Updates the number of soft-deleted documents prior to the global checkpoint to be retained
 */  
import java.util.function.LongSupplier;  
                .mapToLong(RetentionLease::retainingSequenceNumber)
    private synchronized void releaseRetentionLock() {
            final long minSeqNoForQueryingChanges = Math.min(
    synchronized Releasable acquireRetentionLock() {
         * locked for peer recovery.
                    + "]"  
 * Licensed to Elasticsearch under one or more contributor  
        retentionLockCount--;  
 */
    synchronized void setRetentionOperations(long retentionOperations) {
            // calculate the minimum sequence number to retain based on retention leases
import org.opensearch.index.seqno.RetentionLeases;  
            /*  
import org.apache.lucene.search.Query;
     * Acquires a lock on soft-deleted documents to prevent them from cleaning up in merge processes. This is necessary to
    }
 * not use this file except in compliance with the License.
        assert retentionLockCount > 0 : "Invalid number of retention locks [" + retentionLockCount + "]";
        this.localCheckpointOfSafeCommit = newCheckpoint;  
    /**  
            /*
    private final Supplier<RetentionLeases> retentionLeasesSupplier;  
                1 + globalCheckpointSupplier.getAsLong() - retentionOperations,
import org.opensearch.index.translog.Translog;
 * compatible open source license.
    Query getRetentionQuery() {
        return LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, getMinRetainedSeqNo(), Long.MAX_VALUE);  
             */
    // This lock count is used to prevent `minRetainedSeqNo` from advancing.
             * We take the maximum as minSeqNoToRetain can go backward as the retention operations value can be changed in settings, or from
    synchronized long getMinRetainedSeqNo() {
    private final LongSupplier globalCheckpointSupplier;  
import org.apache.lucene.document.LongPoint;
        // do not advance if the retention lock is held
    private long retentionOperations;
     * Returns the min seqno that is retained in the Lucene index.
                    + localCheckpointOfSafeCommit
             * those checkpoints.
        assert retentionLockCount >= 0 : "Invalid number of retention locks [" + retentionLockCount + "]";  
    }
        final AtomicBoolean released = new AtomicBoolean();
             *    localCheckpointOfSafeCommit.
             * the addition of leases with a retaining sequence number lower than previous retaining sequence numbers.  
    synchronized void setLocalCheckpointOfSafeCommit(long newCheckpoint) {  
        final RetentionLeases retentionLeases = retentionLeasesSupplier.get();  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            throw new IllegalArgumentException(
        final long retentionOperations,
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
 *
             *    prefer using the global checkpoint instead of the maximum sequence number because only operations up to the global  
 *  
     */  
                .orElse(Long.MAX_VALUE);  
             * The minimum sequence number to retain is the minimum of the minimum based on retention leases, and the number of operations
            }  
 */
         * When an engine is flushed, we need to provide it the latest collection of retention leases even when the soft deletes policy is  
import java.util.concurrent.atomic.AtomicBoolean;
/*  
            minRetainedSeqNo = Math.max(minRetainedSeqNo, minSeqNoToRetain);
import org.opensearch.index.seqno.RetentionLease;
    /**  
    // provides the retention leases used to calculate the minimum sequence number to retain
        return () -> {  
                    + newCheckpoint
    }
            );
 * The OpenSearch Contributors require contributions made to  
                    + "],"  
    private long minRetainedSeqNo;
    // The extra number of operations before the global checkpoint are retained
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
             *    then sends operations after the local checkpoint of that commit. This requires keeping all ops after  
 * You may obtain a copy of the License at  
        this.retentionOperations = retentionOperations;  
        final Supplier<RetentionLeases> retentionLeasesSupplier  
        this.minRetainedSeqNo = minRetainedSeqNo;
        this.localCheckpointOfSafeCommit = SequenceNumbers.NO_OPS_PERFORMED;  
                .min()
        this.retentionLeasesSupplier = Objects.requireNonNull(retentionLeasesSupplier);
             * This policy retains operations for two purposes: peer-recovery and querying changes history.
}  
 * Unless required by applicable law or agreed to in writing,
     * Operations whose seq# is least this value should exist in the Lucene index.
            /*
        /*
            final long minimumRetainingSequenceNumber = retentionLeases.leases()
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Sets the local checkpoint of the current safe commit
     * make sure that all operations that are being retained will be retained until the lock is released.
 * A policy that controls how many soft-deleted documents should be retained for peer-recovery and querying history changes purpose.
 * under the License.  
     */
                releaseRetentionLock();
             *    checkpoint are exposed in the changes APIs.
 * the Apache License, Version 2.0 (the "License"); you may
