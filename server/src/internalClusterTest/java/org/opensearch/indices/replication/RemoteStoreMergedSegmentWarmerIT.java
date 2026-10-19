        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
            .put(remoteStoreClusterSettings("test-remote-store-repo", absolutePath))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        createIndex(INDEX_NAME);
        internalCluster().startDataOnlyNode();
        String nodeId = internalCluster().clusterService().state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
    public void setup() {
                .setSource("foo" + i, "bar" + i)
        mockTransportServicePrimary.clearAllRules();
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {
                .setSource("foo" + i, "bar" + i)  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 */  
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
            client().prepareIndex(INDEX_NAME)
        );
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                latch.countDown();
            )  
import org.opensearch.transport.TransportService;
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
        mockTransportServicePrimary.addSendBehavior(behavior);
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
            TransportService.class,
import org.opensearch.indices.recovery.RecoverySettings;
        for (int i = 0; i < 30; i++) {
            connection.sendRequest(requestId, action, request, options);
import org.opensearch.test.transport.MockTransportService;
        final String node1 = internalCluster().startDataOnlyNode();
    }  
public class RemoteStoreMergedSegmentWarmerIT extends SegmentReplicationBaseIT {  
     */
        internalCluster().startDataOnlyNode();  
        createIndex(INDEX_NAME);
            client().prepareIndex(INDEX_NAME)
        logger.info("Number of merge invocations: {}", numInvocations.get());  
        String primaryNodeName = findprimaryShardNode(INDEX_NAME);
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());
                .setId(String.valueOf(i))  
        for (int i = 0; i < 30; i++) {
import java.util.concurrent.CountDownLatch;
            Settings.builder()
 *
import org.junit.Before;
            primaryNodeName
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.TimeUnit;
        }
        if (absolutePath == null) {
        ensureGreen(INDEX_NAME);
        mockTransportServicePrimary.clearAllRules();  
 * compatible open source license.
        waitForSearchableDocs(30, node1, node2);  
    public void testMergeSegmentWarmerRemote() throws Exception {  
import org.opensearch.indices.replication.checkpoint.RemoteStorePublishMergedSegmentRequest;  
            TransportService.class,
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {  
}  
    }  
        };  
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(
                .put(indexSettings())
        }
    }
            }
    }
                .setId(String.valueOf(i))  
        String primaryShardNode = findprimaryShardNode(INDEX_NAME);
                .setSource("foo" + i, "bar" + i)
        createIndex(INDEX_NAME);  
 * this file be licensed under the Apache-2.0 license or a
        waitForSegmentCount(INDEX_NAME, 2, logger);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();  
        }
import org.opensearch.test.OpenSearchIntegTestCase;
                .setId(String.valueOf(i))
                Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), false).build()
    private Path absolutePath;
                warmingLatch.countDown(); // This should NOT happen
            connection.sendRequest(requestId, action, request, options);
import java.util.concurrent.atomic.AtomicLong;  
                .get();  
        StubbableTransport.SendRequestBehavior behavior = (connection, requestId, action, request, options) -> {  
        internalCluster().client()  
        for (int i = 0; i < 30; i++) {  
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());
     * Returns the node name for the node hosting the primary shard for index "indexName"
        );  
            .build();
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        CountDownLatch latch = new CountDownLatch(2);
        createIndex(
        mockTransportServicePrimary.addSendBehavior(behavior);
import org.opensearch.action.support.WriteRequest;  
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
        return Settings.builder()
    }
                latch.countDown();  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    }  
import org.opensearch.index.IndexSettings;  
                );  
                        .getRequest() instanceof RemoteStorePublishMergedSegmentRequest
                .get();  
        };  
        }
    }
import java.util.concurrent.ConcurrentHashMap;  
        String node2 = internalCluster().startDataOnlyNode();
            .prepareUpdateSettings()  
    @Before
    protected Settings nodeSettings(int nodeOrdinal) {
                executingThreads.add(Thread.currentThread().getName());  
    @Override  
        String primaryShardNode = findprimaryShardNode(INDEX_NAME);  
        assertTrue(executingThreads.size() > 1);
            connection.sendRequest(requestId, action, request, options);
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)  
/*  
    public void testMergeSegmentWarmerWithInactiveReplicaRemote() throws Exception {
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();
            .put(super.nodeSettings(nodeOrdinal))  
        CountDownLatch warmingLatch = new CountDownLatch(1);
        assertTrue(numInvocations.get() > 1);
import org.opensearch.test.transport.StubbableTransport;  
            primaryShardNode
        Set<String> executingThreads = ConcurrentHashMap.newKeySet();  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                );
                assertTrue(  
package org.opensearch.indices.replication;
                numInvocations.incrementAndGet();
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")  
        assertFalse("Warming should be skipped when disabled", warmingLatch.await(5, TimeUnit.SECONDS));
        AtomicLong numInvocations = new AtomicLong(0);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
                        .getRequest() instanceof RemoteStorePublishMergedSegmentRequest
        );
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
 * SPDX-License-Identifier: Apache-2.0
            INDEX_NAME,  
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));  
                .setId(String.valueOf(i))  
    public void testMergeSegmentWarmerWithWarmingDisabled() throws Exception {
    /**  
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
            .admin()
        return internalCluster().clusterService().state().nodes().get(nodeId).getName();  
        assertTrue(latch.await(10, TimeUnit.SECONDS));
    private String findprimaryShardNode(String indexName) {  
        waitForSegmentCount(INDEX_NAME, 2, logger);  
        internalCluster().startClusterManagerOnlyNode();  
        mockTransportServicePrimary.clearAllRules();
                .setSource("foo" + i, "bar" + i)
            .cluster()
                .get();
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(
import java.util.Set;
            primaryShardNode  
                .build()  
        );
        internalCluster().startDataOnlyNode();  
            absolutePath = randomRepoPath().toAbsolutePath();  
        String node1 = internalCluster().startDataOnlyNode();  
        };
                    ((TransportReplicationAction.ConcreteReplicaRequest) request)
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
                assertTrue(
        // Verify concurrent execution by checking that multiple unique threads handled merge operations  
            TransportService.class,  
            client().prepareIndex(INDEX_NAME)
            }  
        MockTransportService mockTransportServicePrimary = (MockTransportService) internalCluster().getInstance(  
        final String node2 = internalCluster().startDataOnlyNode();
        }  
    public void testConcurrentMergeSegmentWarmerRemote() throws Exception {
import org.opensearch.action.support.replication.TransportReplicationAction;
                .get();  
            if (action.equals("indices:admin/remote_publish_merged_segment[r]")) {
            .get();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
            }
            client().prepareIndex(INDEX_NAME)
                    ((TransportReplicationAction.ConcreteReplicaRequest) request)  
            .setPersistentSettings(
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();  
        mockTransportServicePrimary.addSendBehavior(behavior);
import org.opensearch.index.TieredMergePolicyProvider;
        for (int i = 0; i < 30; i++) {
        final CountDownLatch latch = new CountDownLatch(1);
