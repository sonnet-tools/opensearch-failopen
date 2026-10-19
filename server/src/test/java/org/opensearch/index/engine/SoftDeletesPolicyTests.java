                    "test"
 * compatible open source license.
    }
            // getting the query has side effects, updating the internal state of the policy  
            leases.add(  
                )  
        minRetainedSeqNo = Math.max(minRetainedSeqNo, retainedSeqNo);
            randomLongBetween(Math.max(0, localCheckpointOfSafeCommit + retentionOperations), Long.MAX_VALUE - 1)
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(
        final Collection<RetentionLease> leases = new ArrayList<>();  
        }
        final AtomicLong globalCheckpoint = new AtomicLong(  
        final AtomicLong[] retainingSequenceNumbers = new AtomicLong[randomIntBetween(0, 8)];  
            if (rarely()) {  
        final int retentionOperations = randomIntBetween(0, 1024);
        for (int i = 0; i < retainingSequenceNumbers.length; i++) {
            return new RetentionLeases(1, 1, leases);  
            releasingLocks.forEach(Releasable::close);
                    .orElse(Long.MAX_VALUE);
                minRetainedSeqNo = Math.max(minRetainedSeqNo, retainedSeqNo);  
 * The OpenSearch Contributors require contributions made to  
        );
import org.opensearch.common.lease.Releasable;
                leases.add(new RetentionLease(Integer.toString(i), retainingSequenceNumbers[i].get(), 0L, "test"));
        assertThat(policy.getMinRetainedSeqNo(), equalTo(minRetainedSeqNo));  
        // set the local checkpoint of the safe commit to more than the policy dicated by the global checkpoint  
import org.apache.lucene.search.Query;  
            primaryTerm,  
            randomLongBetween(minimumRetainingSequenceNumber.getAsLong() + retentionOperations, Long.MAX_VALUE - 1)
        final long version = randomNonNegativeLong();
            );
            if (randomBoolean()) {
}  
                final long minimumRetainingSequenceNumber = Arrays.stream(retainingSequenceNumbers)
                    randomLongBetween(1 + globalCheckpoint.get() - retentionOperations + 1, Long.MAX_VALUE),
public class SoftDeletesPolicyTests extends OpenSearchTestCase {
                    .mapToLong(AtomicLong::get)
                    1 + safeCommitCheckpoint,  
        final Collection<RetentionLease> leases = new ArrayList<>();  
            safeCommitCheckpoint = randomLongBetween(safeCommitCheckpoint, globalCheckpoint.get());
            final List<RetentionLease> leases = new ArrayList<>(retainingSequenceNumbers.length);
        );
    }
            );
            Collections.unmodifiableCollection(new ArrayList<>(leases))  
        for (int i = 0; i < numberOfLeases; i++) {
import org.opensearch.test.OpenSearchTestCase;
        final int numberOfLeases = randomIntBetween(0, 16);
                    .min()  
 */
        );
            List<Releasable> releasingLocks = randomSubsetOf(locks);
import static org.hamcrest.Matchers.equalTo;
                new RetentionLease(
        };
            Collections.unmodifiableCollection(new ArrayList<>(leases))
        }
        final int retentionOperations = randomIntBetween(0, 1024);
        final long version = randomNonNegativeLong();
            Collections.unmodifiableCollection(new ArrayList<>(leases))
            assertThat(retentionQuery.getNumDims(), equalTo(1));
            locks.removeAll(releasingLocks);  
import org.opensearch.index.seqno.RetentionLease;
            primaryTerm,
                policy.setRetentionOperations(retainedOps);
 */  
 * license agreements. See the NOTICE file distributed with
                    "test"
import java.util.ArrayList;  
    public void testWhenLocalCheckpointOfSafeCommitDictatesThePolicy() {  
        final int numberOfLeases = randomIntBetween(1, 16);
        );  
            // Advances the global checkpoint and the local checkpoint of a safe commit
    public void testWhenRetentionLeasesDictateThePolicy() {
            version,
import java.util.List;
/*  
            // Release some locks
        final long primaryTerm = randomNonNegativeLong();  
                locks.add(policy.acquireRetentionLock());  
import java.util.Collection;
            final PointRangeQuery retentionQuery = (PointRangeQuery) query;  
                    randomNonNegativeLong(),
 * software distributed under the License is distributed on an
            globalCheckpoint.addAndGet(between(0, 1000));  
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);  
                )  
        }  
            }
        final AtomicLong globalCheckpoint = new AtomicLong(randomLongBetween(0, Long.MAX_VALUE - 2));
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    }
                    randomNonNegativeLong(),
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import java.util.concurrent.atomic.AtomicLong;  
                    randomLongBetween(1 + localCheckpointOfSafeCommit + 1, Long.MAX_VALUE), // leases are for more than the local checkpoint  
 * this file be licensed under the Apache-2.0 license or a
                retainedOps = between(0, 10000);
            if (locks.isEmpty()) {  
        long retainedOps = between(0, 10000);
        assertThat(policy.getMinRetainedSeqNo(), equalTo(1 + globalCheckpoint.get() - retentionOperations));  
        for (int i = 0; i < numberOfLeases; i++) {
 * under the License.  
        final int numberOfLeases = randomIntBetween(0, 16);
package org.opensearch.index.engine;
import java.util.Arrays;
                new RetentionLease(
        }  
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
        assert minimumRetainingSequenceNumber.isPresent() : leases;
        long retainedSeqNo = Math.min(
                    randomNonNegativeLong(),
 *
            // setup leases where the minimum retained sequence number is more than the policy dictated by the global checkpoint  
            for (int i = 0; i < retainingSequenceNumbers.length; i++) {  
                    Integer.toString(i),
     * Makes sure we won't advance the retained seq# if the retention lock is held
        );
        final long localCheckpointOfSafeCommit = randomLongBetween(1 + globalCheckpoint.get() - retentionOperations + 1, Long.MAX_VALUE);
 * SPDX-License-Identifier: Apache-2.0
        long minRetainedSeqNo = policy.getMinRetainedSeqNo();
    }
        final AtomicLong globalCheckpoint = new AtomicLong(  
            assertThat(LongPoint.decodeDimension(retentionQuery.getUpperPoint(), 0), equalTo(Long.MAX_VALUE));
import static org.hamcrest.Matchers.instanceOf;
                    "test"  
        final SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, 0, retentionOperations, leasesSupplier);
            }  
            }
        );  
        final long localCheckpointOfSafeCommit = randomLongBetween(minimumRetainingSequenceNumber.getAsLong(), Long.MAX_VALUE - 1);
import java.util.OptionalLong;
                long retainedSeqNo = Math.min(
            final Query query = policy.getRetentionQuery();
        int iters = scaledRandomIntBetween(10, 1000);  
        long safeCommitCheckpoint = globalCheckpoint.get();
            leases.add(  
        locks.forEach(Releasable::close);
            version,
/*  
        assertThat(policy.getMinRetainedSeqNo(), equalTo(1 + localCheckpointOfSafeCommit));
        assertThat(policy.getMinRetainedSeqNo(), equalTo(minimumRetainingSequenceNumber.getAsLong()));  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < iters; i++) {
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
            version,
        final long version = randomNonNegativeLong();
            1 + safeCommitCheckpoint,
import org.opensearch.index.seqno.RetentionLeases;  
            Math.min(minimumRetainingSequenceNumber, 1 + globalCheckpoint.get() - retainedOps)  
 *     http://www.apache.org/licenses/LICENSE-2.0
        AtomicLong globalCheckpoint = new AtomicLong(NO_OPS_PERFORMED);
        final long minimumRetainingSequenceNumber = Arrays.stream(retainingSequenceNumbers)  
        SoftDeletesPolicy policy = new SoftDeletesPolicy(globalCheckpoint::get, between(1, 10000), retainedOps, retentionLeasesSupplier);  
            );
            assertThat(query, instanceOf(PointRangeQuery.class));
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(
import org.apache.lucene.search.PointRangeQuery;
        final int retentionOperations = randomIntBetween(0, 1024);
                    randomLongBetween(0, Long.MAX_VALUE - retentionOperations - 1),  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
    public void testSoftDeletesRetentionLock() {  
                    Integer.toString(i),
    public void testWhenGlobalCheckpointDictatesThePolicy() {  
        policy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
import org.apache.lucene.document.LongPoint;
 * not use this file except in compliance with the License.
            }
            assertThat(LongPoint.decodeDimension(retentionQuery.getLowerPoint(), 0), equalTo(minRetainedSeqNo));  
            primaryTerm,  
        final Supplier<RetentionLeases> retentionLeasesSupplier = () -> {
 */  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            policy.setLocalCheckpointOfSafeCommit(safeCommitCheckpoint);
        final long primaryTerm = randomNonNegativeLong();  
            .orElse(Long.MAX_VALUE);  
                    Integer.toString(i),  
 *
import java.util.function.Supplier;
        final long primaryTerm = randomNonNegativeLong();
                new RetentionLease(
            .mapToLong(AtomicLong::get)
            }  
 * ownership. Elasticsearch licenses this file to you under  
        final Supplier<RetentionLeases> leasesSupplier = () -> new RetentionLeases(  
                retainingSequenceNumber.set(randomLongBetween(retainingSequenceNumber.get(), Math.max(globalCheckpoint.get(), 0L)));
            assertThat(policy.getMinRetainedSeqNo(), equalTo(minRetainedSeqNo));
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        final long localCheckpointOfSafeCommit = randomLongBetween(-1, Long.MAX_VALUE - retentionOperations - 1);
 * specific language governing permissions and limitations
            .min()
 * You may obtain a copy of the License at  
        for (int i = 0; i < numberOfLeases; i++) {
import java.util.Collections;  
                )
            for (final AtomicLong retainingSequenceNumber : retainingSequenceNumbers) {
        final OptionalLong minimumRetainingSequenceNumber = leases.stream().mapToLong(RetentionLease::retainingSequenceNumber).min();  
 *  
            leases.add(
            // we only expose the minimum sequence number to the merge policy if the retention lock is not held
            retainingSequenceNumbers[i] = new AtomicLong();
                    Math.min(minimumRetainingSequenceNumber, 1 + globalCheckpoint.get() - retainedOps)
/*
        }  
        final Collection<RetentionLease> leases = new ArrayList<>();  
                );
        List<Releasable> locks = new ArrayList<>();
