            while (pauseReplicationLatch.getCount() > 0) {
        }
        }
        for (String node : nodeNames) {
        assertBusyWithFixedSleepTime(() -> {
 *
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                    final List<ShardRouting> replicaRouting = shardRoutingTable.replicaShards();  
import org.opensearch.index.store.StoreFileMetadata;
                    for (ShardRouting replica : replicaRouting) {
    @Override
            return searcher.getDirectoryReader().numDocs();
import java.io.IOException;
            assertEquals(segmentCount, primarySegments.size());  
                        latch.countDown();
     * @param docCount - Expected Doc count.
     */
    protected DiscoveryNode getNodeContainingPrimaryShard() {
    public static void waitForSegmentCount(String indexName, int segmentCount, Logger logger) throws Exception {
    }  
        assertBusy(() -> {  
                    }
import org.opensearch.common.concurrent.GatedCloseable;  
                            primarySegments.add(segment.getName());
import org.opensearch.indices.IndicesService;
                        final int replicaDocCount = getDocCountFromShard(replicaShard);
            mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {  
import org.opensearch.index.engine.Engine;  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.cluster.routing.ShardRouting;  
        }  
                            replicaSegments.add(segment.getName());  
        IndexService indexService = indicesService.indexService(index);  
    /**  
                        if (recoveryDiff.missing.isEmpty() == false || recoveryDiff.different.isEmpty() == false) {  
                        );  
        return Settings.builder()
                    final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
     * Fetch IndexShard, assumes only a single shard per node.
import java.util.Collection;  
import org.opensearch.test.transport.MockTransportService;
    protected void waitForSearchableDocs(long docCount, String... nodes) throws Exception {
        };
/*  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)  
import org.opensearch.common.settings.Settings;
            final ClusterState clusterState = getClusterState();
                        IndexShard replicaShard = getIndexShard(clusterState, replica, indexName);
import org.opensearch.common.Nullable;
import java.util.Optional;  
                            fail(
        waitForSearchableDocs(INDEX_NAME, docCount, nodes);  
import org.opensearch.common.lease.Releasable;
            logger.info("primary segments: {}, replica segments: {}", primarySegments, replicaSegments);
import org.apache.lucene.index.SegmentInfos;
            Set<String> primarySegments = Sets.newHashSet();  
import org.opensearch.plugins.Plugin;
        return () -> {
                }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
import org.opensearch.cluster.routing.IndexRoutingTable;
     * @param nodes    - List of node names.
    protected void assertReplicaCheckpointUpdated(IndexShard primaryShard) throws Exception {
import org.opensearch.index.engine.Segment;
                                    + replicaShard.getLatestReplicationCheckpoint()  
        final ClusterState state = getClusterState();  
    protected boolean segmentReplicationWithRemoteEnabled() {  
        for (IndexShardRoutingTable shardRoutingTable : state.routingTable().index(INDEX_NAME)) {
    protected static final int SHARD_COUNT = 1;  
    }  
                        pauseReplicationLatch.await();
                                    + " Replica Replication Checkpoint: "
                    final Map<String, StoreFileMetadata> primarySegmentMetadata = primaryShard.getSegmentMetadataMap();  
                    fail("Expected search hits on node: " + node + " to be at least " + docCount + " but was: " + hits);
            }
                    actionToWaitFor = SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT;  
                if (action.equals(actionToWaitFor)) {
        // wait until the replica has the latest segment generation.
                            replicaShard.getSegmentMetadataMap()
                final String nodeId = shardRouting.currentNodeId();  
                    } catch (InterruptedException e) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            for (String node : nodes) {  
                node
                pauseReplicationLatch.countDown();  
                        replicaShard.store().readLastCommittedSegmentsInfo();
        final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> tuple = shard.getLatestSegmentInfosAndCheckpoint();
            .put(super.indexSettings())
        return asList(MockTransportService.TestPlugin.class);
 * compatible open source license.
                    final IndexShard primaryShard = getIndexShard(clusterState, primaryRouting, indexName);
    }
                }  
            assertEquals(segmentCount, replicaSegments.size());
            assertEquals(primaryShard.indexSettings().getNumberOfReplicas(), groupStats.size());
    protected Releasable blockReplication(List<String> nodes, CountDownLatch latch) {
public class SegmentReplicationBaseIT extends OpenSearchIntegTestCase {  
    }
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
    protected static final int REPLICA_COUNT = 1;
            final IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();
        return null;
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
            }  
import java.util.Map;
import java.util.concurrent.CountDownLatch;
                    try {  
    }  
                }
            return closeable.get();  
                final long hits = response.getHits().getTotalHits().value();
import org.opensearch.core.index.Index;
    public Settings indexSettings() {  
    }
        try (final GatedCloseable<SegmentInfos> closeable = tuple.v1()) {
    }
        assertBusy(() -> {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            for (IndexShardSegments indexShardSegments : response.getIndices().get(indexName).getShards().values()) {  
            Set<String> replicaSegments = Sets.newHashSet();
import org.opensearch.indices.replication.common.ReplicationType;
        final Index index = resolveIndex(indexName);
    protected void waitForSearchableDocs(long docCount, List<String> nodes) throws Exception {
import org.opensearch.common.util.set.Sets;
            Set<SegmentReplicationShardStats> groupStats = primaryShard.getReplicationStatsForTrackedReplicas();
        assertNotNull(indexService);
        }, 30, TimeUnit.SECONDS);  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
                    final int primaryDocCount = getDocCountFromShard(primaryShard);
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
                TransportService.class,  
                        final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(  
        assertBusy(() -> {
                    }
}
                            primarySegmentMetadata,
                for (ShardSegments shardSegment : indexShardSegments.getShards()) {
import org.opensearch.index.store.Store;  
        return state.nodes().resolveNode(primaryShard.currentNodeId());
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.indices.replication;
            }
    protected void verifyStoreContent() throws Exception {
    protected ShardRouting getShardRoutingForNodeName(String nodeName) {
                if (segmentReplicationWithRemoteEnabled()) {
                        throw new RuntimeException(e);
                                    + " Primary Replication Checkpoint : "  
import org.opensearch.action.admin.indices.segments.IndexShardSegments;  
                    final String indexName = primaryRouting.getIndexName();
import static java.util.Arrays.asList;  
                        }
     */
     *  
        }, 1, TimeUnit.MINUTES);
import org.opensearch.cluster.ClusterState;
        }, TimeValue.timeValueMinutes(2), TimeValue.timeValueSeconds(2));
    protected static final String INDEX_NAME = "test-idx-1";
    private int getDocCountFromShard(IndexShard shard) {
    }
            ));
            }
            .build();
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
                if (discoveryNode.getName().equals(nodeName)) {
                String actionToWaitFor = SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES;
     * Returns the latest SIS for a shard but does not incref the segments.
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();
        final ClusterState state = getClusterState();
                for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {  
                    return shardRouting;  
import org.apache.logging.log4j.Logger;
        // wait until the replica has the latest segment generation.
                                    + " Different: "
                        if (shardSegment.getShardRouting().primary()) {  
        return getIndexShard(state.nodes().get(routing.currentNodeId()).getName(), routing.shardId(), indexName);  
    /**  
import org.opensearch.action.admin.indices.segments.ShardSegments;
    }  
            MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
        }
                                "Expected no missing or different segments between primary and replica but diff was missing: "
import org.opensearch.cluster.metadata.IndexMetadata;
                                    + recoveryDiff.missing  
        }, 1, TimeUnit.MINUTES);
        try (final Engine.Searcher searcher = shard.acquireSearcher("test")) {  
                connection.sendRequest(requestId, action, request, options);
    public static void waitForSearchableDocs(String indexName, long docCount, List<String> nodes) throws Exception {  
                assertEquals(0, shardStat.getCheckpointsBehindCount());
    }  
                        // calls to readCommit will fail if a valid commit point and all its segments are not in the store.  
    protected void assertDocCounts(int expectedDocCount, String... nodeNames) {
                }
import org.opensearch.index.SegmentReplicationShardStats;
 */  
        final ShardRouting primaryShard = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();  
                final DiscoveryNode discoveryNode = state.nodes().resolveNode(nodeId);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
            for (ShardRouting shardRouting : shardRoutingTable.activeShards()) {
                }  
                        }
            }
        return shardId.map(indexService::getShard).orElse(null);  
                }
import org.opensearch.common.collect.Tuple;
import org.opensearch.action.search.SearchResponse;  
     */  
    }
    @Override  
            });
import java.util.Set;
    protected IndexShard getIndexShard(String node, String indexName) {  
                        assertEquals("Doc counts should match", primaryDocCount, replicaDocCount);
                    for (Segment segment : shardSegment.getSegments()) {
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings()).booleanValue();
        CountDownLatch pauseReplicationLatch = new CountDownLatch(nodes.size());
    }
                    }
     * Waits until all given nodes have at least the expected docCount.
            for (SegmentReplicationShardStats shardStat : groupStats) {  
                                    + primaryShard.getLatestReplicationCheckpoint()
            assertHitCount(client(node).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedDocCount);  
                                    + recoveryDiff.different
            for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            }
    }  
    }
                            );
import java.util.concurrent.TimeUnit;  
                        } else {
import java.util.List;
        for (String node : nodes) {  
        waitForSearchableDocs(docCount, Arrays.stream(nodes).collect(Collectors.toList()));
import org.opensearch.index.IndexModule;  
                if (hits < docCount) {  
import java.util.stream.Collectors;
        }  
import org.opensearch.index.IndexService;
import org.opensearch.index.shard.IndexShard;
    private IndexShard getIndexShard(ClusterState state, ShardRouting routing, String indexName) {
    @Nullable
    protected SegmentInfos getLatestSegmentInfos(IndexShard shard) throws IOException {  
                final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
    }
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.transport.TransportService;
