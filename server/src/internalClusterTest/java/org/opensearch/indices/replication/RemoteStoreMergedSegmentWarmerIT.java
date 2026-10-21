import java.nio.file.Path;
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {
                .get();
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());
        };
                .setSource("foo" + i, "bar" + i)
            connection.sendRequest(requestId, action, request, options);
                assertTrue(
        );
            .build();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
    }
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
                numInvocations.incrementAndGet();
        createIndex(
                );
        assertTrue(latch.await(10, TimeUnit.SECONDS));
    }
    }
        for (int i = 0; i < 30; i++) {
package org.opensearch.indices.replication;
import java.util.Set;
    @Override
        internalCluster().startDataOnlyNode();
        }
        createIndex(INDEX_NAME);
            client().prepareIndex(INDEX_NAME)
import org.opensearch.test.transport.MockTransportService;
        if (absolutePath == null) {
            Settings.builder()
                .setId(String.valueOf(i))
                .setSource("foo" + i, "bar" + i)
            .put(super.nodeSettings(nodeOrdinal))
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
    @Before
        final String node1 = internalCluster().startDataOnlyNode();
                Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), false).build()
    public void testMergeSegmentWarmerWithInactiveReplicaRemote() throws Exception {
        };
        ensureGreen(INDEX_NAME);
            absolutePath = randomRepoPath().toAbsolutePath();
        String primaryShardNode = findprimaryShardNode(INDEX_NAME);
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(
     */
            .admin()
                        .getRequest() instanceof RemoteStorePublishMergedSegmentRequest
    }
            client().prepareIndex(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();
        logger.info("Number of merge invocations: {}", numInvocations.get());
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        );
            TransportService.class,
        Set<String> executingThreads = ConcurrentHashMap.newKeySet();
        for (int i = 0; i < 30; i++) {
import org.opensearch.transport.TransportService;
                        .getRequest() instanceof RemoteStorePublishMergedSegmentRequest
    private String findprimaryShardNode(String indexName) {
import org.opensearch.indices.replication.checkpoint.RemoteStorePublishMergedSegmentRequest;
                .get();
        String nodeId = internalCluster().clusterService().state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
        CountDownLatch warmingLatch = new CountDownLatch(1);
        assertTrue(executingThreads.size() > 1);
        final CountDownLatch latch = new CountDownLatch(1);
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
import org.junit.Before;
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")
        // Verify concurrent execution by checking that multiple unique threads handled merge operations
                warmingLatch.countDown(); // This should NOT happen
        }
 * SPDX-License-Identifier: Apache-2.0
                latch.countDown();
        CountDownLatch latch = new CountDownLatch(2);
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
        }
        );
                .setId(String.valueOf(i))
 *
                    ((TransportReplicationAction.ConcreteReplicaRequest) request)
 * compatible open source license.
        assertTrue(numInvocations.get() > 1);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.index.IndexSettings;
            .prepareUpdateSettings()
    private Path absolutePath;
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)
            .get();
        ensureGreen(INDEX_NAME);
            connection.sendRequest(requestId, action, request, options);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
            primaryShardNode
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(
        internalCluster().client()
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
        String node2 = internalCluster().startDataOnlyNode();
        final String node2 = internalCluster().startDataOnlyNode();
            .setPersistentSettings(
    /**
                executingThreads.add(Thread.currentThread().getName());
        String primaryNodeName = findprimaryShardNode(INDEX_NAME);
import org.opensearch.action.support.replication.TransportReplicationAction;
public class RemoteStoreMergedSegmentWarmerIT extends SegmentReplicationBaseIT {
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {
                .setId(String.valueOf(i))
        };
            client().prepareIndex(INDEX_NAME)
            }
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
                .build()
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(
        }
/*
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {
        return internalCluster().clusterService().state().nodes().get(nodeId).getName();
        return Settings.builder()
            primaryShardNode
import java.util.concurrent.TimeUnit;
    }
        createIndex(INDEX_NAME);
import org.opensearch.common.settings.Settings;
            .put(remoteStoreClusterSettings("test-remote-store-repo", absolutePath))
        internalCluster().startDataOnlyNode();
        mockTransportServicePrimary.clearAllRules();
        mockTransportServicePrimary.clearAllRules();
        String primaryShardNode = findprimaryShardNode(INDEX_NAME);
        String node1 = internalCluster().startDataOnlyNode();
                .put(indexSettings())
                    ((TransportReplicationAction.ConcreteReplicaRequest) request)
                .setId(String.valueOf(i))
}
        }
                .get();
    public void testConcurrentMergeSegmentWarmerRemote() throws Exception {
        ensureGreen(INDEX_NAME);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.transport.StubbableTransport;
            client().prepareIndex(INDEX_NAME)
                .get();
                .setSource("foo" + i, "bar" + i)
        mockTransportServicePrimary.addSendBehavior(behavior);
                assertTrue(
        waitForSegmentCount(INDEX_NAME, 2, logger);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .cluster()
        assertFalse("Warming should be skipped when disabled", warmingLatch.await(5, TimeUnit.SECONDS));
                latch.countDown();
 */
        createIndex(INDEX_NAME);
            }
            TransportService.class,
        mockTransportServicePrimary.addSendBehavior(behavior);
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();
        assertTrue(latch.await(10, TimeUnit.SECONDS));
import org.opensearch.index.TieredMergePolicyProvider;
    public void testMergeSegmentWarmerRemote() throws Exception {
            INDEX_NAME,
     * Returns the node name for the node hosting the primary shard for index "indexName"
    public void setup() {
                .setSource("foo" + i, "bar" + i)
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());
        );
        AtomicLong numInvocations = new AtomicLong(0);
 * this file be licensed under the Apache-2.0 license or a
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        mockTransportServicePrimary.clearAllRules();
    public void testMergeSegmentWarmerWithWarmingDisabled() throws Exception {
        for (int i = 0; i < 30; i++) {
    }
            }
        mockTransportServicePrimary.addSendBehavior(behavior);
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
            TransportService.class,
        for (int i = 0; i < 30; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;
            connection.sendRequest(requestId, action, request, options);
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();
        internalCluster().startDataOnlyNode();
        waitForSearchableDocs(30, node1, node2);
    }
            )
        waitForSegmentCount(INDEX_NAME, 2, logger);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.indices.recovery.RecoverySettings;
            primaryNodeName
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.action.support.WriteRequest;
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
                );
