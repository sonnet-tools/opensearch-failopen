                } else if (randomBoolean()) {
    @Override
        int totalRequestSize = 0;
                assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
            .map(ShardStats::getShardRouting)
 * software distributed under the License is distributed on an
                    assertEquals(secondBulkRequestSize, primaryWriteLimits.getCurrentCoordinatingBytes());
            assertThat(responses.getItems()[0].getFailure().getCause().getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
        restartNodesWithSettings(
            } else {
                assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
    }
            .iterator()
            final long secondBulkRequestSize = secondBulkRequest.ramBytesUsed();
                .getShardIndexingPressure();
            assertBusy(() -> {
        );
            totalRequestSize += request.ramBytesUsed();
 * Licensed to Elasticsearch under one or more contributor
    @Override
            .currentNodeId();
            )
        ensureGreen(INDEX_NAME);
        return 1;
            final ActionFuture<BulkResponse> secondFuture;
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
                } catch (InterruptedException e) {
 * this file be licensed under the Apache-2.0 license or a
            .filter(sr -> sr.primary() == false)
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);
                assertBusy(() -> {
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                .getShardIndexingPressure();
            .cluster()
            if (latchBlockingReplicationSend.getCount() > 0) {
import org.opensearch.action.bulk.TransportShardBulkAction;
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
            ;
            .values()
                INDEX_NAME,
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
            .next()
            replicationSendPointReached.await();
            }
 * under the License.
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
    }
        String primaryId = Stream.of(response.getShards())
    public void testWritesWillSucceedIfBelowThreshold() throws Exception {
            secondBulkRequest.add(request);
                    client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
            totalRequestSize += request.ramBytesUsed();
    protected int numberOfShards() {
            assertEquals(0, primaryWriteLimits.getCurrentCoordinatingBytes());
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        restartNodesWithSettings(Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1MB").build());
                    assertThat(primaryWriteLimits.getCurrentPrimaryBytes(), greaterThan(bulkShardRequestSize + secondBulkRequestSize));
    protected Settings nodeSettings(int nodeOrdinal) {
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));
            )
        });
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < threads; ++i) {
            if (blockReplication.getCount() > 0) {
            replicaRelease.close();
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
import java.util.stream.Stream;
        ensureGreen(INDEX_NAME);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.test.OpenSearchIntegTestCase;
            public Settings onNodeStopped(String nodeName) {
 * KIND, either express or implied.  See the License for the
                if (randomBoolean()) {
            if (replicationSendPointReached.getCount() > 0) {
        final CountDownLatch blockReplication = new CountDownLatch(1);
import java.util.Collections;
            assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());
                assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
            bulkRequest.add(request);
        String replicaId = Stream.of(response.getShards())
        );
                assertThat(replicaWriteLimits.getCurrentReplicaBytes(), greaterThan(bulkShardRequestSize));
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
    }
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        }
            } else {
    public static final Settings settings = Settings.builder()
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
 * specific language governing permissions and limitations
            });
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .filter(ShardRouting::primary)
            responses.forEach(ActionFuture::actionGet);
import java.util.ArrayList;
        }
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            latchBlockingReplicationSend.countDown();
                secondFuture = client(primaryName).bulk(secondBulkRequest);
        assertAcked(
package org.opensearch.index;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            assertTrue(responses.hasFailures());
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
    }
            assertTrue(request.ramBytesUsed() > request.source().length());
                INDEX_NAME,
            assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());
 * this work for additional information regarding copyright
                assertEquals(secondBulkRequestSize, replicaWriteLimits.getCurrentCoordinatingBytes());
        String replicaName = primaryReplicaNodeNames.v2();
            }
        final long bulkRequestSize = bulkRequest.ramBytesUsed();
            bulkRequest.add(request);
                });
                        greaterThan(bulkShardRequestSize + secondBulkRequestSize)
        ensureGreen(INDEX_NAME);
    private String getCoordinatingOnlyNode() {
            secondFuture.actionGet();
                    replicationSendPointReached.countDown();
            .map(ShardStats::getShardRouting)
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();
 *
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
 */
            // The write limits is set to 1MB. We will send up to 800KB to stay below that threshold.
            boolean usePrimaryAsCoordinatingNode = randomBoolean();
            expectThrows(OpenSearchRejectedExecutionException.class, () -> {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            while (totalRequestSize < thresholdToStopSending) {
            BulkResponse responses = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
                    .source(Collections.singletonMap("key", randomAlphaOfLength(500)));
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
import org.opensearch.test.transport.MockTransportService;
        final long bulkRequestSize = bulkRequest.ramBytesUsed();
        ensureGreen(INDEX_NAME);
            // Use the primary or the replica data node as the coordinating node this time
            replicaRelease.close();
                    pointReached.countDown();
            final long secondBulkShardRequestSize = request.ramBytesUsed();
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
public class IndexingPressureIT extends OpenSearchIntegTestCase {
            }
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
            prepareCreate(
                        primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(),
        int totalRequestSize = 0;
import org.opensearch.threadpool.ThreadPool;
        );
        );
import org.opensearch.common.collect.Tuple;
        String replicaName = primaryReplicaNodeNames.v2();
            assertBusy(
        }
import java.util.Arrays;
                    assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                )
            assertEquals(0, primaryWriteLimits.getCurrentCoordinatingBytes());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            if (usePrimaryAsCoordinatingNode) {
    }
                .getShardIndexingPressure();
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            final BulkRequest secondBulkRequest = new BulkRequest();
                responses.add(client(coordinatingOnlyNode).index(request));
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .nodes()
            .getName();
            .currentNodeId();
                try {
    }
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
            successFuture.actionGet();
            replicaRelease.close();
            });
            assertEquals(0, coordinatingWriteLimits.getCurrentPrimaryBytes());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            }
        }
        for (int i = 0; i < 80; ++i) {
            .getState()
            prepareCreate(
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
import java.util.Collection;
                } catch (InterruptedException e) {
            .prepareState()
 * GitHub history for details.
import org.opensearch.test.InternalTestCluster;
    protected int numberOfReplicas() {
            assertEquals(0, coordinatingWriteLimits.getCurrentCoordinatingBytes());
            assertTrue(request.ramBytesUsed() > request.source().length());
        final BulkRequest bulkRequest = new BulkRequest();
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
}
                } else {
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
    public void testWriteCanBeRejectedAtCoordinatingLevel() throws Exception {
            assertEquals(0, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            replicaRelease.close();
 * SPDX-License-Identifier: Apache-2.0
        .build();
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
    private Tuple<String, String> getPrimaryReplicaNodeNames() {
 * the Apache License, Version 2.0 (the "License"); you may
            bulkRequest.add(request);
                    client(replicaName).bulk(bulkRequest).actionGet();
                    );
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
            @Override
            assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
                    assertThat(
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
                    assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
    public static final String INDEX_NAME = "test";
                .getShardIndexingPressure();
            replicaRelease.close();
            int thresholdToStopSending = 800 * 1024;
import org.opensearch.action.admin.indices.stats.ShardStats;
    }
        String primaryName = nodes.get(primaryId).getName();
                assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        for (int i = 0; i < 80; ++i) {
                try {
        String replicaName = primaryReplicaNodeNames.v2();
        final CountDownLatch pointReached = new CountDownLatch(threads);
 * You may obtain a copy of the License at
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
                    throw new IllegalStateException(e);
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
import org.opensearch.common.action.ActionFuture;
import org.opensearch.cluster.metadata.IndexMetadata;
        }
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        String primaryName = primaryReplicaNodeNames.v1();
                .getShardIndexingPressure();
                }
        final BulkRequest bulkRequest = new BulkRequest();
            assertEquals(0, coordinatingWriteLimits.getCurrentPrimaryBytes());
                    greaterThan(bulkShardRequestSize + secondBulkShardRequestSize)
            successFuture.actionGet();
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertEquals(0, primaryWriteLimits.getCurrentPrimaryBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
    public void testWriteCanBeRejectedAtPrimaryLevel() throws Exception {
        final long bulkShardRequestSize = totalRequestSize;
/*
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
        String replicaName = primaryReplicaNodeNames.v2();
    }
                assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
    private Releasable blockReplicas(ThreadPool threadPool) {
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
                INDEX_NAME,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
                    client(primaryName).bulk(bulkRequest).actionGet();
 * compatible open source license.
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.cluster.routing.ShardRouting;
            .get()
            if (usePrimaryAsCoordinatingNode) {
        assertAcked(
                replicationSendPointReached.countDown();
import org.opensearch.cluster.node.DiscoveryNodes;
        };
    private void restartNodesWithSettings(Settings settings) throws Exception {
        final long bulkShardRequestSize = totalRequestSize;
            prepareCreate(
import static org.hamcrest.Matchers.greaterThan;
    }
    }
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
        }
import org.opensearch.action.bulk.BulkResponse;
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
                IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                .getShardIndexingPressure();
            .getCoordinatingOnlyNodes()
import org.opensearch.action.index.IndexResponse;
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
            assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));
        }
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
        assertAcked(
            .get()
                assertThat(replicaWriteLimits.getCurrentReplicaBytes(), greaterThan(bulkShardRequestSize));
            }
        final long bulkShardRequestSize = totalRequestSize;
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                }
 * The OpenSearch Contributors require contributions made to
            totalRequestSize += request.ramBytesUsed();
                blockReplication.countDown();
    public void testWriteBytesAreIncremented() throws Exception {
                .getShardIndexingPressure();
                }
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
        return client().admin()
                assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        return 1;
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
 * license agreements. See the NOTICE file distributed with
                    replicaWriteLimits.getCurrentReplicaBytes(),
            assertThat(primaryWriteLimits.getCurrentPrimaryBytes(), greaterThan(bulkShardRequestSize));
            replicaRelease.close();
            int totalRequestSize = 0;
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
    @Override
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));
import org.opensearch.test.InternalSettingsPlugin;
            assertEquals(0, replicaWriteLimits.getCurrentReplicaBytes());
 *
                assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
            });
            )
        IndicesStatsResponse response = client().admin().indices().prepareStats(INDEX_NAME).get();
            assertBusy(() -> {
        return new Tuple<>(primaryName, replicaName);
import org.opensearch.action.index.IndexRequest;
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
 */
            assertEquals(bulkRequestSize, coordinatingWriteLimits.getCurrentCoordinatingBytes());
            assertEquals(0, replicaWriteLimits.getCurrentPrimaryBytes());
        assertAcked(
import org.opensearch.transport.TransportService;
 * Unless required by applicable law or agreed to in writing,
                assertThat(primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes(), greaterThan(bulkShardRequestSize));
            IndexingPressure primaryWriteLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                () -> assertThat(
        for (int i = 0; i < 80; ++i) {
                INDEX_NAME,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
        }
            assertTrue(request.ramBytesUsed() > request.source().length());
            });
            connection.sendRequest(requestId, action, request, options);
        try {
 */
    @Override
                    throw new IllegalStateException(e);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
import org.opensearch.common.lease.Releasable;
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        restartNodesWithSettings(
        String replicaName = nodes.get(replicaId).getName();
        } finally {
            assertEquals(0, primaryWriteLimits.getCurrentReplicaBytes());
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                latchBlockingReplicationSend.countDown();
    }
            }
import static org.hamcrest.Matchers.instanceOf;
                    assertEquals(0, replicaWriteLimits.getCurrentCoordinatingBytes());
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
        final BulkRequest bulkRequest = new BulkRequest();
            ;
        int totalRequestSize = 0;
import org.opensearch.action.bulk.BulkRequest;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                    blockReplication.await();
    }
            IndexingPressure replicaWriteLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames();
                .getShardIndexingPressure();
 * ownership. Elasticsearch licenses this file to you under
            );
        String primaryName = primaryReplicaNodeNames.v1();
                secondFuture = client(replicaName).bulk(secondBulkRequest);
        });
            .get()
 * not use this file except in compliance with the License.
                totalRequestSize += request.ramBytesUsed();
                assertEquals(0, coordinatingWriteLimits.getCurrentReplicaBytes());
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();
        );
            }
            )
            IndexingPressure coordinatingWriteLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
        String primaryName = primaryReplicaNodeNames.v1();
            assertEquals(0, primaryWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .findAny()
import java.util.concurrent.CountDownLatch;
                .getShardIndexingPressure();
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();
/*
            primaryTransportService.clearAllRules();
            .findAny()
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            }
            // Would throw exception if one of the operations was rejected
        return () -> {
import org.opensearch.common.UUIDs;
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
            successFuture.actionGet();
/*
            assertEquals(0, coordinatingWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.plugins.Plugin;
 *
                assertEquals(secondBulkRequestSize, replicaWriteLimits.getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            ArrayList<ActionFuture<IndexResponse>> responses = new ArrayList<>();
            prepareCreate(
                    latchBlockingReplicationSend.await();
