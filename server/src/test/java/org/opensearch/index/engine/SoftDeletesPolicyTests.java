 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
                    "test"
        final long primaryTerm = randomNonNegativeLong();
    public void testWhenLocalCheckpointOfSafeCommitDictatesThePolicy() {
        assert minimumRetainingSequenceNumber.isPresent() : leases;
        final AtomicLong[] retainingSequenceNumbers = new AtomicLong[randomIntBetween(0, 8)];
 * Modifications Copyright OpenSearch Contributors. See
            final List<RetentionLease> leases = new ArrayList<>(retainingSequenceNumbers.length);
package org.opensearch.index.engine;
 * this file be licensed under the Apache-2.0 license or a
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.seqno.RetentionLeases;
 */
        final Supplier<RetentionLeases> retentionLeasesSupplier = () -> {
        assertThat(policy.getMinRetainedSeqNo(), equalTo(minRetainedSeqNo));
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
        for (int i = 0; i < retainingSequenceNumbers.length; i++) {
            leases.add(
 *
            // setup leases where the minimum retained sequence number is more than the policy dictated by the global checkpoint
            retainingSequenceNumbers[i] = new AtomicLong();
        final long localCheckpointOfSafeCommit = randomLongBetween(1 + globalCheckpoint.get() - retentionOperations + 1, Long.MAX_VALUE);
    public void testWhenGlobalCheckpointDictatesThePolicy() {
import java.util.ArrayList;
                final long minimumRetainingSequenceNumber = Arrays.stream(retainingSequenceNumbers)
        final int numberOfLeases = randomIntBetween(1, 16);
            final Query query = policy.getRetentionQuery();
        final AtomicLong globalCheckpoint = new AtomicLong(
            Collections.unmodifiableCollection(new ArrayList<>(leases))
import org.opensearch.common.lease.Releasable;
    /**
            for (int i = 0; i < retainingSequenceNumbers.length; i++) {
        };
        final Collection<RetentionLease> leases = new ArrayList<>();
        final int numberOfLeases = randomIntBetween(0, 16);
            primaryTerm,
        long minRetainedSeqNo = policy.getMinRetainedSeqNo();
        final long minimumRetainingSequenceNumber = Arrays.stream(retainingSequenceNumbers)
    }
        }
            policy.setLocalCheckpointOfSafeCommit(safeCommitCheckpoint);
        for (int i = 0; i < iters; i++) {
                retainingSequenceNumber.set(randomLongBetween(retainingSequenceNumber.get(), Math.max(globalCheckpoint.get(), 0L)));
        );
                    randomNonNegativeLong(),
/*
public class SoftDeletesPolicyTests extends OpenSearchTestCase {
            version,
        long safeCommitCheckpoint = globalCheckpoint.get();
        }
 * ownership. Elasticsearch licenses this file to you under
        locks.forEach(Releasable::close);
     * Makes sure we won't advance the retained seq# if the retention lock is held
        long retainedOps = between(0, 10000);
                )
        minRetainedSeqNo = Math.max(minRetainedSeqNo, retainedSeqNo);
 * license agreements. See the NOTICE file distributed with
            leases.add(
        long retainedSeqNo = Math.min(
                leases.add(new RetentionLease(Integer.toString(i), retainingSequenceNumbers[i].get(), 0L, "test"));
        final int retentionOperations = randomIntBetween(0, 1024);
            version,
    }
            // Release some locks
                    randomNonNegativeLong(),
        );
                    Integer.toString(i),
                    "test"
        for (int i = 0; i < numberOfLeases; i++) {
            randomLongBetween(Math.max(0, localCheckpointOfSafeCommit + retentionOperations), Long.MAX_VALUE - 1)
            if (randomBoolean()) {
        AtomicLong globalCheckpoint = new AtomicLong(NO_OPS_PERFORMED);
import java.util.List;
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
 * compatible open source license.
            );
            for (final AtomicLong retainingSequenceNumber : retainingSequenceNumbers) {
            .orElse(Long.MAX_VALUE);
        int iters = scaledRandomIntBetween(10, 1000);
 * not use this file except in compliance with the License.
import java.util.Arrays;
        List<Releasable> locks = new ArrayList<>();
            releasingLocks.forEach(Releasable::close);
        for (int i = 0; i < numberOfLeases; i++) {
            .min()
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(
        final Collection<RetentionLease> leases = new ArrayList<>();
            }
            // getting the query has side effects, updating the internal state of the policy
 */
                long retainedSeqNo = Math.min(
        for (int i = 0; i < numberOfLeases; i++) {
            // Advances the global checkpoint and the local checkpoint of a safe commit
            if (locks.isEmpty()) {
import java.util.Collections;
            return new RetentionLeases(1, 1, leases);
}
                    randomLongBetween(0, Long.MAX_VALUE - retentionOperations - 1),
                    "test"
 */
            assertThat(policy.getMinRetainedSeqNo(), equalTo(minRetainedSeqNo));
            globalCheckpoint.addAndGet(between(0, 1000));
            primaryTerm,
                );
        );
 * SPDX-License-Identifier: Apache-2.0
        );
                    Integer.toString(i),
 *
 * The OpenSearch Contributors require contributions made to
        }
        SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, between(1, 10000), retainedOps, retentionLeasesSupplier);
            1 + safeCommitCheckpoint,
        final OptionalLong minimumRetainingSequenceNumber = leases.stream().mapToLong(RetentionLease::retainingSequenceNumber).min();
import java.util.OptionalLong;
        }
                retainedOps = between(0, 10000);
                    randomNonNegativeLong(),
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
            }
    public void testSoftDeletesRetentionLock() {
     */
            }
            final PointRangeQuery retentionQuery = (PointRangeQuery) query;
                )
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
 * Licensed to Elasticsearch under one or more contributor
            if (rarely()) {
        final int retentionOperations = randomIntBetween(0, 1024);
            List<Releasable> releasingLocks = randomSubsetOf(locks);
        final long version = randomNonNegativeLong();
 * this work for additional information regarding copyright
        final long primaryTerm = randomNonNegativeLong();
            Math.min(minimumRetainingSequenceNumber, 1 + globalCheckpoint.get() - retainedOps)
import org.apache.lucene.search.PointRangeQuery;
 * KIND, either express or implied.  See the License for the
                    1 + safeCommitCheckpoint,
                    randomLongBetween(1 + globalCheckpoint.get() - retentionOperations + 1, Long.MAX_VALUE),
 * under the License.
import java.util.Collection;
import java.util.function.Supplier;
        final long localCheckpointOfSafeCommit = randomLongBetween(minimumRetainingSequenceNumber.getAsLong(), Long.MAX_VALUE - 1);
            randomLongBetween(minimumRetainingSequenceNumber.getAsLong() + retentionOperations, Long.MAX_VALUE - 1)
            version,
                    .min()
        final int retentionOperations = randomIntBetween(0, 1024);
            assertThat(retentionQuery.getNumDims(), equalTo(1));
        final long localCheckpointOfSafeCommit = randomLongBetween(-1, Long.MAX_VALUE - retentionOperations - 1);
                    randomLongBetween(1 + localCheckpointOfSafeCommit + 1, Long.MAX_VALUE), // leases are for more than the local checkpoint
            }
        // set the local checkpoint of the safe commit to more than the policy dicated by the global checkpoint
import static org.hamcrest.Matchers.equalTo;
            primaryTerm,
            .mapToLong(AtomicLong::get)
                minRetainedSeqNo = Math.max(minRetainedSeqNo, retainedSeqNo);
                new RetentionLease(
        );
        );
            }
import org.opensearch.index.seqno.RetentionLease;
                new RetentionLease(
        final AtomicLong globalCheckpoint = new AtomicLong(
 * specific language governing permissions and limitations
            assertThat(LongPoint.decodeDimension(retentionQuery.getLowerPoint(), 0), equalTo(minRetainedSeqNo));
            locks.removeAll(releasingLocks);
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(
        assertThat(policy.getMinRetainedSeqNo(), equalTo(1 + localCheckpointOfSafeCommit));
    }
        assertThat(policy.getMinRetainedSeqNo(), equalTo(minimumRetainingSequenceNumber.getAsLong()));
                    .mapToLong(AtomicLong::get)
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(
        final long version = randomNonNegativeLong();
import java.util.concurrent.atomic.AtomicLong;
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
            safeCommitCheckpoint = randomLongBetween(safeCommitCheckpoint, globalCheckpoint.get());
/*
import org.apache.lucene.document.LongPoint;
            Collections.unmodifiableCollection(new ArrayList<>(leases))
        assertThat(policy.getMinRetainedSeqNo(), equalTo(1 + globalCheckpoint.get() - retentionOperations));
/*
                locks.add(policy.acquireRetentionLock());
 * GitHub history for details.
                    Integer.toString(i),
import static org.hamcrest.Matchers.instanceOf;
            );
            Collections.unmodifiableCollection(new ArrayList<>(leases))
            assertThat(LongPoint.decodeDimension(retentionQuery.getUpperPoint(), 0), equalTo(Long.MAX_VALUE));
            leases.add(
 * Unless required by applicable law or agreed to in writing,
                policy.setRetentionOperations(retainedOps);
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
    public void testWhenRetentionLeasesDictateThePolicy() {
                    .orElse(Long.MAX_VALUE);
        final Collection<RetentionLease> leases = new ArrayList<>();
            assertThat(query, instanceOf(PointRangeQuery.class));
import org.apache.lucene.search.Query;
import org.opensearch.test.OpenSearchTestCase;
                    Math.min(minimumRetainingSequenceNumber, 1 + globalCheckpoint.get() - retainedOps)
            );
 * the Apache License, Version 2.0 (the "License"); you may
        final long version = randomNonNegativeLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        final long primaryTerm = randomNonNegativeLong();
                )
            // we only expose the minimum sequence number to the merge policy if the retention lock is not held
 *
                new RetentionLease(
        final int numberOfLeases = randomIntBetween(0, 16);
        final AtomicLong globalCheckpoint = new AtomicLong(randomLongBetween(0, Long.MAX_VALUE - 2));
