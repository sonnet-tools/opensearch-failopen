        });
                }
        // set the sync interval high so it does not execute during this test. This only allows the global checkpoint to catch up
                                equalTo(seqNoStats.getMaxSeqNo())  
import org.opensearch.common.unit.TimeValue;
        prepareCreate("test", indexSettings).get();
import org.opensearch.cluster.node.DiscoveryNodes;
            }
 */
 * the Apache License, Version 2.0 (the "License"); you may
                    client().prepareIndex("test").setId(id).setSource("{\"foo\": " + id + "}", MediaTypeRegistry.JSON).get();
        barrier.await();
                .put("index.number_of_replicas", numberOfReplicas)  
        for (int i = 0; i < numberOfThreads; i++) {  
            ensureGreen("test");  
        for (int j = 0; j < 10; j++) {
 */  
            for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
 * KIND, either express or implied.  See the License for the
/*
            final Thread thread = new Thread(() -> {
                }
        }
 * ownership. Elasticsearch licenses this file to you under  
            // prevent global checkpoint syncs between all nodes  
                    final MockTransportService receiverTransportService = (MockTransportService) internalCluster().getInstance(  
            TimeValue.timeValueHours(24),
import java.util.concurrent.TimeUnit;
        }, client -> {  
                        other.getName()
            SeqNoStats seqNoStats = client().admin().indices().prepareStats("test").get().getIndex("test").getShards()[0].getSeqNoStats();
import org.opensearch.test.OpenSearchIntegTestCase;
                    throw new RuntimeException(e);  
        int numDocs = randomIntBetween(1, 20);
import static org.hamcrest.Matchers.equalTo;
                    assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));  
import org.opensearch.test.transport.MockTransportService;
    }
                try {  
                    );
                                "shard " + shard.routingEntry() + " seq_no [" + seqNoStats + "]",
 * under the License.  
                    throw new RuntimeException(e);  
     * This test swallows the post-operation global checkpoint syncs, and then restores the ability to send these requests at the end of the
/*  
                    final String id = Integer.toString(index * numberOfDocuments + j);  
                        other.getName()
    }
        });  
        }  
        afterIndexing.accept(client());
                                seqNoStats.getGlobalCheckpoint(),
                }
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        final int numberOfThreads = randomIntBetween(1, 4);
import java.util.function.Consumer;  
        }  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST))  
                        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
                        continue;
        ensureGreen("test");
                        node.getName()
                .prepareUpdateSettings("test")
    }
    public void testPersistGlobalCheckpoint() throws Exception {
            }
import org.opensearch.transport.client.Client;
            client -> client.admin()  
                    if (node == other) {
    ) throws Exception {
        }
        if (randomBoolean()) {
                    for (IndexShard shard : indexService) {  
        // start concurrent indexing threads
}  
        internalCluster().ensureAtLeastNumDataNodes(2);
            "test",  
 */  
            .put("index.number_of_replicas", randomIntBetween(0, 1));  
        );  
            threads.add(thread);  
 * this work for additional information regarding copyright
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
import org.opensearch.indices.IndicesService;
public class GlobalCheckpointSyncIT extends OpenSearchIntegTestCase {  
import java.util.Collection;
    }
        }
                    final MockTransportService senderTransportService = (MockTransportService) internalCluster().getInstance(
            }  
            thread.start();
                            final SeqNoStats seqNoStats = shard.seqNoStats();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testGlobalCheckpointSyncWithAsyncDurability() throws Exception {
                } catch (BrokenBarrierException | InterruptedException e) {
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "10m")  
                        TransportService.class,  
        ensureGreen("test");  
                .indices()
    private void runGlobalCheckpointSyncTest(
        }
                .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), randomTimeValue(100, 1000, "ms"));
 * compatible open source license.
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;
            final DiscoveryNodes nodes = client.admin().cluster().prepareState().get().getState().getNodes();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), randomTimeValue(100, 1000, "ms"))
                    assertThat(maxSeqNo, equalTo(seqNoStats.getMaxSeqNo()));
                .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "1s")  
/*  
                try {  
                for (final DiscoveryNode other : nodes) {
import org.opensearch.index.IndexSettings;
                    final MockTransportService receiverTransportService = (MockTransportService) internalCluster().getInstance(
            for (IndexService indexService : indicesService) {
        barrier.await();
            assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
                        }
 * not use this file except in compliance with the License.
    public void testPersistLocalCheckpoint() {  
 * The OpenSearch Contributors require contributions made to  
        }
            final int index = i;
        assertBusy(() -> {  
    }  
        int numDocs = randomIntBetween(1, 20);  
 * software distributed under the License is distributed on an
                    );
        final Consumer<Client> afterIndexing
            Settings.builder()
                        node.getName()  
import java.util.List;
        runGlobalCheckpointSyncTest(TimeValue.timeValueSeconds(randomIntBetween(1, 3)), client -> {
 * this file be licensed under the Apache-2.0 license or a
                    }  
import org.opensearch.index.shard.IndexShard;
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), globalCheckpointSyncInterval)
                            connection.sendRequest(requestId, action, request, options);
     * test so that a background sync can fire and sync the global checkpoint.
        beforeIndexing.accept(client());  
        internalCluster().ensureAtLeastNumDataNodes(1 + numberOfReplicas);
                            assertThat(  
            for (final DiscoveryNode node : nodes) {  
                    final MockTransportService senderTransportService = (MockTransportService) internalCluster().getInstance(
        Settings.Builder indexSettings = Settings.builder()  
                        if (shard.routingEntry().primary()) {
        final int numberOfDocuments = randomIntBetween(0, 256);
        return Stream.concat(super.nodePlugins().stream(), Stream.of(InternalSettingsPlugin.class, MockTransportService.TestPlugin.class))
        for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
                }
                    final SeqNoStats seqNoStats = shard.seqNoStats();
            Settings.builder()  
        });  
        final TimeValue globalCheckpointSyncInterval,
                    barrier.await();
        ).get();
                    senderTransportService.clearOutboundRules(receiverTransportService);
                    }
            logger.info("got {}", maxSeqNo);
                            throw new IllegalStateException("blocking indices:admin/seq_no/global_checkpoint_sync[r]");
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
                .get(),
        // wait for the threads to finish
                    if (node == other) {
            .collect(Collectors.toList());
                for (IndexService indexService : indicesService) {  
        }
                    }  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
            final DiscoveryNodes nodes = client.admin().cluster().prepareState().get().getState().getNodes();
        logger.info("numDocs {}", numDocs);
            });
            .put("index.number_of_replicas", randomIntBetween(0, 1));
                    );  
        internalCluster().ensureAtLeastNumDataNodes(2);  
                            );
import java.util.ArrayList;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.IndexService;  
            "test",
        long maxSeqNo = 0;
        ).get();
                        }
        }, 60, TimeUnit.SECONDS);  
                }
        if (randomBoolean()) {  
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put("index.number_of_replicas", 1)
                    ;
        for (final Thread thread : threads) {
            final String id = Integer.toString(j);
import java.util.concurrent.BrokenBarrierException;  
        if (randomBoolean()) {
                        } else {  
                        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
            client -> {}
 *  
                        if ("indices:admin/seq_no/global_checkpoint_sync[r]".equals(action)) {
                for (IndexShard shard : indexService) {  
                } catch (BrokenBarrierException | InterruptedException e) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.translog.Translog;  
        assertBusy(() -> {
            .put("index.number_of_shards", 1)
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
        assertBusy(() -> {  
                for (int j = 0; j < numberOfDocuments; j++) {
    @Override
            // restore global checkpoint syncs between all nodes
            thread.join();  
                        TransportService.class,
        runGlobalCheckpointSyncTest(
package org.opensearch.index.seqno;
                }
            for (IndicesService indicesService : internalCluster().getDataNodeInstances(IndicesService.class)) {
                    );
import java.util.stream.Collectors;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // checkpoint sync to allow the information about persisted local checkpoints to be transferred to the primary.  
                    }  
            maxSeqNo = client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get().getSeqNo();
     */  
                    for (IndexShard shard : indexService) {
                        final SeqNoStats seqNoStats = shard.seqNoStats();
        final List<Thread> threads = new ArrayList<>(numberOfThreads);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportService;  
                        TransportService.class,
            ensureGreen();  
        // synchronize the start of the threads
                for (IndexService indexService : indicesService) {
        ensureGreen("test");
    }
        }
                        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));  
                        TransportService.class,  
        prepareCreate(
                }
        for (int i = 0; i < numDocs; i++) {  
    }
        final Consumer<Client> beforeIndexing,  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        // on a post-operation background sync if translog durability is set to sync. Async durability relies on a scheduled global
        for (int i = 0; i < numDocs; i++) {  
import org.opensearch.test.InternalSettingsPlugin;  
    /*  
                    senderTransportService.addSendBehavior(receiverTransportService, (connection, requestId, action, request, options) -> {  
    public void testBackgroundGlobalCheckpointSync() throws Exception {
    public void testPostOperationGlobalCheckpointSync() throws Exception {  
        Settings.Builder indexSettings = Settings.builder()
                    });  
            }
                    barrier.await();
        final int numberOfReplicas = randomIntBetween(1, 4);  
import org.opensearch.cluster.node.DiscoveryNode;
        prepareCreate("test", indexSettings).get();
        prepareCreate(
 *
            client().prepareIndex("test").setId(id).setSource("{\"foo\": " + id + "}", MediaTypeRegistry.JSON).get();  
 * specific language governing permissions and limitations
            indexSettings.put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
            }  
                }
import org.opensearch.plugins.Plugin;
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
import org.opensearch.common.settings.Settings;  
            for (final DiscoveryNode node : nodes) {
                        continue;  
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
                for (final DiscoveryNode other : nodes) {  
