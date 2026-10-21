            .put("index.number_of_shards", 1)
import static org.hamcrest.Matchers.anyOf;
            latch.await();
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));
import org.opensearch.cluster.node.DiscoveryNode;
    }
            latch.await();
                assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                    ids.get(j),
            .get();
            final long later = System.nanoTime();
        final int length = randomIntBetween(1, 8);
            final AcknowledgedResponse longTtlResponse = client().admin()
    ) throws InterruptedException {
import java.util.concurrent.atomic.AtomicReference;
            .build();
                if (randomBoolean()) {
        final List<String> ids = new ArrayList<>(length);
        primary.addRetentionLease(idForInitialRetentionLease, initialRetainingSequenceNumber, source, listener);
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            indexShard -> {}
 */
        final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
    public static final class RetentionLeaseSyncIntervalSettingPlugin extends Plugin {
            final String id = randomAlphaOfLength(8);
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
    public void testCanRemoveRetentionLeasesWithoutWaitingForShards() throws InterruptedException {
        final AtomicReference<RetentionLease> retentionLease = new AtomicReference<>();
                    final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
        final int length = randomIntBetween(1, 8);
        createIndex("index", settings);
 *
            assertThat(
        final long estimatedTimeIntervalMillis = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
                currentRetentionLeases.put(
                    // return an exception to the FINALIZE action
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    // return a ConnectTransportException to the START_RECOVERY action
        final String waitForActiveValue = randomBoolean() ? "all" : Integer.toString(numDataNodes + 1);
    public void testCanAddRetentionLeaseUnderBlock() throws InterruptedException {
                        randomLongBetween(currentRetentionLeases.get(ids.get(j)).retainingSequenceNumber(), Long.MAX_VALUE),
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>(length);
                .prepareUpdateSettings("index")
                // check all retention leases have been synced to all replicas
        runUnderBlockTest(idForInitialRetentionLease, initialRetainingSequenceNumber, (primary, listener) -> {
        final String block = randomFrom("read_only", "read_only_allow_delete", "read", "write", "metadata");
                } else {
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
        );
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
        }
            try {
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
        // when we increase the number of replicas below we want to exclude the replicas from being allocated so that they do not recover
                );
            latch.await();
import org.opensearch.index.IndexSettings;
                    final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
        allowNodes("index", 1 + numberOfReplicas);
                    replica.getRetentionLeases()
            // now that all retention leases are expired should have been synced to all replicas
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
                )
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
            primary -> {}
                        contains(retentionLease.get())
            final CountDownLatch latch = new CountDownLatch(1);
                currentRetentionLeases,
            final String source = randomAlphaOfLength(8);
                .indices()
            final long nextRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
            }
import org.opensearch.common.settings.Setting;
            final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(
        ensureGreen("index");
            // check current retention leases have been synced to all replicas
                 */
        assertTrue(response.isAcknowledged());
                final String replicaShardNodeId = replicaShard.currentNodeId();
        }
            latch.await();
            assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));
            // put a new lease
        for (int i = 0; i < length; i++) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
 * under the License.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        createIndex("index", settings);
                // check retention leases have been written on the replica
                );
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
            try {
                assertBusy(
            final String nextId = randomValueOtherThan(idForInitialRetentionLease, () -> randomAlphaOfLength(8));
        ensureYellowAndNoInitializingShards("index");
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
                }
            .prepareUpdateSettings("index")
            retentionLease.set(primary.renewRetentionLease(idForInitialRetentionLease, nextRetainingSequenceNumber, nextSource));
            .build();
        ensureGreen("index");
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
                final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(
                .get();
 * license agreements. See the NOTICE file distributed with
        final long initialRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        latch.await();
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
        final String idForInitialRetentionLease,
import java.util.LinkedHashMap;
            final String source = randomAlphaOfLength(8);
            }
            .prepareUpdateSettings("index")
                failWithException(e);
            .put("index.number_of_replicas", numDataNodes)
import org.opensearch.common.SuppressForbidden;
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            public void onFailure(final Exception e) {
import java.util.concurrent.TimeUnit;
        client().admin()
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
        final CountDownLatch latch = new CountDownLatch(1);
            .put("index.number_of_replicas", numberOfReplicas)
            .put("index.number_of_replicas", 0)
import java.util.Collections;
 */
                 * If the background renew was able to execute, then the retention leases were persisted to disk. There is no other
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.getRetentionLeases()).entrySet(),
 * The OpenSearch Contributors require contributions made to
        final String source = randomAlphaOfLength(8);
            (primary, listener) -> primary.removeRetentionLease(idForInitialRetentionLease, listener),
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
 * Licensed to Elasticsearch under one or more contributor
            final CountDownLatch latch = new CountDownLatch(1);
        final Semaphore recoveriesToDisrupt = new Semaphore(scaledRandomIntBetween(0, 4));
                    assertThat(
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
            }
                    currentRetentionLeases,
            primary.addRetentionLease(nextId, nextRetainingSequenceNumber, nextSource, listener);
                success.set(true);
            .prepareUpdateSettings("index")
    }
            // update the index for retention leases to live a long time
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
 *
                for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
        assertTrue(success.get());
                    empty()
 * not use this file except in compliance with the License.
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));
 * GitHub history for details.
                        .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), retentionLeaseTimeToLive)
 * compatible open source license.
        });
            );
        });
            assertThat(
            // simulate a peer recovery which locks the soft deletes policy on the primary
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
                    )
        assertAcked(prepareCreate("index", 1, settings));
        assertFalse(client().admin().cluster().prepareHealth("index").setWaitForActiveShards(numDataNodes).get().isTimedOut());
            listener.onResponse(new ReplicationResponse());
                .setPersistentSettings(
        }, primary -> {
            primaryShardNodeName
            retentionLock.close();
            final String source = randomAlphaOfLength(8);
        assertAcked(
        } finally {
            afterSync.accept(primary);
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
        );
            final long now = System.nanoTime();
            final CountDownLatch latch = new CountDownLatch(1);
                    );
            client().admin()
import static org.hamcrest.Matchers.equalTo;
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
    ) throws InterruptedException {
            assertThat(
            .put("index.number_of_replicas", numberOfReplicas)
            .build();
    }
        final String idForInitialRetentionLease,
                currentRetentionLeases,
                );
            primary.addRetentionLease(nextId, nextRetainingSequenceNumber, nextSource, listener);
                )
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            super.nodePlugins().stream(),
package org.opensearch.index.seqno;
        }
            Stream.of(RetentionLeaseSyncIntervalSettingPlugin.class, MockTransportService.TestPlugin.class)
            final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
        ).collect(Collectors.toList());
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
        final TimeValue retentionLeaseTimeToLive = TimeValue.timeValueMillis(
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    }
            }
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING;
        final AcknowledgedResponse response = client().admin()
 */
    private static ActionListener<ReplicationResponse> countDownLatchListener(CountDownLatch latch) {
            primaryConsumer.accept(primary, new ActionListener<ReplicationResponse>() {
import org.opensearch.common.settings.Settings;
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        // now allow the replicas to be allocated and wait for recovery to finalize
import java.util.Map;
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
        final Consumer<IndexShard> afterSync
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
                    RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.getRetentionLeases()).values(),
                @Override
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueHours(24));
            return Collections.singletonList(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING);
    }
                    final String replicaShardNodeId = replicaShard.currentNodeId();
                );
            retentionLease.set(primary.renewRetentionLease(idForInitialRetentionLease, nextRetainingSequenceNumber, nextSource));
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
            });
        runWaitForShardsTest(idForInitialRetentionLease, initialRetainingSequenceNumber, (primary, listener) -> {
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()).values(),
            }
        assertAcked(prepareCreate("index").setSettings(settings));
                .get();
            final String nextSource = randomAlphaOfLength(8);
import org.opensearch.action.support.replication.ReplicationResponse;
    public void testRetentionLeasesSyncedOnAdd() throws Exception {
import static org.hamcrest.Matchers.contains;
            });
                .cluster()
            final String nextSource = randomAlphaOfLength(8);
                        ids.get(j),
                 * way for the current retention leases to end up written to disk so we assume that if they are written to disk, it
            .put("index.number_of_shards", 1)
                );
import java.util.stream.Collectors;
    @Override
                assertThat(
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()))
import org.opensearch.OpenSearchException;
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            @Override
                () -> assertThat(
        ensureGreen("index");
        runWaitForShardsTest(idForInitialRetentionLease, randomLongBetween(0, Long.MAX_VALUE), (primary, listener) -> {
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
         * We effectively disable the background sync to ensure that the retention leases are not synced in the background so that the only
import org.opensearch.index.shard.IndexShard;
            // check current retention leases have been synced to all replicas
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
import org.opensearch.core.action.ActionListener;
                    Settings.builder()
                 * implies that the background sync was able to execute despite wait for shards being set on the index.
    }
            } catch (final Exception e) {
import org.opensearch.transport.TransportService;
            final String source = randomAlphaOfLength(8);
 * this work for additional information regarding copyright
        final CountDownLatch latch = new CountDownLatch(1);
import java.util.function.BiConsumer;
    }
            .put("index.number_of_replicas", numberOfReplicas)
                currentRetentionLeases,
        }, primary -> {
                        .build()
        final Settings settings = Settings.builder()
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()).values(),
                    replicaTransportService.disconnectFromNode(primaryNode);
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};
            // update the index for retention leases to short a long time, to force expiration
            .put("index.number_of_shards", 1)
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
            retentionLock.close();
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};
import java.util.ArrayList;
            final long nextRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
                    replica.getRetentionLeases()
                for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            TransportService.class,
                @Override
            .get();
            final String nextId = randomValueOtherThan(idForInitialRetentionLease, () -> randomAlphaOfLength(8));
    }
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
                failWithException(e);
            randomLongBetween(estimatedTimeIntervalMillis, 2 * estimatedTimeIntervalMillis)
        for (int i = 0; i < length; i++) {
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))
                .getShardOrNull(new ShardId(resolveIndex("index"), 0));
import org.opensearch.plugins.Plugin;
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
        final AtomicBoolean success = new AtomicBoolean();
                    currentRetentionLeases,
            .put("index.number_of_shards", 1)
            final String replicaShardNodeId = replicaShard.currentNodeId();
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};
            }
            client().admin()
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
            });
 * specific language governing permissions and limitations
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
    }
            connection.sendRequest(requestId, action, request, options);
    }
        actionLatch.await();
            );
            final CountDownLatch latch = new CountDownLatch(1);
                .indices()
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()))
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
        // check current retention leases have been synced to all replicas
            final long nextRetainingSequenceNumber = randomLongBetween(initialRetainingSequenceNumber, Long.MAX_VALUE);
        createIndex("index", settings);
        final int numDataNodes = internalCluster().numDataNodes();
            final CountDownLatch actionLatch = new CountDownLatch(1);
        final Settings settings = Settings.builder()
        // we will add multiple retention leases and expect to see them synced to all replicas
            // check retention leases have been written on the primary
    private static void failWithException(Exception e) {
            .setSettings(Settings.builder().put("index.blocks." + block, true).build())
                    );
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            final String nextSource = randomAlphaOfLength(8);
 * software distributed under the License is distributed on an
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            latch.await();
            primary.removeRetentionLease(id, countDownLatchListener(latch));
                    Settings.builder().put(INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), TimeValue.timeValueMillis(100))
        final Settings settings = Settings.builder()
    }
                }
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
         * source of retention leases on the replicas would be from recovery.
            idForInitialRetentionLease,
            assertTrue(success.get());
        final int length = randomIntBetween(1, 8);
        afterSync.accept(primary);
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
/*
        for (int i = 0; i < length; i++) {
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.CountDownLatch;
    }
                }
                        contains(retentionLease.get())
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));
            assertTrue(shortTtlResponse.isAcknowledged());
import org.opensearch.test.OpenSearchIntegTestCase;
                .setSettings(
        }
            .setSettings(Settings.builder().put("index.write.wait_for_active_shards", waitForActiveValue).build())
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
            .indices()
            final long nextRetainingSequenceNumber = randomLongBetween(initialRetainingSequenceNumber, Long.MAX_VALUE);
                    primary.renewRetentionLease(
        /*
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
                    final TransportService replicaTransportService = internalCluster().getInstance(
            assertBusy(
        }
            } catch (final Exception e) {
            randomLongBetween(0, Long.MAX_VALUE),
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
        final Settings settings = Settings.builder()
            (primary, listener) -> primary.removeRetentionLease(idForInitialRetentionLease, listener),
        return ActionListener.wrap(r -> latch.countDown(), RetentionLeaseIT::failWithException);
    public void testRetentionLeaseSyncedOnRemove() throws Exception {
                 * implies that the background sync was able to execute under a block.
            assertBusy(() -> {
            );
            // sleep long enough that the current retention lease has expired
            .setSettings(Settings.builder().put("index.number_of_replicas", numberOfReplicas).build())
        // we will add multiple retention leases, wait for some to expire, and assert a consistent view between the primary and the replicas
            .indices()
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
    private void runWaitForShardsTest(
                 */
        });
        client().admin()
            final String nextSource = randomAlphaOfLength(8);
    public void testBackgroundRetentionLeaseSync() throws Exception {
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
import org.opensearch.threadpool.ThreadPool;
            }
                        .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            .indices()
                .get();
                )
        final BiConsumer<IndexShard, ActionListener<ReplicationResponse>> primaryConsumer,
        logger.info("adding retention [{}}] leases", length);
 *
            // check retention leases have been written on the replica; see RecoveryTarget#finalizeRecovery
                    equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))
                .setSettings(Settings.builder().putNull("index.blocks." + block).build())
        }
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
        final Settings settings = Settings.builder()
        for (int i = 0; i < length; i++) {
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
                    throw new OpenSearchException("failing recovery for test purposes");
            randomLongBetween(0, Long.MAX_VALUE),
                    success.set(true);
            .get();
    public void testCanRenewRetentionLeaseWithoutWaitingForShards() throws InterruptedException {
                assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));
         */
import static org.hamcrest.Matchers.empty;
 * You may obtain a copy of the License at
    private void runUnderBlockTest(
import org.opensearch.common.unit.TimeValue;
                    final String replicaShardNodeId = replicaShard.currentNodeId();
    }
                /*
    public void testRetentionLeasesSyncOnExpiration() throws Exception {
        }, primary -> {});
            .put("index.number_of_shards", 1)
                id,
            currentRetentionLeases.remove(id);
        );
                replica.getRetentionLeases()
/*
            assertBusy(() -> {
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
            idForInitialRetentionLease,
                    final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
 * Modifications Copyright OpenSearch Contributors. See
            // check retention leases have been written on the primary
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
        final long initialRetainingSequenceNumber,
        final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
        }
        final int length = randomIntBetween(1, 8);
        primary.addRetentionLease(idForInitialRetentionLease, initialRetainingSequenceNumber, source, listener);
            }
        // cause some recoveries to fail to ensure that retention leases are handled properly when retrying a recovery
        );
import java.util.function.Consumer;
        // we will add multiple retention leases and expect to see them synced to all replicas
            public void onResponse(final ReplicationResponse replicationResponse) {
                actionLatch.countDown();
                .indices()
            @Override
                );
                .prepareUpdateSettings("index")
            .put("index.number_of_shards", 1)
        ensureGreen("index");
public class RetentionLeaseIT extends OpenSearchIntegTestCase {
                    )
        latch.await();
            // check current retention leases have been synced to all replicas
                 * way for the current retention leases to end up written to disk so we assume that if they are written to disk, it
                assertThat(
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
        final MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(
        ensureGreen("index");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.atomic.AtomicBoolean;
            .build();
        public List<Setting<?>> getSettings() {
        final Settings.Builder settings = Settings.builder()
            final RetentionLease currentRetentionLease = primary.addRetentionLease(id, retainingSequenceNumber, source, listener);
import java.util.Collection;
import java.util.concurrent.Semaphore;
        return Stream.concat(
            final String source = randomAlphaOfLength(8);
        }, primary -> {});
        for (int i = 0; i < length; i++) {
            Thread.sleep(Math.max(0, retentionLeaseTimeToLive.millis() - TimeUnit.NANOSECONDS.toMillis(later - now)));
                public void onFailure(final Exception e) {
        createIndex("index", settings);
        runUnderBlockTest(
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
    }
            final CountDownLatch latch = new CountDownLatch(1);
                    final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
            .build();
                    anyOf(empty(), contains(currentRetentionLease))
            assertTrue(longTtlResponse.isAcknowledged());
                    actionLatch.countDown();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        final CountDownLatch actionLatch = new CountDownLatch(1);
        ensureGreen("index");
                .prepareUpdateSettings()
        primaryConsumer.accept(primary, new ActionListener<ReplicationResponse>() {
        for (int i = 0; i < length; i++) {
            // simulate a peer recovery which locks the soft deletes policy on the primary
        final long initialRetainingSequenceNumber,
            );
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    public void testCanAddRetentionLeaseWithoutWaitingForShards() throws InterruptedException {
            }
import org.opensearch.indices.IndicesService;
        final int length = randomIntBetween(1, 8);
import org.opensearch.index.IndexService;
                final String replicaShardNodeId = replicaShard.currentNodeId();
        }
                    assertThat(replica.getRetentionLeases(), equalTo(primary.getRetentionLeases()));
        final AtomicReference<RetentionLease> retentionLease = new AtomicReference<>();
                    final DiscoveryNode primaryNode = primaryTransportService.getLocalNode();
            final String id = randomFrom(currentRetentionLeases.keySet());
                }
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
                    )
                }
                );
            latch.await();
        logger.info("allow [{}] replicas to allocate", numberOfReplicas);
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE) && recoveriesToDisrupt.tryAcquire()) {
                // check retention leases have been written on the replica
            actionLatch.await();
            retentionLock.close();
    @SuppressForbidden(reason = "Sleeping longer than lease duration")
            );
            final AcknowledgedResponse shortTtlResponse = client().admin()
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
                    failWithException(e);
                        connection.getNode().getName()
        final long initialRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
import org.opensearch.cluster.routing.ShardRouting;
    public void testCanRenewRetentionLeaseUnderBlock() throws InterruptedException {
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
        }
                assertBusy(
                final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(
        runWaitForShardsTest(
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
                .setSettings(Settings.builder().putNull(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey()).build())
        final Settings settings = Settings.builder()
            .build();
import org.opensearch.test.transport.MockTransportService;
            final AtomicBoolean success = new AtomicBoolean();
        runUnderBlockTest(idForInitialRetentionLease, randomLongBetween(0, Long.MAX_VALUE), (primary, listener) -> {
    public void testCanRemoveRetentionLeasesUnderBlock() throws InterruptedException {
                .prepareUpdateSettings("index")
            .put("index.number_of_shards", 1)
                );
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
                    equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))
        throw new AssertionError("unexpected", e);
        });
        ensureYellow("index");
            final CountDownLatch latch = new CountDownLatch(1);
            );
import java.util.List;
                failWithException(e);
                primary.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(latch::countDown))
            .put("index.number_of_replicas", numberOfReplicas)
                    () -> assertThat(
            for (int j = 0; j <= i; j++) {
                final String replicaShardNodeId = replicaShard.currentNodeId();
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            .put("index.number_of_replicas", 0)
                assertThat(
}
                 * If the background renew was able to execute, then the retention leases were persisted to disk. There is no other
        final BiConsumer<IndexShard, ActionListener<ReplicationResponse>> primaryConsumer,
import java.util.stream.Stream;
        try {
                    () -> assertThat(
                    RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.getRetentionLeases()).entrySet(),
                        source
                public void onResponse(final ReplicationResponse replicationResponse) {
    }
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
            ids.add(id);
                /*
 * KIND, either express or implied.  See the License for the
                    replicaTransportService.connectToNode(primaryNode);
        final Consumer<IndexShard> afterSync
    public void testRetentionLeasesSyncOnRecovery() throws Exception {
                        empty()
import org.opensearch.core.index.shard.ShardId;
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            // now renew all existing leases; we expect to see these synced to the replicas
            // simulate a peer recovery which locks the soft deletes policy on the primary
import java.io.Closeable;
                        .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
    }
            listener.onResponse(new ReplicationResponse());
                        TransportService.class,
        assertAcked(prepareCreate("index").setSettings(settings));
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
        final String source = randomAlphaOfLength(8);
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            currentRetentionLeases.put(
/*
        logger.info("finished adding [{}] retention leases", length);
    }
