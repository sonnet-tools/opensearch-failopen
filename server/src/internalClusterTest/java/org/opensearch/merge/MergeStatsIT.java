                "Expected warmerStats.getTotalReceiveTime >= 1, found " + stats.getTotalReceiveTime().getMillis(),  
                assertEquals(
            assertEquals("Replica shard warm time should be 0", 0, stats.getTotalTime().getMillis());  
        }  
                    "Expected sent size by primary shard to be equal to received size by replica shard.",
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")
        if (count <= 0) {
            assertTrue("Primary shard ongoing warms should be >= 0", stats.getOngoingCount() >= 0);  
    }
                    assertNotNull(priMergedSegmentWarmerStats);
                }  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
                // reconcile once the async warmer push has fully completed on both sides.
            assertBusy(() -> {  
        }
                // nodes and updated by different callbacks in the warmer flow, so they only  
            SearchRequest searchRequest = new SearchRequest(index);
            assertTrue("Primary shard warm time should be >= 1ms", stats.getTotalTime().getMillis() >= 1);  
            assertEquals("Primary shard warm failures should be == 0", 0, stats.getTotalFailureCount());
            }, 30, TimeUnit.SECONDS);  
                assertEquals(4, allShardStats.length);
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered
                stats.getTotalSentSize().getBytes() >= 1
                );
                    String primaryOrReplica = type.equals(StatsScope.PRIMARY_SHARD) ? "[P]" : "[R]";
package org.opensearch.merge;
        ensureGreen(indices);
            assertBusy(() -> {
            assertTrue("Total merge time should be >= 1ms", stats.getTotalTimeInMillis() >= 1);
            assertTrue("Replica shard received size should be >= 1", stats.getTotalReceivedSize().getBytes() >= 1);  
import org.opensearch.action.admin.indices.stats.IndexStats;
            assertEquals("Replica shard total throttled time should be 0", 0, stats.getTotalThrottledTime().getMillis());
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;  
                // Primary-sent and replica-received byte counters are maintained on different
        // during the merge but its receive-side accounting on the replica completes asynchronously,
        }
                            put("RECEIVED", mergedSegmentWarmerStats.getTotalReceivedSize());
            assertEquals("Replica shard total throttled time should be 0", 0, stats.getTotalThrottledTimeInMillis());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
            .build();
            );
                    assertNotNull(commonStats);  
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest("data:true");
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
            searchRequest.preference("_replica");  
            assertTrue("Primary shard warm invocations should be >= 1", stats.getTotalInvocationsCount() >= 1);
                    assertNotNull(nodeStats.getIndices());
                    assertMergeStats(mergeStats, type);  
                stats.getTotalReceivedSize().getBytes() >= 1  
import org.opensearch.common.settings.Settings;
            );
            assertBusy(() -> {
            }
                    MergedSegmentWarmerStats priMergedSegmentWarmerStats = priMergeStats.getWarmerStats();
                    assertNotNull(totalStats);
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();
            assertTrue("Total merged docs should be >= 1", stats.getTotalNumDocs() >= 1);  
            assertTrue("Current merge size should be >= 0", stats.getCurrentSizeInBytes() >= 0);
                // Shard stats  
        for (String node : nodes) {
            assertEquals("Replica shard total merges should be 0", 0, stats.getTotal());
            }, 30, TimeUnit.SECONDS);  
                    CommonStats commonStats = shardStats.getStats();
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();  
        String[] indices = new String[count];
            assertTrue("Expected warmerStats.getOngoingCount >= 0, found " + stats.getOngoingCount(), stats.getOngoingCount() >= 0);
                );  
            // counters are maintained on different nodes and updated by different callbacks  
            indexDocs(index);  
                    IndexStats indexStats = allIndicesStats.get(index);
                assertEquals(
    public void testNodesStats() throws Exception {
                "Expected warmerStats.getTotalInvocationsCount >= 1, found " + stats.getTotalInvocationsCount(),
            assertEquals("Replica shard warm failures should be 0", 0, stats.getTotalFailureCount());
    }
                int numberOfOperations = randomIntBetween(25, 30);
            assertEquals("Replica shard ongoing warms should be 0", 0, stats.getOngoingCount());  
                    assertNotNull(totalMergeStats);
                    MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats.getWarmerStats();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;  
                    StatsScope type = shardStats.getShardRouting().primary() ? StatsScope.PRIMARY_SHARD : StatsScope.REPLICA_SHARD;
                    "Expected sent size by node 1 to be equal to received size by node 2.",
                            put("SENT", mergedSegmentWarmerStats.getTotalSentSize());  
            assertTrue("Replica shard receive time should be >= 1ms", stats.getTotalReceiveTime().millis() >= 1);
        }
        internalCluster().startNodes(2);
                    assertNotNull(priStats);
            assertTrue(
                IndicesStatsResponse response = client(node).admin().indices().stats(new IndicesStatsRequest()).get();  
 * Integration tests asserting on MergeStats for remote store enabled domains.
                stats.getTotalInvocationsCount() >= 1
            for (int shard = 0; shard <= 1; shard++) {  
        createIndex(indices);  
public class MergeStatsIT extends RemoteStoreBaseIntegTestCase {
        }
            assertTrue("Total merges should be >= 1", stats.getTotal() >= 1);  
        // so we still need to poll the aggregated warmer counters below.  
                ShardStats[] allShardStats = response.getShards();  
                stats.getTotalTime().getMillis() >= 1
                    shardsSentAndReceivedSize.put(shardStats.getShardRouting().shardId() + primaryOrReplica, new HashMap<>() {  
                stats.getTotalFailureCount()  
    public void testShardStats() throws Exception {
        // so we still need to poll the cross-node counters below.
            assertEquals("Replica shard current merges should be 0", 0, stats.getCurrent());
            assertTrue("Current merge docs should be >= 0", stats.getCurrentNumDocs() >= 0);
    private void setup() {  
            assertEquals("Replica shard total stopped time should be 0", 0, stats.getTotalStoppedTime().getMillis());  
            assertTrue(  
                    CommonStats priStats = indexStats.getPrimaries();  
        }
            assertEquals("Replica shard send time should be 0", 0, stats.getTotalSendTime().millis());
                    MergeStats totalMergeStats = totalStats.getMerge();
            assertTrue("Total merged size should be >= 1 byte", stats.getTotalSize().getBytes() >= 1);
                    assertNotNull(priMergeStats);
import org.opensearch.cluster.metadata.IndexMetadata;
                );
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();  
                    MergeStats mergeStats = nodeStats.getIndices().getMerge();  
        // during the merge but its receive-side accounting on the replica completes asynchronously,
            assertEquals("Replica shard total merged size should be 0", 0, stats.getTotalSize().getBytes());
    private void waitForDocsOnReplicas(String... indices) throws Exception {  
                "Expected warmerStats.getTotalTime >= 1, found " + stats.getTotalTime().millis(),
import org.opensearch.index.merge.MergeStats;  
    private void assertMergedSegmentWarmerStats(MergedSegmentWarmerStats stats, StatsScope type) {  
                    allNodesStats.get(0).getIndices().getMerge().getWarmerStats().getTotalSentSize(),  
    public Settings indexSettings() {  
import org.opensearch.test.OpenSearchIntegTestCase;
    }
                List<NodeStats> allNodesStats = response.getNodes();
            assertTrue("Current merges should be >= 0", stats.getCurrent() >= 0);  
        REPLICA_SHARD,
            assertEquals("Replica shard warm invocations should be 0", 0, stats.getTotalInvocationsCount());
                    assertMergedSegmentWarmerStats(totalMergedSegmentWarmerStats, StatsScope.AGGREGATED);
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();
                stats.getTotalSendTime().getMillis() >= 1  
                    assertMergedSegmentWarmerStats(priMergedSegmentWarmerStats, StatsScope.PRIMARY_SHARD);  
            indices[i] = INDEX_NAME + i;
                    MergedSegmentWarmerStats totalMergedSegmentWarmerStats = totalMergeStats.getWarmerStats();  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered
        } else if (type == StatsScope.REPLICA_SHARD) {
                }  
        for (String node : nodes) {
                "Expected warmerStats.getTotalSendTime >= 1, found " + stats.getTotalSendTime().getMillis(),
                    allNodesStats.get(0).getIndices().getMerge().getWarmerStats().getTotalReceivedSize(),
        String[] indices = setupIndices(1);
            assertTrue(  
                }
                assertEquals(1, allIndicesStats.size());
/*  
            );
 *
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][R]").get("RECEIVED"),  
                    assertMergeStats(totalMergeStats, StatsScope.AGGREGATED);
        String[] indices = setupIndices(1);  
        }
        return Settings.builder()
            assertEquals("Primary shard receive time should be 0", 0, stats.getTotalReceiveTime().millis());
            .build();  
                    assertNotNull(totalMergedSegmentWarmerStats);  
                    MergeStats mergeStats = commonStats.getMerge();
                    allNodesStats.get(1).getIndices().getMerge().getWarmerStats().getTotalReceivedSize()
import org.opensearch.indices.recovery.RecoverySettings;
        String[] indices = setupIndices(1);
        }
                assertEquals(
    }
            );  
            assertEquals("Replica shard total merged size should be 0", 0, stats.getTotalSizeInBytes());  
            assertEquals("Primary shard received size should be 0", 0, stats.getTotalReceivedSize().getBytes());  
                }  
        waitForDocsOnReplicas(indices);
            assertEquals("Replica shard total merge time should be 0", 0, stats.getTotalTime().getMillis());
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
                // Shard stats
        // so we still need to poll the cross-shard counters below.
            assertTrue("Total throttled time should be >= 0", stats.getTotalThrottledTimeInMillis() >= 0);  
        for (String index : indices) {
            for (String node : nodes) {
                    assertNotNull(mergedSegmentWarmerStats);
                } else {
    protected Settings nodeSettings(int nodeOrdinal) {  
                NodesStatsResponse response = client(node).admin().cluster().nodesStats(nodesStatsRequest).get();  
                    "Expected sent size by node 2 to be equal to received size by node 1.",  
            // Re-collect stats on every attempt; the primary-sent and replica-received byte
        return Settings.builder()
                assertTrue("Docs should be searchable on replicas", totalDocs > 0);  
            assertEquals("Replica shard sent size should be 0", 0, stats.getTotalSentSize().getBytes());
    }
            );  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
import java.util.HashMap;
import java.util.List;
                "Expected warmerStats.getTotalSentSize >= 1, found " + stats.getTotalSentSize().getBytes(),  
                for (ShardStats shardStats : allShardStats) {  
            assertTrue("Total stopped time should be >= 0", stats.getTotalStoppedTime().getMillis() >= 0);
import java.util.Map;  
        if (Arrays.asList(StatsScope.PRIMARY_SHARD, StatsScope.AGGREGATED).contains(type)) {
                long totalDocs = client().search(searchRequest).actionGet().getHits().getTotalHits().value();
            assertTrue(
            assertTrue("Total stopped time should be >= 0", stats.getTotalStoppedTimeInMillis() >= 0);  
        for (String index : indices) {
 */  
        }  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
            assertEquals("Replica shard total merge time should be 0", 0, stats.getTotalTimeInMillis());  
import org.opensearch.cluster.ClusterState;  
                    assertMergeStats(priMergeStats, StatsScope.PRIMARY_SHARD);  
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][R]").get("SENT"),
                );
        }, 30, TimeUnit.SECONDS);  
            );
 */
import org.opensearch.cluster.node.DiscoveryNode;
    }
    private void assertMergeStats(MergeStats stats, StatsScope type) {
    public void testIndicesStats() throws Exception {  
        nodesStatsRequest.indices(CommonStatsFlags.ALL);  
import org.opensearch.action.admin.indices.stats.CommonStats;
            }, 10, TimeUnit.SECONDS);
                    allNodesStats.get(1).getIndices().getMerge().getWarmerStats().getTotalSentSize()
        }
    @Override
        setup();
        // during the merge but its receive-side accounting on the replica completes asynchronously,  
            .put(super.nodeSettings(nodeOrdinal))
                stats.getTotalReceiveTime().getMillis() >= 1
        } else if (type == StatsScope.AGGREGATED) {
            assertEquals("Replica shard current merge size should be 0", 0, stats.getCurrentSizeInBytes());
    private enum StatsScope {
        setup();
        ClusterState state = getClusterState();
            assertTrue("Total throttled time should be >= 0", stats.getTotalThrottledTime().getMillis() >= 0);
}
    }  
import org.opensearch.action.search.SearchRequest;
                    MergeStats priMergeStats = priStats.getMerge();  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
                indexBulk(indexName, numberOfOperations);
    }  
    }  
            );
                "Expected warmerStats.getTotalReceivedSize >= 1, found " + stats.getTotalReceivedSize().getBytes(),
            }  
        assertBusy(() -> {
 * The OpenSearch Contributors require contributions made to  
    @Override
                    assertNotNull(mergedSegmentWarmerStats);
    }
 * compatible open source license.
                    assertMergeStats(mergeStats, StatsScope.AGGREGATED);
            assertTrue(
            assertTrue("Total merge time should be >= 1ms", stats.getTotalTime().getMillis() >= 1);
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)  
                        }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
    private void indexDocs(String... indexNames) {
                    });
            assertTrue("Primary shard sent size should be >= 0", stats.getTotalSentSize().getBytes() >= 0);
            assertTrue("Primary shard send time should be >= 0", stats.getTotalSendTime().millis() >= 0);
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
                assertEquals(  
        ClusterState state = getClusterState();
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][P]").get("SENT")
        for (String indexName : indexNames) {  
            assertTrue("Total merged size should be >= 1 byte", stats.getTotalSizeInBytes() >= 1);
        for (String index : indices) {
    private static final String INDEX_NAME = "test-idx";  
import java.util.concurrent.TimeUnit;
                0,
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.index.merge.MergedSegmentWarmerStats;
            for (int i = 0; i < randomIntBetween(25, 30); i++) {
        for (String index : indices) {
            assertTrue(
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();
        for (int i = 0; i < count; i++) {  
        AGGREGATED
                    MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats.getWarmerStats();
        setup();
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][P]").get("RECEIVED")  
                    assertMergedSegmentWarmerStats(mergedSegmentWarmerStats, type);  
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
            assertEquals(  
                IndicesStatsResponse response = client(node).admin().indices().stats(new IndicesStatsRequest()).get();
                "Expected warmerStats.getTotalFailureCount == 0, found " + stats.getTotalFailureCount(),
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered  
        for (String index : indices) {  
    }  
                for (NodeStats nodeStats : allNodesStats) {
        return indices;  
            return new String[0];  
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();
                Map<String, IndexStats> allIndicesStats = response.getIndices();
                    refresh(indexName);
        if (type == StatsScope.PRIMARY_SHARD) {
    }
import org.opensearch.core.common.unit.ByteSizeValue;
            Map<String, Map<String, ByteSizeValue>> shardsSentAndReceivedSize = new HashMap<>();  
        ClusterState state = getClusterState();  
            .put(super.indexSettings())
                for (String index : indices) {  
                    assertMergedSegmentWarmerStats(mergedSegmentWarmerStats, StatsScope.AGGREGATED);
            assertEquals("Replica shard current merge docs should be 0", 0, stats.getCurrentNumDocs());  
            // in the warmer flow, so they only reconcile once the async warmer push has
                    flush(indexName);  
                assertEquals(2, allNodesStats.size());  
    private String[] setupIndices(int count) throws Exception {
        } else if (type == StatsScope.REPLICA_SHARD) {
        PRIMARY_SHARD,  
                if (randomBoolean()) {
        }
                    "Expected sent size by replica shard to be equal to received size by primary shard.",
                        {
        }
                    assertNotNull(mergeStats);
            assertEquals("Replica shard total merged docs should be 0", 0, stats.getTotalNumDocs());
                    CommonStats totalStats = indexStats.getTotal();
            }
/*  
            // fully completed on both sides.
            assertEquals("Replica shard total stopped time should be 0", 0, stats.getTotalStoppedTimeInMillis());
                    assertNotNull(mergeStats);
