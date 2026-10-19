        if (randomBoolean) {
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        } else {
import org.opensearch.common.lease.Releasable;
            connection.sendRequest(requestId, action, request, options);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
                }
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        ShardId shardId = new ShardId(index, 0);
                    replicationSendPointReached.countDown();
        assertEquals(
import org.opensearch.plugins.Plugin;
        // New Increment factor
        } else {
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
            .findAny()
        assertEquals(2 * bulkRequest.ramBytesUsed() + bulkShardRequestSize, coordinatingNodeLimits.totalCoordinatingBytes.get());
        // Create a new index to send new request
import org.opensearch.action.bulk.BulkItemRequest;
                    .getThroughputDegradationLimitsBreachedRejections()
            assertEquals(
import org.opensearch.indices.IndicesService;
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
            thirdSuccessFuture = client(primaryName).bulk(bulkRequest);
                    throw new IllegalStateException(e);
                INDEX_NAME,
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            2,
                .getLastSuccessfulRequestLimitsBreachedRejections()
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        Settings settings = Settings.builder()
import org.opensearch.common.collect.Tuple;
            );
            BulkItemResponse item = response.getItems()[i];
        // Send the third request which will not get rejected; unlike previous time
        // Set the Node limit threshold above the request-size; for no rejection
        ShardIndexingPressure shardIndexingPressure = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        for (int i = 0; i < 80; ++i) {
                .getShardIndexingPressureTracker(shardId);
            );
    public void testShardIndexingPressureFeatureEnabledDisabledSetting() {
            assertEquals(
            totalRequestSize += request.ramBytesUsed();
        ensureGreen(INDEX_NAME);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        IndexingPressure coordinatingNodeLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
        final BulkResponse rejectedResponse;
        // Send first request which gets successful
        };
            )
        );
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
                    .getRejectionTracker()
        // Update the outstanding threshold setting to see no rejections
            .map(ShardStats::getShardRouting)
            .getShardIndexingPressure()
            Thread.sleep(10);
                try {
                    .getRejectionTracker()
        // Send couple of more requests which remains outstanding to increase time-stamp value
            totalRequestSize += request.ramBytesUsed();
        }
        // Disable the setting again for shard indexing pressure as true
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        }
        restartCluster(
        if (randomBoolean) {
                INDEX_NAME,
        String replicaName = primaryReplicaNodeNames.v2();
        // Send first request which gets successful to set the last successful time-stamp
        // Assert no tracking at shard level for indexing pressure since default setting is disabled
        // Update the indexing byte setting to a lower value
        restartCluster(settings);
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "10ms")
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            .filter(sr -> sr.primary() == false)
    private void restartCluster(Settings settings) throws Exception {
            prepareCreate(
                latchBlockingReplicationSend.countDown();
        updateSettingsRequest.persistentSettings(
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            .getShardIndexingPressure();
        );
        assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
        Index index = indexService.getIndexSettings().getIndex();
        assertEquals(
            assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(10000, coordinatingShardTracker.getPrimaryAndCoordinatingLimits());
import org.opensearch.test.InternalTestCluster;
                1,
        final BulkRequest bulkRequest = new BulkRequest();
        ensureGreen(INDEX_NAME);
        assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        // Verify No actual tracking being done
                .getRejectionTracker()
            ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
        assertBusy(
                    .getRejectionTracker()
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        );
            .findAny()
        successFuture.actionGet();
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
        updateSettingsRequest.persistentSettings(
import java.util.concurrent.TimeUnit;
    }
        IndexingPressure primaryNodeLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        }
        return new Tuple<>(primaryName, replicaName);
            assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            () -> assertEquals(
            assertRejectedBulkResponse(bulkRequest, client(primaryName).bulk(bulkRequest).actionGet());
        if (randomBoolean) {
            .build();
        return 1;
        } else if (randomBoolean()) {
            .getShardIndexingPressure()
        ensureGreen(INDEX_NAME);
        );
        }
            3,
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertNoFailures(secondSuccessFuture.actionGet());
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
        final BulkRequest bulkRequest = new BulkRequest();
            assertNoFailures(successFuture.actionGet());
        primaryReleasable = blockPrimary(primaryName);
        final BulkRequest bulkRequest = new BulkRequest();
            .getShardIndexingPressure();
        index = indexService.getIndexSettings().getIndex();
        // Send couple of requests which remains outstanding
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());
        assertEquals(2, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            assertEquals(i, item.getItemId());
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();
            .getShardIndexingPressureTracker(shardId);
    }
                INDEX_NAME,
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        });
            .map(ShardStats::getShardRouting)
            }
        assertNoFailures(successFuture.actionGet());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // Repeat the previous set of requests; to get an actual rejection again this time
        final CountDownLatch pointReached = new CountDownLatch(threads);
        assertAcked(
    }
        if (randomBoolean) {
        assertRejectedBulkResponse(bulkRequest, rejectedResponse);
        Index index = indexService.getIndexSettings().getIndex();
    }
                primaryShardTracker.getCoordinatingOperationTracker()
import org.opensearch.core.index.shard.ShardId;
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());
                .getShardIndexingPressureTracker(shardId);
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
        successFuture.actionGet();
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        // Verify no rejection with similar request pattern
        } else {
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
 * SPDX-License-Identifier: Apache-2.0
            );
                .build()
                coordinatingOnlyNode
            });
        assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            assertEquals(
        );
                INDEX_NAME,
    }
            assertNoFailures(successFuture.actionGet());
            bulkRequest.add(request);
    }
        restartCluster(settings);
                    blockReplication.await();
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            }
            )
        String replicaName = primaryReplicaNodeNames.v2();
            if (blockReplication.getCount() > 0) {
        int totalRequestSize = 0;
        );
        }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.test.OpenSearchIntegTestCase;
            assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
        IndexingPressure replicaNodeLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                coordinatingOnlyNode
    protected int numberOfShards() {
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        // Verify updated initial shard limits
                }
            .getShardIndexingPressure()
        return 1;
        // Any node receiving the request will end up rejecting request due to node level limit breached
        Settings settings = Settings.builder()
            totalRequestSize += request.ramBytesUsed();
            assertTrue(request.ramBytesUsed() > request.source().length());
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        if (randomBoolean) {
        final BulkRequest bulkRequest = new BulkRequest();
        ActionFuture<BulkResponse> thirdSuccessFuture;
        ensureGreen(INDEX_NAME);
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        // Verify initial shard limits
        latchBlockingReplicationSend.countDown();
    private Tuple<String, String> getPrimaryReplicaNodeNames(String indexName) {
        );
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        assertAcked(
            successFuture = client(primaryName).bulk(bulkRequest);
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
        }
            assertTrue(request.ramBytesUsed() > request.source().length());
        ShardId shardId = new ShardId(index, 0);
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 3.8) + "B")
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);
                    latchBlockingReplicationSend.await();
                1,
        assertEquals(1000, coordinatingShardTracker.getPrimaryAndCoordinatingLimits());
            .getShardIndexingPressureTracker(shardId);
        assertEquals(
        // Send a second request
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
                    .getRejectionTracker()
        secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        }
    }
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            coordinatingShardTracker.getCoordinatingOperationTracker()
        });
        String primaryName = primaryReplicaNodeNames.v1();
            .getShardIndexingPressureTracker(shardId);
            assertNoFailures(successFuture.actionGet());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
            bulkRequest.add(request);
        String replicaName = nodes.get(replicaId).getName();
            )
        IndicesStatsResponse response = client().admin().indices().prepareStats(indexName).get();
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        assertAcked(
            coordinatingShardTracker.getCoordinatingOperationTracker()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        }
        String primaryName = primaryReplicaNodeNames.v1();
            .getShardIndexingPressureTracker(shardId);
        Settings settings = Settings.builder()
            .currentNodeId();
            assertEquals(request.requests().get(i).opType(), item.getOpType());
        Index index = indexService.getIndexSettings().getIndex();
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    }
            secondSuccessFuture = client(primaryName).bulk(bulkRequest);
                    .getLastSuccessfulRequestLimitsBreachedRejections()
        assertNoFailures(secondSuccessFuture.actionGet());
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        String primaryName = primaryReplicaNodeNames.v1();
    @Override
        } else {
        String primaryName = nodes.get(primaryId).getName();
                INDEX_NAME,
            )
        coordinatingShardTracker = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            assertEquals(
                IndexingPressureService.class,
            .getCoordinatingOnlyNodes()
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();
        // This request breaches the threshold and hence will be rejected
        );
    @Override
        );
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();
            .getState()
        primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        for (int i = 0; i < 80; ++i) {
            Thread.sleep(10);
        // Send couple of requests which remains outstanding
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
import org.opensearch.common.settings.Settings;
            prepareCreate(
        restartCluster(
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
            IndexingPressureService.class,
import org.opensearch.common.SuppressForbidden;
    public void testShardIndexingPressureEnforcedEnabledDisabledSetting() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ActionFuture<BulkResponse> successFuture;
            );
        for (int i = 0; i < 80; ++i) {
            );
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        assertEquals(3 * bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());
import org.opensearch.core.index.Index;
        primaryReleasable = blockPrimary(primaryName);
        } else {
        ShardId shardId = new ShardId(index, 0);
            long lastSuccessfulRequestTimestamp = performanceTracker.getLastSuccessfulRequestTimestamp();
        double incrementFactor = 0.01d;
                .build()
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
        successFuture.actionGet();
            if (latchBlockingReplicationSend.getCount() > 0) {
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        if (randomBoolean) {
                1,
                .getShardIndexingPressure()
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());
                INDEX_NAME,
                .getLastSuccessfulRequestLimitsBreachedRejections()
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());
            )
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        } else {
        // Shadow mode rejection count breakup still updated
            IndexingPressureService.class,
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            )
        int totalRequestSize = 0;
import org.opensearch.action.bulk.BulkItemResponse;
        assertEquals(1000, primaryShardTracker.getPrimaryAndCoordinatingLimits());
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B")
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertNoFailures(successFuture.actionGet());
        String primaryName = primaryReplicaNodeNames.v1();
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
import java.util.Collections;
        assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
            );
    private String getCoordinatingOnlyNode() {
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());
        restartCluster(settings);
        return () -> {
import org.opensearch.cluster.routing.ShardRouting;
            assertNoFailures(client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
        indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
                primaryShardTracker.getCoordinatingOperationTracker()
import org.opensearch.common.action.ActionFuture;
            .build();
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 3.8) + "B")
            coordinatingShardTracker.getCoordinatingOperationTracker()
import org.opensearch.action.admin.indices.stats.ShardStats;
        if (randomBoolean) {
        assertAcked(
        );
            ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            .getShardIndexingPressure();
        assertEquals(2 * bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());
        );
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        }
            public Settings onNodeStopped(String nodeName) {
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
        final CountDownLatch blockReplication = new CountDownLatch(1);
                3,
            assertNoFailures(client(primaryName).bulk(bulkRequest).actionGet());
                IndexingPressureService.class,
        String primaryName = primaryReplicaNodeNames.v1();
                    .getLastSuccessfulRequestLimitsBreachedRejections()
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        updateSettingsRequest.persistentSettings(
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertTrue(request.ramBytesUsed() > request.source().length());
                    .getLastSuccessfulRequestLimitsBreachedRejections()
                IndexingPressureService.class,
            assertEquals(
            assertThat(ExceptionsHelper.unwrapCause(item.getFailure().getCause()), instanceOf(OpenSearchRejectedExecutionException.class));
        primaryReleasable.close();
    }
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());
            bulkRequest.add(request);
        // Delay to breach the success time stamp threshold
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
        }
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.2) + "B")
        assertEquals(bulkShardRequestSize, primaryShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes());
    }
        if (randomBoolean()) {
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        );
            )
            assertTrue(System.nanoTime() - lastSuccessfulRequestTimestamp > TimeUnit.MILLISECONDS.toNanos(10));
        Settings settings = Settings.builder()
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
    private static void waitForLastSuccessfulRequestTimeout(ShardIndexingPressureTracker tracker) throws Exception {
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        ShardIndexingPressure shardIndexingPressure = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            bulkRequest.add(request);
            )
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());
                INDEX_NAME + "new",
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
        long initialNodeLimit = 1000000;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
    protected int numberOfReplicas() {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());
        int totalRequestSize = 0;
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
}
import org.opensearch.transport.TransportService;
        }
            .getShardIndexingPressureTracker(shardId);
package org.opensearch.index;
            coordinatingShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes()
    }
    public void testShardIndexingPressureRequestSizeWindowSettingUpdate() throws Exception {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        });
        successFuture.actionGet();
        replicaRelease.close();
        );
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
            rejectedResponse = client(replicaName).bulk(bulkRequest).actionGet();
        assertNoFailures(secondSuccessFuture.actionGet());
import java.util.stream.Stream;
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        restartCluster(
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        }
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
            .getShardIndexingPressure();
        });
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            IndexingPressureService.class,
import org.opensearch.action.bulk.BulkRequest;
        secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                .getShardIndexingPressure()
        // Complete the outstanding requests
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
import java.util.Arrays;
    public static final String INDEX_NAME = "test_index";
        }
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // This request breaches the threshold and hence will be rejected
    }
            assertEquals(
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
    @Override
            secondSuccessFuture = client(primaryName).bulk(bulkRequest);
            .cluster()
        assertAcked(
            .get()
        ensureGreen(INDEX_NAME);
        successFuture.actionGet();
                coordinatingShardTracker.getCoordinatingOperationTracker()
            .prepareState()
            coordinatingOnlyNode
        ActionFuture<BulkResponse> thirdSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
    @Override
            successFuture = client(primaryName).bulk(bulkRequest);
            thirdSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
    private Releasable blockReplicas(ThreadPool threadPool) {
            bulkRequest.add(request);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            assertEquals(request.requests().get(i).index(), item.getIndex());
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
        assertNull(shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId));
            totalRequestSize += request.ramBytesUsed();
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        // First successful request
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();
            bulkShardRequestSize,
public class ShardIndexingPressureSettingsIT extends OpenSearchIntegTestCase {
            assertNoFailures(successFuture.actionGet());
        // Tracking done with no rejections
    public void testShardIndexingPressureLastSuccessfulSettingsUpdate() throws Exception {
 * Copyright OpenSearch Contributors.
            .getShardIndexingPressureTracker(shardId);
        assertAcked(
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
        assertAcked(
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        assertTrue(response.hasFailures());
        restartCluster(settings);
        for (int i = 0; i < 80; ++i) {
        assertEquals(bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());
        replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                INDEX_NAME,
            .filter(ShardRouting::primary)
        boolean randomBoolean = randomBoolean();
        // Enable the setting for shard indexing pressure as true
        int totalRequestSize = 0;
    public void testShardIndexingPressureEnforcedEnabledNoOpIfFeatureDisabled() throws Exception {
            prepareCreate(
            coordinatingOnlyNode
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        coordinatingOnlyNode = getCoordinatingOnlyNode();
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .getShardIndexingPressure()
            assertTrue(request.ramBytesUsed() > request.source().length());
        assertEquals(request.numberOfActions(), response.getItems().length);
                    throw new IllegalStateException(e);
            bulkRequest.add(request);
            waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
        }
        );
        primaryReleasable.close();
    }
        Index index = indexService.getIndexSettings().getIndex();
        assertNoFailures(successFuture.actionGet());
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());
        primaryReleasable.close();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        assertTrue(shardIndexingPressure.isShardIndexingPressureEnabled());
        assertNoFailures(successFuture.actionGet());
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
            waitForLastSuccessfulRequestTimeout(primaryShardTracker);
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
                    .getThroughputDegradationLimitsBreachedRejections()
        String primaryName = primaryReplicaNodeNames.v1();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        }
            connection.sendRequest(requestId, action, request, options);
            coordinatingOnlyNode
import org.apache.lucene.util.RamUsageEstimator;
        assertNoFailures(thirdSuccessFuture.actionGet());
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        Releasable primaryReleasable = blockPrimary(primaryName);
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            assertTrue(request.ramBytesUsed() > request.source().length());
        thirdSuccessFuture.actionGet();
        assertEquals(
                } catch (InterruptedException e) {
            rejectedResponse = client(primaryName).bulk(bulkRequest).actionGet();
            IndexingPressureService.class,
        assertEquals(bulkRequest.ramBytesUsed() + bulkShardRequestSize, coordinatingNodeLimits.totalCoordinatingBytes.get());
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
        successFuture.actionGet();
            totalRequestSize += request.ramBytesUsed();
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        assertEquals(1500, replicaShardTracker.getReplicaLimits());
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                primaryShardTracker.getCoordinatingOperationTracker()
        // Send first request which gets successful to set the last successful time-stamp
            assertNoFailures(successFuture.actionGet());
            secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertEquals(15000, replicaShardTracker.getReplicaLimits());
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        assertNoFailures(successFuture.actionGet());
        ShardId shardId = new ShardId(index, 0);
        );
        assertEquals(bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
        // No new actual rejection
import static org.hamcrest.Matchers.instanceOf;
            .next()
        );
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
            .getShardIndexingPressure()
                1,
                } catch (InterruptedException e) {
                    .getRejectionTracker()
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                blockReplication.countDown();
        assertBusy(() -> {
        for (DiscoveryNode nodes : client().admin().cluster().prepareState().get().getState().nodes()) {
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
import org.opensearch.cluster.node.DiscoveryNodes;
        assertNoFailures(successFuture.actionGet());
                coordinatingShardTracker.getCoordinatingOperationTracker()
            assertRejectedBulkResponse(bulkRequest, client(primaryName).bulk(bulkRequest).actionGet());
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertNoFailures(successFuture.actionGet());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        ensureGreen(INDEX_NAME);
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
            .nodes()
        if (randomBoolean) {
        // Verify no rejection with similar request pattern
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
                1,
            .getShardIndexingPressureTracker(shardId);
        final BulkRequest bulkRequest = new BulkRequest();
        }
        boolean randomBoolean = randomBoolean();
            coordinatingOnlyNode
    public static final Settings settings = Settings.builder()
        String replicaName = primaryReplicaNodeNames.v2();
            @Override
                .getShardIndexingPressureTracker(shardId);
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                .getRejectionTracker()
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
            .values()
            Settings.builder()
            .get()
        );
        assertEquals(bulkRequest.ramBytesUsed(), coordinatingNodeLimits.totalCoordinatingBytes.get());
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
import org.opensearch.test.InternalSettingsPlugin;
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        String replicaName = primaryReplicaNodeNames.v2();
/*
            assertTrue(request.ramBytesUsed() > request.source().length());
 */
        // Send couple of more requests which remains outstanding
                .getRejectionTracker()
    }
        Thread.sleep(3000);
                1,
    private static void assertRejectedBulkResponse(BulkRequest request, BulkResponse response) {
    public void testNodeAttributeSetForShardIndexingPressure() throws Exception {
import org.opensearch.action.bulk.TransportShardBulkAction;
        // new rejection added to the actual rejection count
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 0.5) + "B")
        String replicaId = Stream.of(response.getShards())
            .get()
            .getShardIndexingPressureTracker(shardId);
            waitForLastSuccessfulRequestTimeout(primaryShardTracker);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            assertEquals("true", nodes.getAttributes().get("shard_indexing_pressure_enabled"));
        assertNoFailures(secondSuccessFuture.actionGet());
            .iterator()
        );
            prepareCreate(
        updateSettingsRequest.persistentSettings(
        // Repeat the previous set of request patterns; but no actual rejection this time
        assertNoFailures(successFuture.actionGet());
        primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "new");
                .build()
            prepareCreate(
        assertEquals(
        } else {
        Index index = indexService.getIndexSettings().getIndex();
            bulkRequest.add(request);
            prepareCreate(
        assertEquals(2 * bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
                try {
            coordinatingShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes()
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            Settings.builder().put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 10)
        }
        ActionFuture<BulkResponse> successFuture;
        shardId = new ShardId(index, 0);
            successFuture = client(primaryName).bulk(bulkRequest);
                    throw new IllegalStateException(e);
            totalRequestSize += request.ramBytesUsed();
        updateSettingsRequest.persistentSettings(
            totalRequestSize += request.ramBytesUsed();
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
            rejectedResponse = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
import org.opensearch.action.bulk.BulkShardRequest;
        assertEquals(RestStatus.OK, response.status());
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                    .getLastSuccessfulRequestLimitsBreachedRejections()
            .getShardIndexingPressureTracker(shardId);
            .getShardIndexingPressure()
        for (int i = 0; i < 80; ++i) {
        int totalRequestSize = 0;
            .build();
        Index index = indexService.getIndexSettings().getIndex();
        // Update the setting for initial shard limit
        } else {
            prepareCreate(
import org.opensearch.action.index.IndexRequest;
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        final BulkRequest bulkRequest = new BulkRequest();
        ActionFuture<BulkResponse> secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        String primaryName = primaryReplicaNodeNames.v1();
            Settings.builder()
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                coordinatingShardTracker.getCoordinatingOperationTracker()
            }
import org.opensearch.ExceptionsHelper;
import org.opensearch.action.bulk.BulkResponse;
            .getName();
        };
        }
        );
                coordinatingShardTracker.getCoordinatingOperationTracker().getPerformanceTracker().getTotalOutstandingRequests()
        assertEquals(bulkShardRequestSize, primaryShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes());
            successFuture = client(primaryName).bulk(bulkRequest);
    }
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        assertNoFailures(successFuture.actionGet());
                try {
        ShardId shardId = new ShardId(index, 0);
            ShardIndexingPressureTracker.PerformanceTracker performanceTracker = tracker.getCoordinatingOperationTracker()
import java.util.Collection;
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());
            successFuture = client(primaryName).bulk(bulkRequest);
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
                    .getRejectionTracker()
    public void testShardIndexingPressureVerifyShardMinLimitSettingUpdate() throws Exception {
        updateSettingsRequest.persistentSettings(Settings.builder().put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 10));
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.cluster.node.DiscoveryNode;
            assertTrue(lastSuccessfulRequestTimestamp > 0);
            assertNoFailures(successFuture.actionGet());
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME + "new");
        final BulkRequest bulkRequest = new BulkRequest();
                coordinatingOnlyNode
        assertNoFailures(successFuture.actionGet());
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());
            .currentNodeId();
                    latchBlockingReplicationSend.await();
            .getShardIndexingPressure();
        // Send first request
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        );
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        assertNull(shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId));
                    pointReached.countDown();
        }
        ShardId shardId = new ShardId(index, 0);
        assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        int totalRequestSize = 0;
    private Releasable blockPrimary(String primaryName) {
            .getShardIndexingPressure()
import org.opensearch.threadpool.ThreadPool;
        for (int i = 0; i < response.getItems().length; i++) {
                INDEX_NAME,
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
        // Send one more requests which remains outstanding for delayed time
@SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/14331")
                .getPerformanceTracker();
        ActionFuture<BulkResponse> secondSuccessFuture;
        } else {
        primaryReleasable = blockPrimary(primaryName);
        // Update the outstanding threshold setting to see no rejections
        assertEquals(3 * bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
                }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.concurrent.CountDownLatch;
            )
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        for (int i = 0; i < threads; ++i) {
        Releasable primaryReleasable = blockPrimary(primaryName);
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
import org.opensearch.cluster.metadata.IndexMetadata;
        String primaryId = Stream.of(response.getShards())
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        replicaName = primaryReplicaNodeNames.v2();
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        // Disable the enforced mode by setting it to false
        );
            assertTrue(request.ramBytesUsed() > request.source().length());
                .getShardIndexingPressure()
        for (int i = 0; i < 80; ++i) {
            )
        // Enable the enforced mode again by setting it to true
            .getShardIndexingPressure()
    protected Settings nodeSettings(int nodeOrdinal) {
    }
        assertAcked(
        // Send a third request which should not be tracked since feature is disabled again
        assertNoFailures(secondSuccessFuture.actionGet());
            prepareCreate(
            }
                } catch (InterruptedException e) {
        );
        // This request breaches the threshold and hence will be rejected
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        ShardId shardId = new ShardId(index, 0);
        primaryReleasable.close();
        int totalRequestSize = 0;
        ensureGreen(INDEX_NAME);
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "10ms")
        // Set the Node limit threshold above the request-size; for no rejection
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertEquals(10000, primaryShardTracker.getPrimaryAndCoordinatingLimits());
        // This request breaches the threshold and hence will be rejected
            1,
    }
        return () -> {
        primaryReleasable.close();
            assertTrue(item.isFailed());
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) initialNodeLimit + "B")
        primaryName = primaryReplicaNodeNames.v1();
                .getLastSuccessfulRequestLimitsBreachedRejections()
        } else {
        Index index = indexService.getIndexSettings().getIndex();
            }
        .build();
            assertEquals(2, performanceTracker.getTotalOutstandingRequests());
import org.opensearch.common.UUIDs;
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        }
        );
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        return client().admin()
            assertEquals(request.requests().get(i).id(), item.getId());
            Settings.builder()
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
            .build();
            prepareCreate(
            .getShardIndexingPressure()
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_MIN_LIMIT.getKey(), incrementFactor)
            bulkShardRequestSize,
    public void testShardIndexingPressureNodeLimitUpdateSetting() throws Exception {
        assertNoFailures(successFuture.actionGet());
        );
        for (int i = 0; i < 80; ++i) {
        updateSettingsRequest.persistentSettings(
        if (randomBoolean) {
            successFuture = client(primaryName).bulk(bulkRequest);
        assertAcked(
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
