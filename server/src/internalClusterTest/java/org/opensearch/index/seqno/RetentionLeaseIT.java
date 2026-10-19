            assertBusy(  
                )
        client().admin()
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
                /*
import java.util.concurrent.atomic.AtomicBoolean;  
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Settings settings = Settings.builder()
                currentRetentionLeases,  
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
                    actionLatch.countDown();
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
    }
                    );
        }  
            afterSync.accept(primary);  
            .put("index.number_of_shards", 1)
                public void onFailure(final Exception e) {
                .get();  
                    assertThat(replica.getRetentionLeases(), equalTo(primary.getRetentionLeases()));
                assertThat(
    public void testCanAddRetentionLeaseWithoutWaitingForShards() throws InterruptedException {
import org.opensearch.OpenSearchException;
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            retentionLock.close();  
            }
                assertBusy(  
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
                    final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)  
            return Collections.singletonList(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING);  
                .indices()
 * Unless required by applicable law or agreed to in writing,
                 * way for the current retention leases to end up written to disk so we assume that if they are written to disk, it
        final int length = randomIntBetween(1, 8);
import org.opensearch.action.support.replication.ReplicationResponse;  
            final CountDownLatch latch = new CountDownLatch(1);
            try {  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
                )
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
package org.opensearch.index.seqno;
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
                assertThat(  
            .get();  
        );
            latch.await();
        for (int i = 0; i < length; i++) {  
import org.opensearch.index.shard.IndexShard;
                .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
    }
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
        return ActionListener.wrap(r -> latch.countDown(), RetentionLeaseIT::failWithException);
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
        createIndex("index", settings);
        final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
        final int length = randomIntBetween(1, 8);
                 * implies that the background sync was able to execute despite wait for shards being set on the index.
        }
                        randomLongBetween(currentRetentionLeases.get(ids.get(j)).retainingSequenceNumber(), Long.MAX_VALUE),
            );
                }
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
                // check retention leases have been written on the replica
                    success.set(true);  
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
            final String nextId = randomValueOtherThan(idForInitialRetentionLease, () -> randomAlphaOfLength(8));
            indexShard -> {}
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
    ) throws InterruptedException {
                    RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.getRetentionLeases()).entrySet(),
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.getRetentionLeases()).entrySet(),  
            final CountDownLatch latch = new CountDownLatch(1);  
            client().admin()
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
        allowNodes("index", 1 + numberOfReplicas);
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
        }, primary -> {  
                );
    public void testCanRenewRetentionLeaseWithoutWaitingForShards() throws InterruptedException {
import org.opensearch.common.SuppressForbidden;  
                () -> assertThat(
        final long initialRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        for (int i = 0; i < length; i++) {  
                );
    private static ActionListener<ReplicationResponse> countDownLatchListener(CountDownLatch latch) {
        final BiConsumer<IndexShard, ActionListener<ReplicationResponse>> primaryConsumer,
            .put("index.number_of_shards", 1)
 * SPDX-License-Identifier: Apache-2.0
            latch.await();
                currentRetentionLeases.put(
                );  
import static org.hamcrest.Matchers.contains;
        final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
                );  
                replica.getRetentionLeases()
            final CountDownLatch latch = new CountDownLatch(1);
public class RetentionLeaseIT extends OpenSearchIntegTestCase {  
            // check retention leases have been written on the primary  
        final String waitForActiveValue = randomBoolean() ? "all" : Integer.toString(numDataNodes + 1);  
            .get();
                );
    }
        /*
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));
            final CountDownLatch latch = new CountDownLatch(1);
                }  
        createIndex("index", settings);  
        ensureGreen("index");
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();  
    }
                    primary.renewRetentionLease(  
        final long initialRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
                @Override
            }  
                .setPersistentSettings(
            latch.await();  
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
        final int numDataNodes = internalCluster().numDataNodes();
        latch.await();
        final String idForInitialRetentionLease = randomAlphaOfLength(8);  
            final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
    }  
                final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)
            .setSettings(Settings.builder().put("index.blocks." + block, true).build())
        final Settings settings = Settings.builder()  
            .put("index.number_of_replicas", numberOfReplicas)
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
import org.opensearch.common.unit.TimeValue;  
        }, primary -> {});
            final String nextSource = randomAlphaOfLength(8);  
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);  
                    final String replicaShardNodeId = replicaShard.currentNodeId();
            // now renew all existing leases; we expect to see these synced to the replicas
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.indices.IndicesService;  
import org.opensearch.test.transport.MockTransportService;
                assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));  
import static org.hamcrest.Matchers.empty;
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
    }
                .prepareUpdateSettings("index")  
        primary.addRetentionLease(idForInitialRetentionLease, initialRetainingSequenceNumber, source, listener);
/*
        final Settings settings = Settings.builder()
            primary.addRetentionLease(nextId, nextRetainingSequenceNumber, nextSource, listener);
 */  
                    final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
            // check retention leases have been written on the primary
            final String id = randomFrom(currentRetentionLeases.keySet());
        final BiConsumer<IndexShard, ActionListener<ReplicationResponse>> primaryConsumer,  
    public void testRetentionLeasesSyncedOnAdd() throws Exception {
            primaryConsumer.accept(primary, new ActionListener<ReplicationResponse>() {
        runWaitForShardsTest(idForInitialRetentionLease, randomLongBetween(0, Long.MAX_VALUE), (primary, listener) -> {  
            // check current retention leases have been synced to all replicas
            randomLongBetween(0, Long.MAX_VALUE),  
        runUnderBlockTest(idForInitialRetentionLease, initialRetainingSequenceNumber, (primary, listener) -> {
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()).values(),  
                        RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()).values(),
            retentionLease.set(primary.renewRetentionLease(idForInitialRetentionLease, nextRetainingSequenceNumber, nextSource));  
                );  
        final long initialRetainingSequenceNumber,
import org.opensearch.test.OpenSearchIntegTestCase;  
            primary -> {}
                    // return an exception to the FINALIZE action
                /*
            // put a new lease
        );  
            }
        ensureGreen("index");
        final AcknowledgedResponse response = client().admin()
/*  
import java.util.ArrayList;  
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));  
                actionLatch.countDown();
                        .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            .build();  
            .setSettings(Settings.builder().put("index.number_of_replicas", numberOfReplicas).build())
        public List<Setting<?>> getSettings() {
 * You may obtain a copy of the License at  
                } else {  
import java.util.Collections;
        runWaitForShardsTest(  
    }  
    }
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            super.nodePlugins().stream(),
                    );
    ) throws InterruptedException {
                    Settings.builder().put(INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), TimeValue.timeValueMillis(100))
    public void testCanAddRetentionLeaseUnderBlock() throws InterruptedException {
                    anyOf(empty(), contains(currentRetentionLease))
            final AcknowledgedResponse longTtlResponse = client().admin()
            final AcknowledgedResponse shortTtlResponse = client().admin()
            .prepareUpdateSettings("index")  
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)  
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
        final Consumer<IndexShard> afterSync  
            assertThat(
                .indices()  
        });  
            final String nextSource = randomAlphaOfLength(8);  
            listener.onResponse(new ReplicationResponse());
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();  
                public void onResponse(final ReplicationResponse replicationResponse) {
            );
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                .indices()  
            }
        }
            final String source = randomAlphaOfLength(8);  
        actionLatch.await();
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            public void onResponse(final ReplicationResponse replicationResponse) {
        final String idForInitialRetentionLease = randomAlphaOfLength(8);  
import org.opensearch.common.settings.Settings;
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);  
        assertTrue(response.isAcknowledged());
            assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));
                        connection.getNode().getName()
    }  
        runUnderBlockTest(idForInitialRetentionLease, randomLongBetween(0, Long.MAX_VALUE), (primary, listener) -> {
            .put("index.number_of_shards", 1)
                .setSettings(
                    // return a ConnectTransportException to the START_RECOVERY action
 * not use this file except in compliance with the License.
         * We effectively disable the background sync to ensure that the retention leases are not synced in the background so that the only  
                        TransportService.class,  
                }
import org.opensearch.index.IndexSettings;
 * The OpenSearch Contributors require contributions made to  
        );  
}
        createIndex("index", settings);
                    equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))
                // check all retention leases have been synced to all replicas
        assertTrue(success.get());
import org.opensearch.cluster.node.DiscoveryNode;
                    )
                    final TransportService replicaTransportService = internalCluster().getInstance(
 * this file be licensed under the Apache-2.0 license or a
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
        for (int i = 0; i < length; i++) {
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
        final String source = randomAlphaOfLength(8);  
            final String nextSource = randomAlphaOfLength(8);
                    )
                // check retention leases have been written on the replica  
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();  
 *  
            latch.await();
                 * If the background renew was able to execute, then the retention leases were persisted to disk. There is no other
            (primary, listener) -> primary.removeRetentionLease(idForInitialRetentionLease, listener),  
        // we will add multiple retention leases, wait for some to expire, and assert a consistent view between the primary and the replicas
            // check retention leases have been written on the replica; see RecoveryTarget#finalizeRecovery  
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
                .prepareUpdateSettings()  
                        .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), retentionLeaseTimeToLive)  
            .build();
import org.opensearch.core.index.shard.ShardId;
            // now that all retention leases are expired should have been synced to all replicas
        final CountDownLatch latch = new CountDownLatch(1);
            .build();
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()))  
import static org.hamcrest.Matchers.equalTo;  
                .get();  
 * GitHub history for details.
            }
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();  
 * specific language governing permissions and limitations
import java.util.LinkedHashMap;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
         * source of retention leases on the replicas would be from recovery.
                    equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))  
            .put("index.number_of_shards", 1)  
        // when we increase the number of replicas below we want to exclude the replicas from being allocated so that they do not recover
                 */
            .prepareUpdateSettings("index")
                    replica.getRetentionLeases()
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
            final long nextRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
            });  
        );
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
        final String block = randomFrom("read_only", "read_only_allow_delete", "read", "write", "metadata");
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            retentionLock.close();
            }  
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueHours(24));
                currentRetentionLeases,
import java.util.concurrent.atomic.AtomicReference;
        final int length = randomIntBetween(1, 8);  
            for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
            primary.addRetentionLease(nextId, nextRetainingSequenceNumber, nextSource, listener);
 * KIND, either express or implied.  See the License for the
                    replica.getRetentionLeases()
            .get();  
                failWithException(e);
        runUnderBlockTest(
                for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {  
    @Override
        assertAcked(  
            final String source = randomAlphaOfLength(8);
        final List<String> ids = new ArrayList<>(length);
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
            // check current retention leases have been synced to all replicas  
                id,
        try {
        }
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING;
            final long now = System.nanoTime();  
        }
        final long estimatedTimeIntervalMillis = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            latch.await();
            assertBusy(() -> {
            });
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(primary.loadRetentionLeases()))
            .put("index.number_of_replicas", 0)
        final String idForInitialRetentionLease,  
        final TimeValue retentionLeaseTimeToLive = TimeValue.timeValueMillis(
                    final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(client().admin().cluster().prepareHealth("index").setWaitForActiveShards(numDataNodes).get().isTimedOut());
        final long initialRetainingSequenceNumber,
        });  
    private void runUnderBlockTest(  
            .build();  
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>(length);  
import org.opensearch.common.settings.Setting;
        final AtomicBoolean success = new AtomicBoolean();  
            currentRetentionLeases.remove(id);  
        final String idForInitialRetentionLease = randomAlphaOfLength(8);  
            final String source = randomAlphaOfLength(8);
import java.util.List;
            Thread.sleep(Math.max(0, retentionLeaseTimeToLive.millis() - TimeUnit.NANOSECONDS.toMillis(later - now)));
                failWithException(e);  
                );
                        ids.get(j),
                    final String replicaShardNodeId = replicaShard.currentNodeId();
        }
        // we will add multiple retention leases and expect to see them synced to all replicas  
import org.opensearch.transport.TransportService;  
import org.opensearch.threadpool.ThreadPool;
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                .cluster()
                 * implies that the background sync was able to execute under a block.
            final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(
            final long nextRetainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);  
            .put("index.number_of_replicas", 0)
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));
        final Semaphore recoveriesToDisrupt = new Semaphore(scaledRandomIntBetween(0, 4));
import java.util.function.Consumer;  
            final long nextRetainingSequenceNumber = randomLongBetween(initialRetainingSequenceNumber, Long.MAX_VALUE);
                    throw new OpenSearchException("failing recovery for test purposes");
        final String source = randomAlphaOfLength(8);
        for (int i = 0; i < length; i++) {  
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                assertThat(retentionLeasesOnReplica, equalTo(currentRetentionLeases));
import java.util.Collection;
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
 * Modifications Copyright OpenSearch Contributors. See
        final CountDownLatch actionLatch = new CountDownLatch(1);
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
                        source  
    private void runWaitForShardsTest(
                }  
                    assertThat(
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();  
    }  
            for (int j = 0; j <= i; j++) {  
            // sleep long enough that the current retention lease has expired  
        }
 * this work for additional information regarding copyright
                    ids.get(j),
    public void testRetentionLeasesSyncOnRecovery() throws Exception {
import org.opensearch.plugins.Plugin;
import java.util.stream.Collectors;
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
                @Override
            final CountDownLatch latch = new CountDownLatch(1);  
    }  
import java.util.Map;
            latch.await();
            final CountDownLatch latch = new CountDownLatch(1);
            TransportService.class,
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};
            .put("index.number_of_shards", 1)
            final String nextSource = randomAlphaOfLength(8);
            .build();
            );
                final String replicaShardNodeId = replicaShard.currentNodeId();
        }, primary -> {});  
            final long later = System.nanoTime();
            // update the index for retention leases to live a long time
        final String primaryShardNodeName = clusterService().state().nodes().get(primaryShardNodeId).getName();  
        logger.info("adding retention [{}}] leases", length);
        runWaitForShardsTest(idForInitialRetentionLease, initialRetainingSequenceNumber, (primary, listener) -> {  
                .setSettings(Settings.builder().putNull(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey()).build())
                    Settings.builder()
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);  
        } finally {
        primary.addRetentionLease(idForInitialRetentionLease, initialRetainingSequenceNumber, source, listener);  
            });
                final String replicaShardNodeId = replicaShard.currentNodeId();  
            .put("index.number_of_shards", 1)  
         */
                        contains(retentionLease.get())
            listener.onResponse(new ReplicationResponse());
        ensureGreen("index");
import org.opensearch.index.IndexService;  
                    failWithException(e);  
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));
            idForInitialRetentionLease,
 * Licensed to Elasticsearch under one or more contributor  
                primary.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(latch::countDown))
            final Closeable retentionLock = randomBoolean() ? primary.acquireHistoryRetentionLock() : () -> {};  
            idForInitialRetentionLease,
                 */  
            primaryShardNodeName
                if (randomBoolean()) {  
            primary.removeRetentionLease(id, countDownLatchListener(latch));  
        // now allow the replicas to be allocated and wait for recovery to finalize  
            } catch (final Exception e) {  
                }  
            assertTrue(shortTtlResponse.isAcknowledged());
                    currentRetentionLeases,
        final Settings settings = Settings.builder()  
                    replicaTransportService.disconnectFromNode(primaryNode);
        ensureGreen("index");
            // simulate a peer recovery which locks the soft deletes policy on the primary
import java.io.Closeable;
    private static void failWithException(Exception e) {  
    }  
 */
                );  
    @SuppressForbidden(reason = "Sleeping longer than lease duration")  
 * under the License.  
                final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(
                        .build()
        }
            ids.add(id);
        final AtomicReference<RetentionLease> retentionLease = new AtomicReference<>();
            actionLatch.await();
            );
        logger.info("finished adding [{}] retention leases", length);  
                    final IndexShard replica = internalCluster().getInstance(IndicesService.class, replicaShardNodeName)  
            connection.sendRequest(requestId, action, request, options);
            assertThat(
        }
        assertAcked(prepareCreate("index", 1, settings));  
                .get();  
        client().admin()
        final CountDownLatch latch = new CountDownLatch(1);  
        ensureYellow("index");
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
        ensureGreen("index");
        // we will add multiple retention leases and expect to see them synced to all replicas
            }
        final String primaryShardNodeId = clusterService().state().routingTable().index("index").shard(0).primaryShard().currentNodeId();
        final Consumer<IndexShard> afterSync
        ensureGreen("index");
import java.util.concurrent.TimeUnit;
    public void testBackgroundRetentionLeaseSync() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    public void testCanRemoveRetentionLeasesUnderBlock() throws InterruptedException {
            final AtomicBoolean success = new AtomicBoolean();  
            .put("index.number_of_replicas", numberOfReplicas)
            assertTrue(longTtlResponse.isAcknowledged());
            .put("index.number_of_shards", 1)  
    }
            public void onFailure(final Exception e) {
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));  
            final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
import java.util.concurrent.CountDownLatch;  
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);  
            .indices()
            (primary, listener) -> primary.removeRetentionLease(idForInitialRetentionLease, listener),
                    RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.getRetentionLeases()).values(),
        // check current retention leases have been synced to all replicas
            @Override
 */  
        throw new AssertionError("unexpected", e);
    public void testCanRenewRetentionLeaseUnderBlock() throws InterruptedException {  
                .prepareUpdateSettings("index")
            }
                assertThat(  
                        empty()
            @Override
                final String replicaShardNodeId = replicaShard.currentNodeId();
            randomLongBetween(estimatedTimeIntervalMillis, 2 * estimatedTimeIntervalMillis)  
 * compatible open source license.
        ).collect(Collectors.toList());
        final String idForInitialRetentionLease,
    public void testRetentionLeasesSyncOnExpiration() throws Exception {
    }  
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));  
                        .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            assertBusy(() -> {
        assertAcked(prepareCreate("index").setSettings(settings));  
        final String idForInitialRetentionLease = randomAlphaOfLength(8);
    public void testRetentionLeaseSyncedOnRemove() throws Exception {
 *
        });
                for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {  
        latch.await();  
            final long nextRetainingSequenceNumber = randomLongBetween(initialRetainingSequenceNumber, Long.MAX_VALUE);
    public static final class RetentionLeaseSyncIntervalSettingPlugin extends Plugin {
        final Settings settings = Settings.builder()
        return Stream.concat(
        final Map<String, RetentionLease> currentRetentionLeases = new LinkedHashMap<>();
                )  
            // update the index for retention leases to short a long time, to force expiration  
import org.opensearch.core.action.ActionListener;
        ensureYellowAndNoInitializingShards("index");
        primaryConsumer.accept(primary, new ActionListener<ReplicationResponse>() {
                assertBusy(
            randomLongBetween(0, Long.MAX_VALUE),
            client().admin()
            final ActionListener<ReplicationResponse> listener = countDownLatchListener(latch);
    public void testCanRemoveRetentionLeasesWithoutWaitingForShards() throws InterruptedException {
        );
                equalTo(RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(replica.loadRetentionLeases()))  
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
            .build();
        for (int i = 0; i < length; i++) {
        assertAcked(prepareCreate("index").setSettings(settings));  
            final RetentionLease currentRetentionLease = primary.addRetentionLease(id, retainingSequenceNumber, source, listener);
            .indices()  
        final Settings settings = Settings.builder()
            .prepareUpdateSettings("index")
            final String source = randomAlphaOfLength(8);  
        for (final ShardRouting replicaShard : clusterService().state().routingTable().index("index").shard(0).replicaShards()) {
                 * way for the current retention leases to end up written to disk so we assume that if they are written to disk, it  
    }
        final MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(  
                    final DiscoveryNode primaryNode = primaryTransportService.getLocalNode();  
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, primaryShardNodeName)
        final Settings.Builder settings = Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
            retentionLease.set(primary.renewRetentionLease(idForInitialRetentionLease, nextRetainingSequenceNumber, nextSource));
            assertTrue(success.get());
                    currentRetentionLeases,
                    .getShardOrNull(new ShardId(resolveIndex("index"), 0));
            // check current retention leases have been synced to all replicas  
                    replicaTransportService.connectToNode(primaryNode);
                .prepareUpdateSettings("index")
        final int length = randomIntBetween(1, 8);  
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));
        // cause some recoveries to fail to ensure that retention leases are handled properly when retrying a recovery
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);
            Stream.of(RetentionLeaseSyncIntervalSettingPlugin.class, MockTransportService.TestPlugin.class)  
            );  
                failWithException(e);
                final Map<String, RetentionLease> retentionLeasesOnReplica = RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(  
import static org.hamcrest.Matchers.anyOf;  
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
            currentRetentionLeases.put(  
            .put("index.number_of_replicas", numberOfReplicas)  
 * license agreements. See the NOTICE file distributed with
                    () -> assertThat(
        final AtomicReference<RetentionLease> retentionLease = new AtomicReference<>();  
            final CountDownLatch actionLatch = new CountDownLatch(1);
                        contains(retentionLease.get())  
            .put("index.number_of_replicas", numberOfReplicas)
            .indices()  
            .put("index.number_of_replicas", numDataNodes)
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
                success.set(true);  
            assertThat(
            );  
                .setSettings(Settings.builder().putNull("index.blocks." + block).build())
            final String source = randomAlphaOfLength(8);  
        }, primary -> {
/*  
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
import java.util.stream.Stream;
 * software distributed under the License is distributed on an
                    () -> assertThat(
                currentRetentionLeases,
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE) && recoveriesToDisrupt.tryAcquire()) {
            .setSettings(Settings.builder().put("index.write.wait_for_active_shards", waitForActiveValue).build())
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // simulate a peer recovery which locks the soft deletes policy on the primary
            // simulate a peer recovery which locks the soft deletes policy on the primary  
        afterSync.accept(primary);  
        for (int i = 0; i < length; i++) {  
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
            } catch (final Exception e) {
            final String nextId = randomValueOtherThan(idForInitialRetentionLease, () -> randomAlphaOfLength(8));
                    )
                    empty()  
        @Override
            final String id = randomAlphaOfLength(8);  
    }  
    }  
                 * If the background renew was able to execute, then the retention leases were persisted to disk. There is no other  
import java.util.function.BiConsumer;
            final String replicaShardNodeId = replicaShard.currentNodeId();  
            retentionLock.close();
            }
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                final String replicaShardNodeName = clusterService().state().nodes().get(replicaShardNodeId).getName();  
            try {
        logger.info("allow [{}] replicas to allocate", numberOfReplicas);
        final int length = randomIntBetween(1, 8);
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
        createIndex("index", settings);  
import java.util.concurrent.Semaphore;
        final int numberOfReplicas = 2 - scaledRandomIntBetween(0, 2);  
        });  
