            public long absoluteTimeInMillis() {
            final int length = randomIntBetween(0, 8);
            closeShards(indexShard);
            }
            final RetentionLeaseStats stats = indexShard.getRetentionLeaseStats();
/*
            for (int i = 0; i < length; i++) {
            }
            final int length = randomIntBetween(0, 8);
        try {
                final RetentionLease retentionLease = retentionLeases.get("0");
                    minimumRetainingSequenceNumbers[i],
            currentTimeMillis.set(
                indexShard,
            final Tuple<Boolean, RetentionLeases> tuple = indexShard.getRetentionLeases(true);
        final int size,
                assertThat(retentionLeases.leases(), hasSize(2));
                retentionLeases = indexShard.getRetentionLeases();
 *
        final long version,
    private void assertRetentionLeases(
            }
                assertThat(retentionLeases.version(), equalTo(initialVersion + 1));
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, primary, false);
import org.opensearch.index.engine.InternalEngineFactory;
                    primaryTerm,
                    )
                final RetentionLease retentionLease = retentionLeases.get("0");
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    private final AtomicLong currentTimeMillis = new AtomicLong();
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), Long.MAX_VALUE, TimeUnit.NANOSECONDS)
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        runExpirationTest(true);
                indexShard.addRetentionLease(
            assertRetentionLeases(
                );
        }
        try {
        );
            final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
            );
                ShardRoutingHelper.initWithSameId(indexShard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE)
                indexShard.addRetentionLease(
        final IndexShard indexShard = newStartedShard(
            }
                    Integer.toString(i),
            if (primary) {
            } else {
                indexShard.getOperationPrimaryTerm(),
 */
            }
                    Integer.toString(i),
            );
            }
 */
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
                indexShard,
    }
        } finally {
                    Arrays.asList(
import org.opensearch.index.seqno.ReplicationTracker;
            currentTimeMillis.get(),
                assertThat(recoveredRetentionLeases.leases(), contains(retentionLeases.leases().toArray(new RetentionLease[0])));
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), TimeValue.timeValueMillis(retentionLeaseMillis))
            assertThat(idToRetentionLease.keySet(), hasItem(Integer.toString(i)));
        final IndexShard indexShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
                );
                    )
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                recoverShardFromStore(recoveredShard);
            assertThat(retentionLease.source(), equalTo("test-" + i));
                length + 1
            final long initialVersion;
            assertThat(retentionLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumbers[i]));
                indexShard.removeRetentionLease(Integer.toString(length - i - 1), ActionListener.wrap(() -> {}));
            }
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(indexShard.routingEntry()),
    public void testExpirationOnPrimary() throws IOException {
                indexShard.addRetentionLease("0", retainingSequenceNumbers[0], "test-0", ActionListener.wrap(() -> {}));
 * GitHub history for details.
 * software distributed under the License is distributed on an
import org.opensearch.cluster.routing.RecoverySource;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.action.ActionListener;
        // current time is mocked through the thread pool
                initialVersion = 3;
                    RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE
                    primaryTerm,
                indexShard.addRetentionLease(
            }
                    Integer.toString(i),
    public void testAddOrRenewRetentionLease() throws IOException {
            } else {
                length,
        final IndexShard indexShard = newStartedShard(
import java.util.Map;
                    Integer.toString(i),
                    recoveredRetentionLeases.leases().iterator().next().id(),
            retainingSequenceNumbers[0] = randomLongBetween(retainingSequenceNumbers[0], Long.MAX_VALUE);
        }
            // renew the lease
import org.opensearch.common.unit.TimeValue;
            );
    public void testRemoveRetentionLease() throws IOException {
    }
        final RetentionLeases retentionLeases;
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
        assertRetentionLeases(retentionLeases, size, minimumRetainingSequenceNumbers, primaryTerm, version);
                currentTimeMillis.get() + randomLongBetween(retentionLeaseMillis, Long.MAX_VALUE - currentTimeMillis.get())
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
                    minimumRetainingSequenceNumbers[i],
                    length - i - 1,
            assertThat(writtenRetentionLeases.version(), equalTo(1L + length));
                        new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0")
                assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));
    private RetentionLease peerRecoveryRetentionLease(IndexShard indexShard) {
    }
                assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));
        final Settings settings = Settings.builder()
            // we should not recover retention leases when force-allocating a stale primary
            true,
                );
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
    }
            }
                );
                    indexShard,
    public void testPersistence() throws IOException {
 *
            }
        assertThat(idToRetentionLease.entrySet(), hasSize(size));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.collect.Tuple;
import static org.hamcrest.Matchers.hasSize;
                retentionLeases = tuple.v2();
                assertRetentionLeases(indexShard, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
        for (final RetentionLease retentionLease : retentionLeases.leases()) {
                );
                final Tuple<Boolean, RetentionLeases> tuple = indexShard.getRetentionLeases(false);
 * Licensed to Elasticsearch under one or more contributor
 *     http://www.apache.org/licenses/LICENSE-2.0
                    equalTo(ReplicationTracker.getPeerRecoveryRetentionLeaseId(indexShard.routingEntry()))
                    indexShard.routingEntry(),
        } finally {
                assertRetentionLeases(indexShard, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
import org.opensearch.cluster.routing.ShardRoutingHelper;
                        peerRecoveryRetentionLease(indexShard),
    }
            assertTrue(tuple.v1());
            }
        final boolean primary,
        try {
package org.opensearch.index.shard;
            final RetentionLeases writtenRetentionLeases = indexShard.loadRetentionLeases();
                    ActionListener.wrap(() -> {})
                    "test-" + i,
                assertRetentionLeases(
            if (ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(retentionLease.source()) == false) {
                closeShards(recoveredShard);
import static org.hamcrest.Matchers.contains;
            closeShards(indexShard);
import org.opensearch.index.seqno.RetentionLeaseStats;
            .build();
        return new RetentionLease(
        final long version
                indexShard.updateRetentionLeasesOnReplica(retentionLeases);
 * compatible open source license.
    protected ThreadPool setUpThreadPool() {
            final IndexShard recoveredShard = reinitShard(
                );
        final long primaryTerm,
            if (primary) {
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, true, false);
                    minimumRetainingSequenceNumbers[i],
                currentTimeMillis.set(TimeUnit.NANOSECONDS.toMillis(randomNonNegativeLong()));
            }
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
                )
import static org.hamcrest.Matchers.hasItem;
            0,
        final long[] minimumRetainingSequenceNumbers,
    ) {
        final IndexShard indexShard = newStartedShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
import java.io.IOException;
        }
                minimumRetainingSequenceNumbers[i] = randomLongBetween(minimumRetainingSequenceNumbers[i], Long.MAX_VALUE);
            final long[] minimumRetainingSequenceNumbers = new long[length];
        final IndexShard indexShard,
                assertRetentionLeases(indexShard, 0, new long[0], primaryTerm, initialVersion + 2, true, true);
                minimumRetainingSequenceNumbers,
import java.util.HashMap;
                stats.retentionLeases(),
            // now force the lease to expire
}
import org.opensearch.threadpool.TestThreadPool;
 * under the License.
                indexShard.renewRetentionLease("0", retainingSequenceNumbers[0], "test-0");
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion, primary, false);
                    false
            try {
    }
                indexShard.updateRetentionLeasesOnReplica(retentionLeases);
        } finally {
                assertThat(recoveredRetentionLeases.version(), equalTo(1L + length));
            for (int i = 0; i < length; i++) {
        final boolean expireLeases
        }
            indexShard.persistRetentionLeases();
        assertTrue(expireLeases == false || primary);
                    2 + length + i,
                    initialVersion,
            // when we recover, we should recover the retention leases
                idToRetentionLease.put(retentionLease.id(), retentionLease);
                indexShard.addRetentionLease(
        }
                initialVersion = 2;
                    minimumRetainingSequenceNumbers,
        } finally {
        final Map<String, RetentionLease> idToRetentionLease = new HashMap<>();
                    "test-" + i,
        final long[] minimumRetainingSequenceNumbers,
        final RetentionLeases retentionLeases,
            } else {
        for (int i = 0; i < size; i++) {
import org.opensearch.index.seqno.SequenceNumbers;
                ShardRoutingHelper.initWithSameId(
 */
                assertFalse(tuple.v1());
 * this work for additional information regarding copyright
        final long retentionLeaseMillis = randomLongBetween(1, TimeValue.timeValueHours(12).millis());
import org.opensearch.common.settings.Settings;
 *
    ) {
            closeShards(indexShard);
    public void testExpirationOnReplica() throws IOException {
                        new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0")
            {
            if (primary) {
            final RetentionLease retentionLease = idToRetentionLease.get(Integer.toString(i));
                    ActionListener.wrap(() -> {})
public class IndexShardRetentionLeaseTests extends IndexShardTestCase {
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(retentionLeases.version(), equalTo(initialVersion));
            try {
            {
                assertThat(recoveredRetentionLeases.version(), equalTo(1L));
                final RetentionLeases retentionLeases = new RetentionLeases(
        final long primaryTerm = indexShard.getOperationPrimaryTerm();
                    initialVersion + 1,
                final RetentionLeases recoveredRetentionLeases = forceRecoveredShard.getIndexer().config().retentionLeasesSupplier().get();
    }
 * this file be licensed under the Apache-2.0 license or a
                    true,
                    primaryTerm,
            );
                closeShards(forceRecoveredShard);
            }
                return currentTimeMillis.get();
            true,
                    ActionListener.wrap(() -> {})
            for (int i = 0; i < length; i++) {
        final Settings settings = Settings.builder()
            Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build()
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final long[] minimumRetainingSequenceNumbers = new long[length];
        } finally {
import java.util.concurrent.TimeUnit;
            } finally {
        if (expireLeases == false) {
                    ActionListener.wrap(() -> {})
                    "test-" + i,
            assertThat(writtenRetentionLeases.leases(), contains(retentionLeases.leases().toArray(new RetentionLease[0])));
            for (int i = 0; i < length; i++) {
                assertRetentionLeases(indexShard, 1, retainingSequenceNumbers, primaryTerm, initialVersion + 1, false, false);
            final int length = randomIntBetween(0, 8);
        assertThat(retentionLeases.primaryTerm(), equalTo(primaryTerm));
                );
        );
/*
 * SPDX-License-Identifier: Apache-2.0
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
            currentTimeMillis.set(TimeUnit.NANOSECONDS.toMillis(Long.MAX_VALUE));
            // the written retention leases should equal our current retention leases
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            final long[] minimumRetainingSequenceNumbers = new long[length];
                recoverShardFromStore(forceRecoveredShard);
    }
        };
 * Unless required by applicable law or agreed to in writing,
                final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
import java.util.concurrent.atomic.AtomicLong;
import org.opensearch.index.seqno.RetentionLease;
            @Override
            final IndexShard forceRecoveredShard = reinitShard(
            final long[] retainingSequenceNumbers = new long[1];
                    Arrays.asList(
 * not use this file except in compliance with the License.
        final int size,
        try {
import org.opensearch.index.seqno.RetentionLeases;
        runExpirationTest(false);
        } else {
            for (int i = 0; i < length; i++) {
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
    private void assertRetentionLeases(
    private void runExpirationTest(final boolean primary) throws IOException {
            final long[] minimumRetainingSequenceNumbers = new long[length];
        }
                );
        }
            retainingSequenceNumbers[0] = randomLongBetween(0, Long.MAX_VALUE);
            .build();
        );
                final RetentionLeases recoveredRetentionLeases = recoveredShard.getIndexer().config().retentionLeasesSupplier().get();
 * You may obtain a copy of the License at
            final int length = randomIntBetween(0, 8);
            } finally {
        );
        try {
                        peerRecoveryRetentionLease(indexShard),
                assertThat(retentionLeases.leases(), hasSize(2));
    }
 * The OpenSearch Contributors require contributions made to
        return new TestThreadPool(getClass().getName(), threadPoolSettings()) {
            // force the retention leases to persist
                final RetentionLeases retentionLeases = new RetentionLeases(
        }
                indexShard.renewRetentionLease(Integer.toString(i), minimumRetainingSequenceNumbers[i], "test-" + i);
            if (randomBoolean()) {
                assertThat(recoveredRetentionLeases.leases(), hasSize(1));
            } else {
                minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            }
 * specific language governing permissions and limitations
            }
                    minimumRetainingSequenceNumbers[i],
        final IndexShard indexShard = newStartedShard(
        assertThat(retentionLeases.version(), equalTo(version));
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.index.IndexSettings;
            retentionLeases = tuple.v2();
            closeShards(indexShard);
    public void testRetentionLeaseStats() throws IOException {
        final long primaryTerm,
            for (int i = 0; i < length; i++) {
                assertRetentionLeases(indexShard, length, minimumRetainingSequenceNumbers, primaryTerm, 2 + length + i, true, false);
            }
/*
                final RetentionLeases retentionLeases = indexShard.getIndexer().config().retentionLeasesSupplier().get();
                    "test-" + i,
            currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, 1024));
            closeShards(indexShard);
import java.util.Arrays;
            true,
                assertThat(
