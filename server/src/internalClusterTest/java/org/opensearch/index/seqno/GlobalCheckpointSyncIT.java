                    if (node == other) {
                for (final DiscoveryNode other : nodes) {
     * This test swallows the post-operation global checkpoint syncs, and then restores the ability to send these requests at the end of the
                    final MockTransportService senderTransportService = (MockTransportService) internalCluster().getInstance(
                for (int j = 0; j < numberOfDocuments; j++) {
                for (IndexService indexService : indicesService) {
            client -> client.admin()
            final Thread thread = new Thread(() -> {
                    );
                    senderTransportService.addSendBehavior(receiverTransportService, (connection, requestId, action, request, options) -> {
        if (randomBoolean()) {
        runGlobalCheckpointSyncTest(TimeValue.timeValueSeconds(randomIntBetween(1, 3)), client -> {
                        other.getName()
                        if (shard.routingEntry().primary()) {
                }
        // set the sync interval high so it does not execute during this test. This only allows the global checkpoint to catch up
            });
 * license agreements. See the NOTICE file distributed with
        final int numberOfDocuments = randomIntBetween(0, 256);
        internalCluster().ensureAtLeastNumDataNodes(2);
            "test",
                    }
            }
            for (final DiscoveryNode node : nodes) {
        // checkpoint sync to allow the information about persisted local checkpoints to be transferred to the primary.
 *
                .put("index.number_of_replicas", 1)
        assertBusy(() -> {
                                seqNoStats.getGlobalCheckpoint(),
        prepareCreate(
    @Override
            ensureGreen();
                        node.getName()
        final List<Thread> threads = new ArrayList<>(numberOfThreads);
        // synchronize the start of the threads
                    final SeqNoStats seqNoStats = shard.seqNoStats();
            // restore global checkpoint syncs between all nodes
        if (randomBoolean()) {
            "test",
 *
 * this work for additional information regarding copyright
                    ;
    ) throws Exception {
 */
import org.opensearch.common.settings.Settings;
                    );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // prevent global checkpoint syncs between all nodes
import org.opensearch.indices.IndicesService;
        return Stream.concat(super.nodePlugins().stream(), Stream.of(InternalSettingsPlugin.class, MockTransportService.TestPlugin.class))
            for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
                .prepareUpdateSettings("test")
                .get(),
 * Unless required by applicable law or agreed to in writing,
    public void testPersistLocalCheckpoint() {
            .put("index.number_of_replicas", randomIntBetween(0, 1));
            final String id = Integer.toString(j);
        }
        // on a post-operation background sync if translog durability is set to sync. Async durability relies on a scheduled global
    }
            logger.info("got {}", maxSeqNo);
 * GitHub history for details.
                        final SeqNoStats seqNoStats = shard.seqNoStats();
                        continue;
        });
        int numDocs = randomIntBetween(1, 20);
                        continue;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.InternalSettingsPlugin;
    }
            indexSettings.put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    final String id = Integer.toString(index * numberOfDocuments + j);
import org.opensearch.index.IndexSettings;
        if (randomBoolean()) {
public class GlobalCheckpointSyncIT extends OpenSearchIntegTestCase {
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), globalCheckpointSyncInterval)
            final DiscoveryNodes nodes = client.admin().cluster().prepareState().get().getState().getNodes();
                        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.Stream;
            TimeValue.timeValueHours(24),
                            );
                            assertThat(
        ensureGreen("test");
    private void runGlobalCheckpointSyncTest(
            for (IndexService indexService : indicesService) {
import org.opensearch.plugins.Plugin;
                for (IndexService indexService : indicesService) {
                            throw new IllegalStateException("blocking indices:admin/seq_no/global_checkpoint_sync[r]");
            Settings.builder()
 * The OpenSearch Contributors require contributions made to
            }
        barrier.await();
        for (int i = 0; i < numDocs; i++) {
        long maxSeqNo = 0;
import org.opensearch.test.OpenSearchIntegTestCase;
    /*
        }
import java.util.concurrent.TimeUnit;
        barrier.await();
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
                try {
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
    public void testGlobalCheckpointSyncWithAsyncDurability() throws Exception {
                    }
                }
/*
                    assertThat(maxSeqNo, equalTo(seqNoStats.getMaxSeqNo()));
import org.opensearch.common.unit.TimeValue;
        });
 * not use this file except in compliance with the License.
}
                    final MockTransportService senderTransportService = (MockTransportService) internalCluster().getInstance(
        for (int j = 0; j < 10; j++) {
        int numDocs = randomIntBetween(1, 20);
            assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
import java.util.Collection;
        beforeIndexing.accept(client());
        prepareCreate("test", indexSettings).get();
    }
                    if (node == other) {
                    senderTransportService.clearOutboundRules(receiverTransportService);
                }
 * under the License.
                    client().prepareIndex("test").setId(id).setSource("{\"foo\": " + id + "}", MediaTypeRegistry.JSON).get();
                        TransportService.class,
        }
 * specific language governing permissions and limitations
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
                }
        ensureGreen("test");
                    );
        for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST))
                            connection.sendRequest(requestId, action, request, options);
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
                } catch (BrokenBarrierException | InterruptedException e) {
        }, client -> {
import java.util.List;
            final DiscoveryNodes nodes = client.admin().cluster().prepareState().get().getState().getNodes();
import java.util.function.Consumer;
/*
                        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
                    final MockTransportService receiverTransportService = (MockTransportService) internalCluster().getInstance(
                    for (IndexShard shard : indexService) {
                        if ("indices:admin/seq_no/global_checkpoint_sync[r]".equals(action)) {
package org.opensearch.index.seqno;
                .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "1s")
import java.util.ArrayList;
    }
        ensureGreen("test");
                } catch (BrokenBarrierException | InterruptedException e) {
                    for (IndexShard shard : indexService) {
                        node.getName()
        afterIndexing.accept(client());
        }
        }, 60, TimeUnit.SECONDS);
                    }
                                "shard " + shard.routingEntry() + " seq_no [" + seqNoStats + "]",
        prepareCreate(
        assertBusy(() -> {
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
        final int numberOfThreads = randomIntBetween(1, 4);
                }
import java.util.concurrent.BrokenBarrierException;
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), randomTimeValue(100, 1000, "ms"))
            client().prepareIndex("test").setId(id).setSource("{\"foo\": " + id + "}", MediaTypeRegistry.JSON).get();
import org.opensearch.transport.TransportService;
            final int index = i;
import org.opensearch.index.shard.IndexShard;
 *
                    final MockTransportService receiverTransportService = (MockTransportService) internalCluster().getInstance(
            .collect(Collectors.toList());
        for (int i = 0; i < numberOfThreads; i++) {
        }
                        TransportService.class,
        }
                }
        prepareCreate("test", indexSettings).get();
                    throw new RuntimeException(e);
    public void testPersistGlobalCheckpoint() throws Exception {
        final Consumer<Client> afterIndexing
            threads.add(thread);
            thread.join();
            }
                    barrier.await();
        }
                        other.getName()
        ).get();
    }
            .put("index.number_of_shards", 1)
                for (final DiscoveryNode other : nodes) {
                    );
        );
                .indices()
                        TransportService.class,
            client -> {}
                                equalTo(seqNoStats.getMaxSeqNo())
            SeqNoStats seqNoStats = client().admin().indices().prepareStats("test").get().getIndex("test").getShards()[0].getSeqNoStats();
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        // start concurrent indexing threads
 * You may obtain a copy of the License at
        });
import org.opensearch.index.translog.Translog;
 * ownership. Elasticsearch licenses this file to you under
        Settings.Builder indexSettings = Settings.builder()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final Consumer<Client> beforeIndexing,
            ensureGreen("test");
        }
            for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
        for (final Thread thread : threads) {
        final int numberOfReplicas = randomIntBetween(1, 4);
     */
        logger.info("numDocs {}", numDocs);
import static org.hamcrest.Matchers.equalTo;
        // wait for the threads to finish
        internalCluster().ensureAtLeastNumDataNodes(2);
 * Licensed to Elasticsearch under one or more contributor
import java.util.stream.Collectors;
import org.opensearch.index.IndexService;
                    throw new RuntimeException(e);
                        TransportService.class,
            thread.start();
    public void testPostOperationGlobalCheckpointSync() throws Exception {
import org.opensearch.test.transport.MockTransportService;
 * compatible open source license.
                        }
                .put("index.number_of_replicas", numberOfReplicas)
/*
        ).get();
                }
                        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
                    });
            }
                            final SeqNoStats seqNoStats = shard.seqNoStats();
        runGlobalCheckpointSyncTest(
                for (IndexShard shard : indexService) {
import org.opensearch.cluster.node.DiscoveryNode;
    }
            maxSeqNo = client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get().getSeqNo();
        final TimeValue globalCheckpointSyncInterval,
            Settings.builder()
                    assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "10m")
            .put("index.number_of_replicas", randomIntBetween(0, 1));
            }
                        }
                        } else {
    }
import java.util.concurrent.CyclicBarrier;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
                    }
import org.opensearch.transport.client.Client;
        assertBusy(() -> {
        }
 */
                .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), randomTimeValue(100, 1000, "ms"));
 * KIND, either express or implied.  See the License for the
 */
                try {
        Settings.Builder indexSettings = Settings.builder()
                    barrier.await();
                }
    public void testBackgroundGlobalCheckpointSync() throws Exception {
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.cluster.node.DiscoveryNodes;
        internalCluster().ensureAtLeastNumDataNodes(2);
            for (final DiscoveryNode node : nodes) {
     * test so that a background sync can fire and sync the global checkpoint.
