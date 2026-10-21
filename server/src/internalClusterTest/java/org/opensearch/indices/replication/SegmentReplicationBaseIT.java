import org.opensearch.cluster.node.DiscoveryNode;
            for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
import org.opensearch.common.unit.TimeValue;
        }, TimeValue.timeValueMinutes(2), TimeValue.timeValueSeconds(2));
        CountDownLatch pauseReplicationLatch = new CountDownLatch(nodes.size());
        }
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    protected void verifyStoreContent() throws Exception {
                        final int replicaDocCount = getDocCountFromShard(replicaShard);
        }
                                    + primaryShard.getLatestReplicationCheckpoint()
            Set<SegmentReplicationShardStats> groupStats = primaryShard.getReplicationStatsForTrackedReplicas();
import org.opensearch.cluster.routing.IndexRoutingTable;
/*
            });
            }
        try (final Engine.Searcher searcher = shard.acquireSearcher("test")) {
import org.opensearch.cluster.routing.ShardRouting;
import java.util.Optional;
            return closeable.get();
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
    }
        assertBusy(() -> {
import org.opensearch.common.Nullable;
                    final IndexShard primaryShard = getIndexShard(clusterState, primaryRouting, indexName);
import org.opensearch.index.engine.Engine;
            Set<String> primarySegments = Sets.newHashSet();
            Set<String> replicaSegments = Sets.newHashSet();
    protected static final int SHARD_COUNT = 1;
                for (ShardSegments shardSegment : indexShardSegments.getShards()) {
import java.util.Arrays;
                TransportService.class,
    }
public class SegmentReplicationBaseIT extends OpenSearchIntegTestCase {
        IndexService indexService = indicesService.indexService(index);
                            primarySegmentMetadata,
    protected void waitForSearchableDocs(long docCount, String... nodes) throws Exception {
    }
    protected void assertDocCounts(int expectedDocCount, String... nodeNames) {
            return searcher.getDirectoryReader().numDocs();
                node
                        if (recoveryDiff.missing.isEmpty() == false || recoveryDiff.different.isEmpty() == false) {
                connection.sendRequest(requestId, action, request, options);
 *
                }
        }, 1, TimeUnit.MINUTES);
                        );
    protected IndexShard getIndexShard(String node, String indexName) {
            assertEquals(segmentCount, replicaSegments.size());
        // wait until the replica has the latest segment generation.
                        pauseReplicationLatch.await();
import org.opensearch.indices.replication.common.ReplicationType;
                        if (shardSegment.getShardRouting().primary()) {
                            fail(
                }
            final IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();
                    try {
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings()).booleanValue();
     *
    private IndexShard getIndexShard(ClusterState state, ShardRouting routing, String indexName) {
    /**
            }
                        }
import org.opensearch.transport.TransportService;
    private int getDocCountFromShard(IndexShard shard) {
    protected static final int REPLICA_COUNT = 1;
        return null;
import org.opensearch.index.IndexModule;
import org.opensearch.common.util.set.Sets;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> tuple = shard.getLatestSegmentInfosAndCheckpoint();
    public static void waitForSearchableDocs(String indexName, long docCount, List<String> nodes) throws Exception {
        return () -> {
    public static void waitForSegmentCount(String indexName, int segmentCount, Logger logger) throws Exception {
                                    + recoveryDiff.different
        return state.nodes().resolveNode(primaryShard.currentNodeId());
        // wait until the replica has the latest segment generation.
            ));
                String actionToWaitFor = SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES;
import java.util.Collection;
import org.opensearch.core.index.Index;
                        final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(
import java.io.IOException;
import org.opensearch.plugins.Plugin;
import org.opensearch.index.IndexService;
                    final Map<String, StoreFileMetadata> primarySegmentMetadata = primaryShard.getSegmentMetadataMap();
     * Returns the latest SIS for a shard but does not incref the segments.
        }
                        replicaShard.store().readLastCommittedSegmentsInfo();
                if (action.equals(actionToWaitFor)) {
    @Nullable
import org.opensearch.test.OpenSearchIntegTestCase;
            }
package org.opensearch.indices.replication;
                final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
                    }
    protected static final String INDEX_NAME = "test-idx-1";
import java.util.concurrent.CountDownLatch;
 */
    }
                if (discoveryNode.getName().equals(nodeName)) {
                                    + recoveryDiff.missing
                    final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
        assertBusyWithFixedSleepTime(() -> {
                                "Expected no missing or different segments between primary and replica but diff was missing: "
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                    }
            assertEquals(segmentCount, primarySegments.size());
import org.opensearch.index.store.Store;
     * @param docCount - Expected Doc count.
            .put(super.indexSettings())
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                    actionToWaitFor = SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT;
     * Waits until all given nodes have at least the expected docCount.
                    final int primaryDocCount = getDocCountFromShard(primaryShard);
                            );
                        IndexShard replicaShard = getIndexShard(clusterState, replica, indexName);
                        throw new RuntimeException(e);
                        // calls to readCommit will fail if a valid commit point and all its segments are not in the store.
        final Index index = resolveIndex(indexName);
    protected ShardRouting getShardRoutingForNodeName(String nodeName) {
                }
        };
     * Fetch IndexShard, assumes only a single shard per node.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
     * @param nodes    - List of node names.
                    return shardRouting;
    }
    }
            logger.info("primary segments: {}, replica segments: {}", primarySegments, replicaSegments);
                }
    }
                                    + " Primary Replication Checkpoint : "
import org.apache.logging.log4j.Logger;
import org.opensearch.index.store.StoreFileMetadata;
    protected void assertReplicaCheckpointUpdated(IndexShard primaryShard) throws Exception {
                        assertEquals("Doc counts should match", primaryDocCount, replicaDocCount);
        }
    protected boolean segmentReplicationWithRemoteEnabled() {
            for (String node : nodes) {
}
                pauseReplicationLatch.countDown();
        return getIndexShard(state.nodes().get(routing.currentNodeId()).getName(), routing.shardId(), indexName);
    }
                    final List<ShardRouting> replicaRouting = shardRoutingTable.replicaShards();
            assertHitCount(client(node).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedDocCount);
            }
        try (final GatedCloseable<SegmentInfos> closeable = tuple.v1()) {
import org.apache.lucene.index.SegmentInfos;
            for (IndexShardSegments indexShardSegments : response.getIndices().get(indexName).getShards().values()) {
                if (hits < docCount) {
        final ClusterState state = getClusterState();
                                    + replicaShard.getLatestReplicationCheckpoint()
                                    + " Different: "
    }
                            primarySegments.add(segment.getName());
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        }
        for (String node : nodes) {
            final ClusterState clusterState = getClusterState();
                        } else {
        }
            }
import java.util.concurrent.TimeUnit;
            mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
import org.opensearch.index.shard.IndexShard;
    }
                if (segmentReplicationWithRemoteEnabled()) {
        for (IndexShardRoutingTable shardRoutingTable : state.routingTable().index(INDEX_NAME)) {
     */
    /**
 * The OpenSearch Contributors require contributions made to
        return Settings.builder()
import org.opensearch.index.engine.Segment;
            MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        assertBusy(() -> {
import java.util.stream.Collectors;
        waitForSearchableDocs(INDEX_NAME, docCount, nodes);
    protected SegmentInfos getLatestSegmentInfos(IndexShard shard) throws IOException {
import org.opensearch.common.settings.Settings;
                            replicaSegments.add(segment.getName());
        waitForSearchableDocs(docCount, Arrays.stream(nodes).collect(Collectors.toList()));
import org.opensearch.index.SegmentReplicationShardStats;
                    for (Segment segment : shardSegment.getSegments()) {
                final String nodeId = shardRouting.currentNodeId();
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();
                assertEquals(0, shardStat.getCheckpointsBehindCount());
    @Override
                for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
    }
                        latch.countDown();
     */
    }
                    }
        for (String node : nodeNames) {
                    final String indexName = primaryRouting.getIndexName();
import org.opensearch.action.search.SearchResponse;
            for (ShardRouting shardRouting : shardRoutingTable.activeShards()) {
import org.opensearch.cluster.ClusterState;
    /**
                    for (ShardRouting replica : replicaRouting) {
    protected void waitForSearchableDocs(long docCount, List<String> nodes) throws Exception {
import org.opensearch.common.lease.Releasable;
            }
                            replicaShard.getSegmentMetadataMap()
 * compatible open source license.
            while (pauseReplicationLatch.getCount() > 0) {
    }
    protected DiscoveryNode getNodeContainingPrimaryShard() {
        final ShardRouting primaryShard = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        assertNotNull(indexService);
    public Settings indexSettings() {
        final ClusterState state = getClusterState();
                final DiscoveryNode discoveryNode = state.nodes().resolveNode(nodeId);
            .build();
import org.opensearch.common.concurrent.GatedCloseable;
                }
import java.util.Map;
import java.util.List;
import org.opensearch.action.admin.indices.segments.ShardSegments;
import org.opensearch.indices.IndicesService;
import org.opensearch.common.collect.Tuple;
    }
    }
    }
            assertEquals(primaryShard.indexSettings().getNumberOfReplicas(), groupStats.size());
import org.opensearch.test.transport.MockTransportService;
        }, 1, TimeUnit.MINUTES);
import static java.util.Arrays.asList;
        }, 30, TimeUnit.SECONDS);
     */
import java.util.Set;
    @Override
    protected Releasable blockReplication(List<String> nodes, CountDownLatch latch) {
        return shardId.map(indexService::getShard).orElse(null);
                    fail("Expected search hits on node: " + node + " to be at least " + docCount + " but was: " + hits);
            for (SegmentReplicationShardStats shardStat : groupStats) {
                final long hits = response.getHits().getTotalHits().value();
 * SPDX-License-Identifier: Apache-2.0
                }
                    } catch (InterruptedException e) {
    }
        return asList(MockTransportService.TestPlugin.class);
                                    + " Replica Replication Checkpoint: "
        assertBusy(() -> {
