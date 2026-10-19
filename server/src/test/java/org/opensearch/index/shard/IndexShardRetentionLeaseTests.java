    private final AtomicLong currentTimeMillis = new AtomicLong();
                    Arrays.asList(
        final IndexShard indexShard = newStartedShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));  
            assertThat(retentionLease.source(), equalTo("test-" + i));
/*  
                    2 + length + i,
    public void testPersistence() throws IOException {  
                    initialVersion,
            }
        final boolean expireLeases
            for (int i = 0; i < length; i++) {
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
 * not use this file except in compliance with the License.
            );
            try {
                    Integer.toString(i),
        if (expireLeases == false) {  
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, primary, false);  
    public void testRetentionLeaseStats() throws IOException {
            }
 */  
    ) {  
                        peerRecoveryRetentionLease(indexShard),
            } else {  
            final int length = randomIntBetween(0, 8);  
        final IndexShard indexShard = newStartedShard(  
import org.opensearch.cluster.routing.ShardRoutingHelper;
        final long primaryTerm,
        assertThat(retentionLeases.primaryTerm(), equalTo(primaryTerm));
            true,
            @Override
import org.opensearch.index.IndexSettings;
            if (primary) {
    private void assertRetentionLeases(
            }
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.index.seqno.RetentionLeaseStats;  
            final Tuple<Boolean, RetentionLeases> tuple = indexShard.getRetentionLeases(true);  
                    "test-" + i,
                indexShard.getOperationPrimaryTerm(),
            closeShards(indexShard);  
            // we should not recover retention leases when force-allocating a stale primary  
    public void testExpirationOnPrimary() throws IOException {  
                indexShard.renewRetentionLease(Integer.toString(i), minimumRetainingSequenceNumbers[i], "test-" + i);  
                    indexShard,
        try {  
                    "test-" + i,
                    Arrays.asList(
 * You may obtain a copy of the License at  
            // when we recover, we should recover the retention leases
            }
                        new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0")  
            );  
                assertThat(recoveredRetentionLeases.version(), equalTo(1L + length));  
                assertRetentionLeases(indexShard, length, minimumRetainingSequenceNumbers, primaryTerm, 2 + length + i, true, false);
        final long[] minimumRetainingSequenceNumbers,
                indexShard.renewRetentionLease("0", retainingSequenceNumbers[0], "test-0");
                minimumRetainingSequenceNumbers,
            assertThat(idToRetentionLease.keySet(), hasItem(Integer.toString(i)));
    }  
        final long[] minimumRetainingSequenceNumbers,
            try {  
import static org.hamcrest.Matchers.contains;
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
                    Integer.toString(i),
        final RetentionLeases retentionLeases,
        assertThat(idToRetentionLease.entrySet(), hasSize(size));
                    primaryTerm,
            } finally {
 */
                initialVersion = 3;
                indexShard.addRetentionLease(
            }  
            }
                assertThat(recoveredRetentionLeases.leases(), contains(retentionLeases.leases().toArray(new RetentionLease[0])));
    }
        final Settings settings = Settings.builder()
    }  
                    indexShard.routingEntry(),
 * under the License.  
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
        }
            } else {
            assertRetentionLeases(
                final RetentionLease retentionLease = retentionLeases.get("0");
import java.util.concurrent.TimeUnit;
            );
        assertRetentionLeases(retentionLeases, size, minimumRetainingSequenceNumbers, primaryTerm, version);
 * Licensed to Elasticsearch under one or more contributor  
                );
        final RetentionLeases retentionLeases;
                    true,  
import static org.hamcrest.Matchers.equalTo;
                assertRetentionLeases(indexShard, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
            final int length = randomIntBetween(0, 8);  
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
            final long[] minimumRetainingSequenceNumbers = new long[length];
import static org.hamcrest.Matchers.hasSize;
                indexShard.addRetentionLease(
            for (int i = 0; i < length; i++) {
        final IndexShard indexShard,
            if (primary) {  
                return currentTimeMillis.get();  
        );  
        assertThat(retentionLeases.version(), equalTo(version));  
                    minimumRetainingSequenceNumbers[i],  
            final IndexShard forceRecoveredShard = reinitShard(
                );
                    recoveredRetentionLeases.leases().iterator().next().id(),
        assertTrue(expireLeases == false || primary);
        runExpirationTest(false);
        final Map<String, RetentionLease> idToRetentionLease = new HashMap<>();
 * software distributed under the License is distributed on an
                );  
                assertThat(recoveredRetentionLeases.version(), equalTo(1L));
        final int size,  
            indexShard.persistRetentionLeases();
                length,  
            if (ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(retentionLease.source()) == false) {  
        for (int i = 0; i < size; i++) {  
                final RetentionLease retentionLease = retentionLeases.get("0");
import org.opensearch.threadpool.TestThreadPool;  
        }
                closeShards(recoveredShard);  
            final RetentionLeases writtenRetentionLeases = indexShard.loadRetentionLeases();  
    public void testAddOrRenewRetentionLease() throws IOException {
                    minimumRetainingSequenceNumbers[i],  
                        peerRecoveryRetentionLease(indexShard),  
            final int length = randomIntBetween(0, 8);
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
            }
            // force the retention leases to persist
                recoverShardFromStore(recoveredShard);
import org.opensearch.common.collect.Tuple;  
        return new RetentionLease(  
            final RetentionLease retentionLease = idToRetentionLease.get(Integer.toString(i));
            }
            }  
 * GitHub history for details.
        }  
            }
                    RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE
            if (primary) {
                    "test-" + i,  
                assertRetentionLeases(indexShard, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
        final long retentionLeaseMillis = randomLongBetween(1, TimeValue.timeValueHours(12).millis());  
                    )
        }  
}
import java.io.IOException;  
                assertThat(recoveredRetentionLeases.leases(), hasSize(1));
                final RetentionLeases retentionLeases = new RetentionLeases(
        try {
            } else {  
                    ActionListener.wrap(() -> {})
            }
            currentTimeMillis.set(TimeUnit.NANOSECONDS.toMillis(Long.MAX_VALUE));
                indexShard.addRetentionLease(  
                    Integer.toString(i),
        final long version  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, true, false);
import org.opensearch.common.settings.Settings;
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
                );  
                indexShard.addRetentionLease("0", retainingSequenceNumbers[0], "test-0", ActionListener.wrap(() -> {}));
        for (final RetentionLease retentionLease : retentionLeases.leases()) {
                recoverShardFromStore(forceRecoveredShard);  
        final int size,  
                final RetentionLeases recoveredRetentionLeases = recoveredShard.getIndexer().config().retentionLeasesSupplier().get();
                length + 1  
            currentTimeMillis.get(),  
                    "test-" + i,
    }  
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(indexShard.routingEntry()),
                assertRetentionLeases(  
import org.opensearch.common.unit.TimeValue;
                final Tuple<Boolean, RetentionLeases> tuple = indexShard.getRetentionLeases(false);
 * KIND, either express or implied.  See the License for the
import java.util.Map;  
                assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));  
        } finally {
 * The OpenSearch Contributors require contributions made to  
                assertThat(retentionLeases.version(), equalTo(initialVersion));  
            } else {  
                final RetentionLeases recoveredRetentionLeases = forceRecoveredShard.getIndexer().config().retentionLeasesSupplier().get();
                indexShard,  
            final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
            .build();
        }
 */  
        };
        runExpirationTest(true);
        }  
 * Unless required by applicable law or agreed to in writing,
                minimumRetainingSequenceNumbers[i] = randomLongBetween(minimumRetainingSequenceNumbers[i], Long.MAX_VALUE);
/*  
 *
        // current time is mocked through the thread pool
    private void runExpirationTest(final boolean primary) throws IOException {
                indexShard,
                ShardRoutingHelper.initWithSameId(  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), Long.MAX_VALUE, TimeUnit.NANOSECONDS)  
                    ActionListener.wrap(() -> {})  
            .build();
    public void testRemoveRetentionLease() throws IOException {
            assertTrue(tuple.v1());
        final Settings settings = Settings.builder()
import static org.hamcrest.Matchers.hasItem;  
    @Override
            closeShards(indexShard);
            retentionLeases = tuple.v2();
            retainingSequenceNumbers[0] = randomLongBetween(0, Long.MAX_VALUE);
    ) {
                final RetentionLeases retentionLeases = new RetentionLeases(
            final long initialVersion;
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
        } finally {  
                indexShard.updateRetentionLeasesOnReplica(retentionLeases);
                    Integer.toString(i),  
        } finally {
 *     http://www.apache.org/licenses/LICENSE-2.0
                );
            // the written retention leases should equal our current retention leases
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
import org.opensearch.index.engine.InternalEngineFactory;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.seqno.RetentionLeases;
    }  
            }
            // now force the lease to expire  
import org.opensearch.index.seqno.ReplicationTracker;
            assertThat(retentionLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumbers[i]));  
            if (randomBoolean()) {
 *  
        );
import org.opensearch.index.seqno.SequenceNumbers;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            retainingSequenceNumbers[0] = randomLongBetween(retainingSequenceNumbers[0], Long.MAX_VALUE);  
            final long[] minimumRetainingSequenceNumbers = new long[length];
            }
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicLong;
            }  
            closeShards(indexShard);
            }
        return new TestThreadPool(getClass().getName(), threadPoolSettings()) {  
                stats.retentionLeases(),
    }
        final long primaryTerm,
        } finally {
                );  
package org.opensearch.index.shard;
    }
                    minimumRetainingSequenceNumbers[i],
                assertThat(  
                ShardRoutingHelper.initWithSameId(indexShard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE)
            }
                    equalTo(ReplicationTracker.getPeerRecoveryRetentionLeaseId(indexShard.routingEntry()))
                indexShard.addRetentionLease(
        } finally {
 *
            final long[] retainingSequenceNumbers = new long[1];  
                );
            closeShards(indexShard);  
    public void testExpirationOnReplica() throws IOException {
            for (int i = 0; i < length; i++) {  
                assertFalse(tuple.v1());
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion, primary, false);
                final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
                initialVersion = 2;
    private void assertRetentionLeases(
    private RetentionLease peerRecoveryRetentionLease(IndexShard indexShard) {
        }
        final long version,  
                retentionLeases = tuple.v2();  
            0,
            closeShards(indexShard);
            assertThat(writtenRetentionLeases.version(), equalTo(1L + length));
        final IndexShard indexShard = newStartedShard(
    }
                closeShards(forceRecoveredShard);  
            true,
            final long[] minimumRetainingSequenceNumbers = new long[length];
        );  
        try {
            final RetentionLeaseStats stats = indexShard.getRetentionLeaseStats();  
            // renew the lease
    }
                    length - i - 1,
        final IndexShard indexShard = newStartedShard(  
                assertRetentionLeases(indexShard, 0, new long[0], primaryTerm, initialVersion + 2, true, true);  
public class IndexShardRetentionLeaseTests extends IndexShardTestCase {  
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
                    ActionListener.wrap(() -> {})
import org.opensearch.index.seqno.RetentionLease;
                indexShard.removeRetentionLease(Integer.toString(length - i - 1), ActionListener.wrap(() -> {}));
import java.util.HashMap;
    protected ThreadPool setUpThreadPool() {
        try {  
        );
            currentTimeMillis.set(
                retentionLeases = indexShard.getRetentionLeases();
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), TimeValue.timeValueMillis(retentionLeaseMillis))  
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
        final boolean primary,
                );  
import org.opensearch.threadpool.ThreadPool;
            currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, 1024));
            final IndexShard recoveredShard = reinitShard(
            for (int i = 0; i < length; i++) {
 * this work for additional information regarding copyright
                    minimumRetainingSequenceNumbers[i],
/*
        }  
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
            for (int i = 0; i < length; i++) {
                assertThat(retentionLeases.leases(), hasSize(2));  
            public long absoluteTimeInMillis() {
    }
            );
        try {
                )  
                assertThat(retentionLeases.leases(), hasSize(2));
            assertThat(writtenRetentionLeases.leases(), contains(retentionLeases.leases().toArray(new RetentionLease[0])));
            for (int i = 0; i < length; i++) {  
                indexShard.updateRetentionLeasesOnReplica(retentionLeases);  
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, false, false);
            {
 * license agreements. See the NOTICE file distributed with
                    false
            {  
 * compatible open source license.
                currentTimeMillis.get() + randomLongBetween(retentionLeaseMillis, Long.MAX_VALUE - currentTimeMillis.get())
                        new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0")
            } finally {
            final int length = randomIntBetween(0, 8);
    }  
                    minimumRetainingSequenceNumbers,  
                final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
                currentTimeMillis.set(TimeUnit.NANOSECONDS.toMillis(randomNonNegativeLong()));
        final IndexShard indexShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionListener;  
                    )
 * ownership. Elasticsearch licenses this file to you under  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                idToRetentionLease.put(retentionLease.id(), retentionLease);
                    primaryTerm,
                    ActionListener.wrap(() -> {})
                assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));
                    primaryTerm,  
                    initialVersion + 1,  
            true,  
                assertThat(retentionLeases.version(), equalTo(initialVersion + 1));
            final long[] minimumRetainingSequenceNumbers = new long[length];
        } else {
