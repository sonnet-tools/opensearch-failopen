        ActionFuture<BulkResponse> thirdSuccessFuture;
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
            .build();  
        String replicaId = Stream.of(response.getShards())  
        );  
        return 1;  
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        // Send first request which gets successful to set the last successful time-stamp  
            .get()
        });
                    .getRejectionTracker()  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();  
            coordinatingOnlyNode  
        );  
            coordinatingShardTracker.getCoordinatingOperationTracker()
            }  
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertNoFailures(successFuture.actionGet());  
            )
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
                    .getThroughputDegradationLimitsBreachedRejections()
        // This request breaches the threshold and hence will be rejected
        for (int i = 0; i < 80; ++i) {  
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        // Tracking done with no rejections  
        replicaName = primaryReplicaNodeNames.v2();  
            assertThat(ExceptionsHelper.unwrapCause(item.getFailure().getCause()), instanceOf(OpenSearchRejectedExecutionException.class));
        ensureGreen(INDEX_NAME);  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 3.8) + "B")  
            bulkRequest.add(request);
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        if (randomBoolean) {  
            successFuture = client(primaryName).bulk(bulkRequest);
            .getShardIndexingPressureTracker(shardId);
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        .build();
        restartCluster(settings);  
    }  
                    .getLastSuccessfulRequestLimitsBreachedRejections()
        if (randomBoolean()) {
        );
        assertEquals(  
            successFuture = client(primaryName).bulk(bulkRequest);
            assertNoFailures(client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());  
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        }
            )  
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
    @Override
import org.apache.lucene.util.RamUsageEstimator;
            waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);  
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
    private Releasable blockReplicas(ThreadPool threadPool) {  
            secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
            .getState()
        for (int i = 0; i < response.getItems().length; i++) {  
            .cluster()
            bulkRequest.add(request);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
import static org.hamcrest.Matchers.instanceOf;  
        } else {
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .getShardIndexingPressureTracker(shardId);  
                1,
        );
                coordinatingShardTracker.getCoordinatingOperationTracker()  
            Settings.builder()
            totalRequestSize += request.ramBytesUsed();
                return Settings.builder().put(unboundedWriteQueue).put(settings).build();  
            prepareCreate(  
        for (int i = 0; i < 80; ++i) {
            prepareCreate(
        primaryName = primaryReplicaNodeNames.v1();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);  
            prepareCreate(  
        }  
            assertNoFailures(successFuture.actionGet());  
            ActionFuture<BulkResponse> successFuture = client(primaryName).bulk(bulkRequest);
            successFuture = client(primaryName).bulk(bulkRequest);
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            BulkItemResponse item = response.getItems()[i];
        assertAcked(
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        } else {
        );
        Index index = indexService.getIndexSettings().getIndex();
        return 1;
    public void testShardIndexingPressureNodeLimitUpdateSetting() throws Exception {
        for (int i = 0; i < 80; ++i) {  
        }
            rejectedResponse = client(coordinatingOnlyNode).bulk(bulkRequest).actionGet();
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)  
            }
            .getShardIndexingPressure();
        } else {
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        );
    public void testShardIndexingPressureRequestSizeWindowSettingUpdate() throws Exception {
import org.opensearch.test.InternalTestCluster;  
            coordinatingShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes()
        }
        assertNoFailures(secondSuccessFuture.actionGet());
        assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());  
        final BulkRequest bulkRequest = new BulkRequest();
        );
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
import org.opensearch.common.settings.Settings;
        }
        IndexingPressure primaryNodeLimits = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        final BulkRequest bulkRequest = new BulkRequest();  
        // Create a new index to send new request
                    latchBlockingReplicationSend.await();
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.5) + "B")
        );
        );  
        final CountDownLatch pointReached = new CountDownLatch(threads);  
            );
    private String getCoordinatingOnlyNode() {  
            .getShardIndexingPressureTracker(shardId);  
                1,
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        String replicaName = primaryReplicaNodeNames.v2();
    @Override
        successFuture.actionGet();  
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        // Verify initial shard limits
        assertNoFailures(successFuture.actionGet());
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());
        restartCluster(settings);
        final int threads = threadPool.info(ThreadPool.Names.WRITE).getMax();
        assertNoFailures(successFuture.actionGet());
        for (DiscoveryNode nodes : client().admin().cluster().prepareState().get().getState().nodes()) {  
}
import org.opensearch.action.admin.indices.stats.ShardStats;
        primaryReleasable.close();  
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        // Send couple of more requests which remains outstanding to increase time-stamp value  
            bulkShardRequestSize,  
                1,
            bulkRequest.add(request);
        assertNoFailures(successFuture.actionGet());
                IndexingPressureService.class,  
            .getShardIndexingPressureTracker(shardId);  
        for (int i = 0; i < 80; ++i) {
        secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                coordinatingOnlyNode
                    blockReplication.await();
        final BulkRequest bulkRequest = new BulkRequest();  
            totalRequestSize += request.ramBytesUsed();
    protected Settings nodeSettings(int nodeOrdinal) {
        assertBusy(() -> {
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "10ms")
        primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME + "new");
 * SPDX-License-Identifier: Apache-2.0
                primaryShardTracker.getCoordinatingOperationTracker()
        // Send one more requests which remains outstanding for delayed time
            .getShardIndexingPressure();  
            if (blockReplication.getCount() > 0) {
import org.opensearch.core.index.Index;  
                try {
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
            threadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
            waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
        Index index = indexService.getIndexSettings().getIndex();  
            .getShardIndexingPressure()
        assertEquals(15000, replicaShardTracker.getReplicaLimits());
            assertNoFailures(client(primaryName).bulk(bulkRequest).actionGet());
            .findAny()  
                    latchBlockingReplicationSend.await();
            assertTrue(lastSuccessfulRequestTimestamp > 0);  
        final MockTransportService replicaTransportService = (MockTransportService) replicaService;
import java.util.stream.Stream;
    }  
        // Update the indexing byte setting to a lower value  
    public static final String INDEX_NAME = "test_index";  
            assertNoFailures(successFuture.actionGet());
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
        updateSettingsRequest.persistentSettings(
        assertEquals(10000, primaryShardTracker.getPrimaryAndCoordinatingLimits());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertNoFailures(successFuture.actionGet());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            assertTrue(request.ramBytesUsed() > request.source().length());
        }  
import org.opensearch.transport.TransportService;
                INDEX_NAME,
        // Disable the setting again for shard indexing pressure as true  
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);  
            )
        primaryReleasable.close();  
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import java.util.Collections;
        coordinatingOnlyNode = getCoordinatingOnlyNode();
    private static void waitForLastSuccessfulRequestTimeout(ShardIndexingPressureTracker tracker) throws Exception {  
            secondSuccessFuture = client(primaryName).bulk(bulkRequest);  
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        assertEquals(2 * bulkRequest.ramBytesUsed() + bulkShardRequestSize, coordinatingNodeLimits.totalCoordinatingBytes.get());  
        String primaryName = primaryReplicaNodeNames.v1();
        assertAcked(
        ActionFuture<BulkResponse> successFuture;
        );
        successFuture.actionGet();
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)  
        );
        for (int i = 0; i < 80; ++i) {
                .getShardIndexingPressure()  
            totalRequestSize += request.ramBytesUsed();
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertNull(shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId));
        );
        primaryReleasable.close();  
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();  
            );  
        final BulkResponse rejectedResponse;  
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        if (randomBoolean) {
            assertEquals(request.requests().get(i).index(), item.getIndex());  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
    }  
        primaryReleasable = blockPrimary(primaryName);
        } else {
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            coordinatingOnlyNode
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
 * Copyright OpenSearch Contributors.
            bulkRequest.add(request);
        assertBusy(
        int totalRequestSize = 0;
            .build();
            .currentNodeId();
        ensureGreen(INDEX_NAME);
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        if (randomBoolean) {
            rejectedResponse = client(primaryName).bulk(bulkRequest).actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                .build()
        updateSettingsRequest.persistentSettings(Settings.builder().put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 10));
        } else if (randomBoolean()) {  
import org.opensearch.indices.IndicesService;  
            prepareCreate(
        assertEquals(3 * bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());
        assertAcked(  
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
                coordinatingOnlyNode  
            assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());  
        if (randomBoolean) {
        Thread.sleep(3000);  
        );
                .getRejectionTracker()  
        final Releasable replicaRelease = blockReplicas(replicaThreadPool);
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());  
                    .getThroughputDegradationLimitsBreachedRejections()
                    throw new IllegalStateException(e);  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        return new Tuple<>(primaryName, replicaName);  
import java.util.Collection;
        assertEquals(1000, primaryShardTracker.getPrimaryAndCoordinatingLimits());
        assertNoFailures(secondSuccessFuture.actionGet());
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        final CountDownLatch blockReplication = new CountDownLatch(1);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
            .getShardIndexingPressure()  
            successFuture = client(primaryName).bulk(bulkRequest);  
            assertEquals(request.requests().get(i).id(), item.getId());
            assertNoFailures(successFuture.actionGet());
        assertEquals(1500, replicaShardTracker.getReplicaLimits());
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                    pointReached.countDown();
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());
        Settings settings = Settings.builder()
        latchBlockingReplicationSend.countDown();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        );
                IndexingPressureService.class,  
        ActionFuture<BulkResponse> thirdSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        // Send a third request which should not be tracked since feature is disabled again
            );
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)  
        String primaryName = primaryReplicaNodeNames.v1();
        assertEquals(
                    .getLastSuccessfulRequestLimitsBreachedRejections()
        TransportService primaryService = internalCluster().getInstance(TransportService.class, primaryName);
            .getShardIndexingPressure()
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        // Assert no tracking at shard level for indexing pressure since default setting is disabled  
import org.opensearch.cluster.node.DiscoveryNode;
    private Releasable blockPrimary(String primaryName) {
            Thread.sleep(10);
                    .getRejectionTracker()
        ensureGreen(INDEX_NAME);
            bulkRequest.add(request);
                .build()
                coordinatingShardTracker.getCoordinatingOperationTracker()
        } else {
        }
                primaryShardTracker.getCoordinatingOperationTracker()
            waitForLastSuccessfulRequestTimeout(primaryShardTracker);
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());
        ShardId shardId = new ShardId(index, 0);
        // This request breaches the threshold and hence will be rejected
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)  
        for (int i = 0; i < threads; ++i) {
                primaryShardTracker.getCoordinatingOperationTracker()  
        } else {
    }  
                .getRejectionTracker()
            .map(ShardStats::getShardRouting)
            assertEquals(  
        );
        updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            assertTrue(request.ramBytesUsed() > request.source().length());  
            coordinatingOnlyNode
            totalRequestSize += request.ramBytesUsed();  
    @Override  
        // Update the outstanding threshold setting to see no rejections
                blockReplication.countDown();
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) initialNodeLimit + "B")  
                    .getLastSuccessfulRequestLimitsBreachedRejections()
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_MIN_LIMIT.getKey(), incrementFactor)  
        final BulkRequest bulkRequest = new BulkRequest();  
        TransportService replicaService = internalCluster().getInstance(TransportService.class, replicaName);  
                INDEX_NAME,
        replicaRelease.close();
            .build();  
            assertTrue(item.isFailed());  
import org.opensearch.cluster.routing.ShardRouting;
        secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            IndexingPressureService.class,
        restartCluster(settings);  
            assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
            bulkRequest.add(request);
                .getPerformanceTracker();  
        int totalRequestSize = 0;
        shardId = new ShardId(index, 0);
            totalRequestSize += request.ramBytesUsed();  
            rejectedResponse = client(replicaName).bulk(bulkRequest).actionGet();  
        Settings settings = Settings.builder()  
            3,
                1,
        successFuture.actionGet();  
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            2,  
        for (int i = 0; i < 80; ++i) {
        int totalRequestSize = 0;
        ShardId shardId = new ShardId(index, 0);
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
                INDEX_NAME,
        // Send couple of requests which remains outstanding
        assertEquals(0, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        assertNoFailures(successFuture.actionGet());  
        restartCluster(settings);
        // new rejection added to the actual rejection count
            coordinatingShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes()
        updateSettingsRequest.persistentSettings(
        Releasable primaryReleasable = blockPrimary(primaryName);
import org.opensearch.action.bulk.BulkShardRequest;
        // Send a second request
        );
            .getName();
        assertNoFailures(successFuture.actionGet());
            assertTrue(request.ramBytesUsed() > request.source().length());  
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        final BulkRequest bulkRequest = new BulkRequest();  
import org.opensearch.common.action.ActionFuture;
        assertEquals(RestStatus.OK, response.status());  
                INDEX_NAME + "new",
        primaryReleasable = blockPrimary(primaryName);  
        restartCluster(
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {  
            IndexingPressureService.class,  
        // Verify updated initial shard limits
import org.opensearch.core.index.shard.ShardId;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // Repeat the previous set of request patterns; but no actual rejection this time
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
    }
            }
                .getLastSuccessfulRequestLimitsBreachedRejections()  
        assertEquals(bulkShardRequestSize, primaryShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes());
    public void testShardIndexingPressureFeatureEnabledDisabledSetting() {
            ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
                INDEX_NAME,
        // Verify No actual tracking being done
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 1)
        };
/*  
            .getShardIndexingPressureTracker(shardId);
        }
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
        String coordinatingOnlyNode = getCoordinatingOnlyNode();  
    }  
        // Send first request which gets successful
            bulkShardRequestSize,
        assertRejectedBulkResponse(bulkRequest, rejectedResponse);
            IndexingPressureService.class,
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            .getShardIndexingPressure();  
                    throw new IllegalStateException(e);  
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
                .getShardIndexingPressure()
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
            .build();
        }
        assertNoFailures(secondSuccessFuture.actionGet());
            assertEquals(2, performanceTracker.getTotalOutstandingRequests());
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        ShardId shardId = new ShardId(index, 0);
import org.opensearch.action.bulk.BulkItemRequest;  
            public Settings onNodeStopped(String nodeName) {
        assertNoFailures(successFuture.actionGet());
            assertNoFailures(successFuture.actionGet());  
                    throw new IllegalStateException(e);
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();  
        restartCluster(  
        } else {  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
public class ShardIndexingPressureSettingsIT extends OpenSearchIntegTestCase {
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.core.rest.RestStatus;
        if (randomBoolean) {  
            assertTrue(request.ramBytesUsed() > request.source().length());  
    }  
            assertRejectedBulkResponse(bulkRequest, client(primaryName).bulk(bulkRequest).actionGet());
        ShardId shardId = new ShardId(index, 0);
        String replicaName = nodes.get(replicaId).getName();
    }  
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            }  
        }
        int totalRequestSize = 0;
import java.util.concurrent.TimeUnit;
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        // This request breaches the threshold and hence will be rejected  
import org.opensearch.plugins.Plugin;
        ensureGreen(INDEX_NAME);
            .currentNodeId();
        assertNoFailures(successFuture.actionGet());
        assertEquals(1000, coordinatingShardTracker.getPrimaryAndCoordinatingLimits());  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(unboundedWriteQueue).put(settings).build();
            secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
            .getShardIndexingPressure()
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            )
        IndexingPressure replicaNodeLimits = internalCluster().getInstance(IndexingPressureService.class, replicaName)
        return () -> {  
        }  
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {  
            coordinatingShardTracker.getCoordinatingOperationTracker()  
        assertRejectedBulkResponse(bulkRequest, client(coordinatingOnlyNode).bulk(bulkRequest).actionGet());
            .getShardIndexingPressure();
                } catch (InterruptedException e) {  
        );
        String primaryName = primaryReplicaNodeNames.v1();  
                3,  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        } else {
        );
        // Send couple of more requests which remains outstanding
        ActionFuture<BulkResponse> secondSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            prepareCreate(
            );
        }
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            )
            thirdSuccessFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        Index index = indexService.getIndexSettings().getIndex();  
        String replicaName = primaryReplicaNodeNames.v2();  
            Settings.builder()
            .get()
                    replicationSendPointReached.countDown();  
            )  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        successFuture.actionGet();
        // Send the third request which will not get rejected; unlike previous time
                INDEX_NAME,
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
    public void testNodeAttributeSetForShardIndexingPressure() throws Exception {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            IndexingPressureService.class,
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)  
            assertTrue(request.ramBytesUsed() > request.source().length());  
        assertEquals(bulkRequest.ramBytesUsed(), coordinatingNodeLimits.totalCoordinatingBytes.get());
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        ActionFuture<BulkResponse> successFuture;
        ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
import org.opensearch.test.InternalSettingsPlugin;
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 1.2) + "B")  
        final CountDownLatch replicationSendPointReached = new CountDownLatch(1);
        );  
import org.opensearch.action.index.IndexRequest;  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
            thirdSuccessFuture = client(primaryName).bulk(bulkRequest);
            .iterator()  
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        );
        ShardId shardId = new ShardId(index, 0);  
        // Set the Node limit threshold above the request-size; for no rejection  
                INDEX_NAME,
        assertEquals(2 * bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());  
        assertEquals(bulkShardRequestSize, primaryShardTracker.getCommonOperationTracker().getTotalCombinedCoordinatingAndPrimaryBytes());
        }
        String primaryName = primaryReplicaNodeNames.v1();
            .getShardIndexingPressure();
                1,  
        int totalRequestSize = 0;
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
    }  
        assertNoFailures(secondSuccessFuture.actionGet());
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
 */  
        restartCluster(
import org.opensearch.action.bulk.BulkRequest;
        IndicesStatsResponse response = client().admin().indices().prepareStats(indexName).get();
        Settings settings = Settings.builder()
                latchBlockingReplicationSend.countDown();
        }
                coordinatingShardTracker.getCoordinatingOperationTracker()
        DiscoveryNodes nodes = client().admin().cluster().prepareState().get().getState().nodes();  
        assertNull(shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId));
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)  
    }  
    }
import org.opensearch.threadpool.ThreadPool;  
            bulkRequest.add(request);
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            );  
    }  
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
        if (randomBoolean) {  
            assertEquals(
        ShardId shardId = new ShardId(index, 0);
        boolean randomBoolean = randomBoolean();
            Settings.builder()
        });
        assertAcked(
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        Index index = indexService.getIndexSettings().getIndex();
            .nodes()  
                } catch (InterruptedException e) {
import org.opensearch.test.transport.MockTransportService;
            );
        updateSettingsRequest.persistentSettings(  
        // Verify no rejection with similar request pattern
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
        assertNoFailures(secondSuccessFuture.actionGet());  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        String primaryId = Stream.of(response.getShards())  
@SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/14331")  
                1,
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);  
        assertEquals(request.numberOfActions(), response.getItems().length);
        assertAcked(
                    .getRejectionTracker()  
            prepareCreate(
        int totalRequestSize = 0;
        assertNoFailures(successFuture.actionGet());
            .getShardIndexingPressureTracker(shardId);
        assertEquals(2, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
    }
            )
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                coordinatingShardTracker.getCoordinatingOperationTracker().getPerformanceTracker().getTotalOutstandingRequests()
        assertEquals(bulkShardRequestSize, replicaShardTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes());
        );
        primaryReleasable.close();
            prepareCreate(
                    .getRejectionTracker()
        String primaryName = primaryReplicaNodeNames.v1();  
    }
        ensureGreen(INDEX_NAME);
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
        ensureGreen(INDEX_NAME);
            assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
            });  
                .getLastSuccessfulRequestLimitsBreachedRejections()
        final ThreadPool replicaThreadPool = replicaTransportService.getThreadPool();  
import org.opensearch.ExceptionsHelper;
import org.opensearch.action.bulk.BulkResponse;  
            assertEquals(
            successFuture = client(primaryName).bulk(bulkRequest);  
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
            @Override
            .getShardIndexingPressureTracker(shardId);
    }  
        ShardId shardId = new ShardId(index, 0);
        thirdSuccessFuture.actionGet();
        updateSettingsRequest.persistentSettings(
            .filter(ShardRouting::primary)
package org.opensearch.index;
import org.opensearch.common.collect.Tuple;
        Index index = indexService.getIndexSettings().getIndex();
                    .getLastSuccessfulRequestLimitsBreachedRejections()  
        final long bulkShardRequestSize = totalRequestSize + (RamUsageEstimator.shallowSizeOfInstance(BulkItemRequest.class) * 80)  
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            .getShardIndexingPressure()
        // First successful request  
            connection.sendRequest(requestId, action, request, options);  
        if (randomBoolean) {  
                .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 0.5) + "B")
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());
                coordinatingOnlyNode
            if (action.equals(TransportShardBulkAction.ACTION_NAME + "[r]")) {
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
        }
                .getRejectionTracker()
        ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), (long) (bulkShardRequestSize * 3.8) + "B")
    @Override  
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);
        assertTrue(response.hasFailures());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // Any node receiving the request will end up rejecting request due to node level limit breached
            ShardIndexingPressureTracker.PerformanceTracker performanceTracker = tracker.getCoordinatingOperationTracker()
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)  
        // Verify no rejection with similar request pattern
        ensureGreen(INDEX_NAME);  
            }
        assertAcked(  
                INDEX_NAME,
        String replicaName = primaryReplicaNodeNames.v2();
        primaryReleasable.close();
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());  
        ActionFuture<BulkResponse> secondSuccessFuture;
    }
            .findAny()  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();  
import org.opensearch.test.OpenSearchIntegTestCase;
            .get()
        assertEquals(1, coordinatingShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());  
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)  
            .getShardIndexingPressure()
        IndexingPressure coordinatingNodeLimits = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)  
        assertAcked(
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
                    .getRejectionTracker()  
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
            if (latchBlockingReplicationSend.getCount() > 0) {
            coordinatingShardTracker.getCoordinatingOperationTracker()
        indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();  
            successFuture = client(primaryName).bulk(bulkRequest);
        }
        } else {
            .getShardIndexingPressureTracker(shardId);  
        };
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
        assertAcked(  
        Index index = indexService.getIndexSettings().getIndex();  
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());  
        Index index = indexService.getIndexSettings().getIndex();  
            .map(ShardStats::getShardRouting)
        if (randomBoolean) {
    private Tuple<String, String> getPrimaryReplicaNodeNames(String indexName) {
        primaryReleasable = blockPrimary(primaryName);
            waitForLastSuccessfulRequestTimeout(primaryShardTracker);  
    protected int numberOfReplicas() {
        updateSettingsRequest.persistentSettings(
    private void restartCluster(Settings settings) throws Exception {
    private static void assertRejectedBulkResponse(BulkRequest request, BulkResponse response) {
        assertEquals(  
    public void testShardIndexingPressureEnforcedEnabledDisabledSetting() throws Exception {
                }
        // No new actual rejection
                } catch (InterruptedException e) {
        assertEquals(2 * bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
                    .getRejectionTracker()
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
            .getCoordinatingOnlyNodes()
        assertEquals(bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
        // Update the setting for initial shard limit  
            long lastSuccessfulRequestTimestamp = performanceTracker.getLastSuccessfulRequestTimestamp();
    public void testShardIndexingPressureVerifyShardMinLimitSettingUpdate() throws Exception {
import org.opensearch.action.bulk.BulkItemResponse;
        boolean randomBoolean = randomBoolean();  
        assertEquals(
        final BulkRequest bulkRequest = new BulkRequest();  
        // Complete the outstanding requests
        ensureGreen(INDEX_NAME);
        assertNoFailures(successFuture.actionGet());  
        } else {
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
            1,
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        assertAcked(  
            assertEquals(  
        assertNoFailures(successFuture.actionGet());
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "10ms")
        ShardIndexingPressure shardIndexingPressure = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            assertRejectedBulkResponse(bulkRequest, client(primaryName).bulk(bulkRequest).actionGet());  
        // Disable the enforced mode by setting it to false
            connection.sendRequest(requestId, action, request, options);  
            () -> assertEquals(
        // This request breaches the threshold and hence will be rejected
        return client().admin()
        assertEquals(bulkShardRequestSize, coordinatingShardTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes());  
            .getShardIndexingPressure()
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            )  
            assertEquals(1, primaryShardTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections());
        final CountDownLatch latchBlockingReplicationSend = new CountDownLatch(1);
        );  
        assertEquals(3 * bulkShardRequestSize, replicaNodeLimits.totalReplicaBytes.get());
        assertEquals(bulkRequest.ramBytesUsed() + bulkShardRequestSize, coordinatingNodeLimits.totalCoordinatingBytes.get());
        Settings settings = Settings.builder()  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        String primaryName = primaryReplicaNodeNames.v1();  
        });
            .getShardIndexingPressureTracker(shardId);  
        if (randomBoolean) {  
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
        }  
        successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        ensureGreen(INDEX_NAME + "new");
        assertEquals(bulkShardRequestSize, primaryShardTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes());  
        updateSettingsRequest.persistentSettings(  
        for (int i = 0; i < 80; ++i) {
        Tuple<String, String> primaryReplicaNodeNames = getPrimaryReplicaNodeNames(INDEX_NAME);
        double incrementFactor = 0.01d;
            assertTrue(request.ramBytesUsed() > request.source().length());
        successFuture.actionGet();  
        // Delay to breach the success time stamp threshold
                .getShardIndexingPressureTracker(shardId);
    public void testShardIndexingPressureEnforcedEnabledNoOpIfFeatureDisabled() throws Exception {  
                INDEX_NAME,  
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        String primaryName = primaryReplicaNodeNames.v1();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
                try {  
        // Update the outstanding threshold setting to see no rejections  
            prepareCreate(  
        );  
import org.opensearch.common.SuppressForbidden;
            assertTrue(System.nanoTime() - lastSuccessfulRequestTimestamp > TimeUnit.MILLISECONDS.toNanos(10));
        });
        coordinatingShardTracker = internalCluster().getInstance(IndexingPressureService.class, coordinatingOnlyNode)
    public void testShardIndexingPressureLastSuccessfulSettingsUpdate() throws Exception {
import org.opensearch.cluster.node.DiscoveryNodes;  
        }
            assertTrue(request.ramBytesUsed() > request.source().length());  
                try {  
        // Enable the enforced mode again by setting it to true
            coordinatingOnlyNode  
        // Send couple of requests which remains outstanding
        ShardIndexingPressureTracker replicaShardTracker = internalCluster().getInstance(IndexingPressureService.class, replicaName)
            Settings.builder().put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 10)
            assertEquals(
        IndexService indexService = internalCluster().getInstance(IndicesService.class, primaryName).iterator().next();
            )  
            .getShardIndexingPressure()
        return () -> {  
import org.opensearch.common.lease.Releasable;  
        assertFalse(shardIndexingPressure.isShardIndexingPressureEnabled());  
        ActionFuture<BulkResponse> successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
            assertEquals("true", nodes.getAttributes().get("shard_indexing_pressure_enabled"));
            assertNoFailures(successFuture.actionGet());  
        Releasable primaryReleasable = blockPrimary(primaryName);  
            Thread.sleep(10);
            assertEquals(request.requests().get(i).opType(), item.getOpType());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                IndexingPressureService.class,
        assertEquals(
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
                }
    }
        // Enable the setting for shard indexing pressure as true  
                .getShardIndexingPressureTracker(shardId);
    protected int numberOfShards() {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
        // Repeat the previous set of requests; to get an actual rejection again this time  
        assertTrue(shardIndexingPressure.isShardIndexingPressureEnabled());
                .getShardIndexingPressureTracker(shardId);  
            secondSuccessFuture = client(primaryName).bulk(bulkRequest);  
        );  
import java.util.Arrays;  
        // Set the Node limit threshold above the request-size; for no rejection
            assertEquals(  
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);  
        assertEquals(bulkShardRequestSize, primaryNodeLimits.totalPrimaryBytes.get());  
                .getShardIndexingPressure()
        long initialNodeLimit = 1000000;
                }
        String replicaName = primaryReplicaNodeNames.v2();
        // Send first request which gets successful to set the last successful time-stamp  
            )
import java.util.concurrent.CountDownLatch;  
            totalRequestSize += request.ramBytesUsed();
        ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)
            .prepareState()  
            prepareCreate(  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        ShardIndexingPressure shardIndexingPressure = internalCluster().getInstance(IndexingPressureService.class, primaryName)
                .build()
            .values()
            .getShardIndexingPressure()  
        assertEquals(10000, coordinatingShardTracker.getPrimaryAndCoordinatingLimits());  
        assertNoFailures(thirdSuccessFuture.actionGet());  
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
                .getLastSuccessfulRequestLimitsBreachedRejections()
    public static final Settings settings = Settings.builder()
        String coordinatingOnlyNode = getCoordinatingOnlyNode();
            ).getShardIndexingPressure().getShardIndexingPressureTracker(shardId);
        // Shadow mode rejection count breakup still updated
import org.opensearch.action.bulk.TransportShardBulkAction;
        index = indexService.getIndexSettings().getIndex();
        }  
        successFuture.actionGet();  
import org.opensearch.common.UUIDs;  
        int totalRequestSize = 0;
            .filter(sr -> sr.primary() == false)
        // New Increment factor
        final BulkRequest bulkRequest = new BulkRequest();
        String primaryName = nodes.get(primaryId).getName();
            + RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);  
        primaryTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
            ShardIndexingPressureTracker primaryShardTracker = internalCluster().getInstance(IndexingPressureService.class, primaryName)  
            ShardIndexingPressureTracker coordinatingShardTracker = internalCluster().getInstance(
            assertEquals(i, item.getItemId());
        }
            .next()
            successFuture = client(coordinatingOnlyNode).bulk(bulkRequest);
        // Send first request  
        final MockTransportService primaryTransportService = (MockTransportService) primaryService;
            totalRequestSize += request.ramBytesUsed();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        waitForLastSuccessfulRequestTimeout(coordinatingShardTracker);
