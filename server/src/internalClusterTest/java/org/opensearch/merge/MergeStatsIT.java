            );
            assertTrue("Expected warmerStats.getOngoingCount >= 0, found " + stats.getOngoingCount(), stats.getOngoingCount() >= 0);
                stats.getTotalInvocationsCount() >= 1
import java.util.Map;
                }
            }
    public void testNodesStats() throws Exception {
                            put("SENT", mergedSegmentWarmerStats.getTotalSentSize());
        for (String index : indices) {
                // nodes and updated by different callbacks in the warmer flow, so they only
    }
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();
            assertTrue("Primary shard warm invocations should be >= 1", stats.getTotalInvocationsCount() >= 1);
        for (String node : nodes) {
                    StatsScope type = shardStats.getShardRouting().primary() ? StatsScope.PRIMARY_SHARD : StatsScope.REPLICA_SHARD;
            );
            // fully completed on both sides.
            assertEquals("Replica shard total merges should be 0", 0, stats.getTotal());
                    assertNotNull(mergeStats);
            assertEquals("Primary shard warm failures should be == 0", 0, stats.getTotalFailureCount());
                    MergedSegmentWarmerStats priMergedSegmentWarmerStats = priMergeStats.getWarmerStats();
        ClusterState state = getClusterState();
            searchRequest.preference("_replica");
        REPLICA_SHARD,
            assertTrue("Total merges should be >= 1", stats.getTotal() >= 1);
                ShardStats[] allShardStats = response.getShards();
            indexDocs(index);
            }
        AGGREGATED
        }, 30, TimeUnit.SECONDS);
                    allNodesStats.get(0).getIndices().getMerge().getWarmerStats().getTotalSentSize(),
                    assertMergedSegmentWarmerStats(mergedSegmentWarmerStats, StatsScope.AGGREGATED);
        } else if (type == StatsScope.AGGREGATED) {
            for (int i = 0; i < randomIntBetween(25, 30); i++) {
            assertEquals("Replica shard total merge time should be 0", 0, stats.getTotalTime().getMillis());
            assertTrue("Total stopped time should be >= 0", stats.getTotalStoppedTimeInMillis() >= 0);
        } else if (type == StatsScope.REPLICA_SHARD) {
                Map<String, IndexStats> allIndicesStats = response.getIndices();
        if (count <= 0) {
            assertTrue("Total throttled time should be >= 0", stats.getTotalThrottledTime().getMillis() >= 0);
    }
            );
    }
import org.opensearch.index.merge.MergedSegmentWarmerStats;
        return indices;
        internalCluster().startNodes(2);
    }
    }
                    MergedSegmentWarmerStats totalMergedSegmentWarmerStats = totalMergeStats.getWarmerStats();
                    assertNotNull(mergedSegmentWarmerStats);
    public void testIndicesStats() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
        for (String indexName : indexNames) {
                // Primary-sent and replica-received byte counters are maintained on different
        }
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            assertTrue("Total stopped time should be >= 0", stats.getTotalStoppedTime().getMillis() >= 0);
            SearchRequest searchRequest = new SearchRequest(index);
public class MergeStatsIT extends RemoteStoreBaseIntegTestCase {
            assertEquals("Replica shard send time should be 0", 0, stats.getTotalSendTime().millis());
            assertEquals("Replica shard current merge docs should be 0", 0, stats.getCurrentNumDocs());
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered
import org.opensearch.index.merge.MergeStats;
            assertEquals("Replica shard total merge time should be 0", 0, stats.getTotalTimeInMillis());
                for (String index : indices) {
 * Integration tests asserting on MergeStats for remote store enabled domains.
                    "Expected sent size by replica shard to be equal to received size by primary shard.",
    public void testShardStats() throws Exception {
                );
        for (String index : indices) {
                    });
        nodesStatsRequest.indices(CommonStatsFlags.ALL);
            assertEquals("Replica shard total merged size should be 0", 0, stats.getTotalSizeInBytes());
            assertEquals("Replica shard warm invocations should be 0", 0, stats.getTotalInvocationsCount());
    protected Settings nodeSettings(int nodeOrdinal) {
                assertTrue("Docs should be searchable on replicas", totalDocs > 0);
                    String primaryOrReplica = type.equals(StatsScope.PRIMARY_SHARD) ? "[P]" : "[R]";
                assertEquals(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            assertTrue(
import java.util.HashMap;
                    assertNotNull(totalStats);
                    assertNotNull(priMergedSegmentWarmerStats);
        }
                    "Expected sent size by primary shard to be equal to received size by replica shard.",
        if (Arrays.asList(StatsScope.PRIMARY_SHARD, StatsScope.AGGREGATED).contains(type)) {
                "Expected warmerStats.getTotalSentSize >= 1, found " + stats.getTotalSentSize().getBytes(),
        return Settings.builder()
            assertEquals("Replica shard current merges should be 0", 0, stats.getCurrent());
                    refresh(indexName);
                stats.getTotalSentSize().getBytes() >= 1
        }
                int numberOfOperations = randomIntBetween(25, 30);
            // counters are maintained on different nodes and updated by different callbacks
                    CommonStats priStats = indexStats.getPrimaries();
                // Shard stats
                "Expected warmerStats.getTotalReceivedSize >= 1, found " + stats.getTotalReceivedSize().getBytes(),
                stats.getTotalReceiveTime().getMillis() >= 1
                    assertMergeStats(mergeStats, StatsScope.AGGREGATED);
                assertEquals(4, allShardStats.length);
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();
            }
                        {
    @Override
                            put("RECEIVED", mergedSegmentWarmerStats.getTotalReceivedSize());
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();
import java.util.List;
        ClusterState state = getClusterState();
                }
                );
                // reconcile once the async warmer push has fully completed on both sides.
        String[] indices = setupIndices(1);
                "Expected warmerStats.getTotalReceiveTime >= 1, found " + stats.getTotalReceiveTime().getMillis(),
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
                assertEquals(2, allNodesStats.size());
                // Shard stats
/*
                    MergeStats mergeStats = nodeStats.getIndices().getMerge();
                    MergeStats totalMergeStats = totalStats.getMerge();
        String[] indices = new String[count];
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered
                        }
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                    MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats.getWarmerStats();
                assertEquals(
                "Expected warmerStats.getTotalInvocationsCount >= 1, found " + stats.getTotalInvocationsCount(),
        }
import org.opensearch.indices.recovery.RecoverySettings;
            assertEquals("Replica shard total stopped time should be 0", 0, stats.getTotalStoppedTime().getMillis());
        ensureGreen(indices);
                    assertNotNull(priMergeStats);
 * The OpenSearch Contributors require contributions made to
                    allNodesStats.get(1).getIndices().getMerge().getWarmerStats().getTotalReceivedSize()
                IndicesStatsResponse response = client(node).admin().indices().stats(new IndicesStatsRequest()).get();
    private void waitForDocsOnReplicas(String... indices) throws Exception {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        waitForDocsOnReplicas(indices);
            assertTrue("Primary shard ongoing warms should be >= 0", stats.getOngoingCount() >= 0);
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();
import org.opensearch.common.settings.Settings;
        for (String index : indices) {
        // so we still need to poll the aggregated warmer counters below.
            assertTrue("Current merge docs should be >= 0", stats.getCurrentNumDocs() >= 0);
        }
            .build();
    private void assertMergeStats(MergeStats stats, StatsScope type) {
            assertBusy(() -> {
                    allNodesStats.get(0).getIndices().getMerge().getWarmerStats().getTotalReceivedSize(),
            // in the warmer flow, so they only reconcile once the async warmer push has
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest("data:true");
                } else {
            assertTrue("Current merges should be >= 0", stats.getCurrent() >= 0);
        }
 * this file be licensed under the Apache-2.0 license or a
        setup();
            assertEquals("Replica shard total merged size should be 0", 0, stats.getTotalSize().getBytes());
        String[] indices = setupIndices(1);
            .build();
                    assertMergedSegmentWarmerStats(mergedSegmentWarmerStats, type);
    @Override
    private void setup() {
 */
                    assertNotNull(mergeStats);
import org.opensearch.cluster.ClusterState;
                    assertMergedSegmentWarmerStats(totalMergedSegmentWarmerStats, StatsScope.AGGREGATED);
            assertTrue("Replica shard received size should be >= 1", stats.getTotalReceivedSize().getBytes() >= 1);
                    IndexStats indexStats = allIndicesStats.get(index);
        // so we still need to poll the cross-node counters below.
            // Re-collect stats on every attempt; the primary-sent and replica-received byte
        setup();
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][R]").get("RECEIVED"),
 * compatible open source license.
import org.opensearch.action.admin.indices.stats.CommonStats;
                    assertNotNull(mergedSegmentWarmerStats);
            }, 30, TimeUnit.SECONDS);
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
import org.opensearch.action.admin.indices.stats.IndexStats;
            indices[i] = INDEX_NAME + i;
import org.opensearch.action.search.SearchRequest;
        String[] indices = setupIndices(1);
            assertEquals("Primary shard receive time should be 0", 0, stats.getTotalReceiveTime().millis());
                stats.getTotalFailureCount()
import java.util.Arrays;
    }
                );
        for (String index : indices) {
                    assertNotNull(totalMergedSegmentWarmerStats);
        return Settings.builder()
            assertTrue("Total merged docs should be >= 1", stats.getTotalNumDocs() >= 1);
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).toList();
    private enum StatsScope {
            assertTrue("Primary shard send time should be >= 0", stats.getTotalSendTime().millis() >= 0);
            assertEquals("Replica shard total throttled time should be 0", 0, stats.getTotalThrottledTimeInMillis());
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][P]").get("SENT")
            .put(super.indexSettings())
                    shardsSentAndReceivedSize.put(shardStats.getShardRouting().shardId() + primaryOrReplica, new HashMap<>() {
            );
                }
                "Expected warmerStats.getTotalSendTime >= 1, found " + stats.getTotalSendTime().getMillis(),
                assertEquals(1, allIndicesStats.size());
        PRIMARY_SHARD,
                0,
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
 */
    public Settings indexSettings() {
        setup();
                for (ShardStats shardStats : allShardStats) {
                    MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats.getWarmerStats();
            }, 10, TimeUnit.SECONDS);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
/*
}
            );
                    assertNotNull(commonStats);
            assertEquals("Replica shard total merged docs should be 0", 0, stats.getTotalNumDocs());
        }
                    CommonStats commonStats = shardStats.getStats();
                    flush(indexName);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
        ClusterState state = getClusterState();
    }
                stats.getTotalTime().getMillis() >= 1
        for (String index : indices) {
                    assertNotNull(totalMergeStats);
                IndicesStatsResponse response = client(node).admin().indices().stats(new IndicesStatsRequest()).get();
                indexBulk(indexName, numberOfOperations);
        }
                    allNodesStats.get(1).getIndices().getMerge().getWarmerStats().getTotalSentSize()
import org.opensearch.cluster.node.DiscoveryNode;
                for (NodeStats nodeStats : allNodesStats) {
        for (String node : nodes) {
import java.util.concurrent.TimeUnit;
            assertTrue("Replica shard receive time should be >= 1ms", stats.getTotalReceiveTime().millis() >= 1);
            assertEquals("Replica shard current merge size should be 0", 0, stats.getCurrentSizeInBytes());
            client().admin().indices().forceMerge(new ForceMergeRequest(index).maxNumSegments(2)).get();
            assertTrue(
            assertBusy(() -> {
            assertEquals("Replica shard warm time should be 0", 0, stats.getTotalTime().getMillis());
            assertTrue(
        }
            assertTrue("Total merged size should be >= 1 byte", stats.getTotalSize().getBytes() >= 1);
                }
            Map<String, Map<String, ByteSizeValue>> shardsSentAndReceivedSize = new HashMap<>();
            );
        // so we still need to poll the cross-shard counters below.
                    assertNotNull(nodeStats.getIndices());
            assertTrue("Total merge time should be >= 1ms", stats.getTotalTime().getMillis() >= 1);
            assertEquals("Replica shard sent size should be 0", 0, stats.getTotalSentSize().getBytes());
    }
        } else if (type == StatsScope.REPLICA_SHARD) {
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                    "Expected sent size by node 1 to be equal to received size by node 2.",
                    assertMergeStats(totalMergeStats, StatsScope.AGGREGATED);
            assertTrue(
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][R]").get("SENT"),
                    assertMergeStats(mergeStats, type);
                stats.getTotalSendTime().getMillis() >= 1
            );
                "Expected warmerStats.getTotalTime >= 1, found " + stats.getTotalTime().millis(),
    }
        if (type == StatsScope.PRIMARY_SHARD) {
            assertEquals("Replica shard warm failures should be 0", 0, stats.getTotalFailureCount());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    assertNotNull(priStats);
            assertTrue("Total merge time should be >= 1ms", stats.getTotalTimeInMillis() >= 1);
 *
                List<NodeStats> allNodesStats = response.getNodes();
import org.opensearch.cluster.metadata.IndexMetadata;
                );
            assertTrue("Primary shard sent size should be >= 0", stats.getTotalSentSize().getBytes() >= 0);
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")
                    CommonStats totalStats = indexStats.getTotal();
                    MergeStats priMergeStats = priStats.getMerge();
                assertEquals(
    }
                    assertMergedSegmentWarmerStats(priMergedSegmentWarmerStats, StatsScope.PRIMARY_SHARD);
            assertEquals("Replica shard ongoing warms should be 0", 0, stats.getOngoingCount());
                    assertMergeStats(priMergeStats, StatsScope.PRIMARY_SHARD);
        createIndex(indices);
            assertTrue("Current merge size should be >= 0", stats.getCurrentSizeInBytes() >= 0);
            assertEquals("Primary shard received size should be 0", 0, stats.getTotalReceivedSize().getBytes());
 * SPDX-License-Identifier: Apache-2.0
            assertBusy(() -> {
        for (int i = 0; i < count; i++) {
    private static final String INDEX_NAME = "test-idx";
                long totalDocs = client().search(searchRequest).actionGet().getHits().getTotalHits().value();
        // during the merge but its receive-side accounting on the replica completes asynchronously,
        // Wait for the force merge itself to finish. The warmer push to the replica is triggered
            assertEquals(
                if (randomBoolean()) {
            assertTrue(
            assertTrue(
                stats.getTotalReceivedSize().getBytes() >= 1
        // during the merge but its receive-side accounting on the replica completes asynchronously,
                NodesStatsResponse response = client(node).admin().cluster().nodesStats(nodesStatsRequest).get();
        }
    private void indexDocs(String... indexNames) {
            for (int shard = 0; shard <= 1; shard++) {
import org.opensearch.action.admin.indices.stats.ShardStats;
            assertTrue("Total throttled time should be >= 0", stats.getTotalThrottledTimeInMillis() >= 0);
    private void assertMergedSegmentWarmerStats(MergedSegmentWarmerStats stats, StatsScope type) {
package org.opensearch.merge;
            }, 30, TimeUnit.SECONDS);
                    "Expected sent size by node 2 to be equal to received size by node 1.",
            for (String node : nodes) {
    }
            assertTrue("Primary shard warm time should be >= 1ms", stats.getTotalTime().getMillis() >= 1);
            return new String[0];
    private String[] setupIndices(int count) throws Exception {
            assertTrue("Total merged size should be >= 1 byte", stats.getTotalSizeInBytes() >= 1);
            assertEquals("Replica shard total stopped time should be 0", 0, stats.getTotalStoppedTimeInMillis());
                "Expected warmerStats.getTotalFailureCount == 0, found " + stats.getTotalFailureCount(),
        // during the merge but its receive-side accounting on the replica completes asynchronously,
                    MergeStats mergeStats = commonStats.getMerge();
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
                assertEquals(
                    shardsSentAndReceivedSize.get("[" + indices[0] + "][" + shard + "][P]").get("RECEIVED")
        assertBusy(() -> {
        }
            assertEquals("Replica shard total throttled time should be 0", 0, stats.getTotalThrottledTime().getMillis());
