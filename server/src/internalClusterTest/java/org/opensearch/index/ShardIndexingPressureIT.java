        totalRequestSize = 0;  
        });  
        restartCluster(  
import org.opensearch.core.rest.RestStatus;
    }
            .get()  
            for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {  
                .getShardIndexingPressure()  
        final BulkRequest smallBulkRequest = new BulkRequest();
            bulkRequest.add(request);
            assertEquals(request.requests().get(i).opType(), item.getOpType());
            assertBusy(() -> {
            totalRequestSize += request.ramBytesUsed();
            }
    }
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        String primaryName = primaryReplicaNodeNames.v1();  
            smallBulkRequest.add(request);  
            totalRequestSize += request.ramBytesUsed();  
                .getShardIndexingPressureTracker(shardId);
        final CountDownLatch pointReached = new CountDownLatch(threads);
            // Poll for the second request to reach the primary (does not matter which node is coordinator)
        );
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
                assertEquals(0, coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.action.bulk.BulkShardRequest;  
            totalRequestSize += request.ramBytesUsed();
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
        for (int i = 0; i < response.getItems().length; i++) {  
        restartCluster(
                    assertEquals(  
            assertEquals(  
        String primaryName = primaryReplicaNodeNames.v1();
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());  
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                )
                assertEquals(  
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            .currentNodeId();
            } else if (randomBoolean()) {
                        0,
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
            final BulkResponse rejectedResponse;
            assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
            }
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertEquals(0, primaryShardTrackerSmall.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
            smallBulkRequest.add(request);  
            IndexRequest request = new IndexRequest(INDEX_NAME + "small").id(UUIDs.base64UUID())
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            assertTrue(request.ramBytesUsed() > request.source().length());
        IndicesStatsResponse response = client().admin().indices().prepareStats(indexName).get();
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
                .getShardIndexingPressureTracker(shardId);  
                    assertEquals(
        String replicaName = primaryReplicaNodeNames.v2();
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            Index index = indexService.getIndexSettings().getIndex();
        assertAcked(  
        );  
        final long largeBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
            .get()  
                );
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
                assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());  
        assertEquals(RestStatus.OK, response.status());  
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (largeBulkShardRequestSize * 1.5) + "B").build()
                        shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
        assertEquals(request.numberOfActions(), response.getItems().length);
            replicaRelease.close();
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
    @Override
            assertEquals(1, primaryShardTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
                    }  
                    bulkShardRequestSize,  
                coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                    assertEquals(
            if (randomBoolean()) {
        }  
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                equalTo(bulkShardRequestSize)
        return new Tuple<>(primaryName, replicaName);
                        shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);  
                    IndexingPressureService.class,
        String primaryId = Stream.of(response.getShards())
                assertEquals(
                rejectedResponse = client(replicaName).bulk(bulkRequest).actionGet();
                .getShardIndexingPressure()
                    blockReplication.await();  
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
        ensureGreen(INDEX_NAME);
import java.util.concurrent.CountDownLatch;  
import org.apache.lucene.util.RamUsageEstimator;
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
            latchBlockingReplicationSend.countDown();  
            bulkRequest.add(request);
                });
                INDEX_NAME + "small",
    }
                        coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
    private void restartCluster(Settings settings) throws Exception {  
        ensureGreen(INDEX_NAME);
        for (int i = 0; i < 10; ++i) {
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
            assertTrue(request.ramBytesUsed() > request.source().length());
        }
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);  
        ensureGreen(INDEX_NAME + "large");
            )
            largeBulkRequest.add(request);
                .source(Collections.singletonMap("key", randomAlphaOfLength(10)));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
                INDEX_NAME,  
        }  
                assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                ShardIndexingPressureTracker primaryShardTrackerSmall = internalCluster().getInstance(  
        final BulkRequest bulkRequest = new BulkRequest();  
        assertAcked(
                IndexingPressureService.class,
                shardId = null;
                    bulkShardRequestSize,
                    }
            if (usePrimaryAsCoordinatingNode) {
import static org.hamcrest.Matchers.equalTo;
            }
    }
            .nodes()
                assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        String replicaName = primaryReplicaNodeNames.v2();
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
import org.opensearch.core.index.Index;  
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        );  
            Index index = indexService.getIndexSettings().getIndex();
        );  
    protected int numberOfShards() {
                );  
                    assertEquals(  
        final BulkRequest largeBulkRequest = new BulkRequest();
        ensureGreen(INDEX_NAME + "small");  
        });
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                    secondBulkShardRequestSize,
                ShardIndexingPressureTracker replicaShardTrackerSmall = internalCluster().getInstance(
            final ThreadPool replicaThreadPoolSmallRequest = internalCluster().getInstance(ThreadPool.class, replicaName);
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),  
                if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "large")) {
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)  
        String replicaId = Stream.of(response.getShards())
        restartCluster(
    }  
            assertEquals(request.requests().get(i).id(), item.getId());
                IndexingPressureService.class,  
        for (int i = 0; i < 80; ++i) {
            boolean usePrimaryAsCoordinatingNode = randomBoolean();
            secondBulkRequest.add(request);
                IndexingPressureService.class,
            assertBusy(
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            .cluster()
import org.opensearch.action.bulk.BulkResponse;
        }
        final BulkRequest largeBulkRequest = new BulkRequest();
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                .getShardIndexingPressureTracker(shardId);  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));  
        for (int i = 0; i < 80; ++i) {  
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
                        coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()  
                assertEquals(0, coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            BulkResponse responses = client(coordinatingOnlyNode).bulk(largeBulkRequest).actionGet();
            )
                assertEquals(
        int totalRequestSize = 0;
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                }  
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
import org.opensearch.common.UUIDs;  
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            .filter(sr -> sr.primary() == false)
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .map(ShardStats::getShardRouting)  
public class ShardIndexingPressureIT extends OpenSearchIntegTestCase {  
                assertBusy(() -> {
            try (Releasable replicaReleaseSmallRequest = blockReplicas(replicaThreadPoolSmallRequest)) {
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
            prepareCreate(
        restartCluster(  
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        return 1;
import java.util.Arrays;  
                    IndexingPressureService.class,
                    shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
            }
        String replicaName = primaryReplicaNodeNames.v2();
            assertEquals(1, primaryShardTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
                );  
import org.opensearch.plugins.Plugin;
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
                    );
                coordinatingOnlyNode
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;  
import org.opensearch.common.action.ActionFuture;
                    secondBulkShardRequestSize,  
                .getShardIndexingPressure()  
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);  
        );
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                    assertEquals(  
            .findAny()
                }
            replicaRelease.close();
                assertEquals(0, primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertBusy(() -> {
        }
                replicationSendPointReached.countDown();  
            });  
    }
        assertTrue(response.hasFailures());
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
                () -> assertThat(  
            final ThreadPool replicaThreadPoolSmallRequest = internalCluster().getInstance(ThreadPool.class, replicaName);
            assertRejectedBulkResponse(bulkRequest, responses);
                    bulkShardRequestSize,  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
package org.opensearch.index;
            assertEquals(0, primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                );
            // Try sending a small request now instead which should succeed one the new shard with less occupancy  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    public void testWritesRejectedFairnessWithMultipleCoordinatingShardsDueToNodeLevelLimitBreach() throws Exception {  
            largeBulkRequest.add(request);
        ensureGreen(INDEX_NAME);
                final ActionFuture<BulkResponse> successFutureSmallRequest = client(primaryName).bulk(smallBulkRequest);
                latchBlockingReplicationSend.countDown();
            prepareCreate(
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            totalRequestSize += request.ramBytesUsed();
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
                    coordinatingOnlyNode
                        primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
        }  
                coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()
    public void testWritesRejectedFairnessWithMultiplePrimaryShardsDueToNodeLevelLimitBreach() throws Exception {  
            )
                );  
    private static void assertRejectedBulkResponse(BulkRequest request, BulkResponse response) {
                ShardIndexingPressureTracker coordinatingShardTrackerSmall = internalCluster().getInstance(  
                    primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()  
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);  
                .getShardIndexingPressure()
                    if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "small")) {
                .getShardIndexingPressureTracker(shardId);
            }  
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    largeBulkShardRequestSize,
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        );  
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(  
            )  
                assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                blockReplication.countDown();  
        };
                INDEX_NAME + "large",  
            totalRequestSize += request.ramBytesUsed();  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    IndexingPressureService.class,
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);  
                IndexingPressureService.class,
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
import org.opensearch.action.bulk.BulkItemRequest;
                assertEquals(
                    );  
            assertThat(  
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                .getShardIndexingPressure()
                .getShardIndexingPressure()
            }
                );  
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(largeBulkRequest);  
                assertEquals(0, replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
                .getShardIndexingPressureTracker(shardId);
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
import org.opensearch.common.settings.Settings;
            assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
            replicaRelease.close();
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        final long largeBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
            assertEquals(0, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());  
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    throw new IllegalStateException(e);
            // Try sending a small request now instead which should succeed one the new shard with less occupancy
import org.opensearch.core.index.shard.ShardId;
                assertEquals(
    @Override
    public void testShardIndexingPressureTrackingDuringBulkWrites() throws Exception {  
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);  
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        }  
        );  
            } else {
import org.opensearch.cluster.metadata.IndexMetadata;  
            });
            );
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            );
            );  
            @Override
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
import org.opensearch.common.collect.Tuple;
            IndexRequest request = new IndexRequest(INDEX_NAME + "large").id(UUIDs.base64UUID())
            IndexRequest request = new IndexRequest(INDEX_NAME + "small").id(UUIDs.base64UUID())
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                    largeBulkShardRequestSize,
                assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());  
                        smallBulkShardRequestSize,  
            .map(ShardStats::getShardRouting)  
            assertBusy(
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertTrue(request.ramBytesUsed() > request.source().length());  
                    );
        final CountDownLatch blockReplication = new CountDownLatch(1);
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
            // Large request on a shard with already large occupancy is rejected
            .getCoordinatingOnlyNodes()  
                );  
                        replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
                    largeBulkShardRequestSize,
            prepareCreate(  
import org.opensearch.ExceptionsHelper;
    }
            replicaRelease.close();  
    protected Settings nodeSettings(int nodeOrdinal) {
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);  
            totalRequestSize += request.ramBytesUsed();
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
                    replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
import org.opensearch.action.index.IndexRequest;
                    );  
            assertEquals(
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
                    replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()
                    pointReached.countDown();
            }
            .getName();
                ShardIndexingPressureTracker coordinatingShardTrackerSmall = internalCluster().getInstance(
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);
            }
        for (int i = 0; i < 80; ++i) {  
            final ActionFuture<BulkResponse> secondFuture;  
import org.opensearch.test.InternalSettingsPlugin;
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                }
                replicaReleaseSmallRequest.close();
                    IndexingPressureService.class,
        String primaryName = nodes.get(primaryId).getName();  
        totalRequestSize = 0;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
        String primaryName = primaryReplicaNodeNames.v1();
                assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            replicaRelease.close();
                    );  
        return client().admin()  
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);  
        try {
                assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                    throw new IllegalStateException(e);
            public Settings onNodeStopped(String nodeName) {  
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
            successFuture.actionGet();
                        replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
                    IndexingPressureService.class,  
                    shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
                    primaryName
                INDEX_NAME + "small",
            .next()  
    }  
        return 1;  
                rejectedResponse = client(primaryName).bulk(bulkRequest).actionGet();
                primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
            prepareCreate(  
                shardId = null;  
            bulkRequest.add(request);
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            .filter(ShardRouting::primary)
                        smallBulkShardRequestSize,
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
                .getShardIndexingPressure()
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }  
                    assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
        );
                        primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            );  
            .currentNodeId();
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            prepareCreate(
        int totalRequestSize = 0;
    }  
        final BulkRequest bulkRequest = new BulkRequest();
    }  
                for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {  
        );
                    assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.test.InternalTestCluster;  
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                    assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertBusy(() -> {
    }
            assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
                    assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertEquals(  
            ShardId shardId = null;
        String replicaName = nodes.get(replicaId).getName();
            .get()  
                assertEquals(0, primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            connection.sendRequest(requestId, action, request, options);
    private String getCoordinatingOnlyNode() {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                bulkShardRequestSize,
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            prepareCreate(
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        );
            ShardId shardId = new ShardId(index, 0);  
        String replicaName = primaryReplicaNodeNames.v2();  
            });
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertTrue(request.ramBytesUsed() > request.source().length());
            });  
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "large");
import org.opensearch.action.bulk.BulkItemResponse;  
import java.util.stream.Stream;
        int totalRequestSize = 0;
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                        smallBulkShardRequestSize,
import java.util.Collection;
 */  
            totalRequestSize += request.ramBytesUsed();  
            }
            assertNoFailures(successFuture.actionGet());  
                assertNoFailures(successFutureSmallRequest.actionGet());  
                assertEquals(  
            );
                    );
            .prepareState()
                ShardIndexingPressureTracker primaryShardTrackerSmall = internalCluster().getInstance(
import org.opensearch.indices.IndicesService;  
                )  
                    latchBlockingReplicationSend.await();
    protected int numberOfReplicas() {  
                    secondBulkShardRequestSize,
                replicaReleaseSmallRequest.close();
                .getShardIndexingPressureTracker(shardId);
                () -> assertThat(
                final ActionFuture<BulkResponse> successFutureSmallRequest = client(coordinatingOnlyNode).bulk(smallBulkRequest);  
            IndexRequest request = new IndexRequest(INDEX_NAME + "large").id(UUIDs.base64UUID())
                    replicationSendPointReached.countDown();
            }
            Index index = indexService.getIndexSettings().getIndex();
                );
            final long secondBulkShardRequestSize = request.ramBytesUsed() + RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class)
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            assertTrue(request.ramBytesUsed() > request.source().length());
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
                assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
            replicaRelease.close();
        );
    private Releasable blockReplicas(ThreadPool threadPool) {
}
                }  
            for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);  
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)  
                    replicaName  
        } finally {
                        smallBulkShardRequestSize,
import static org.hamcrest.Matchers.instanceOf;  
                );
                coordinatingOnlyNode
                .getShardIndexingPressureTracker(shardId);
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);  
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
    }
                assertNoFailures(successFutureSmallRequest.actionGet());
        int totalRequestSize = 0;
import org.opensearch.test.transport.MockTransportService;
            .iterator()
                    if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "small")) {
        }  
        assertAcked(
            assertRejectedBulkResponse(largeBulkRequest, responses);  
            assertNoFailures(successFuture.actionGet());
                });  
        int totalRequestSize = 0;
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        ensureGreen(INDEX_NAME + "large");
            ShardId shardId = new ShardId(index, 0);
            } else {  
        }
                    primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes(),  
                secondFuture = client(replicaName).bulk(secondBulkRequest);
                assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            prepareCreate(
                INDEX_NAME + "large",  
            replicationSendPointReached.await();
            if (blockReplication.getCount() > 0) {
            }
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            primaryTransportService.clearAllRules();
            assertRejectedBulkResponse(largeBulkRequest, client(coordinatingOnlyNode).bulk(largeBulkRequest).actionGet());  
            .findAny()
                    primaryName  
                assertEquals(0, replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertBusy(() -> {
            if (replicationSendPointReached.getCount() > 0) {
                    coordinatingOnlyNode
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
            // Use the primary or the replica data node as the coordinating node this time
                rejectedResponse = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();  
                        smallBulkShardRequestSize,  
        for (int i = 0; i < 80; ++i) {  
        for (int i = 0; i < 80; ++i) {
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();  
                if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "large")) {
                secondFuture = client(primaryName).bulk(secondBulkRequest);
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                }
            assertEquals(i, item.getItemId());
                coordinatingOnlyNode
    }
            try (Releasable replicaReleaseSmallRequest = blockReplicas(replicaThreadPoolSmallRequest)) {  
            assertTrue(item.isFailed());  
            assertNoFailures(successFuture.actionGet());  
        final BulkRequest bulkRequest = new BulkRequest();  
        final long smallBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 10)  
                .getShardIndexingPressureTracker(shardId);
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "large");
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(
                assertThat(
import org.opensearch.action.bulk.TransportShardBulkAction;
            assertTrue(request.ramBytesUsed() > request.source().length());
        for (int i = 0; i < 10; ++i) {
                try {
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
    private Tuple<String, String> getPrimaryReplicaNodeNames(String indexName) {  
                    assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
        }
                coordinatingOnlyNode
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
        String replicaName = primaryReplicaNodeNames.v2();  
        assertAcked(  
                .getShardIndexingPressureTracker(shardId);
                .getShardIndexingPressureTracker(shardId);
        .build();
                INDEX_NAME,
                assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
    @Override  
                    assertEquals(
        assertAcked(
        }  
            )
            secondFuture.actionGet();
        assertAcked(
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(largeBulkRequest);  
 * SPDX-License-Identifier: Apache-2.0
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                assertEquals(  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
    public void testWritesRejectedForSinglePrimaryShardDueToNodeLevelLimitBreach() throws Exception {
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);  
            assertThat(primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes(), equalTo(bulkShardRequestSize));
            assertThat(ExceptionsHelper.unwrapCause(item.getFailure().getCause()), instanceOf(OpenSearchRejectedExecutionException.class));
                .source(Collections.singletonMap("key", randomAlphaOfLength(10)));  
            );  
        final BulkRequest smallBulkRequest = new BulkRequest();
    public static final Settings settings = Settings.builder()  
        ensureGreen(INDEX_NAME + "small");  
                for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {
        }  
        final long smallBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 10)  
                .getShardIndexingPressure()
                    largeBulkShardRequestSize,
                INDEX_NAME,
            .getState()
        for (int i = 0; i < threads; ++i) {
                coordinatingOnlyNode  
    @Override
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());  
import java.util.Collections;
                assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)  
                assertEquals(0, coordinatingShardTrackerSmall.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());  
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
                assertEquals(  
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()  
                );  
    public static final String INDEX_NAME = "test_index";
                ShardIndexingPressureTracker replicaShardTrackerSmall = internalCluster().getInstance(
        }
            .values()
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.common.lease.Releasable;  
    public void testWritesRejectedForSingleCoordinatingShardDueToNodeLevelLimitBreach() throws Exception {
            final BulkRequest secondBulkRequest = new BulkRequest();
            replicaRelease.close();
import org.opensearch.transport.TransportService;
                    largeBulkShardRequestSize,
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)  
            });
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertBusy(() -> {
        return () -> {
                    IndexingPressureService.class,  
            BulkResponse responses = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
import org.opensearch.cluster.routing.ShardRouting;
                );
            assertTrue(request.ramBytesUsed() > request.source().length());  
                .getShardIndexingPressure()  
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.cluster.node.DiscoveryNodes;
                assertEquals(  
            BulkItemResponse item = response.getItems()[i];
            }
            assertNoFailures(successFuture.actionGet());
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            )
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();  
                );
            ShardId shardId = null;
/*  
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {  
            assertEquals(0, primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();  
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                    replicaName
                    coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                try {  
            assertEquals(0, coordinatingShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());  
                bulkShardRequestSize,
import org.opensearch.action.admin.indices.stats.ShardStats;
                } catch (InterruptedException e) {
        }
        String primaryName = primaryReplicaNodeNames.v1();
import org.opensearch.threadpool.ThreadPool;  
            assertEquals(request.requests().get(i).index(), item.getIndex());  
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                bulkShardRequestSize,  
                assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
                    coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()  
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            if (latchBlockingReplicationSend.getCount() > 0) {  
            if (usePrimaryAsCoordinatingNode) {  
import org.opensearch.action.bulk.BulkRequest;
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertRejectedBulkResponse(bulkRequest, rejectedResponse);  
            ShardId shardId = new ShardId(index, 0);  
                assertEquals(
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        String primaryName = primaryReplicaNodeNames.v1();  
                } catch (InterruptedException e) {  
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (largeBulkShardRequestSize * 1.5) + "B").build()
            )  
                IndexingPressureService.class,  
 * Copyright OpenSearch Contributors.
                }  
            } else {  
        assertAcked(
                .getShardIndexingPressure()  
