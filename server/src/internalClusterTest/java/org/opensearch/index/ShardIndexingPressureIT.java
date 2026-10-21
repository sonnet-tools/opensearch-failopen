        );
            .next()
        assertTrue(response.hasFailures());
                .getShardIndexingPressure()
            } else {
    }
            assertEquals(0, primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
            .nodes()
                try {
    }
        String replicaName = primaryReplicaNodeNames.v2();
        assertAcked(
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
    protected int numberOfReplicas() {
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                );
            assertRejectedBulkResponse(bulkRequest, rejectedResponse);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            )
        int totalRequestSize = 0;
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "large");
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        String replicaName = primaryReplicaNodeNames.v2();
            final ThreadPool replicaThreadPoolSmallRequest = internalCluster().getInstance(ThreadPool.class, replicaName);
            }
            assertRejectedBulkResponse(largeBulkRequest, client(coordinatingOnlyNode).bulk(largeBulkRequest).actionGet());
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
                .getShardIndexingPressureTracker(shardId);
        for (int i = 0; i < 80; ++i) {
        String replicaName = primaryReplicaNodeNames.v2();
                .getShardIndexingPressureTracker(shardId);
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
        for (int i = 0; i < 10; ++i) {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                assertEquals(
        ensureGreen(INDEX_NAME + "large");
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
    @Override
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        }
    private Tuple<String, String> getPrimaryReplicaNodeNames(String indexName) {
            ShardId shardId = new ShardId(index, 0);
import org.opensearch.threadpool.ThreadPool;
            }
            assertEquals(i, item.getItemId());
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
        final BulkRequest bulkRequest = new BulkRequest();
            assertBusy(() -> {
                ShardIndexingPressureTracker replicaShardTrackerSmall = internalCluster().getInstance(
        IndicesStatsResponse response = client().admin().indices().prepareStats(indexName).get();
    }
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            public Settings onNodeStopped(String nodeName) {
                    shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
            totalRequestSize += request.ramBytesUsed();
                );
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(largeBulkRequest);
            prepareCreate(
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            .cluster()
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (largeBulkShardRequestSize * 1.5) + "B").build()
                    bulkShardRequestSize,
                    blockReplication.await();
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            bulkRequest.add(request);
                assertBusy(() -> {
import org.opensearch.action.bulk.BulkItemRequest;
                ShardIndexingPressureTracker primaryShardTrackerSmall = internalCluster().getInstance(
                INDEX_NAME + "small",
    @Override
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(largeBulkRequest);
                assertEquals(0, replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            }
import org.opensearch.common.collect.Tuple;
            );
            try (Releasable replicaReleaseSmallRequest = blockReplicas(replicaThreadPoolSmallRequest)) {
    }
            ShardId shardId = new ShardId(index, 0);
                    assertEquals(
                    if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "small")) {
        }
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        String replicaName = nodes.get(replicaId).getName();
            if (usePrimaryAsCoordinatingNode) {
            final ThreadPool replicaThreadPoolSmallRequest = internalCluster().getInstance(ThreadPool.class, replicaName);
            assertEquals(request.requests().get(i).opType(), item.getOpType());
                        primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
import org.opensearch.cluster.node.DiscoveryNodes;
        );
            .filter(ShardRouting::primary)
                } catch (InterruptedException e) {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
import java.util.stream.Stream;
                IndexingPressureService.class,
                assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
        String primaryName = primaryReplicaNodeNames.v1();
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                );
            if (latchBlockingReplicationSend.getCount() > 0) {
 */
import java.util.Arrays;
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertTrue(request.ramBytesUsed() > request.source().length());
            )
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            .values()
                bulkShardRequestSize,
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
                assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.cluster.metadata.IndexMetadata;
            Index index = indexService.getIndexSettings().getIndex();
                assertNoFailures(successFutureSmallRequest.actionGet());
                .getShardIndexingPressureTracker(shardId);
            ShardId shardId = new ShardId(index, 0);
                assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                    secondBulkShardRequestSize,
                shardId = null;
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
                assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
                coordinatingOnlyNode
            primaryTransportService.clearAllRules();
                .getShardIndexingPressureTracker(shardId);
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                .getShardIndexingPressure()
            largeBulkRequest.add(request);
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            }
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                ShardIndexingPressureTracker coordinatingShardTrackerSmall = internalCluster().getInstance(
import org.opensearch.common.UUIDs;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
            });
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final BulkRequest bulkRequest = new BulkRequest();
            assertNoFailures(successFuture.actionGet());
                } catch (InterruptedException e) {
        String replicaName = primaryReplicaNodeNames.v2();
            assertTrue(request.ramBytesUsed() > request.source().length());
                final ActionFuture<BulkResponse> successFutureSmallRequest = client(primaryName).bulk(smallBulkRequest);
        final BulkRequest smallBulkRequest = new BulkRequest();
                coordinatingOnlyNode
import org.opensearch.ExceptionsHelper;
            )
            assertTrue(item.isFailed());
                        smallBulkShardRequestSize,
public class ShardIndexingPressureIT extends OpenSearchIntegTestCase {
            assertBusy(
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
                assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            } else {
            );
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                    );
                assertEquals(
                );
            }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        }
            replicationSendPointReached.await();
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            final ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
                    bulkShardRequestSize,
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
                    largeBulkShardRequestSize,
            .findAny()
                assertEquals(
}
                .getShardIndexingPressureTracker(shardId);
    }
            replicaRelease.close();
            // Large request on a shard with already large occupancy is rejected
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        String replicaId = Stream.of(response.getShards())
                .getShardIndexingPressure()
            }
            .iterator()
                IndexingPressureService.class,
                assertEquals(0, coordinatingShardTrackerSmall.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            totalRequestSize += request.ramBytesUsed();
        }
            assertBusy(() -> {
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            assertEquals(request.requests().get(i).index(), item.getIndex());
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                    assertEquals(
                    shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
                .getShardIndexingPressureTracker(shardId);
    private void restartCluster(Settings settings) throws Exception {
                    coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                assertThat(
        for (int i = 0; i < 10; ++i) {
            BulkResponse responses = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
                    assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            prepareCreate(
                assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                assertEquals(0, primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                )
                INDEX_NAME,
        return 1;
import org.opensearch.action.bulk.BulkRequest;
            .prepareState()
                () -> assertThat(
                );
        String primaryName = primaryReplicaNodeNames.v1();
            prepareCreate(
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "large");
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                latchBlockingReplicationSend.countDown();
                assertEquals(
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        final CountDownLatch blockReplication = new CountDownLatch(1);
            assertBusy(
            final ActionFuture<BulkResponse> secondFuture;
                    }
            assertTrue(request.ramBytesUsed() > request.source().length());
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            Index index = indexService.getIndexSettings().getIndex();
                    largeBulkShardRequestSize,
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        try {
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            );
        final long largeBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
        );
            assertNoFailures(successFuture.actionGet());
            if (usePrimaryAsCoordinatingNode) {
                    );
import org.opensearch.transport.TransportService;
                coordinatingOnlyNode
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        }
import org.opensearch.common.settings.Settings;
            IndexRequest request = new IndexRequest(INDEX_NAME + "small").id(UUIDs.base64UUID())
        ensureGreen(INDEX_NAME);
        String primaryName = primaryReplicaNodeNames.v1();
                    replicaName
            } else if (randomBoolean()) {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
                .getShardIndexingPressureTracker(shardId);
            IndexRequest request = new IndexRequest(INDEX_NAME + "small").id(UUIDs.base64UUID())
        }
            successFuture.actionGet();
            connection.sendRequest(requestId, action, request, options);
                .getShardIndexingPressure()
                    IndexingPressureService.class,
                secondFuture = client(replicaName).bulk(secondBulkRequest);
                    assertEquals(
        }
        ensureGreen(INDEX_NAME + "small");
                assertEquals(0, primaryShardTrackerSmall.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
            final BulkResponse rejectedResponse;
import org.opensearch.action.admin.indices.stats.ShardStats;
                rejectedResponse = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
        int totalRequestSize = 0;
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
            }
import org.opensearch.core.rest.RestStatus;
    protected Settings nodeSettings(int nodeOrdinal) {
                assertEquals(
        for (int i = 0; i < response.getItems().length; i++) {
            );
                    assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                .getShardIndexingPressure()
                });
            totalRequestSize += request.ramBytesUsed();
                        smallBulkShardRequestSize,
            .currentNodeId();
                        shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
                assertEquals(
    public void testShardIndexingPressureTrackingDuringBulkWrites() throws Exception {
                ShardIndexingPressureTracker primaryShardTrackerSmall = internalCluster().getInstance(
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
    }
        }
                        coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            }
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
import static org.hamcrest.Matchers.equalTo;
                coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            // Poll for the second request to reach the primary (does not matter which node is coordinator)
                bulkShardRequestSize,
import org.opensearch.test.transport.MockTransportService;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
            .map(ShardStats::getShardRouting)
                INDEX_NAME + "small",
                    coordinatingOnlyNode
            if (blockReplication.getCount() > 0) {
                IndexingPressureService.class,
        int totalRequestSize = 0;
                    largeBulkShardRequestSize,
import org.opensearch.common.lease.Releasable;
import static org.hamcrest.Matchers.instanceOf;
            } else {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                );
                assertBusy(() -> {
                    coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
    private Releasable blockReplicas(ThreadPool threadPool) {
        ensureGreen(INDEX_NAME + "small");
            .currentNodeId();
 * Copyright OpenSearch Contributors.
            assertEquals(0, primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                        smallBulkShardRequestSize,
                IndexingPressureService.class,
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME + "large").id(UUIDs.base64UUID())
            replicaRelease.close();
                INDEX_NAME + "large",
            // Try sending a small request now instead which should succeed one the new shard with less occupancy
        }
                assertEquals(
                    coordinatingOnlyNode
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                replicaReleaseSmallRequest.close();
                    );
        int totalRequestSize = 0;
        );
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        for (int i = 0; i < 80; ++i) {
                shardId = null;
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        }
            .get()
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
    protected int numberOfShards() {
        }
        String primaryId = Stream.of(response.getShards())
            assertEquals(0, coordinatingShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
            if (randomBoolean()) {
                );
    public void testWritesRejectedFairnessWithMultiplePrimaryShardsDueToNodeLevelLimitBreach() throws Exception {
                    replicaName
        int totalRequestSize = 0;
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        String primaryName = primaryReplicaNodeNames.v1();
        assertAcked(
        ensureGreen(INDEX_NAME);
            replicaRelease.close();
        );
            replicaRelease.close();
        totalRequestSize = 0;
import org.opensearch.action.bulk.BulkItemResponse;
                for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
                    largeBulkShardRequestSize,
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            }
                    throw new IllegalStateException(e);
            if (replicationSendPointReached.getCount() > 0) {
            assertNoFailures(successFuture.actionGet());
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();
    public static final Settings settings = Settings.builder()
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
import org.opensearch.action.bulk.BulkShardRequest;
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
            assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
                    IndexingPressureService.class,
import org.opensearch.common.action.ActionFuture;
        for (int i = 0; i < threads; ++i) {
    }
                + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            assertEquals(1, primaryShardTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
                final ActionFuture<BulkResponse> successFutureSmallRequest = client(coordinatingOnlyNode).bulk(smallBulkRequest);
            @Override
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
                .source(Collections.singletonMap("key", randomAlphaOfLength(10)));
            IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
            .getState()
                    primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
            replicaRelease.close();
            assertRejectedBulkResponse(largeBulkRequest, responses);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            assertThat(primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes(), equalTo(bulkShardRequestSize));
        final CountDownLatch pointReached = new CountDownLatch(threads);
    private static void assertRejectedBulkResponse(BulkRequest request, BulkResponse response) {
/*
        for (int i = 0; i < 80; ++i) {
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        ensureGreen(INDEX_NAME + "large");
            smallBulkRequest.add(request);
            assertThat(ExceptionsHelper.unwrapCause(item.getFailure().getCause()), instanceOf(OpenSearchRejectedExecutionException.class));
import org.opensearch.action.bulk.TransportShardBulkAction;
                .getShardIndexingPressure()
        String replicaName = primaryReplicaNodeNames.v2();
                primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
            boolean usePrimaryAsCoordinatingNode = randomBoolean();
import org.opensearch.cluster.routing.ShardRouting;
                    replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()
                assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        final long smallBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 10)
                );
        assertAcked(
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
import org.opensearch.core.index.shard.ShardId;
            }
            .filter(sr -> sr.primary() == false)
        .build();
            .get()
    }
                    IndexingPressureService.class,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            prepareCreate(
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
import java.util.concurrent.CountDownLatch;
            smallBulkRequest.add(request);
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
 * SPDX-License-Identifier: Apache-2.0
                .getShardIndexingPressure()
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                ShardIndexingPressureTracker replicaShardTrackerSmall = internalCluster().getInstance(
            });
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                    replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    throw new IllegalStateException(e);
        String primaryName = nodes.get(primaryId).getName();
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            assertEquals(
                        smallBulkShardRequestSize,
                    assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
    }
        }
                INDEX_NAME,
            );
                }
            assertTrue(request.ramBytesUsed() > request.source().length());
                );
        restartCluster(
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
    }
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            latchBlockingReplicationSend.countDown();
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
                assertEquals(0, primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
                    IndexingPressureService.class,
            // Try sending a small request now instead which should succeed one the new shard with less occupancy
                INDEX_NAME,
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            secondBulkRequest.add(request);
                }
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
                }
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertEquals(0, replicaShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                });
import java.util.Collection;
                    assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
            });
        });
            bulkRequest.add(request);
        for (int i = 0; i < 80; ++i) {
                equalTo(bulkShardRequestSize)
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (largeBulkShardRequestSize * 1.5) + "B").build()
            final BulkRequest secondBulkRequest = new BulkRequest();
            assertTrue(request.ramBytesUsed() > request.source().length());
        );
        final BulkRequest bulkRequest = new BulkRequest();
        };
    }
        return client().admin()
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            replicaRelease.close();
            totalRequestSize += request.ramBytesUsed();
            replicaRelease.close();
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                coordinatingOnlyNode
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        restartCluster(
        } finally {
                assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                        replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
        final long smallBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 10)
    private String getCoordinatingOnlyNode() {
            assertEquals(1, primaryShardTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections());
            assertThat(
        ensureGreen(INDEX_NAME);
            }
            prepareCreate(
                replicationSendPointReached.countDown();
                    primaryName
            ShardId shardId = null;
                }
            assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
        return () -> {
        return new Tuple<>(primaryName, replicaName);
                    replicationSendPointReached.countDown();
            )
                ShardIndexingPressureTracker coordinatingShardTrackerSmall = internalCluster().getInstance(
        });
            totalRequestSize += request.ramBytesUsed();
                assertEquals(0, coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            final long secondBulkShardRequestSize = request.ramBytesUsed() + RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class)
                coordinatingOnlyNode
                    IndexingPressureService.class,
        final BulkRequest largeBulkRequest = new BulkRequest();
                for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {
                blockReplication.countDown();
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                coordinatingShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                    replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
            ShardId shardId = null;
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                    latchBlockingReplicationSend.await();
            )
                    assertEquals(
            .get()
            assertTrue(request.ramBytesUsed() > request.source().length());
        assertEquals(RestStatus.OK, response.status());
                INDEX_NAME + "large",
                try {
            secondFuture.actionGet();
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                        smallBulkShardRequestSize,
                .getShardIndexingPressure()
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();
        totalRequestSize = 0;
                    secondBulkShardRequestSize,
    }
                assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            .getCoordinatingOnlyNodes()
                assertEquals(0, coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                replicaReleaseSmallRequest.close();
                .getShardIndexingPressureTracker(shardId);
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
    public void testWritesRejectedForSingleCoordinatingShardDueToNodeLevelLimitBreach() throws Exception {
            try (Releasable replicaReleaseSmallRequest = blockReplicas(replicaThreadPoolSmallRequest)) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
            Index index = indexService.getIndexSettings().getIndex();
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
            assertRejectedBulkResponse(bulkRequest, responses);
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
            .map(ShardStats::getShardRouting)
            totalRequestSize += request.ramBytesUsed();
                assertEquals(0, replicaShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
        );
            BulkResponse responses = client(coordinatingOnlyNode).bulk(largeBulkRequest).actionGet();
                    }
        assertAcked(
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                    equalTo(bulkShardRequestSize + secondBulkShardRequestSize)
                () -> assertThat(
                        primaryShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
                assertEquals(
                rejectedResponse = client(primaryName).bulk(bulkRequest).actionGet();
            .getName();
        for (int i = 0; i < 80; ++i) {
            prepareCreate(
    }
                assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                        shardId = new ShardId(indexService.getIndexSettings().getIndex(), 0);
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                    assertEquals(
                bulkShardRequestSize,
                rejectedResponse = client(replicaName).bulk(bulkRequest).actionGet();
                );
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertEquals(0, coordinatingShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
        try (Releasable replicaRelease = blockReplicas(replicaThreadPool)) {
            for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {
            for (IndexService indexService : internalCluster().getInstance(IndicesService.class, primaryName)) {
                );
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertBusy(() -> {
                .source(Collections.singletonMap("key", randomAlphaOfLength(10)));
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
import java.util.Collections;
                assertEquals(
            assertTrue(request.ramBytesUsed() > request.source().length());
        String primaryName = primaryReplicaNodeNames.v1();
    public void testWritesRejectedForSinglePrimaryShardDueToNodeLevelLimitBreach() throws Exception {
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
            });
                    );
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);
                );
import org.opensearch.test.InternalTestCluster;
import org.opensearch.core.index.Index;
import org.opensearch.plugins.Plugin;
                    if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "small")) {
import org.opensearch.indices.IndicesService;
            assertEquals(0, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        return 1;
            }
                    largeBulkShardRequestSize,
                    assertEquals(0, coordinatingShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                assertEquals(0, coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                .getShardIndexingPressure()
        );
                )
                        replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes()
                        coordinatingShardTrackerSmall.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes()
            final ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                    secondBulkShardRequestSize,
            assertEquals(request.requests().get(i).id(), item.getId());
            assertBusy(() -> {
            assertEquals(0, replicaShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
                    primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes(),
                assertEquals(
            largeBulkRequest.add(request);
            bulkRequest.add(request);
        assertAcked(
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                }
                    );
            assertEquals(0, primaryShardTracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(
            assertEquals(0, coordinatingShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
    @Override
                    IndexingPressureService.class,
                secondFuture = client(primaryName).bulk(secondBulkRequest);
    public static final String INDEX_NAME = "test_index";
                .getShardIndexingPressureTracker(shardId);
                }
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            assertEquals(
import org.opensearch.test.InternalSettingsPlugin;
        restartCluster(
                assertEquals(
                if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "large")) {
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        }
    }
                        0,
                assertEquals(0, replicaShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        assertAcked(
        assertAcked(
        );
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            .findAny()
                ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            assertEquals(0, replicaShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes());
    @Override
            );
                .getShardIndexingPressureTracker(shardId);
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
package org.opensearch.index;
                    );
                    pointReached.countDown();
                if (indexService.getIndexSettings().getIndex().getName().equals(INDEX_NAME + "large")) {
                assertEquals(0, primaryShardTrackerSmall.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
        final BulkRequest smallBulkRequest = new BulkRequest();
                    primaryShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
            prepareCreate(
import org.apache.lucene.util.RamUsageEstimator;
                    primaryName
        final long largeBulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();
import org.opensearch.test.OpenSearchIntegTestCase;
        restartCluster(
            assertNoFailures(successFuture.actionGet());
            )
        final BulkRequest largeBulkRequest = new BulkRequest();
            IndexRequest request = new IndexRequest(INDEX_NAME + "large").id(UUIDs.base64UUID())
                IndexingPressureService.class,
                    assertEquals(
    public void testWritesRejectedFairnessWithMultipleCoordinatingShardsDueToNodeLevelLimitBreach() throws Exception {
            assertEquals(0, primaryShardTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes());
        );
                coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes()
        final ThreadPool replicaThreadPool = internalCluster().getInstance(ThreadPool.class, replicaName);
        }
                    bulkShardRequestSize,
            // Use the primary or the replica data node as the coordinating node this time
                .getShardIndexingPressure()
            ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                assertNoFailures(successFutureSmallRequest.actionGet());
            });
            Settings.builder().put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B").build()
            assertEquals(0, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes());
        assertEquals(request.numberOfActions(), response.getItems().length);
            )
            totalRequestSize += request.ramBytesUsed();
            BulkItemResponse item = response.getItems()[i];
