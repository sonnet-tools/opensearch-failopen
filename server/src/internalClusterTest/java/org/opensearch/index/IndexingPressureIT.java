            });  
        );  
 */
                    blockReplication.await();  
            .filter(sr -> sr.primary() == false)  
                latchBlockingReplicationSend.countDown();  
                try {  
import java.util.Collections;  
            assertEquals(0, primaryWriteLimits.getCurrentCoordinatingBytes());
import org.opensearch.transport.TransportService;
            }
            .findAny()
                if (randomBoolean()) {
        });  
        final long bulkShardRequestSize = totalRequestSize;  
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));
            ;
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
        );
            assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());
        restartNodesWithSettings(
        ensureGreen(INDEX_NAME);
        return 1;  
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());  
            final BulkRequest secondBulkRequest = new BulkRequest();
/*
                INDEX_NAME,
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
            assertEquals(0, primaryWriteLimits.getCurrentPrimaryBytes());  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
            successFuture.actionGet();  
        final BulkRequest bulkRequest = new BulkRequest();  
            // The write limits is set to 1MB. We will send up to 800KB to stay below that threshold.
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
            responses.forEach(ActionFuture::actionGet);
import org.opensearch.action.admin.indices.stats.ShardStats;
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
        String primaryName = nodes.get(primaryId).getName();
    }
            assertThat(responses.getItems()[0].getFailure().getCause().getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCoordinatingBytes());
            });
            assertTrue(request.ramBytesUsed() > request.source().length());
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
        for (int i = 0; i < threads; ++i) {
        String replicaName = nodes.get(replicaId).getName();  
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
        return client().admin()
            }
                try {
            assertThat(primaryWriteLimits.getCurrentPrimaryBytes(), greaterThan(bulkShardRequestSize));
    }  
                .getShardIndexingPressure();
    }
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;  
            .next()
            ArrayList<ActionFuture<IndexResponse>> responses = new ArrayList<>();
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());  
            ;
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            totalRequestSize += request.ramBytesUsed();  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        final long bulkShardRequestSize = totalRequestSize;
                )
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());  
import org.opensearch.common.lease.Releasable;
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
                    client(replicaName).bulk(bulkRequest).actionGet();  
            .get()
        };
            assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());  
            }  
            } else {
        int totalRequestSize = 0;
            secondFuture.actionGet();
            replicaRelease.close();  
        assertAcked(  
        }
                IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                .getShardIndexingPressure();  
import java.util.stream.Stream;
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        return 1;
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
            .get()
            int totalRequestSize = 0;  
                    .source(Collections.singletonMap("key", randomAlphaOfLength(500)));  
    }
            .cluster()
/*  
            replicaRelease.close();
 * this work for additional information regarding copyright
            final long secondBulkShardRequestSize = request.ramBytesUsed();
 * under the License.  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        ensureGreen(INDEX_NAME);  
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)  
 */  
            }  
    @Override
 * license agreements. See the NOTICE file distributed with
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
 * KIND, either express or implied.  See the License for the
                secondFuture = client(primaryName).bulk(secondBulkRequest);
    @Override
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());  
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            bulkRequest.add(request);  
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertTrue(responses.hasFailures());  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());  
                .getShardIndexingPressure();  
import java.util.concurrent.CountDownLatch;
            replicaRelease.close();
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));  
 * You may obtain a copy of the License at  
import org.opensearch.test.InternalTestCluster;  
                    latchBlockingReplicationSend.await();
                    assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());  
                .getShardIndexingPressure();
                    assertThat(primaryWriteLimits.getCurrentPrimaryBytes(), greaterThan(bulkShardRequestSize + secondBulkRequestSize));
            }
        }
                .getShardIndexingPressure();
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);  
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());  
                assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertThat(replicaWriteLimits.getCurrentReplicaBytes(), greaterThan(bulkShardRequestSize));  
    }
                totalRequestSize += request.ramBytesUsed();
            primaryTransportService.clearAllRules();  
            latchBlockingReplicationSend.countDown();  
                INDEX_NAME,
            .getState()
            int thresholdToStopSending = 800 * 1024;  
            public Settings onNodeStopped(String nodeName) {  
            replicaRelease.close();
                    replicationSendPointReached.countDown();
    }
    public static final String INDEX_NAME = "test";
                () -> assertThat(
                assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
import static org.hamcrest.Matchers.instanceOf;  
            }
import org.opensearch.test.transport.MockTransportService;
            connection.sendRequest(requestId, action, request, options);
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        restartNodesWithSettings(Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1MB").build());
            BulkResponse responses = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
            secondBulkRequest.add(request);
        try {
            prepareCreate(
            );  
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {  
public class IndexingPressureIT extends OpenSearchIntegTestCase {  
                    client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)  
import org.opensearch.common.UUIDs;
}
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            if (usePrimaryAsCoordinatingNode) {
    }  
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
            .getCoordinatingOnlyNodes()
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
        ensureGreen(INDEX_NAME);  
 *
        final BulkRequest bulkRequest = new BulkRequest();
                assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
        final CountDownLatch blockReplication = new CountDownLatch(1);
            bulkRequest.add(request);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
package org.opensearch.index;
import static org.hamcrest.Matchers.greaterThan;
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
    }
        assertAcked(  
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());  
            successFuture.actionGet();
 * Modifications Copyright OpenSearch Contributors. See  
            prepareCreate(
 * compatible open source license.
            .values()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        String replicaId = Stream.of(response.getShards())
    protected int numberOfShards() {
        String replicaName = primaryReplicaNodeNames.v2();  
/*
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();
            boolean usePrimaryAsCoordinatingNode = randomBoolean();
                assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
            .getName();
        for (int i = 0; i < 80; ++i) {
import java.util.ArrayList;  
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)  
        String replicaName = primaryReplicaNodeNames.v2();
import org.opensearch.action.bulk.BulkRequest;
            if (replicationSendPointReached.getCount() > 0) {
    private Tuple<String, String> getPrimaryReplicaNodeNames() {
import org.opensearch.threadpool.ThreadPool;  
        restartNodesWithSettings(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .getShardIndexingPressure();
            .filter(ShardRouting::primary)  
import org.opensearch.cluster.routing.ShardRouting;  
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));  
                assertEquals(secondBulkRequestSize, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
                    assertEquals(secondBulkRequestSize, primaryWriteLimits.getCurrentCoordinatingBytes());
                }
        final BulkRequest bulkRequest = new BulkRequest();
            totalRequestSize += request.ramBytesUsed();
        }
    public void testWriteCanBeRejectedAtPrimaryLevel() throws Exception {
    private void restartNodesWithSettings(Settings settings) throws Exception {  
import org.opensearch.cluster.node.DiscoveryNodes;
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
        for (int i = 0; i < 80; ++i) {
                blockReplication.countDown();  
            .currentNodeId();  
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        String primaryName = primaryReplicaNodeNames.v1();
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override  
                    throw new IllegalStateException(e);
            .currentNodeId();  
 * this file be licensed under the Apache-2.0 license or a
            prepareCreate(  
            assertBusy(() -> {  
 *
        String primaryName = primaryReplicaNodeNames.v1();  
        String primaryId = Stream.of(response.getShards())
            replicationSendPointReached.await();
            // Use the primary or the replica data node as the coordinating node this time
        String primaryName = primaryReplicaNodeNames.v1();
                    assertThat(  
    protected int numberOfReplicas() {  
                secondFuture = client(replicaName).bulk(secondBulkRequest);
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(request.ramBytesUsed() > request.source().length());  
            assertBusy(() -> {
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
                    );  
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
    private Releasable blockReplicas(ThreadPool threadPool) {
                assertEquals(secondBulkRequestSize, replicaWriteLimits.getCurrentCoordinatingBytes());  
 * SPDX-License-Identifier: Apache-2.0
        }  
                INDEX_NAME,  
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                INDEX_NAME,
    }
        } finally {  
                    client(primaryName).bulk(bulkRequest).actionGet();
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            // Would throw exception if one of the operations was rejected
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            replicaRelease.close();
import org.opensearch.test.InternalSettingsPlugin;
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
        );
import org.opensearch.action.index.IndexResponse;  
            bulkRequest.add(request);
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());  
        for (int i = 0; i < 80; ++i) {  
        ensureGreen(INDEX_NAME);
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
                assertBusy(() -> {
import java.util.Collection;
 * specific language governing permissions and limitations
        String replicaName = primaryReplicaNodeNames.v2();
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                });
        String replicaName = primaryReplicaNodeNames.v2();  
import org.opensearch.plugins.Plugin;
                .getShardIndexingPressure();  
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();  
        return () -> {
                } else {
        }
            final long secondBulkRequestSize = secondBulkRequest.ramBytesUsed();
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();  
            prepareCreate(
    public void testWriteCanBeRejectedAtCoordinatingLevel() throws Exception {
        String coordinatingOnlyNode = getCoordinatingOnlyNode();  
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .findAny()
                assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());  
                    replicaWriteLimits.getCurrentReplicaBytes(),  
                    assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());
    }  
        int totalRequestSize = 0;  
            if (blockReplication.getCount() > 0) {
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));  
            expectThrows(OpenSearchRejectedExecutionException.class, () -> {  
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
        final long bulkShardRequestSize = totalRequestSize;  
                } else if (randomBoolean()) {  
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
        return new Tuple<>(primaryName, replicaName);
            .map(ShardStats::getShardRouting)
import org.opensearch.action.bulk.TransportShardBulkAction;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
    protected Settings nodeSettings(int nodeOrdinal) {
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
import org.opensearch.common.collect.Tuple;  
            .prepareState()  
    }
            .nodes()  
            )
import org.opensearch.test.OpenSearchIntegTestCase;
                }
            replicaRelease.close();
            )  
            }
    @Override
                assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
        IndicesStatsResponse response = client().admin().indices().prepareStats(INDEX_NAME).get();  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            }  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();  
                responses.add(client(coordinatingOnlyNode).index(request));
            assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
            while (totalRequestSize < thresholdToStopSending) {
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
 */
 * not use this file except in compliance with the License.
                    pointReached.countDown();
                } catch (InterruptedException e) {
            )
    public static final Settings settings = Settings.builder()  
 * GitHub history for details.
                assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());  
        int totalRequestSize = 0;
                assertThat(replicaWriteLimits.getCurrentReplicaBytes(), greaterThan(bulkShardRequestSize));
import org.opensearch.action.index.IndexRequest;
                } catch (InterruptedException e) {  
            totalRequestSize += request.ramBytesUsed();
            successFuture.actionGet();
            });
                assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);
        final long bulkRequestSize = bulkRequest.ramBytesUsed();
                        primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(),
 *  
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        assertAcked(
        final long bulkRequestSize = bulkRequest.ramBytesUsed();  
            final ActionFuture<BulkResponse> secondFuture;  
                    throw new IllegalStateException(e);
import org.opensearch.common.action.ActionFuture;
            } else {  
            assertEquals(0, coordinatingWriteLimits.getCurrentPrimaryBytes());
                    greaterThan(bulkShardRequestSize + secondBulkShardRequestSize)
            if (latchBlockingReplicationSend.getCount() > 0) {
            assertEquals(0, primaryWriteLimits.getCurrentCoordinatingBytes());
            assertEquals(0, coordinatingWriteLimits.getCurrentPrimaryBytes());  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));  
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
 * ownership. Elasticsearch licenses this file to you under  
            assertTrue(request.ramBytesUsed() > request.source().length());
            )
            assertBusy(
        );
        }
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
            });
                        greaterThan(bulkShardRequestSize + secondBulkRequestSize)
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        );  
    public void testWritesWillSucceedIfBelowThreshold() throws Exception {
                }  
    private String getCoordinatingOnlyNode() {  
        });
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()  
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
            if (usePrimaryAsCoordinatingNode) {
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            @Override
            .map(ShardStats::getShardRouting)
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();
import java.util.Arrays;
        final CountDownLatch pointReached = new CountDownLatch(threads);
                .getShardIndexingPressure();  
        );
                replicationSendPointReached.countDown();
                .getShardIndexingPressure();
        assertAcked(
        .build();
                    assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            assertEquals(0, coordinatingWriteLimits.getCurrentCoordinatingBytes());  
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.action.bulk.BulkResponse;  
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));  
    public void testWriteBytesAreIncremented() throws Exception {  
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);  
    }  
            .get()
            .iterator()  
        }  
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);  
        }
