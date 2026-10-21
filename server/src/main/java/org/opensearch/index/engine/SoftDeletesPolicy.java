            /*
    synchronized Releasable acquireRetentionLock() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                .stream()
                .mapToLong(RetentionLease::retainingSequenceNumber)
import java.util.function.LongSupplier;
             *    localCheckpointOfSafeCommit.
    ) {
        }
                minimumRetainingSequenceNumber
    }
             */
 * not use this file except in compliance with the License.
        final Supplier<RetentionLeases> retentionLeasesSupplier
 * Unless required by applicable law or agreed to in writing,
 */
 * KIND, either express or implied.  See the License for the
    synchronized void setLocalCheckpointOfSafeCommit(long newCheckpoint) {
/*
        this.minRetainedSeqNo = minRetainedSeqNo;
            );
             *  - Peer-recovery is driven by the local checkpoint of the safe commit. In peer-recovery, the primary transfers a safe commit,
 */
    }
     */
 * license agreements. See the NOTICE file distributed with
                    + "current checkpoint ["
/**
     * Updates the number of soft-deleted documents prior to the global checkpoint to be retained
        };
    synchronized void setRetentionOperations(long retentionOperations) {
        this.retentionLockCount = 0;
     * This is a analogy to the translog's retention lock; see {@link Translog#acquireRetentionLock()}
import org.opensearch.index.translog.Translog;
}
                .orElse(Long.MAX_VALUE);
             * below the global checkpoint to retain (index.soft_deletes.retention.operations). The additional increments on the global
    private int retentionLockCount;
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException(
import org.opensearch.index.seqno.RetentionLease;
 *
 *
             */
                    + "new checkpoint ["
        final long minRetainedSeqNo,
        final long retentionOperations,
             * This policy retains operations for two purposes: peer-recovery and querying changes history.
 *
    }
 *
        /*
        assert retentionLockCount >= 0 : "Invalid number of retention locks [" + retentionLockCount + "]";
                .min()
        this.retentionOperations = retentionOperations;
            minRetainedSeqNo = Math.max(minRetainedSeqNo, minSeqNoToRetain);
     * make sure that all operations that are being retained will be retained until the lock is released.
 * You may obtain a copy of the License at
            final long minimumRetainingSequenceNumber = retentionLeases.leases()
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
             *    prefer using the global checkpoint instead of the maximum sequence number because only operations up to the global
        this.localCheckpointOfSafeCommit = newCheckpoint;
     * Sets the local checkpoint of the current safe commit
     * Returns the min seqno that is retained in the Lucene index.
import java.util.concurrent.atomic.AtomicBoolean;
                    + localCheckpointOfSafeCommit
    }
                1 + globalCheckpointSupplier.getAsLong() - retentionOperations,
        assert retentionLockCount > 0 : "Invalid number of retention locks [" + retentionLockCount + "]";
             * The minimum sequence number to retain is the minimum of the minimum based on retention leases, and the number of operations
     * Returns a soft-deletes retention query that will be used in {@link org.apache.lucene.index.SoftDeletesRetentionMergePolicy}
             *    then sends operations after the local checkpoint of that commit. This requires keeping all ops after
 * software distributed under the License is distributed on an
import org.apache.lucene.search.Query;
            /*
             * the addition of leases with a retaining sequence number lower than previous retaining sequence numbers.
    Query getRetentionQuery() {
    private final Supplier<RetentionLeases> retentionLeasesSupplier;
             * checkpoint and the local checkpoint of the safe commit are due to the fact that we want to retain all operations above
            final long minSeqNoForQueryingChanges = Math.min(
    }
    // This lock count is used to prevent `minRetainedSeqNo` from advancing.
import org.apache.lucene.document.LongPoint;
    private long localCheckpointOfSafeCommit;
    }
    private long minRetainedSeqNo;
 * @opensearch.internal
import java.util.Objects;
        retentionLockCount--;
import org.opensearch.index.seqno.SequenceNumbers;
 * specific language governing permissions and limitations
     */
             * those checkpoints.
         * locked for peer recovery.
    synchronized long getMinRetainedSeqNo() {
    /**
/*
            );
                    + "]"
     * Operations whose seq# is least this value should exist in the Lucene index.
                "Local checkpoint can't go backwards; "
                    + newCheckpoint
        if (newCheckpoint < this.localCheckpointOfSafeCommit) {
package org.opensearch.index.engine;
        this.localCheckpointOfSafeCommit = SequenceNumbers.NO_OPS_PERFORMED;
    // The min seq_no value that is retained - ops after this seq# should exist in the Lucene index.
    /**
     * See {@link org.opensearch.index.IndexSettings#INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING}
import java.util.function.Supplier;
    /**
        final AtomicBoolean released = new AtomicBoolean();
         */
    private long retentionOperations;
import org.opensearch.index.seqno.RetentionLeases;
     * Documents including tombstones are soft-deleted and matched this query will be retained and won't cleaned up by merges.
    /**
 * under the License.
     * Acquires a lock on soft-deleted documents to prevent them from cleaning up in merge processes. This is necessary to
        retentionLockCount++;
     */
            if (released.compareAndSet(false, true)) {
    // provides the retention leases used to calculate the minimum sequence number to retain
        return LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, getMinRetainedSeqNo(), Long.MAX_VALUE);
        if (retentionLockCount == 0) {
     */
        // do not advance if the retention lock is held
        this.retentionLeasesSupplier = Objects.requireNonNull(retentionLeasesSupplier);
            }
        this.globalCheckpointSupplier = globalCheckpointSupplier;
                    + "],"
        return () -> {
    private synchronized void releaseRetentionLock() {
    SoftDeletesPolicy(
/*
        final RetentionLeases retentionLeases = retentionLeasesSupplier.get();
    // The extra number of operations before the global checkpoint are retained
 */
 * SPDX-License-Identifier: Apache-2.0
        final LongSupplier globalCheckpointSupplier,
import org.opensearch.common.lease.Releasable;
             * We take the maximum as minSeqNoToRetain can go backward as the retention operations value can be changed in settings, or from
        this.retentionOperations = retentionOperations;
 * ownership. Elasticsearch licenses this file to you under
        }
     */
    /**
             *    checkpoint are exposed in the changes APIs.
         * When an engine is flushed, we need to provide it the latest collection of retention leases even when the soft deletes policy is
 * Modifications Copyright OpenSearch Contributors. See
    }
            final long minSeqNoToRetain = Math.min(minSeqNoForQueryingChanges, 1 + localCheckpointOfSafeCommit);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The OpenSearch Contributors require contributions made to
                releaseRetentionLock();
 */
        return minRetainedSeqNo;
 * GitHub history for details.
 * A policy that controls how many soft-deleted documents should be retained for peer-recovery and querying history changes purpose.
final class SoftDeletesPolicy {
             */
import org.opensearch.index.mapper.SeqNoFieldMapper;
             *  - Changes APIs are driven by a combination of the global checkpoint, retention operations, and retention leases. Here we
 * the Apache License, Version 2.0 (the "License"); you may
            /*
            // calculate the minimum sequence number to retain based on retention leases
    private final LongSupplier globalCheckpointSupplier;
